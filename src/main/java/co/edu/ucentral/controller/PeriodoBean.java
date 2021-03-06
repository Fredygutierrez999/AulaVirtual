/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import co.edu.ucentral.models.Periodo;
import co.edu.ucentral.services.PeriodoService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named("periodoBean")
@RequestScoped
public class PeriodoBean {

    @Inject
    private PeriodoService periodoService;
    private Periodo periodo;
    private List<Periodo> periodos;
    private String funcionalidad;
    @Inject
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuariologin;
    private String mensaje;

    @PostConstruct
    public void inicializar() throws UnsupportedOperationException {
        usuariologin.validarIdioma();
        if (usuariologin.getUsuario().getNombre() != null) {
            System.out.println("usuaiologin.getUsuario = " + usuariologin.getUsuario());
            periodos = new ArrayList<>();
            periodos = periodoService.listadoPeriodo();
            periodo = new Periodo();
        } else {
            setMensaje("Usuario no autorizado");
            PrimeFaces pf = PrimeFaces.current();
            pf.executeScript("$('#modal').modal('show')");
        }
    }

    public void PeriodoBean() {
        this.periodos = new ArrayList<>();
        this.funcionalidad = "periodo";
    }

    public String editar(int IdPeriodo) {
        periodo = this.periodoService.periodoPorId(new Periodo(IdPeriodo));
        return this.funcionalidad + "Editar";
    }

    public String eliminar(int IdPeriodo) {
        periodo = this.periodoService.periodoPorId(new Periodo(IdPeriodo));
        return this.funcionalidad + "Consultar";
    }

    public String guardar() {
        if (periodo.getIdPeriodo() == 0) {
            this.periodoService.guardarPeriodo(periodo);
        } else {
            this.periodoService.modificarPeriodo(periodo);
        }
        return this.funcionalidad + "Consultar";
    }
    
    public String crear() {
        this.periodo = new Periodo();
        return this.funcionalidad + "Crear";
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String login() {

        return "login";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String eliminar(Integer idPeriodo) {
        Periodo p = periodoService.periodoPorId(new Periodo(idPeriodo));
        this.periodoService.eliminarPeriodo(p);
        this.periodos = this.periodoService.listadoPeriodo();
        return this.funcionalidad + "Consultar";
    }
}
