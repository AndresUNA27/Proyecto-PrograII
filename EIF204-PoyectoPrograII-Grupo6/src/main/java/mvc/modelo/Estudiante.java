package mvc.modelo;

public class Estudiante {
    private int numeroCedulaEstudiante;
    private int numeroCarnetEstudiante;
    private String nombreEstudiante;
    private String apellido1Estudiante;
    private String apellido2Estudiante;
    private String nacionalidadEstudiante;

    public Estudiante(){
        this.numeroCedulaEstudiante = 0;
        this.numeroCarnetEstudiante = 0;
        this.nombreEstudiante = "";
        this.apellido1Estudiante = "";
        this.apellido2Estudiante = "";
        this.nacionalidadEstudiante = "";
    }

    public Estudiante(int pNumeroCedula, int pNumeroCarnet, String pNombreEstudiante, String pApellido1, String pApellido2, String pNacionaidad){
        this.numeroCedulaEstudiante = pNumeroCedula;
        this.numeroCarnetEstudiante = pNumeroCarnet;
        this.nombreEstudiante = pNombreEstudiante;
        this.apellido1Estudiante = pApellido1;
        this.apellido2Estudiante = pApellido2;
        this.nacionalidadEstudiante = pNacionaidad;
    }

    // Getters y setters de los atributos
    public int getNumeroCedulaEstudiante() {
        return numeroCedulaEstudiante;
    }

    public void setNumeroCedulaEstudiante(int pNumeroCedulaEstudiante) {
        this.numeroCedulaEstudiante = pNumeroCedulaEstudiante;
    }

    public int getNumeroCarnetEstudiante() {
        return numeroCarnetEstudiante;
    }

    public void setNumeroCarnetEstudiante(int pNumeroCarnetEstudiante) {
        this.numeroCarnetEstudiante = numeroCarnetEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String pNombreEstudiante) {
        this.nombreEstudiante = pNombreEstudiante;
    }

    public String getApellido1Estudiante() {
        return apellido1Estudiante;
    }

    public void setApellido1Estudiante(String pApellido1Estudiante) {
        this.apellido1Estudiante = pApellido1Estudiante;
    }

    public String getApellido2Estudiante() {
        return apellido2Estudiante;
    }

    public void setApellido2Estudiante(String pApellido2Estudiante) {
        this.apellido2Estudiante = pApellido2Estudiante;
    }

    public String getNacionalidadEstudiante() {
        return nacionalidadEstudiante;
    }

    public void setNacionalidadEstudiante(String nacionalidadEstudiante) {
        this.nacionalidadEstudiante = nacionalidadEstudiante;
    }

    public String toString() {
        return  "Numero de cedula del estudiante: " + this.numeroCedulaEstudiante + "\n"
                + "Numero del carnet del estudiante: " + this.numeroCarnetEstudiante + "\n"
                + "Nombre del estudiante: " + this.nombreEstudiante + "\n"
                + "Primer apellido del estudiante: " + this.apellido1Estudiante + "\n"
                + "Segundo apellido del estudiante: " + this.apellido2Estudiante + "\n"
                + "El estudiante es: " + this.nacionalidadEstudiante + "\n";
    }
}