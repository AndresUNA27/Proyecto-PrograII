package mvc.modelo;

import javax.swing.*;
import java.util.ArrayList;
//Clase profesor:
public class Profesor {
    //Atributos
    private final int numeroCedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private boolean director;
    private String nombreEscuelaPertenece;
    private ArrayList<Grupo> gruposImpartidos;
    //Constructor vacio
    public Profesor(){
        this.numeroCedula = 0;
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.director = false;
        this.nombreEscuelaPertenece = "";
    }

    //Constructor con parametros
    public Profesor(int pNumeroCedula, String pNombre, String pApellido1, String pApellido2, boolean pDirector, String pNombreEscuelaPertenece){
        this.numeroCedula = pNumeroCedula;
        this.nombre = pNombre;
        this.apellido1 = pApellido1;
        this.apellido2 = pApellido2;
        this.director = pDirector;
        this.nombreEscuelaPertenece = pNombreEscuelaPertenece ;
        this.gruposImpartidos = new ArrayList<>();
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

    public String obtenerEscuelaPertenece(){
        return nombreEscuelaPertenece;
    }

    public ArrayList<Grupo> obtenerGruposImpartidos(){
        return gruposImpartidos;
    }

    // Metodos para asignar y desasignar un profesor a un curso
    public void asignarProfesorAGrupo(Grupo grupo){
        if (gruposImpartidos.contains(grupo)){
            JOptionPane.showMessageDialog(null,"El curso ya es impartido por el profesor!!!");
        } else {
            gruposImpartidos.add(grupo);
        }
    }

    public void desasignarProfesorAGrupo(Grupo grupo){
        gruposImpartidos.remove(grupo);
    }

    //Metodo toString
    public String toString() {
        return "Cedula: " + numeroCedula + "\n" +
                " Nombre: " + nombre + "\n" +
                " Primer apellido: " + apellido1 + "\n" +
                " Segundo apellido: " + apellido2 + "\n" +
                " Escuela donde fue registrado: " + nombreEscuelaPertenece;
    }
}