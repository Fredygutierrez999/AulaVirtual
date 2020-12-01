/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Pregunta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adolfo
 */
@Stateless
public class PreguntaDAOImpl implements PreguntaDAO {

    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Pregunta> listPregunta() {
        return em.createNamedQuery("Pregunta.findAll", Pregunta.class).getResultList();
    }

    @Override
    public Pregunta findByPregunta(Pregunta pregunta) {
        return em.find(Pregunta.class, pregunta.getIdPregunta());
    }
    

    @Override
    public void insertPregunta(Pregunta pregunta) {
        em.persist(pregunta);
    }

    @Override
    public void updatePregunta(Pregunta pregunta) {
        em.merge(pregunta);
    }

    @Override
    public void deletePregunta(Pregunta pregunta) {
        em.remove(em.merge(pregunta));
    }

}
