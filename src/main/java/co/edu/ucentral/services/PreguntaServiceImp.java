/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.PreguntaDAO;
import co.edu.ucentral.models.Pregunta;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
public class PreguntaServiceImp implements PreguntaService {

    @Inject
    private PreguntaDAO preguntaDAO;
    
    @Override
    public List<Pregunta> listadoPregunta() {
        return preguntaDAO.listPregunta();
    }

    @Override
    public Pregunta preguntaPorId(Pregunta pregunta) {
        return preguntaDAO.findByPregunta(pregunta);
    }

    @Override
    public void guardarPregunta(Pregunta pregunta) {
       preguntaDAO.insertPregunta(pregunta);
    }

    @Override
    public void modificarPregunta(Pregunta pregunta) {
        preguntaDAO.updatePregunta(pregunta);
    }

    @Override
    public void eliminarPregunta(Pregunta pregunta) {
        preguntaDAO.deletePregunta(pregunta);
    }
    
}
