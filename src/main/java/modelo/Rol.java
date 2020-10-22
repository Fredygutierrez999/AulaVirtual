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
@Table(name = "Rol")
@NamedQueries(
        {
            @NamedQuery(name = "findAll.Rol", query = "SELECT p FROM Rol p"),
            @NamedQuery(name = "findById.Rol", query = "SELECT p FROM Rol p WHERE p.IdRol = :idPro")
        }
)
public class Rol implements Serializable,InterfaceModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRol;
    private String Nombre;

    public Rol() {
    }

    public Rol(int IdRol, String Nombre) {
        this.IdRol = IdRol;
        this.Nombre = Nombre;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Rol{" + "IdRol=" + IdRol + ", Nombre=" + Nombre + '}';
    }

    
    
}
