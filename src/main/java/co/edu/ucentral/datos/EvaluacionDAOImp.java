/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Evaluacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Adolfo
 */
@Stateless
public class EvaluacionDAOImp implements EvaluacionDAO{

    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Evaluacion> listEvaluacion() {
        return em.createNamedQuery("Evaluacion.findAll", Evaluacion.class).getResultList();
    }

    @Override
    public Evaluacion findByEvaluacion(Evaluacion evaluacio) {
        return em.find(Evaluacion.class, evaluacio.getIdEvaluacion());
    }

    @Override
    public void insertEvaluacion(Evaluacion evaluacio) {
        em.persist(evaluacio);
    }

    @Override
    public void updateEvaluacion(Evaluacion evaluacio) {
        em.merge(evaluacio);
    }

    @Override
    public void deleteEvaluacion(Evaluacion evaluacio) {
        em.remove(em.merge(evaluacio));
    }

}
