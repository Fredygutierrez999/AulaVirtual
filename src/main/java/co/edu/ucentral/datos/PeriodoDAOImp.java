/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Periodo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
