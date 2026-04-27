package com.claro.sp.automation.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class GetSubscriberResponse {

    private int resultCode;
    private String subId;
    private String peDescription;
    private String accountNumber;
    private String imSi;
    private String smId;
    private Integer smOnAtSubLevel;
    private Integer serviceStatus;
    private Integer accountStatus;
    private Integer accountBalance;
    private Integer languageId;
    private Integer profileId;
    private Integer currentTarrifPlanId;
    private Integer totalRechargeErrorCounter;
    private Date suspendDate;
    private Date activationDate;
    private Date expiryDate;
    private Date ivrQueryExpiryDate;
    private String familyAndFriends;
    private Date ffExpiry;
    private Integer ffDiscount;
    private Integer smPackageId;
    private Integer smPackageIdNext;
    private Integer smPackageCounter;
    private Date smPackageExpiry;
    private Integer smPackageNotificationStatus;
    private Integer rechargeCount;
    private Date rechargeBonusExpiry;
    private Integer periodicBalance;
    private Date periodicExpiry;
    private Integer bonusBalance;
    private Date bonusExpiry;
    private Integer smBalance;
    private Date smExpiry;
    private Integer dataBalance;
    private Date dataExpiry;
    private Date lastRechargeDate;
    private Integer perSubsBlockOnAtSubLevel;
    private Integer fixedLineServOnAtSubLevel;
    private Integer dbRefId;
    private Integer periodicTariffPlan;
    private Integer reservationCounter;
    private Integer lastReservationId;
    private Integer lowBalSmBlockingSet;
    private Integer mainReservationAmount;
    private Integer periodicReservationAmount;
    private Integer bonusReservationAmount;
    private Integer smReservationAmount;
    private Integer dataReservationAmount;
    private String incomingCollectCallList;
    private String outGoingCollectCallList;
    private Integer localCollectCallOnAtSubLevel;
    private Integer voiceBalance4;
    private Date voiceExpiry4;
    private Date loyaltyAccumulationDate;
    private Integer loyaltyAccumulationQuantity;
    private Integer loyaltyTariffPlanId;
    private Date loyaltyTariffPlanExpiry;
    private Date accountStatusChangeDate;
    private Integer rechargeFraudCounter0;
    private Integer rechargeFraudCounter1;
    private Integer rechargeFraudCounter2;
    private Date evaluationPeriodEndDate;
    private Integer suspendedErrorFactor;
    private Integer suspendedFraudFactor0;
    private Integer suspendedFraudFactor1;
    private Integer suspendedFraudFactor2;
    private Integer ffOnAtSubLevel;
    private Integer cycle;
    private Integer nextProfile;
    private Date startDateRenewal;
    private Integer autoRenewal;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getPeDescription() {
        return peDescription;
    }

    public void setPeDescription(String peDescription) {
        this.peDescription = peDescription;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getImSi() {
        return imSi;
    }

    public void setImSi(String imSi) {
        this.imSi = imSi;
    }

    public String getSmId() {
        return smId;
    }

    public void setSmId(String smId) {
        this.smId = smId;
    }

    public Integer getSmOnAtSubLevel() {
        return smOnAtSubLevel;
    }

    public void setSmOnAtSubLevel(int smOnAtSubLevel) {
        this.smOnAtSubLevel = smOnAtSubLevel;
    }

    public Integer getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public Integer getCurrentTarrifPlanId() {
        return currentTarrifPlanId;
    }

    public void setCurrentTarrifPlanId(int currentTarrifPlanId) {
        this.currentTarrifPlanId = currentTarrifPlanId;
    }

    public Integer getTotalRechargeErrorCounter() {
        return totalRechargeErrorCounter;
    }

    public void setTotalRechargeErrorCounter(int totalRechargeErrorCounter) {
        this.totalRechargeErrorCounter = totalRechargeErrorCounter;
    }

    public Date getSuspendDate() {
        return suspendDate;
    }

    public void setSuspendDate(Date suspendDate) {
        this.suspendDate = suspendDate;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getIvrQueryExpiryDate() {
        return ivrQueryExpiryDate;
    }

    public void setIvrQueryExpiryDate(Date ivrQueryExpiryDate) {
        this.ivrQueryExpiryDate = ivrQueryExpiryDate;
    }

    public String getFamilyAndFriends() {
        return familyAndFriends;
    }

    public void setFamilyAndFriends(String familyAndFriends) {
        this.familyAndFriends = familyAndFriends;
    }

    public Date getFfExpiry() {
        return ffExpiry;
    }

    public void setFfExpiry(Date ffExpiry) {
        this.ffExpiry = ffExpiry;
    }

    public Integer getFfDiscount() {
        return ffDiscount;
    }

    public void setFfDiscount(int ffDiscount) {
        this.ffDiscount = ffDiscount;
    }

    public Integer getSmPackageId() {
        return smPackageId;
    }

    public void setSmPackageId(int smPackageId) {
        this.smPackageId = smPackageId;
    }

    public Integer getSmPackageIdNext() {
        return smPackageIdNext;
    }

    public void setSmPackageIdNext(int smPackageIdNext) {
        this.smPackageIdNext = smPackageIdNext;
    }

    public Integer getSmPackageCounter() {
        return smPackageCounter;
    }

    public void setSmPackageCounter(int smPackageCounter) {
        this.smPackageCounter = smPackageCounter;
    }

    public Date getSmPackageExpiry() {
        return smPackageExpiry;
    }

    public void setSmPackageExpiry(Date smPackageExpiry) {
        this.smPackageExpiry = smPackageExpiry;
    }

    public Integer getSmPackageNotificationStatus() {
        return smPackageNotificationStatus;
    }

    public void setSmPackageNotificationStatus(int smPackageNotificationStatus) {
        this.smPackageNotificationStatus = smPackageNotificationStatus;
    }

    public Integer getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(int rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public Date getRechargeBonusExpiry() {
        return rechargeBonusExpiry;
    }

    public void setRechargeBonusExpiry(Date rechargeBonusExpiry) {
        this.rechargeBonusExpiry = rechargeBonusExpiry;
    }

    public Integer getPeriodicBalance() {
        return periodicBalance;
    }

    public void setPeriodicBalance(int periodicBalance) {
        this.periodicBalance = periodicBalance;
    }

    public Date getPeriodicExpiry() {
        return periodicExpiry;
    }

    public void setPeriodicExpiry(Date periodicExpiry) {
        this.periodicExpiry = periodicExpiry;
    }

    public Integer getBonusBalance() {
        return bonusBalance;
    }

    public void setBonusBalance(int bonusBalance) {
        this.bonusBalance = bonusBalance;
    }

    public Date getBonusExpiry() {
        return bonusExpiry;
    }

    public void setBonusExpiry(Date bonusExpiry) {
        this.bonusExpiry = bonusExpiry;
    }

    public Integer getSmBalance() {
        return smBalance;
    }

    public void setSmBalance(int smBalance) {
        this.smBalance = smBalance;
    }

    public Date getSmExpiry() {
        return smExpiry;
    }

    public void setSmExpiry(Date smExpiry) {
        this.smExpiry = smExpiry;
    }

    public Integer getDataBalance() {
        return dataBalance;
    }

    public void setDataBalance(int dataBalance) {
        this.dataBalance = dataBalance;
    }

    public Date getDataExpiry() {
        return dataExpiry;
    }

    public void setDataExpiry(Date dataExpiry) {
        this.dataExpiry = dataExpiry;
    }

    public Date getLastRechargeDate() {
        return lastRechargeDate;
    }

    public void setLastRechargeDate(Date lastRechargeDate) {
        this.lastRechargeDate = lastRechargeDate;
    }

    public Integer getPerSubsBlockOnAtSubLevel() {
        return perSubsBlockOnAtSubLevel;
    }

    public void setPerSubsBlockOnAtSubLevel(int perSubsBlockOnAtSubLevel) {
        this.perSubsBlockOnAtSubLevel = perSubsBlockOnAtSubLevel;
    }

    public Integer getFixedLineServOnAtSubLevel() {
        return fixedLineServOnAtSubLevel;
    }

    public void setFixedLineServOnAtSubLevel(int fixedLineServOnAtSubLevel) {
        this.fixedLineServOnAtSubLevel = fixedLineServOnAtSubLevel;
    }

    public Integer getDbRefId() {
        return dbRefId;
    }

    public void setDbRefId(int dbRefId) {
        this.dbRefId = dbRefId;
    }

    public Integer getPeriodicTariffPlan() {
        return periodicTariffPlan;
    }

    public void setPeriodicTariffPlan(int periodicTariffPlan) {
        this.periodicTariffPlan = periodicTariffPlan;
    }

    public Integer getReservationCounter() {
        return reservationCounter;
    }

    public void setReservationCounter(int reservationCounter) {
        this.reservationCounter = reservationCounter;
    }

    public Integer getLastReservationId() {
        return lastReservationId;
    }

    public void setLastReservationId(int lastReservationId) {
        this.lastReservationId = lastReservationId;
    }

    public Integer getLowBalSmBlockingSet() {
        return lowBalSmBlockingSet;
    }

    public void setLowBalSmBlockingSet(int lowBalSmBlockingSet) {
        this.lowBalSmBlockingSet = lowBalSmBlockingSet;
    }

    public Integer getMainReservationAmount() {
        return mainReservationAmount;
    }

    public void setMainReservationAmount(int mainReservationAmount) {
        this.mainReservationAmount = mainReservationAmount;
    }

    public Integer getPeriodicReservationAmount() {
        return periodicReservationAmount;
    }

    public void setPeriodicReservationAmount(int periodicReservationAmount) {
        this.periodicReservationAmount = periodicReservationAmount;
    }

    public Integer getBonusReservationAmount() {
        return bonusReservationAmount;
    }

    public void setBonusReservationAmount(int bonusReservationAmount) {
        this.bonusReservationAmount = bonusReservationAmount;
    }

    public Integer getSmReservationAmount() {
        return smReservationAmount;
    }

    public void setSmReservationAmount(int smReservationAmount) {
        this.smReservationAmount = smReservationAmount;
    }

    public Integer getDataReservationAmount() {
        return dataReservationAmount;
    }

    public void setDataReservationAmount(int dataReservationAmount) {
        this.dataReservationAmount = dataReservationAmount;
    }

    public String getIncomingCollectCallList() {
        return incomingCollectCallList;
    }

    public void setIncomingCollectCallList(String incomingCollectCallList) {
        this.incomingCollectCallList = incomingCollectCallList;
    }

    public String getOutGoingCollectCallList() {
        return outGoingCollectCallList;
    }

    public void setOutGoingCollectCallList(String outGoingCollectCallList) {
        this.outGoingCollectCallList = outGoingCollectCallList;
    }

    public Integer getLocalCollectCallOnAtSubLevel() {
        return localCollectCallOnAtSubLevel;
    }

    public void setLocalCollectCallOnAtSubLevel(int localCollectCallOnAtSubLevel) {
        this.localCollectCallOnAtSubLevel = localCollectCallOnAtSubLevel;
    }

    public Integer getVoiceBalance4() {
        return voiceBalance4;
    }

    public void setVoiceBalance4(int voiceBalance4) {
        this.voiceBalance4 = voiceBalance4;
    }

    public Date getVoiceExpiry4() {
        return voiceExpiry4;
    }

    public void setVoiceExpiry4(Date voiceExpiry4) {
        this.voiceExpiry4 = voiceExpiry4;
    }

    public Date getLoyaltyAccumulationDate() {
        return loyaltyAccumulationDate;
    }

    public void setLoyaltyAccumulationDate(Date loyaltyAccumulationDate) {
        this.loyaltyAccumulationDate = loyaltyAccumulationDate;
    }

    public Integer getLoyaltyAccumulationQuantity() {
        return loyaltyAccumulationQuantity;
    }

    public void setLoyaltyAccumulationQuantity(int loyaltyAccumulationQuantity) {
        this.loyaltyAccumulationQuantity = loyaltyAccumulationQuantity;
    }

    public Integer getLoyaltyTariffPlanId() {
        return loyaltyTariffPlanId;
    }

    public void setLoyaltyTariffPlanId(int loyaltyTariffPlanId) {
        this.loyaltyTariffPlanId = loyaltyTariffPlanId;
    }

    public Date getLoyaltyTariffPlanExpiry() {
        return loyaltyTariffPlanExpiry;
    }

    public void setLoyaltyTariffPlanExpiry(Date loyaltyTariffPlanExpiry) {
        this.loyaltyTariffPlanExpiry = loyaltyTariffPlanExpiry;
    }

    public Date getAccountStatusChangeDate() {
        return accountStatusChangeDate;
    }

    public void setAccountStatusChangeDate(Date accountStatusChangeDate) {
        this.accountStatusChangeDate = accountStatusChangeDate;
    }

    public Integer getRechargeFraudCounter0() {
        return rechargeFraudCounter0;
    }

    public void setRechargeFraudCounter0(int rechargeFraudCounter0) {
        this.rechargeFraudCounter0 = rechargeFraudCounter0;
    }

    public Integer getRechargeFraudCounter1() {
        return rechargeFraudCounter1;
    }

    public void setRechargeFraudCounter1(int rechargeFraudCounter1) {
        this.rechargeFraudCounter1 = rechargeFraudCounter1;
    }

    public Integer getRechargeFraudCounter2() {
        return rechargeFraudCounter2;
    }

    public void setRechargeFraudCounter2(int rechargeFraudCounter2) {
        this.rechargeFraudCounter2 = rechargeFraudCounter2;
    }

    public Date getEvaluationPeriodEndDate() {
        return evaluationPeriodEndDate;
    }

    public void setEvaluationPeriodEndDate(Date evaluationPeriodEndDate) {
        this.evaluationPeriodEndDate = evaluationPeriodEndDate;
    }

    public Integer getSuspendedErrorFactor() {
        return suspendedErrorFactor;
    }

    public void setSuspendedErrorFactor(int suspendedErrorFactor) {
        this.suspendedErrorFactor = suspendedErrorFactor;
    }

    public Integer getSuspendedFraudFactor0() {
        return suspendedFraudFactor0;
    }

    public void setSuspendedFraudFactor0(int suspendedFraudFactor0) {
        this.suspendedFraudFactor0 = suspendedFraudFactor0;
    }

    public Integer getSuspendedFraudFactor1() {
        return suspendedFraudFactor1;
    }

    public void setSuspendedFraudFactor1(int suspendedFraudFactor1) {
        this.suspendedFraudFactor1 = suspendedFraudFactor1;
    }

    public Integer getSuspendedFraudFactor2() {
        return suspendedFraudFactor2;
    }

    public void setSuspendedFraudFactor2(int suspendedFraudFactor2) {
        this.suspendedFraudFactor2 = suspendedFraudFactor2;
    }

    public Integer getFfOnAtSubLevel() {
        return ffOnAtSubLevel;
    }

    public void setFfOnAtSubLevel(int ffOnAtSubLevel) {
        this.ffOnAtSubLevel = ffOnAtSubLevel;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public Integer getNextProfile() {
        return nextProfile;
    }

    public void setNextProfile(int nextProfile) {
        this.nextProfile = nextProfile;
    }

    public Date getStartDateRenewal() {
        return startDateRenewal;
    }

    public void setStartDateRenewal(Date startDateRenewal) {
        this.startDateRenewal = startDateRenewal;
    }

    public Integer getAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(int autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public List<String[]> getListField(String title, String description, String[] field) {
        List<String[]> list = new ArrayList<>();
        String[] column = new String[field.length];
        String[] value = new String[field.length];
        String[] titl = new String[field.length];
        String[] descriptio = new String[field.length];

        titl[0] = title;
        descriptio[0] = description;

        list.add(descriptio);
        list.add(titl);

        for (int x = 0; x < field.length; x++) {
            switch (field[x]) {
                case "subId": {
                    column[x] = field[x];
                    if (String.valueOf(this.getSubId()) != null) {
                        value[x] = String.valueOf(this.getSubId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "peDescription": {
                    column[x] = field[x];
                    if (String.valueOf(this.getPeDescription()) != null) {
                        value[x] = String.valueOf(this.getPeDescription());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "accountNumber": {
                    column[x] = field[x];
                    if (String.valueOf(this.getAccountNumber()) != null) {
                        value[x] = String.valueOf(this.getAccountNumber());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "imSi": {
                    column[x] = field[x];
                    if (String.valueOf(this.getImSi()) != null) {
                        value[x] = String.valueOf(this.getImSi());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smId": {
                    column[x] = field[x];
                    if (String.valueOf(this.getSmId()) != null) {
                        value[x] = String.valueOf(this.getSmId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smOnAtSubLevel": {
                    column[x] = field[x];
                    if (this.getSmOnAtSubLevel() != null) {
                        value[x] = String.valueOf(this.getSmOnAtSubLevel());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "serviceStatus": {
                    column[x] = field[x];
                    if (this.getServiceStatus() != null) {
                        value[x] = String.valueOf(this.getServiceStatus());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "accountStatus": {
                    column[x] = field[x];
                    if (this.getAccountStatus() != null) {
                        value[x] = String.valueOf(this.getServiceStatus());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "accountBalance": {
                    column[x] = field[x];
                    if (this.getAccountBalance() != null) {
                        value[x] = String.valueOf(this.getAccountBalance());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "languageId": {
                    column[x] = field[x];
                    if (this.getLanguageId() != null) {
                        value[x] = String.valueOf(this.getLanguageId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "profileId": {
                    column[x] = field[x];
                    if (this.getProfileId() != null) {
                        value[x] = String.valueOf(this.getProfileId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "currentTarrifPlanId": {
                    column[x] = field[x];
                    if (this.getCurrentTarrifPlanId() != null) {
                        value[x] = String.valueOf(this.getCurrentTarrifPlanId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "totalRechargeErrorCounter": {
                    column[x] = field[x];
                    if (this.getTotalRechargeErrorCounter() != null) {
                        value[x] = String.valueOf(this.getTotalRechargeErrorCounter());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "suspendDate": {
                    column[x] = field[x];
                    if (this.getSuspendDate() != null) {
                        value[x] = String.valueOf(this.getSuspendDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "activationDate": {
                    column[x] = field[x];
                    if (this.getActivationDate() != null) {
                        value[x] = String.valueOf(this.getActivationDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "expiryDate": {
                    column[x] = field[x];
                    if (this.getExpiryDate() != null) {
                        value[x] = String.valueOf(this.getExpiryDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "ivrQueryExpiryDate": {
                    column[x] = field[x];
                    if (this.getIvrQueryExpiryDate() != null) {
                        value[x] = String.valueOf(this.getIvrQueryExpiryDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "familyAndFriends": {
                    column[x] = field[x];
                    if (this.getFamilyAndFriends() != null) {
                        value[x] = this.getFamilyAndFriends();
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "ffExpiry": {
                    column[x] = field[x];
                    if (this.getFfExpiry() != null) {
                        value[x] = String.valueOf(this.getFfExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "ffDiscount": {
                    column[x] = field[x];
                    if (this.getFfDiscount() != null) {
                        value[x] = String.valueOf(this.getFfDiscount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smPackageId": {
                    column[x] = field[x];
                    if (this.getSmPackageId() != null) {
                        value[x] = String.valueOf(this.getSmPackageId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smPackageIdNext": {
                    column[x] = field[x];
                    if (this.getSmPackageIdNext() != null) {
                        value[x] = String.valueOf(this.getSmPackageIdNext());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smPackageCounter": {
                    column[x] = field[x];
                    if (this.getSmPackageCounter() != null) {
                        value[x] = String.valueOf(this.getSmPackageCounter());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smPackageExpiry": {
                    column[x] = field[x];
                    if (this.getSmPackageExpiry() != null) {
                        value[x] = String.valueOf(this.getSmPackageExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smPackageNotificationStatus": {
                    column[x] = field[x];
                    if (this.getSmPackageNotificationStatus() != null) {
                        value[x] = String.valueOf(this.getSmPackageNotificationStatus());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "rechargeCount": {
                    column[x] = field[x];
                    if (this.getRechargeCount() != null) {
                        value[x] = String.valueOf(this.getRechargeCount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "rechargeBonusExpiry": {
                    column[x] = field[x];
                    if (this.getRechargeBonusExpiry() != null) {
                        value[x] = String.valueOf(this.getRechargeBonusExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "periodicBalance": {
                    column[x] = field[x];
                    if (this.getPeriodicBalance() != null) {
                        value[x] = String.valueOf(this.getPeriodicBalance());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "periodicExpiry": {
                    column[x] = field[x];
                    if (this.getPeriodicExpiry() != null) {
                        value[x] = String.valueOf(this.getPeriodicExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "bonusBalance": {
                    column[x] = field[x];
                    if (this.getBonusBalance() != null) {
                        value[x] = String.valueOf(this.getBonusBalance());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "bonusExpiry": {
                    column[x] = field[x];
                    if (this.getBonusExpiry() != null) {
                        value[x] = String.valueOf(this.getBonusExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smBalance": {
                    column[x] = field[x];
                    if (this.getSmBalance() != null) {
                        value[x] = String.valueOf(this.getSmBalance());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smExpiry": {
                    column[x] = field[x];
                    if (this.getSmExpiry() != null) {
                        value[x] = String.valueOf(this.getSmExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "dataBalance": {
                    column[x] = field[x];
                    if (this.getDataBalance() != null) {
                        value[x] = String.valueOf(this.getDataBalance());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "dataExpiry": {
                    column[x] = field[x];
                    if (this.getDataExpiry() != null) {
                        value[x] = String.valueOf(this.getDataExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "lastRechargeDate": {
                    column[x] = field[x];
                    if (this.getLastRechargeDate() != null) {
                        value[x] = String.valueOf(this.getLastRechargeDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "perSubsBlockOnAtSubLevel": {
                    column[x] = field[x];
                    if (this.getPerSubsBlockOnAtSubLevel() != null) {
                        value[x] = String.valueOf(this.getPerSubsBlockOnAtSubLevel());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "fixedLineServOnAtSubLevel": {
                    column[x] = field[x];
                    if (this.getFixedLineServOnAtSubLevel() != null) {
                        value[x] = String.valueOf(this.getFixedLineServOnAtSubLevel());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "dbRefId": {
                    column[x] = field[x];
                    if (this.getDbRefId() != null) {
                        value[x] = String.valueOf(this.getDbRefId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "periodicTariffPlan": {
                    column[x] = field[x];
                    if (this.getPeriodicTariffPlan() != null) {
                        value[x] = String.valueOf(this.getDbRefId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "reservationCounter": {
                    column[x] = field[x];
                    if (this.getReservationCounter() != null) {
                        value[x] = String.valueOf(this.getReservationCounter());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "lastReservationId": {
                    column[x] = field[x];
                    if (this.getLastReservationId() != null) {
                        value[x] = String.valueOf(this.getLastReservationId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "lowBalSmBlockingSet": {
                    column[x] = field[x];
                    if (this.getLowBalSmBlockingSet() != null) {
                        value[x] = String.valueOf(this.getLowBalSmBlockingSet());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "mainReservationAmount": {
                    column[x] = field[x];
                    if (this.getMainReservationAmount() != null) {
                        value[x] = String.valueOf(this.getMainReservationAmount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "periodicReservationAmount": {
                    column[x] = field[x];
                    if (this.getPeriodicReservationAmount() != null) {
                        value[x] = String.valueOf(this.getPeriodicReservationAmount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "bonusReservationAmount": {
                    column[x] = field[x];
                    if (this.getBonusReservationAmount() != null) {
                        value[x] = String.valueOf(this.getBonusReservationAmount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "smReservationAmount": {
                    column[x] = field[x];
                    if (this.getSmReservationAmount() != null) {
                        value[x] = String.valueOf(this.getSmReservationAmount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "dataReservationAmount": {
                    column[x] = field[x];
                    if (this.getDataReservationAmount() != null) {
                        value[x] = String.valueOf(this.getDataReservationAmount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "incomingCollectCallList": {
                    column[x] = field[x];
                    if (this.getIncomingCollectCallList() != null) {
                        value[x] = this.getIncomingCollectCallList();
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "outGoingCollectCallList": {
                    column[x] = field[x];
                    if (this.getOutGoingCollectCallList() != null) {
                        value[x] = this.getOutGoingCollectCallList();
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "localCollectCallOnAtSubLevel": {
                    column[x] = field[x];
                    if (this.getLocalCollectCallOnAtSubLevel() != null) {
                        value[x] = String.valueOf(this.getLocalCollectCallOnAtSubLevel());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "voiceBalance4": {
                    column[x] = field[x];
                    if (this.getVoiceBalance4() != null) {
                        value[x] = String.valueOf(this.getVoiceBalance4());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "voiceExpiry4": {
                    column[x] = field[x];
                    if (this.getVoiceExpiry4() != null) {
                        value[x] = String.valueOf(this.getVoiceExpiry4());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "loyaltyAccumulationDate": {
                    column[x] = field[x];
                    if (this.getLoyaltyAccumulationDate() != null) {
                        value[x] = String.valueOf(this.getLoyaltyAccumulationDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "loyaltyAccumulationQuantity": {
                    column[x] = field[x];
                    if (this.getLoyaltyAccumulationQuantity() != null) {
                        value[x] = String.valueOf(this.getLoyaltyAccumulationQuantity());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "loyaltyTariffPlanId": {
                    column[x] = field[x];
                    if (this.getLoyaltyTariffPlanId() != null) {
                        value[x] = String.valueOf(this.getLoyaltyTariffPlanId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "loyaltyTariffPlanExpiry": {
                    column[x] = field[x];
                    if (this.getLoyaltyTariffPlanExpiry() != null) {
                        value[x] = String.valueOf(this.getLoyaltyTariffPlanExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "accountStatusChangeDate": {
                    column[x] = field[x];
                    if (this.getAccountStatusChangeDate() != null) {
                        value[x] = String.valueOf(this.getAccountStatusChangeDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "rechargeFraudCounter0": {
                    column[x] = field[x];
                    if (this.getRechargeFraudCounter0() != null) {
                        value[x] = String.valueOf(this.getRechargeFraudCounter0());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "rechargeFraudCounter1": {
                    column[x] = field[x];
                    if (this.getRechargeFraudCounter1() != null) {
                        value[x] = String.valueOf(this.getRechargeFraudCounter1());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "rechargeFraudCounter2": {
                    column[x] = field[x];
                    if (this.getRechargeFraudCounter2() != null) {
                        value[x] = String.valueOf(this.getRechargeFraudCounter2());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "evaluationPeriodEndDate": {
                    column[x] = field[x];
                    if (this.getEvaluationPeriodEndDate() != null) {
                        value[x] = String.valueOf(this.getEvaluationPeriodEndDate());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "suspendedErrorFactor": {
                    column[x] = field[x];
                    if (this.getSuspendedErrorFactor() != null) {
                        value[x] = String.valueOf(this.getSuspendedErrorFactor());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "suspendedFraudFactor0": {
                    column[x] = field[x];
                    if (this.getSuspendedFraudFactor0() != null) {
                        value[x] = String.valueOf(this.getSuspendedFraudFactor0());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "suspendedFraudFactor1": {
                    column[x] = field[x];
                    if (this.getSuspendedFraudFactor1() != null) {
                        value[x] = String.valueOf(this.getSuspendedFraudFactor1());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "suspendedFraudFactor2": {
                    column[x] = field[x];
                    if (this.getSuspendedFraudFactor2() != null) {
                        value[x] = String.valueOf(this.getSuspendedFraudFactor2());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "ffOnAtSubLevel": {
                    column[x] = field[x];
                    if (this.getFfOnAtSubLevel() != null) {
                        value[x] = String.valueOf(this.getFfOnAtSubLevel());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "cycle": {
                    column[x] = field[x];
                    if (this.getCycle() != null) {
                        value[x] = String.valueOf(this.getCycle());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "nextProfile": {
                    column[x] = field[x];
                    if (this.getNextProfile() != null) {
                        value[x] = String.valueOf(this.getNextProfile());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "startDateRenewal": {
                    column[x] = field[x];
                    if (this.getStartDateRenewal() != null) {
                        value[x] = String.valueOf(this.getStartDateRenewal());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "autoRenewal": {
                    column[x] = field[x];
                    if (this.getAutoRenewal() != null) {
                        value[x] = String.valueOf(this.getAutoRenewal());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
            }
        }
        list.add(column);
        list.add(value);
        return list;
    }

}
