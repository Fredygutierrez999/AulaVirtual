/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.RespuestaDAO;
import co.edu.ucentral.models.Respuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class RespuestaServiceImple implements RespuestaService{

    @Inject
    private RespuestaDAO respuestaDAO;
    @Override
    public List<Respuesta> listadoRespuesta() {
        return respuestaDAO.listResultado();
    }

    @Override
    public Respuesta respuestaPorId(Respuesta respuesta) {
        return respuestaDAO.findByRespuesta(respuesta);
    }

    @Override
    public void guardarRespuesta(Respuesta respuesta) {
        respuestaDAO.insertRespuesta(respuesta);
    }

    @Override
    public void modificarRespuesta(Respuesta respuesta) {
        respuestaDAO.updateRespuesta(respuesta);
    }

    @Override
    public void eliminarRespuesta(Respuesta respuesta) {
        respuestaDAO.deleteRespuesta(respuesta);
    }
    
}
