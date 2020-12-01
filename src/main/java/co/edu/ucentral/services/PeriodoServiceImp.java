/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.PeriodoDAO;
import co.edu.ucentral.models.Periodo;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class PeriodoServiceImp implements PeriodoService {

    @Inject
    private PeriodoDAO peridoDAO;

    @Override
    public List<Periodo> listadoPeriodo() {
        return peridoDAO.listPeriodo();
    }

    @Override
    public Periodo periodoPorId(Periodo periodo) {
        return peridoDAO.findByPeriodo(periodo);
    }

    @Override
    public void guardarPeriodo(Periodo periodo) {
        peridoDAO.insertPeriodo(periodo);
    }

    @Override
    public void modificarPeriodo(Periodo periodo) {
        peridoDAO.updatePeriodo(periodo);
    }

    @Override
    public void eliminarPeriodo(Periodo periodo) {
        peridoDAO.deletePeriodo(periodo);
    }

}
