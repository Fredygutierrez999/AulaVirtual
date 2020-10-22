/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Clase")
@NamedQueries(
        {
            @NamedQuery(name = "findAll.Clase", query = "SELECT p FROM Clase p"),
            @NamedQuery(name = "findById.Clase", query = "SELECT p FROM Clase p WHERE p.IdClase = :IdClase")
        }
)
public class Clase implements Serializable,InterfaceModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int IdClase;
    private Curso Curso;
    private String Nombre;
    private String Contenido;
    private Date FechaultimoCambio;

    public Clase() {
    }

    public Clase(int IdClase, Curso Curso, String Nombre, String Contenido, Date FechaultimoCambio) {
        this.IdClase = IdClase;
        this.Curso = Curso;
        this.Nombre = Nombre;
        this.Contenido = Contenido;
        this.FechaultimoCambio = FechaultimoCambio;
    }

    public int getIdClase() {
        return IdClase;
    }

    public void setIdClase(int IdClase) {
        this.IdClase = IdClase;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public Date getFechaultimoCambio() {
        return FechaultimoCambio;
    }

    public void setFechaultimoCambio(Date FechaultimoCambio) {
        this.FechaultimoCambio = FechaultimoCambio;
    }

    @Override
    public String toString() {
        return "Clase{" + "IdClase=" + IdClase + ", Curso=" + Curso + ", Nombre=" + Nombre + ", Contenido=" + Contenido + ", FechaultimoCambio=" + FechaultimoCambio + '}';
    }
    
}
