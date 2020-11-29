/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.CursoDAO;
import co.edu.ucentral.models.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class CursoServiceImp implements CursoService {

    @Inject
    private CursoDAO cursoDAO;

    @Override
    public List<Curso> listadoCurso() {
        return cursoDAO.listCursos();
    }

    @Override
    public Curso clasePorId(Curso curso) {
        return cursoDAO.findByCurso(curso);
    }

    @Override
    public void guardarClase(Curso curso) {
        cursoDAO.insertCurso(curso);
    }

    @Override
    public void modificarClase(Curso curso) {
        cursoDAO.updateCurso(curso);
    }

    @Override
    public void eliminarClase(Curso curso) {
        cursoDAO.deleteCurso(curso);
    }

}
