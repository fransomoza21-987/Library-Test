package com.claro.sp.automation.util;

public class ConstantCellular {
    //ESTADOS DE LA LINEA
    //STEALTH
    public static final String STH_STATUS_ACTIVE = "A";
    public static final String STH_STATUS_SUSPENDED = "S";
    public static final String STH_STATUS_CANCELED = "C";
    //CCARD
    public static final String CCARD_STATUS_ACTIVE = "AC";
    public static final String CCARD_STATUS_LAPSED = "CD";
    public static final String CCARD_STATUS_SUSPENDED = "SU";
    public static final String CCARD_STATUS_CANCELED = "CN";
    //CALL RESTRICTIONS
    public static final String CR_ID_DDN = "2";
    public static final String CR_ID_ONLY_ENTRANCE = "5";

    //ARGENTINA
    public static final String ACCOUNT_AR = "65324311";
    public static final String ACCOUNT_CORPO_AR = "683818744";
    public static final String DEALER_AR = "L026500134";
    public static final String CLIENT_AR = "637188";
    public static final String CLIENT_CORPO_AR = "8507987";
    /*Setea por default las terminaciones de lineas entre 00 y 99 abarcando todos los sitios*/
    public static final String DEFAULT_BEGIN_RANGE = "00";
    public static final String DEFAULT_END_RANGE = "99";

    //URUGUAY
    public static final String ACCOUNT_UY = "1318666";
    public static final String ACCOUNT_CORPO_UY = "270355";
    public static final String DEALER_UY = "UY00100997";
    public static final String CLIENT_UY = "99910";
    public static final String CLIENT_CORPO_UY = "19924";

    //PARAGUAY
    public static final String ACCOUNT_PY = "117400960";
    public static final String ACCOUNT_CORPO_PY = "16143588";
    public static final String DEALER_PY = "CACPY50240";
    public static final String CLIENT_PY = "2114121";
    public static final String CLIENT_CORPO_PY = "593917";
}
