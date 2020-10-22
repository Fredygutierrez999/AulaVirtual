/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
@Entity
@Table(name = "Facultad")
@NamedQueries(
        {
            @NamedQuery(name = "findAll.Facultad", query = "SELECT p FROM Facultad p"),
            @NamedQuery(name = "findById.Facultad", query = "SELECT p FROM Facultad p WHERE p.IdFacultad = :IdFacultad")
        }
)
public class Facultad implements Serializable,InterfaceModelo{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdFacultad;
    private String Nombre;

    public Facultad() {
    }

    public Facultad(int IdFacultad, String Nombre) {
        this.IdFacultad = IdFacultad;
        this.Nombre = Nombre;
    }

    public int getIdFacultad() {
        return IdFacultad;
    }

    public void setIdFacultad(int IdFacultad) {
        this.IdFacultad = IdFacultad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Facultad{" + "IdFacultad=" + IdFacultad + ", Nombre=" + Nombre + '}';
    }

}
