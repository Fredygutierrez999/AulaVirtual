/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Clase;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

@Stateless
public class ClaseDAOImp implements  ClaseDao{
   @PersistenceUnit(name = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Clase> listClase() {
        return  em.createNamedQuery("Clase.findAll",Clase.class).getResultList();
    }

    @Override
    public Clase findByCurso(Clase clase) {
        return em.find(Clase.class,clase.getIdClase());
    }

    @Override
    public void insertCurso(Clase clase) {
        em.persist(clase);
    }

    @Override
    public void updateCurso(Clase clase) {
        em.merge(clase);
    }

    @Override
    public void deleteCurso(Clase clase) {
        em.remove(em.merge(em));
    }
 
}
