/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.DepartamentoDAO;
import co.edu.ucentral.models.Departamento;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
public class DepartamentoServicesImp implements DepartamentoServices {

    @Inject
    private DepartamentoDAO dpDAO;

    @Override
    public List<Departamento> listadoDepartamento() {
        return dpDAO.listDepartamento();
    }

    @Override
    public Departamento clasePorId(Departamento departamento) {
        return dpDAO.findByDepartamento(departamento);

    }

    @Override
    public void guardarCursosTomado(Departamento departamento) {
        dpDAO.insertDepartamento(departamento);
    }

    @Override
    public void modificarCursosTomado(Departamento departamento) {
        dpDAO.updateDepartamento(departamento);
    }

    @Override
    public void eliminarCursosTomado(Departamento departamento) {
        dpDAO.deleteDepartamento(departamento);
    }

}
