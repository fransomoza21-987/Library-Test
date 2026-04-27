package com.claro.sp.automation.model.subscriber;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cellular {
    private String cellularNumber;
    private String billNumber;
    private String subid;
    private String handle;
    private String imsi;
    private String iccid;
    private String profileId;
    private String ratePlanSth;
    private String serviceStatus;
    private String statusStealth;
    private String statusPpay;
    private String accountStatus;
    private String callRestrictionId;
    private String businessType;
    private String node;
    private String block_code;
    private String accountId;
    private String dealerId;
    private String clientId;
    private boolean distinctBillNumber;
    private boolean corporativeClient;
    private String tmtId;
    private String codeArea;
    private boolean flagRange = false;
    private String beginRange;
    private String endRange;
    private boolean flagSims = true;

    public Cellular() {
    }

}