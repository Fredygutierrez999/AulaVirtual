/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.ClaseDao;
import co.edu.ucentral.models.Clase;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class ClaseServiceImp implements ClaseService{

    @Inject
    private ClaseDao claseDAO;
    
    @Override
    public List<Clase> listadoClase() {
        return  claseDAO.listClase();
    }

    @Override
    public Clase clasePorId(Clase clase) {
       return claseDAO.findByCurso(clase);
    }

    @Override
    public void guardarClase(Clase clase) {
        claseDAO.insertCurso(clase);
    }

    @Override
    public void modificarClase(Clase clase) {
       claseDAO.updateCurso(clase);
    }

    @Override
    public void eliminarClase(Clase clase) {
       claseDAO.deleteCurso(clase);
    }
    
}
