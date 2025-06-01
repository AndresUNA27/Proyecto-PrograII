package mvc.modelo;

public class EstudianteExtranjero extends Estudiante{
    private final double recargoEstudianteExtranjero = 0.40;
    private final static int costoPorCredito = 10000;
    private final static int cargosAdministrativos = 15000;

    public EstudianteExtranjero(){
        super();
    }

    public EstudianteExtranjero(int pNumeroCedula, int pNumeroCarnet, String pNombreEstudiante, String pApellido1,
                                String pApellido2, String pNacionalidad){
        super(pNumeroCedula, pNumeroCarnet, pNombreEstudiante, pApellido1, pApellido2, pNacionalidad);
    }

    public double calculoArancelCurso(int cantidadCreditos){
        double costoBaseCreditos = cantidadCreditos * costoPorCredito;
        double subTotal = costoBaseCreditos + cargosAdministrativos;

        double montoFinal = subTotal * (1 + recargoEstudianteExtranjero);
        return montoFinal;
    }

    public String toString() {
        return "---Estudiante extranjero---" + "\n"
                + super.toString()
                + "Recargo del estudiante: " + (this.recargoEstudianteExtranjero * 100) + "%";
    }
}
