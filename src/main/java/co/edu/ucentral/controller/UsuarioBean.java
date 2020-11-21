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
    
    @PostConstruct
    public void inicializar(){
        try {
        usuarios = usuarioService.listadoUsuario();
            System.out.println("this = " +  usuarios.size());
        } catch (Exception e) {
            System.out.println("fallo " + e.getMessage());
        }
        usuario = new Usuario();
    }

    public UsuarioBean(){
        this.usuario = new Usuario();
    }

    public String validarUsuario(){
        Usuario tmp =this.usuarioService.usuarioPorClave(usuario);
        if(tmp == null){
            this.mensaje = "Datos incorrectos.";
            return "login";
        }else{
            return "index";
        }
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
    

}
