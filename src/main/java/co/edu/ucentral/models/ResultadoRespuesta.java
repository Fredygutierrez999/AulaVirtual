/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.models;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author Adolfo
 */
@Entity
@Table(name = "ResultadoRespuesta")
@NamedQueries({
    @NamedQuery(name = "ResultadoRespuesta.findAll", query = "SELECT r FROM ResultadoRespuesta r"),
    @NamedQuery(name = "ResultadoRespuesta.findByIdResultadoRespuesta", query = "SELECT r FROM ResultadoRespuesta r WHERE r.idResultadoRespuesta = :idResultadoRespuesta"),
    @NamedQuery(name = "ResultadoRespuesta.findByValorRespuesta", query = "SELECT r FROM ResultadoRespuesta r WHERE r.valorRespuesta = :valorRespuesta")})
public class ResultadoRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdResultadoRespuesta")
    private Integer idResultadoRespuesta;
    @Basic(optional = false)
    @Column(name = "ValorRespuesta")
    private boolean valorRespuesta;
    @JoinColumn(name = "IdCursosTomados", referencedColumnName = "IdCursosTomados")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CursosTomados idCursosTomados;
    @JoinColumn(name = "IdPregunta", referencedColumnName = "IdPregunta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pregunta idPregunta;
    @JoinColumn(name = "IdRespuesta", referencedColumnName = "IdRespuesta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Respuesta idRespuesta;

    public ResultadoRespuesta() {
    }

    public ResultadoRespuesta(Integer idResultadoRespuesta) {
        this.idResultadoRespuesta = idResultadoRespuesta;
    }

    public ResultadoRespuesta(Integer idResultadoRespuesta, boolean valorRespuesta) {
        this.idResultadoRespuesta = idResultadoRespuesta;
        this.valorRespuesta = valorRespuesta;
    }

    public Integer getIdResultadoRespuesta() {
        return idResultadoRespuesta;
    }

    public void setIdResultadoRespuesta(Integer idResultadoRespuesta) {
        this.idResultadoRespuesta = idResultadoRespuesta;
    }

    public boolean getValorRespuesta() {
        return valorRespuesta;
    }

    public void setValorRespuesta(boolean valorRespuesta) {
        this.valorRespuesta = valorRespuesta;
    }

    public CursosTomados getIdCursosTomados() {
        return idCursosTomados;
    }

    public void setIdCursosTomados(CursosTomados idCursosTomados) {
        this.idCursosTomados = idCursosTomados;
    }

    public Pregunta getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Pregunta idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Respuesta getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Respuesta idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoRespuesta != null ? idResultadoRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoRespuesta)) {
            return false;
        }
        ResultadoRespuesta other = (ResultadoRespuesta) object;
        if ((this.idResultadoRespuesta == null && other.idResultadoRespuesta != null) || (this.idResultadoRespuesta != null && !this.idResultadoRespuesta.equals(other.idResultadoRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.mavenproject2.ResultadoRespuesta[ idResultadoRespuesta=" + idResultadoRespuesta + " ]";
    }

}
