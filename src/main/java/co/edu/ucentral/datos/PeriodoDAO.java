/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Periodo;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface PeriodoDAO {

    public List<Periodo> listPeriodo();

    public Periodo findByPeriodo(Periodo periodo);

    public void insertPeriodo(Periodo periodo);

    public void updatePeriodo(Periodo periodo);

    public void deletePeriodo(Periodo periodo);
}
