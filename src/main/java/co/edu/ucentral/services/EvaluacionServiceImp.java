/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.EvaluacionDAO;
import co.edu.ucentral.models.Evaluacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class EvaluacionServiceImp implements EvaluacionService{

    @Inject
    private EvaluacionDAO evaluacionDAO;
    @Override
    public List<Evaluacion> listEvaluacion() {
     return evaluacionDAO.listEvaluacion();
    }

    @Override
    public Evaluacion findByEvaluacion(Evaluacion evaluacion) {
        return evaluacionDAO.findByEvaluacion(evaluacion);
    }

    @Override
    public void insertEvaluacion(Evaluacion evaluacion) {
        evaluacionDAO.insertEvaluacion(evaluacion);
    }

    @Override
    public void updateEvaluacion(Evaluacion evaluacion) {
        evaluacionDAO.updateEvaluacion(evaluacion);
    }

    @Override
    public void deleteEvaluacion(Evaluacion evaluacion) {
        evaluacionDAO.deleteEvaluacion(evaluacion);
    }
    
}
