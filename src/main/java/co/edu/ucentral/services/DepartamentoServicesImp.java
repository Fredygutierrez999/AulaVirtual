/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.DepartamentoDAO;
import co.edu.ucentral.models.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class DepartamentoServicesImp implements DepartamentoServices {

    @Inject
    private DepartamentoDAO dpDAO;

    @Override
    public List<Departamento> listadoDepartamento() {
        return dpDAO.listDepartamento();
    }

    @Override
    public Departamento departamentoPorId(Departamento departamento) {
        return dpDAO.findByDepartamento(departamento);

    }

    @Override
    public void guardarDepartamento(Departamento departamento) {
        dpDAO.insertDepartamento(departamento);
    }

    @Override
    public void modificarDepartamento(Departamento departamento) {
        dpDAO.updateDepartamento(departamento);
    }

    @Override
    public void eliminarDepartamento(Departamento departamento) {
        dpDAO.deleteDepartamento(departamento);
    }

}
