/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Curso")
@NamedQueries(
        {
            @NamedQuery(name = "findAll", query = "SELECT p FROM Curso p"),
            @NamedQuery(name = "findById", query = "SELECT p FROM Curso p WHERE p.IdCurso = :IdCurso")
        }
)
public class Curso implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCurso;
    private String Nombre;
    private Departamento Departamento;
    private String Descripcion;
    private Profesor Usuario_Profesor;
    private Date FechaCreacion;
    private List<Clase> Clases;
    private List<Evaluacion> Evaluaciones;

    private Curso() {
    }

    private Curso(int IdCurso, String Nombre, Departamento Departamento, String Descripcion, Profesor Usuario_Profesor, Date FechaCreacion) {
        this.IdCurso = IdCurso;
        this.Nombre = Nombre;
        this.Departamento = Departamento;
        this.Descripcion = Descripcion;
        this.Usuario_Profesor = Usuario_Profesor;
        this.FechaCreacion = FechaCreacion;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Departamento getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Departamento Departamento) {
        this.Departamento = Departamento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Profesor getUsuario_Profesor() {
        return Usuario_Profesor;
    }

    public void setUsuario_Profesor(Profesor Usuario_Profesor) {
        this.Usuario_Profesor = Usuario_Profesor;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public List<Clase> getClases() {
        return Clases;
    }

    public void setClases(List<Clase> Clases) {
        this.Clases = Clases;
    }

    public List<Evaluacion> getEvaluaciones() {
        return Evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> Evaluaciones) {
        this.Evaluaciones = Evaluaciones;
    }
    
    

    @Override
    public String toString() {
        return "Curso{" + "IdCurso=" + IdCurso + ", Nombre=" + Nombre + ", Departamento=" + Departamento + ", Descripcion=" + Descripcion + ", Usuario_Profesor=" + Usuario_Profesor + ", FechaCreacion=" + FechaCreacion + '}';
    }
    
    
    
}
