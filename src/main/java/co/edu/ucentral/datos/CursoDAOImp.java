/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CursoDAOImp implements CursoDAO{

   @PersistenceContext(unitName = "AulaWeb")

    private EntityManager em;

    @Override
    public List<Curso> listCursos() {
      return em.createNamedQuery("Curso.findAll", Curso.class).getResultList();
    }

    @Override
    public Curso findByCurso(Curso cursos) {
        return  em.find(Curso.class, cursos.getIdCurso());
    }

    @Override
    public void insertCurso(Curso cursos) {
        em.persist(cursos);
    }

    @Override
    public void updateCurso(Curso cursos) {
        em.merge(cursos);
    }

    @Override
    public void deleteCurso(Curso cursos) {
        em.remove(em.merge(cursos));
    }
 
}
