package mvc.modelo;
import javax.swing.*;
import java.util.ArrayList;
//clase universidad
public class Universidad {
    //Atributos
    private  final String varNameU;
    private String varAddresU;
    private int varNumberU;
    private ArrayList<Escuela> escuelas;
    private ArrayList<EstudianteNacional> estudiantesNacionalesDeLaUniversidad;
    private ArrayList<EstudianteExtranjero> estudiantesExtranjerosDeLaUniversidad;
    // private ArrayList<Curso>listaCursos;

    public String getVarNameU() {
        return varNameU;
    }
    public String getVarAddresU() {
        return varAddresU;
    }
    public void setVarAddresU(String varAddresU) {
        this.varAddresU = varAddresU;
    }
    public int getVarNumberU() {
        return varNumberU;
    }
    public void setVarNumberU(int varNumberU) {
        this.varNumberU = varNumberU;
    }

    public Universidad() {
        this.varNameU = "";
        this.varAddresU = "";
        this.varNumberU = 0;
    };
    //Constructor con parametros
    public Universidad(String pNameU,String pAddresU,int pNumberU) {
        this.varNameU = pNameU;
        this.varAddresU = pAddresU;
        this.varNumberU = pNumberU;
        this.escuelas = new ArrayList<>();
        this.estudiantesNacionalesDeLaUniversidad = new ArrayList<>();
        this.estudiantesExtranjerosDeLaUniversidad = new ArrayList<>();
    };
    //Metodos:
    //Metodo para encontrar la escuela
    public Escuela encontrarEscuelaConNombre(String pNombreEscuela){
        for(Escuela p : escuelas) {
            if(p.getVarSchoolName().equalsIgnoreCase(pNombreEscuela)) {
                return p;
            }
        }
        return null;
    }
    //Setters y Getters
//Metodo para agregar la escuela
    public void agregarEscuela(Escuela escuela) {
        this.escuelas.add(escuela);
    }
    //Metodo del arrayList (get)
    public ArrayList<Escuela> getEscuelas(){
        return this.escuelas;
    }
    //Metodo para agregar estudiante nacional
    public void agregarEstudianteNacional(EstudianteNacional pEstudianteNacional) { this.estudiantesNacionalesDeLaUniversidad.add(pEstudianteNacional); }
    //Metodo del arrayList estudiante nacional (get)
    public ArrayList<EstudianteNacional> getEstudiantesNacionalesDelCurso(){ return this.estudiantesNacionalesDeLaUniversidad; }
    //Metodo para agregar estudiante extranjero
    public void agregarEstudianteExtranjero(EstudianteExtranjero pEstudianteExtranjero) { this.estudiantesExtranjerosDeLaUniversidad.add(pEstudianteExtranjero); }
    //Metodo del arrayList estudiante nacional (get)
    public ArrayList<EstudianteExtranjero> getEstudiantesExtranjerosDelCurso(){ return this.estudiantesExtranjerosDeLaUniversidad; }
    //Metodo para obtener las escuelas por nombre
    public Escuela getEscuelaConNombre(String pNombreEscuela){
        for(Escuela e : escuelas) {
            if(e.getVarSchoolName().equalsIgnoreCase(pNombreEscuela)) {
                return e;
            }
        }
        return null;
    }
    //Metodo para cambiar de nacionalidad al estudiante. Remover el estudiante nacional
    public void cambiarDeNacionalidadEstudianteNacional(int pNumeroCedulaCarnet){
        estudiantesNacionalesDeLaUniversidad.removeIf(
                e -> e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet
        );
    }
    //Metodo para encontrar al estudiante nacional por la cedula o carnet
    public EstudianteNacional encontrarEstudianteNacionalConCedulaCarnet(int pNumeroCedulaCarnet){
        for (EstudianteNacional e : estudiantesNacionalesDeLaUniversidad){
            if (e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet) {
                JOptionPane.showMessageDialog(null, "Estudiante nacional encontrado correctamente!!!");
                return e;
            }
        }
        return null;
    }
    //Metodo para cambiar de nacionalidad al estudiante. Remover el estudiante extranjero
    public void cambiarDeNacionalidadEstudianteExtranjero(int pNumeroCedulaCarnet){
        estudiantesExtranjerosDeLaUniversidad.removeIf(
                e -> e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet
        );
    }
    //Metodo para encontrar al estudiante extranjero por la cedula o carnet
    public EstudianteExtranjero encontrarEstudianteExtranjeroConCedulaCarnet(int pNumeroCedulaCarnet){
        for (EstudianteExtranjero e : estudiantesExtranjerosDeLaUniversidad) {
            if (e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet) {
                JOptionPane.showMessageDialog(null, "Estudiante extranjero encontrado correctamente!!!");
                return e;
            }
        }
        return null;
    }
    //Metodo toString
    public String toString() {
        return "Nombre de la universidad: "+ this.varNameU + "\n"
                + "Direccion de la universidad: " + this.varAddresU + "\n"
                + "Numero de la universidad: " + this.varNumberU;
    }
}