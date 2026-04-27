package com.claro.sp.automation.model;

import com.claro.sp.automation.model.subscriber.Slot;

import java.sql.Date;

public class SubscriberAccount {

    private final Slot[] slot = new Slot[15];
    private String subid;
    private Integer operatorId;
    private Integer accountType;
    private Integer counter6;
    private Date counterTStamp6;
    private Integer tariffPlanId;
    private Integer balanceAmount0;
    private Integer balanceUnits0;
    private Date balanceExpiry0;
    private Integer bestDate;

    public SubscriberAccount() {
        super();
        for (int i = 0; i < slot.length; i++)
            slot[i] = new Slot();
    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getCounter6() {
        return counter6;
    }

    public void setCounter6(Integer counter6) {
        this.counter6 = counter6;
    }

    public Date getCounterTStamp6() {
        return counterTStamp6;
    }

    public void setCounterTStamp6(Date counterTStamp6) {
        this.counterTStamp6 = counterTStamp6;
    }

    public Integer getTariffPlanId() {
        return tariffPlanId;
    }

    public void setTariffPlanId(Integer tariffPlanId) {
        this.tariffPlanId = tariffPlanId;
    }

    public Integer getBalanceAmount0() {
        return balanceAmount0;
    }

    public void setBalanceAmount0(Integer balanceAmount0) {
        this.balanceAmount0 = balanceAmount0;
    }

    public Integer getBalanceUnits0() {
        return balanceUnits0;
    }

    public void setBalanceUnits0(Integer balanceUnits0) {
        this.balanceUnits0 = balanceUnits0;
    }

    public Date getBalanceExpiry0() {
        return balanceExpiry0;
    }

    public void setBalanceExpiry0(Date balanceExpiry0) {
        this.balanceExpiry0 = balanceExpiry0;
    }

    public Integer getBestDate() {
        return bestDate;
    }

    public void setBestDate(Integer bestDate) {
        this.bestDate = bestDate;
    }

    public void setSlot(int position, Slot slot) {
        this.slot[position] = slot;
    }

    public String getPkgDefId(int position) {
        return slot[position].getPkgDefId();
    }

    public Integer getPkgQuantityLeft(int position) {
        return slot[position].getPkgQuantityLeft();
    }

    public Date getPkgExpiry(int position) {
        return slot[position].getPkgExpiry();
    }

    public String getPkgRenewal(int position) {
        return slot[position].getPkgRenewal();
    }

}
