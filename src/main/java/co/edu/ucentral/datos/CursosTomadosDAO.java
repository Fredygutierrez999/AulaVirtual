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

/**
 *
 * @author Adolfo
 */
public interface CursosTomadosDAO {

    public List<CursosTomados> listCursosTomados();

    public CursosTomados findByCursosTomados(CursosTomados cursosTomados);

    public void insertCursosTomados(CursosTomados cursosTomados);

    public void updateCursosTomados(CursosTomados cursosTomados);

    public void deleteCursosTomados(CursosTomados cursosTomados);
    
    public List<CursosTomados> listCursosTomadosPorUsuario(Usuario IdUsuario);
    
    public List<CursosTomados> listCursosTomadosPorUsuarioYCurso(Usuario IdUsuario, Curso IdCurso);
}
