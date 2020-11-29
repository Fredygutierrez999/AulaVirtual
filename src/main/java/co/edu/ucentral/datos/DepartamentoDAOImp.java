/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
public class DepartamentoDAOImp implements DepartamentoDAO {

    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Departamento> listDepartamento() {
        return em.createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
    }

    @Override
    public Departamento findByDepartamento(Departamento departamento) {
        return em.find(Departamento.class, departamento.getIdDepartamento());
    }

    @Override
    public void insertDepartamento(Departamento departamento) {
        em.persist(departamento);
    }

    @Override
    public void updateDepartamento(Departamento departamento) {
        em.merge(departamento);
    }

    @Override
    public void deleteDepartamento(Departamento departamento) {
        em.remove(em.merge(departamento));
    }

}
