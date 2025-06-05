package mvc.modelo;
import java.util.ArrayList;
//Clase escuela
public class Escuela {

    //Atributos
    private String varSchoolName;
    private ArrayList<Curso> cursos;
    private ArrayList<Profesor> profesores;
    //getters y setters
    public String getVarSchoolName() {
        return varSchoolName;
    }

    public void setVarSchoolName(String varSchoolName) {
        this.varSchoolName = varSchoolName;
    }
    public Escuela() {
        this.varSchoolName = "";
    };
    public Escuela(String pSchoolName) {
        this.varSchoolName = pSchoolName;
        cursos = new ArrayList<>();
        profesores = new ArrayList<>();
    }
    //toString
    public String toString() {
        return "Nombre: " + varSchoolName;
    }
    //agregar curso
    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    //agregar profesor
    public void agregarProfesor(Profesor profesor){
        this.profesores.add(profesor);
    }

    public ArrayList<Profesor> getProfesores(){
        return profesores;
    }

    //Metodo para obtener curso por la sigla
    public Curso getCursoConSigla(String sigla){
        for(Curso c : cursos) {
            if(c.getSigla().equalsIgnoreCase(sigla)) {
                return c;
            }
        }
        return null;
    }
    //Metodo para obtener curso por el nombre
    public Curso getCursoConNombre(String pNombre){
        for(Curso c : cursos) {
            if(c.getNombre().equalsIgnoreCase(pNombre)) {
                return c;
            }
        }
        return null;
    }
    //Metodo para modificar  curso por la sigla
    public String modificarCurso(String sigla, String nombre) {
        Curso curso = getCursoConSigla(sigla);

        if(curso != null) {
            curso.setNombre(nombre);
            return "Nombre del curso modificado correctamente :)";
        }

        return "Curso no encontrado :(";
    }
    //Metodo para eliminar curso por la sigla
    public boolean eliminarCursoConSigla(String sigla) {
        Curso curso = getCursoConSigla(sigla);
        if(curso != null) {
            cursos.remove(curso);
            return true;
        }
        return false;
    }

    // Metodo para encontrar un profesor
    public Profesor getProfesorConCedula(int numCedula){
        for(Profesor p : profesores) {
            if(p.getNumeroCedula() == numCedula) {
                return p;
            }
        }
        return null;
    }
    //Metodo para modificar el profesor
    public String modificarProfesor(int pNumCedula,String pNombre, String pApellido1, String pApellido2){
        Profesor profesor = getProfesorConCedula(pNumCedula);
        if(profesor != null) {
            profesor.setNombre(pNombre);
            profesor.setApellido1(pApellido1);
            profesor.setApellido2(pApellido2);
            return "Nombre y apellidos del profesor modificados correctamente :)";
        }
        return "Profesor no encontrado D:";
    }
}