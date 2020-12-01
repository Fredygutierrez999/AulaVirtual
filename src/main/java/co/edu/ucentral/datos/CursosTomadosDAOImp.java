/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Curso;
import co.edu.ucentral.models.CursosTomados;
import co.edu.ucentral.models.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

@Stateless
public class CursosTomadosDAOImp implements CursosTomadosDAO {

    @PersistenceContext(unitName = "AulaWeb")
    private EntityManager em;

    @Override
    public List<CursosTomados> listCursosTomados() {
        return em.createNamedQuery("CursosTomados.findAll", CursosTomados.class).getResultList();
    }

    @Override
    public CursosTomados findByCursosTomados(CursosTomados cursosTomados) {
        return em.find(CursosTomados.class, cursosTomados.getIdCursosTomados());
    }

    @Override
    public void insertCursosTomados(CursosTomados cursosTomados) {
        em.persist(cursosTomados);
    }

    @Override
    public void updateCursosTomados(CursosTomados cursosTomados) {
        em.merge(cursosTomados);
    }

    @Override
    public void deleteCursosTomados(CursosTomados cursosTomados) {
        em.remove(em.merge(cursosTomados));
    }

    
    @Override
    public List<CursosTomados> listCursosTomadosPorUsuario(Usuario IdUsuario) {
        Query query = em.createNamedQuery("CursosTomados.findByIdUsuarios");
        query.setParameter("idUsuarioEstudiante", IdUsuario);
        return (List<CursosTomados>) query.getResultList();
    }
    
    @Override
    public List<CursosTomados> listCursosTomadosPorUsuarioYCurso(Usuario IdUsuario, Curso IdCurso) {
        Query query = em.createNamedQuery("CursosTomados.findByIdUsuariosYIdCurso");
        query.setParameter("idUsuarioEstudiante", IdUsuario);
        query.setParameter("IdCurso", IdCurso);
        return (List<CursosTomados>) query.getResultList();
    }
    
}
