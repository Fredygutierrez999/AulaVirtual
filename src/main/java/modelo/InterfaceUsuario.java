/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
public interface InterfaceUsuario {
    
    int getIdUsuario();
    void setIdUsuario(int IdUsuario);
    String getUsuario();
    void setUsuario(String Usuario);
    String getClave();
    void setClave(String Clave);
    String getFotoPerfil();
    void setFotoPerfil(String FotoPerfil);
    Rol getRol();
    void setRol(Rol rol);
    String getNombre();
    void setNombre(String Nombre);
    boolean esProfesor();
    boolean esEstudiante();
    
    String toString();
}
