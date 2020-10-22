/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
@Entity
@Table(name = "Usuario")
@NamedQueries(
        {
            @NamedQuery(name = "findAll.Administrador", query = "SELECT p FROM Administrador p"),
            @NamedQuery(name = "findById.Administrador", query = "SELECT p FROM Administrador p WHERE p.IdUsuario = :IdUsuario")
        }
)
public class Administrador implements InterfaceUsuario, InterfaceModelo, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUsuario;
    private String Usuario;
    private String Nombre;
    private String Clave;
    private String FotoPerfil;
    @JoinColumn(name = "IdRol", referencedColumnName = "IdRol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rol;

    public Administrador() {
    }

    public Administrador(int IdUsuario, String Usuario, String Nombre, String Clave, String FotoPerfil, Rol rol) {
        this.IdUsuario = IdUsuario;
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Clave = Clave;
        this.FotoPerfil = FotoPerfil;
        this.rol = rol;
    }

    @Override
    public int getIdUsuario() {
        return IdUsuario;
    }

    @Override
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    @Override
    public String getUsuario() {
        return Usuario;
    }

    @Override
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    @Override
    public String getClave() {
        return Clave;
    }

    @Override
    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    @Override
    public String getFotoPerfil() {
        return FotoPerfil;
    }

    @Override
    public void setFotoPerfil(String FotoPerfil) {
        this.FotoPerfil = FotoPerfil;
    }

    @Override
    public Rol getRol() {
        return rol;
    }

    @Override
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String getNombre() {
        return Nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "IdUsuario=" + IdUsuario + ", Usuario=" + Usuario + ", Nombre=" + Nombre + ", Clave=" + Clave + ", FotoPerfil=" + FotoPerfil + ", rol=" + rol + '}';
    }

    @Override
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public boolean esProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esEstudiante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
