/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adolfo
 */
@Entity
@Table(name = "Clase")
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByIdClase", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase"),
    @NamedQuery(name = "Clase.findByNombre", query = "SELECT c FROM Clase c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Clase.findByContenido", query = "SELECT c FROM Clase c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "Clase.findByFechaultimoCambio", query = "SELECT c FROM Clase c WHERE c.fechaultimoCambio = :fechaultimoCambio")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdClase")
    private Integer idClase;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Contenido")
    private String contenido;
    @Basic(optional = false)
    @Column(name = "FechaultimoCambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaultimoCambio;
    @JoinColumn(name = "IdCurso", referencedColumnName = "IdCurso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso idCurso;

    public Clase() {
    }

    public Clase(Integer idClase) {
        this.idClase = idClase;
    }

    public Clase(Integer idClase, String nombre, String contenido, Date fechaultimoCambio) {
        this.idClase = idClase;
        this.nombre = nombre;
        this.contenido = contenido;
        this.fechaultimoCambio = fechaultimoCambio;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaultimoCambio() {
        return fechaultimoCambio;
    }

    public void setFechaultimoCambio(Date fechaultimoCambio) {
        this.fechaultimoCambio = fechaultimoCambio;
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
        hash += (idClase != null ? idClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idClase == null && other.idClase != null) || (this.idClase != null && !this.idClase.equals(other.idClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.mavenproject2.Clase[ idClase=" + idClase + " ]";
    }
    
}
