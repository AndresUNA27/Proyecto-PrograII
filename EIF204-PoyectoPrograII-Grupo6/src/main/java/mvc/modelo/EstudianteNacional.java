package mvc.modelo;

public class EstudianteNacional extends Estudiante{
    private double porcentajeBecaEstudiante;
    private final static int costoPorCredito = 10000;
    private final static int cargosAdministrativos = 15000;

    public EstudianteNacional(){
        super();
        this.porcentajeBecaEstudiante = 0.0;
    }

    public EstudianteNacional(int pNumeroCedula, int pNumeroCarnet, String pNombreEstudiante,
                              String pApellido1, String pApellido2, String pNacionalidad, double pPorcentajeBeca) {
        super(pNumeroCedula, pNumeroCarnet, pNombreEstudiante, pApellido1, pApellido2, pNacionalidad);
        this.porcentajeBecaEstudiante = pPorcentajeBeca;
    }

    public double getPorcentajeBecaEstudiante() {
        return porcentajeBecaEstudiante;
    }

    public void setPorcentajeBecaEstudiante(double pPorcentajeBecaEstudiante) {
        this.porcentajeBecaEstudiante = pPorcentajeBecaEstudiante;
    }

    public double calculoDeArancelesCurso(int cantidadCreditos) {
        double costoBaseCreditos = cantidadCreditos * costoPorCredito;
        double subTotal = costoBaseCreditos + cargosAdministrativos;

        double montoConDescuento = subTotal * (1 - this.porcentajeBecaEstudiante);
        return montoConDescuento;
    }

    public String toString() {
        return  "---Estudiante nacional---" + "\n"
                + super.toString()
                + "Porcentaje de beca del estudiante: " + (this.porcentajeBecaEstudiante * 100) + "%";
    }

}
