/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
public class Conexion {

    private static EntityManagerFactory emf;

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("AulaWeb");
        } catch (Throwable e) {
            System.out.print(e.getMessage());
            throw new RuntimeException("Error al crear la factoria JPA." + e.getMessage());
        }
    }

    public static EntityManagerFactory getInstancia() {
        if (emf == null) {
            emf = buildEntityManagerFactory();
        }
        return emf;
    }
    
}
