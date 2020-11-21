/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
public class RolDAOImp implements RolDAO {

    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Rol> listadoRoles() {
        return  em.createNamedQuery("Rol.findAll", Rol.class).getResultList();
    }

    @Override
    public Rol findByIdRol(Rol rol) {
        return  em.find(Rol.class, rol.getIdRol());
    }

    @Override
    public void insertRol(Rol rol) {
        em.persist(rol);
    }

    @Override
    public void updateRol(Rol rol) {
      em.merge(rol);
    }

    @Override
    public void deleteRol(Rol rol) {
        em.remove(rol);
    }

}
