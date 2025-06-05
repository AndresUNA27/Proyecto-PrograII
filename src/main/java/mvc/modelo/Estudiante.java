package mvc.modelo;
//Clase estudiante
public class Estudiante {
    //Atributos
    private int numeroCedulaEstudiante;
    private int numeroCarnetEstudiante;
    private String nombreEstudiante;
    private String apellido1Estudiante;
    private String apellido2Estudiante;
    private String nacionalidadEstudiante;
    private int cantidaCreditosMatriculados;

    //Constructor vacio
    public Estudiante(){
        this.numeroCedulaEstudiante = 0;
        this.numeroCarnetEstudiante = 0;
        this.nombreEstudiante = "";
        this.apellido1Estudiante = "";
        this.apellido2Estudiante = "";
        nacionalidadEstudiante = "";
        cantidaCreditosMatriculados = 0;
    }

    //Constructor por parametros
    public Estudiante(int pNumeroCedula, int pNumeroCarnet, String pNombreEstudiante, String pApellido1, String pApellido2, String pNacionalidad, int pCantidadCreditosMatriculados) {
        this.numeroCedulaEstudiante = pNumeroCedula;
        this.numeroCarnetEstudiante = pNumeroCarnet;
        this.nombreEstudiante = pNombreEstudiante;
        this.apellido1Estudiante = pApellido1;
        this.apellido2Estudiante = pApellido2;
        this.nacionalidadEstudiante = pNacionalidad;
        this.cantidaCreditosMatriculados = pCantidadCreditosMatriculados;
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

    public double getCantidaCreditosMatriculados() {
        return cantidaCreditosMatriculados;
    }

    public void setCantidaCreditosMatriculados(int cantidaCreditosMatriculados) {
        this.cantidaCreditosMatriculados = cantidaCreditosMatriculados;
    }
    // ------Metodos propios------

     // Metodo para agregar los creditos del curso cuando se matricula un curso
    public void agregarCreditos(int pCreditosSumados){
        this.cantidaCreditosMatriculados += pCreditosSumados;
    }

    // Metodo para quitar los creditos del curso cuando se desmatricula un curso
    public void quitarCreditos(int pCreditosRestados){
        this.cantidaCreditosMatriculados -= pCreditosRestados;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comparación por referencia
        if (obj == null || getClass() != obj.getClass()) return false;

        Estudiante other = (Estudiante) obj;
        return this.numeroCedulaEstudiante == other.numeroCedulaEstudiante;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numeroCedulaEstudiante);
    }

    //toString
    public String toString() {
        return  " cedula: "+this.numeroCedulaEstudiante + "\n"
                + "-carnet:" + " "+this.numeroCarnetEstudiante + "\n"
                + "-Nombre:" + " "+this.nombreEstudiante + "\n"
                + "-apellido:" + " "+this.apellido1Estudiante + "\n"
                + "-apellido:" + " "+this.apellido2Estudiante + "\n"
                + "-Nacionalidad:" + " "+this.nacionalidadEstudiante + "\n"
                + "-Cantidad de creditos:" + this.cantidaCreditosMatriculados + "\n";
    }
}