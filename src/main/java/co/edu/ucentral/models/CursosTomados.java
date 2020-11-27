/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CursosTomados")
@NamedQueries({
    @NamedQuery(name = "CursosTomados.findAll", query = "SELECT c FROM CursosTomados c"),
    @NamedQuery(name = "CursosTomados.findByIdCursosTomados", query = "SELECT c FROM CursosTomados c WHERE c.idCursosTomados = :idCursosTomados"),
    @NamedQuery(name = "CursosTomados.findByNotaFinal", query = "SELECT c FROM CursosTomados c WHERE c.notaFinal = :notaFinal")})
public class CursosTomados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCursosTomados")
    private Integer idCursosTomados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "NotaFinal")
    private BigDecimal notaFinal;
    @JoinColumn(name = "IdCurso", referencedColumnName = "IdCurso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso idCurso;
    @JoinColumn(name = "IdPeriodo", referencedColumnName = "IdPeriodo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Periodo idPeriodo;
    @JoinColumn(name = "IdUsuario_Estudiante", referencedColumnName = "IdUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuarioEstudiante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCursosTomados", fetch = FetchType.LAZY)
    private List<ResultadoRespuesta> resultadoRespuestaList;

    public CursosTomados() {
        this.idCursosTomados = 0;
    }

    public CursosTomados(Integer idCursosTomados) {
        this.idCursosTomados = idCursosTomados;
    }

    public CursosTomados(Integer idCursosTomados, BigDecimal notaFinal) {
        this.idCursosTomados = idCursosTomados;
        this.notaFinal = notaFinal;
    }

    public Integer getIdCursosTomados() {
        return idCursosTomados;
    }

    public void setIdCursosTomados(Integer idCursosTomados) {
        this.idCursosTomados = idCursosTomados;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Usuario getIdUsuarioEstudiante() {
        return idUsuarioEstudiante;
    }

    public void setIdUsuarioEstudiante(Usuario idUsuarioEstudiante) {
        this.idUsuarioEstudiante = idUsuarioEstudiante;
    }

    public List<ResultadoRespuesta> getResultadoRespuestaList() {
        return resultadoRespuestaList;
    }

    public void setResultadoRespuestaList(List<ResultadoRespuesta> resultadoRespuestaList) {
        this.resultadoRespuestaList = resultadoRespuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursosTomados != null ? idCursosTomados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosTomados)) {
            return false;
        }
        CursosTomados other = (CursosTomados) object;
        if ((this.idCursosTomados == null && other.idCursosTomados != null) || (this.idCursosTomados != null && !this.idCursosTomados.equals(other.idCursosTomados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.mavenproject2.CursosTomados[ idCursosTomados=" + idCursosTomados + " ]";
    }
    
}
