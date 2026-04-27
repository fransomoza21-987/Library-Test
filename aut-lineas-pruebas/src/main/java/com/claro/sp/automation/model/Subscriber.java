package com.claro.sp.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Subscriber {

    private String login;
    private Integer userType;
    private Integer languageId;
    private Integer operatorId;
    private String subId;
    private Integer accountBalance;
    private Date expiryDate;
    private String familyFriends;
    private Integer ffDiscount;
    private Date ffExpiry;
    private Integer ffOnatSubLevel;
    private String imsi;
    private Integer profileId;
    private Date bonusExpiry;
    private String smid;
    private Integer subClass;
    private Date activationDate;
    private Integer accountType;
    private Integer accountTypeGprs;
    private Integer tariffPlandId;
    private Integer balanceAmount0;
    private Integer balanceUnits0;
    private Date balanceExpiry0;
    private Integer pkgdefId0;
    private Integer pkgQuantityLeft0;
    private Date pkgExpiry0;
    private Integer pkgRenewal0;
    private Integer pkgNextDefId0;
    private Integer pkgDefId1;
    private Integer pkgQuantityLeft1;
    private Date pkgExpiry1;
    private Integer pkgRenewal1;
    private Integer pkgNextDefId1;
    private Integer pkgDefId2;
    private Integer pkgQuantityLeft2;
    private Date pkgExpiry2;
    private Integer pkgRenewal2;
    private Integer pkgNextDefId2;
    private Integer pkgDefId3;
    private Integer pkgQuantityLeft3;
    private Date pkgExpiry3;
    private Integer pkgRenewal3;
    private Integer pkgNextDefId3;
    private Integer serviceType;
    private Integer serviceSubType;
    private Integer serviceTypeGprs;
    private Integer serviceSubTypeGprs;
    private String prefdDstList0;
    private Date prefDestExpiry0;
    private String prefDestList1;
    private Date prefDestExpiry1;
    private Integer callMeonatSubLevel;

    public Subscriber() {
        super();
    }

}
