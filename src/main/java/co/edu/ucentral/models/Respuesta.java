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
@Table(name = "Respuesta")
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespuesta", query = "SELECT r FROM Respuesta r WHERE r.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuesta.findByRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuesta = :respuesta"),
    @NamedQuery(name = "Respuesta.findByValorCorrecto", query = "SELECT r FROM Respuesta r WHERE r.valorCorrecto = :valorCorrecto")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdRespuesta")
    private Integer idRespuesta;
    @Basic(optional = false)
    @Column(name = "Respuesta")
    private String respuesta;
    @Basic(optional = false)
    @Column(name = "ValorCorrecto")
    private boolean valorCorrecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRespuesta", fetch = FetchType.LAZY)
    private List<ResultadoRespuesta> resultadoRespuestaList;
    @JoinColumn(name = "IdPregunta", referencedColumnName = "IdPregunta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pregunta idPregunta;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Respuesta(Integer idRespuesta, String respuesta, boolean valorCorrecto) {
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;
        this.valorCorrecto = valorCorrecto;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean getValorCorrecto() {
        return valorCorrecto;
    }

    public void setValorCorrecto(boolean valorCorrecto) {
        this.valorCorrecto = valorCorrecto;
    }

    public List<ResultadoRespuesta> getResultadoRespuestaList() {
        return resultadoRespuestaList;
    }

    public void setResultadoRespuestaList(List<ResultadoRespuesta> resultadoRespuestaList) {
        this.resultadoRespuestaList = resultadoRespuestaList;
    }

    public Pregunta getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Pregunta idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.mavenproject2.Respuesta[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
