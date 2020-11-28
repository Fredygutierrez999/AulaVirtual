/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import co.edu.ucentral.models.Periodo;
import co.edu.ucentral.models.Rol;
import co.edu.ucentral.services.PeriodoService;
import co.edu.ucentral.services.RolService;
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
        this.periodos = new ArrayList<>();
    }

    public PeriodoBean() {
        this.periodos = this.periodoService.listadoPeriodo();
        
        this.periodo = new Periodo();
        this.funcionalidad = "periodo";
    }

    
    public String eliminar(Integer idPeriodo) {
        this.periodoService.eliminarPeriodo(new Periodo(idPeriodo));
        this.periodos = this.periodoService.listadoPeriodo();
        return this.funcionalidad + "Consultar";
    }
    
    public String editar(int idperiodo) {
        this.periodo = this.periodoService.periodoPorId(new Periodo(idperiodo));
        return this.funcionalidad + "Editar";
    }
    
    public String crear() {
        this.periodo = new Periodo();
        return this.funcionalidad + "Crear";
    }
    
    public String guardar(){
        this.periodoService.guardarPeriodo(periodo);
        return this.funcionalidad + "Consultar";
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

    
    
}
