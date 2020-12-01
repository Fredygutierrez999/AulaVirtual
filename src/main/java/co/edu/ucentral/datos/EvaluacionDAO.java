/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Evaluacion;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface EvaluacionDAO {

    public List<Evaluacion> listEvaluacion();

    public Evaluacion findByEvaluacion(Evaluacion evaluacio);

    public void insertEvaluacion(Evaluacion evaluacio);

    public void updateEvaluacion(Evaluacion evaluacio);

    public void deleteEvaluacion(Evaluacion evaluacio);
}
