/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Curso;
import co.edu.ucentral.models.Periodo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adolfo
 */
@Stateless
public class PeriodoDAOImp implements PeriodoDAO {

    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Periodo> listPeriodo() {
        return em.createNamedQuery("Periodo.findAll", Periodo.class).getResultList();
    }

    @Override
    public List<Periodo> listPeriodoPorEstado(boolean activo) {
        Query query = em.createNamedQuery("Periodo.findByActivo");
        query.setParameter("activo", activo);
        return (List<Periodo>) query.getResultList();
    }

    @Override
    public Periodo findByPeriodo(Periodo periodo) {
        return em.find(Periodo.class, periodo.getIdPeriodo());
    }

    @Override
    public void insertPeriodo(Periodo periodo) {
        em.persist(periodo);
    }

    @Override
    public void updatePeriodo(Periodo periodo) {
        em.merge(periodo);
    }

    @Override
    public void deletePeriodo(Periodo periodo) {
        em.remove(em.merge(periodo));
    }

}
