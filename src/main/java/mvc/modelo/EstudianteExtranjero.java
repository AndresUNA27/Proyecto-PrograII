package mvc.modelo;
//clase estudiante extranjero
public class EstudianteExtranjero extends Estudiante{
    //Atributos
    private final double recargoEstudianteExtranjero = 0.40;
    private final static int costoPorCredito = 10000;
    private final static int cargosAdministrativos = 15000;

    //constructor vacio
    public EstudianteExtranjero(){
        super();
    }

    //constructor con parametros
    public EstudianteExtranjero(int pNumeroCedula, int pNumeroCarnet, String pNombreEstudiante, String pApellido1,
                                String pApellido2, String pNacionalidad,int pCantidadCreditos){
        super(pNumeroCedula, pNumeroCarnet, pNombreEstudiante, pApellido1, pApellido2, pNacionalidad, pCantidadCreditos);
    }

    //Metodo de calcular los aranceles por curso y creditos
    public double calculoArancelCurso(){
        double costoBaseCreditos = super.getCantidaCreditosMatriculados() * costoPorCredito;
        double subTotal = costoBaseCreditos + cargosAdministrativos;

        double montoFinal = subTotal * (1 + recargoEstudianteExtranjero);
        return montoFinal;
    }
    //toString
    public String toString() {
        return "---Estudiante extranjero---" + "\n"
                + super.toString() + "\n"
                + "Recargo del estudiante: " + (this.recargoEstudianteExtranjero * 100) + "%";
    }
}
