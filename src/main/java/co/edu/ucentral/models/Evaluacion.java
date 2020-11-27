/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Adolfo
 */
@Entity
@Table(name = "Evaluacion")
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByNombre", query = "SELECT e FROM Evaluacion e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Evaluacion.findByDetalle", query = "SELECT e FROM Evaluacion e WHERE e.detalle = :detalle")})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEvaluacion")
    private Integer idEvaluacion;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Detalle")
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvaluacion", fetch = FetchType.LAZY)
    private List<Pregunta> preguntaList;
    @JoinColumn(name = "IdCurso", referencedColumnName = "IdCurso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso idCurso;

    public Evaluacion() {
        this.idEvaluacion = 0;
    }

    public Evaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Evaluacion(Integer idEvaluacion, String nombre, String detalle) {
        this.idEvaluacion = idEvaluacion;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacion != null ? idEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.idEvaluacion == null && other.idEvaluacion != null) || (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.mavenproject2.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
    }

}
