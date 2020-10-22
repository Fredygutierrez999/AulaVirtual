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
public class PreguntaDAO {

    private EntityManager em;

    public Pregunta consultarXID(Integer ID) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        Pregunta pregunta = new Pregunta();
        Query query = em.createNamedQuery("Pregunta.findByIdCliente", Pregunta.class);
        query.setParameter("idPregunta", ID);
        try {
            List<Pregunta> listado = (List<Pregunta>) query.getResultList();
            if (!listado.isEmpty()) {
                pregunta = listado.get(0);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            if (pregunta != null) {
                em.close();
            }
        }
        return pregunta;
    }

    public List<InterfaceModelo> consultarTodos() {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        List<InterfaceModelo> listado = new ArrayList<>();
        Query query = em.createNamedQuery("Pregunta.findall", Pregunta.class);
        try {
            listado = (List<InterfaceModelo>) query.getResultList();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            em.close();
        }
        return listado;
    }

    public boolean insertar(Pregunta obj) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        String mensaje = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(obj);
            tx.commit();
            mensaje = "El " + obj.getClass().getName() + " ha sido creado exitosamente";
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            mensaje = "El " + obj.getClass().getName() + " no ha sido posible crearlospor favor intentelo de nuevo";
        } finally {
            em.close();
        }
        return true;
    }

    public boolean actualizar(InterfaceModelo obj) {
        EntityManagerFactory factoriaSesion = Conexion.getInstancia();
        em = factoriaSesion.createEntityManager();
        EntityTransaction tx = null;
        String mensaje = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(obj);
            tx.commit();
            System.out.println("La pregunta se ha actualizado exitosamente");
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.err.println("La pregunta no se ha modificado");
        } finally {
            em.close();
        }
        return true;
    }

    public boolean eliminar(Pregunta obj) {
        Pregunta objEliminar = consultarXID(obj.getIdPregunta());
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
