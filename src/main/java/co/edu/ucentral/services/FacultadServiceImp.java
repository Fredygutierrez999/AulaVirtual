/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.FacultadDAO;
import co.edu.ucentral.models.Facultad;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
public class FacultadServiceImp implements FacultadService {

    @Inject
    private FacultadDAO facultadDAO;
    @Override
    public List<Facultad> listadoFacultad() {
        return facultadDAO.listFacultad();
    }

    @Override
    public Facultad facultadPorId(Facultad facultad) {
        return facultadDAO.findByFacultad(facultad);
    }

    @Override
    public void guardarFacultad(Facultad facultad) {
        facultadDAO.insertFacultad(facultad);
    }

    @Override
    public void modificarFacultad(Facultad facultad) {
        facultadDAO.updateFacultad(facultad);
    }

    @Override
    public void eliminarFacultad(Facultad facultad) {
        facultadDAO.deleteFacultad(facultad);
    }
 
}
