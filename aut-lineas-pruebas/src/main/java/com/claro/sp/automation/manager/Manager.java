package com.claro.sp.automation.manager;

import com.claro.sp.automation.exceptions.InvalidCountryException;
import com.claro.sp.automation.model.*;
import com.claro.sp.automation.model.subscriber.Balance;
import com.claro.sp.automation.model.subscriber.Cellular;
import com.claro.sp.automation.model.subscriber.Pack;
import com.claro.sp.automation.model.subscriber.Slot;
import com.claro.sp.automation.util.Constant;
import com.claro.sp.ta.db.connection.DatabaseConnection;
import com.claro.sp.ta.db.model.DataBaseProperties;
import com.claro.sp.ta.db.util.Country;
import com.claro.sp.ta.db.util.Environment;
import java.security.SecureRandom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static com.claro.sp.automation.manager.DataBaseManager.executeQuery;
import static com.claro.sp.automation.manager.DataBaseManager.executeUpdate;
import static com.claro.sp.automation.util.Constant.*;
import static com.claro.sp.automation.util.SqlBlocks.*;
import static com.claro.sp.automation.util.SqlQueries.*;

public abstract class Manager {

    protected Connection ccardConn;
    protected Connection prodConn;
    protected Map<String, Pack> packs;
    private TecnoManager tecnoManager;
    private static final SecureRandom secureRandom = new SecureRandom();


    public static Manager create(String country) throws InvalidCountryException {
        if (country.equalsIgnoreCase(Country.ARGENTINA)) return new ManagerAR();
        if (country.equalsIgnoreCase(Country.URUGUAY)) return new ManagerUY();
        if (country.equalsIgnoreCase(Country.PARAGUAY)) return new ManagerPY();
        throw new InvalidCountryException();
    }

    public Connection getProdConn() throws Exception {
        if (this.prodConn == null || this.prodConn.isClosed())
            this.prodConn = DatabaseConnection.getProdConnection(DataBaseProperties.environment, DataBaseProperties.country, DataBaseProperties.userProd, DataBaseProperties.passwordProd);
        return this.prodConn;
    }

    public Connection getCcardConn() throws Exception {
        if (this.ccardConn == null || this.ccardConn.isClosed()) {
            this.ccardConn = DatabaseConnection.getCcardConnection(DataBaseProperties.environment, DataBaseProperties.country, DataBaseProperties.userCcard, DataBaseProperties.passwordCcard);
            this.tecnoManager = new TecnoManager(ccardConn);
        }
        return this.ccardConn;
    }

    public abstract void validateInitialCellularData(Cellular c);

    public abstract void initCellular(Cellular c) throws Exception;

    public abstract String createRandomNim(Cellular c) throws SQLException;

    public abstract void insertActivationRanges(Cellular c) throws Exception;

    public void startConnection() throws Exception {
        this.ccardConn = DatabaseConnection.getCcardConnection(DataBaseProperties.environment, DataBaseProperties.country, DataBaseProperties.userCcard, DataBaseProperties.passwordCcard);
        this.prodConn = DatabaseConnection.getProdConnection(DataBaseProperties.environment, DataBaseProperties.country, DataBaseProperties.userProd, DataBaseProperties.passwordProd);
        this.tecnoManager = new TecnoManager(this.ccardConn);
    }

    public void closeConnection() throws SQLException {
        this.prodConn.close();
        this.ccardConn.close();
        this.tecnoManager = null;
    }

    public void createSim(Cellular c) throws Exception {
        //Verifico si la tarjeta sim ya fue registrada anteriormente en el equipo
        String query = BLOCK_GENERATE_SIM.replaceAll("#pais#", DataBaseProperties.country.toUpperCase());
        query = query.replaceAll("#equipo#", c.getSubid());

        executeUpdate(prodConn, query);
    }

    protected String getRatePlanId(String profileId) throws Exception {
        String query = null;
        ResultSet rs = null;

        query = String.format(QUERY_GET_RATE_PLAN_ID, profileId);

        rs = DataBaseManager.executeQuery(prodConn, query);
        if (rs.next())
            return rs.getString("rppr_rpl_id");
        rs.close();
        return null;
    }

