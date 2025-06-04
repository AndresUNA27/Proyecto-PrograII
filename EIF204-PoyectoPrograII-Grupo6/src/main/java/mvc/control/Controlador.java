package mvc.control;

import mvc.json.JsonManager;
import mvc.modelo.*;
import mvc.view.PrincipalView;
import mvc.modelo.Curso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.google.gson.reflect.TypeToken;

import static java.lang.Character.getType;

public class Controlador {
    private ArrayList<Universidad> varListaUnis;
    private ArrayList<Escuela> varListaEscuelas;
    private ArrayList<Curso> varListaCursos;
    private ArrayList<Profesor> varListaProfesores;
    private ArrayList<EstudianteNacional> estudiantesNacionalesDeLaUniversidad;
    private ArrayList<EstudianteExtranjero> estudiantesExtranjerosDeLaUniversidad;
    private EstudianteNacional estNaCambiarNacionalidad;
    private EstudianteExtranjero estExCambiarNacionalidad;
    private ArrayList<Grupo> varListaGrupos;
    private PrincipalView varPrincipal;

    //Constructor del controlador
    public Controlador(PrincipalView pVista) {
//       Type tipo = new TypeToken<ArrayList<Universidad>>(){}.getType();
//        varListaUnis = JsonManager.cargar("universidades.json", tipo);

//        this.varListaUnis = new ArrayList<>();
//        this.varListaEscuelas = new ArrayList<>();
//        this.varListaCursos = new ArrayList<>();
//        this.varListaProfesores = new ArrayList<>();
//        this.estudiantesNacionalesDeLaUniversidad = new ArrayList<>();
//        this.estudiantesExtranjerosDeLaUniversidad = new ArrayList<>();
//        this.varListaGrupos = new ArrayList<>();
        this.varPrincipal = pVista;
        Type tipo = new TypeToken<ArrayList<Universidad>>(){}.getType();
        this.varListaUnis = JsonManager.cargar("universidades.json", tipo);
        if (varListaUnis == null) {
            varListaUnis = new ArrayList<>();
        }
        agregarControlador();
    }

    // Action listeners
    public void agregarControlador() {
        actionListenerAgregarUnis();
        actionListenerModificarUnis();
        actionListenerAgregarEscuela();
        actionListenerConsultarEscuelas();
        actionListenerAgregarCursos();
        actionListenerMostrarCurso();
        actionListenerMostrarCursos();
        actionListenerModificarCurso();
        actionListenerEliminarCurso();
        actionListenerAgregarGrupoACurso();
        actionListenerIrGestionarProfesores();
        actionListenerGestionarProfesor();
        actionListenerModificarProfesor();
        actionListenerMostrarProfesor();
        actionListenerAsiganarProfeCurso();
        actionListenerlistaCursosAsignadosProfesor();
        actionListerListaProfesDeUnaEscuela();
        actionListenerVolverDesdeConsultaGeneral();
        actionListenerIrConsultaGeneral();
        actionListenerConsultaGeneralP();
        actionListenerGestionarEstudiantes();
        actionListenerAgregarEstudiante();
        actionListenerMostrarInformacionEstudiante();
        actionListenerModificarInformacionEstudiante();
        actionListenerMatricularEstudiante();
        actionListenerIrAConsultaGeneralEstudiantil();
        actionListenerVolverAGestionarEstudiantes();
        actionListenerCalculoAranceles();
        actionListenerConsultaGeneralEstudiantil();
    }

