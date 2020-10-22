/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import modelo.*;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
public class FactoriaUsuario {

    public InterfaceUsuario getUsuario(String tipo) {
        InterfaceUsuario cn = null;
        if (tipo.equals("Profesor")) {
            cn = new Profesor();
        } else {
            if (tipo.equals("Estudiante")) {
                cn = new Estudiante();
            } else {
                if (tipo.equals("Administrador")) {
                    cn = new Administrador();
                }
            }
        }
        return cn;
    }
    
    public InterfaceUsuario getUsuario(Rol obj) {
        InterfaceUsuario cn = null;
        if (obj.getNombre().equals("Profesor")) {
            cn = new Profesor();
        } else {
            if (obj.getNombre().equals("Estudiante")) {
                cn = new Estudiante();
            } else {
                if (obj.getNombre().equals("Administrador")) {
                    cn = new Administrador();
                }
            }
        }
        cn.setRol(obj);
        return cn;
    }

}
