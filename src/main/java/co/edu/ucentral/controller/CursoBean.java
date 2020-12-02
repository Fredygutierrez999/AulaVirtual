/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.controller;

import co.edu.ucentral.models.Clase;
import co.edu.ucentral.models.Curso;
import co.edu.ucentral.models.Departamento;
import co.edu.ucentral.models.Evaluacion;
import co.edu.ucentral.models.Facultad;
import co.edu.ucentral.models.Pregunta;
import co.edu.ucentral.models.Respuesta;
import co.edu.ucentral.models.Rol;
import co.edu.ucentral.models.Usuario;
import co.edu.ucentral.services.CursoService;
import co.edu.ucentral.services.DepartamentoServices;
import co.edu.ucentral.services.EvaluacionService;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import co.edu.ucentral.services.FacultadService;
import co.edu.ucentral.services.PreguntaService;
import co.edu.ucentral.services.RolService;
import co.edu.ucentral.services.UsuarioService;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import org.primefaces.PrimeFaces;

@Named("cursoBean")
@SessionScoped
public class CursoBean implements Serializable {

    @Inject
    private CursoService cursoService;
    @Inject
    private DepartamentoServices departamentoService;
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private RolService rolService;
    @Inject
    private EvaluacionService evaluacionService;
    @Inject
    private PreguntaService preguntaService;

    private Curso curso;
    private List<Curso> cursos;
    private String funcionalidad;
    private int idDepartamento;
    private int idUsuarioProfesor;
    private List<Departamento> departamentos;
    private List<Usuario> usuarios;
    private Clase clase;
    private String nombreClase;
    private String contenidoClase;
    private Evaluacion evaluacion;
    private Pregunta pregunta;

    private String nombrePregunta;
    private String nombreRespuesta;
    private boolean valorCorrectoRespuesta;
    private List<Respuesta> respuestasPregunta;
    private int notaPregunta;
    private int IdEvaluacion;
    @Inject
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuariologin;

    @PostConstruct
    public void inicializar() {
        usuariologin.validarIdioma();
        if (usuariologin.getUsuario().getNombre() != null) {
            this.cursos = this.cursoService.listadoCurso();
            this.departamentos = this.departamentoService.listadoDepartamento();
            Rol rolProfesor = this.rolService.rolPorId(new Rol(2));
            this.usuarios = rolProfesor.getUsuarioList();
            this.notaPregunta = 0;
        } else {
            usuariologin.setMensaje("Usuario no autorizado");
            PrimeFaces pf = PrimeFaces.current();
            pf.executeScript("$('#modal').modal('show')");
        }

    }

    public CursoBean() {
        this.cursos = new ArrayList<>();
        this.curso = new Curso();
        this.departamentos = new ArrayList<>();
        this.funcionalidad = "curso";
        this.departamentos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.respuestasPregunta = new ArrayList<>();
    }

    public String editar(int id) {
        this.curso = this.cursoService.cursoPorId(new Curso(id));
        this.idUsuarioProfesor = this.curso.getIdUsuarioProfesor().getIdUsuario();
        this.idDepartamento = this.curso.getIdDepartamento().getIdDepartamento();
        return this.funcionalidad + "Editar";
    }

    public String guardar() {
        this.curso.setFechaCreacion(new Date());
        this.curso.setIdUsuarioProfesor(this.usuarioService.usuarioPorId(new Usuario(idUsuarioProfesor)));
        this.curso.setIdDepartamento(this.departamentoService.departamentoPorId(new Departamento(idDepartamento)));
        if (this.curso.getEvaluacionList().isEmpty()) {
            Evaluacion objEvaluacion = new Evaluacion(0, "Evaluación final - " + this.curso.getNombre(), "");
            objEvaluacion.setIdCurso(this.curso);
            this.curso.getEvaluacionList().add(objEvaluacion);
        }
        if (this.curso.getIdCurso() == 0) {
            this.cursoService.guardarCurso(this.curso);
        } else {
            this.cursoService.modificarCurso(this.curso);
        }
        this.cursos = cursoService.listadoCurso();
        return this.funcionalidad + "Consultar";
    }

    public String eliminar(int id) {
        this.cursoService.eliminarCurso(new Curso(id));
        this.cursos = cursoService.listadoCurso();
        return this.funcionalidad + "Consultar";
    }

    public String crear() {
        this.curso = new Curso();
        return this.funcionalidad + "Crear";
    }

    public String agregarClase() {
        this.clase = new Clase();
        this.clase.setIdClase(this.curso.getClaseList().size() + 1);
        this.clase.setNombre(this.nombreClase);
        this.clase.setContenido(this.contenidoClase);
        this.clase.setFechaultimoCambio(new Date());
        this.clase.setIdCurso(this.curso);
        this.curso.getClaseList().add(clase);

        this.nombreClase = "";
        this.contenidoClase = "";

        return this.funcionalidad + "Crear";
    }

    public String removerClase(int IdClase) {
        for (int i = 0; i < this.curso.getClaseList().size(); i++) {
            if (this.curso.getClaseList().get(i).getIdClase() == IdClase) {
                this.curso.getClaseList().remove(this.curso.getClaseList().get(i));
            }
        }
        return this.funcionalidad + "Crear";
    }

