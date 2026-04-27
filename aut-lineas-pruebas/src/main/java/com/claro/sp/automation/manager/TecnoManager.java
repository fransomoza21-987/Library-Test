package com.claro.sp.automation.manager;

import com.claro.sp.automation.model.*;
import com.claro.sp.automation.model.subscriber.Slot;
import com.claro.sp.automation.util.Utils;
import com.claro.sp.ta.db.model.DataBaseProperties;
import com.claro.sp.ta.db.util.Country;
import com.claro.sp.ta.db.util.Environment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class TecnoManager {

    private final int operatorId = 1;
    private final Connection connection;

    public TecnoManager(Connection connection) {
        this.connection = connection;
    }

    public short UpdateSubscriberAccount(SubscriberAccount subscriberAccount) throws Exception {

        CallableStatement cstmt = connection.prepareCall("{? = call ccard.PP_PP_SERVER.Update_Subscriber_Account(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.registerOutParameter(2, Types.VARCHAR);

        cstmt.setString(3, subscriberAccount.getSubid());
        cstmt.setInt(4, operatorId);
        cstmt.setInt(5, subscriberAccount.getAccountType());

        if (subscriberAccount.getCounter6() != null) {
            cstmt.setInt(6, subscriberAccount.getCounter6());
        } else {
            cstmt.setNull(6, Types.INTEGER);
        }

        cstmt.setDate(7, subscriberAccount.getCounterTStamp6());

        if (subscriberAccount.getTariffPlanId() != null) {
            cstmt.setInt(8, subscriberAccount.getTariffPlanId());
        } else {
            cstmt.setNull(8, Types.INTEGER);
        }
        if (subscriberAccount.getBalanceAmount0() != null) {
            cstmt.setInt(9, subscriberAccount.getBalanceAmount0());
        } else {
            cstmt.setNull(9, Types.INTEGER);
        }
        if (subscriberAccount.getBalanceUnits0() != null) {
            cstmt.setInt(10, subscriberAccount.getBalanceUnits0());
        } else {
            cstmt.setNull(10, Types.INTEGER);
        }

        cstmt.setDate(11, subscriberAccount.getBalanceExpiry0());

        int z = 12;
        for (int x = 0; x < 14; x++) {
            cstmt.setString(z, subscriberAccount.getPkgDefId(x));
            z++;
            if (subscriberAccount.getPkgQuantityLeft(x) != null) {
                cstmt.setInt(z, subscriberAccount.getPkgQuantityLeft(x));
            } else {
                cstmt.setNull(z, Types.INTEGER);
            }
            z++;
            cstmt.setDate(z, subscriberAccount.getPkgExpiry(x));
            z++;
            cstmt.setString(z, subscriberAccount.getPkgRenewal(x));
            z++;
            cstmt.setInt(z, 0);
            z++;
        }
        if (subscriberAccount.getBestDate() != null) {
            cstmt.setInt(z, subscriberAccount.getBestDate());
        } else {
            cstmt.setNull(z, Types.INTEGER);
        }
        z++;
        cstmt.registerOutParameter(z, Types.NUMERIC);
        z++;
        cstmt.registerOutParameter(z, Types.DATE);

        cstmt.executeUpdate();
        return (short) cstmt.getInt(1);
    }


    public SubscriberAccount GetSubscriberAccount(String subId, int accountType) throws Exception {

        SubscriberAccount subscriberAccount = new SubscriberAccount();

        CallableStatement cstmt = connection.prepareCall("{? = call ccard.PP_PP_SERVER.Get_Subscriber_Account(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.registerOutParameter(2, Types.VARCHAR);

        cstmt.registerOutParameter(6, Types.NUMERIC);
        cstmt.registerOutParameter(7, Types.NUMERIC);
        cstmt.registerOutParameter(8, Types.NUMERIC);
        cstmt.registerOutParameter(9, Types.VARCHAR);

        cstmt.registerOutParameter(10, Types.NUMERIC);
        cstmt.registerOutParameter(11, Types.NUMERIC);
        cstmt.registerOutParameter(12, Types.VARCHAR);
        cstmt.registerOutParameter(13, Types.NUMERIC);
        cstmt.registerOutParameter(14, Types.NUMERIC);

        cstmt.registerOutParameter(15, Types.NUMERIC);
        cstmt.registerOutParameter(16, Types.NUMERIC);
        cstmt.registerOutParameter(17, Types.VARCHAR);
        cstmt.registerOutParameter(18, Types.NUMERIC);
        cstmt.registerOutParameter(19, Types.NUMERIC);

        cstmt.registerOutParameter(20, Types.NUMERIC);
        cstmt.registerOutParameter(21, Types.NUMERIC);
        cstmt.registerOutParameter(22, Types.VARCHAR);
        cstmt.registerOutParameter(23, Types.NUMERIC);
        cstmt.registerOutParameter(24, Types.NUMERIC);

        cstmt.registerOutParameter(25, Types.NUMERIC);
        cstmt.registerOutParameter(26, Types.NUMERIC);
        cstmt.registerOutParameter(27, Types.VARCHAR);
        cstmt.registerOutParameter(28, Types.NUMERIC);
        cstmt.registerOutParameter(29, Types.NUMERIC);

        cstmt.registerOutParameter(30, Types.NUMERIC);
        cstmt.registerOutParameter(31, Types.NUMERIC);
        cstmt.registerOutParameter(32, Types.VARCHAR);
        cstmt.registerOutParameter(33, Types.NUMERIC);
        cstmt.registerOutParameter(34, Types.NUMERIC);

        cstmt.registerOutParameter(35, Types.NUMERIC);
        cstmt.registerOutParameter(36, Types.NUMERIC);
        cstmt.registerOutParameter(37, Types.VARCHAR);
        cstmt.registerOutParameter(38, Types.NUMERIC);
        cstmt.registerOutParameter(39, Types.NUMERIC);

        cstmt.registerOutParameter(40, Types.NUMERIC);
        cstmt.registerOutParameter(41, Types.NUMERIC);
        cstmt.registerOutParameter(42, Types.VARCHAR);
        cstmt.registerOutParameter(43, Types.NUMERIC);
        cstmt.registerOutParameter(44, Types.NUMERIC);

        cstmt.registerOutParameter(45, Types.NUMERIC);
        cstmt.registerOutParameter(46, Types.NUMERIC);
        cstmt.registerOutParameter(47, Types.VARCHAR);
        cstmt.registerOutParameter(48, Types.NUMERIC);
        cstmt.registerOutParameter(49, Types.NUMERIC);

        cstmt.registerOutParameter(50, Types.NUMERIC);
        cstmt.registerOutParameter(51, Types.NUMERIC);
        cstmt.registerOutParameter(52, Types.VARCHAR);
        cstmt.registerOutParameter(53, Types.NUMERIC);
        cstmt.registerOutParameter(54, Types.NUMERIC);

        cstmt.registerOutParameter(55, Types.NUMERIC);
        cstmt.registerOutParameter(56, Types.NUMERIC);
        cstmt.registerOutParameter(57, Types.VARCHAR);
        cstmt.registerOutParameter(58, Types.NUMERIC);
        cstmt.registerOutParameter(59, Types.NUMERIC);

        cstmt.registerOutParameter(60, Types.NUMERIC);
        cstmt.registerOutParameter(61, Types.NUMERIC);
        cstmt.registerOutParameter(62, Types.VARCHAR);
        cstmt.registerOutParameter(63, Types.NUMERIC);
        cstmt.registerOutParameter(64, Types.NUMERIC);

        cstmt.registerOutParameter(65, Types.NUMERIC);
        cstmt.registerOutParameter(66, Types.NUMERIC);
        cstmt.registerOutParameter(67, Types.VARCHAR);
        cstmt.registerOutParameter(68, Types.NUMERIC);
        cstmt.registerOutParameter(69, Types.NUMERIC);

        cstmt.registerOutParameter(70, Types.NUMERIC);
        cstmt.registerOutParameter(71, Types.NUMERIC);
        cstmt.registerOutParameter(72, Types.VARCHAR);
        cstmt.registerOutParameter(73, Types.NUMERIC);
        cstmt.registerOutParameter(74, Types.NUMERIC);

        cstmt.registerOutParameter(75, Types.NUMERIC);
        cstmt.registerOutParameter(76, Types.NUMERIC);
        cstmt.registerOutParameter(77, Types.VARCHAR);
        cstmt.registerOutParameter(78, Types.NUMERIC);
        cstmt.registerOutParameter(79, Types.NUMERIC);

        cstmt.setInt(3, operatorId);
        cstmt.setString(4, subId);
        cstmt.setInt(5, accountType);

        cstmt.executeUpdate();

        int resultCode = cstmt.getInt(1);

        if (resultCode == 0) {

            subscriberAccount.setSubid(subId);
            subscriberAccount.setAccountType(accountType);
            subscriberAccount.setTariffPlanId(cstmt.getInt(6));
            subscriberAccount.setBalanceAmount0(cstmt.getInt(7));
            subscriberAccount.setBalanceExpiry0(Utils.getDateFromString(cstmt.getString(9)));

            short y = 0;
            for (int x = 10; x < 76; x = x + 5) {
                subscriberAccount.setSlot(y, new Slot(cstmt.getString(x), cstmt.getInt(x + 1), Utils.getDateFromString(cstmt.getString(x + 2)), cstmt.getString(x + 3)));
                y++;
            }
        }
        return subscriberAccount;
    }

    public short CreateSubscriber(Subscriber subscriber) throws Exception {
        CallableStatement cstmt;
        if (DataBaseProperties.environment.equalsIgnoreCase(Environment.DEVELOP) && DataBaseProperties.country.equalsIgnoreCase(Country.ARGENTINA)) {
            cstmt = connection.prepareCall("{? = call PP_PROVISIONING_INTERFACE.Create_Subscriber(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        } else {
            cstmt = connection.prepareCall("{? = call ccard.PP_PROVISIONING_INTERFACE.Create_Subscriber(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        }
        cstmt.registerOutParameter(1, Types.NUMERIC);

        cstmt.setString(2, subscriber.getLogin());
        cstmt.setInt(3, subscriber.getUserType());
        cstmt.setInt(4, subscriber.getLanguageId());
        cstmt.setInt(5, subscriber.getOperatorId());
        cstmt.setString(6, subscriber.getSubId());

        if (subscriber.getAccountBalance() != null) {
            cstmt.setInt(7, subscriber.getAccountBalance());
        } else {
            cstmt.setNull(7, Types.INTEGER);
        }

        cstmt.setDate(8, (java.sql.Date) subscriber.getExpiryDate());
        cstmt.setString(9, subscriber.getFamilyFriends());

        if (subscriber.getFfDiscount() != null) {
            cstmt.setInt(10, subscriber.getFfDiscount());
        } else {
            cstmt.setNull(10, Types.INTEGER);
        }

        cstmt.setDate(11, (java.sql.Date) subscriber.getFfExpiry());

        if (subscriber.getFfOnatSubLevel() != null) {
            cstmt.setInt(12, subscriber.getFfOnatSubLevel());
        } else {
            cstmt.setNull(12, Types.INTEGER);
        }

        cstmt.setString(13, subscriber.getImsi());
        cstmt.setInt(14, subscriber.getProfileId());
        cstmt.setDate(15, (java.sql.Date) subscriber.getBonusExpiry());
        cstmt.setString(16, subscriber.getSmid());

        if (subscriber.getSubClass() != null) {
            cstmt.setInt(17, subscriber.getSubClass());
        } else {
            cstmt.setNull(17, Types.INTEGER);
        }

        cstmt.setDate(18, (java.sql.Date) subscriber.getActivationDate());
        cstmt.setInt(19, subscriber.getAccountType());
        cstmt.setInt(20, subscriber.getAccountTypeGprs());
        cstmt.setInt(21, subscriber.getTariffPlandId());

        if (subscriber.getBalanceAmount0() != null) {
            cstmt.setInt(22, subscriber.getBalanceAmount0());
        } else {
            cstmt.setNull(22, Types.INTEGER);
        }
        if (subscriber.getBalanceUnits0() != null) {
            cstmt.setInt(23, subscriber.getBalanceUnits0());
        } else {
            cstmt.setNull(23, Types.INTEGER);
        }

        cstmt.setDate(24, (java.sql.Date) subscriber.getBalanceExpiry0());

        if (subscriber.getPkgdefId0() != null) {
            cstmt.setInt(25, subscriber.getPkgdefId0());
        } else {
            cstmt.setNull(25, Types.INTEGER);
        }
        if (subscriber.getPkgQuantityLeft0() != null) {
            cstmt.setInt(26, subscriber.getPkgQuantityLeft0());
        } else {
            cstmt.setNull(26, Types.INTEGER);
        }

        cstmt.setDate(27, (java.sql.Date) subscriber.getPkgExpiry0());

        if (subscriber.getPkgRenewal0() != null) {
            cstmt.setInt(28, subscriber.getPkgRenewal0());
        } else {
            cstmt.setNull(28, Types.INTEGER);
        }
        if (subscriber.getPkgNextDefId0() != null) {
            cstmt.setInt(29, subscriber.getPkgNextDefId0());
        } else {
            cstmt.setNull(29, Types.INTEGER);
        }
        if (subscriber.getPkgDefId1() != null) {
            cstmt.setInt(30, subscriber.getPkgDefId1());
        } else {
            cstmt.setNull(30, Types.INTEGER);
        }
        if (subscriber.getPkgQuantityLeft1() != null) {
            cstmt.setInt(31, subscriber.getPkgQuantityLeft1());
        } else {
            cstmt.setNull(31, Types.INTEGER);
        }

        cstmt.setDate(32, (java.sql.Date) subscriber.getPkgExpiry1());

        if (subscriber.getPkgRenewal1() != null) {
            cstmt.setInt(33, subscriber.getPkgRenewal1());
        } else {
            cstmt.setNull(33, Types.INTEGER);
        }
        if (subscriber.getPkgNextDefId1() != null) {
            cstmt.setInt(34, subscriber.getPkgNextDefId1());
        } else {
            cstmt.setNull(34, Types.INTEGER);
        }
        if (subscriber.getPkgDefId2() != null) {
            cstmt.setInt(35, subscriber.getPkgDefId2());
        } else {
            cstmt.setNull(35, Types.INTEGER);
        }
        if (subscriber.getPkgQuantityLeft2() != null) {
            cstmt.setInt(36, subscriber.getPkgQuantityLeft2());
        } else {
            cstmt.setNull(36, Types.INTEGER);
        }

        cstmt.setDate(37, (java.sql.Date) subscriber.getPkgExpiry2());

        if (subscriber.getPkgRenewal2() != null) {
            cstmt.setInt(38, subscriber.getPkgRenewal2());
        } else {
            cstmt.setNull(38, Types.INTEGER);
        }
        if (subscriber.getPkgNextDefId2() != null) {
            cstmt.setInt(39, subscriber.getPkgNextDefId2());
        } else {
            cstmt.setNull(39, Types.INTEGER);
        }
        if (subscriber.getPkgDefId3() != null) {
            cstmt.setInt(40, subscriber.getPkgDefId3());
        } else {
            cstmt.setNull(40, Types.INTEGER);
        }
        if (subscriber.getPkgQuantityLeft3() != null) {
            cstmt.setInt(41, subscriber.getPkgQuantityLeft3());
        } else {
            cstmt.setNull(41, Types.INTEGER);
        }

        cstmt.setDate(42, (java.sql.Date) subscriber.getPkgExpiry3());

        if (subscriber.getPkgRenewal3() != null) {
            cstmt.setInt(43, subscriber.getPkgRenewal3());
        } else {
            cstmt.setNull(43, Types.INTEGER);
        }
        if (subscriber.getPkgNextDefId3() != null) {
            cstmt.setInt(44, subscriber.getPkgNextDefId3());
        } else {
            cstmt.setNull(44, Types.INTEGER);
        }

        cstmt.setInt(45, subscriber.getServiceType());
        cstmt.setInt(46, subscriber.getServiceSubType());
        cstmt.setInt(47, subscriber.getServiceTypeGprs());
        cstmt.setInt(48, subscriber.getServiceSubTypeGprs());
        cstmt.setString(49, subscriber.getPrefdDstList0());
        cstmt.setDate(50, (java.sql.Date) subscriber.getPrefDestExpiry0());
        cstmt.setString(51, subscriber.getPrefDestList1());
        cstmt.setDate(52, (java.sql.Date) subscriber.getPrefDestExpiry1());
        cstmt.registerOutParameter(53, Types.VARCHAR);

        if (subscriber.getCallMeonatSubLevel() != null) {
            cstmt.setInt(54, subscriber.getCallMeonatSubLevel());
        } else {
            cstmt.setNull(54, Types.INTEGER);
        }

        cstmt.executeUpdate();
        return (short) cstmt.getInt(1);
    }

    public short UpdateSubscriber(TppUpdateSubscriber tppUpdateSubscriber) throws SQLException {

        CallableStatement cstmt = connection.prepareCall("{? = call PP_PP_SERVER.Update_Subscriber(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        cstmt.registerOutParameter(1, Types.NUMERIC);

        cstmt.setString(2, tppUpdateSubscriber.getSubId());

        if (tppUpdateSubscriber.getOperatorId() != null) {
            cstmt.setInt(3, tppUpdateSubscriber.getOperatorId());
        } else {
            cstmt.setNull(3, Types.INTEGER);
        }

        cstmt.registerOutParameter(4, Types.VARCHAR);
        cstmt.setString(5, tppUpdateSubscriber.getAccountNumber());
        cstmt.setString(6, tppUpdateSubscriber.getImsi());
        cstmt.setString(7, tppUpdateSubscriber.getSmid());

        if (tppUpdateSubscriber.getSmonatSubLevel() != null) {
            cstmt.setInt(8, tppUpdateSubscriber.getSmonatSubLevel());
        } else {
            cstmt.setNull(8, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getServiceStatus() != null) {
            cstmt.setInt(9, tppUpdateSubscriber.getServiceStatus());
        } else {
            cstmt.setNull(9, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getAccountStatus() != null) {
            cstmt.setInt(10, tppUpdateSubscriber.getAccountStatus());
        } else {
            cstmt.setNull(10, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getAccountBalance() != null) {
            cstmt.setInt(11, tppUpdateSubscriber.getAccountBalance());
        } else {
            cstmt.setNull(11, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getLanguageId() != null) {
            cstmt.setInt(12, tppUpdateSubscriber.getLanguageId());
        } else {
            cstmt.setNull(12, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getProfileId() != null) {
            cstmt.setInt(13, tppUpdateSubscriber.getProfileId());
        } else {
            cstmt.setNull(13, Types.INTEGER);
        }

        cstmt.setDate(14, tppUpdateSubscriber.getSuspendDate());
        cstmt.setDate(15, tppUpdateSubscriber.getActivationDate());
        cstmt.setDate(16, tppUpdateSubscriber.getExpiryDate());
        cstmt.setDate(17, tppUpdateSubscriber.getIvrQueryExpiryDate());
        cstmt.setString(18, tppUpdateSubscriber.getFamilyAndFriends());
        cstmt.setDate(19, tppUpdateSubscriber.getFfExpiry());

        if (tppUpdateSubscriber.getFfDiscount() != null) {
            cstmt.setInt(20, tppUpdateSubscriber.getFfDiscount());
        } else {
            cstmt.setNull(20, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getFfonatSubLevel() != null) {
            cstmt.setInt(21, tppUpdateSubscriber.getFfonatSubLevel());
        } else {
            cstmt.setNull(21, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getSmpPckageId() != null) {
            cstmt.setInt(22, tppUpdateSubscriber.getSmpPckageId());
        } else {
            cstmt.setNull(22, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getSmPackageIdNext() != null) {
            cstmt.setInt(23, tppUpdateSubscriber.getSmPackageIdNext());
        } else {
            cstmt.setNull(23, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getSmPackageCounter() != null) {
            cstmt.setInt(24, tppUpdateSubscriber.getSmPackageCounter());
        } else {
            cstmt.setNull(24, Types.INTEGER);
        }

        cstmt.setDate(25, tppUpdateSubscriber.getSmPackageExpiry());

        if (tppUpdateSubscriber.getSmPackageNotificationStatus() != null) {
            cstmt.setInt(26, tppUpdateSubscriber.getSmPackageNotificationStatus());
        } else {
            cstmt.setNull(26, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getRechargeCount() != null) {
            cstmt.setInt(27, tppUpdateSubscriber.getRechargeCount());
        } else {
            cstmt.setNull(27, Types.INTEGER);
        }

        cstmt.setDate(28, tppUpdateSubscriber.getRechargeBonusExpiry());

        if (tppUpdateSubscriber.getBonusBalance() != null) {
            cstmt.setInt(29, tppUpdateSubscriber.getBonusBalance());
        } else {
            cstmt.setNull(29, Types.INTEGER);
        }

        cstmt.setDate(30, tppUpdateSubscriber.getBonusExpiry());

        if (tppUpdateSubscriber.getPeriodicTariffPlan() != null) {
            cstmt.setInt(31, tppUpdateSubscriber.getPeriodicTariffPlan());
        } else {
            cstmt.setNull(31, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getReservationCounter() != null) {
            cstmt.setInt(32, tppUpdateSubscriber.getReservationCounter());
        } else {
            cstmt.setNull(32, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getLastReservationId() != null) {
            cstmt.setInt(33, tppUpdateSubscriber.getLastReservationId());
        } else {
            cstmt.setNull(33, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getLowBalancesmBlockingSet() != null) {
            cstmt.setInt(34, tppUpdateSubscriber.getLowBalancesmBlockingSet());
        } else {
            cstmt.setNull(34, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getMainrRservationAmount() != null) {
            cstmt.setInt(35, tppUpdateSubscriber.getMainrRservationAmount());
        } else {
            cstmt.setNull(35, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getBonusReservationAmount() != null) {
            cstmt.setInt(36, tppUpdateSubscriber.getBonusReservationAmount());
        } else {
            cstmt.setNull(36, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getSmReservationAmount() != null) {
            cstmt.setInt(37, tppUpdateSubscriber.getSmReservationAmount());
        } else {
            cstmt.setNull(37, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getDataReservationAmount() != null) {
            cstmt.setInt(38, tppUpdateSubscriber.getDataReservationAmount());
        } else {
            cstmt.setNull(38, Types.INTEGER);
        }

        cstmt.setString(39, tppUpdateSubscriber.getIncomingCollectCallList());
        cstmt.setString(40, tppUpdateSubscriber.getOutgoingCollectcallList());

        if (tppUpdateSubscriber.getLocalCollectCallonatSubLevel() != null) {
            cstmt.setInt(41, tppUpdateSubscriber.getLocalCollectCallonatSubLevel());
        } else {
            cstmt.setNull(41, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getTotalRechargeErrorCounter() != null) {
            cstmt.setInt(42, tppUpdateSubscriber.getTotalRechargeErrorCounter());
        } else {
            cstmt.setNull(42, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getBestDate() != null) {
            cstmt.setInt(43, tppUpdateSubscriber.getBestDate());
        } else {
            cstmt.setNull(43, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getRechargeFraudCounter_0() != null) {
            cstmt.setInt(44, tppUpdateSubscriber.getRechargeFraudCounter_0());
        } else {
            cstmt.setNull(44, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getRechargeFraudCounter_1() != null) {
            cstmt.setInt(45, tppUpdateSubscriber.getRechargeFraudCounter_1());
        } else {
            cstmt.setNull(45, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getRechargeFraudCounter_2() != null) {
            cstmt.setInt(46, tppUpdateSubscriber.getRechargeFraudCounter_2());
        } else {
            cstmt.setNull(46, Types.INTEGER);
        }

        cstmt.setDate(47, tppUpdateSubscriber.getEvaluationPeriodendDate());

        if (tppUpdateSubscriber.getSuspendedErrorFactor() != null) {
            cstmt.setInt(48, tppUpdateSubscriber.getSuspendedErrorFactor());
        } else {
            cstmt.setNull(48, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getSuspendedFraudFactor_0() != null) {
            cstmt.setInt(49, tppUpdateSubscriber.getSuspendedFraudFactor_0());
        } else {
            cstmt.setNull(49, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getSuspendedFraudFactor_1() != null) {
            cstmt.setInt(50, tppUpdateSubscriber.getSuspendedFraudFactor_1());
        } else {
            cstmt.setNull(50, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getSuspendedFraudFactor_2() != null) {
            cstmt.setInt(51, tppUpdateSubscriber.getSuspendedFraudFactor_2());
        } else {
            cstmt.setNull(51, Types.INTEGER);
        }

        cstmt.registerOutParameter(52, Types.INTEGER);
        cstmt.registerOutParameter(53, Types.DATE);
        cstmt.registerOutParameter(54, Types.INTEGER);
        cstmt.registerOutParameter(55, Types.DATE);
        cstmt.registerOutParameter(56, Types.INTEGER);
        cstmt.registerOutParameter(57, Types.DATE);

        if (tppUpdateSubscriber.getCycle() != null) {
            cstmt.setInt(58, tppUpdateSubscriber.getCycle());
        } else {
            cstmt.setNull(58, Types.INTEGER);
        }
        if (tppUpdateSubscriber.getNextProfile() != null) {
            cstmt.setInt(59, tppUpdateSubscriber.getNextProfile());
        } else {
            cstmt.setNull(59, Types.INTEGER);
        }

        cstmt.setDate(60, tppUpdateSubscriber.getStartDateRenewal());

        if (tppUpdateSubscriber.getAutoRenewal() != null) {
            cstmt.setInt(61, tppUpdateSubscriber.getAutoRenewal());
        } else {
            cstmt.setNull(61, Types.INTEGER);
        }

        cstmt.executeUpdate();
        return (short) cstmt.getInt(1);
    }

    public short fundTransferDFT(PaymentFundTransferDFTSubscriber fundTransferDFT) throws SQLException {

        CallableStatement cstmt = connection.prepareCall("{? = call ccard.PP_PAYMENT_INTERFACE.Fundtransfer_Dft(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.registerOutParameter(2, Types.VARCHAR);

        cstmt.setString(3, fundTransferDFT.getSubId());

        if (fundTransferDFT.getOperatorId() != null) {
            cstmt.setInt(4, fundTransferDFT.getOperatorId());
        } else {
            cstmt.setNull(4, Types.INTEGER);
        }
        if (fundTransferDFT.getTransactionType() != null) {
            cstmt.setInt(5, fundTransferDFT.getTransactionType());
        } else {
            cstmt.setNull(5, Types.INTEGER);
        }
        if (fundTransferDFT.getRechargeDiscount() != null) {
            cstmt.setInt(6, fundTransferDFT.getRechargeDiscount());
        } else {
            cstmt.setNull(6, Types.INTEGER);
        }
        if (fundTransferDFT.getAmount() != null) {
            cstmt.setInt(7, fundTransferDFT.getAmount());
        } else {
            cstmt.setNull(7, Types.INTEGER);
        }

        cstmt.setDate(8, fundTransferDFT.getExpiryDate());

        if (fundTransferDFT.getPeriodicAmount() != null) {
            cstmt.setInt(9, fundTransferDFT.getPeriodicAmount());
        } else {
            cstmt.setNull(9, Types.INTEGER);
        }

        cstmt.setDate(10, fundTransferDFT.getPeriodicExpiry());

        if (fundTransferDFT.getBonusAmount() != null) {
            cstmt.setInt(11, fundTransferDFT.getBonusAmount());
        } else {
            cstmt.setNull(11, Types.INTEGER);
        }

        cstmt.setDate(12, fundTransferDFT.getBonusExpiry());

        if (fundTransferDFT.getSmAmount() != null) {
            cstmt.setInt(13, fundTransferDFT.getSmAmount());
        } else {
            cstmt.setNull(13, Types.INTEGER);
        }

        cstmt.setDate(14, fundTransferDFT.getSmExpiry());

        if (fundTransferDFT.getDataAmount() != null) {
            cstmt.setInt(15, fundTransferDFT.getDataAmount());
        } else {
            cstmt.setNull(15, Types.INTEGER);
        }

        cstmt.setDate(16, fundTransferDFT.getDataExpiry());

        if (fundTransferDFT.getPromotionalBalanceDelta() != null) {
            cstmt.setInt(17, fundTransferDFT.getPromotionalBalanceDelta());
        } else {
            cstmt.setNull(17, Types.INTEGER);
        }

        cstmt.setDate(18, fundTransferDFT.getPromotionalExpiryDate());

        if (fundTransferDFT.getPromotionalPlanId() != null) {
            cstmt.setInt(19, fundTransferDFT.getPromotionalPlanId());
        } else {
            cstmt.setNull(19, Types.INTEGER);
        }

        if (fundTransferDFT.getBestDate() != null) {
            cstmt.setInt(20, fundTransferDFT.getBestDate());
        } else {
            cstmt.setNull(20, Types.INTEGER);
        }

        cstmt.registerOutParameter(21, Types.NUMERIC);
        cstmt.registerOutParameter(22, Types.NUMERIC);
        cstmt.registerOutParameter(23, Types.NUMERIC);
        cstmt.registerOutParameter(24, Types.NUMERIC);
        cstmt.registerOutParameter(25, Types.DATE);
        cstmt.registerOutParameter(26, Types.NUMERIC);
        cstmt.registerOutParameter(27, Types.NUMERIC);
        cstmt.registerOutParameter(28, Types.NUMERIC);
        cstmt.registerOutParameter(29, Types.DATE);
        cstmt.registerOutParameter(30, Types.NUMERIC);
        cstmt.registerOutParameter(31, Types.DATE);
        cstmt.registerOutParameter(32, Types.NUMERIC);
        cstmt.registerOutParameter(33, Types.DATE);
        cstmt.registerOutParameter(34, Types.NUMERIC);
        cstmt.registerOutParameter(35, Types.DATE);
        cstmt.registerOutParameter(36, Types.NUMERIC);
        cstmt.registerOutParameter(37, Types.DATE);
        cstmt.registerOutParameter(38, Types.NUMERIC);
        cstmt.registerOutParameter(39, Types.DATE);

        cstmt.executeUpdate();

        return (short) cstmt.getInt(1);
    }

    public short deleteSubscriber(String subid) throws SQLException {
        CallableStatement cstmt;
        if (DataBaseProperties.environment.equalsIgnoreCase(Environment.DEVELOP) && DataBaseProperties.country.equalsIgnoreCase(Country.ARGENTINA)) {
            cstmt = connection.prepareCall("{? = call PP_PROVISIONING_INTERFACE.delete_subscriber(?,?,?)}");
        } else {
            cstmt = connection.prepareCall("{? = call ccard.PP_PROVISIONING_INTERFACE.delete_subscriber(?,?,?)}");
        }

        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.setString(2, subid);
        cstmt.setNull(3, Types.INTEGER);
        cstmt.registerOutParameter(4, Types.VARCHAR);

        cstmt.executeUpdate();

        return (short) cstmt.getInt(1);
    }

    public short accountQuery(AccountQuery accountQuery) throws SQLException {

        CallableStatement cstmt = connection.prepareCall("{? = call ccard.PP_PAYMENT_INTERFACE.account_query(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.setNull(3, Types.INTEGER);
        cstmt.registerOutParameter(2, Types.VARCHAR);

        cstmt.setString(4, accountQuery.getSubId());

        if (accountQuery.getOperatorId() != null) {
            cstmt.setInt(5, accountQuery.getOperatorId());
        } else {
            cstmt.setNull(13, Types.INTEGER);
        }

        cstmt.registerOutParameter(6, Types.NUMERIC);
        cstmt.registerOutParameter(7, Types.NUMERIC);
        cstmt.registerOutParameter(8, Types.NUMERIC);
        cstmt.registerOutParameter(9, Types.NUMERIC);
        cstmt.registerOutParameter(10, Types.VARCHAR);
        cstmt.registerOutParameter(11, Types.NUMERIC);
        cstmt.registerOutParameter(12, Types.NUMERIC);
        cstmt.registerOutParameter(13, Types.VARCHAR);
        cstmt.registerOutParameter(14, Types.NUMERIC);
        cstmt.registerOutParameter(15, Types.NUMERIC);
        cstmt.registerOutParameter(16, Types.VARCHAR);
        cstmt.registerOutParameter(17, Types.NUMERIC);
        cstmt.registerOutParameter(18, Types.VARCHAR);
        cstmt.registerOutParameter(19, Types.NUMERIC);
        cstmt.registerOutParameter(20, Types.VARCHAR);
        cstmt.registerOutParameter(21, Types.NUMERIC);
        cstmt.registerOutParameter(22, Types.VARCHAR);
        cstmt.registerOutParameter(23, Types.NUMERIC);
        cstmt.registerOutParameter(24, Types.VARCHAR);
        cstmt.registerOutParameter(25, Types.NUMERIC);
        cstmt.registerOutParameter(26, Types.NUMERIC);
        cstmt.registerOutParameter(27, Types.VARCHAR);

        cstmt.executeUpdate();

        int resultCode = cstmt.getInt(1);
        if (resultCode == 0) {
            accountQuery.setPeDescription(cstmt.getString(2));
            accountQuery.setTransferResult(cstmt.getInt(6));
            accountQuery.setAccountBalance(cstmt.getInt(7));
            accountQuery.setServiceStatus(cstmt.getInt(8));
            accountQuery.setAccountStatus(cstmt.getInt(9));
            accountQuery.setExpiryDate(Utils.getDateFromString(cstmt.getString(10)));
            accountQuery.setProfileId(cstmt.getInt(11));
            accountQuery.setSubOptions(cstmt.getInt(12));
            accountQuery.setIvrQueryExpiryDate(Utils.getDateFromString(cstmt.getString(13)));
            accountQuery.setIvrQueryCounter(cstmt.getInt(14));
            accountQuery.setAmountBalance(cstmt.getInt(15));
            accountQuery.setLastrechargedate(Utils.getDateFromString(cstmt.getString(16)));
            accountQuery.setPeriodicBalance(cstmt.getInt(17));
            accountQuery.setPeriodicExpiry(Utils.getDateFromString(cstmt.getString(18)));
            accountQuery.setBonusBalance(cstmt.getInt(19));
            accountQuery.setBonusExpiry(Utils.getDateFromString(cstmt.getString(20)));
            accountQuery.setSmBalance(cstmt.getInt(21));
            accountQuery.setSmExpiry(Utils.getDateFromString(cstmt.getString(22)));
            accountQuery.setDataBalance(cstmt.getInt(23));
            accountQuery.setDataExpiry(Utils.getDateFromString(cstmt.getString(24)));
            accountQuery.setOverDraftBalance(cstmt.getInt(25));
            accountQuery.setVoiceBalance4(cstmt.getInt(26));
            accountQuery.setVoiceExpiry4(Utils.getDateFromString(cstmt.getString(27)));
        }
        return (short) resultCode;
    }

    public FundAccountTransfeResponse FundAccountTransferOFT(FundAccountTransferRequest request) throws Exception {

        FundAccountTransfeResponse response = new FundAccountTransfeResponse();
        CallableStatement cstmt = connection.prepareCall("{? = call ccard.PP_PAYMENT_INTERFACE.Fund_Account_Transfer(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.registerOutParameter(15, Types.VARCHAR);
        cstmt.registerOutParameter(16, Types.NUMERIC);
        cstmt.registerOutParameter(17, Types.NUMERIC);
        cstmt.registerOutParameter(18, Types.NUMERIC);
        cstmt.registerOutParameter(19, Types.DATE);
        cstmt.registerOutParameter(20, Types.NUMERIC);
        cstmt.registerOutParameter(21, Types.NUMERIC);
        cstmt.registerOutParameter(22, Types.DATE);
        cstmt.registerOutParameter(23, Types.NUMERIC);
        cstmt.registerOutParameter(24, Types.NUMERIC);
        cstmt.registerOutParameter(25, Types.DATE);

        cstmt.setString(2, request.getSubid());

        if (request.getOperatorId() != null) {
            cstmt.setInt(3, request.getOperatorId());
        } else {
            cstmt.setNull(3, Types.INTEGER);
        }

        if (request.getTransactionType() != null) {
            cstmt.setInt(4, request.getTransactionType());
        } else {
            cstmt.setNull(4, Types.INTEGER);
        }

        if (request.getRechargeDiscount() != null) {
            cstmt.setInt(5, request.getRechargeDiscount());
        } else {
            cstmt.setNull(5, Types.INTEGER);
        }

        cstmt.setString(6, request.getCorrelationId());

        if (request.getDeltaAmount() != null) {
            cstmt.setInt(7, request.getDeltaAmount());
        } else {
            cstmt.setNull(7, Types.INTEGER);
        }

        if (request.getNoFailonInsuficcientFunds() != null) {
            cstmt.setInt(8, request.getNoFailonInsuficcientFunds());
        } else {
            cstmt.setNull(8, Types.INTEGER);
        }

        if (request.getTrafficType() != null) {
            cstmt.setInt(9, request.getTrafficType());
        } else {
            cstmt.setNull(9, Types.INTEGER);
        }

        if (request.getAccountType() != null) {
            cstmt.setInt(10, request.getAccountType());
        } else {
            cstmt.setNull(10, Types.INTEGER);
        }

        if (request.getBalanceId() != null) {
            cstmt.setInt(11, request.getBalanceId());
        } else {
            cstmt.setNull(11, Types.INTEGER);
        }

        if (request.getBalanceDelta() != null) {
            cstmt.setInt(12, request.getBalanceDelta());
        } else {
            cstmt.setNull(12, Types.INTEGER);
        }

        cstmt.setDate(13, request.getExpiryDate());

        if (request.getBestDate() != null) {
            cstmt.setInt(14, request.getBestDate());
        } else {
            cstmt.setNull(14, Types.INTEGER);
        }

        cstmt.executeUpdate();

        response.setResultCode(cstmt.getInt(1));

        if (response.getResultCode() == 0) {
            response.setDescription(cstmt.getString(15));
            response.setTariffPlan(cstmt.getInt(16));
            response.setBalanceAmountMain(cstmt.getInt(17));
            response.setBalanceUnitsMain(cstmt.getInt(18));
            response.setBalanceExpiryMain(cstmt.getDate(19));
            response.setBalanceAmountBonus(cstmt.getInt(20));
            response.setBalanceUnitsBonus(cstmt.getInt(21));
            response.setBalanceExpiryBonus(cstmt.getDate(22));
            response.setBalanceAmountBonus2(cstmt.getInt(23));
            response.setBalanceUnitsBonus2(cstmt.getInt(24));
            response.setBalanceExpiryBonus2(cstmt.getDate(25));
        }
        return response;
    }

    public GetSubscriberResponse GetSubscriber(String subId) throws Exception {

        GetSubscriberResponse subscriber = new GetSubscriberResponse();

        CallableStatement cstmt = connection.prepareCall("{? = call PP_PP_SERVER.Get_Subscriber(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        cstmt.registerOutParameter(1, Types.NUMERIC);

        cstmt.registerOutParameter(3, Types.VARCHAR); // peDescription
        cstmt.registerOutParameter(4, Types.VARCHAR); // accountNumber
        cstmt.registerOutParameter(5, Types.VARCHAR); // imSi
        cstmt.registerOutParameter(6, Types.VARCHAR); // smId
        cstmt.registerOutParameter(7, Types.NUMERIC); // smOnAtSubLevel
        cstmt.registerOutParameter(8, Types.NUMERIC); // serviceStatus
        cstmt.registerOutParameter(9, Types.NUMERIC); // accountStatus
        cstmt.registerOutParameter(10, Types.NUMERIC); // accountBalance
        cstmt.registerOutParameter(11, Types.NUMERIC); // languageId
        cstmt.registerOutParameter(12, Types.NUMERIC); // profileId
        cstmt.registerOutParameter(13, Types.NUMERIC); // currentTarrifPlanId
        cstmt.registerOutParameter(14, Types.NUMERIC); // totalRechargeErrorCounter
        cstmt.registerOutParameter(15, Types.DATE); //  suspendDate
        cstmt.registerOutParameter(16, Types.DATE); // activationDate
        cstmt.registerOutParameter(17, Types.DATE); // expiryDate
        cstmt.registerOutParameter(18, Types.DATE); // ivrQueryExpiryDate

        cstmt.registerOutParameter(19, Types.VARCHAR); // familyAndFriends
        cstmt.registerOutParameter(20, Types.DATE); // ffExpiry
        cstmt.registerOutParameter(21, Types.NUMERIC); // ffDiscount

        cstmt.registerOutParameter(22, Types.NUMERIC); // smPackageId
        cstmt.registerOutParameter(23, Types.NUMERIC); // smPackageIdNext
        cstmt.registerOutParameter(24, Types.NUMERIC); // smPackageCounter
        cstmt.registerOutParameter(25, Types.DATE); // smPackageExpiry
        cstmt.registerOutParameter(26, Types.NUMERIC); // smPackageNotificationStatus;

        cstmt.registerOutParameter(27, Types.NUMERIC); // rechargeCount
        cstmt.registerOutParameter(28, Types.DATE); // rechargeBonusExpiry

        cstmt.registerOutParameter(29, Types.NUMERIC); // periodicBalance
        cstmt.registerOutParameter(30, Types.DATE); // periodicExpiry

        cstmt.registerOutParameter(31, Types.NUMERIC); // bonusBalance
        cstmt.registerOutParameter(32, Types.DATE); // bonusExpiry

        cstmt.registerOutParameter(33, Types.NUMERIC); // smBalance
        cstmt.registerOutParameter(34, Types.DATE); // smExpiry

        cstmt.registerOutParameter(35, Types.NUMERIC); // dataBalance
        cstmt.registerOutParameter(36, Types.DATE); // dataExpiry

        cstmt.registerOutParameter(37, Types.DATE); //  lastRechargeDate

        cstmt.registerOutParameter(38, Types.NUMERIC); // perSubsBlockOnAtSubLevel

        cstmt.registerOutParameter(39, Types.NUMERIC); // fixedLineServOnAtSubLevel
        cstmt.registerOutParameter(40, Types.NUMERIC); // dbRefId
        cstmt.registerOutParameter(41, Types.NUMERIC); // periodicTariffPlan
        cstmt.registerOutParameter(42, Types.NUMERIC); // reservationCounter
        cstmt.registerOutParameter(43, Types.NUMERIC); // lastReservationId
        cstmt.registerOutParameter(44, Types.NUMERIC); // lowBalSmBlockingSet
        cstmt.registerOutParameter(45, Types.NUMERIC); // mainReservationAmount
        cstmt.registerOutParameter(46, Types.NUMERIC); // periodicReservationAmount
        cstmt.registerOutParameter(47, Types.NUMERIC); // bonusReservationAmount
        cstmt.registerOutParameter(48, Types.NUMERIC); // smReservationAmount
        cstmt.registerOutParameter(49, Types.NUMERIC); // dataReservationAmount

        cstmt.registerOutParameter(50, Types.VARCHAR); // incomingCollectCallList
        cstmt.registerOutParameter(51, Types.VARCHAR); // outGoingCollectCallList

        cstmt.registerOutParameter(52, Types.NUMERIC); // localCollectCallOnAtSubLevel

        cstmt.registerOutParameter(53, Types.NUMERIC); // voiceBalance4
        cstmt.registerOutParameter(54, Types.DATE); // voiceExpiry4

        cstmt.registerOutParameter(55, Types.DATE); // loyaltyAccumulationDate
        cstmt.registerOutParameter(56, Types.NUMERIC); // loyaltyAccumulationQuantity
        cstmt.registerOutParameter(57, Types.NUMERIC); // loyaltyTariffPlanId
        cstmt.registerOutParameter(58, Types.DATE); // loyaltyTariffPlanExpiry

        cstmt.registerOutParameter(59, Types.DATE); // accountStatusChangeDate

        cstmt.registerOutParameter(60, Types.NUMERIC); // rechargeFraudCounter0
        cstmt.registerOutParameter(61, Types.NUMERIC); // rechargeFraudCounter1
        cstmt.registerOutParameter(62, Types.NUMERIC); // rechargeFraudCounter2

        cstmt.registerOutParameter(63, Types.DATE); // evaluationPeriodEndDate

        cstmt.registerOutParameter(64, Types.NUMERIC); // suspendedErrorFactor
        cstmt.registerOutParameter(65, Types.NUMERIC); // suspendedFraudFactor0
        cstmt.registerOutParameter(66, Types.NUMERIC); // suspendedFraudFactor1
        cstmt.registerOutParameter(67, Types.NUMERIC); // suspendedFraudFactor2

        cstmt.registerOutParameter(68, Types.NUMERIC); // ffOnAtSubLevel
        cstmt.registerOutParameter(69, Types.NUMERIC); // cycle
        cstmt.registerOutParameter(70, Types.NUMERIC); // nextProfile

        cstmt.registerOutParameter(71, Types.DATE); // startDateRenewal
        cstmt.registerOutParameter(72, Types.NUMERIC); // autoRenewal;

        cstmt.setString(2, subId);

        cstmt.executeUpdate();

        subscriber.setResultCode(cstmt.getInt(1));

        if (subscriber.getResultCode() == 0) {

            subscriber.setSubId(subId);

            //main
            subscriber.setAccountBalance(cstmt.getInt(10));
            subscriber.setExpiryDate(cstmt.getDate(17));
            //bonus
            subscriber.setBonusBalance(cstmt.getInt(31));
            subscriber.setBonusExpiry(cstmt.getDate(32));

        }
        return subscriber;
    }

    public UpdateSubBalanceQueueSlotResponse getUpdateSubBalanceQueueSlotResponse(String subId, Integer balanceType, Integer accountType, Integer slotNumber, Integer balanceValue, String balanceExpiry, Integer operatorId) throws Exception {

        UpdateSubBalanceQueueSlotResponse subscriber = new UpdateSubBalanceQueueSlotResponse();
        CallableStatement cstmt = connection.prepareCall("{? = call ccard.PP_PP_SERVER.Update_Sub_Balance_Queue_Slot(?,?,?,?,?,?,?,?)}");

        //in
        cstmt.setString(2, subId);
        cstmt.setInt(3, balanceType);
        cstmt.setInt(4, accountType);
        cstmt.setInt(5, slotNumber);
        cstmt.setInt(6, balanceValue);
        cstmt.setString(7, balanceExpiry);
        cstmt.setInt(8, operatorId);

        //out
        cstmt.registerOutParameter(1, Types.NUMERIC); // peDescription
        cstmt.registerOutParameter(9, Types.VARCHAR); // return

        //set objeto con datos de entrada
        subscriber.setSubId(subId);
        subscriber.setBalanceType(balanceType);
        subscriber.setAccountType(accountType);
        subscriber.setSlotNumber(slotNumber);
        subscriber.setBalanceValue(balanceValue);
        subscriber.setBalanceExpiry(balanceExpiry);
        subscriber.setOperatorId(operatorId);

        //ejecuta la api de TN3
        cstmt.executeUpdate();

        //set valores salida
        subscriber.setResultCode(cstmt.getInt(1));
        subscriber.setPeDescription(cstmt.getString(9));

        return subscriber;
    }

}