    public void initPacks(Slot s) throws Exception {
        String idPackTN3 = s.getPkgDefId();
        String idPackSTH = null;
        ResultSet rs = null;
        ResultSet rsExpiry = null;

        if (idPackTN3 != null) {
            String query = String.format(QUERY_GET_PACK_DATA, idPackTN3);
            rs = executeQuery(ccardConn, query);
            if (rs.next()) {
                idPackSTH = rs.getString("sep_pkt_id");
                if (idPackSTH != null) {
                    s.setPkgQuantityLeft(rs.getInt("quantityLeft"));
                    s.setPkgRenewal(rs.getString("sep_renewal_pkt"));

                    this.packs.put(idPackTN3, new Pack(idPackSTH, idPackTN3, rs.getInt("sep_type_tecnomen"), rs.getString("accountTypeId")));

                    query = String.format(QUERY_GET_PKG_EXPIRY, idPackSTH);
                    rsExpiry = executeQuery(prodConn, query);

                    if (rsExpiry.next())
                        s.setPkgExpiry(rsExpiry.getDate("pkgExpiry"));
                } else {
                    throw new Exception("ERROR: No se encontro el id de Stealth del pack: " + idPackTN3);
                }
            }
        } else {
            throw new Exception("ERROR: No se cargo el id del pack en TN3");
        }
        rs.close();
    }

    public void loadBags(Cellular c, Balance b) throws Exception {
        PaymentFundTransferDFTSubscriber fundTransferDFT = new PaymentFundTransferDFTSubscriber();
        fundTransferDFT.setOperatorId(0);
        fundTransferDFT.setSubId(c.getSubid());

        Integer gsmDecDivisor = this.getDecimalDivisor();

        if (gsmDecDivisor != null) {
            switch (b.getName()) {
                case MAIN: {
                    fundTransferDFT.setAmount(b.getAmount() * gsmDecDivisor);
                    fundTransferDFT.setExpiryDate(b.getExpiry());
                    break;
                }
                case PERIODIC: {
                    fundTransferDFT.setPeriodicAmount(b.getAmount() * gsmDecDivisor);
                    fundTransferDFT.setPeriodicExpiry(b.getExpiry());
                    break;
                }
                case BONUS: {
                    fundTransferDFT.setBonusAmount(b.getAmount() * gsmDecDivisor);
                    fundTransferDFT.setBonusExpiry(b.getExpiry());
                    break;
                }
                case BONUS2: {
                }
            }
        } else {
            throw new Exception("ERROR: no se pudo obtener el gsm_decimal_divisor");
        }

        Short result = this.tecnoManager.fundTransferDFT(fundTransferDFT);

        if (result != 0) {
            throw new Exception("ERROR: Al cargar bolsas. fundTransferDFT = " + result);
        }
    }

    protected Integer getDecimalDivisor() throws Exception {
        ResultSet rs = null;
        Integer divisor = null;
        String query = QUERY_GET_DECIMAL_DIVISOR;

        rs = executeQuery(ccardConn, query);

        if (rs.next())
            divisor = rs.getInt("ppa_value");

        return divisor;
    }

