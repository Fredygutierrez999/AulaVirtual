/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Curso;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface CursoDAO {
    public List<Curso> listCursos();
    public Curso findByCurso(Curso cursos);
    public void insertCurso(Curso cursos);
    public void updateCurso(Curso cursos);
    public void deleteCurso(Curso cursos);
}
