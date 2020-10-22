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
        /*RolDAO rolDato = new RolDAO();
        Rol obj= new Rol();
        obj.setNombre("Fredy");
        rolDato.insertar(obj);*/
        
        
        UsuarioDAO objDAo = new UsuarioDAO();
        FactoriaUsuario factoria = new FactoriaUsuario();
        InterfaceUsuario objUsu = factoria.getUsuario("Profesor");
        objUsu.setNombre("Profe. Agusto pataqui 369");
        objUsu.setClave("profesores2020");
        objUsu.setFotoPerfil("Mi imagen");
        objUsu.setUsuario("augustopa");
        objUsu.setRol(new Rol(2, ""));
        objDAo.insertar(objUsu);

        //InterfaceUsuario objConsulta = objDAo.consultarXID(1);
        //System.out.println(objConsulta);

        //List<InterfaceUsuario> lstUsuarios = objDAo.consultarTodos();
        //for (int i = 0; i < lstUsuarios.size(); i++) {
        //    System.out.println(lstUsuarios.get(i));
        //}

        //InterfaceUsuario objUsuElimina = new Administrador();
        //objUsuElimina.setIdUsuario(2);
        //objDAo.eliminar(objUsuElimina);
        
    }
}
