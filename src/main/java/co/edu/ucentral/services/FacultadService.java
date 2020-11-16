/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.models.Facultad;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface FacultadService {
    public List<Facultad> listadoFacultad();
    public Facultad facultadPorId(Facultad facultad);
    public void guardarFacultad(Facultad facultad);
    public void modificarFacultad(Facultad facultad);
    public void eliminarFacultad(Facultad facultad);     
}
