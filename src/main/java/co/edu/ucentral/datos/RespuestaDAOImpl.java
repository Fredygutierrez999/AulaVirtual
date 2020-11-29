/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Respuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adolfo
 */
@Stateless
public class RespuestaDAOImpl implements RespuestaDAO {

    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Respuesta> listResultado() {
        return em.createNamedQuery("Respuesta.findAll", Respuesta.class).getResultList();
    }

    @Override
    public Respuesta findByRespuesta(Respuesta respuesta) {
        return em.find(Respuesta.class, respuesta.getIdRespuesta());
    }

    @Override
    public void insertRespuesta(Respuesta respuesta) {
        em.persist(respuesta);
    }

    @Override
    public void updateRespuesta(Respuesta respuesta) {
        em.merge(respuesta);
    }

    @Override
    public void deleteRespuesta(Respuesta respuesta) {
        em.remove(em.merge(respuesta));
    }

}
