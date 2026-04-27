package com.claro.sp.automation.util;

import com.claro.sp.automation.controller.CellularController;
import com.claro.sp.automation.manager.ManagerUY;
import com.jcraft.jsch.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Utils {
    private static final Logger LOG = LoggerFactory.getLogger(CellularController.class);
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        return new Date(cal.getTimeInMillis());
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return new Date(cal.getTimeInMillis());
    }

    public static Date addDaysCurrentDate(int days) {
        Date currentDate = getCurrentDate();
        return addDays(currentDate, days);
    }

    public static Date getDateFromString(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date date = sdf.parse(dateString);
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Error parsing date string: " + dateString, e);
        }
    }

    public static double diffDatesMin(java.util.Date minorDate, java.util.Date majorDate) {
        if (minorDate == null || majorDate == null) {
            return 0;
        }

        double diferenciaEn_ms = (double) (majorDate.getTime() - minorDate.getTime());
        double minutos = diferenciaEn_ms / (1000 * 60);
        return minutos;
    }

    public static void writeFileLines(List<String> lines, String fileName) throws Exception {
        String line;
        FileWriter f1 = new FileWriter(fileName, true);
        PrintWriter dataFile = new PrintWriter(f1);
        for (int x = 0; x < lines.size(); x++) {
            line = lines.get(x);
            if (x == lines.size() - 1) {
                dataFile.print(line);
            } else {
                dataFile.println(line);
            }
        }
        dataFile.close();
    }

    private static Session getRemoteSession(String user, String password, String host) throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setPassword(password);
        return session;
    }

    public static void sendFile(String user, String password, String host, String fileName, String remotePath) throws Exception {
        Session session = null;
        ChannelSftp sftpChannel = null;
        try {
            session = getRemoteSession(user, password, host);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftpChannel = (ChannelSftp) channel;

            sftpChannel.put(fileName, remotePath + fileName);

        } finally {
            if (sftpChannel != null && sftpChannel.isConnected()) {
                sftpChannel.disconnect();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }

    public static int executeFile(String user, String password, String host, String command, int sleep) {

        Channel channel = null;
        Session session = null;
        try {

            session = getRemoteSession(user, password, host);
            session.connect();

            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand("bash --login -c '" + command + "'");
            ((ChannelExec) channel).setPty(true);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    break;
                }
                try {
                    Thread.sleep(sleep);
                } catch (Exception ee) {
                }
            }
        } catch (Exception e) {
            LOG.error("Error al ejecutar el archivo: {}", command, e);
        } finally {
            channel.disconnect();
            session.disconnect();
        }
        return channel.getExitStatus();
    }

    public static void getFile(String user, String password, String host, String fileName, String remotePath) throws Exception {
        Session session = null;
        ChannelSftp sftpChannel = null;
        try {
            session = getRemoteSession(user, password, host);
            session.connect();

            sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            sftpChannel.get(remotePath + "/" + fileName, fileName);
        } finally {
            sftpChannel.disconnect();
            session.disconnect();
        }
    }

    public static List<List<String>> readFileLineByLine(String fileName, String delimiter) throws IOException {
        List<List<String>> lista = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                List<String> aux = new ArrayList<>();
                String[] data = line.split(delimiter);
                for (int x = 0; x < data.length; x++) {
                    aux.add(data[x]);
                }
                lista.add(aux);
            }

        } catch (IOException e) {
            LOG.error("Error al leer el archivo: {}", fileName, e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lista;
    }

    public static boolean isServiceUp(String healthUrl) {
        HttpResponse response = null;
        boolean isUp = false;
        try {

            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet getRequest = new HttpGet(healthUrl);

            getRequest.addHeader("Content-type", "application/json");

            response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() == 200) {
                String json_string = EntityUtils.toString(response.getEntity());
                isUp = json_string.contains("UP");
            } else {
                isUp = false;
            }

        } catch (ClientProtocolException e) {
            LOG.error("Error ClientProtocolException: {}", healthUrl, e);

        } catch (IOException e) {
            LOG.error("Error IOException: {}", healthUrl, e);
        }
        return isUp;
    }

}