package com.claro.sp.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class PaymentFundTransferDFTSubscriber {

    private String peDescription;
    private String subId;
    private Integer operatorId;
    private Short transactionType;
    private Short rechargeDiscount;
    private Integer amount;
    private Date expiryDate;
    private Integer periodicAmount;
    private Date periodicExpiry;
    private Integer bonusAmount;
    private Date bonusExpiry;
    private Integer smAmount;
    private Date smExpiry;
    private Integer dataAmount;
    private Date dataExpiry;
    private Integer promotionalBalanceDelta;
    private Date promotionalExpiryDate;
    private Integer promotionalPlanId;
    private Integer bestDate;
    private Short serviceStatus;
    private Short accountStatus;
    private Short profileId;
    private Integer subOptions;
    private Date ivrQueryWxpiryDate;
    private Short ivrCounter;
    private Integer amountBalance;
    private Integer accountBalance;
    private Date rExpiryDate;
    private Integer periodicBalance;
    private Date rperiodicExpiry;
    private Integer bonusBalance;
    private Date rBonusExpiry;
    private Integer smBalance;
    private Date rsmExpiry;
    private Integer dataBalance;
    private Date rDataExpiry;
    private Integer rPromotionalBalance;
    private Date rPromotionalExpiry;

    public PaymentFundTransferDFTSubscriber() {
        super();
    }

}
