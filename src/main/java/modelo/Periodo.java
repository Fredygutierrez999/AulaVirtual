/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
public class Periodo {
    
    private int IdPeriodo;
    private String Nombre;
    private Date Fechainicial;
    private Date Fechafinal;
    private boolean Activo;

    public Periodo() {
    }

    public Periodo(int IdPeriodo, String Nombre, Date Fechainicial, Date Fechafinal, boolean Activo) {
        this.IdPeriodo = IdPeriodo;
        this.Nombre = Nombre;
        this.Fechainicial = Fechainicial;
        this.Fechafinal = Fechafinal;
        this.Activo = Activo;
    }

    public int getIdPeriodo() {
        return IdPeriodo;
    }

    public void setIdPeriodo(int IdPeriodo) {
        this.IdPeriodo = IdPeriodo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechainicial() {
        return Fechainicial;
    }

    public void setFechainicial(Date Fechainicial) {
        this.Fechainicial = Fechainicial;
    }

    public Date getFechafinal() {
        return Fechafinal;
    }

    public void setFechafinal(Date Fechafinal) {
        this.Fechafinal = Fechafinal;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    @Override
    public String toString() {
        return "periodo{" + "IdPeriodo=" + IdPeriodo + ", Nombre=" + Nombre + ", Fechainicial=" + Fechainicial + ", Fechafinal=" + Fechafinal + ", Activo=" + Activo + '}';
    }
    
}
