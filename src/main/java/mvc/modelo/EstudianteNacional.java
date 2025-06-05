package mvc.modelo;

//clase estudiante nacional
public class EstudianteNacional extends Estudiante{
    //Atributos
    private double porcentajeBecaEstudiante;
    private final static int costoPorCredito = 10000;
    private final static int cargosAdministrativos = 15000;

    //Constructor vacio
    public EstudianteNacional(){
        super();
        this.porcentajeBecaEstudiante = 0.0;
    }

    //Constructor  por parametros
    public EstudianteNacional(int pNumeroCedula, int pNumeroCarnet, String pNombreEstudiante,
                              String pApellido1, String pApellido2, String pNacionalidad, double pPorcentajeBeca, int pCantidadCreditos) {
        super(pNumeroCedula, pNumeroCarnet, pNombreEstudiante, pApellido1, pApellido2, pNacionalidad, pCantidadCreditos);
        this.porcentajeBecaEstudiante = pPorcentajeBeca;
    }
    //getters y setters
    public double getPorcentajeBecaEstudiante() {
        return porcentajeBecaEstudiante;
    }

    public void setPorcentajeBecaEstudiante(double pPorcentajeBecaEstudiante) {
        this.porcentajeBecaEstudiante = pPorcentajeBecaEstudiante;
    }

    //Metodo de calcular los aranceles por curso y creditos
    public double calculoDeArancelesCurso() {
        double costoBaseCreditos = super.getCantidaCreditosMatriculados() * costoPorCredito;
        double subTotal = costoBaseCreditos + cargosAdministrativos;

        double montoConDescuento = subTotal * (1 - this.porcentajeBecaEstudiante);
        return montoConDescuento;
    }
    //toString
    public String toString() {
        return  "---Estudiante nacional---" + "\n"
                + super.toString() + "\n"
                + "Porcentaje de beca del estudiante: " + (this.porcentajeBecaEstudiante * 100) + "%";
    }
}