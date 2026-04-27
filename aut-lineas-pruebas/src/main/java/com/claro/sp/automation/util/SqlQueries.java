package com.claro.sp.automation.util;

public class SqlQueries {
    public static final String QUERY_RANDOM_NIM_AR = """
            select %s || to_char(trunc(dbms_random.value(10000, 99999))) ||
                   to_char(trunc(dbms_random.value(%s, %s))) as nim
              from dual
            """;
    public static final String QUERY_RANDOM_NIM_AR_NODE = """
            select ('%s' || to_char(trunc(dbms_random.value(10000, 99999))) ||
                   to_char(trunc(dbms_random.value(ste_ini_rango, ste_fin_rango)))) as nim
              from sitios_tecnotree
             where ste_rango = '%s'
               and sysdate between ste_start_date and nvl(ste_end_date, sysdate + 1)
            """;
    public static final String QUERY_RANDOM_NIM_UY = """
            select %s || to_char(trunc(dbms_random.value(1000, 9999))) ||
                   to_char(trunc(dbms_random.value(%s, %s))) as nim
              from dual
            """;
    public static final String QUERY_RANDOM_NIM_PY = """
            select %s || to_char(trunc(dbms_random.value(41699, 99999))) ||
                   to_char(trunc(dbms_random.value(%s, %s))) as nim
              from dual
            """;
    public static final String QUERY_VALIDATE_CELLULARS = """
            select clu_cellular_number from cellulars where clu_cellular_number = '%s'
            """;
    public static final String QUERY_VALIDATE_SIMS = """
            select sim_imsi,
                   sim_iccid,
                   sim_msisdn
              from sims
             where sim_msisdn = '%s'
            """;
    public static final String QUERY_GET_SUBID = """
            select p.ppa_value || clu_bill_number as subid
              from cellulars         c,
                   prepay_parameters p
             where (c.clu_bill_number = '%1$s' or c.clu_cellular_number = '%2$s')
               and p.ppa_name in
                   (select decode(c.clu_type, 'CPP', 'PREFIJOS_GSM_CPP', 'MPP', 'PREFIJOS_GSM_MPP')
                      from cellulars c
                     where (c.clu_bill_number = '%1$s' or c.clu_cellular_number = '%2$s'))
               and sysdate between p.ppa_start_date and nvl(p.ppa_end_date, sysdate + 1)
            """;
    public static final String QUERY_GET_SEQUENCE_ID = """
            select %s.nextval seq from dual
            """;
    public static final String QUERY_VALID_ACCOUNT_ID = """
            select cac_id from cellular_accounts where cac_id = %s
            """;
    public static final String QUERY_VALID_CALL_RESTR_ID = """
            select ccr_id from cellular_call_restrictions where ccr_id = %s
            """;
    public static final String QUERY_VALIDATE_HANDLE = """
            select pce_handle from prepay_cellulars where pce_handle = %s
            """;
    public static final String QUERY_GET_RATE_PLAN_ID = """
            select rppr_rpl_id
              from rate_plan_profiles
             where rppr_gprf_id = %s
               and sysdate between rppr_start_date and nvl(rppr_end_date, sysdate)
            """;
    public static final String QUERY_GET_BASIC_PACKS_STH = """
            select cpa_pkt_id
              from cel_business_types_packages
             where cpa_cbt_id = (select clu_cbt_id from cellulars where clu_cellular_number = '%s')
               and cpa_default_flag = 'Y'
               and cpa_start_date <= sysdate
               and cpa_end_date >= sysdate
            """;
    public static final String QUERY_GET_PACK_DATA = """
            select sep_pkt_id,
                   case sep_gspr_id
                     when 1 then sep_type_tecnomen
                     else sep_type_tecnomen - 1
                   end as sep_type_tecnomen,
                   decode(sep_gspr_id, 1, 0, 2, 1, 8, 2, 9, 3) as accounttypeid,
                   case sep_gspr_id
                     when 8 then sep_units_in * (select tuc_divisor from tecno_units_conversion where tuc_unit_id = sp.sep_tuc_unit_id)
                     else sep_units_in
                   end as quantityleft,
                   sep_renewal_pkt
              from service_pack_parameters sp
             where sep_pkt_tecnomen = %s
               and sysdate between sep_start_date and nvl(sep_end_date, sysdate + 1)
            """;
    public static final String QUERY_GET_PKG_EXPIRY = """
            select decode(pkt_type,
                          'PD',
                          sysdate + trunc(pkt.pkt_length_days),
                          'PH',
                          sysdate + pkt.pkt_length_days,
                          sysdate + pkt.pkt_length_days) as pkgexpiry
              from packages pkt
             where pkt_id = '%s'
            """;
    public static final String QUERY_GET_DECIMAL_DIVISOR = """
            select ppa_value
              from prepay_parameters
             where ppa_name = 'GSM_DECIMAL_DIVISOR'
               and sysdate between ppa_start_date and nvl(ppa_end_date, sysdate + 1)
            """;
    public static final String QUERY_GET_PREFIX = """
            select ppa_value from prepay_parameters where ppa_name in ('PREFIJOS_GSM_CPP')
            """;
}
