/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Facultad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Adolfo
 */
@Stateless
public class FacultadDAOImp implements FacultadDAO{
    @PersistenceUnit(name = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Facultad> listFacultad() {
        return em.createNamedQuery("Facultad.findAll", Facultad.class).getResultList();
    }

    @Override
    public Facultad findByFacultad(Facultad facultad) {
        return em.find(Facultad.class,facultad.getIdFacultad());
    }

    @Override
    public void insertFacultad(Facultad facultad) {
        em.persist(facultad);
    }

    @Override
    public void updateFacultad(Facultad facultad) {
        em.merge(facultad);
    }

    @Override
    public void deleteFacultad(Facultad facultad) {
        em.remove(em.merge(facultad));
    }

}
