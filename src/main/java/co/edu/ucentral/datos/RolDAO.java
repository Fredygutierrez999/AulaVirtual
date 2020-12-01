/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Rol;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface RolDAO {

    public List<Rol> listadoRoles();

    public Rol findByIdRol(Rol rol);

    public void insertRol(Rol rol);

    public void updateRol(Rol rol);

    public void deleteRol(Rol rol);

}
