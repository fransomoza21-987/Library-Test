package com.claro.sp.automation.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FundAccountTransfeResponse {

    int resultCode;
    String description;
    Integer tariffPlan;
    Integer balanceAmountMain;
    Integer balanceUnitsMain;
    Date balanceExpiryMain;
    Integer balanceAmountBonus;
    Integer balanceUnitsBonus;
    Date balanceExpiryBonus;
    Integer balanceAmountBonus2;
    Integer balanceUnitsBonus2;
    Date balanceExpiryBonus2;

    public FundAccountTransfeResponse() {
        super();
    }

    public FundAccountTransfeResponse(String description, Integer tariffPlan, Integer balanceAmountMain,
                                      Integer balanceUnitsMain, Date balanceExpiryMain, Integer balanceAmountBonus, Integer balanceUnitsBonus,
                                      Date balanceExpiryBonus, Integer balanceAmountBonus2, Integer balanceUnitsBonus2,
                                      Date balanceExpiryBonus2) {
        super();
        this.description = description;
        this.tariffPlan = tariffPlan;
        this.balanceAmountMain = balanceAmountMain;
        this.balanceUnitsMain = balanceUnitsMain;
        this.balanceExpiryMain = balanceExpiryMain;
        this.balanceAmountBonus = balanceAmountBonus;
        this.balanceUnitsBonus = balanceUnitsBonus;
        this.balanceExpiryBonus = balanceExpiryBonus;
        this.balanceAmountBonus2 = balanceAmountBonus2;
        this.balanceUnitsBonus2 = balanceUnitsBonus2;
        this.balanceExpiryBonus2 = balanceExpiryBonus2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTariffPlan() {
        return tariffPlan;
    }

    public void setTariffPlan(Integer tariffPlan) {
        this.tariffPlan = tariffPlan;
    }

    public Integer getBalanceAmountMain() {
        return balanceAmountMain;
    }

    public void setBalanceAmountMain(Integer balanceAmountMain) {
        this.balanceAmountMain = balanceAmountMain;
    }

    public Integer getBalanceUnitsMain() {
        return balanceUnitsMain;
    }

    public void setBalanceUnitsMain(Integer balanceUnitsMain) {
        this.balanceUnitsMain = balanceUnitsMain;
    }

    public Date getBalanceExpiryMain() {
        return balanceExpiryMain;
    }

    public void setBalanceExpiryMain(Date balanceExpiryMain) {
        this.balanceExpiryMain = balanceExpiryMain;
    }

    public Integer getBalanceAmountBonus() {
        return balanceAmountBonus;
    }

    public void setBalanceAmountBonus(Integer balanceAmountBonus) {
        this.balanceAmountBonus = balanceAmountBonus;
    }

    public Integer getBalanceUnitsBonus() {
        return balanceUnitsBonus;
    }

    public void setBalanceUnitsBonus(Integer balanceUnitsBonus) {
        this.balanceUnitsBonus = balanceUnitsBonus;
    }

    public Date getBalanceExpiryBonus() {
        return balanceExpiryBonus;
    }

    public void setBalanceExpiryBonus(Date balanceExpiryBonus) {
        this.balanceExpiryBonus = balanceExpiryBonus;
    }

    public Integer getBalanceAmountBonus2() {
        return balanceAmountBonus2;
    }

    public void setBalanceAmountBonus2(Integer balanceAmountBonus2) {
        this.balanceAmountBonus2 = balanceAmountBonus2;
    }

    public Integer getBalanceUnitsBonus2() {
        return balanceUnitsBonus2;
    }

    public void setBalanceUnitsBonus2(Integer balanceUnitsBonus2) {
        this.balanceUnitsBonus2 = balanceUnitsBonus2;
    }

    public Date getBalanceExpiryBonus2() {
        return balanceExpiryBonus2;
    }

    public void setBalanceExpiryBonus2(Date balanceExpiryBonus2) {
        this.balanceExpiryBonus2 = balanceExpiryBonus2;
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
                case "resultCode": {
                    column[x] = field[x];
                    if (String.valueOf(this.getResultCode()) != null) {
                        value[x] = String.valueOf(this.getResultCode());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "description": {
                    column[x] = field[x];
                    if (this.getDescription() != null) {
                        value[x] = this.getDescription();
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "tariffPlan": {
                    column[x] = field[x];
                    if (this.getTariffPlan() != null) {
                        value[x] = String.valueOf(this.getTariffPlan());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceAmountMain": {
                    column[x] = field[x];
                    if (this.getBalanceAmountMain() != null) {
                        value[x] = String.valueOf(this.getBalanceAmountMain());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceUnitsMain": {
                    column[x] = field[x];
                    if (this.getBalanceExpiryMain() != null) {
                        value[x] = String.valueOf(this.getBalanceExpiryMain());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceExpiryMain": {
                    column[x] = field[x];
                    if (this.getBalanceExpiryMain() != null) {
                        value[x] = String.valueOf(this.getBalanceExpiryMain());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceAmountBonus": {
                    column[x] = field[x];
                    if (this.getBalanceAmountBonus() != null) {
                        value[x] = String.valueOf(this.getBalanceAmountBonus());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceUnitsBonus": {
                    column[x] = field[x];
                    if (this.getBalanceUnitsBonus() != null) {
                        value[x] = String.valueOf(this.getBalanceUnitsBonus());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceExpiryBonus": {
                    column[x] = field[x];
                    if (this.getBalanceExpiryBonus() != null) {
                        value[x] = String.valueOf(this.getBalanceExpiryBonus());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceAmountBonus2": {
                    column[x] = field[x];
                    if (this.getBalanceAmountBonus2() != null) {
                        value[x] = String.valueOf(this.getBalanceAmountBonus2());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceUnitsBonus2": {
                    column[x] = field[x];
                    if (this.getBalanceUnitsBonus2() != null) {
                        value[x] = String.valueOf(this.getBalanceUnitsBonus2());
                    } else {
                        value[x] = "";
                    }
                    break;
                }
                case "balanceExpiryBonus2": {
                    column[x] = field[x];
                    if (this.getBalanceExpiryBonus2() != null) {
                        value[x] = String.valueOf(this.getBalanceExpiryBonus2());
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
