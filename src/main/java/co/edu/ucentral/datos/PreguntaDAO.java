/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Pregunta;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface PreguntaDAO {
    public List<Pregunta> listPregunta();
    public Pregunta findByPregunta(Pregunta pregunta);
    public void insertPregunta(Pregunta pregunta);
    public void updatePregunta(Pregunta pregunta);
    public void deletePregunta(Pregunta pregunta);   
}
