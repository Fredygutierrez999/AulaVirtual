/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.ResultadoRespuestaDAO;
import co.edu.ucentral.models.ResultadoRespuesta;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
public class ResultadoRespuestaServiceImp implements ResultadoRespuestaService{

    @Inject
    private ResultadoRespuestaDAO resultadoRespuestaDAO;
    
    @Override
    public List<ResultadoRespuesta> listadoResultadoRespuesta() {
        return resultadoRespuestaDAO.listResultado();
    }

    @Override
    public ResultadoRespuesta resultadoRespuestaPorId(ResultadoRespuesta resultadoRespuesta) {
        return resultadoRespuestaDAO.findByResultadoRespuesta(resultadoRespuesta);
    }

    @Override
    public void guardarResultadoRespues(ResultadoRespuesta resultadoRespuesta) {
        resultadoRespuestaDAO.insertResultadoRespuesta(resultadoRespuesta);
    }

    @Override
    public void modificarResultadoRespues(ResultadoRespuesta resultadoRespuesta) {
        resultadoRespuestaDAO.updateResultadoRespuesta(resultadoRespuesta);
    }

    @Override
    public void eliminarResultadoRespues(ResultadoRespuesta resultadoRespuesta) {
        resultadoRespuestaDAO.deleteResultadoRespuesta(resultadoRespuesta);
    }
    
}
