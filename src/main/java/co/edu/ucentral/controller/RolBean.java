/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.models.Rol;
import co.edu.ucentral.services.RolService;

@Named("rolBean")
@RequestScoped
public class RolBean {

    @Inject
    private RolService rolService;
    private Rol rol;
    private List<Rol> roles;
    private String funcionalidad;

    @PostConstruct
    public void inicializar() {
        this.roles = this.rolService.listadoRol();
    }

    public RolBean() {
        this.rol = new Rol();
        this.roles = new ArrayList<>();
        this.funcionalidad = "rol";
    }

    public String consultarTodos() {
        this.roles = this.rolService.listadoRol();
        return this.funcionalidad + "Consultar";
    }

    public String eliminar(int idrol) {
        this.rol = new Rol();
        this.rol.setIdRol(idrol);
        this.rolService.eliminarRol(this.rol);
        this.roles = this.rolService.listadoRol();
        return this.funcionalidad + "Consultar";
    }

    public String crear() {
        this.rol = new Rol();
        return this.funcionalidad + "Crear";
    }

    public String editar(int idrol) {
        this.rol = this.rolService.rolPorId(new Rol(idrol));
        return this.funcionalidad + "Editar";
    }

    public String guardar() {
        if (this.rol.getIdRol() == 0) {
            this.rolService.guardarRol(this.rol);
        }else{
            this.rolService.modificarRol(rol);
        }
        this.roles = this.rolService.listadoRol();
        return this.funcionalidad + "Consultar";
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

}
