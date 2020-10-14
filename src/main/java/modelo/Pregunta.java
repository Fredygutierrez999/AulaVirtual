/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
@Entity
@Table(name = "Pregunta")
@NamedQueries(
        {
            @NamedQuery(name = "findAll", query = "SELECT p FROM Pregunta p"),
            @NamedQuery(name = "findById", query = "SELECT p FROM Pregunta p WHERE p.IdPregunta = :IdPregunta")
        }
)
public class Pregunta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdPregunta;
    private Evaluacion Evaluacion;
    private String Nombre;
    private String Respuesta1;
    private String Respuesta2;
    private String Respuesta3;
    private String Respuesta4;
    private int RespuestaCorrecta;

    public Pregunta() {
    }

    public Pregunta(int IdPregunta, Evaluacion Evaluacion, String Nombre, String Respuesta1, String Respuesta2, String Respuesta3, String Respuesta4, int RespuestaCorrecta) {
        this.IdPregunta = IdPregunta;
        this.Evaluacion = Evaluacion;
        this.Nombre = Nombre;
        this.Respuesta1 = Respuesta1;
        this.Respuesta2 = Respuesta2;
        this.Respuesta3 = Respuesta3;
        this.Respuesta4 = Respuesta4;
        this.RespuestaCorrecta = RespuestaCorrecta;
    }

    public int getIdPregunta() {
        return IdPregunta;
    }

    public void setIdPregunta(int IdPregunta) {
        this.IdPregunta = IdPregunta;
    }

    public Evaluacion getEvaluacion() {
        return Evaluacion;
    }

    public void setEvaluacion(Evaluacion Evaluacion) {
        this.Evaluacion = Evaluacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRespuesta1() {
        return Respuesta1;
    }

    public void setRespuesta1(String Respuesta1) {
        this.Respuesta1 = Respuesta1;
    }

    public String getRespuesta2() {
        return Respuesta2;
    }

    public void setRespuesta2(String Respuesta2) {
        this.Respuesta2 = Respuesta2;
    }

    public String getRespuesta3() {
        return Respuesta3;
    }

    public void setRespuesta3(String Respuesta3) {
        this.Respuesta3 = Respuesta3;
    }

    public String getRespuesta4() {
        return Respuesta4;
    }

    public void setRespuesta4(String Respuesta4) {
        this.Respuesta4 = Respuesta4;
    }

    public int getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    public void setRespuestaCorrecta(int RespuestaCorrecta) {
        this.RespuestaCorrecta = RespuestaCorrecta;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "IdPregunta=" + IdPregunta + ", Evaluacion=" + Evaluacion + ", Nombre=" + Nombre + ", Respuesta1=" + Respuesta1 + ", Respuesta2=" + Respuesta2 + ", Respuesta3=" + Respuesta3 + ", Respuesta4=" + Respuesta4 + ", RespuestaCorrecta=" + RespuestaCorrecta + '}';
    }
    
    
    
}
