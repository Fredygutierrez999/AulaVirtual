/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Departamento;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Adolfo
 */
@Local
public interface DepartamentoServices {
    public List<Departamento> listadoDepartamento();
    public Departamento departamentoPorId(Departamento departamento);
    public void guardarDepartamento(Departamento departamento);
    public void modificarDepartamento(Departamento departamento);
    public void eliminarDepartamento(Departamento departamento); 
}
