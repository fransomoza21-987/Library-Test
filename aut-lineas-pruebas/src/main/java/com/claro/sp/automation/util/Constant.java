package com.claro.sp.automation.util;

import java.sql.Date;

public class Constant {
    public static final Date MAIN_EXPIRY = Utils.addDays(Utils.getCurrentDate(), 15);
    public static final Date PERIODIC_EXPIRY = Utils.addDays(Utils.getCurrentDate(), 30);
    public static final Date BONUS_EXPIRY = Utils.addDays(Utils.getCurrentDate(), 5);

    //reemplazar por una sola constante que tome el valor de la base con un método estático
    public static final int GSM_DECIMAL_DIVISOR_AR = 100000;
    public static final int GSM_DECIMAL_DIVISOR_UY = 100000;
    public static final int GSM_DECIMAL_DIVISOR_PY = 100;

    public static final String CCARD_DEV_AR_OWNER = "ccard2";
    public static final String CCARD_OWNER = "ccard";

}
