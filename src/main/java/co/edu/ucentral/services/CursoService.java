/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Adolfo
 */
@Local
public interface CursoService {

    public List<Curso> listadoCurso();

    public Curso cursoPorId(Curso curso);
    public void guardarCurso(Curso curso);
    public void modificarCurso(Curso curso);
    public void eliminarCurso(Curso curso);
    public List<Curso> listCursosPorNombre(String nombre);
    
}
