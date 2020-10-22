/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class RolDAO {

    private EntityManager em;

    public Rol consultarXID(Integer ID) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        Rol rol = new Rol();
        Query query = em.createNamedQuery("Rol.findById", Administrador.class);
        query.setParameter("idRol", ID);
        try {
            List<Rol> listado = (List<Rol>) query.getResultList();
            if (!listado.isEmpty()) {
                rol = listado.get(0);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            if (rol != null) {
                em.close();
            }
        }
        return rol;
    }

    public List<Rol> consultarTodos() {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        List<Rol> listado = new ArrayList<>();
        Query query = em.createNamedQuery("Rol.findall", Administrador.class);
        try {
            listado = (List<Rol>) query.getResultList();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            em.close();
        }
        return listado;
    }

    public boolean insertar(Rol obj) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        String mensaje = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(obj);
            tx.commit();
            mensaje = "El Rol ha sido creado exitosamente";
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            mensaje = "El Rol no ha sido posible crearlospor favor intentelo de nuevo";
        } finally {
            em.close();
        }
        return true;
    }

    public boolean actualizar(Rol obj) {      
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        String mensaje = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(obj);
            tx.commit();
            System.out.println("El rol se ha actualizado exitosamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.err.println("El rol no se ha modificado");
        } finally {
            em.close();
        }
        return true;
    }

    public boolean eliminar(Rol obj) {
        Rol objEliminar = consultarXID(obj.getIdRol());
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(objEliminar));
            tx.commit();
            System.out.println("El rol se ha eliminado");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.err.println("El rol no se ha eliminado");
        } finally {
            em.close();
        }
        return true;
    }

}