    public String verEvaliacion(int id) {
        this.curso = this.cursoService.cursoPorId(new Curso(id));
        this.evaluacion = this.curso.getEvaluacionList().get(0);
        this.IdEvaluacion = this.evaluacion.getIdEvaluacion();
        /*TRAE LA PRIMERA EVALUCION*/
        return this.funcionalidad + "Evaluacion";
    }

    public String agregarPregunta() {
        this.pregunta = new Pregunta();
        this.pregunta.setIdEvaluacion(this.evaluacion);
        this.nombrePregunta = "";
        this.notaPregunta = 0;
        this.respuestasPregunta = new ArrayList<>();
        return this.funcionalidad + "AgregarPregunta";
    }

    public String editarPregunta(int Id) {
        this.pregunta = this.preguntaService.preguntaPorId(new Pregunta(Id));
        this.nombrePregunta = this.pregunta.getNombre();
        this.notaPregunta = this.pregunta.getNota();
        this.respuestasPregunta = this.pregunta.getRespuestaList();
        return this.funcionalidad + "AgregarPregunta";
    }

    public String eliminarPregunta(int Id) {
        for (int i = 0; i < this.evaluacion.getPreguntaList().size(); i++) {
            if (this.evaluacion.getPreguntaList().get(i).getIdPregunta() == Id) {
                this.evaluacion.getPreguntaList().remove(this.evaluacion.getPreguntaList().get(i));
            }
        }
        this.evaluacionService.updateEvaluacion(evaluacion);
        this.evaluacion = this.evaluacionService.findByEvaluacion(new Evaluacion(this.IdEvaluacion));
        return this.funcionalidad + "Evaluacion";
    }

    public String guardarPregunta() {
        this.pregunta.setRespuestaList(respuestasPregunta);
        this.pregunta.setNombre(nombrePregunta);
        this.pregunta.setNota(notaPregunta);
        this.pregunta.setIdEvaluacion(evaluacion);
        if (this.pregunta.getIdPregunta() == 0) {
            this.evaluacion.getPreguntaList().add(pregunta);
        }
        this.evaluacionService.updateEvaluacion(evaluacion);
        this.evaluacion = this.evaluacionService.findByEvaluacion(new Evaluacion(this.IdEvaluacion));
        return this.funcionalidad + "Evaluacion";
    }

    public String removerRespuesta(int Id) {
        for (int i = 0; i < this.pregunta.getRespuestaList().size(); i++) {
            if (this.pregunta.getRespuestaList().get(i).getIdRespuesta() == Id) {
                this.pregunta.getRespuestaList().remove(this.pregunta.getRespuestaList().get(i));
            }
        }
        return this.funcionalidad + "AgregarPregunta";
    }

    public String agregarRespuesta() {
        Respuesta objRespuesta = new Respuesta();
        objRespuesta.setIdPregunta(pregunta);
        objRespuesta.setRespuesta(nombreRespuesta);
        objRespuesta.setValorCorrecto(valorCorrectoRespuesta);
        objRespuesta.setIdRespuesta(this.respuestasPregunta.size() + 1);
        this.respuestasPregunta.add(objRespuesta);
        return this.funcionalidad + "AgregarPregunta";
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public int getIdUsuarioProfesor() {
        return idUsuarioProfesor;
    }

    public void setIdUsuarioProfesor(int idUsuarioProfesor) {
        this.idUsuarioProfesor = idUsuarioProfesor;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getContenidoClase() {
        return contenidoClase;
    }

    public void setContenidoClase(String contenidoClase) {
        this.contenidoClase = contenidoClase;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getNombrePregunta() {
        return nombrePregunta;
    }

    public void setNombrePregunta(String nombrePregunta) {
        this.nombrePregunta = nombrePregunta;
    }

    public List<Respuesta> getRespuestasPregunta() {
        return respuestasPregunta;
    }

    public void setRespuestasPregunta(List<Respuesta> respuestasPregunta) {
        this.respuestasPregunta = respuestasPregunta;
    }

    public int getNotaPregunta() {
        return notaPregunta;
    }

    public void setNotaPregunta(int notaPregunta) {
        this.notaPregunta = notaPregunta;
    }

    public String getNombreRespuesta() {
        return nombreRespuesta;
    }

    public void setNombreRespuesta(String nombreRespuesta) {
        this.nombreRespuesta = nombreRespuesta;
    }

    public boolean isValorCorrectoRespuesta() {
        return valorCorrectoRespuesta;
    }

    public void setValorCorrectoRespuesta(boolean valorCorrectoRespuesta) {
        this.valorCorrectoRespuesta = valorCorrectoRespuesta;
    }

    public int getIdEvaluacion() {
        return IdEvaluacion;
    }

    public void setIdEvaluacion(int IdEvaluacion) {
        this.IdEvaluacion = IdEvaluacion;
    }

    public UsuarioBean getUsuariologin() {
        return usuariologin;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
    

}
