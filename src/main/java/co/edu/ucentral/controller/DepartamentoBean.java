/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import co.edu.ucentral.models.Departamento;
import co.edu.ucentral.services.DepartamentoServices;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import co.edu.ucentral.models.Facultad;
import javax.faces.annotation.ManagedProperty;
import org.primefaces.PrimeFaces;

@Named("departamentoBean")
@RequestScoped
public class DepartamentoBean implements Serializable {

    @Inject
    private DepartamentoServices departamentoService;
    @Inject
    private FacultadBean facultadService;

    private Departamento departamento;
    private List<Departamento> departamentos;
    private List<Facultad> facultades;
    private String funcionalidad;
    private int idFacultad;
    @Inject
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuariologin;

    @PostConstruct
    public void inicializar() {
        if (usuariologin.getUsuario().getNombre()!= null) {
            this.departamentos = this.departamentoService.listadoDepartamento();
            this.facultades = this.facultadService.getFacultades();
        }else{
            usuariologin.setMensaje("Usuario no autorizado");
            PrimeFaces pf = PrimeFaces.current();
            pf.executeScript("$('#modal').modal('show')");
        }
    }

    public DepartamentoBean() {
        departamentos = new ArrayList<>();
        departamento = new Departamento();
        this.funcionalidad = "departamento";
    }

    public String editar(int id) {
        this.departamento = this.departamentoService.departamentoPorId(new Departamento(id));
        this.idFacultad = this.departamento.getIdFacultad().getIdFacultad();
        return this.funcionalidad + "Editar";
    }

    public String guardar() {
        this.departamento.setIdFacultad(new Facultad(this.idFacultad));
        if (this.departamento.getIdDepartamento() == 0) {
            this.departamentoService.guardarDepartamento(this.departamento);
        } else {
            this.departamentoService.modificarDepartamento(this.departamento);
        }
        this.departamentos = departamentoService.listadoDepartamento();
        return this.funcionalidad + "Consultar";
    }

    public String eliminar(int id) {
        this.departamentoService.eliminarDepartamento(new Departamento(id));
        this.departamentos = departamentoService.listadoDepartamento();
        return this.funcionalidad + "Consultar";
    }

    public String crear() {
        this.departamento = new Departamento();
        return this.funcionalidad + "Crear";
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public UsuarioBean getUsuariologin() {
        return usuariologin;
    }

    

}
