/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Departamento;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface DepartamentoServices {
    public List<Departamento> listadoDepartamento();
    public Departamento clasePorId(Departamento departamento);
    public void guardarCursosTomado(Departamento departamento);
    public void modificarCursosTomado(Departamento departamento);
    public void eliminarCursosTomado(Departamento departamento); 
}
