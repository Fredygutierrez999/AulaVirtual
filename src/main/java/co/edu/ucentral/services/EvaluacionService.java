/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Evaluacion;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface EvaluacionService {
    public List<Evaluacion> listEvaluacion();
    public Evaluacion findByEvaluacion(Evaluacion evaluacion);
    public void insertEvaluacion(Evaluacion evaluacion);
    public void updateEvaluacion(Evaluacion evaluacion);
    public void deleteEvaluacion(Evaluacion evaluacion);     
}
