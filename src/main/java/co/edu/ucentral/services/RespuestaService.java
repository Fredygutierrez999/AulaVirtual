/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Respuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Adolfo
 */
@Local
public interface RespuestaService {
    public List<Respuesta> listadoRespuesta();
    public Respuesta respuestaPorId(Respuesta respuesta);
    public void guardarRespuesta(Respuesta respuesta);
    public void modificarRespuesta(Respuesta respuesta);
    public void eliminarRespuesta(Respuesta respuesta);    
}
