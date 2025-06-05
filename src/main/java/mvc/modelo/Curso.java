package mvc.modelo;
import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//clase curso
public class Curso {
    //Atributos
    private String sigla;
    private String nombre;
    private String escuelaPertenece;
    private int creditos;
    private ArrayList<Grupo> gruposDelCurso;
    //Constructor vacio
    public Curso(){
        this.sigla = "";
        this.nombre = "";
        this.escuelaPertenece = "";
    }
    //Constructor con parametros
    public Curso(String sigla, String nombre, String escuelaPertenece) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.escuelaPertenece = escuelaPertenece;
        this.gruposDelCurso = new ArrayList<>();
        this.creditos = ThreadLocalRandom.current().nextInt(3, 5);
    }
    //Setters y getters
    public int getCreditos() {
        return creditos;
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

    public String getEscuelaPertenece() {
        return this.escuelaPertenece;
    }

    //ArrayList de cursos
    public ArrayList<Grupo> getGruposDelCurso(){
        return gruposDelCurso;
    }

    // Agregar un grupo al curso
    public void agregarGrupo(Grupo pGrupo){
        gruposDelCurso.add(pGrupo);
    }

    //toString
    public String toString() {
        return sigla + ": " + nombre + ": " + escuelaPertenece+": ";
    }
}
