/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import co.edu.ucentral.models.Curso;
import co.edu.ucentral.models.CursosTomados;
import co.edu.ucentral.models.Evaluacion;
import co.edu.ucentral.models.Periodo;
import co.edu.ucentral.models.Rol;
import co.edu.ucentral.services.CursoService;
import co.edu.ucentral.services.CursosTomadoService;
import co.edu.ucentral.services.EvaluacionService;
import co.edu.ucentral.services.PeriodoService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.primefaces.PrimeFaces;

/**
 *
 * @author fredyalejandrogutierrezvelasquez
 */
@Named("cursosTomadosBean")
@RequestScoped
public class CursosTomadosBean implements Serializable {

    @Inject
    private CursoService cursoService;
    @Inject
    private CursosTomadoService cursosTomadoService;
    @Inject
    private PeriodoService periodoService;
    @Inject
    private EvaluacionService evaluacionService;

    private CursosTomados cursoTomado;
    private List<Curso> cursosdisponibles;
    private List<CursosTomados> cursostomados;
    private String funcionalidad;
    private String nombreCurso;
    private String mensaje;
    private CursosTomados cursoEvaluacion;
    private Evaluacion evaluacion;

    @Inject
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuariologin;

    @PostConstruct
    public void inicializar() {
        usuariologin.validarIdioma();
        if (usuariologin.getUsuario().getNombre() != null) {
            this.cursosdisponibles = this.cursoService.listadoCurso();
            this.cursostomados = this.cursosTomadoService.listCursosTomadosPorUsuario(usuariologin.getUsuario());
            this.funcionalidad = "favoritos";
        } else {
            usuariologin.setMensaje("Usuario no autorizado");
            PrimeFaces pf = PrimeFaces.current();
            pf.executeScript("$('#modal').modal('show')");
        }
    }

    public CursosTomadosBean() {
        this.mensaje = "";
        this.cursosdisponibles = new ArrayList();
        this.cursostomados = new ArrayList();
        this.cursoTomado = new CursosTomados();
    }

    public String buscarCursosXNombre() {
        this.cursosdisponibles = this.cursoService.listCursosPorNombre(nombreCurso);
        return this.funcionalidad + "ConsultarCursos";
    }

    public String tomarCurso(int idCurso) {
        List<Periodo> lstPeriodos = this.periodoService.listPeriodoPorEstado(true);
        if (!lstPeriodos.isEmpty()) {
            Curso cursoATomar = this.cursoService.cursoPorId(new Curso(idCurso));
            List<CursosTomados> lstCursosTomados = this.cursosTomadoService.listCursosTomadosPorUsuarioYCurso(usuariologin.getUsuario(), cursoATomar);
            if (lstCursosTomados.isEmpty()) {
                CursosTomados objCursoTomado = new CursosTomados();
                objCursoTomado.setIdCurso(cursoATomar);
                objCursoTomado.setIdUsuarioEstudiante(usuariologin.getUsuario());
                objCursoTomado.setIdPeriodo(lstPeriodos.get(0));
                objCursoTomado.setNotaFinal(BigDecimal.ZERO);
                this.cursosTomadoService.guardarCursosTomado(objCursoTomado);
                return this.funcionalidad + "MisCursos";
            } else {
                this.mensaje = "El usuario solo puede tomar un curso";
                this.cursosdisponibles = this.cursoService.listCursosPorNombre(nombreCurso);
                return this.funcionalidad + "ConsultarCursos";
            }
        } else {
            this.mensaje = "No existe un periodo activo";
            this.cursosdisponibles = this.cursoService.listCursosPorNombre(nombreCurso);
            return this.funcionalidad + "ConsultarCursos";
        }
    }

    public String eliminarCursoTomado(int IDCursoTomado) {
        this.cursosTomadoService.eliminarCursosTomado(this.cursosTomadoService.clasePorId(new CursosTomados(IDCursoTomado)));
        this.cursostomados = this.cursosTomadoService.listCursosTomadosPorUsuario(usuariologin.getUsuario());
        return this.funcionalidad + "MisCursos";
    }

    public String consultarCurso(int IDCursoTomado) {
        this.cursoTomado = this.cursosTomadoService.clasePorId(new CursosTomados(IDCursoTomado));
        return this.funcionalidad + "VerCursosTomado";
    }

    public String realizarEvaluacion(int IDCursoTomado) {
        this.cursoEvaluacion = this.cursosTomadoService.clasePorId(new CursosTomados(IDCursoTomado));
        List<Evaluacion> lstEvaluaciones = this.cursoEvaluacion.getIdCurso().getEvaluacionList();
        if (lstEvaluaciones.size() > 0) {
            this.evaluacion = this.evaluacionService.findByEvaluacion(lstEvaluaciones.get(0));
            return this.funcionalidad + "RealizarEvaluacion";
        } else {
            this.cursoTomado = this.cursoEvaluacion;
            return this.funcionalidad + "VerCursosTomado";
        }
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public List<Curso> getCursosdisponibles() {
        return cursosdisponibles;
    }

    public void setCursosdisponibles(List<Curso> cursosdisponibles) {
        this.cursosdisponibles = cursosdisponibles;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<CursosTomados> getCursostomados() {
        return cursostomados;
    }

    public void setCursostomados(List<CursosTomados> cursostomados) {
        this.cursostomados = cursostomados;
    }

    public CursosTomados getCursoTomado() {
        return cursoTomado;
    }

    public void setCursoTomado(CursosTomados cursoTomado) {
        this.cursoTomado = cursoTomado;
    }

    public CursosTomados getCursoEvaluacion() {
        return cursoEvaluacion;
    }

    public void setCursoEvaluacion(CursosTomados cursoEvaluacion) {
        this.cursoEvaluacion = cursoEvaluacion;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    
    
}
