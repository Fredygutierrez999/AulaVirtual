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
@Table(name = "Departamento")
@NamedQueries(
        {
            @NamedQuery(name = "findAll", query = "SELECT p FROM Departamento p"),
            @NamedQuery(name = "findById", query = "SELECT p FROM Departamento p WHERE p.IdDepartamento = :IdDepartamento")
        }
)
public class Departamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdDepartamento;
    private Facultad facultad;
    private String Nombre;

    public Departamento() {
    }

    public Departamento(int IdDepartamento, Facultad facultad, String Nombre) {
        this.IdDepartamento = IdDepartamento;
        this.facultad = facultad;
        this.Nombre = Nombre;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Departamento{" + "IdDepartamento=" + IdDepartamento + ", facultad=" + facultad + ", Nombre=" + Nombre + '}';
    }
    
    
}
