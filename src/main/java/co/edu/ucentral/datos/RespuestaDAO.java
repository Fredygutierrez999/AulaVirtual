/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Respuesta;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface RespuestaDAO {

    public List<Respuesta> listResultado();
    public Respuesta findByRespuesta(Respuesta respuesta);
    public void insertRespuesta(Respuesta respuesta);
    public void updateRespuesta(Respuesta respuesta);
    public void deleteRespuesta(Respuesta respuesta);
}
