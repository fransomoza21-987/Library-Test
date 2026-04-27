package com.claro.sp.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AccountQuery {
    private Integer role;
    private String peDescription;
    private String subId;
    private Integer operatorId;
    private Integer TransferResult;
    private Integer accountBalance;
    private Integer serviceStatus;
    private Integer accountStatus;
    private Date expiryDate;
    private Integer profileId;
    private Integer subOptions;
    private Date ivrQueryExpiryDate;
    private Integer ivrQueryCounter;
    private Integer amountBalance;
    private Date lastrechargedate;
    private Integer periodicBalance;
    private Date periodicExpiry;
    private Integer bonusBalance;
    private Date bonusExpiry;
    private Integer smBalance;
    private Date smExpiry;
    private Integer dataBalance;
    private Date dataExpiry;
    private Integer overDraftBalance;
    private Integer voiceBalance4;
    private Date voiceExpiry4;
}
