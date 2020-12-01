/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.services;

import co.edu.ucentral.datos.UsuarioDAO;
import co.edu.ucentral.models.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Adolfo
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> listadoUsuario() {
        return usuarioDAO.listUser();
    }

    @Override
    public Usuario usuarioPorId(Usuario usuario) {
        return usuarioDAO.findByUser(usuario);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDAO.insertUser(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDAO.updateUser(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.deleteUser(usuario);
    }

    @Override
    public Usuario usuarioPorClave(Usuario usuario) {
        return usuarioDAO.findByUserAndPassword(usuario);
    }

}
