/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Pregunta;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface PreguntaService {
    public List<Pregunta> listadoPregunta();
    public Pregunta preguntaPorId(Pregunta pregunta);
    public void guardarPregunta(Pregunta pregunta);
    public void modificarPregunta(Pregunta pregunta);
    public void eliminarPregunta(Pregunta pregunta);    
}
