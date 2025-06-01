package mvc.modelo;
import java.util.ArrayList;

public class Universidad {

    private  final String varNameU;
    private String varAddresU;
    private int varNumberU;
    private ArrayList<Escuela> escuelas;
    private ArrayList<EstudianteNacional> estudiantesNacionalesDeLaUniversidad;
    private ArrayList<EstudianteExtranjero> estudiantesExtranjerosDeLaUniversidad;

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

    public String toString() {

        return "Nombre de la universidad "+this.varNameU+"direccion de la univercidad "+this.varAddresU+"Numero de la univercidad "+this.varNumberU;

    }
}