package com.claro.sp.automation.controller;

import com.claro.sp.automation.exceptions.InvalidCountryException;
import com.claro.sp.automation.manager.*;
import com.claro.sp.automation.model.subscriber.Balance;
import com.claro.sp.automation.model.subscriber.Cellular;
import com.claro.sp.automation.model.subscriber.Slot;
import com.claro.sp.ta.db.model.DataBaseProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CellularController {
    private final Manager sthManager;
    private static final Logger LOG = LoggerFactory.getLogger(CellularController.class);
    public CellularController() throws InvalidCountryException {
        sthManager = Manager.create(DataBaseProperties.country);
    }

    public CellularController(String environment, String country, String userProd, String passwordProd, String userCcard, String passwordCcard) throws InvalidCountryException {
        setDataBaseProperties(environment, country, userProd, passwordProd, userCcard, passwordCcard);
        sthManager = Manager.create(country);
    }

    private static void setDataBaseProperties(String... prop) {
        DataBaseProperties.environment = prop[0];
        DataBaseProperties.country = prop[1];
        DataBaseProperties.userProd = prop[2];
        DataBaseProperties.passwordProd = prop[3];
        DataBaseProperties.userCcard = prop[4];
        DataBaseProperties.passwordCcard = prop[5];
    }

    public Cellular cellularProvisioning(Cellular c) throws Exception {
        try (var prodConnection = sthManager.getProdConn();
             var ccardConnection = sthManager.getCcardConn())
        {
            executeBaseProvisioning(c);
            return c;
        } catch (Exception e) {
            rollback(c);
            throw e;
        }
    }

    private void executeBaseProvisioning(Cellular c) throws Exception {
        this.sthManager.validateInitialCellularData(c);
        this.sthManager.initCellular(c);
        this.createNim(c);
        this.createSim(c);
        this.sthManager.insertCelBussinesHist(c);
        this.sthManager.insertCellularAccounts(c);
        this.sthManager.createSubscriberInTn3(c);
        this.updateStatus(c);
        this.sthManager.insertRatePlan(c);
        this.sthManager.insertBasicPacksSTH(c);
        if (c.getBusinessType().equalsIgnoreCase("CR"))
            this.sthManager.insertCreditLimit(c);
    }

    private void rollback(Cellular c) throws Exception {
        try (var prodConnection = sthManager.getProdConn();
             var ccardConnection = sthManager.getCcardConn())
        {
            this.sthManager.deleteSubscriber(c);
        }
    }

    public Cellular cellularProvisioning(Cellular c, List<Slot> slots) throws Exception {
        try (var prodConnection = sthManager.getProdConn();
             var ccardConnection = sthManager.getCcardConn())
        {
            executeBaseProvisioning(c);
            providePacksToSlots(c, slots);
            return c;
        } catch (Exception e) {
            rollback(c);
            throw e;
        }
    }

    private void providePacksToSlots(Cellular c, List<Slot> slots) throws Exception {
        if (slots == null)
            throw new Exception("ERROR: La lista -slots- no fue cargada. slots = null");
        for (Slot s : slots) {
            this.sthManager.initPacks(s);
            this.sthManager.insertPack(c, s);
        }
    }

    public Cellular cellularProvisioning(Cellular c, ArrayList<Balance> balances) throws Exception {
        try (var prodConnection = sthManager.getProdConn();
             var ccardConnection = sthManager.getCcardConn())
        {
            executeBaseProvisioning(c);
            provideBalanceToBags(c, balances);
            return c;
        } catch (Exception e) {
            rollback(c);
            throw e;
        }
    }

    private void provideBalanceToBags(Cellular c, ArrayList<Balance> balances) throws Exception {
        if (balances == null)
            throw new Exception("ERROR: La lista -balances- no fue cargada. balances = null");
        for (Balance b : balances)
            this.sthManager.loadBags(c, b);
    }

    public Cellular cellularProvisioning(Cellular c, List<Slot> slots, ArrayList<Balance> balances) throws Exception {
        try (var prodConnection = sthManager.getProdConn();
             var ccardConnection = sthManager.getCcardConn())
        {
            executeBaseProvisioning(c);
            provideBalanceToBags(c, balances);
            providePacksToSlots(c, slots);
            return c;
        } catch (Exception e) {
            rollback(c);
            throw e;
        }
    }

    public void createNim(Cellular c) throws Exception {
        String nim = null;
        String bill = null;
        String handle = null;

        do {
            nim = this.sthManager.createRandomNim(c);
        } while (!this.sthManager.checkNim(nim));

        c.setCellularNumber(nim);

        if (c.isDistinctBillNumber()) {
            do {
                bill = this.sthManager.createRandomNim(c);
            } while (!this.sthManager.checkNim(bill));
            c.setBillNumber(bill);
        } else {
            c.setBillNumber(nim);
        }

        do {
            handle = this.sthManager.createHandle(c);
        } while (!this.sthManager.checkHandle(handle));

        c.setHandle(handle);

        this.sthManager.insertActivationRanges(c);
        this.sthManager.insertCellulars(c);
        if (c.isDistinctBillNumber()){
            this.sthManager.updateBillNumber(c);
        }
        this.sthManager.insertPrepayCellulars(c);
        this.sthManager.insertCellularNumberChanges(c);
    }

    public void createSim(Cellular c) throws Exception {

        this.sthManager.loadSubid(c);

        if (c.isFlagSims()) {

            this.sthManager.createSim(c);

            if (!this.sthManager.checkAndLoadSim(c)) {
                throw new Exception("ERROR: Al asignar SIM a la linea");
            }

            this.sthManager.updateCellularsEsn(c);
            this.sthManager.asignSimToCellular(c);

        } else {
            c.setImsi(c.getSubid());
        }

    }

    public void updateStatus(Cellular c) {
        try {
            this.sthManager.insertServiceStatus(c);
            this.sthManager.insertCellularCallRestrictions(c);
            this.sthManager.insertPpServiceStatus(c);
            this.sthManager.updateStatusInTn3(c);
        } catch (Exception e) {
            LOG.error("Error al actualizar el estado del celular: {}", c, e);
        }
    }

    public void deleteCellular(Cellular c) throws Exception {
        try (var prodConnection = sthManager.getProdConn();
             var ccardConnection = sthManager.getCcardConn())
        {
            if (c.getSubid() == null)
                this.sthManager.loadSubid(c);
            //Verifico si la tarjeta sim se encuentra registrada con el subId/msisdn encontrado
            if (c.isFlagSims() && !this.sthManager.checkAndLoadSim(c))
                throw new Exception("ERROR: No hay tarjetas SIM registradas para el subId de la linea");
            this.sthManager.deleteSubscriber(c);
        }
    }

    //Método utilizado para la creación del nim AFTER cuando se prueba el Cambio de NUMERO (CU)
    public void insertCellularsCU(Cellular c) throws Exception {
        try (var prodConnection = sthManager.getProdConn()) {
            this.sthManager.insertCellulars(c);
        }
    }

    //Método utilizado para obtener el subid del nim cuando se prueba el Cambio de NUMERO (CU)
    public String obtainSubidCU(Cellular c) throws Exception {
        try (var prodConnection = sthManager.getProdConn()) {
            return this.sthManager.obtainSubid(c);
        }
    }

    //Método utilizado para el borrado del nim cuando se prueba el Cambio de NUMERO (CU)
    public void deleteCellularsCU(Cellular c) throws Exception {
        try (var prodConnection = sthManager.getProdConn();
             var ccardConnection = sthManager.getCcardConn())
        {
            this.sthManager.deleteCellulars(c);
        }
    }

    /**
     * Método que se utiliza para crear líneas con un cierto rango de finalización
     * Al invocarlo activa la flag que permite introducir los rangos personalizados
     *
     * @Parameters comienzo y fin de rango (deben ser de dos dígitos)
     */

    public void setRangeLine(Cellular c, String begin, String end) {
        c.setFlagRange(true);
        c.setBeginRange(begin);
        c.setEndRange(end);
    }

    /**
     * Metodo que se utiliza para crear lineas con/sin la generación y asignación de la tarjeta SIM.
     * Por defecto, es true, ya que existen casos de prueba en los cuales se requiere de esta flag
     * para la posterior ejecución correcta, evitando problemas de regresión.
     *
     * @param c                         el Objeto Celular al cual se aplica la generacion Sims
     * @param isSimsGenerationActivated la flag que activa (true) o desactiva (false) la creacion de SIM
     */
    public void setGenerateSims(Cellular c, boolean isSimsGenerationActivated) {
        c.setFlagSims(isSimsGenerationActivated);
    }

}
