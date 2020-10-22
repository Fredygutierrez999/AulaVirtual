/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "Evaluacion")
@NamedQueries(
        {
            @NamedQuery(name = "findAll.Evaluacion", query = "SELECT p FROM Evaluacion p"),
            @NamedQuery(name = "findById.Evaluacion", query = "SELECT p FROM Evaluacion p WHERE p.IdClase = :IdClase")
        }
)
public class Evaluacion implements Serializable,InterfaceModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdClase;
    private Curso Curso;
    private String Nombre;
    private String Detalle;
    private List<Pregunta> Preguntas;

    public Evaluacion() {
    }

    public Evaluacion(int IdClase, Curso Curso, String Nombre, String Detalle, List<Pregunta> Preguntas) {
        this.IdClase = IdClase;
        this.Curso = Curso;
        this.Nombre = Nombre;
        this.Detalle = Detalle;
        this.Preguntas = Preguntas;
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

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public List<Pregunta> getPreguntas() {
        return Preguntas;
    }

    public void setPreguntas(List<Pregunta> Preguntas) {
        this.Preguntas = Preguntas;
    }
    
    

    @Override
    public String toString() {
        return "Evaluacion{" + "IdClase=" + IdClase + ", Curso=" + Curso + ", Nombre=" + Nombre + ", Detalle=" + Detalle + '}';
    }
    
    
}
