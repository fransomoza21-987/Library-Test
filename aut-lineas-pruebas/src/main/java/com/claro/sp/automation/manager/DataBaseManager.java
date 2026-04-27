package com.claro.sp.automation.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.claro.sp.automation.controller.CellularController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBaseManager {
    private static final Logger LOG = LoggerFactory.getLogger(CellularController.class);
    public static ResultSet executeQuery(Connection con, String query) throws Exception {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception ex) {
            LOG.error("Error al ejecutar la query: {}", query, ex);
            throw ex;
        }
    }

    public static void executeUpdate(Connection con, String query) throws Exception {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception ex) {
            LOG.error("Error al ejecutar el update: {}", query, ex);
            throw ex;
        }
    }
}
