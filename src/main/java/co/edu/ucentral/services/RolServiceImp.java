/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.RolDAO;
import co.edu.ucentral.models.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class RolServiceImp implements RolService{

    @Inject
    private RolDAO rolDAO;
    @Override
    public List<Rol> listadoRol() {
       return rolDAO.listadoRoles();
    }

    @Override
    public Rol rolPorId(Rol rol) {
        return rolDAO.findByIdRol(rol);
    }

    @Override
    public void guardarRol(Rol rol) {
       rolDAO.insertRol(rol);
    }

    @Override
    public void modificarRol(Rol rol) {
        rolDAO.updateRol(rol);
    }

    @Override
    public void eliminarRol(Rol rol) {
        rolDAO.deleteRol(rol);
    }
    
}
