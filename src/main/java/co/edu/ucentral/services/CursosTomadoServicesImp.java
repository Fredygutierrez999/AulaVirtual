package co.edu.ucentral.services;

import co.edu.ucentral.datos.CursosTomadosDAO;
import co.edu.ucentral.models.Curso;
import co.edu.ucentral.models.CursosTomados;
import co.edu.ucentral.models.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Adolfo
 */
@Stateless
public class CursosTomadoServicesImp implements CursosTomadoService {

    @Inject
    private CursosTomadosDAO cursoTomadosDAO;

    @Override
    public List<CursosTomados> listadoCursosTomados() {
        return cursoTomadosDAO.listCursosTomados();
    }

    @Override
    public CursosTomados clasePorId(CursosTomados cursosTomados) {
        return cursoTomadosDAO.findByCursosTomados(cursosTomados);
    }

    @Override
    public void guardarCursosTomado(CursosTomados cursosTomados) {
        cursoTomadosDAO.insertCursosTomados(cursosTomados);
    }

    @Override
    public void modificarCursosTomado(CursosTomados cursosTomados) {
        cursoTomadosDAO.updateCursosTomados(cursosTomados);
    }

    @Override
    public void eliminarCursosTomado(CursosTomados cursosTomados) {
        cursoTomadosDAO.deleteCursosTomados(cursosTomados);
    }

    @Override
    public List<CursosTomados> listCursosTomadosPorUsuario(Usuario IdUsuario) {
        return cursoTomadosDAO.listCursosTomadosPorUsuario(IdUsuario);
    }

    @Override
    public List<CursosTomados> listCursosTomadosPorUsuarioYCurso(Usuario IdUsuario, Curso IdCurso) {
        return cursoTomadosDAO.listCursosTomadosPorUsuarioYCurso(IdUsuario, IdCurso);
    }
}
