/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.ResultadoRespuesta;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface ResultadoRespuestaDAO {

    public List<ResultadoRespuesta> listResultado();

    public ResultadoRespuesta findByResultadoRespuesta(ResultadoRespuesta resultadoRespuesta);

    public void insertResultadoRespuesta(ResultadoRespuesta resultadoRespuesta);

    public void updateResultadoRespuesta(ResultadoRespuesta resultadoRespuesta);

    public void deleteResultadoRespuesta(ResultadoRespuesta resultadoRespuesta);
}
