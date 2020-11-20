/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Periodo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Adolfo
 */
@Local
public interface PeriodoService {
    public List<Periodo> listadoPeriodo();
    public Periodo periodoPorId(Periodo periodo);
    public void guardarPeriodo(Periodo periodo);
    public void modificarPeriodo(Periodo periodo);
    public void eliminarPeriodo(Periodo periodo);     
}
