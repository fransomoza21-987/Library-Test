package com.claro.sp.automation.manager;

import com.claro.sp.automation.controller.CellularController;
import com.claro.sp.automation.model.subscriber.Cellular;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.claro.sp.automation.manager.DataBaseManager.executeQuery;
import static com.claro.sp.automation.manager.DataBaseManager.executeUpdate;
import static com.claro.sp.automation.util.ConstantCellular.*;
import static com.claro.sp.automation.util.SqlBlocks.*;
import static com.claro.sp.automation.util.SqlQueries.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagerPY extends Manager {
    private static final Logger LOG = LoggerFactory.getLogger(CellularController.class);
    public void validateInitialCellularData(Cellular c) {
        if (c.getNode() == null) {
            c.setNode("N");
        }
        if (c.getAccountStatus() == null) {
            c.setAccountStatus("2");
        }
        if (c.getBlock_code() == null) {
            c.setBlock_code("APP01");
        }
        if (c.getBusinessType() == null) {
            c.setBusinessType("PP");
        }
        if (c.getCodeArea() == null) {
            c.setCodeArea("66");
        }

        if (c.getProfileId() == null) {
            if ("PP".equalsIgnoreCase(c.getBusinessType())) {
                c.setProfileId("921");
            } else if ("CR".equalsIgnoreCase(c.getBusinessType())) {
                c.setProfileId("912"); //880
            }
        }
    }

    public void initCellular(Cellular c) throws Exception {

        if ("2".equalsIgnoreCase(c.getAccountStatus())) {
            c.setStatusStealth(STH_STATUS_ACTIVE);
            c.setStatusPpay(CCARD_STATUS_ACTIVE);
            c.setCallRestrictionId(CR_ID_DDN);
        } else if ("3".equalsIgnoreCase(c.getAccountStatus())) {
            c.setStatusStealth(STH_STATUS_ACTIVE);
            c.setStatusPpay(CCARD_STATUS_LAPSED);
            c.setCallRestrictionId(CR_ID_DDN);
        } else if ("4".equalsIgnoreCase(c.getAccountStatus())) {
            c.setStatusStealth(STH_STATUS_SUSPENDED);
            c.setStatusPpay(CCARD_STATUS_SUSPENDED);
            c.setCallRestrictionId(CR_ID_ONLY_ENTRANCE);
        } else if ("5".equalsIgnoreCase(c.getAccountStatus())) {
            c.setStatusStealth(STH_STATUS_CANCELED);
            c.setStatusPpay(CCARD_STATUS_CANCELED);
            c.setCallRestrictionId(CR_ID_ONLY_ENTRANCE);
        }

        c.setAccountId(ACCOUNT_PY);
        c.setDealerId(DEALER_PY);

        if (c.isCorporativeClient()) {
            c.setAccountId(ACCOUNT_CORPO_PY);
            c.setClientId(CLIENT_CORPO_PY);
        } else {
            c.setAccountId(ACCOUNT_PY);
            c.setClientId(CLIENT_PY);
        }

        c.setRatePlanSth(this.getRatePlanId(c.getProfileId()));
    }

    public String createRandomNim(Cellular c) throws SQLException {
        ResultSet rs = null;
        String query = null;
        try {
            if ("N".equalsIgnoreCase(c.getNode())) {
                if(c.isFlagRange())
                    query = String.format(QUERY_RANDOM_NIM_PY, c.getCodeArea(),c.getBeginRange(),c.getEndRange());
                else
                    query = String.format(QUERY_RANDOM_NIM_PY, c.getCodeArea(),DEFAULT_BEGIN_RANGE,DEFAULT_END_RANGE);
                rs = executeQuery(this.prodConn, query);
            }
            if (rs.next())
                return calibrateLength(rs.getString("NIM"),9);
        } catch (SQLException sqle) {
            LOG.error("Error en SQL: {}", c, sqle);
        } catch (Exception e) {
            LOG.error("Error al crear el NIM: {}", c, e);
        } finally {
            rs.close();
        }
        return null;
    }

    public void insertActivationRanges(Cellular c) throws Exception {
        String query = String.format(BLOCK_INSERT_ACTIVATION_RANGES, c.getCellularNumber(), c.getCellularNumber(), c.getCellularNumber(), c.getBlock_code(), c.getCellularNumber().substring(0, 2),
                c.getCellularNumber().substring(2, 9), c.getCellularNumber().substring(2, 9), c.getCellularNumber(), c.getCellularNumber(), c.getSubid());

        executeUpdate(prodConn, query);
    }


}