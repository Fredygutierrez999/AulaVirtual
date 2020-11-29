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
import javax.inject.Inject;
import javax.inject.Named;

@Named("periodoBean")
@RequestScoped
public class PeriodoBean {

    @Inject
    private PeriodoService periodoService;
    private Periodo periodo;
    private List<Periodo> periodos;
    private String funcionalidad;

    @PostConstruct
    public void inicializar() {
        periodos = new ArrayList<>();
        periodos = periodoService.listadoPeriodo();
        periodo = new Periodo();
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

    public String crear() {
        return "editar";
    }

}
