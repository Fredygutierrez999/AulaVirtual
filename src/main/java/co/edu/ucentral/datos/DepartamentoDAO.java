/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Departamento;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface DepartamentoDAO {

    public List<Departamento> listDepartamento();

    public Departamento findByDepartamento(Departamento departamento);

    public void insertDepartamento(Departamento departamento);

    public void updateDepartamento(Departamento departamento);

    public void deleteDepartamento(Departamento departamento);
}