    public Boolean checkNim(String celNumber) throws Exception {
        ResultSet rs = null;
        String query = null;
        try {
            String subId = getPrefix() + celNumber;
            GetSubscriberResponse subscriber = this.tecnoManager.GetSubscriber(subId);

            if (celNumber != null) {
                query = String.format(QUERY_VALIDATE_CELLULARS, celNumber);
                rs = executeQuery(prodConn, query);
                if (!rs.next() && subscriber.getResultCode() == 100) {
                    return true;
                }
            } else {
                throw new Exception("ERROR: El numero a validar es nulo.");
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    private String getPrefix() throws Exception {
        ResultSet rs = null;
        String query = QUERY_GET_PREFIX;
        rs = executeQuery(ccardConn, query);
        rs.next();

        return rs.getString(1);
    }

    public Boolean checkNim(Connection conn, String celNumber) throws Exception {
        ResultSet rs = null;
        String query = null;
        try {
            if (celNumber != null) {
                query = String.format(QUERY_VALIDATE_CELLULARS, celNumber);
                rs = executeQuery(conn, query);
                if (!rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    public String getSequenceId(String seqName, Connection conn) throws Exception {
        String query = null;
        ResultSet rs = null;

        query = String.format(QUERY_GET_SEQUENCE_ID, seqName);

        rs = executeQuery(conn, query);
        if (rs.next())
            return rs.getString("seq");

        return null;
    }

    public String createHandle(Cellular c) throws Exception {
        String seqId = getSequenceId("CCARD.SEQ_PCE_ID", this.ccardConn);

        return seqId;
    }

    public Boolean checkHandle(String handle) throws Exception {
        ResultSet rs = null;
        String query = null;
        try {
            if (handle != null) {
                query = String.format(QUERY_VALIDATE_HANDLE, handle);
                rs = executeQuery(ccardConn, query);
                if (!rs.next()) {
                    return true;
                }
            } else {
                throw new Exception("ERROR: El handle a validar es nulo");
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    public void createSubscriberInTn3(Cellular c) throws Exception {
        Subscriber sub = new Subscriber();

        sub.setLogin(c.getSubid());
        sub.setUserType(1);
        sub.setLanguageId(32);
        sub.setOperatorId(1);
        sub.setSubId(c.getSubid());
        sub.setImsi(c.getImsi());
        sub.setProfileId(Integer.parseInt(c.getProfileId()));
        sub.setAccountType(1);
        sub.setAccountTypeGprs(2);
        sub.setTariffPlandId(Integer.parseInt(c.getProfileId()));
        sub.setServiceType(1);
        sub.setServiceSubType(1);
        sub.setServiceTypeGprs(2);
        sub.setServiceSubTypeGprs(6);

        Short result = this.tecnoManager.CreateSubscriber(sub);

        if (result != 0) {
            throw new Exception("ERROR: Al crear subscriber en TN3. create_subscriber = " + result);
        }
    }

    public void insertCellulars(Cellular c) throws Exception {
        String query = String.format(BLOCK_GENERATE_CELLULARS, c.getCellularNumber(), c.getStatusStealth(), c.getAccountId(), c.getDealerId(),
                c.getClientId(), c.getBlock_code(), c.getBusinessType(), c.getBillNumber());
        executeUpdate(prodConn, query);
    }

    public void insertPrepayCellulars(Cellular c) throws Exception {
        String query = BLOCK_INSERT_PREPAY_CELLULARS.replaceAll("#handle#", c.getHandle());
        query = query.replaceAll("#linea#", c.getCellularNumber());
        query = query.replaceAll("#estado_ppay#", c.getStatusPpay());
        query = query.replaceAll("#linea#", c.getCellularNumber());

        executeUpdate(ccardConn, query);
    }

    public void insertCellularNumberChanges(Cellular c) throws Exception {
        String query = String.format(BLOCK_INSERT_CEL_NUMBER_CHANGES, c.getHandle(), c.getCellularNumber());

        executeUpdate(ccardConn, query);
    }

    public Boolean checkAndLoadSim(Cellular c) throws Exception {
        String query = String.format(QUERY_VALIDATE_SIMS, c.getSubid());
        ResultSet rs = null;

        rs = executeQuery(prodConn, query);
        if (rs.next()) {
            c.setImsi(rs.getString("sim_imsi"));
            c.setIccid(rs.getString("sim_iccid"));
            return true;
        }

        return false;
    }

    public String obtainSubid(Cellular c) throws Exception {
        String query;
        if(c.getBillNumber() != null && c.getCellularNumber() != null)
            query = String.format(QUERY_GET_SUBID, c.getBillNumber(), c.getCellularNumber());
        else
            query = String.format(QUERY_GET_SUBID, c.getBillNumber(), c.getBillNumber());
        ResultSet rs = null;

        rs = executeQuery(prodConn, query);
        if (rs.next()) {
            return rs.getString("subId");
        }
        return null;
    }

    public void loadSubid(Cellular c) throws Exception {
        c.setSubid(this.obtainSubid(c));
    }

    public void updateCellularsEsn(Cellular c) throws Exception {
        String query = String.format(BLOCK_UPDATE_CELLULARS_ESN, c.getIccid().substring(0, 19), c.getCellularNumber());

        executeUpdate(prodConn, query);
    }

    public void asignSimToCellular(Cellular c) throws Exception {
        String query = BLOCK_ASIGN_SIM_TO_CEL.replaceAll("#linea#", c.getCellularNumber());
        query = query.replaceAll("#iccid#", c.getIccid());
        query = query.replaceAll("#dealer#", c.getDealerId());
        query = query.replaceAll("#msisdn#", c.getSubid());
        query = query.replaceAll("#cetid#", getRandomCetId());

        executeUpdate(prodConn, query);
    }

    public void insertCelBussinesHist(Cellular c) throws Exception {
        String query = String.format(BLOCK_INSERT_CBH, c.getCellularNumber(), c.getBusinessType());

        executeUpdate(prodConn, query);
    }

    public void insertCellularAccounts(Cellular c) throws Exception {
        Boolean check = null;
        String query = null;

        do {
            String seqId = getSequenceId("SEQ_CELLULAR_ACCOUNTS", this.prodConn);
            check = this.checkAccountSeqId(seqId);

            if (check) {
                query = String.format(BLOCK_INSERT_CELLULAR_ACCOUNTS, seqId, c.getCellularNumber(), c.getAccountId());
                executeUpdate(prodConn, query);
            }
        } while (!check);
    }

    protected Boolean checkAccountSeqId(String id) throws Exception {
        ResultSet rs = null;
        String query = String.format(QUERY_VALID_ACCOUNT_ID, id);

        rs = executeQuery(prodConn, query);
        return !rs.next();
    }

    public void insertServiceStatus(Cellular c) throws Exception {
        String query = String.format(BLOCK_INSERT_SERVICE_STATUS, c.getCellularNumber(), c.getStatusStealth());

        executeUpdate(prodConn, query);
    }

    public void insertCellularCallRestrictions(Cellular c) throws Exception {
        Boolean check = null;
        String query = null;

        do {
            String seqId = getSequenceId("CCR_SEQ", this.prodConn);
            check = this.checkCallRestSeqId(seqId);

            if (check) {
                query = String.format(BLOCK_INSERT_CELLULAR_CALL_RESTRICTIONS, seqId, c.getCallRestrictionId(), c.getCellularNumber());
                executeUpdate(prodConn, query);
            }
        } while (!check);
    }

    protected Boolean checkCallRestSeqId(String id) throws Exception {
        ResultSet rs = null;
        String query = String.format(QUERY_VALID_CALL_RESTR_ID, id);

        rs = executeQuery(prodConn, query);
        return !rs.next();
    }

    public void insertPpServiceStatus(Cellular c) throws Exception {
        String query = String.format(BLOCK_INSERT_PP_SERVICE_STATUS, c.getHandle(), c.getCellularNumber(), c.getStatusPpay());

        executeUpdate(ccardConn, query);
    }

    public void updateStatusInTn3(Cellular c) throws Exception {
        TppUpdateSubscriber updSubs = new TppUpdateSubscriber();

        updSubs.setSubId(c.getSubid());
        updSubs.setOperatorId(1);
        updSubs.setServiceStatus(1);
        updSubs.setAccountStatus(Integer.parseInt(c.getAccountStatus()));

        Short result = this.tecnoManager.UpdateSubscriber(updSubs);

        if (result != 0) {
            throw new Exception("ERROR: Al actualizar subscriber. update_subscriber = " + result);
        }
    }

    public void insertRatePlan(Cellular c) throws Exception {
        String query = BLOCK_INSERT_RATE_PLAN.replaceAll("#linea#", c.getCellularNumber());
        query = query.replaceAll("#plan#", c.getRatePlanSth());

        executeUpdate(prodConn, query);
    }

    public void insertBasicPacksSTH(Cellular c) throws Exception {
        String query = String.format(QUERY_GET_BASIC_PACKS_STH, c.getCellularNumber());
        String packId = null;
        ResultSet rs = null;

        rs = executeQuery(prodConn, query);

        while (rs.next()) {
            packId = rs.getString("cpa_pkt_id");

            query = String.format(BLOCK_INSERT_CELLULAR_PACKAGES, c.getCellularNumber(), packId);
            executeUpdate(prodConn, query);
        }
    }

    public void insertPack(Cellular c, Slot s) throws Exception {
        Short result = null;
        String query = null;
        Pack p = null;

        SubscriberAccount subAccVOICE = null;
        SubscriberAccount subAccSMS = null;
        SubscriberAccount subAccGPRS = null;

        p = this.packs.get(s.getPkgDefId());
        query = String.format(BLOCK_INSERT_CELLULAR_PACKAGES, c.getCellularNumber(), p.getIdPackSTH());
        executeUpdate(prodConn, query);

        if (Integer.parseInt(p.getAccountTypeId()) == 0) {
            //VOZ
            subAccVOICE = new SubscriberAccount();
            subAccVOICE.setSlot(p.getSlotId(), s);
            subAccVOICE.setSubid(c.getSubid());
            subAccVOICE.setAccountType(0);

            result = this.tecnoManager.UpdateSubscriberAccount(subAccVOICE);
            if (result != 0) {
                throw new Exception("ERROR: Al dar de alta pack de VOZ " + p.getIdPackSTH() + ". update_subscriber_account = " + result);
            }
        } else if (Integer.parseInt(p.getAccountTypeId()) == 1) {
            //SMS
            subAccSMS = new SubscriberAccount();
            subAccSMS.setSlot(p.getSlotId().intValue(), s);
            subAccSMS.setSubid(c.getSubid());
            subAccSMS.setAccountType(1);

            result = this.tecnoManager.UpdateSubscriberAccount(subAccSMS);
            if (result != 0) {
                throw new Exception("ERROR: Al dar de alta pack de SMS " + p.getIdPackSTH() + ". update_subscriber_account = " + result);
            }
        } else if (Integer.parseInt(p.getAccountTypeId()) == 2) {
            //DATOS
            subAccGPRS = new SubscriberAccount();
            subAccGPRS.setSlot(p.getSlotId(), s);
            subAccGPRS.setAccountType(2);
            subAccGPRS.setSubid(c.getSubid());

            result = this.tecnoManager.UpdateSubscriberAccount(subAccGPRS);
            if (result != 0) {
                throw new Exception("ERROR: Al dar de alta pack de DATOS " + p.getIdPackSTH() + ". update_subscriber_account = " + result);
            }
        }
    }

    public void deleteSubscriber(Cellular c) throws Exception {
        if (c.isFlagSims() && c.getIccid() != null) {
            String esnHexa = c.getIccid().substring(0, c.getIccid().length() - 1);
            String query1 = String.format(BLOCK_DELETE_SIM_CELLULAR, c.getIccid(), esnHexa);
            executeUpdate(prodConn, query1);
        }
        String query2 = String.format(BLOCK_DELETE_PROD, c.getCellularNumber(), DataBaseProperties.userProd);
        executeUpdate(prodConn, query2);
        String query3 = String.format(BLOCK_DELETE_CCARD, c.getCellularNumber(), getCcardOwner());
        executeUpdate(ccardConn, query3);
        short result = this.tecnoManager.deleteSubscriber(c.getSubid());
        if (result != 0 && result != 3)
            throw new Exception("ERROR: Al borrar subscriber. delete_subscriber = " + result);
    }

    private String getCcardOwner() {
        String environment = DataBaseProperties.environment.toUpperCase();
        String country = DataBaseProperties.country.toUpperCase();
        if (environment.equals(Environment.DEVELOP) && country.equals(Country.ARGENTINA))
            return Constant.CCARD_DEV_AR_OWNER;
        else return CCARD_OWNER;
    }

    public void deleteCellulars(Cellular c) throws Exception {
        String query = BLOCK_DELETE_CELLULAR_CU.replaceAll("#linea#", c.getCellularNumber());

        executeUpdate(prodConn, query);

        Short result = this.tecnoManager.deleteSubscriber(c.getSubid());

        if (result != 0) {
            if (result != 3) {
                throw new Exception("ERROR: Al borrar subscriber. delete_subscriber = " + result);
            }
        }
    }

    protected String calibrateLength(String nim, int length){
        if(nim.length()!= length){
            String newNim = nim.substring(0,nim.length()-1).concat("0");
            return newNim.concat(nim.substring(nim.length()-1));
        }else{
            return nim;
        }
    }

    public String getRandomCetId() {
        String prefix = "5497";
        int tenDigits = 10000000 + secureRandom.nextInt(90000000);
        return prefix.concat(String.valueOf(tenDigits));
    }

    public void insertCreditLimit(Cellular c) throws Exception {
        String query = String.format(BLOCK_INSERT_CREDIT_LIMIT, c.getCellularNumber(), c.getHandle(), c.getRatePlanSth(), c.getBillNumber());
        try {
            DataBaseManager.executeUpdate(this.prodConn, query);
        } catch (Exception e) {
            throw new Exception("ERROR: Al asignar limite de crédito al subscriber: " + e);
        }
    }

    public void updateBillNumber(Cellular c) throws Exception{
        String query = String.format(QUERY_UPDATE_CELLULARS_BILL_NUMBER, c.getBillNumber(), c.getCellularNumber());
        executeUpdate(prodConn, query);
    }
}
