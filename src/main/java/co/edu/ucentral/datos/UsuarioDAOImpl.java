/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.datos;

import co.edu.ucentral.models.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author Adolfo
 */
@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

    @PersistenceUnit(name = "AulaWeb")
    private EntityManager em;

    @Override
    public List<Usuario> listUser() {
        return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
    }

    @Override
    public Usuario findByUser(Usuario usuario) {
       return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public void insertUser(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUser(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUser(Usuario usuario) {
     em.remove(em.merge(usuario));
    }

    @Override
    public Usuario findByUserAndPassword(Usuario usuario) {
        Query query =em.createNamedQuery("Usuario.findByUsuarioAndPass", Usuario.class);
        query.setParameter("usuario",usuario.getNombre());
        query.setParameter("clave",usuario.getClave());
        return (Usuario) query.getSingleResult();
    }

}
