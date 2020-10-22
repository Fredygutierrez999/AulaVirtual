/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import factory.FactoriaUsuario;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modelo.InterfaceModelo;
import servicio.Conexion;
import modelo.*;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
public class UsuarioDAO {

    private EntityManager em;

    public InterfaceUsuario consultarXID(Integer ID) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        InterfaceUsuario usuario = new Administrador();
        Query query = em.createNamedQuery("findById.Administrador", Administrador.class);
        query.setParameter("IdUsuario", ID);
        try {
            InterfaceUsuario objUsuariotmp  = (InterfaceUsuario)query.getSingleResult();
            FactoriaUsuario objFactoria = new FactoriaUsuario();
            usuario = objFactoria.getUsuario(objUsuariotmp.getRol().getNombre());
            usuario.setClave(objUsuariotmp.getClave());
            usuario.setNombre(objUsuariotmp.getNombre());
            usuario.setFotoPerfil(objUsuariotmp.getFotoPerfil());
            usuario.setRol(objUsuariotmp.getRol());
            usuario.setUsuario(objUsuariotmp.getUsuario());
            usuario.setIdUsuario(objUsuariotmp.getIdUsuario());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            if (usuario != null) {
                em.close();
            }
        }
        return usuario;
    }

    public List<InterfaceUsuario> consultarTodos() {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        List<InterfaceUsuario> listado = new ArrayList<>();
        Query query = em.createNamedQuery("findAll.Administrador", Administrador.class);
        try {
            listado = (List<InterfaceUsuario>) query.getResultList();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            em.close();
        }
        return listado;
    }

    public boolean insertar(InterfaceUsuario obj) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        String mensaje = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(obj);
            tx.commit();
            System.out.println("El usuario ha sido creado exitosamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.err.println("El usuario no ha sido posible crearlospor favor intentelo de nuevo");
        } finally {
            em.close();
        }
        return true;
    }

    public boolean actualizar(InterfaceUsuario obj) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        String mensaje = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(obj);
            tx.commit();
            System.out.println("El usuario se ha actualizado exitosamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.err.println("El usuario no se ha modificado");
        } finally {
            em.close();
        }
        return true;
    }

    public boolean eliminar(InterfaceUsuario obj) {
        InterfaceUsuario objEliminar = consultarXID(obj.getIdUsuario());
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(objEliminar));
            tx.commit();
            System.out.println("El usuario se ha eliminado");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.err.println("El usuario no se ha eliminado");
        } finally {
            em.close();
        }
        return true;
    }

}
