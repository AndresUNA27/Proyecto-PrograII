package mvc.modelo;

public class Grupo {
    private final String siglaGrupo;
    private Curso cursoPertenece; // Merequetengue
    private Profesor profesorPertenece;

    public Grupo(){
        this.siglaGrupo = "";
        this.cursoPertenece = null;
        this.profesorPertenece = null;
    }

    public Grupo(String siglaGrupo, Curso cursoPertenece, Profesor profesorPertenece) {
        this.siglaGrupo = siglaGrupo;
        this.cursoPertenece = cursoPertenece;
        this.profesorPertenece = profesorPertenece;
    }

    public String getSiglaGrupo() {
        return siglaGrupo;
    }

    public Profesor getProfesorPertenece() {
        return profesorPertenece;
    }

    public void setProfesorPertenece(Profesor pProfesorPertenece) {
        this.profesorPertenece = pProfesorPertenece;
    }

    public Curso getCursoPertenece() {
        return cursoPertenece;
    }

    public void setCursoPertenece(Curso pCursoPertenece) {
        this.cursoPertenece = pCursoPertenece;
    }

    public String toString(){
        return "Sigla del curso: " + siglaGrupo
                + " Curso al que pertenece el grupo: " + cursoPertenece.getNombre();
    }
}