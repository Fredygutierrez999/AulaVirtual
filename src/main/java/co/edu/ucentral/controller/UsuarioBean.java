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
import co.edu.ucentral.models.Usuario;
import co.edu.ucentral.services.UsuarioService;

@Named("usuarioBean")
@RequestScoped
public class UsuarioBean {

    @Inject
    private UsuarioService usuarioService;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private String mensaje;

    public UsuarioBean() {
        this.usuario = new Usuario();
    }

    public String validarUsuario() {
        Usuario tmp = this.usuarioService.usuarioPorClave(usuario);
        if (tmp != null) {
            return "index";
        } else {
            this.mensaje = "Datos incorrectos.";
            return "login";
        }
    }

    public String consultarUsuario() {
        usuarios = usuarioService.listadoUsuario();
        return "usuarioconsultar";
    }

    
    
    public String editar(int id) {
        return "usuarioeditar";
    }
    
    
    public String eliminar(Usuario usuario) {
        usuarioService.eliminarUsuario(usuario);
        usuarios = usuarioService.listadoUsuario();
        return "usuarioconsultar";
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    
}
