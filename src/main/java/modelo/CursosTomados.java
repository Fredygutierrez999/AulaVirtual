/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.javafx.scene.control.skin.CustomColorDialog;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import sun.security.jca.GetInstance;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
@Entity
@Table(name = "CursosTomados")
@NamedQueries(
        {
            @NamedQuery(name = "findAll", query = "SELECT p FROM CursosTomados p"),
            @NamedQuery(name = "findById", query = "SELECT p FROM CursosTomados p WHERE p.IdCursosTomados = :IdCursosTomados")
        }
)
public class CursosTomados  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCursosTomados;
    private Profesor Usuario_Estudiante;
    private Curso Curso;
    private Periodo Periodo;
    private double  NotaFinal;
    private static CursosTomados CursoTomadoActual;

    private CursosTomados() {
    }

    private CursosTomados(int IdCursosTomados, Profesor Usuario_Estudiante, Curso Curso, Periodo Periodo, double NotaFinal) {
        this.IdCursosTomados = IdCursosTomados;
        this.Usuario_Estudiante = Usuario_Estudiante;
        this.Curso = Curso;
        this.Periodo = Periodo;
        this.NotaFinal = NotaFinal;
    }
    
    
    public static CursosTomados getInstancia(){
        if(CursoTomadoActual == null){
            CursoTomadoActual = new CursosTomados();
        }
        return CursoTomadoActual;
    }

    public int getIdCursosTomados() {
        return IdCursosTomados;
    }

    public void setIdCursosTomados(int IdCursosTomados) {
        this.IdCursosTomados = IdCursosTomados;
    }

    public Profesor getUsuario_Estudiante() {
        return Usuario_Estudiante;
    }

    public void setUsuario_Estudiante(Profesor Usuario_Estudiante) {
        this.Usuario_Estudiante = Usuario_Estudiante;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    public Periodo getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(Periodo Periodo) {
        this.Periodo = Periodo;
    }

    public double getNotaFinal() {
        return NotaFinal;
    }

    public void setNotaFinal(double NotaFinal) {
        this.NotaFinal = NotaFinal;
    }

    @Override
    public String toString() {
        return "CursosTomados{" + "IdCursosTomados=" + IdCursosTomados + ", Usuario_Estudiante=" + Usuario_Estudiante + ", Curso=" + Curso + ", Periodo=" + Periodo + ", NotaFinal=" + NotaFinal + '}';
    }
    
    
    
    
}
