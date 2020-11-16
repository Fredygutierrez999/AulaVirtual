/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.ResultadoRespuesta;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface ResultadoRespuestaService {
    public List<ResultadoRespuesta> listadoResultadoRespuesta();
    public ResultadoRespuesta resultadoRespuestaPorId(ResultadoRespuesta resultadoRespuesta);
    public void guardarResultadoRespues(ResultadoRespuesta resultadoRespuesta);
    public void modificarResultadoRespues(ResultadoRespuesta resultadoRespuesta);
    public void eliminarResultadoRespues(ResultadoRespuesta resultadoRespuesta);      
}
