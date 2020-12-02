/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Curso;
import co.edu.ucentral.models.CursosTomados;
import co.edu.ucentral.models.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Adolfo
 */
@Local
public interface CursosTomadoService {

    public List<CursosTomados> listadoCursosTomados();

    public CursosTomados clasePorId(CursosTomados cursosTomados);

    public void guardarCursosTomado(CursosTomados cursosTomados);

    public void modificarCursosTomado(CursosTomados cursosTomados);

    public void eliminarCursosTomado(CursosTomados cursosTomados);
    
    public List<CursosTomados> listCursosTomadosPorUsuario(Usuario IdUsuario);
    
    public List<CursosTomados> listCursosTomadosPorUsuarioYCurso(Usuario IdUsuario, Curso IdCurso);
}
