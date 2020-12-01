/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Adolfo
 */
@Local
public interface RolService {

    public List<Rol> listadoRol();

    public Rol rolPorId(Rol rol);

    public void guardarRol(Rol rol);

    public void modificarRol(Rol rol);

    public void eliminarRol(Rol rol);
}
