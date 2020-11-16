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
@Table(name = "Pregunta")
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta"),
    @NamedQuery(name = "Pregunta.findByNombre", query = "SELECT p FROM Pregunta p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pregunta.findByNota", query = "SELECT p FROM Pregunta p WHERE p.nota = :nota")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPregunta")
    private Integer idPregunta;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Nota")
    private int nota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta", fetch = FetchType.LAZY)
    private List<ResultadoRespuesta> resultadoRespuestaList;
    @JoinColumn(name = "IdEvaluacion", referencedColumnName = "IdEvaluacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Evaluacion idEvaluacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta", fetch = FetchType.LAZY)
    private List<Respuesta> respuestaList;

    public Pregunta() {
    }

    public Pregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Pregunta(Integer idPregunta, String nombre, int nota) {
        this.idPregunta = idPregunta;
        this.nombre = nombre;
        this.nota = nota;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public List<ResultadoRespuesta> getResultadoRespuestaList() {
        return resultadoRespuestaList;
    }

    public void setResultadoRespuestaList(List<ResultadoRespuesta> resultadoRespuestaList) {
        this.resultadoRespuestaList = resultadoRespuestaList;
    }

    public Evaluacion getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Evaluacion idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.mavenproject2.Pregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
