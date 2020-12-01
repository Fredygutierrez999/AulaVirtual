/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import co.edu.ucentral.models.Rol;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.models.Usuario;
import co.edu.ucentral.services.RolService;
import co.edu.ucentral.services.UsuarioService;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named("usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    @Inject
    private UsuarioService usuarioService;
    @Inject
    private RolService rolService;

    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<Rol> roles;
    private String funcionalidad;
    private int idRol;
    private boolean idioma;
    private String mensaje;

    @PostConstruct
    public void inicializar() {
        this.roles = this.rolService.listadoRol();
        this.usuarios = usuarioService.listadoUsuario();
    }

    public UsuarioBean() {
        usuarios = new ArrayList<>();
        usuario = new Usuario();
        this.funcionalidad = "usuario";
    }

    public String validarUsuario() {
        Usuario tmp = new Usuario();
        tmp = this.usuarioService.usuarioPorClave(usuario);
        if (tmp != null) {
            usuario = tmp;
            return "index";
        } else {
            if (tmp == null) {
                String msg = "Usuario o contraseña invalidos";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;
                facesContext.addMessage(componentId, facesMessage);
                return "login";
            }
        }

        return "login";
    }

    public String consultarUsuario() {
        this.usuarios = usuarioService.listadoUsuario();
        return this.funcionalidad + "consultar";

    }

    public String editar(int id) {
        this.usuario = this.usuarioService.usuarioPorId(new Usuario(id));
        this.idRol = this.usuario.getRol().getIdRol();
        return this.funcionalidad + "Editar";
    }

    public String guardar() {
        this.usuario.setRol(new Rol(this.idRol));
        if (this.usuario.getIdUsuario() == 0) {
            this.usuarioService.guardarUsuario(this.usuario);
        } else {
            this.usuarioService.modificarUsuario(this.usuario);
        }
        this.usuarios = usuarioService.listadoUsuario();
        return this.funcionalidad + "Consultar";
    }

    public String eliminar(int idUsuario) {
        this.usuarioService.eliminarUsuario(new Usuario(idUsuario));
        this.usuarios = usuarioService.listadoUsuario();
        return this.funcionalidad + "Consultar";
    }

    public String crear() {
        this.usuario = new Usuario();
        return this.funcionalidad + "Crear";
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public boolean isIdioma() {
        return idioma;
    }

    public void setIdioma(boolean idioma) {
        this.idioma = idioma;
    }

    public boolean validarIdioma() {

        FacesContext.getCurrentInstance().getApplication().setDefaultLocale(Locale.ENGLISH);
        return true;
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String login(){
        return "login";
    }
    
}
