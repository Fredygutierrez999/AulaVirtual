/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import co.edu.ucentral.models.Facultad;
import co.edu.ucentral.models.Rol;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.services.FacultadService;
import java.io.Serializable;
import javax.faces.annotation.ManagedProperty;
import org.primefaces.PrimeFaces;

@Named("facultadBean")
@RequestScoped
public class FacultadBean implements Serializable {

    @Inject
    private FacultadService facultadService;

    private Facultad facultad;
    private List<Facultad> facultades;
    private String funcionalidad;
    @Inject
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuariologin;

    @PostConstruct
    public void inicializar() {
        usuariologin.validarIdioma();
        if (usuariologin.getUsuario().getNombre() != null) {
            this.facultades = this.facultadService.listadoFacultad();
        } else {
            usuariologin.setMensaje("Usuario no autorizado");
            PrimeFaces pf = PrimeFaces.current();
            pf.executeScript("$('#modal').modal('show')");
        }
    }

    public FacultadBean() {
        facultades = new ArrayList<>();
        facultad = new Facultad();
        this.funcionalidad = "facultad";
    }

    public String editar(int id) {
        this.facultad = this.facultadService.facultadPorId(new Facultad(id));
        return this.funcionalidad + "Editar";
    }

    public String guardar() {
        if (this.facultad.getIdFacultad() == 0) {
            this.facultadService.guardarFacultad(this.facultad);
        } else {
            this.facultadService.modificarFacultad(this.facultad);
        }
        this.facultades = facultadService.listadoFacultad();
        return this.funcionalidad + "Consultar";
    }

    public String eliminar(int id) {
        this.facultadService.eliminarFacultad(new Facultad(id));
        this.facultades = facultadService.listadoFacultad();
        return this.funcionalidad + "Consultar";
    }

    public String crear() {
        this.facultad = new Facultad();
        return this.funcionalidad + "Crear";
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
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
