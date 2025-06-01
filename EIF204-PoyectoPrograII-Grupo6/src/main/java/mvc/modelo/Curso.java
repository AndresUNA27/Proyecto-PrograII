package mvc.modelo;
import java.util.ArrayList;


public class Curso {
    private String sigla;
    private String nombre;
    private String escuelaPertenece;
    private ArrayList<Profesor> profesoresDelCurso;
    private ArrayList<EstudianteNacional> estudiantesNacionalesDelCurso;
    private ArrayList<EstudianteExtranjero> estudiantesExtranjerosDelCurso;

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

    public void agregarEstudianteNacional(EstudianteNacional estudianteNacional){
        this.estudiantesNacionalesDelCurso.add(estudianteNacional);
    }

    public void cambiarDeNacionalidad(int pNumeroCedula){
        for (EstudianteNacional e : estudiantesNacionalesDelCurso){
            if (e.getNumeroCedulaEstudiante() == pNumeroCedula ) {
                estudiantesNacionalesDelCurso.remove(e);
            }
        }
    }

    public ArrayList<EstudianteExtranjero> getEstudiantesExtranjerosDelCurso() {
        return estudiantesExtranjerosDelCurso;
    }

    public void agregarEstudianteExtranjero(EstudianteExtranjero estudianteExtranjero){
        this.estudiantesExtranjerosDelCurso.add(estudianteExtranjero);
    }

    public void cambiarDeNacionalidadEstudianteExtranjero(int pNumeroCarnet){
        for (EstudianteExtranjero e : estudiantesExtranjerosDelCurso){
            if (e.getNumeroCarnetEstudiante() == pNumeroCarnet) {
                estudiantesExtranjerosDelCurso.remove(e);
            }
        }
    }

    public String toString() {
        return sigla + " - " + nombre + " - " + escuelaPertenece+" ";
    }
}
