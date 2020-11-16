/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Facultad;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface FacultadDAO {
    public List<Facultad> listFacultad();
    public Facultad findByFacultad(Facultad facultad);
    public void insertFacultad(Facultad facultad);
    public void updateFacultad(Facultad facultad);
    public void deleteFacultad(Facultad facultad);   
}
