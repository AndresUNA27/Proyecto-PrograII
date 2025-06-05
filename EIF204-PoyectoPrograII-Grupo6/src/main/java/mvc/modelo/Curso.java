package mvc.modelo;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Curso {
    private String sigla;
    private String nombre;
    private String escuelaPertenece;
    private float creditos;
    private ArrayList<Profesor> profesoresDelCurso;
    private ArrayList<EstudianteNacional> estudiantesNacionalesDelCurso;
    private ArrayList<EstudianteExtranjero> estudiantesExtranjerosDelCurso;
    private ArrayList<Grupo> gruposDelCurso;

    public Curso(){
        this.sigla = "";
        this.nombre = "";
        this.escuelaPertenece = "";
    }

    public Curso(String sigla, String nombre, String escuelaPertenece) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.escuelaPertenece = escuelaPertenece;
        this.profesoresDelCurso= new ArrayList<>();
        this.estudiantesNacionalesDelCurso = new ArrayList<>();
        this.estudiantesExtranjerosDelCurso = new ArrayList<>();
        this.gruposDelCurso = new ArrayList<>();
        this.creditos = new Random().nextFloat(2) + 3;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getSigla() {
        return this.sigla;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setEscuelaPertenece(String escuelaPertenece) {
        this.escuelaPertenece = escuelaPertenece;
    }

    public String getEscuelaPertenece() {
        return this.escuelaPertenece;
    }

    public ArrayList<EstudianteNacional> getEstudiantesNacionalesDelCurso() {
        return estudiantesNacionalesDelCurso;
    }
    public boolean estaMatriculadoExtranjero(Estudiante estudiante) {
        return estudiantesExtranjerosDelCurso.contains(estudiante);
    }
    public boolean estaMatriculadoNacional(Estudiante estudiante) {
        return estudiantesNacionalesDelCurso.contains(estudiante);
    }
    public boolean estaDesmatriculadoEstudiante(Estudiante pEstudiante){
        return estudiantesExtranjerosDelCurso.contains(pEstudiante);
    }
    public void agregarEstudianteNacional(EstudianteNacional estudianteNacional){
        if(!estaMatriculadoNacional(estudianteNacional)){
            this.estudiantesNacionalesDelCurso.add(estudianteNacional);
            return;
        }
        JOptionPane.showMessageDialog(null,"El estudiante ya esta matriculado");
    }

    public ArrayList<EstudianteExtranjero> getEstudiantesExtranjerosDelCurso() {
        return estudiantesExtranjerosDelCurso;
    }

    public void agregarEstudianteExtranjero(EstudianteExtranjero estudianteExtranjero){
        if(!estaMatriculadoExtranjero(estudianteExtranjero)){
            this.estudiantesExtranjerosDelCurso.add(estudianteExtranjero);
            return;
        }
        JOptionPane.showMessageDialog(null,"El estudiante ya esta matriculado");
    }
    public void eliminarEstudiante(Estudiante est){
        if(!estaDesmatriculadoEstudiante(est)) {
            if (est instanceof EstudianteNacional) {
                estudiantesNacionalesDelCurso.remove(est);
            } else if (est instanceof EstudianteExtranjero) {
                estudiantesExtranjerosDelCurso.remove(est);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"El estudiante no puede desmatricularse porque esta matriculado");
        }
    }

    public void agregarEstudiante(Estudiante est) {
            if (est instanceof EstudianteNacional) {
                agregarEstudianteNacional((EstudianteNacional) est);
            } else if (est instanceof EstudianteExtranjero) {
                agregarEstudianteExtranjero((EstudianteExtranjero) est);
            }

    }

    public ArrayList<Grupo> getGruposDelCurso(){
        return gruposDelCurso;
    }

    public void agregarGrupo(Grupo pGrupo){
        gruposDelCurso.add(pGrupo);
    }

    public String toString() {
        return sigla + ": " + nombre + ": " + escuelaPertenece+": ";
    }
}