    // Metodo para los action listener del formulario para agregar universidades
    public void actionListenerAgregarUnis() {
        //Metodo para agregar una nueva universidad
        this.varPrincipal.btnAgregar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        addU();
                    }
                });

        //Cambia al panel de modificar la universidad
        this.varPrincipal.btnCambiar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "modoficarU");
                        limpiarCamposAgregarUni();
                    }
                });

        // Cambia al panel de agregar escuelas
        this.varPrincipal.btnIrE.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "escuelas");
                        limpiarCamposAgregarUni();
                    }
                });

        // Cambia al panel de agregar cursos
        this.varPrincipal.btnAgregarCursos.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarCursos");
                        limpiarCamposAgregarUni();
                    }
                });

        // Cambia al panel de aregar un grupo nuevo a un curso
        this.varPrincipal.btnIrAgregarGrupoACurso.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarGrupoACurso");
                        limpiarCamposAgregarUni();
                    }
                });

        // Cambia al panel para seleccionar qué hacer con respecto a los profesores
        this.varPrincipal.btnIrGestionarProfesores.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarProfesores");
                    }
                });

        this.varPrincipal.btnGestionarEstudiantes.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor,"gestionarEstudiantes");
                    }
                });
    }

    // Metodo para los action listener del formulario para modificar universidades
    public void actionListenerModificarUnis() {
        // Metodo para validar el nombre de la universidad
        this.varPrincipal.btnBuscarNombreU.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        validarNameModificarU(varPrincipal.txtName2.getText());
                    }
                });

        // Metodo para modificar la direccion y el numero telefonico de la universidad
        this.varPrincipal.btnModificar2.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        modificarUni(varPrincipal.txtName2.getText());
                    }
                });

        // Vuelve al panel de agregar universidad
        this.varPrincipal.btnVolver.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });
    }

    // Metodo para los action listener del formulario para agregar una nueva escuela
    public void actionListenerAgregarEscuela() {
        // Mï¿½todo para validar el nombre de la universidad
        this.varPrincipal.btnEscuelaBuscarUni.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        validarNameAgregarEscuela(varPrincipal.txtNameEscuelaUniBuscar.getText());
                    }
                });


        // Mï¿½todo para agregar una nueva escuela a una universidad
        this.varPrincipal.btnAgregarEscuela.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        agregarEscuela(varPrincipal.txtNameEscuelaUniBuscar.getText(), varPrincipal.txtNameEscuela.getText());
                    }
                });

        // Cambia al panel de agregar universidad
        this.varPrincipal.btnCambiar2.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });

        // Cambia al manel de consultar la lista de escuelas de una universidad
        this.varPrincipal.btnConsultarE.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "consultaE");
                    }
                });

        // Vuelve al panel de agregar universidad
        this.varPrincipal.btnCambiar2.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });
    }

    // Metodo para los action listener del formulario para consultar escuelas
    public void actionListenerConsultarEscuelas() {
        // Mï¿½todo para validar el nombre de la universidad
        this.varPrincipal.btnBuscarNombreUniE.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        validarConsultarEscuelas(varPrincipal.txtNameUniConsultarE.getText());
                    }
                });

        // Cambia al panel de agregar escuelas
        this.varPrincipal.btnVolverAgregarEscuela.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "escuelas");
                    }
                });

        // Cambia al panel de agregar universidad
        this.varPrincipal.btnCambiar3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });

    }

    // Metodo para los action listener del formulario para agregar un curso nuevo
    public void actionListenerAgregarCursos() {
        // Mï¿½todo para validar el nombre del curso
        this.varPrincipal.btnBuscarUniRegistrarCurso.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        validarNombreUniAgregarCurso(varPrincipal.txtBuscarUniRegistrarCurso.getText());
                    }
                });

        // Llama al mï¿½todo para volver a buscar una universidad a la cual aï¿½adir nuevos cursos
        this.varPrincipal.btnBuscarNuevaUni.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        buscarOtraUni();
                    }
                });

        // Llama al mï¿½todo para agregar un nuevo curso en una escuela
        this.varPrincipal.btnRegistrarCurso.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        agregarCurso(varPrincipal.txtSiglaCursoAgregar.getText(),varPrincipal.txtNombreCursoAgregar.getText(),(String) varPrincipal.cbEscuelasRegistrarCurso.getSelectedItem());
                    }
                });

        // Cambia al panel de agregar universidad
        this.varPrincipal.btnCambiar4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });

        // Acï¿½ va el cambio hacia el panel de modificar un curso
        this.varPrincipal.btnModificarCurso.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "modificarCurso");
                    }
                });

        // Aca va el cambio hacia el panel de mostrar cursos
        this.varPrincipal.btnConsultarCurso.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "mostrarCursos");
                    }
                });

        // Acï¿½ va el cambio hacia el panel de eliminar un curso
        this.varPrincipal.btnIrEliminarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "eliminarCurso");
            }
        });

        this.varPrincipal.btnverLisCursos.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor,"cursos");
                        // TODO Auto-generated method stub

                    }
                });
    }

    // Metodo para los action listener del formulario para mostrar la informaciï¿½n de un curso
    public void actionListenerMostrarCurso() {
        //Llama al metodo para buscar el curso y mostrar su informaciï¿½n
        this.varPrincipal.btnBuscarCursoPorSigla.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        encontrarMostrarCursoPorSigla(varPrincipal.txtBuscarCursoPorSigla.getText());
                    }
                });

        // Cambia al panel de agregar curso
        this.varPrincipal.btnVolverAgregarCursos.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarCursos");
                        limpiarCamposMostrarCurso();
                    }
                });
    }

    public void actionListenerMostrarCursos() {
        this.varPrincipal.btnBuscarCursoEscuela.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        // TODO Auto-generated method stub
                        varPrincipal.cbCursoEscuela.removeAllItems();
                        mostrarListCursosDeEscuela(varPrincipal.txtBuscarCursoEscuela.getText());

                    }
                });
        this.varPrincipal.btnTodosCurso.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        mostrarListaDeCursosU(varPrincipal.txtBuscarListaUE.getText());
                    }
                });

        //cambia a panel univverdad

        this.varPrincipal.btnVolUni.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });
    }

    public void actionListenerModificarCurso() {
        //accion del boton de buscar la sigla
        varPrincipal.btnBuscarSiglaCurso.addActionListener(
                new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent p) {
                        validarCursoParaModificar(varPrincipal.txtModBCursoPorSigla.getText());
                    }
                });

        //accion del boton de modificar el nombre y la sigla
        varPrincipal.btnModCursoP.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent p) {
                        modificarCursoExistente(varPrincipal.txtModBCursoPorSigla.getText(), varPrincipal.txtNuevoNombreCurso.getText());
                    }

                });

        varPrincipal.btnVolverACursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor,"agregarCursos");
                varPrincipal.btnBuscarUniRegistrarCurso.setEnabled(true);
                varPrincipal.txtBuscarUniRegistrarCurso.setEditable(true);
                varPrincipal.btnBuscarNuevaUni.setEnabled(false);
                varPrincipal.btnRegistrarCurso.setEnabled(false);
                varPrincipal.cbEscuelasRegistrarCurso.removeAllItems();
                limpiarCamposAgregarCurso();
            }
        });
    }

    public void actionListenerEliminarCurso() {
        varPrincipal.btnEliminarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sigla = varPrincipal.txtEliminarCursoPorSigla.getText().trim();

                if (sigla.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una sigla para eliminar el curso.");
                    return;
                }
                eliminarCursoPorSigla(sigla);
            }
        });

        varPrincipal.btnVolverAlCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarCursos");
            }
        });
    }

    public void actionListenerAgregarGrupoACurso(){
        this.varPrincipal.btnBuscarUniAgregarGrupo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        buscarUniAgregarGrupo(varPrincipal.txtBuscarUniAgregarGrupo.getText());
                    }
                });

        this.varPrincipal.btnVolverAgregarUniDesdeAgregarGrupo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });

        varPrincipal.cbEscuelasAgregarGrupo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String escuelaSeleccionada = (String) varPrincipal.cbEscuelasAgregarGrupo.getSelectedItem();

                    if(!escuelaSeleccionada.equals("Seleccione una de las escuelas de la universidad")){
                        Universidad u = buscarUniversidadConNombre(varPrincipal.txtBuscarUniAgregarGrupo.getText());
                        if(u != null) {
                            Escuela escuelaEncontrada = null;
                            for(Escuela es : u.getEscuelas()){
                                if(es.getVarSchoolName().equalsIgnoreCase(escuelaSeleccionada)){
                                    escuelaEncontrada = es;
                                    break;
                                }
                            }

                            if(escuelaEncontrada != null){
                                varListaCursos = escuelaEncontrada.getCursos();
                                if(varListaCursos.isEmpty()){
                                    JOptionPane.showMessageDialog(null, "No hay cursos en la escuela para agregar grupo...");
                                    varPrincipal.cbEscuelasAgregarGrupo.setSelectedIndex(0);
                                    return;
                                }

                                varPrincipal.cbCursosAgregarGrupo.removeAllItems();
                                for(Curso c : varListaCursos){
                                    varPrincipal.cbCursosAgregarGrupo.addItem(c.getNombre());
                                }
                                return;
                            } else{
                                return;
                            }
                        }else{
                            return;
                        }
                    } else{
                        varPrincipal.cbCursosAgregarGrupo.removeAllItems();
                        varPrincipal.cbCursosAgregarGrupo.addItem("Cursos de la escuela");
                        return;
                    }
                }
            }
        });

        this.varPrincipal.btnAgregarGrupoACurso.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        agregarGrupoACurso((String) varPrincipal.cbEscuelasAgregarGrupo.getSelectedItem(),
                                (String) varPrincipal.cbCursosAgregarGrupo.getSelectedItem(), varPrincipal.txtSiglaGrupoAgregarGrupo.getText());
                    }
                });
    }

    public void actionListenerIrGestionarProfesores(){
        this.varPrincipal.btnVolverAgregarUniDesdeGestionarProfesores.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
                    }
                });

        this.varPrincipal.btnGestionarProfesores.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarProfesor");
                    }
                });
    }

    public void actionListenerGestionarProfesor(){
        this.varPrincipal.btnVolverGestionarProfesores1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarProfesores");
                    }
                });

        this.varPrincipal.btnBuscarUniProfesores.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        validarEscuelaAgregarProfesor(varPrincipal.txtBuscarUniAgregarProfesor.getText());
                    }
                });

        this.varPrincipal.btnAgregarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        agregarProfesor((String) varPrincipal.cbEscuelasAgregarProfesor.getSelectedItem(), varPrincipal.txtBuscarUniAgregarProfesor.getText(), varPrincipal.txtNumeroCedulaProfesor.getText(), varPrincipal.txtNombreProfesor.getText(), varPrincipal.txtApellido1Profesor.getText(), varPrincipal.txtApellido2Profesor.getText());
                    }
                });

        this.varPrincipal.btnModificarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "modificarProfesor");
                    }
                });

        this.varPrincipal.btnConsultarInformacionProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "mostrarProfesor");
                    }
                });



        this.varPrincipal.btnGestionCursosProfesores.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "asiganarProfeCurso");
                    }
                }
        );
    }

    //accion del boton para ir a la consulta general
    public void actionListenerIrConsultaGeneral(){
        this.varPrincipal.btnIrConsultaGeneral.addActionListener(
                e -> varPrincipal.layout.show(varPrincipal.panelContenedor, "consultaGeneralProfes")
        );
    }

    //accion del boton de volver al panel de gestionar profesores
    public void actionListenerVolverDesdeConsultaGeneral(){
        this.varPrincipal.btnVolverAPanelUni.addActionListener(e -> varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarProfesores"));
    }

    //action listener para la consulta general de los profesores
    public void actionListenerConsultaGeneralP() {
        this.varPrincipal.btnConsultaGeneralProfes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.jtaMostrarConsultaGeneralProfes.setText("");
                int op = varPrincipal.cbConsultaGeneralProfes.getSelectedIndex();
                String resultado = "";

                switch (op) {
                    case 0:
                        String varSiglaCurso = JOptionPane.showInputDialog("Ingrese la sigla del curso: ");
                        resultado = obtenerListaProfesoresPorCurso(varSiglaCurso, varListaGrupos, varListaProfesores);
                        break;
                    case 1:
                        resultado = obtenerListaCursoConProfesor(varListaGrupos, varListaCursos);
                        break;
                    case 2:
                        resultado = obtenerListaEscuelasCursoYProfesores(varListaEscuelas, varListaGrupos, varListaCursos);
                        break;
                }

                varPrincipal.jtaMostrarConsultaGeneralProfes.setText(resultado);
            }
        });
    }

    public void actionListenerModificarProfesor(){
        this.varPrincipal.btnBuscarUniModificarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        validarNombreUniModificarProfe(varPrincipal.txtBuscarUniModificarProfe.getText());
                    }
                });

        this.varPrincipal.btnVolverAgregarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarProfesor");
                    }
                });

        this.varPrincipal.btnBuscarProfeConCedulaModificarProfe.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        encontrarProfesorConCedulaModificarProfesor(varPrincipal.txtBuscarUniModificarProfe.getText() ,varPrincipal.txtEscribirCedulaModificarProfe.getText());
                    }
                });

        this.varPrincipal.btnModificarInformacionProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        modificarProfesor(varPrincipal.txtNombreProfeModificarProfe.getText(), varPrincipal.txtApellido1ProfeModificarProfe.getText(), varPrincipal.txtApellido2ProfeModificarProfe.getText());
                    }
                });
    }

    public void actionListenerMostrarProfesor(){
        this.varPrincipal.btnVolverAgregarProfesorDesdeMostrarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarProfesor");
                    }
                });

        this.varPrincipal.btnBuscarUniMostrarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        validarUniMostrarInformacionProfesor(varPrincipal.txtBuscarUniMostrarProfesor.getText());
                    }
                });

        this.varPrincipal.btnBuscarProfesorMostrarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        encontrarProfeConCedulaMostrarInfoProfe(varPrincipal.txtBuscarUniMostrarProfesor.getText(), varPrincipal.txtBuscarProfesorMostrarProfesor.getText());
                    }
                });

        this.varPrincipal.btnBuscarOtraUniMostrarProfesor.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        buscarProfeEnOtraUniMostrarInfoProfe();
                    }
                });
    }
    public void actionListerListaProfesDeUnaEscuela(){
        this.varPrincipal.btnIrListaProfesDeUnaEscuela.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent p) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "listaProfesDeUnaEscuela");

                    }
                }
        );

        this.varPrincipal.btnBuscarUListaProfesDeUnaEscuela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1){
                mostrarListEscuela(varPrincipal.txtListaProfesDeUnaEscuela.getText());
            }
        });
        this.varPrincipal.btnMostrarListaProfesDeUnaEscuela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2){
                Escuela escuelaSeleccionada = (Escuela) varPrincipal.cbListaEscuelas.getSelectedItem();

                if (escuelaSeleccionada == null) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una escuela.");
                    return;
                }

                boolean resultado = mostrarListProfeEscuela(escuelaSeleccionada);
                if (!resultado) {
                    JOptionPane.showMessageDialog(null, "No se encontraron profesores en esta escuela.");
                }
            }
        });
        this.varPrincipal.btnVolverListaProfesDeUnaEscuela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e3){
                varPrincipal.layout.show(varPrincipal.panelContenedor, "asiganarProfeCurso");
            }
        });
    }

    public void actionListenerAsiganarProfeCurso(){
        this.varPrincipal.btnBuscarUniverdad.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarListaProfes(varPrincipal.txtBuscarUniversidad.getText());
                    }

                }

        );
        this.varPrincipal.btnVolverr.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarProfesores");
                    }
                }
        );

        this.varPrincipal.cbListaProfes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Profesor profesorSeleccionado = (Profesor) varPrincipal.cbListaProfes.getSelectedItem();
                    if (profesorSeleccionado != null) {
                        mostrarListCursosProfesorPorEscuela(profesorSeleccionado);
                    }
                }
            }
        });

        this.varPrincipal.cbListaCursos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Curso cursoSeleccionado = (Curso) varPrincipal.cbListaCursos.getSelectedItem();
                    if (cursoSeleccionado != null) {
                        mostrarListaGruposPorCurso(cursoSeleccionado);
                    }
                }
            }
        });

        this.varPrincipal.btnAsignarProfeCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asignarProfesorAUnCurso();
            }
        });
        this.varPrincipal.btnDesasignarProfeCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desasingarCursoProfesor();
            }
        });
        this.varPrincipal.btnIrListaCurososAsigandosProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "listaCursosAsignadosProfesor");
            }
        }); // Hola, soy Salchichon
    }
    public void actionListenerlistaCursosAsignadosProfesor(){
        this.varPrincipal.btnBuscarUniversidadListaCursosAsignadosProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mostrarListaProfes2(varPrincipal.txtBucarUniversidadListaCursosAsignadosProfesor.getText());
            }
        });

        this.varPrincipal.cbListaProfes2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Profesor profesorSeleccionado = (Profesor) varPrincipal.cbListaProfes2.getSelectedItem();
                    if (profesorSeleccionado != null) {
                        // mostrarListCursosAsignadosProfesor(,profesorSeleccionado);
                    }
                }
            }
        });

        this.varPrincipal.btnMostrarListaCursosAsignadosProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUniversidad = varPrincipal.txtBucarUniversidadListaCursosAsignadosProfesor.getText();
                Profesor profesorSeleccionado = (Profesor) varPrincipal.cbListaProfes2.getSelectedItem();

                if (profesorSeleccionado == null) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un profesor.");
                    return;
                }
                limparCamposMostrarListProfesorCursos();
                int idProfesor = profesorSeleccionado.getNumeroCedula();
                mostrarListCursosAsignadosProfesor(buscarUniversidadPorNombre(varPrincipal.txtBucarUniversidadListaCursosAsignadosProfesor.getText()), Integer.toString(idProfesor));
                //limparCamposMostrarListProfesorCursos();
            }
        });
        varPrincipal.btnVolverUniversidadListaCursosAsignadosProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarProfesores");
            }
        });
    }

    public void actionListenerGestionarEstudiantes(){
        varPrincipal.btnVolverAgregarUniDesdeGestionarEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "universidad");
            }
        });

        varPrincipal.btnIrAgregarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "agregarEstudiantes");
            }
        });

        varPrincipal.btnIrMostrarInformacionEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "mostrarEstudiantes");
            }
        });

        this.varPrincipal.btnIrModificarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1){
                varPrincipal.layout.show(varPrincipal.panelContenedor, "modificarEstudiantes");
            }
        });

        this.varPrincipal.btnMatriculaIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1){
                varPrincipal.layout.show(varPrincipal.panelContenedor, "matricularEstudiante");
            }
        });
    }

    public void actionListenerAgregarEstudiante(){
        varPrincipal.btnVolverGestionarEstudiantesDesdeAgregarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarEstudiantes");
            }
        });

        varPrincipal.btnBuscarUniAgregarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUniAgregarEstudiante(varPrincipal.txtBuscarUniAgregarEstudiante.getText());
            }
        });

        varPrincipal.btnAgregarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEstudiante(varPrincipal.txtNumeroCedulaEstudiante.getText(), varPrincipal.txtNumeroCarnetEstudiante.getText(), varPrincipal.txtNombreEstudiante.getText(),
                        varPrincipal.txtApellido1Estudiante.getText(), varPrincipal.txtApellido2Estudiante.getText(), (String) varPrincipal.cbEscogerNacionalidad.getSelectedItem(), (String) varPrincipal.cbEscogerCantidadBeca.getSelectedItem());
            }
        });

        varPrincipal.cbEscogerNacionalidad.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String seleccion = (String) varPrincipal.cbEscogerNacionalidad.getSelectedItem();
                    boolean estudianteEsNacional = "Nacional".equals(seleccion);

                    varPrincipal.cbEscogerCantidadBeca.setEnabled(estudianteEsNacional);
                    if(!estudianteEsNacional){
                        varPrincipal.cbEscogerCantidadBeca.setSelectedIndex(0);
                    }
                }
            }
        });
        this.varPrincipal.btnArancelesIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "calculoAranceles");
            }
        });
    }

    public void actionListenerMostrarInformacionEstudiante(){
        varPrincipal.btnVolverGestionarEstudiantesDesdeMostraInforEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarEstudiantes");
            }
        });

        varPrincipal.btnBuscarUniMostrarInfoEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUniMostrarEstudiante(varPrincipal.txtBuscarUniMostrarInfoEstudiante.getText());
            }
        });

        varPrincipal.btnBuscarEstConCedulaCarnetMostrarInfoEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacionEstudiante(varPrincipal.txtBuscarEstConCedulaCarnetMostrarInfoEst.getText());
            }
        });

        varPrincipal.btnBuscarOtraUniMostrarInfoEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarOtraUniMostrarInfoEstudiante();
            }
        });
    }

    public void actionListenerModificarInformacionEstudiante(){
        varPrincipal.btnBuscarUniModificarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUniModificarEstudiante(varPrincipal.txtBuscarUniModificarEstudiante.getText());
            }
        });

        varPrincipal.btnEcontrarEstudianteConCarnetCedula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEstudianteConCedulaCarnetModificarEstudiante(varPrincipal.txtBuscarEstudianteModificarEstudiante.getText());
            }
        });

        varPrincipal.btnModificarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarEstudiante(varPrincipal.txtNombreModificarEstudiante.getText(), varPrincipal.txtApellido1ModificarEstudiante.getText(),
                        varPrincipal.txtApellido2ModificarEstudiante.getText(), (String) varPrincipal.cbNacionalidadEstudianteModificarEstudiante.getSelectedItem());
            }
        });

        varPrincipal.btnVolverGestionarEstudiantesDesdeModificarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarEstudiantes");
            }
        });


    }

    public void actionListenerMatricularEstudiante(){
        varPrincipal.btnMatricularBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLisaEstudiantesYCursos(varPrincipal.txtBuscarUMatriculaEstudiante.getText());
            }

        });
        this.varPrincipal.btnMatricular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                matricularEstudiante(
                        (Estudiante) varPrincipal.cbListaEstudiantes.getSelectedItem(),
                        (Curso) varPrincipal.cbListaCursos2.getSelectedItem()
                );
            }
        });
        this.varPrincipal.btnDesMatricular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                desMatricularEstudiante(
                        (Estudiante) varPrincipal.cbListaEstudiantes.getSelectedItem(),
                        (Curso) varPrincipal.cbListaCursos2.getSelectedItem()
                );
            }
        });
        this.varPrincipal.btnMatriculaVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarEstudiantes");
            }
        });
    }

    public void actionListenerCalculoAranceles(){
        this.varPrincipal.btnArancelesMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nombreU = varPrincipal.txtCalculoArancelesBuscarU.getText().trim();
                String idEstudiante = varPrincipal.txtCalculoArancelesBuscarID.getText().trim();
                calculoAranceles(nombreU,idEstudiante);
            }
        });
        this.varPrincipal.btnAraancelesVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarEstudiantes");
            }
        });
    }

    //actionListener para la consulta general estudiantil
    public void actionListenerConsultaGeneralEstudiantil(){

        this.varPrincipal.btnConsultaGeneralEstudianteLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varPrincipal.jtaMostrarConsultaGeneralEstudiantes.setText("");

                String varOption = (String)varPrincipal.getCbConsultaGeneralEstudiantesporCurso().getSelectedItem();
                String varSiglaCurso = JOptionPane.showInputDialog(null,"Escriba la sigla del curso: ");

                if(varSiglaCurso == null || varSiglaCurso.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una sigla valida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String resultado = "";
                switch (varOption){
                    case "Estudiantes nacionales por curso" :
                        resultado = obtenerEstudiantesNacionalPorCurso(varSiglaCurso);
                        break;

                    case "Estudiantes extranjeros por curso":
                        resultado = obtenerEstudianteExtranjeroPorCurso(varSiglaCurso);
                        break;

                    case "Todos los estudiantes por curso":
                        resultado = obtenerListaCursosPorEsstudiante(varSiglaCurso);
                        break;
                }

                JOptionPane.showMessageDialog(null, resultado, "Resultado de la consulta: ",JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }


    //actions listeners para los botones de ir al panel general estudiantil y devolverse
    public void actionListenerIrAConsultaGeneralEstudiantil(){
        this.varPrincipal.btnIrConsultaGenEstudiante.addActionListener( e -> varPrincipal.layout.show(varPrincipal.panelContenedor, "consultaGeneralE"));
    }
    public void actionListenerVolverAGestionarEstudiantes(){
        this.varPrincipal.btnVolverAGestionarEstudiantes.addActionListener(e -> varPrincipal.layout.show(varPrincipal.panelContenedor, "gestionarEstudiantes"));
    }


    //buscar U
    public Universidad buscarUniversidadPorNombre(String nombreUniversidad) {
        if (nombreUniversidad.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Espacio en blanco, por favor ingrese un nombre de universidad");
            return null;
        }

        for (Universidad u : varListaUnis) {
            if (u.getVarNameU().equalsIgnoreCase(nombreUniversidad)) {
                return u;
            }
        }

        JOptionPane.showMessageDialog(null, "Universidad no encontrada.");
        return null;
    }

    // otros datos ya registrados en otro universidad ni que se dejen campos en blanco
    public void addU() {

        try {
            String nameU = this.varPrincipal.txtNameU.getText();
            String addressU = this.varPrincipal.txtAddressU.getText();
            int numberU = Integer.parseInt(this.varPrincipal.txtNumberU.getText());
            if(nameU.equalsIgnoreCase("") || addressU.equalsIgnoreCase("")) {
                throw new IllegalArgumentException("Todos los campos deben ser llenados");
            } else if(this.varPrincipal.txtNumberU.getText().length() != 8){
                throw new IllegalArgumentException("El numero de telefono debe tener exactamente 8 numeros");
            }

            for (Universidad u : varListaUnis) {
                if(u.getVarNameU().equalsIgnoreCase(nameU)||u.getVarAddresU().equalsIgnoreCase(addressU)||u.getVarNumberU() == numberU){
                    JOptionPane.showMessageDialog(null, "Error: Ya existe alguno de los datos ingresados a otra universidad.");
                    return;
                }
            }

            Universidad uni = new Universidad(nameU,addressU,numberU);
            varListaUnis.add(uni);
           JsonManager.guardar("universidades.json", varListaUnis);
            limpiarCamposAgregarUni();
            JOptionPane.showMessageDialog(null, "se agrego la Universidad de forma correcta");
            return;

        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El numero de telefono solo puede llevar numeros y no puede estar vacio");
        } catch(IllegalArgumentException p) {
            JOptionPane.showMessageDialog(null, p.getMessage());
        }
    }

    // Metodo para verificar si el nombre de la universidad a modificar existe en la lista de universidades
    public void validarNameModificarU(String  pNameU) {
        Universidad universidad = buscarUniversidadConNombre(pNameU);
        if(universidad != null) {
            JOptionPane.showMessageDialog(null, "Universidad encontrada");
            varPrincipal.btnBuscarNombreU.setEnabled(false);
            varPrincipal.txtName2.setEditable(false);
            varPrincipal.txtAddress2.setText(universidad.getVarAddresU());
            varPrincipal.txtNumber2.setText(Integer.toString(universidad.getVarNumberU()));
            varPrincipal.btnModificar2.setEnabled(true);
            return;
        }
    }

    // Metodo para modificar la direccion y el numero de telefono de la universidad
    public void modificarUni(String pNameU) {
        try {
            String addressU = this.varPrincipal.txtAddress2.getText();
            int numberU = Integer.parseInt(this.varPrincipal.txtNumber2.getText());

            if(addressU.equalsIgnoreCase("")) {
                throw new IllegalArgumentException("La direccion no puede estar vacia...");
            } else if(this.varPrincipal.txtNumber2.getText().length() != 8){
                throw new IllegalArgumentException("El numero de telefono debe tener exactamente 8 numeros");
            }

            Universidad u = buscarUniversidadConNombre(pNameU);
            u.setVarAddresU(addressU);
            u.setVarNumberU(numberU);
            JsonManager.guardar("universidades.json", varListaUnis);
            JOptionPane.showMessageDialog(null, "La direccion y el numero de telefono han sido modificados exitosamente");
            varPrincipal.btnBuscarNombreU.setEnabled(true);
            varPrincipal.txtName2.setEditable(true);
            varPrincipal.btnModificar2.setEnabled(false);
            limpiarCamposModificarUni();
            return;
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El nUmero de telefono de la universidad solo puede contener numero y no puede estar vacia");
        } catch(IllegalArgumentException p) {
            JOptionPane.showMessageDialog(null, p.getMessage());
        }
    }

    // Metodo que valida el nombre de la universidad ingresado en el panel de agregar escuela
    public void validarNameAgregarEscuela(String pNameU) {
        Universidad universidad = buscarUniversidadConNombre(pNameU);
        if(universidad != null) {
            JOptionPane.showMessageDialog(null, "Universidad encontrada");
            varPrincipal.btnBuscarNombreU.setEnabled(false);
            varPrincipal.txtNameEscuelaUniBuscar.setEditable(false);
            varPrincipal.btnEscuelaBuscarUni.setEnabled(false);
            varPrincipal.btnAgregarEscuela.setEnabled(true);
            varPrincipal.lblEscribirEscuela.setVisible(true);
            varPrincipal.txtNameEscuela.setVisible(true);
            return;
        }
    }

    // Metodo para agregar una escuela a una universidad
    public void agregarEscuela(String pNameU, String pNameE) {
        if(pNameE.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado ningun nombre de escuela...");
            return;
        }

        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null) {
            varListaEscuelas = u.getEscuelas();
            for(Escuela e : varListaEscuelas){
                if(e.getVarSchoolName().equalsIgnoreCase(pNameE)){
                    JOptionPane.showMessageDialog(null, "Esa escuela ya existe en la universidad...");
                    return;
                }
            }

            Escuela school = new Escuela(pNameE);
            u.agregarEscuela(school);
            JsonManager.guardar("universidades.json", varListaUnis);
            varPrincipal.btnBuscarNombreU.setEnabled(true);
            varPrincipal.txtNameEscuelaUniBuscar.setEditable(true);
            varPrincipal.btnEscuelaBuscarUni.setEnabled(true);
            varPrincipal.btnAgregarEscuela.setEnabled(false);
            varPrincipal.lblEscribirEscuela.setVisible(false);
            varPrincipal.txtNameEscuela.setVisible(false);
            JOptionPane.showMessageDialog(null, "La escuela ha sido agregada correctamente a la universidad " + pNameU + "!!!");
            limpiarCamposAgregarEscuela();
            return;
        } else{
            JOptionPane.showMessageDialog(null, "No existe una universidad con el nombre ingresado, vuelva a intentarlo...");
            return;
        }
    }

    // Mï¿½todo que valida y muestra los nombres de las escuelas vinculadas a una universidad
    public void validarConsultarEscuelas(String pNameU) {
        StringBuilder varEscuelas = new StringBuilder();
        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null) {
            varListaEscuelas = u.getEscuelas();
            for(Escuela school : varListaEscuelas) {
                varEscuelas.append(school.getVarSchoolName()).append("\n");
            }
            varPrincipal.jtaEscuelasEnUni.setText(varEscuelas.toString());
            return;
        }
    }

    // Mï¿½todo para buscar la universidad donde se guardarï¿½n los nuevos cursos
    public void validarNombreUniAgregarCurso(String pNameU) {
        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null) {
            varListaEscuelas = u.getEscuelas();
            if(varListaEscuelas.isEmpty() || varListaEscuelas == null){
                JOptionPane.showMessageDialog(null, "Universidad encontrada, pero no hay escuelas agregadas, agregue una escuela para poder agregar un curso...");
                return;
            }

            JOptionPane.showMessageDialog(null, "Universidad encontrada");
            varPrincipal.btnBuscarUniRegistrarCurso.setEnabled(false);
            varPrincipal.txtBuscarUniRegistrarCurso.setEditable(false);
            varPrincipal.btnBuscarNuevaUni.setEnabled(true);
            varPrincipal.btnRegistrarCurso.setEnabled(true);
            varPrincipal.cbEscuelasRegistrarCurso.removeAllItems();
            for(Escuela e : varListaEscuelas) {
                varPrincipal.cbEscuelasRegistrarCurso.addItem(e.getVarSchoolName());
            }
            return;
        }
    }
    // Metodo para buscar otra universidad en la cual agregar nuevos cursos
    public void buscarOtraUni() {
        varPrincipal.btnBuscarUniRegistrarCurso.setEnabled(true);
        varPrincipal.txtBuscarUniRegistrarCurso.setEditable(true);
        varPrincipal.btnBuscarNuevaUni.setEnabled(false);
        varPrincipal.btnRegistrarCurso.setEnabled(false);
        varPrincipal.txtBuscarUniRegistrarCurso.setText("");
        varPrincipal.txtSiglaCursoAgregar.setText("");
        varPrincipal.txtNombreCursoAgregar.setText("");
        varPrincipal.cbEscuelasRegistrarCurso.removeAllItems();
        varPrincipal.cbEscuelasRegistrarCurso.addItem("Aca se mostraran las escuelas de la universidad");
    }

    // Metodo para agregar un curso nuevo
    public void agregarCurso(String pSigla, String pNombre, String pEscuela) {
        if(pSigla.equalsIgnoreCase("") || pNombre.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado la sigla o el nombre del curso, intentelo de nuevo...");
            return;
        }

        for(Escuela e : varListaEscuelas) {
            varListaCursos = e.getCursos();
            for(Curso c : varListaCursos) {
                if(c.getNombre().equalsIgnoreCase(pNombre) || c.getSigla().equalsIgnoreCase(pSigla)) {
                    JOptionPane.showMessageDialog(null, "El nombre o la sigla ya existe en otro curso, intentelo de nuevo!");
                    return;
                }
            }
        }


        for(Escuela e : varListaEscuelas) {
            if(e.getVarSchoolName().equalsIgnoreCase(pEscuela)) {
                Curso curso = new Curso(pSigla, pNombre, pEscuela);
                e.agregarCurso(curso);
                JOptionPane.showMessageDialog(null, "Curso agregado exitosamente a la " + pEscuela);
                JsonManager.guardar("universidades.json", varListaUnis);
                varPrincipal.btnBuscarUniRegistrarCurso.setEnabled(true);
                varPrincipal.txtBuscarUniRegistrarCurso.setEditable(true);
                varPrincipal.btnBuscarNuevaUni.setEnabled(false);
                varPrincipal.btnRegistrarCurso.setEnabled(false);
                limpiarCamposAgregarCurso();
                return;
            }
        }
    }

    public void encontrarMostrarCursoPorSigla(String pSigla) {
        if(pSigla.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado ninguna sigla, intentelo de nuevo...");
            return;
        }

        for(Universidad u : varListaUnis) {
            varListaEscuelas = u.getEscuelas();
            for(Escuela e : varListaEscuelas) {
                varListaCursos = e.getCursos();
                Curso curso = e.getCursoConSigla(pSigla);
                if(curso != null) {
                    varPrincipal.txtNombreCursoM.setText(curso.getNombre());
                    varPrincipal.txtEscuelaCursoM.setText(curso.getEscuelaPertenece());
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ningun curso con esa sigla, vuelva a intentarlo...");
    }

    //muestra la lista de cursos asociados a una escuela en particular
    public void mostrarListCursosDeEscuela(String pNameE) {
        boolean find = false;

        if(pNameE.isEmpty())
            JOptionPane.showMessageDialog(null, "No se escribio nada, por favor escriba el nombre de la escuela");

        for(Escuela e: varListaEscuelas) {
            if(e.getVarSchoolName().equalsIgnoreCase(pNameE)) {
                find = true;
                JOptionPane.showMessageDialog(null, "Escuela encontrada!");
                for(Curso c: e.getCursos()) {
                    varPrincipal.cbCursoEscuela.addItem(c.getNombre());
                }
            }
        }
        if(!find){
            JOptionPane.showMessageDialog(null, "Escuela no encontrada");
            return;}
    } // Mae, en la clase Universidad hay un metodo para encontrar la escuela con
      // el nombre, para que así se ahorre el buscarla con el for

    public void mostrarListaDeCursosU(String pNameU) {
        StringBuilder texto = new StringBuilder();
        boolean find = false;
        if(pNameU.isEmpty())
            JOptionPane.showMessageDialog(null, "Sin texto porfa escriba el nombre de la escuela");

        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null){
            if(u.getEscuelas().isEmpty()){
                texto.append("No hay escuelas registradas");
            }
            texto.append("Universidad: ").append(u.getVarNameU()).append("\n");
            for(Escuela e: u.getEscuelas()) {
                if(e.getCursos().isEmpty())
                    texto.append("La escuela no tiene cursos registrados");
                texto.append("Escuelas: ").append(e.getVarSchoolName()).append("\n");
                for(Curso c: e.getCursos()) {
                    texto.append("Cursos: ").append(c.getNombre()).append("\n");
                }
            }
            texto.append("\n");
        }
        varPrincipal.jtaMostrarUYEscuela.setText(texto.toString());
        return;
    }

    // Metodos para limpiar campos

    public void validarCursoParaModificar(String sigla) {
        boolean encontrado = false;

        for (Universidad uni : varListaUnis) {
            for (Escuela esc : uni.getEscuelas()) {
                Curso curso = esc.getCursoConSigla(sigla);
                if (curso != null) {
                    varPrincipal.txtNuevoNombreCurso.setText(curso.getNombre());
                   // varPrincipal.txtNuevaSigla.setText(curso.getSigla());
                    varPrincipal.btnModCursoP.setEnabled(true);
                    encontrado = true;
                    return;
                }
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Curso no encontrado con la sigla: " + sigla);
            varPrincipal.btnModCursoP.setEnabled(false);
            varPrincipal.txtNuevoNombreCurso.setText("");
            // varPrincipal.txtNuevaSigla.setText("");
        }
    }

    public void modificarCursoExistente(String siglaAntigua, String nuevoNombre) {
        for (Universidad uni : varListaUnis) {
            for (Escuela esc : uni.getEscuelas()) {
                Curso curso = esc.getCursoConSigla(siglaAntigua);
                if (curso != null) {
                    curso.setNombre(nuevoNombre);
                    JsonManager.guardar("universidades.json", varListaUnis);
                    JOptionPane.showMessageDialog(null, "Curso modificado exitosamente.");
                    varPrincipal.btnModCursoP.setEnabled(false);
                    limpiarCamposModificadosCurso();
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Error al modificar. Curso no encontrado.");
    }

    public void eliminarCursoPorSigla(String sigla) {
        boolean eliminado = false;

        for (Universidad u : varListaUnis) {
            for (Escuela esc : u.getEscuelas()) {
                Curso curso = esc.getCursoConSigla(sigla);
                if (curso != null) {
                    esc.getCursos().remove(curso);// Aquï¿½ eliminamos el curso
                    JsonManager.guardar("cursos.json", varListaCursos);
                    JOptionPane.showMessageDialog(null, "Curso eliminado correctamente");
                    eliminado = true;
                    varPrincipal.txtEliminarCursoPorSigla.setText("");
                    return;
                }
            }
        }

        if (!eliminado) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun curso con esa sigla");
        }
    }

    public void buscarUniAgregarGrupo(String pNameU){
        Universidad u = buscarUniversidadConNombre(pNameU);

        if (u != null) {
            varListaEscuelas = u.getEscuelas();
            if(varListaEscuelas.isEmpty() || varListaEscuelas == null){
                JOptionPane.showMessageDialog(null, "La universidad no tiene escuelas registradas, agregue una escuela para poder agregar un grupo...");
                return;
            }
            varPrincipal.cbEscuelasAgregarGrupo.removeAllItems();
            varPrincipal.cbEscuelasAgregarGrupo.addItem("Seleccione una de las escuelas de la universidad");
            for(Escuela e : varListaEscuelas) {
                varPrincipal.cbEscuelasAgregarGrupo.addItem(e.getVarSchoolName());
            }
            JOptionPane.showMessageDialog(null, "Escuelas agregadas!");
            varPrincipal.txtBuscarUniAgregarGrupo.setEditable(false);
            varPrincipal.btnBuscarUniAgregarGrupo.setEnabled(false);
            varPrincipal.txtSiglaGrupoAgregarGrupo.setEditable(true);
            varPrincipal.btnAgregarGrupoACurso.setEnabled(true);
            varPrincipal.cbEscuelasAgregarGrupo.setEnabled(true);
            varPrincipal.cbCursosAgregarGrupo.setEnabled(true);
            return;
        }
    }

    public void agregarGrupoACurso(String pNombreEscuela, String pNombreCurso, String pSiglaGrupo) {
        if (pNombreEscuela.equalsIgnoreCase("Seleccione una de las escuelas de la universidad") || pNombreCurso.equalsIgnoreCase("Cursos de la escuela") || pSiglaGrupo.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado ningun nombre de escuela, curso o sigla del grupo, intentelo de nuevo...");
            return;
        }

        Universidad u = buscarUniversidadConNombre(varPrincipal.txtBuscarUniAgregarGrupo.getText());
        if (u == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la universidad.");
            return;
        }

        Escuela e = u.getEscuelaConNombre(pNombreEscuela);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la escuela.");
            return;
        }

        Curso c = e.getCursoConNombre(pNombreCurso);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el curso.");
            return;
        }

        for (Grupo g : c.getGruposDelCurso()){
            if(g.getSiglaGrupo().equals(pSiglaGrupo)){
                JOptionPane.showMessageDialog(null, "Ese grupo ya pertenece existe en el curso seleccionado...");
                return;
            }
        }
        Grupo grupo = new Grupo(pSiglaGrupo, c.getSigla(), 0);
        c.agregarGrupo(grupo);
        JsonManager.guardar("universidades.json", varListaUnis);
        JOptionPane.showMessageDialog(null, "Grupo con sigla " + pSiglaGrupo + " fue agregado exitosamente al curso " + pNombreCurso);
        varPrincipal.txtBuscarUniAgregarGrupo.setEditable(true);
        varPrincipal.txtBuscarUniAgregarGrupo.setText("");
        varPrincipal.btnBuscarUniAgregarGrupo.setEnabled(true);
        varPrincipal.cbEscuelasAgregarGrupo.removeAllItems();
        varPrincipal.cbEscuelasAgregarGrupo.setEnabled(false);
        varPrincipal.cbCursosAgregarGrupo.removeAllItems();
        varPrincipal.cbCursosAgregarGrupo.setEnabled(false);
        varPrincipal.txtSiglaGrupoAgregarGrupo.setEditable(false);
        varPrincipal.txtSiglaGrupoAgregarGrupo.setText("");
        varPrincipal.btnAgregarGrupoACurso.setEnabled(false);
        return;
    }
    public Curso buscarCursoPorSigla(String sigla, ArrayList<Curso> listaCursos) {
        for (Curso c : listaCursos) {
            if (c.getSigla().equalsIgnoreCase(sigla)) {
                return c;
            }
        }
        return null;
    }
    public void validarEscuelaAgregarProfesor(String pNombreUni){
        Universidad u = buscarUniversidadConNombre(pNombreUni);
        if(u != null){
            varListaEscuelas = u.getEscuelas();
            if(varListaEscuelas.isEmpty() || varListaEscuelas == null){
                JOptionPane.showMessageDialog(null, "Universidad encontrada pero no hay escuelas agregadas, agregue una escuela para poder agregar un profesor...");
                return;
            }

            JOptionPane.showMessageDialog(null, "Universidad encontrada exitosamente...");
            varPrincipal.txtNumeroCedulaProfesor.setEnabled(true);
            varPrincipal.txtNombreProfesor.setEnabled(true);
            varPrincipal.txtApellido1Profesor.setEnabled(true);
            varPrincipal.txtApellido2Profesor.setEnabled(true);
            varPrincipal.txtBuscarUniAgregarProfesor.setEnabled(false);
            varPrincipal.btnBuscarUniProfesores.setEnabled(false);
            varPrincipal.jrbDirector.setEnabled(true);
            varPrincipal.btnAgregarProfesor.setEnabled(true);
            varPrincipal.cbEscuelasAgregarProfesor.removeAllItems();
            for(Escuela e : varListaEscuelas){
                varPrincipal.cbEscuelasAgregarProfesor.addItem(e.getVarSchoolName());
            }
            return;
        }
    }

    public void agregarProfesor(String pEscuela, String pUni, String pNumCed, String pNombreProfesor, String pApellido1, String pApellido2) {
        try {
            if (pNumCed.equalsIgnoreCase("") || pNombreProfesor.equalsIgnoreCase("") ||
                    pApellido1.equalsIgnoreCase("") || pApellido2.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Alguno de los campos está vacío. Por favor, llénelos todos e inténtelo de nuevo...");
                return;
            } else if (pNumCed.length() != 9) {
                JOptionPane.showMessageDialog(null, "El número de cédula debe tener exactamente 9 dígitos...");
                return;
            }

            int numCedula = Integer.parseInt(pNumCed);

            Universidad u = buscarUniversidadConNombre(pUni);
            Escuela esc = u.encontrarEscuelaConNombre(pEscuela);
            varListaProfesores = esc.getProfesores();

            boolean varDirector = varPrincipal.jrbDirector.isSelected();

            // Validar si ya hay un director en la escuela
            if (varDirector) {
                for (Profesor p : varListaProfesores) {
                    if (p.getDirector()) {
                        JOptionPane.showMessageDialog(null, "Ya hay un profesor como director en esa escuela. No puede haber más de 1 director por escuela...");
                        return;
                    }
                }
            }

            // Validar si el profesor ya está asignado a una escuela
            for (Escuela e : u.getEscuelas()) {
                for (Profesor p : e.getProfesores()) {
                    if (p.getNumeroCedula() == numCedula) {
                        if (p.obtenerEscuelaPertenece() != null && !p.obtenerEscuelaPertenece().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Este profesor ya pertenece a una escuela. Solo puede pertenecer a una.");
                            return;
                        }
                    }
                }
            }

            // Crear profesor usando solo el nombre de la escuela como string
            Profesor profesor = new Profesor(numCedula, pNombreProfesor, pApellido1, pApellido2, varDirector, pEscuela);
            esc.agregarProfesor(profesor);
            JsonManager.guardar("universidades.json", varListaUnis);

            JOptionPane.showMessageDialog(null, "Profesor agregado exitosamente a la " + pEscuela);
            varPrincipal.txtNumeroCedulaProfesor.setEnabled(false);
            varPrincipal.txtNombreProfesor.setEnabled(false);
            varPrincipal.txtApellido1Profesor.setEnabled(false);
            varPrincipal.txtApellido2Profesor.setEnabled(false);
            varPrincipal.txtBuscarUniAgregarProfesor.setEnabled(true);
            varPrincipal.btnBuscarUniProfesores.setEnabled(true);
            varPrincipal.jrbDirector.setEnabled(false);
            varPrincipal.btnAgregarProfesor.setEnabled(false);
            varPrincipal.cbEscuelasAgregarProfesor.removeAllItems();
            varPrincipal.cbEscuelasAgregarProfesor.addItem("Acá se mostrarán las escuelas de la universidad encontrada");
            limpiarCamposAgregarProfesor();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo de cédula del profesor solo puede llevar números...");
        }
    }


    public void validarNombreUniModificarProfe(String pNameU){
        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null){
            JOptionPane.showMessageDialog(null, "Universidad encontrada exitosamente! Ya puede escribir el numero de cedula del profesor para modificar su informacion :D");
            varPrincipal.lblEscribirCedulaModificarProfe.setVisible(true);
            varPrincipal.txtEscribirCedulaModificarProfe.setVisible(true);
            varPrincipal.btnBuscarProfeConCedulaModificarProfe.setVisible(true);
            varPrincipal.lblEscribirUniModificarProfe.setVisible(false);
            varPrincipal.txtBuscarUniModificarProfe.setVisible(false);
            varPrincipal.btnBuscarUniModificarProfesor.setVisible(false);
            return;
        }
    }

    public void encontrarProfesorConCedulaModificarProfesor(String pNameU, String pCedulaProfesor){
        try{
            if(pCedulaProfesor.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "No se ha escrito ningun numero de cedula, vuelva a intentarlo...");
                return;
            }

            int cedulaProfesor = Integer.parseInt(pCedulaProfesor);

            Universidad u = buscarUniversidadConNombre(pNameU);
            varListaEscuelas = u.getEscuelas();
            if (varListaEscuelas.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay ninguna escuela existente, agrega una escuela para buscar un profesor en ella...");
                return;
            }

            for(Escuela e : varListaEscuelas){
                Profesor p = e.getProfesorConCedula(cedulaProfesor);
                if(p != null){
                    JOptionPane.showMessageDialog(null, "Profesor encontrado correctamente!!!");
                    varPrincipal.txtCedulaProfeModificarProfe.setText(Integer.toString(p.getNumeroCedula()));
                    varPrincipal.txtNombreProfeModificarProfe.setText(p.getNombre());
                    varPrincipal.txtApellido1ProfeModificarProfe.setText(p.getApellido1());
                    varPrincipal.txtApellido2ProfeModificarProfe.setText(p.getApellido2());
                    varPrincipal.txtNombreProfeModificarProfe.setEditable(true);
                    varPrincipal.txtApellido1ProfeModificarProfe.setEditable(true);
                    varPrincipal.txtApellido2ProfeModificarProfe.setEditable(true);
                    varPrincipal.btnModificarInformacionProfesor.setEnabled(true);
                    varPrincipal.txtEscribirCedulaModificarProfe.setEditable(false);
                    varPrincipal.btnBuscarProfeConCedulaModificarProfe.setEnabled(false);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No hay ningun profesor con ese numero de cedula, vuelve a intentarlo...");
            return;
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El campo de cedula del profesor solo puede llevar numeros...");
        }
    }

    public void modificarProfesor(String pNombreProfe, String pApellido1, String pApellido2){
        if(pNombreProfe.equalsIgnoreCase("") || pApellido1.equalsIgnoreCase("") || pApellido2.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Todos los espacios deben ser llenados...");
            return;
        }

        Universidad u = buscarUniversidadConNombre(varPrincipal.txtBuscarUniModificarProfe.getText());
        varListaEscuelas = u.getEscuelas();
        for(Escuela e : varListaEscuelas){
            Profesor p = e.getProfesorConCedula(Integer.parseInt(varPrincipal.txtEscribirCedulaModificarProfe.getText()));
            if (p != null){
                p.setNombre(pNombreProfe);
                p.setApellido1(pApellido1);
                p.setApellido2(pApellido2);
                JsonManager.guardar("universidades.json", varListaUnis);
                JOptionPane.showMessageDialog(null, "Profesor modificado exitosamente!!!!");
                varPrincipal.lblEscribirUniModificarProfe.setVisible(true);
                varPrincipal.txtBuscarUniModificarProfe.setVisible(true);
                varPrincipal.btnBuscarUniModificarProfesor.setVisible(true);
                varPrincipal.lblEscribirCedulaModificarProfe.setVisible(false);
                varPrincipal.txtEscribirCedulaModificarProfe.setVisible(false);
                varPrincipal.txtEscribirCedulaModificarProfe.setEditable(true);
                varPrincipal.btnBuscarProfeConCedulaModificarProfe.setVisible(false);
                varPrincipal.btnBuscarProfeConCedulaModificarProfe.setEnabled(true);
                varPrincipal.txtNombreProfeModificarProfe.setEditable(false);
                varPrincipal.txtApellido1ProfeModificarProfe.setEditable(false);
                varPrincipal.txtApellido2ProfeModificarProfe.setEditable(false);
                varPrincipal.btnModificarInformacionProfesor.setEnabled(false);
                limpiarCamposModificarProfesor();
            }
        }
    }

    public void validarUniMostrarInformacionProfesor(String pNameU){
        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null){
            if (u.getEscuelas().isEmpty()){
                JOptionPane.showMessageDialog(null, "Se encontro la universidad pero aún no hay escuelas dentro de la misma, ingrese una escuela y agregue un profesor...");
                return;
            }
            JOptionPane.showMessageDialog(null, "Universidad encontrada correctamente, ya puede escribir la cedula del profesor para mostrar su informacion!!!");
            varPrincipal.lblEscribirUniMostrarProfesor.setVisible(false);
            varPrincipal.txtBuscarUniMostrarProfesor.setVisible(false);
            varPrincipal.btnBuscarUniMostrarProfesor.setVisible(false);
            varPrincipal.lblEscribirProfesorMostrarProfesor.setVisible(true);
            varPrincipal.txtBuscarProfesorMostrarProfesor.setVisible(true);
            varPrincipal.btnBuscarProfesorMostrarProfesor.setVisible(true);
            varPrincipal.btnBuscarOtraUniMostrarProfesor.setVisible(true);
            return;
        }
    }

    public void encontrarProfeConCedulaMostrarInfoProfe(String pNameU, String pCedulaProfesor){
        try{
            if(pCedulaProfesor.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "No se ha escrito ningun numero de cedula, vuelva a intentarlo...");
                return;
            }

            int cedulaProfesor = Integer.parseInt(pCedulaProfesor);

            Universidad u = buscarUniversidadConNombre(pNameU);
            varListaEscuelas = u.getEscuelas();
            for(Escuela e : varListaEscuelas){
                Profesor p = e.getProfesorConCedula(cedulaProfesor);
                if(p != null){
                    JOptionPane.showMessageDialog(null, "Profesor encontrado correctamente!!!");
                    varPrincipal.jtaMostrarInformacionProfesor.setText(p.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No hay ningun profesor con ese numero de cedula, vuelve a intentarlo...");
            return;
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo de la cedula solo puede llevar numeros...");
        }
    }

    public void buscarProfeEnOtraUniMostrarInfoProfe(){
        varPrincipal.lblEscribirUniMostrarProfesor.setVisible(true);
        varPrincipal.txtBuscarUniMostrarProfesor.setVisible(true);
        varPrincipal.btnBuscarUniMostrarProfesor.setVisible(true);
        varPrincipal.lblEscribirProfesorMostrarProfesor.setVisible(false);
        varPrincipal.txtBuscarProfesorMostrarProfesor.setVisible(false);
        varPrincipal.btnBuscarProfesorMostrarProfesor.setVisible(false);
        varPrincipal.btnBuscarOtraUniMostrarProfesor.setVisible(false);
        limpiarCamposMostrarInfoProfe();
    }

    public Boolean mostrarListProfeEscuela(Escuela pEscuela){//falta su view
        for (Escuela e : varListaEscuelas){
            if(e.getVarSchoolName().equalsIgnoreCase(pEscuela.getVarSchoolName())){
                List<Profesor> listaProfesores = e.getProfesores();

                if (listaProfesores == null || listaProfesores.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay profesores registrados en la escuela: " + e.getVarSchoolName());
                    return false;
                }

                StringBuilder texto = new StringBuilder("Los profesores de la escuela: " + pEscuela + " son: ");
                for(Profesor p : e.getProfesores()){

                    texto.append(p.getNombre()).append(" ").append(p.getApellido1()).append(" ").append(p.getApellido2()).append("\n");
                }
                varPrincipal.jtaListaProfesDeUnaEscuela.setText(texto.toString());
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ninguna escuela con el nombre: " + pEscuela.getVarSchoolName());
        return false;
    }

    public void mostrarListEscuela(String pNameU){
        if(pNameU.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se ha escrito ningun nombre de universidad, vuelva a intentarlo...");
            return;
        }

        for(Universidad u : varListaUnis){

            if(pNameU.equalsIgnoreCase(u.getVarNameU())){
                List<Escuela> escuelas = u.getEscuelas();
                if (escuelas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La universidad: " + u.getVarNameU() + " no tiene escuelas registradas");
                    return;
                }
                varPrincipal.cbListaEscuelas.removeAllItems();
                for(Escuela e : u.getEscuelas()){
                    varPrincipal.cbListaEscuelas.addItem(e);
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay ninguna universidad con el nombre: " + pNameU);
    }
    public boolean mostrarListaProfes(String pNombreU) {
        if (pNombreU.isEmpty()) {
            JOptionPane.showMessageDialog(null, " Espacio en blanco, por favor ingrese un nombre de universidad");
            return false;
        }

        for (Universidad u : varListaUnis) {
            if (u.getVarNameU().equalsIgnoreCase(pNombreU)){
                if(u.getEscuelas()==null||u.getEscuelas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay ninguna escuela resgistrada en la universidad seleccionada");
                    return false;
                }
                varPrincipal.cbListaProfes.removeAllItems();

                for (Escuela c : u.getEscuelas()) {
                    if (c.getProfesores().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se ha ingresado ningun profesor, vuelva a intentarlo...");
                        return false;
                    }
                    for (Profesor p : c.getProfesores()) {
                        varPrincipal.cbListaProfes.addItem(p);
                    }
                }

            }
            return true;
        }
        JOptionPane.showMessageDialog(null, "Universidad no encotrada");
        return false;
    }

    public boolean mostrarListaProfes2(String pNombreU) {
        if (pNombreU.isEmpty()) {
            JOptionPane.showMessageDialog(null, " Espacio en blanco, por favor ingrese un nombre de universidad");
            return false;
        }

        for (Universidad u : varListaUnis) {
            if (u.getVarNameU().equalsIgnoreCase(pNombreU)) {
                if(u.getEscuelas()==null||u.getEscuelas().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay ninguna escuela resgistrada en la universidad seleccionada");
                    return false;
                }
                varPrincipal.cbListaProfes2.removeAllItems();

                for (Escuela c : u.getEscuelas()) {
                    if (c.getProfesores().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se ha ingresado ningun profesor, vuelva a intentarlo...");
                        return false;
                    }
                    for (Profesor p : c.getProfesores()) {
                        varPrincipal.cbListaProfes2.addItem(p);
                    }
                }

            }
            return true;
        }
        JOptionPane.showMessageDialog(null, "Universidad no encotrada");
        return false;
    }

    public void mostrarListCursosProfesorPorEscuela(Profesor p) {
        if (p == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún profesor. Por favor seleccione uno...");
            return;
        }

        varPrincipal.cbListaCursos.removeAllItems();

        for (Universidad u1 : varListaUnis) {
            if (u1.getEscuelas() == null || u1.getEscuelas().isEmpty()) {
                continue; // Mejor que cortar todo con return
            }

            for (Escuela e : u1.getEscuelas()) {
                if (e.getProfesores() != null && e.getProfesores().contains(p)) {

                    List<Curso> cursos = e.getCursos();
                    if (cursos == null || cursos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay ningún curso registrado en la escuela a la que pertenece el profesor.");
                        return;
                    }

                    for (Curso curso : cursos) {
                        if (curso != null) {
                            varPrincipal.cbListaCursos.addItem(curso);
                        }
                    }
                    return; // Ya encontramos la escuela del profesor, no seguimos buscando
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Este profesor no pertenece a ninguna escuela.");
    }
    public void mostrarListaGruposPorCurso(Curso c){
        varPrincipal.cbGruposDelCurso.removeAllItems();
        for (Universidad u1 : varListaUnis) {
            if(u1.getEscuelas()==null||u1.getEscuelas().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay ninguna escuela resgistrada en la universidad seleccionada");
                return;
            }
            for(Grupo g : c.getGruposDelCurso()){
                varPrincipal.cbGruposDelCurso.addItem(g);
            }
        }
    }

    public void asignarProfesorAUnCurso() {
        Curso cursoSeleccionado = (Curso) varPrincipal.cbListaCursos.getSelectedItem();
        Profesor profesorSeleccionado = (Profesor) varPrincipal.cbListaProfes.getSelectedItem();
        Grupo grupoSeleccionado = (Grupo) varPrincipal.cbGruposDelCurso.getSelectedItem();

        if (profesorSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun profesor por favor seleccione uno...");
            return;
        }
        if (cursoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun curso por favor seleccione uno...");
            return;
        }
        if (grupoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun grupo, por favor seleccione uno...");
            return;
        }

        for (Curso c : profesorSeleccionado.obtenerCursosImpartidos()) {
            if (c == cursoSeleccionado) {
                JOptionPane.showMessageDialog(null, "Este profesor ya imparte este curso...");
                return;
            }
        }

        // Ahora profesorPertenece es un ID (por ejemplo int cedula),
        // revisamos si tiene profesor asignado con una condición diferente:
        if (grupoSeleccionado.getProfesorPertenece() != 0) { // o null si es Integer
            JOptionPane.showMessageDialog(null, "Este grupo ya se le fue asignado a otro profesor...");
            return;
        }

        profesorSeleccionado.asignarProfesorACurso(cursoSeleccionado);

        // Guardar solo la cédula del profesor en el grupo
        grupoSeleccionado.setProfesorPertenece(profesorSeleccionado.getNumeroCedula());

        JsonManager.guardar("universidades.json", varListaUnis);

        JOptionPane.showMessageDialog(null, "Profesor asignado exitosamente al curso: " + cursoSeleccionado.getNombre() +
                ". Y grupo con sigla: " + grupoSeleccionado.getSiglaGrupo());
    }

    public void desasingarCursoProfesor(){
        Curso cursoSeleccionado = (Curso) varPrincipal.cbListaCursos.getSelectedItem();
        Profesor profesorSeleccionado = (Profesor) varPrincipal.cbListaProfes.getSelectedItem();
        Grupo grupoSeleccionado = (Grupo) varPrincipal.cbGruposDelCurso.getSelectedItem();

        if(cursoSeleccionado == null || profesorSeleccionado == null || grupoSeleccionado == null){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun profesor, curso o grupo, por favor seleccione uno...");
            return;
        }
        if (grupoSeleccionado.getProfesorPertenece() == profesorSeleccionado.getNumeroCedula()){
            profesorSeleccionado.desasignarProfesorACurso(cursoSeleccionado);
            grupoSeleccionado.setProfesorPertenece(null);
            JsonManager.guardar("universidades.json", varListaUnis);
            JOptionPane.showMessageDialog(null, "Profesor desasignado exitosamente al curso: " + cursoSeleccionado.getNombre());
            return;
        }

        JOptionPane.showMessageDialog(null, "El profesor seleccionado no imparte ese grupo, por favor seleccione un grupo que este siendo impartido por el profesor...");
        return;
    }

    public void mostrarListCursosAsignadosProfesor(Universidad pNombreU,String idProfesor) {

        if (pNombreU==null) {
            JOptionPane.showMessageDialog(null, " Espacio en blanco, por favor ingrese un nombre de universidad");
            return;
        }

        int idProfe = Integer.parseInt(idProfesor);

        for (Escuela e : pNombreU.getEscuelas()) {
            for (Profesor p : e.getProfesores()) {
                if(p.getNumeroCedula() == idProfe){
                    List<Curso> cursos = p.obtenerCursosImpartidos();
                    if(cursos.isEmpty()){
                        JOptionPane.showMessageDialog(null, "No se ha asignado ningun curso a este profesor...");
                        return;
                    }
                    StringBuilder texto = new StringBuilder("Cursos asignados al profesor " + p.getNombre() + ":\n");
                    for(Curso c : cursos){
                        texto.append("-").append(c.getNombre()).append("\n");
                    }
                    varPrincipal.jtaCursosAsignadosProfesor.append(texto.toString());

                    return;

                };
            }
        }
        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun profesor con ese numero de cedula...");
    }
    public Profesor buscarProfesorPorCedula(int cedula, ArrayList<Profesor> profesores) {
        for (Profesor p : profesores) {
            if (p.getNumeroCedula() == cedula) {
                return p;
            }
        }
        return null;
    }
    //Metodos de consulta de los profesores:


    public String obtenerListaCursoConProfesor(ArrayList<Grupo> grupos){
        StringBuilder resultado = new StringBuilder();
        for (Grupo grupo : grupos) {
            Curso curso = grupo.getCursoPertenece();
            Profesor profesor = grupo.getProfesorPertenece();
            resultado.append("Curso: ").append(curso.getNombre()).append(" (").append(curso.getSigla()).append(")\n")
                    .append("Grupo: ").append(grupo.getSiglaGrupo()).append("\n")
                    .append("Profesor: ").append(profesor.getNombre()).append(" ")
                    .append(profesor.getApellido1()).append(" ").append(profesor.getApellido2()).append("\n")
                    .append("Cédula: ").append(profesor.getNumeroCedula()).append("\n");
        }
        if (resultado.isEmpty()) {
            return "No hay cursos asignados con profesores.";
        }
        return resultado.toString();
    }

    public String obtenerListaProfesoresPorCurso(String pSiglaCurso, ArrayList<Grupo> grupos) {
        StringBuilder resultado = new StringBuilder();
        for (Grupo grupo : grupos) {
            if (grupo.getCursoPertenece().getSigla().equalsIgnoreCase(pSiglaCurso)) {
                Profesor profe = grupo.getProfesorPertenece();
                resultado.append("Grupo: ").append(grupo.getSiglaGrupo()).append("\n").append("Profesor: ").append(profe.getNombre()).append("")
                        .append(profe.getApellido1()).append(" ").append(profe.getApellido2()).append("\n");
            }
        }
        if (resultado.isEmpty()) {
            return "No hay profesores asignados a este curso...";
        }
        return resultado.toString();
    }
    //Curso con profesores/Todas las escuelas, todos los cursos y profesores de cada curso
    public String obtenerListaEscuelasCursoYProfesores(ArrayList<Escuela> escuelas, ArrayList<Grupo> grupos){

        StringBuilder resultado = new StringBuilder();
        for (Escuela escuela : escuelas) {
            resultado.append("Escuela: ").append(escuela.getVarSchoolName()).append("\n");
            for (Grupo grupo : grupos) {
                Curso curso = grupo.getCursoPertenece();
                if (curso.getEscuelaPertenece().equalsIgnoreCase(escuela.getVarSchoolName())) {
                    Profesor profesor = grupo.getProfesorPertenece();
                    resultado.append("Curso: ").append(curso.getNombre()).append(" (").append(curso.getSigla()).append(")\n")
                            .append("Grupo: ").append(grupo.getSiglaGrupo()).append("\n")
                            .append("Profesor: ").append(profesor.getNombre()).append(" ")
                            .append(profesor.getApellido1()).append(" ").append(profesor.getApellido2()).append("\n")
                            .append("Cédula: ").append(profesor.getNumeroCedula()).append("\n");
                }
            }
            resultado.append("\n");
        }

        return resultado.isEmpty() ? "No hay datos registrados para escuelas, cursos o profesores." : resultado.toString();


    }




    public void buscarUniAgregarEstudiante(String pNombreUni) {
        Universidad u = buscarUniversidadConNombre(pNombreUni);

        if (u != null) {
            JOptionPane.showMessageDialog(null, "Universidad encontrada correctamente!!!");
            varPrincipal.txtBuscarUniAgregarEstudiante.setEditable(false);
            varPrincipal.btnBuscarUniAgregarEstudiante.setEnabled(false);
            varPrincipal.txtNumeroCedulaEstudiante.setEditable(true);
            varPrincipal.txtNumeroCarnetEstudiante.setEditable(true);
            varPrincipal.txtNombreEstudiante.setEditable(true);
            varPrincipal.txtApellido1Estudiante.setEditable(true);
            varPrincipal.txtApellido2Estudiante.setEditable(true);
            varPrincipal.cbEscogerNacionalidad.setEnabled(true);
            varPrincipal.cbEscogerCantidadBeca.setEnabled(true);
            varPrincipal.btnAgregarEstudiante.setEnabled(true);
        }
    }

    public void agregarEstudiante(String pNumCed, String pNumCarnet, String pNombreEst, String pApellido1, String pApellido2, String pNacionalidad, String pCantidadBeca){
        try {
            if (pNumCed.equalsIgnoreCase("") || pNumCarnet.equalsIgnoreCase("") || pNombreEst.equalsIgnoreCase("") || pApellido1.equalsIgnoreCase("") || pApellido2.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Todos los espacios deben ser llenados...");
                return;
            } else if (pNumCed.length() != 9) {
                JOptionPane.showMessageDialog(null, "El numero de cedula debe tener exactamente 9 digitos...");
                return;
            }
            int numeroCedula = Integer.parseInt(pNumCed);
            int numeroCarnet = Integer.parseInt(pNumCarnet);
            Universidad u = buscarUniversidadConNombre(varPrincipal.txtBuscarUniAgregarEstudiante.getText());

            estudiantesNacionalesDeLaUniversidad = u.getEstudiantesNacionalesDelCurso();
            for(Estudiante e : estudiantesNacionalesDeLaUniversidad){
                if(e.getNumeroCedulaEstudiante() == numeroCedula){
                    JOptionPane.showMessageDialog(null, "El estudiante con el numero de cedula: " + numeroCedula + " ya se encuentra registrado...");
                    return;
                } else if(e.getNumeroCarnetEstudiante() == numeroCarnet){
                    JOptionPane.showMessageDialog(null, "El estudiante con el numero de carnet: " + numeroCarnet + " ya se encuentra registrado...");
                    return;
                }
            }

            estudiantesExtranjerosDeLaUniversidad = u.getEstudiantesExtranjerosDelCurso();
            for(Estudiante e : estudiantesExtranjerosDeLaUniversidad){
                if(e.getNumeroCedulaEstudiante() == numeroCedula){
                    JOptionPane.showMessageDialog(null, "El estudiante con el numero de cedula: " + numeroCedula + " ya se encuentra registrado...");
                    return;
                } else if(e.getNumeroCarnetEstudiante() == numeroCarnet){
                    JOptionPane.showMessageDialog(null, "El estudiante con el numero de carnet: " + numeroCarnet + " ya se encuentra registrado...");
                    return;
                }
            }

            if(pNacionalidad == "Nacional"){
                pCantidadBeca = pCantidadBeca.replace("%", ""); // Esto elimina el símbolo de porcentaje
                double beca = Double.parseDouble(pCantidadBeca);
                beca = (beca / 100);
                EstudianteNacional p = new EstudianteNacional(numeroCedula, numeroCarnet, pNombreEst, pApellido1, pApellido2, "Nacional", beca);
                u.agregarEstudianteNacional(p);
                JsonManager.guardar("universidades.json", varListaUnis);

                JOptionPane.showMessageDialog(null, "Estudiante nacional agregado a la " + u.getVarNameU() + "!!!");
            } else {
                EstudianteExtranjero p = new EstudianteExtranjero(numeroCedula, numeroCarnet, pNombreEst, pApellido1, pApellido2, "Extranjero");
                u.agregarEstudianteExtranjero(p);
                JsonManager.guardar("universidades.json", varListaUnis);

                JOptionPane.showMessageDialog(null, "Estudiante extranjerp agregado a la " + u.getVarNameU() + "!!!");
            }
            varPrincipal.txtBuscarUniAgregarEstudiante.setEditable(true);
            varPrincipal.btnBuscarUniAgregarEstudiante.setEnabled(true);
            varPrincipal.txtNumeroCedulaEstudiante.setEditable(false);
            varPrincipal.txtNumeroCarnetEstudiante.setEditable(false);
            varPrincipal.txtNombreEstudiante.setEditable(false);
            varPrincipal.txtApellido1Estudiante.setEditable(false);
            varPrincipal.txtApellido2Estudiante.setEditable(false);
            varPrincipal.cbEscogerNacionalidad.setEnabled(false);
            varPrincipal.cbEscogerNacionalidad.setSelectedIndex(0);
            varPrincipal.cbEscogerCantidadBeca.setEnabled(false);
            varPrincipal.cbEscogerCantidadBeca.setSelectedIndex(0);
            varPrincipal.btnAgregarEstudiante.setEnabled(false);
            limpiarCamposAgregarEstudiante();
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar letras en el campo de la cedula ni del carnet...");
        }
    }

    public void buscarUniMostrarEstudiante(String pNameU){
        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null){
            estudiantesNacionalesDeLaUniversidad = u.getEstudiantesNacionalesDelCurso();
            estudiantesExtranjerosDeLaUniversidad = u.getEstudiantesExtranjerosDelCurso();
            if(estudiantesNacionalesDeLaUniversidad.isEmpty() && estudiantesExtranjerosDeLaUniversidad.isEmpty()){
                JOptionPane.showMessageDialog(null, "Universidad encontrada, pero no hay estudiantes agregados aun, agregue un estudiante para poder mostrar su informacion...");
                return;
            }

            JOptionPane.showMessageDialog(null, "Universidad encontrada correctamente, ya puede escribir la cedula del estudiante para mostrar su informacion!!!");
            varPrincipal.lblEscribirUniMostrarInfoEstudiante.setVisible(false);
            varPrincipal.txtBuscarUniMostrarInfoEstudiante.setVisible(false);
            varPrincipal.btnBuscarUniMostrarInfoEstudiante.setVisible(false);
            varPrincipal.lblEscribirCedulaCarnetMostrarInfoEstudiante.setVisible(true);
            varPrincipal.txtBuscarEstConCedulaCarnetMostrarInfoEst.setVisible(true);
            varPrincipal.btnBuscarEstConCedulaCarnetMostrarInfoEst.setVisible(true);
            varPrincipal.btnBuscarOtraUniMostrarInfoEst.setEnabled(true);
            return;
        }
    }

    public void mostrarInformacionEstudiante(String pCedulaCarnet){
        try{
            int cedulaCarnet = Integer.parseInt(pCedulaCarnet);
            Universidad u = buscarUniversidadConNombre(varPrincipal.txtBuscarUniMostrarInfoEstudiante.getText());
            for(Estudiante e : estudiantesNacionalesDeLaUniversidad){
                if (e.getNumeroCedulaEstudiante() == cedulaCarnet || e.getNumeroCarnetEstudiante() == cedulaCarnet) {
                    JOptionPane.showMessageDialog(null, "Estudiante encontrado correctamente!!!");
                    varPrincipal.jtaMostrarInformacionEstudiante.setText(e.toString());
                    return;
                }
            }

            for(Estudiante e : estudiantesExtranjerosDeLaUniversidad){
                if (e.getNumeroCedulaEstudiante() == cedulaCarnet || e.getNumeroCarnetEstudiante() == cedulaCarnet) {
                    JOptionPane.showMessageDialog(null, "Estudiante encontrado correctamente!!!");
                    varPrincipal.jtaMostrarInformacionEstudiante.setText(e.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No hay ningun estudiante con esa cedula o carnet...");
            return;
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "El campo de la cedula o carnet solo puede llevar numeros...");
        }
    }

    public void buscarOtraUniMostrarInfoEstudiante(){
        varPrincipal.lblEscribirUniMostrarInfoEstudiante.setVisible(true);
        varPrincipal.txtBuscarUniMostrarInfoEstudiante.setVisible(true);
        varPrincipal.btnBuscarUniMostrarInfoEstudiante.setVisible(true);
        varPrincipal.lblEscribirCedulaCarnetMostrarInfoEstudiante.setVisible(false);
        varPrincipal.txtBuscarEstConCedulaCarnetMostrarInfoEst.setVisible(false);
        varPrincipal.btnBuscarEstConCedulaCarnetMostrarInfoEst.setVisible(false);
        varPrincipal.btnBuscarOtraUniMostrarInfoEst.setEnabled(false);
        limpiarCamposMostrarInfoEstudiante();
        return;
    }

    public void buscarUniModificarEstudiante(String pNameU){
        Universidad u = buscarUniversidadConNombre(pNameU);
        if(u != null){
            JOptionPane.showMessageDialog(null, "Universidad encontrada correctamente, ya puede escribir la cedula del estudiante para modificar su informacion!!");
            varPrincipal.txtBuscarUniModificarEstudiante.setEditable(false);
            varPrincipal.btnBuscarUniModificarEstudiante.setEnabled(false);
            varPrincipal.txtBuscarEstudianteModificarEstudiante.setEditable(true);
            varPrincipal.btnEcontrarEstudianteConCarnetCedula.setEnabled(true);
        }
    }

    public void buscarEstudianteConCedulaCarnetModificarEstudiante(String pCedulaCarnet){
        try {
            Universidad u = buscarUniversidadConNombre(varPrincipal.txtBuscarUniModificarEstudiante.getText());
            int cedulaCarnet = Integer.parseInt(pCedulaCarnet);

            EstudianteNacional en = u.encontrarEstudianteNacionalConCedulaCarnet(cedulaCarnet);
            if (en != null) {
                varPrincipal.txtNombreModificarEstudiante.setText(en.getNombreEstudiante());
                varPrincipal.txtApellido1ModificarEstudiante.setText(en.getApellido1Estudiante());
                varPrincipal.txtApellido2ModificarEstudiante.setText(en.getApellido2Estudiante());
                varPrincipal.txtNombreModificarEstudiante.setEditable(true);
                varPrincipal.txtApellido1ModificarEstudiante.setEditable(true);
                varPrincipal.txtApellido2ModificarEstudiante.setEditable(true);
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.setEnabled(true);
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.removeAllItems();
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.addItem(en.getNacionalidadEstudiante());
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.addItem("Extranjero");
                varPrincipal.btnModificarEstudiante.setEnabled(true);
                estNaCambiarNacionalidad = en;
                estExCambiarNacionalidad = null;
                return;
            }

            EstudianteExtranjero ee = u.encontrarEstudianteExtranjeroConCedulaCarnet(cedulaCarnet);
            if (ee != null) {
                varPrincipal.txtNombreModificarEstudiante.setText(ee.getNombreEstudiante());
                varPrincipal.txtApellido1ModificarEstudiante.setText(ee.getApellido1Estudiante());
                varPrincipal.txtApellido2ModificarEstudiante.setText(ee.getApellido2Estudiante());
                varPrincipal.txtNombreModificarEstudiante.setEditable(true);
                varPrincipal.txtApellido1ModificarEstudiante.setEditable(true);
                varPrincipal.txtApellido2ModificarEstudiante.setEditable(true);
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.setEnabled(true);
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.removeAllItems();
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.addItem(ee.getNacionalidadEstudiante());
                varPrincipal.cbNacionalidadEstudianteModificarEstudiante.addItem("Nacional");
                estExCambiarNacionalidad = ee;
                estNaCambiarNacionalidad = null;
                varPrincipal.btnModificarEstudiante.setEnabled(true);
                return;
            }
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado...");
            return;
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Solo se pueden escribir numeros en el campo del numero de cedula o carnet...");
        }
    }

    public void modificarEstudiante(String pNombre, String pApellido1, String pApellido2, String pNacionalidad){
        if(pNombre.equalsIgnoreCase("") || pApellido1.equalsIgnoreCase("") || pApellido2.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Todos los espacios deben ser llenados...");
            return;
        }

        Universidad u = buscarUniversidadConNombre(varPrincipal.txtBuscarUniModificarEstudiante.getText());
        if(estNaCambiarNacionalidad != null){
            if(varPrincipal.cbNacionalidadEstudianteModificarEstudiante.getSelectedItem().equals("Nacional")){
                estNaCambiarNacionalidad.setNombreEstudiante(varPrincipal.txtNombreModificarEstudiante.getText());
                estNaCambiarNacionalidad.setApellido1Estudiante(varPrincipal.txtApellido1ModificarEstudiante.getText());
                estNaCambiarNacionalidad.setApellido2Estudiante(varPrincipal.txtApellido2ModificarEstudiante.getText());
                modificarOtroEstudiante();
                return;
            } else{
                EstudianteExtranjero estudianteExtranjero = new EstudianteExtranjero(estNaCambiarNacionalidad.getNumeroCedulaEstudiante(),
                        estNaCambiarNacionalidad.getNumeroCarnetEstudiante(), varPrincipal.txtNombreModificarEstudiante.getText(), varPrincipal.txtApellido1ModificarEstudiante.getText(),
                        varPrincipal.txtApellido2ModificarEstudiante.getText(), "Extranjero");
                u.cambiarDeNacionalidadEstudianteNacional(estNaCambiarNacionalidad.getNumeroCedulaEstudiante());
                u.agregarEstudianteExtranjero(estudianteExtranjero);
                JsonManager.guardar("universidades.json", varListaUnis);
                JOptionPane.showMessageDialog(null, "Estudiante ahora es extranjero!!!!");
                modificarOtroEstudiante();
                return;
            }
        }

        if(estExCambiarNacionalidad != null){
            if(varPrincipal.cbNacionalidadEstudianteModificarEstudiante.getSelectedItem().equals("Extranjero")){
                estExCambiarNacionalidad.setNombreEstudiante(varPrincipal.txtNombreModificarEstudiante.getText());
                estExCambiarNacionalidad.setApellido1Estudiante(varPrincipal.txtApellido1ModificarEstudiante.getText());
                estExCambiarNacionalidad.setApellido2Estudiante(varPrincipal.txtApellido2ModificarEstudiante.getText());
                modificarOtroEstudiante();
                return;
            } else{
                EstudianteNacional estudianteNacional = new EstudianteNacional(estExCambiarNacionalidad.getNumeroCedulaEstudiante(),
                        estExCambiarNacionalidad.getNumeroCarnetEstudiante(), varPrincipal.txtNombreModificarEstudiante.getText(), varPrincipal.txtApellido1ModificarEstudiante.getText(),
                        varPrincipal.txtApellido2ModificarEstudiante.getText(), "Nacional", 0.0);
                u.cambiarDeNacionalidadEstudianteExtranjero(estExCambiarNacionalidad.getNumeroCedulaEstudiante());
                u.agregarEstudianteNacional(estudianteNacional);
                JsonManager.guardar("universidades.json", varListaUnis);
                JOptionPane.showMessageDialog(null, "Estudiante ahora es nacional!!!");
                modificarOtroEstudiante();
                return;
            }
        }
    }

    public void modificarOtroEstudiante(){
        JOptionPane.showMessageDialog(null, "Estudiante modificado correctamente!!!");
        varPrincipal.txtBuscarUniModificarEstudiante.setEditable(true);
        varPrincipal.txtBuscarUniModificarEstudiante.setText("");
        varPrincipal.btnBuscarUniModificarEstudiante.setEnabled(true);
        varPrincipal.txtBuscarEstudianteModificarEstudiante.setEditable(false);
        varPrincipal.txtBuscarEstudianteModificarEstudiante.setText("");
        varPrincipal.btnEcontrarEstudianteConCarnetCedula.setEnabled(false);
        varPrincipal.txtNombreModificarEstudiante.setEditable(false);
        varPrincipal.txtNombreModificarEstudiante.setText("");
        varPrincipal.txtApellido1ModificarEstudiante.setEditable(false);
        varPrincipal.txtApellido1ModificarEstudiante.setText("");
        varPrincipal.txtApellido2ModificarEstudiante.setEditable(false);
        varPrincipal.txtApellido2ModificarEstudiante.setText("");
        varPrincipal.cbNacionalidadEstudianteModificarEstudiante.removeAllItems();
        varPrincipal.cbNacionalidadEstudianteModificarEstudiante.setEnabled(false);
        varPrincipal.btnModificarEstudiante.setEnabled(false);
        return;
    }

    // Metodo para buscar una universidad con el nombre
    public Universidad buscarUniversidadConNombre(String pNombreU){
        if(pNombreU.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "No se ha escrito ningun nombre de universidad, vuelva a intentarlo...");
            return null;
        }

        for(Universidad u : varListaUnis){
            if (u.getVarNameU().equalsIgnoreCase(pNombreU)){
                return u;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontro ninguna universidad con el nombre ingresado...");
        return null;
    }
    public void limparCamposMostrarListProfesorCursos(){
        this.varPrincipal.jtaCursosAsignadosProfesor.setText("");
    }

    public void mostrarLisaEstudiantesYCursos(String pNombreU){

        if(pNombreU.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "No se ha escrito ningun nombre de universidad, vuelva a intentarlo...");
            return;
        }
        for(Universidad u : varListaUnis){
            if(pNombreU.equalsIgnoreCase(u.getVarNameU())){
                varPrincipal.cbListaEstudiantes.removeAllItems();
                for(EstudianteNacional u1 : u.getEstudiantesNacionalesDelCurso()){
                    varPrincipal.cbListaEstudiantes.addItem(u1);
                }
                for(EstudianteExtranjero u2 : u.getEstudiantesExtranjerosDelCurso()){
                    varPrincipal.cbListaEstudiantes.addItem(u2);
                }
                for(Escuela e : u.getEscuelas()){
                    varPrincipal.cbListaCursos2.removeAllItems();
                    for(Curso c : e.getCursos()){
                        varPrincipal.cbListaCursos2.addItem(c);
                    }

                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro ninguna universidad con el nombre ingresado...");
    }
    public boolean matricularEstudiante(Estudiante pEstudiante, Curso pCurso){
        if(pCurso == null || pEstudiante == null|| pCurso.equals("")||pEstudiante.equals("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleciona las opciones necesarias, vuelva a intentarlo...");
            return false;
        }
        pCurso.agregarEstudiante(pEstudiante);
        JsonManager.guardar("universidades.json", varListaUnis);
        JOptionPane .showMessageDialog(null, "Estudiante matriculado exitosamente a el curso: " + pCurso.getNombre() + "!!!");
        return true;
    } // Acá lol

    public boolean desMatricularEstudiante(Estudiante pEstudiante, Curso pCurso){
        if(pCurso == null || pEstudiante == null|| pCurso.equals("")||pEstudiante.equals("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleciona las opciones necesarias, vuelva a intentarlo...");
            return false;
        }
        pCurso.eliminarEstudiante(pEstudiante);
        JsonManager.guardar("universidades.json", varListaUnis);
        JOptionPane .showMessageDialog(null, "Estudiante desmatriculado exitosamente a el curso: " + pCurso.getNombre() + "!!!");
        return true;
    }
    public void calculoAranceles(String pNombreU,String IdEstudiante){

        if(pNombreU.equalsIgnoreCase("")||IdEstudiante.equalsIgnoreCase("")) {
            System.out.println("Se llamó a  con: " + pNombreU);
            JOptionPane.showMessageDialog(null, "No se ha escrito ningun nombre de universidad, vuelva a intentarlo...");
            return;
        }
        for(Universidad u : varListaUnis){
            if(pNombreU.equalsIgnoreCase(u.getVarNameU())){
                double aranceles = 0;
                for(EstudianteNacional e : u.getEstudiantesNacionalesDelCurso()){
                    if (String.valueOf(e.getNumeroCedulaEstudiante()).equals(IdEstudiante)){
                        for(Curso c: varListaCursos){
                            if(c.getEstudiantesNacionalesDelCurso().contains(e)){
                               aranceles+=e.calculoDeArancelesCurso((int) c.getCreditos());
                                JsonManager.guardar("universidades.json", varListaUnis);


                            }

                        }
                        JOptionPane.showMessageDialog(null, "El arancel del estudiante con cedula: " + e.getNumeroCedulaEstudiante() + " es: ₡" + aranceles);
                        return;
                    }
                }
                for(EstudianteExtranjero e : u.getEstudiantesExtranjerosDelCurso()){
                    if (String.valueOf(e.getNumeroCedulaEstudiante()).equals(IdEstudiante)){
                        for(Curso c: varListaCursos){
                            if(c.getEstudiantesExtranjerosDelCurso().contains(e)){
                                aranceles+=e.calculoArancelCurso((int) c.getCreditos());
                                JsonManager.guardar("universidades.json", varListaUnis);

                            }
                        }
                        JOptionPane.showMessageDialog(null, "El arancele del estudiante con cedula: " + e.getNumeroCedulaEstudiante() + " es: ₡" + aranceles);
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro ninguna universidad con el nombre ingresado o el estudiante con la cedula ingresada...");
    }

    //metodo para mostrar la lista de estudiantes nacionales por curso:
    public String obtenerEstudiantesNacionalPorCurso(String siglaCurso){
        StringBuilder sb = new StringBuilder();
        for(Universidad u : varListaUnis){
            for(Escuela esc : u.getEscuelas()){
                for(Curso c : esc.getCursos()){
                    if(c.getSigla().equalsIgnoreCase(siglaCurso)){
                        sb.append("Curso: ").append(c.getSigla()).append(" - ").append(c.getNombre()).append("\n");
                        sb.append("--- Estudiantes Nacionales ---\n");
                        for(EstudianteNacional na: c.getEstudiantesNacionalesDelCurso()){
                            sb.append(na).append("\n");
                        }
                        return sb.toString();
                    }
                }
            }
        }
        return "No se encontro la sigla del curso: "+siglaCurso;
    }

    //metodo de obtener lista de estudiantes extranjeros por curso:
    public String obtenerEstudianteExtranjeroPorCurso(String siglaCurso){
        StringBuilder sb = new StringBuilder();

        for(Universidad u : varListaUnis){
            for(Escuela esc : u.getEscuelas()){
                for(Curso c : esc.getCursos()){
                    if(c.getSigla().equalsIgnoreCase(siglaCurso)){
                        sb.append("Curso: ").append(c.getSigla()).append(" - ").append(c.getNombre()).append("\n");
                        sb.append("---Estudiantes extranjeros---\n");
                        for(EstudianteExtranjero ex : c.getEstudiantesExtranjerosDelCurso()){
                            sb.append(ex).append("\n");
                        }
                        return sb.toString();
                    }
                }
            }
        }
        return "No se encontro el curso con la sigla: "+siglaCurso;
    }

    //Metodo para obtener la lista de cursos por estudiante:

    public String obtenerListaCursosPorEsstudiante(String siglaCurso){
        StringBuilder sb = new StringBuilder();
        for(Universidad u : varListaUnis){
            for(Escuela esc : u.getEscuelas()){
                for(Curso c : esc.getCursos()){
                    if(c.getSigla().equalsIgnoreCase(siglaCurso)){
                        sb.append("Curso: ").append(c.getSigla()).append(" - ").append(c.getNombre()).append("\n");
                        sb.append("--- Estudiantes Nacionales ---\n");
                        for(EstudianteNacional na : c.getEstudiantesNacionalesDelCurso()){
                            sb.append(na).append("\n");
                        }

                        sb.append("--- Estudiantes Extranjeros ---\n");
                        for(EstudianteExtranjero ex : c.getEstudiantesExtranjerosDelCurso()){
                            sb.append(ex).append("\n");
                        }
                        return sb.toString();
                    }
                }
            }
        }
        return "No se encontro el curso con la sigla: "+siglaCurso;
    }




    public void limpiarCamposAgregarUni() {
        this.varPrincipal.txtNameU.setText("");
        this.varPrincipal.txtAddressU.setText("");
        this.varPrincipal.txtNumberU.setText("");
    }

    public void limpiarCamposModificarUni() {
        this.varPrincipal.txtName2.setText("");
        this.varPrincipal.txtAddress2.setText("");
        this.varPrincipal.txtNumber2.setText("");
    }

    public void limpiarCamposAgregarEscuela() {
        this.varPrincipal.txtNameEscuelaUniBuscar.setText("");
        this.varPrincipal.txtNameEscuela.setText("");
    }

    public void limpiarCamposAgregarCurso() {
        varPrincipal.txtBuscarUniRegistrarCurso.setText("");
        varPrincipal.txtSiglaCursoAgregar.setText("");
        varPrincipal.txtNombreCursoAgregar.setText("");
        varPrincipal.cbEscuelasRegistrarCurso.removeAllItems();
        varPrincipal.cbEscuelasRegistrarCurso.addItem("Aca se mostraran las escuelas de la universidad");
    }

    public void limpiarCamposMostrarCurso() {
        varPrincipal.txtNombreCursoM.setText("");
        varPrincipal.txtEscuelaCursoM.setText("");
    }

    public void limpiarCamposModificadosCurso() {
        varPrincipal.txtModBCursoPorSigla.setText("");
        varPrincipal.txtNuevoNombreCurso.setText("");
        //varPrincipal.txtNuevaSigla.setText("");
    }

    public void limpiarCamposAgregarProfesor(){
        varPrincipal.txtNumeroCedulaProfesor.setText("");
        varPrincipal.txtNombreProfesor.setText("");
        varPrincipal.txtApellido1Profesor.setText("");
        varPrincipal.txtApellido2Profesor.setText("");
        varPrincipal.txtBuscarUniAgregarProfesor.setText("");;
    }

    public void limpiarCamposModificarProfesor(){
        varPrincipal.txtBuscarUniModificarProfe.setText("");
        varPrincipal.txtEscribirCedulaModificarProfe.setText("");
        varPrincipal.txtCedulaProfeModificarProfe.setText("");
        varPrincipal.txtNombreProfeModificarProfe.setText("");
        varPrincipal.txtApellido1ProfeModificarProfe.setText("");
        varPrincipal.txtApellido2ProfeModificarProfe.setText("");
    }

    public void limpiarCamposMostrarInfoProfe(){
        varPrincipal.txtBuscarUniMostrarProfesor.setText("");
        varPrincipal.txtBuscarProfesorMostrarProfesor.setText("");
        varPrincipal.jtaMostrarInformacionProfesor.setText("");
    }

    public void limpiarCamposAgregarEstudiante(){
        varPrincipal.txtBuscarUniAgregarEstudiante.setText("");
        varPrincipal.txtNumeroCedulaEstudiante.setText("");
        varPrincipal.txtNumeroCarnetEstudiante.setText("");
        varPrincipal.txtNombreEstudiante.setText("");
        varPrincipal.txtApellido1Estudiante.setText("");
        varPrincipal.txtApellido2Estudiante.setText("");
    }

    public void limpiarCamposMostrarInfoEstudiante(){
        varPrincipal.txtBuscarUniMostrarInfoEstudiante.setText("");
        varPrincipal.txtBuscarEstConCedulaCarnetMostrarInfoEst.setText("");
        varPrincipal.jtaMostrarInformacionEstudiante.setText("");
    }
}