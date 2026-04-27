package com.claro.sp.automation.util;

public class SqlBlocks {
    public static final String BLOCK_GENERATE_CELLULARS = """
            begin
              insert into cellulars
                (clu_cellular_number,
                 clu_activation_date,
                 clu_status,
                 clu_add_date,
                 clu_stg_id,
                 clu_cmp_id,
                 clu_acc_id,
                 clu_dlr_id,
                 clu_usr_id,
                 clu_clt_id,
                 clu_blc_block_code,
                 clu_type,
                 clu_cbt_id,
                 clu_bill_number,
                 clu_npa_digits,
                 clu_pro_mode_type,
                 clu_line_type,
                 clu_tmt_id)
              values
                ('%s',
                 sysdate,
                 '%s',
                 sysdate,
                 'AH',
                 1,
                 '%s',
                 '%s',
                 'STL',
                 '%s',
                 '%s',
                 'CPP',
                 '%s',
                 '%s',
                 2,
                 'GSM',
                 'COMERCIAL',
                 '138C');
            end;
            """;
    public static final String BLOCK_GENERATE_SIM = """
            declare
              v_lote_id         lotes_sims.lote_id%type := 0;
              v_lote_in_table   lotes_sims.lote_id%type := 0;
              v_last_digits     varchar2(5);
              v_imsi_in_table   sims.sim_imsi%type := 0;
              v_imsi_generated  sims.sim_imsi%type := 0;
              v_iccid_generated sims.sim_iccid%type;
            begin
              while v_lote_in_table = v_lote_id loop
                select lote_id_seq.nextval into v_lote_id from dual;
                begin
                  select lote_id into v_lote_in_table from lotes_sims where lote_id = v_lote_id;
                exception
                  when no_data_found then
                    null;
                end;
              end loop;
              while v_imsi_in_table = v_imsi_generated loop
                select trunc(dbms_random.value(100000000000000, 999999999999999))
                  into v_imsi_generated
                  from dual;
                select v_imsi_generated || trunc(dbms_random.value(1000, 9999))
                  into v_iccid_generated
                  from dual;
                begin
                  select sim_imsi into v_imsi_in_table from sims where sim_imsi = v_imsi_generated;
                exception
                  when no_data_found then
                    null;
                end;
              end loop;
              insert into lotes_sims
                (lote_id,
                 lote_quant,
                 lote_sim_type,
                 lote_subscription_type,
                 lote_electrical_profile,
                 lote_graphic_profile,
                 lote_transport_key,
                 lote_transport_kappli,
                 lote_po_ref_number,
                 lote_imsi_start_number,
                 lote_iccid_start_number,
                 lote_supplier,
                 lote_technology,
                 lote_country,
                 lote_proc_date,
                 lote_file_name)
              values
                (v_lote_id,
                 10000,
                 'PLUG-IN',
                 0,
                 '01.01C',
                 '01.01',
                 1,
                 1,
                 'S/N',
                 v_imsi_generated,
                 v_iccid_generated,
                 31,
                 'USIM 256K',
                 '#pais#',
                 sysdate,
                 '#equipo#');
              insert into sims
                (sim_lote_id, sim_pro_id, sim_imsi, sim_iccid, sim_msisdn)
              values
                (v_lote_id, '20310040', v_imsi_generated, v_iccid_generated || 'F', '#equipo#');
              insert into sim_histories
                (sih_sim_iccid, sih_chs_id, sih_start_date, sih_end_date, sih_usr_id)
              values
                (v_iccid_generated || 'F', '217', sysdate, null, 'WEB');
            end;
            """;
    public static final String BLOCK_UPDATE_CELLULARS_ESN = """
            begin
              update cellulars set clu_esn = '%s' where clu_cellular_number = '%s';
            end;
            """;
    public static final String BLOCK_REFRESH_SNAP = """
            begin
              dbms_mview.refresh('%s.%s');
            end;
            """;
    public static final String BLOCK_ASIGN_SIM_TO_CEL = """
            declare
              v_existe          number(1);
              v_nim             cellulars.clu_cellular_number%type;
              v_iccid           sims.sim_iccid%type;
              v_hexa            esn_cellulars.esc_esn_hexa%type;
              v_activation_date service_request_forms.srf_activation_date%type := sysdate;
              v_est_id          service_request_forms.srf_est_id%type;
              v_est_own_id      service_request_forms.srf_est_own_id%type;
              v_srf_id          service_request_forms.srf_id%type;
              v_dlr_id          dealers.dlr_id%type;
              v_pro_id          sims.sim_pro_id%type;
              v_imsi            sims.sim_imsi%type;
              v_esc_start_date  esn_cellulars.esc_start_date%type;
              v_cet_id          cellular_terminals.cet_id%type;
              v_cet_pro_id      service_request_terminals.srt_pro_id%type;
              v_cet_imei        service_request_terminals.srt_imei%type;
              v_cet_est_id      service_request_terminals.srt_est_id%type;
              v_cet_est_own_id  service_request_terminals.srt_est_own_id%type;
            begin
              v_nim    := '#linea#';
              v_iccid  := '#iccid#';
              v_hexa   := trim(trailing 'F' from v_iccid);
              v_cet_id := '#cetid#';
              select sim_pro_id,
                     sim_imsi
                into v_pro_id,
                     v_imsi
                from sims
               where sim_iccid = v_iccid;
              /* Actualiza ELECTRONICAL_SERIAL_NUMBERS */
              begin
                insert into electronical_serial_numbers
                  (esn_hexa, financial_flag, esn_pro_id)
                values
                  (v_hexa, 'N', v_pro_id);
              exception
                when dup_val_on_index then
                  update electronical_serial_numbers
                     set financial_flag = 'N', esn_pro_id = v_pro_id
                   where esn_hexa = v_hexa;
              end;
              /* Actualiza ESN_CELLULARS */
              begin
                select 1
                  into v_existe
                  from esn_cellulars
                 where esc_clu_cellular_number = v_nim
                   and esc_end_date is null;
              exception
                when no_data_found then
                  v_existe := 0;
              end;
              if v_existe = 1 then
                update esn_cellulars
                   set esc_esn_hexa = v_hexa
                 where esc_clu_cellular_number = v_nim
                   and esc_end_date is null;
              else
                insert into esn_cellulars
                  (esc_esn_hexa,
                   esc_clu_cellular_number,
                   esc_start_date,
                   esc_est_id,
                   esc_est_own_id,
                   esc_dlr_id,
                   esc_usr_id)
                values
                  (v_hexa, v_nim, sysdate, 'DIST', 'CTI', '#dealer#', 'WEB');
              end if;
              /* Actualiza CELLULAR_TERMINALS */
              begin
                select srt_pro_id,
                       srt_imei,
                       srt_est_id,
                       srt_est_own_id
                  into v_cet_pro_id,
                       v_cet_imei,
                       v_cet_est_id,
                       v_cet_est_own_id
                  from service_request_terminals
                 where srt_srf_id = v_srf_id;
              exception
                when no_data_found then
                  v_cet_pro_id     := '20300001';
                  v_cet_imei       := '999999999999994';
                  v_cet_est_id     := 'DIST';
                  v_cet_est_own_id := 'CTI';
              end;
              insert into cellular_terminals
                (cet_id,
                 cet_sim_iccid,
                 cet_clu_cellular_number,
                 cet_pro_id,
                 cet_imei,
                 cet_est_id,
                 cet_est_own_id,
                 cet_start_date)
              values
                (v_cet_id,
                 v_hexa,
                 v_nim,
                 v_cet_pro_id,
                 v_cet_imei,
                 v_cet_est_id,
                 v_cet_est_own_id,
                 v_activation_date);
              /* Actualiza CELLULAR_TERMINAL_STATUS*/
              insert into cellular_terminal_status
                (cts_cet_id, cts_chs_id, cts_usr_id, cts_start_date)
              values
                (v_cet_id, 221, 'WEB', v_activation_date);
              /* Asigna MSISDN a la SIM migrada */
              update sims set sim_msisdn = '#msisdn#' where sim_iccid = v_iccid;
              /* Actualiza SIM_HISTORIES */
              select esc_start_date
                into v_esc_start_date
                from esn_cellulars
               where esc_clu_cellular_number = v_nim
                 and esc_end_date is null;
              update sim_histories
                 set sih_end_date = v_esc_start_date
               where sih_sim_iccid = v_iccid
                 and sih_chs_id = '217'
                 and sih_end_date is null;
              insert into sim_histories
                (sih_sim_iccid, sih_chs_id, sih_start_date, sih_usr_id)
              values
                (v_iccid, '218', v_esc_start_date, 'WEB');
              commit;
            end;
            """;
    public static final String BLOCK_INSERT_CBH = """
            begin
              insert into cellular_business_histories
                (cbh_clu_cellular_number, cbh_cbt_id, cbh_start_date)
              values
                ('%s', '%s', sysdate);
            end;
            """;
    public static final String BLOCK_INSERT_CELLULAR_ACCOUNTS = """
            begin
              insert into cellular_accounts
                (cac_id,
                 cac_clu_cellular_number,
                 cac_acc_id,
                 cac_start_date,
                 cac_end_date,
                 cac_usr_id,
                 cac_add_date)
              values
                (%s, '%s', '%s', sysdate, null, 'WEB', sysdate);
            end;
            """;
    public static final String BLOCK_INSERT_SERVICE_STATUS = """
            begin
              insert into service_status
                (sst_clu_cellular_number,
                 sst_service_status,
                 sst_start_date,
                 sst_end_date,
                 sst_add_date,
                 sst_usr_id,
                 sst_rsn_id)
              values
                ('%s', '%s', sysdate, null, sysdate, user, 'WACTIV');
            end;
            """;
    public static final String BLOCK_INSERT_CELLULAR_CALL_RESTRICTIONS = """
            begin
              insert into cellular_call_restrictions
                (ccr_id,
                 ccr_cr_id,
                 ccr_start_date,
                 ccr_tck_id,
                 ccr_rmr_id,
                 ccr_usr_id,
                 ccr_clu_cellular_number,
                 ccr_rsn_id,
                 ccr_end_date)
              values
                (%s, %s, sysdate, null, null, 'WEB', '%s', 'WACTIV', null);
            end;
            """;
    public static final String BLOCK_INSERT_PREPAY_CELLULARS = """
            declare
              v_cpam_ddi_call      call_parameters.cpam_ddi_call%type;
              v_cpam_ddn_call      call_parameters.cpam_ddn_call%type;
              v_cpam_local_call    call_parameters.cpam_local_call%type;
              v_cpam_incoming_call call_parameters.cpam_incoming_call%type;
              v_cpam_aty_id        call_parameters.cpam_aty_id%type;
              v_cpam_lty_id        call_parameters.cpam_lty_id%type;
              v_cpam_sys_code_id   call_parameters.cpam_sys_code_id%type;
            begin
              select cpam_ddi_call,
                     cpam_ddn_call,
                     cpam_local_call,
                     cpam_incoming_call,
                     cpam_aty_id,
                     cpam_lty_id,
                     cpam_sys_code_id
                into v_cpam_ddi_call,
                     v_cpam_ddn_call,
                     v_cpam_local_call,
                     v_cpam_incoming_call,
                     v_cpam_aty_id,
                     v_cpam_lty_id,
                     v_cpam_sys_code_id
                from call_parameters
               where sysdate between cpam_start_date and cpam_end_date;
              insert into prepay_cellulars
                (pce_handle,
                 pce_clu_cellular_number,
                 pce_pcs_id_actual,
                 pce_pcs_id_before,
                 pce_pcc_id,
                 pce_last_status_update,
                 pce_last_update,
                 pce_add_date,
                 pce_available_amount,
                 pce_ddi,
                 pce_ddn,
                 pce_loc,
                 pce_incoming,
                 pce_anouncement,
                 pce_prev_amount,
                 pce_lang_id,
                 pce_account_amount,
                 pce_sys_code_id,
                 pce_first_call_date,
                 pce_last_call_date,
                 pce_percentage,
                 pce_due_amount_date,
                 pce_suspend_date,
                 pce_cancel_date,
                 pce_expiration_date,
                 pce_psa_action_status,
                 pce_err_id)
              values
                (#handle#,
                 '#linea#',
                 '#estado_ppay#',
                 '#estado_ppay#',
                 'NM',
                 sysdate,
                 sysdate,
                 sysdate,
                 0,
                 v_cpam_ddi_call,
                 v_cpam_ddn_call,
                 v_cpam_local_call,
                 v_cpam_incoming_call,
                 v_cpam_aty_id,
                 0,
                 v_cpam_lty_id,
                 0,
                 v_cpam_sys_code_id,
                 sysdate,
                 sysdate,
                 0,
                 trunc(sysdate),
                 trunc(sysdate) + 300,
                 trunc(sysdate) + 300,
                 trunc(sysdate) + 300,
                 'N',
                 0);
            end;
            """;
    public static final String BLOCK_INSERT_CEL_NUMBER_CHANGES = """
            begin
              insert into cellular_number_changes
                (cnc_handle,
                 cnc_clu_cellular,
                 cnc_add_date,
                 cnc_last_update_date,
                 cnc_start_date,
                 cnc_end_date)
              values
                (%s, '%s', sysdate, sysdate, sysdate, null);
            end;
            """;
    public static final String BLOCK_INSERT_PP_SERVICE_STATUS = """
            begin
              insert into pp_service_status
                (pss_handle,
                 pss_clu_cellular_number,
                 pss_activation_date,
                 pss_pcs_id_actual,
                 pss_start_date,
                 pss_last_updated_date)
              values
                (%s, '%s', sysdate, '%s', sysdate, sysdate);
            end;
            """;
    public static final String BLOCK_INSERT_CELLULAR_PLANS = """
            declare
              v_linea           cellulars.clu_cellular_number%type;
              v_plan            rate_plans.rpl_id%type;
              v_activation_date cellulars.clu_activation_date%type;
              v_end_date        date;
              cursor c_requeridos(linea cellulars.clu_cellular_number%type) is
                select bsg_stg_id
                  from business_service_type_groups,
                       cellular_business_types
                 where bsg_bus_id = cbt_bus_id
                   and cbt_id = (select clu_cbt_id from cellulars where clu_cellular_number = linea)
                   and bsg_required_flag = 'Y';
            begin
              v_linea := '#linea#';
              v_plan  := '#planSTH#';
              v_end_date := to_date('30/12/3999 11:59:59', 'dd/mm/yyyy hh24:mi:ss');
              insert into cellular_plans
                (cpl_clu_cellular_number,
                 cpl_stg_id,
                 cpl_rpl_id,
                 cpl_start_date,
                 cpl_end_date,
                 cpl_due_date,
                 cpl_usr_id,
                 cpl_add_date)
                select v_linea,
                       rpa_stg_id,
                       rpa_rpl_id_assignment,
                       sysdate,
                       v_end_date,
                       v_end_date,
                       'WEB',
                       sysdate
                  from rate_plan_assignments
                 where rpa_start_date <= trunc(sysdate)
                   and (rpa_end_date is null or rpa_end_date > trunc(sysdate))
                   and rpa_rpl_id_air = v_plan;
              for r_req in c_requeridos(v_linea) loop
                insert into cellular_plans
                  (cpl_clu_cellular_number,
                   cpl_stg_id,
                   cpl_rpl_id,
                   cpl_start_date,
                   cpl_end_date,
                   cpl_due_date,
                   cpl_usr_id,
                   cpl_add_date)
                values
                  (v_linea, r_req.bsg_stg_id, v_plan, sysdate, v_end_date, v_end_date, 'WEB', sysdate);
              end loop;
            end;
            """;
    public static final String BLOCK_INSERT_RATE_PLAN = """
            declare
              v_linea           cellulars.clu_cellular_number%type;
              v_plan            rate_plans.rpl_id%type;
              v_activation_date cellulars.clu_activation_date%type;
              v_end_date        date;
              cursor c_requeridos(linea cellulars.clu_cellular_number%type) is
                select bsg_stg_id
                  from business_service_type_groups,
                       cellular_business_types
                 where bsg_bus_id = cbt_bus_id
                   and cbt_id = (select clu_cbt_id from cellulars where clu_cellular_number = linea)
                   and bsg_required_flag = 'Y';
            begin
              v_linea := '#linea#';
              v_plan  := '#plan#';
              v_end_date := to_date('30/12/3999 11:59:59', 'dd/mm/yyyy hh24:mi:ss');
              insert into cellular_plans
                (cpl_clu_cellular_number,
                 cpl_stg_id,
                 cpl_rpl_id,
                 cpl_start_date,
                 cpl_end_date,
                 cpl_due_date,
                 cpl_usr_id,
                 cpl_add_date)
                select v_linea,
                       rpa_stg_id,
                       rpa_rpl_id_assignment,
                       sysdate,
                       v_end_date,
                       v_end_date,
                       'WEB',
                       sysdate
                  from rate_plan_assignments
                 where rpa_start_date <= trunc(sysdate)
                   and (rpa_end_date is null or rpa_end_date > trunc(sysdate))
                   and rpa_rpl_id_air = v_plan;
              for r_req in c_requeridos(v_linea) loop
                insert into cellular_plans
                  (cpl_clu_cellular_number,
                   cpl_stg_id,
                   cpl_rpl_id,
                   cpl_start_date,
                   cpl_end_date,
                   cpl_due_date,
                   cpl_usr_id,
                   cpl_add_date)
                values
                  (v_linea, r_req.bsg_stg_id, v_plan, sysdate, v_end_date, v_end_date, 'WEB', sysdate);
              end loop;
              commit;
            end;
            """;
    public static final String BLOCK_INSERT_CELLULAR_PACKAGES = """
            begin
              insert into cellular_packages
                (cpk_clu_cellular_number,
                 cpk_pkt_id,
                 cpk_activation_date,
                 cpk_price_type,
                 cpk_usr_id_is_load,
                 cpk_move_type)
              values
                ('%s', '%s', sysdate, 'P', 'WEB', 'A');
            end;
            """;
    public static final String BLOCK_DELETE_SIM_CELLULAR = """
            declare
              v_iccid    sims.sim_iccid%%type := '%s';
              v_esn_hexa electronical_serial_numbers.esn_hexa%%type := '%s';
              v_lote_id  sims.sim_lote_id%%type;
              cursor c_lotes(p_iccid sims.sim_iccid%%type) is
                select sim_lote_id from sims where sim_iccid = p_iccid;
            begin
              begin
                select sim_lote_id into v_lote_id from sims where sim_iccid = v_iccid;
                delete from sims where sim_iccid = v_iccid;
                delete from lotes_sims where lote_id = v_lote_id;
              exception
                when too_many_rows then
                  for v_lote in c_lotes(v_iccid) loop
                    delete from lotes_sims where lote_id = v_lote.sim_lote_id;
                  end loop;
              end;
              delete from sim_histories where sih_sim_iccid = v_iccid;
              delete from electronical_serial_numbers where esn_hexa = v_esn_hexa;
              commit;
            end;
            """;
    public static final String BLOCK_DELETE_PROD = """
            declare
              v_linea  cellulars.clu_cellular_number%%type := '%s';
              v_user   updates.upd_usr_id%%type := upper('%s');
              v_cet_id cellular_terminal_status.cts_cet_id%%type;
              cursor c_terminals(p_cellular cellular_terminals.cet_clu_cellular_number%%type) is
                select cet_id from cellular_terminals where cet_clu_cellular_number = p_cellular;
            begin
              begin
                delete from applied_tools where apt_clu_cellular_number = v_linea;
              end;
              begin
                delete from cellular_call_restrictions where ccr_clu_cellular_number = v_linea;
              end;
              begin
                delete from cellular_packages where cpk_clu_cellular_number = v_linea;
              end;
              begin
                delete from service_status where sst_clu_cellular_number = v_linea;
              end;
              begin
                delete from cellular_plans where cpl_clu_cellular_number = v_linea;
              end;
              begin
                delete from esn_cellulars where esc_clu_cellular_number = v_linea;
              end;
              begin
                delete from cellulars where clu_cellular_number = v_linea;
              end;
              begin
                delete from activation_ranges where acr_starting_range = v_linea;
              end;
              begin
                delete from cellular_business_histories where cbh_clu_cellular_number = v_linea;
              end;
              begin
                delete from cellular_accounts where cac_clu_cellular_number = v_linea;
              end;
              begin
                begin
                  select cet_id into v_cet_id from cellular_terminals where cet_clu_cellular_number = v_linea;
                  delete from cellular_terminal_status where cts_cet_id = v_cet_id;
                  delete from cellular_terminals where cet_clu_cellular_number = v_linea;
                exception
                  when too_many_rows then
                    for v_term in c_terminals(v_linea) loop
                      delete from cellular_terminals where cet_clu_cellular_number = v_linea;
                      delete from cellular_terminal_status where cts_cet_id = v_term.cet_id;
                    end loop;
                  when no_data_found then
                    null;
                end;
              end;
              begin
                delete from cellular_services where cese_clu_cellular_number = v_linea;
              end;
              begin
                delete from updates where upd_table_name in ('ACCOUNTS', 'CELLULARS') and upd_usr_id = v_user;
              end;
              begin
                delete from gsm_wap_interfaces where gwi_clu_bill_number = v_linea;
              end;
              begin
                delete from strmadmin.fms_cellular_events where fcv_cellular_number = v_linea;
              end;
              begin
                delete from strmadmin.fms_cellular_events_ogg where fcv_cellular_number = v_linea;
              end;
              begin
                delete from credit_limit_assignments where clas_clu_cellular_number = v_linea;
              end;
              begin
                delete from planes_borrados where celular = v_linea;
              end;
              commit;
            end;
            """;
    public static final String BLOCK_DELETE_CCARD = """
            declare
              v_linea prepay_cellulars.pce_clu_cellular_number%%type := '%s';
            begin
              delete from cellular_number_changes where cnc_clu_cellular = v_linea;
              delete from prepay_cellulars where pce_clu_cellular_number = v_linea;
              delete from pp_service_status_hist where psh_clu_cellular_number = v_linea;
              delete from %s.hubble_interfaces_tmp where hin_cellular_number = v_linea;
              commit;
            end;
            """;
    public static final String BLOCK_DELETE_CELLULAR_CU = """
            declare
              v_linea cellulars.clu_cellular_number%type := '#linea#';
            begin
              execute immediate 'ALTER TRIGGER TRIG_INSCLU DISABLE';
              execute immediate 'ALTER TRIGGER TRIG_DELCLU DISABLE';
              execute immediate 'ALTER TRIGGER TRG_FMS_ONDELETE_CELLULARS DISABLE';
              delete from cellulars where clu_cellular_number = v_linea;
              delete from activation_ranges where acr_starting_range = v_linea;
              delete from cellular_business_histories where cbh_clu_cellular_number = v_linea;
              delete from cellular_accounts where cac_clu_cellular_number = v_linea;
              delete from esn_cellulars where esc_clu_cellular_number = v_linea;
              delete from cellular_terminals where cet_clu_cellular_number = v_linea;
              delete from service_status where sst_clu_cellular_number = v_linea;
              delete from cellular_call_restrictions where ccr_clu_cellular_number = v_linea;
              delete from cellular_plans where cpl_clu_cellular_number = v_linea;
              delete from cellular_packages where cpk_clu_cellular_number = v_linea;
              delete from prepay_cellulars where pce_clu_cellular_number = v_linea;
              delete from cellular_number_changes where cnc_clu_cellular = v_linea;
              execute immediate 'ALTER TRIGGER TRIG_INSCLU ENABLE';
              execute immediate 'ALTER TRIGGER TRIG_DELCLU ENABLE';
              execute immediate 'ALTER TRIGGER TRG_FMS_ONDELETE_CELLULARS ENABLE';
            exception
              when no_data_found then
                null;
            end;
            """;
    public static final String BLOCK_INSERT_ACTIVATION_RANGES = """
            begin
              delete from activation_ranges where acr_starting_range = %s;
              insert into activation_ranges
                (acr_starting_range,
                 acr_ending_range,
                 acr_blc_block_code,
                 acr_mpp,
                 acr_bill_prefix,
                 acr_start_bill_range,
                 acr_end_bill_range,
                 acr_starting_bill,
                 acr_ending_bill,
                 acr_usr_id,
                 acr_add_date)
              values
                ('%s', '%s', '%s', 'N', '%s', '%s', '%s', '%s', '%s', '%s', sysdate);
            end;
            """;
    public static final String BLOCK_INSERT_CREDIT_LIMIT = """
            declare
              v_cellular_number varchar2(15) := '%s';
              v_handle          number := %s;
              v_rpl_id          varchar2(7) := '%s';
              v_bill_number     varchar2(15) := '%s';
            begin
              delete from credit_limit_assignments where clas_clu_cellular_number = v_cellular_number;
              insert into credit_limit_assignments
                (clas_clu_cellular_number,
                 clas_pce_handle,
                 clas_credit_limit_automatic,
                 clas_credit_limit_manual,
                 clas_credit_limit_manual_flag,
                 clas_credit_limit_excedent,
                 clas_excedent_expiry_date,
                 clas_start_date,
                 clas_user_id,
                 clas_rsk_id,
                 clas_rpl_id,
                 clas_coefficient_value,
                 clas_clu_bill_number,
                 clas_credit_limit_autoscore,
                 clas_score_id,
                 clas_coefscore_value,
                 clas_plan_price)
              values
                (v_cellular_number,
                 v_handle,
                 8400,
                 null,
                 null,
                 null,
                 null,
                 to_date('12-07-2022 12:57:31', 'DD-MM-YYYY HH24:MI:SS'),
                 'PREPAGO',
                 'M',
                 v_rpl_id,
                 2,
                 v_bill_number,
                 6300,
                 '1M',
                 1,
                 4200);
            end;
            """;

    public static final String QUERY_UPDATE_CELLULARS_BILL_NUMBER = """
            UPDATE cellulars SET clu_bill_number = '%s' WHERE clu_cellular_number = '%s'
            """;
}
