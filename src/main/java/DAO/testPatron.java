/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import factory.FactoriaUsuario;
import java.util.List;
import modelo.*;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
public class testPatron {

    public static void main(String[] args) {
        /*CONSULTA ROL POR ID*/
        RolDAO rolDato = new RolDAO();
        Rol objRol = rolDato.consultarXID(2);
        
        
        UsuarioDAO objDAo = new UsuarioDAO();
        
        /*INSERTA NUEVO USUARIO*/
        FactoriaUsuario factoria = new FactoriaUsuario();
        InterfaceUsuario objUsu = factoria.getUsuario(objRol);
        objUsu.setNombre("Profe. Agusto pataqui 369");
        objUsu.setClave("profesores2020");
        objUsu.setFotoPerfil("Mi imagen");
        objUsu.setUsuario("augustopa");
        objUsu.setRol(objRol);
        //objDAo.insertar(objUsu);

        /*CONSULTA POR ID*/
        InterfaceUsuario objConsulta = objDAo.consultarXID(1);
        System.out.println(objConsulta);

        /*CONSULTA TODOS*/
        List<InterfaceUsuario> lstUsuarios = objDAo.consultarTodos();
        for (int i = 0; i < lstUsuarios.size(); i++) {
            System.out.println(lstUsuarios.get(i));
        }

        /*ELIMINAR*/
        //InterfaceUsuario objUsuElimina = new Administrador();
        //objUsuElimina.setIdUsuario(2);
        //objDAo.eliminar(objUsuElimina);
        
    }
}
