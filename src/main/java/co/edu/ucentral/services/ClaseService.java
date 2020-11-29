/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Clase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Adolfo
 */
@Local
public interface ClaseService {

    public List<Clase> listadoClase();

    public Clase clasePorId(Clase clase);

    public void guardarClase(Clase clase);

    public void modificarClase(Clase clase);

    public void eliminarClase(Clase clase);
}
