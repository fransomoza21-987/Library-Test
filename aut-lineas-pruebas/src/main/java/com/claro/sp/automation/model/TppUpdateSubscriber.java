package com.claro.sp.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class TppUpdateSubscriber {

    private String subId;
    private Integer operatorId;
    private String accountNumber;
    private String imsi;
    private String smid;
    private Integer smonatSubLevel;
    private Integer serviceStatus;
    private Integer accountStatus;
    private Integer accountBalance;
    private Integer languageId;
    private Integer profileId;
    private Date suspendDate;
    private Date activationDate;
    private Date expiryDate;
    private Date ivrQueryExpiryDate;
    private String familyAndFriends;
    private Date ffExpiry;
    private Integer ffDiscount;
    private Integer ffonatSubLevel;
    private Integer smpPckageId;
    private Integer smPackageIdNext;
    private Integer smPackageCounter;
    private Date smPackageExpiry;
    private Integer smPackageNotificationStatus;
    private Integer rechargeCount;
    private Date rechargeBonusExpiry;
    private Integer bonusBalance;
    private Date bonusExpiry;
    private Integer periodicTariffPlan;
    private Integer reservationCounter;
    private Integer lastReservationId;
    private Integer lowBalancesmBlockingSet;
    private Integer mainrRservationAmount;
    private Integer bonusReservationAmount;
    private Integer smReservationAmount;
    private Integer dataReservationAmount;
    private String incomingCollectCallList;
    private String outgoingCollectcallList;
    private Integer localCollectCallonatSubLevel;
    private Integer totalRechargeErrorCounter;
    private Integer bestDate;
    private Integer rechargeFraudCounter_0;
    private Integer rechargeFraudCounter_1;
    private Integer rechargeFraudCounter_2;
    private Date evaluationPeriodendDate;
    private Integer suspendedErrorFactor;
    private Integer suspendedFraudFactor_0;
    private Integer suspendedFraudFactor_1;
    private Integer suspendedFraudFactor_2;
    private Integer cycle;
    private Integer nextProfile;
    private Date startDateRenewal;
    private Integer autoRenewal;

    public TppUpdateSubscriber() {
        super();
    }
}
