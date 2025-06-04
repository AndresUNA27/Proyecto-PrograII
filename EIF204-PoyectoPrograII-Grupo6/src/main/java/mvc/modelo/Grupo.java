package mvc.modelo;

public class Grupo {
    private final String siglaGrupo;
    private  String cursoSiglaPertenece; // Merequetengue
    private Integer  profesorPertenece;

    public Grupo(){
        this.siglaGrupo = "";
        this.cursoSiglaPertenece = "";
        this.profesorPertenece = 0;
    }

    public Grupo(String siglaGrupo, String cursoPertenece, int profesorPertenece) {
        this.siglaGrupo = siglaGrupo;
        this.cursoSiglaPertenece = cursoPertenece;
        this.profesorPertenece = profesorPertenece;
    }

    public String getSiglaGrupo() {
        return siglaGrupo;
    }

    public Integer  getProfesorPertenece() {
        return this.profesorPertenece;
    }

    public void setProfesorPertenece(Integer  pProfesorPertenece) {
        this.profesorPertenece = pProfesorPertenece;
    }

    public String getCursoPertenece() {
        return cursoSiglaPertenece;
    }

    public void setCursoPertenece(String pCursoPertenece) {
        this.cursoSiglaPertenece = pCursoPertenece;
    }

    public String toString() {
        return siglaGrupo + " (" + cursoSiglaPertenece + ")";
    }
}