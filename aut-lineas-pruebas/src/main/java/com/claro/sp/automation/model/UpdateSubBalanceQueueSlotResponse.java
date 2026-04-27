package com.claro.sp.automation.model;

import java.util.ArrayList;
import java.util.List;

public class UpdateSubBalanceQueueSlotResponse {

    //in
    private String subId;
    private Integer balanceType;
    private Integer accountType;
    private Integer slotNumber;
    private Integer balanceValue;
    private String balanceExpiry;
    private Integer operatorId;

    //out
    private String peDescription;
    private int resultCode;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public Integer getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(Integer balanceType) {
        this.balanceType = balanceType;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Integer getBalanceValue() {
        return balanceValue;
    }

    public void setBalanceValue(Integer balanceValue) {
        this.balanceValue = balanceValue;
    }

    public String getBalanceExpiry() {
        return balanceExpiry;
    }

    public void setBalanceExpiry(String balanceExpiry) {
        this.balanceExpiry = balanceExpiry;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getPeDescription() {
        return peDescription;
    }

    public void setPeDescription(String peDescription) {
        this.peDescription = peDescription;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
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
                case "balanceType": {
                    column[x] = field[x];
                    if (String.valueOf(this.getBalanceType()) != null) {
                        value[x] = String.valueOf(this.getBalanceType());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "accountType": {
                    column[x] = field[x];
                    if (String.valueOf(this.getAccountType()) != null) {
                        value[x] = String.valueOf(this.getAccountType());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "slotNumber": {
                    column[x] = field[x];
                    if (String.valueOf(this.getSlotNumber()) != null) {
                        value[x] = String.valueOf(this.getSlotNumber());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceValue": {
                    column[x] = field[x];
                    if (String.valueOf(this.getBalanceValue()) != null) {
                        value[x] = String.valueOf(this.getBalanceValue());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceExpiry": {
                    column[x] = field[x];
                    if (String.valueOf(this.getBalanceExpiry()) != null) {
                        value[x] = String.valueOf(this.getBalanceExpiry());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "operatorId": {
                    column[x] = field[x];
                    if (String.valueOf(this.getOperatorId()) != null) {
                        value[x] = String.valueOf(this.getOperatorId());
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
            }
        }
        list.add(column);
        list.add(value);
        return list;
    }
}