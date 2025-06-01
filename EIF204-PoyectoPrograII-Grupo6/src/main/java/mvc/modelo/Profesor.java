package mvc.modelo;

import javax.swing.*;
import java.util.ArrayList;

public class Profesor {
    private final int numeroCedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private boolean director;
    private Escuela escuelaPertenece;
    private ArrayList<Curso> cursosImpartidos;

    public Profesor(int pNumeroCedula, String pNombre, String pApellido1, String pApellido2, boolean pDirector, Escuela pEscuela){
        this.numeroCedula = pNumeroCedula;
        this.nombre = pNombre;
        this.apellido1 = pApellido1;
        this.apellido2 = pApellido2;
        this.director = pDirector;
        this.escuelaPertenece = pEscuela;
        this.cursosImpartidos = new ArrayList<>();
    }

    // Setters y getters
    public int getNumeroCedula(){
        return this.numeroCedula;
    }

    public void setNombre(String pNombre){
        this.nombre = pNombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido1(String pApellido1){
        this.apellido1 = pApellido1;
    }

    public String getApellido1(){return this.apellido1;}

    public void setApellido2(String pApellido2){
        this.apellido2 = pApellido2;
    }

    public String getApellido2(){
        return this.apellido2;
    }

    public void setDirector(boolean pDirector){this.director = pDirector;}

    public boolean getDirector(){return this.director;}

    public Escuela obtenerEscuelaPertenece(){
        return escuelaPertenece;
    }

    public ArrayList<Curso> obtenerCursosImpartidos(){
        return cursosImpartidos;
    }

    // Metodos para asignar y desasignar un profesor a un curso
    public void asignarProfesorACurso(Curso curso){
        if (cursosImpartidos.contains(curso)){
            JOptionPane.showMessageDialog(null,"El curso ya es impartido por el profesor!!!");
        } else {
            cursosImpartidos.add(curso);
        }
    }

    public void desasignarProfesorACurso(Curso curso){
        cursosImpartidos.remove(curso);
    }

    public String toString() {
        return "Cedula = " + numeroCedula + "\n" +
                "Nombre = " + nombre + "\n" +
                "Primer apellido = " + apellido1 + "\n" +
                "Segundo apellido = " + apellido2 + "\n" +
                "Escuela donde fue registrado = " + (escuelaPertenece.getVarSchoolName());
    }
}
