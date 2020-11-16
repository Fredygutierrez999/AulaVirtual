/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Clase;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface ClaseDao {
    public List<Clase> listClase();
    public Clase findByCurso(Clase clase);
    public void insertCurso(Clase clase);
    public void updateCurso(Clase clase);
    public void deleteCurso(Clase clase);
}
