/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.ResultadoRespuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ResultadoRespuestaDAOImp implements ResultadoRespuestaDAO{
    
    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<ResultadoRespuesta> listResultado() {
        return em.createNamedQuery("ResultadoRespuesta.findAll", ResultadoRespuesta.class).getResultList();
    }

    @Override
    public ResultadoRespuesta findByResultadoRespuesta(ResultadoRespuesta resultadoRespuesta) {
        return em.find(ResultadoRespuesta.class, resultadoRespuesta.getIdResultadoRespuesta());
    }

    @Override
    public void insertResultadoRespuesta(ResultadoRespuesta resultadoRespuesta) {
        em.persist(resultadoRespuesta);
    }

    @Override
    public void updateResultadoRespuesta(ResultadoRespuesta resultadoRespuesta) {
        em.merge(resultadoRespuesta);
    }

    @Override
    public void deleteResultadoRespuesta(ResultadoRespuesta resultadoRespuesta) {
        em.remove(em.merge(resultadoRespuesta));
    }

}
