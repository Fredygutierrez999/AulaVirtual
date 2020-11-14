/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Usuario;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface UsuarioDAO {

    public List<Usuario> listUser();

    public Usuario findByUser(Usuario usuario);

    public void insertUser(Usuario usuario);

    public void updateUser(Usuario usuario);

    public void deleteUser(Usuario usuario);

}
