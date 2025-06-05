package mvc.modelo;

import javax.swing.*;
import java.util.ArrayList;

//Clase Grupo
public class Grupo {
    //Atributos
    private final String siglaGrupo;
    private String cursoSiglaPertenece;
    private Integer profesorPertenece;
    private ArrayList<EstudianteNacional> estudiantesNacionalesDelCurso;
    private ArrayList<EstudianteExtranjero> estudiantesExtranjerosDelCurso;

    //Constructor vacio
    public Grupo(){
        this.siglaGrupo = "";
        this.cursoSiglaPertenece = "";
        this.profesorPertenece = null;
    }
    //Constructor con parametros
    public Grupo(String siglaGrupo, String cursoPertenece, Integer profesorPertenece) {
        this.siglaGrupo = siglaGrupo;
        this.cursoSiglaPertenece = cursoPertenece;
        this.profesorPertenece = profesorPertenece;
        this.estudiantesNacionalesDelCurso = new ArrayList<>();
        this.estudiantesExtranjerosDelCurso = new ArrayList<>();
    }
    //Setters y getters
    public String getSiglaGrupo() {
        return siglaGrupo;
    }

    public Integer getProfesorPertenece() {
        return this.profesorPertenece;
    }

    public void setProfesorPertenece(Integer  pProfesorPertenece) {
        this.profesorPertenece = pProfesorPertenece;
    }

    public String getCursoPertenece() {
        return cursoSiglaPertenece;
    }

    public void setCursoPertenece(String pCursoPertenece) {
        this.cursoSiglaPertenece = pCursoPertenece;
    }

    public ArrayList<EstudianteNacional> getEstudiantesNacionalesDelCurso() {
        return estudiantesNacionalesDelCurso;
    }

    public boolean estaMatriculadoExtranjero(Estudiante estudiante) {

        return estudiantesExtranjerosDelCurso.contains(estudiante);
    }
    //Matricular
    public boolean estaMatriculadoNacional(Estudiante estudiante) {
        return estudiantesNacionalesDelCurso.contains(estudiante);
    }

    //Agregar estudiante
    public void agregarEstudianteNacional(EstudianteNacional estudianteNacional){
        if(!estaMatriculadoNacional(estudianteNacional)){
            this.estudiantesNacionalesDelCurso.add(estudianteNacional);
            return;
        }
        JOptionPane.showMessageDialog(null,"El estudiante ya esta matriculado");
        return;
    }
    //obtener estudiantes extranjeros
    public ArrayList<EstudianteExtranjero> getEstudiantesExtranjerosDelCurso() {
        return estudiantesExtranjerosDelCurso;
    }
    //Agregar estudiante extranjero
    public void agregarEstudianteExtranjero(EstudianteExtranjero estudianteExtranjero){
        if(!estaMatriculadoExtranjero(estudianteExtranjero)){
            this.estudiantesExtranjerosDelCurso.add(estudianteExtranjero);
            return;
        }
        JOptionPane.showMessageDialog(null,"El estudiante ya esta matriculado");
        return;
    }
    //Eliminar estudiante
    public void eliminarEstudiante(Estudiante est) {
        if (est instanceof EstudianteNacional) {
            estudiantesNacionalesDelCurso.remove(est);
        } else if (est instanceof EstudianteExtranjero) {
            estudiantesExtranjerosDelCurso.remove(est);
        }
    }


    public void agregarEstudiante(Estudiante est) {
        if (est instanceof EstudianteNacional) {
            agregarEstudianteNacional((EstudianteNacional) est);
        } else if (est instanceof EstudianteExtranjero) {
            agregarEstudianteExtranjero((EstudianteExtranjero) est);
        }
    }
     // Metodo para saber si el estudiante está matriculado
    public boolean saberSiEstudianteEstaMatriculado(Estudiante est) {
        if (est instanceof EstudianteNacional) {
            return estaMatriculadoNacional((EstudianteNacional) est);
        } else if (est instanceof EstudianteExtranjero) {
            return estaMatriculadoExtranjero((EstudianteExtranjero) est);
        }
        return false;
    }

    //to String
    public String toString() {
        return "Sigla del grupo: " + siglaGrupo + " --Pertenece al curso con sigla: " + cursoSiglaPertenece;
    }
}