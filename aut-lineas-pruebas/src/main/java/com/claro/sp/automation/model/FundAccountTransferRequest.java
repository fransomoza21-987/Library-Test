package com.claro.sp.automation.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FundAccountTransferRequest {

    String subid;
    Integer operatorId;
    Integer transactionType;
    Integer rechargeDiscount;
    String correlationId;
    Integer deltaAmount;
    Integer noFailonInsuficcientFunds;
    Integer trafficType;
    Integer accountType;
    Integer balanceId;
    Integer balanceDelta;
    Date expiryDate;
    Integer bestDate;


    public FundAccountTransferRequest() {
        super();
    }

    public FundAccountTransferRequest(String subid, Integer operatorId, Integer transactionType, Integer rechargeDiscount,
                                      String correlationId, Integer deltaAmount, Integer noFailonInsuficcientFunds, Integer trafficType, Integer accountType,
                                      Integer balanceId, Integer balanceDelta, Date expiryDate, Integer bestDate) {
        super();
        this.subid = subid;
        this.operatorId = operatorId;
        this.transactionType = transactionType;
        this.rechargeDiscount = rechargeDiscount;
        this.correlationId = correlationId;
        this.deltaAmount = deltaAmount;
        this.noFailonInsuficcientFunds = noFailonInsuficcientFunds;
        this.trafficType = trafficType;
        this.accountType = accountType;
        this.balanceId = balanceId;
        this.balanceDelta = balanceDelta;
        this.expiryDate = expiryDate;
        this.bestDate = bestDate;
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

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getRechargeDiscount() {
        return rechargeDiscount;
    }

    public void setRechargeDiscount(Integer rechargeDiscount) {
        this.rechargeDiscount = rechargeDiscount;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public Integer getDeltaAmount() {
        return deltaAmount;
    }

    public void setDeltaAmount(Integer deltaAmount) {
        this.deltaAmount = deltaAmount;
    }

    public Integer getNoFailonInsuficcientFunds() {
        return noFailonInsuficcientFunds;
    }

    public void setNoFailonInsuficcientFunds(Integer noFailonInsuficcientFunds) {
        this.noFailonInsuficcientFunds = noFailonInsuficcientFunds;
    }

    public Integer getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(Integer trafficType) {
        this.trafficType = trafficType;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    public Integer getBalanceDelta() {
        return balanceDelta;
    }

    public void setBalanceDelta(Integer balanceDelta) {
        this.balanceDelta = balanceDelta;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getBestDate() {
        return bestDate;
    }

    public void setBestDate(Integer bestDate) {
        this.bestDate = bestDate;
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
                case "subid": {
                    column[x] = field[x];
                    if (String.valueOf(this.getSubid()) != null) {
                        value[x] = String.valueOf(this.getSubid());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "operatorId": {
                    column[x] = field[x];
                    if (this.getOperatorId() != null) {
                        value[x] = String.valueOf(this.getOperatorId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "transactionType": {
                    column[x] = field[x];
                    if (this.getTransactionType() != null) {
                        value[x] = String.valueOf(this.getTransactionType());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "rechargeDiscount": {
                    column[x] = field[x];
                    if (this.getRechargeDiscount() != null) {
                        value[x] = String.valueOf(this.getRechargeDiscount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "correlationId": {
                    column[x] = field[x];
                    if (this.getCorrelationId() != null) {
                        value[x] = String.valueOf(this.getCorrelationId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "deltaAmount": {
                    column[x] = field[x];
                    if (this.getDeltaAmount() != null) {
                        value[x] = String.valueOf(this.getDeltaAmount());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "noFailonInsuficcientFunds": {
                    column[x] = field[x];
                    if (this.getNoFailonInsuficcientFunds() != null) {
                        value[x] = String.valueOf(this.getNoFailonInsuficcientFunds());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "trafficType": {
                    column[x] = field[x];
                    if (this.getTrafficType() != null) {
                        value[x] = String.valueOf(this.getTrafficType());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "accountType": {
                    column[x] = field[x];
                    if (this.getAccountType() != null) {
                        value[x] = String.valueOf(this.getAccountType());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceId": {
                    column[x] = field[x];
                    if (this.getBalanceId() != null) {
                        value[x] = String.valueOf(this.getBalanceId());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceDelta": {
                    column[x] = field[x];
                    if (this.getBalanceDelta() != null) {
                        value[x] = String.valueOf(this.getBalanceDelta());
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
                case "bestDate": {
                    column[x] = field[x];
                    if (this.getBestDate() != null) {
                        value[x] = String.valueOf(this.getBestDate());
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
