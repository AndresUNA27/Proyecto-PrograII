package mvc.modelo;
import javax.swing.*;
import java.util.ArrayList;

public class Universidad {

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
    public Universidad(String pNameU,String pAddresU,int pNumberU) {
        this.varNameU = pNameU;
        this.varAddresU = pAddresU;
        this.varNumberU = pNumberU;
        this.escuelas = new ArrayList<>();
        this.estudiantesNacionalesDeLaUniversidad = new ArrayList<>();
        this.estudiantesExtranjerosDeLaUniversidad = new ArrayList<>();
    };

    public Escuela encontrarEscuelaConNombre(String pNombreEscuela){
        for(Escuela p : escuelas) {
            if(p.getVarSchoolName().equalsIgnoreCase(pNombreEscuela)) {
                return p;
            }
        }
        return null;
    }

    public void agregarEscuela(Escuela escuela) {
        this.escuelas.add(escuela);
    }

    public ArrayList<Escuela> getEscuelas(){
        return this.escuelas;
    }

    public void agregarEstudianteNacional(EstudianteNacional pEstudianteNacional) { this.estudiantesNacionalesDeLaUniversidad.add(pEstudianteNacional); }

    public ArrayList<EstudianteNacional> getEstudiantesNacionalesDelCurso(){ return this.estudiantesNacionalesDeLaUniversidad; }

    public void agregarEstudianteExtranjero(EstudianteExtranjero pEstudianteExtranjero) { this.estudiantesExtranjerosDeLaUniversidad.add(pEstudianteExtranjero); }

    public ArrayList<EstudianteExtranjero> getEstudiantesExtranjerosDelCurso(){ return this.estudiantesExtranjerosDeLaUniversidad; }

    public Escuela getEscuelaConNombre(String pNombreEscuela){
        for(Escuela e : escuelas) {
            if(e.getVarSchoolName().equalsIgnoreCase(pNombreEscuela)) {
                return e;
            }
        }
        return null;
    }

    public void cambiarDeNacionalidadEstudianteNacional(int pNumeroCedulaCarnet){
        estudiantesNacionalesDeLaUniversidad.removeIf(
                e -> e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet
        );
    }

    public EstudianteNacional encontrarEstudianteNacionalConCedulaCarnet(int pNumeroCedulaCarnet){
        for (EstudianteNacional e : estudiantesNacionalesDeLaUniversidad){
            if (e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet) {
                JOptionPane.showMessageDialog(null, "Estudiante nacional encontrado correctamente!!!");
                return e;
            }
        }
        return null;
    }

    public void cambiarDeNacionalidadEstudianteExtranjero(int pNumeroCedulaCarnet){
        estudiantesExtranjerosDeLaUniversidad.removeIf(
                e -> e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet
        );
    }

    public EstudianteExtranjero encontrarEstudianteExtranjeroConCedulaCarnet(int pNumeroCedulaCarnet){
        for (EstudianteExtranjero e : estudiantesExtranjerosDeLaUniversidad) {
            if (e.getNumeroCedulaEstudiante() == pNumeroCedulaCarnet || e.getNumeroCarnetEstudiante() == pNumeroCedulaCarnet) {
                JOptionPane.showMessageDialog(null, "Estudiante extranjero encontrado correctamente!!!");
                return e;
            }
        }
        return null;
    }

    public String toString() {

        return "Nombre de la universidad "+this.varNameU+"direccion de la univercidad "+this.varAddresU+"Numero de la univercidad "+this.varNumberU;

    }
}