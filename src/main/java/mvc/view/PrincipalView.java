package mvc.view;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import mvc.modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PrincipalView extends JFrame {
    private static final long serialVersionUID = 1L;
    public JPanel panelContenedor;
    public CardLayout layout;

    private JPanel panelFormularioU, panelModificarU, panelMostrarInformacionUni;
    private JPanel panelFormularioE, panelConsultaE;
    private JPanel panelAgregarCurso, panelModificarCurso, panelMostrarCurso, panelEliminarCurso, panelVerCursos; // Paneles de cursos;
    private JPanel panelAgregarGrupoACurso;
    private JPanel panelGestionarProfesores, panelAgregarProfesor, panelModificarProfesor, panelMostrarInformacionProfesor;
    private JPanel panelAsignarProfeCurso, panelListaCursosAsignadosProfesor, panelListaProfesDeUnaEscuela;
    private JPanel panelGestionarEstudiantes, panelAgregarEstudiantes, panelMostrarInformacionEstudiante, panelModificarEstudiante, panelMatricularEstudiante;
    private JPanel panelConsultaGeneralProfesores, panelCalculoAranceles; // Panel para consulta general de los profes
    private JPanel panelListaGeneralEstudiantil; //panel para mostrar la consulta general del estudiante

    public JTextField txtNameU, txtAddressU, txtNumberU; // Campos de texto para agregar unis
    public JTextField txtNombreMostrarUni;
    public JTextField txtName2, txtAddress2, txtNumber2; // Campos de texto para modificar unis
    public JTextField txtNameEscuelaUniBuscar, txtNameEscuela; // Campos de texto para agregar escuelas
    public JTextField txtNameUniConsultarE; // Campos de texto para consultar las escuelas
    public JTextField txtBuscarUniRegistrarCurso, txtSiglaCursoAgregar, txtNombreCursoAgregar; // Campos de texto para agregar un curso
    public JTextField txtBuscarCursoPorSigla, txtNombreCursoM, txtEscuelaCursoM;
    public JTextField txtBuscarCursoEscuela, txtBuscarListaUE; //campos de texto mostrar cursos
    public JTextField txtModUCurso, txtModECurso, txtModBCursoPorSigla, txtNuevoNombreCurso, txtNuevaSigla;  //campos de texto para modificar un curso
    public JTextField txtEliminarUCurso, txtEliminarECurso, txtEliminarCursoPorSigla; //campos de texto para eliminar un curso
    public JTextField txtBuscarUniAgregarGrupo, txtSiglaGrupoAgregarGrupo;
    public JTextField txtBuscarUniAgregarProfesor, txtNumeroCedulaProfesor, txtNombreProfesor, txtApellido1Profesor, txtApellido2Profesor;
    // Campos de texto para agregar un profesor a una escuela
    public JTextField txtBuscarUniModificarProfe, txtEscribirCedulaModificarProfe, txtCedulaProfeModificarProfe, txtNombreProfeModificarProfe, txtApellido1ProfeModificarProfe, txtApellido2ProfeModificarProfe;
    public JTextField txtBuscarUniMostrarProfesor, txtBuscarProfesorMostrarProfesor;
    public JTextField txtBuscarUniversidad;//compos de asignarProfesor a un curso
    public JTextField txtBucarUniversidadListaCursosAsignadosProfesor;
    public JTextField txtListaProfesDeUnaEscuela; //Recuperación de la lista de profesores de una escuela.
    public JTextField txtBuscarUniAgregarEstudiante, txtNumeroCedulaEstudiante, txtNumeroCarnetEstudiante; // #1 - Campos texto de agregar estudiantes
    public JTextField txtNombreEstudiante, txtApellido1Estudiante, txtApellido2Estudiante; // #2 - Campos texto de agregar estudiantes
    public JTextField txtBuscarUniMostrarInfoEstudiante, txtBuscarEstConCedulaCarnetMostrarInfoEst;
    public JTextField txtBuscarUniModificarEstudiante, txtBuscarEstudianteModificarEstudiante, txtNombreModificarEstudiante,
            txtApellido1ModificarEstudiante, txtApellido2ModificarEstudiante;
    public JTextField txtBuscarUMatriculaEstudiante, txtCalculoAranceles;
    public JTextField txtCalculoArancelesBuscarU, txtCalculoArancelesBuscarID;

    public JComboBox<String> cbEscuelasRegistrarCurso; // JCombo box para mostrar las escuelas disponibles a elegir
    public JComboBox<String> cbCursoEscuela;
    public JComboBox<String> cbEscuelasAgregarGrupo, cbCursosAgregarGrupo;
    public JComboBox<String> cbEscuelasAgregarProfesor;
    public JComboBox<Profesor> cbListaProfes, cbListaProfes2;
    public JComboBox<Curso> cbListaCursos; //los cajabox del metodo para asignar un profesor
    public JComboBox<Grupo> cbGruposDelCurso,cbGruposDelCurso2;
    public JComboBox<Curso> cbListaCursos2;
    public JComboBox<Estudiante> cbListaEstudiantes, cbListaEstudiantes2;
    //  public JComboBox<EstudianteExtranjero>cbListaEstudianteExtranjero;
    public JComboBox<Escuela> cbListaEscuelas;  //4. Recuperación de la lista de profesores de una escuela.
    public JComboBox<String> cbConsultaGeneralProfes; //ComboBox para seleccionar la consulta
    public JComboBox<String> cbEscogerNacionalidad, cbEscogerCantidadBeca;
    public JComboBox <String> cbConsultaGeneralEstudiantesporCurso; //Combobox para consultar la lista de estudiantes
    public JComboBox <String> cbNacionalidadEstudianteModificarEstudiante;
    private JComboBox<String> cbCantidadBecaModificarEstudiante;

    public JTextArea jtaMostrarUni;
    public JTextArea jtaEscuelasEnUni; // Campo de texto de area para consultar las escuelas
    public JTextArea jtaMostrarUYEscuela; // campo de texto donde se mostraran las universidaades y el las escuelas
    public JTextArea jtaMostrarInformacionProfesor;
    public JTextArea jtaMostrarListProfeEscuela;//se mostraran la lsita de profes en una escuela
    public JTextArea jtaCursosAsignadosProfesor;
    public JTextArea jtaListaProfesDeUnaEscuela;//4. Recuperación de la lista de profesores de una escuela.
    public JTextArea jtaMostrarConsultaGeneralProfes; //Campo de texto para mostrar la consulta general de los profes
    public JTextArea jtaMostrarInformacionEstudiante, jtaCalculoAranceles;
    public JTextArea jtaMostrarConsultaGeneralEstudiantes; //Campo de texto para mostrar el dato general del estudiante
    public JTextArea jtaMostrarGrupos;
    public JLabel lblEscribirEscuela, lblEscribirUniModificarProfe, lblEscribirCedulaModificarProfe;
    public JLabel lblEscribirUniMostrarProfesor, lblEscribirProfesorMostrarProfesor; // Label para indicar donde se puede agregar escuelas
    public JLabel lblEscribirUniMostrarInfoEstudiante, lblEscribirCedulaCarnetMostrarInfoEstudiante;

    public JButton btnAgregar, btnModificar, btnIrMostrarUni, btnCambiar, btnAgregarCursos, btnIrE; // Botones para agregar unis
    public JButton btnMostrarUni, btnVolverAgregarUniDesdeMostrarUni;
    public JButton btnModificar2, btnCambiar2, btnBuscarNombreU, btnVolver; // Botones para modificar unis
    public JButton btnEscuelaBuscarUni, btnAgregarEscuela, btnConsultarE; // Botones para agregar escuelas
    public JButton btnverLisCursos, btnCambiar3, btnBuscarNombreUniE, btnVolverAgregarEscuela, btnMostrarCargaAcademica; // Botones para consultar escuelas
    // Botones del panel de agregar curso
    public JButton btnBuscarUniRegistrarCurso, btnBuscarNuevaUni, btnCambiar4, btnModificarCurso, btnRegistrarCurso, btnConsultarCurso, btnEliminarCurso;
    // Botones del panel de mostrar un curso
    public JButton btnBuscarCursoPorSigla, btnVolverAgregarCursos;
    public JButton btnBuscarCursoEscuela, btnVolUni, btnTodosCurso;//botones para mostrar cursos
    public JButton btnBuscarSiglaCurso, btnModCursoP, btnVolverACursos; //botones para modificar un curso
    public JButton btnEliminarCursoPorSiglas, btnIrEliminarCurso, btnVolverAlCurso; //botones para eliminar un curso
    public JButton btnIrGestionarProfesores, btnGestionarEstudiantes; // Boton para ir al panel de seleecion
    public JButton btnVolverAgregarUniDesdeGestionarProfesores, btnGestionarProfesores, btnGestionCursosProfesores, btnConsultarCursoProfesores, btnConsultarEscuelaProfesores;
    public JButton   btnIrAgregarGrupoACurso;
    public JButton btnBuscarUniAgregarGrupo, btnVolverAgregarUniDesdeAgregarGrupo, btnAgregarGrupoACurso;
    public JButton btnBuscarUniProfesores, btnVolverGestionarProfesores1, btnModificarProfesor, btnConsultarInformacionProfesor, btnAgregarProfesor; // Botones para agregar un profesor a una escuela
    public JButton btnBuscarUniModificarProfesor, btnBuscarProfeConCedulaModificarProfe, btnVolverAgregarProfesor, btnModificarInformacionProfesor;
    public JButton btnBuscarUniMostrarProfesor, btnBuscarProfesorMostrarProfesor, btnVolverAgregarProfesorDesdeMostrarProfesor, btnBuscarOtraUniMostrarProfesor;
    public JButton btnBuscarUListaProfesDeUnaEscuela, btnMostrarListaProfesDeUnaEscuela, btnIrListaProfesDeUnaEscuela, btnVolverListaProfesDeUnaEscuela;
    public JButton btnAsignarProfeCurso, btnDesasignarProfeCurso, btnBuscarUniverdad, btnVolverr, btnIrListaCurososAsigandosProfesor;//bones para asiganr y desasignar un curso
    public JButton btnMostrarListaCursosAsignadosProfesor, btnBuscarUniversidadListaCursosAsignadosProfesor, btnVolverUniversidadListaCursosAsignadosProfesor;//4. Recuperación de la lista de profesores de una escuela.
    public JButton btnConsultaGeneralProfes, btnVolverAPanelUni, btnIrConsultaGeneral; //Boton para mostrar la consulta general de los profesores
    public JButton btnVolverAgregarUniDesdeGestionarEstudiantes, btnIrAgregarEstudiante, btnIrMostrarInformacionEstudiante, btnIrModificarEstudiante; // Botones de gestionar estudiantes
    public JButton btnVolverGestionarEstudiantesDesdeModificarEstudiante, btnBuscarUniModificarEstudiante, btnEcontrarEstudianteConCarnetCedula, btnModificarEstudiante;
    public JButton btnBuscarUniAgregarEstudiante, btnVolverGestionarEstudiantesDesdeAgregarEstudiante, btnAgregarEstudiante;
    public JButton btnBuscarUniMostrarInfoEstudiante, btnBuscarEstConCedulaCarnetMostrarInfoEst, btnVolverGestionarEstudiantesDesdeMostraInforEst, btnBuscarOtraUniMostrarInfoEst;
    public JButton btnMatriculaIr, btnMatricularBuscar, btnMatriculaVolver, btnMatricular, btnDesMatricular;
    public JButton btnArancelesIr,btnAraancelesVolver,btnArancelesMostrar, btnArancelesBuscarU;

    public JButton btnConsultaGeneralEstudianteLista, btnVolverAGestionarEstudiantes, btnIrConsultaGenEstudiante; //botones para el panel de consulta general estudiantil
    public JButton btnMostrarGrupos;
    public JRadioButton jrbDirector;
    public JRadioButton jrbEstNacional;
    public JRadioButton jrbEstExtranjero;

    // public BottonGrup bgTipoEstudiante;

    public PrincipalView() {
        layout = new CardLayout();
        panelContenedor = new JPanel(layout);

        setTitle("Universidades");
        setSize(1500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.ORANGE);

        // Creamos los paneles
        crearFormularioU();
        mostrarInformacionUniversidad();
        modificarU();
        panelFormularioEscuelas();
        panelConsultarE();
        panelAgregarCursos();
        mostrarCurso();
        metodoMostrarCursos();
        modificarCurso();
        eliminarCurso();
        agregarGrupoACurso();
        gestionarProfesores();
        agregarProfesorEscuela();
        modificarProfesor();
        mostrarInformacionProfesor();
        asignarProfesorCurso();
        mostrarListaCursosAsignadosProfesor();
        ListaProfesDeUnaEscuela();
        gestionarEstudiante();
        agregarEstudiantes();
        crearPanelConsultaGeneralP();
        mostrarInformacionEstudiante();
        modificarEstudiante();
        panelMatricularEstudiante();
        calculoDeAranceles();
        consultaGeneralEstudiantil();

        // Agregamos los paneles al contenedor
        panelContenedor.add(panelFormularioU, "universidad");
        panelContenedor.add(panelMostrarInformacionUni, "mostrarUniversidad");
        panelContenedor.add(panelModificarU, "modoficarU");
        panelContenedor.add(panelFormularioE, "escuelas");
        panelContenedor.add(panelConsultaE, "consultaE");
        panelContenedor.add(panelAgregarCurso, "agregarCursos");
        panelContenedor.add(panelMostrarCurso, "mostrarCursos");
        panelContenedor.add(panelVerCursos, "cursos");
        panelContenedor.add(panelModificarCurso, "modificarCurso");
        panelContenedor.add(panelEliminarCurso, "eliminarCurso");
        panelContenedor.add(panelAgregarGrupoACurso, "agregarGrupoACurso");
        panelContenedor.add(panelGestionarProfesores, "gestionarProfesores");
        panelContenedor.add(panelConsultaGeneralProfesores, "consultaGeneralProfes");
        panelContenedor.add(panelAgregarProfesor, "agregarProfesor");
        panelContenedor.add(panelAsignarProfeCurso, "asiganarProfeCurso");
        panelContenedor.add(panelListaCursosAsignadosProfesor, "listaCursosAsignadosProfesor");
        panelContenedor.add(panelModificarProfesor, "modificarProfesor");
        panelContenedor.add(panelMostrarInformacionProfesor, "mostrarProfesor");
        panelContenedor.add(panelListaProfesDeUnaEscuela, "listaProfesDeUnaEscuela");
        panelContenedor.add(panelGestionarEstudiantes, "gestionarEstudiantes");
        panelContenedor.add(panelAgregarEstudiantes, "agregarEstudiantes");
        panelContenedor.add(panelMostrarInformacionEstudiante, "mostrarEstudiantes");
        panelContenedor.add(panelModificarEstudiante, "modificarEstudiantes");
        panelContenedor.add(panelMatricularEstudiante, "matricularEstudiante");
        panelContenedor.add(panelCalculoAranceles, "calculoAranceles");
        panelContenedor.add(panelListaGeneralEstudiantil, "consultaGeneralE");
        add(panelContenedor, BorderLayout.CENTER);
    }

    //avance 1
    //  Panel de Universidad
    public void crearFormularioU() {
        //UIManager.put("Buton.arc",20);

        panelFormularioU = new JPanel(new GridBagLayout());
        panelFormularioU.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Informacion de la Universidad",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        m.gridx = 0;
        m.gridy = 0;
        panelFormularioU.add(new JLabel("Nombre de la universidad"), m);
        m.gridx++;
        txtNameU = new JTextField(15);
        panelFormularioU.add(txtNameU, m);

        m.gridx = 2;
        btnAgregar = new JButton("Agregar Universidad");
        panelFormularioU.add(btnAgregar, m);


        //direccion
        m.gridx = 0;
        m.gridy++;

        panelFormularioU.add(new JLabel("Direccion de la Universidad"), m);
        m.gridx++;
        txtAddressU = new JTextField();
        panelFormularioU.add(txtAddressU, m);


        //telefono
        m.gridx = 0;
        m.gridy++;
        panelFormularioU.add(new JLabel("Telefono de la Universidad"), m);
        m.gridx++;
        txtNumberU = new JTextField();
        panelFormularioU.add(txtNumberU, m);

        m.gridy++;
        m.gridx = 0;
        btnCambiar = new JButton("Universidad");
        panelFormularioU.add(btnCambiar, m);

        m.gridx++;
        btnIrE = new JButton("Escuelas");
        panelFormularioU.add(btnIrE, m);

        m.gridx++;
        btnGestionarEstudiantes = new JButton("Estudiantes");
        panelFormularioU.add(btnGestionarEstudiantes, m);

        m.gridy++;
        m.gridx = 0;
        btnAgregarCursos = new JButton("Cursos");
        panelFormularioU.add(btnAgregarCursos, m);

        m.gridx++;
        btnIrAgregarGrupoACurso = new JButton("Grupos");
        panelFormularioU.add(btnIrAgregarGrupoACurso, m);

        m.gridx++;
        btnIrGestionarProfesores = new JButton("Profesores");
        panelFormularioU.add(btnIrGestionarProfesores, m);
    }

    public void mostrarInformacionUniversidad(){
        panelMostrarInformacionUni = new JPanel(new GridBagLayout());
        panelMostrarInformacionUni.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Mostrar la informacion de una universidad",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        m.gridy = 0;
        m.gridx = 0;
        panelMostrarInformacionUni.add(new JLabel("Dijite el nombre de la universidad"), m);

        m.gridx++;
        txtNombreMostrarUni = new JTextField(15);
        panelMostrarInformacionUni.add(txtNombreMostrarUni, m);

        m.gridx++;
        btnMostrarUni = new JButton("Buscar universidad");
        panelMostrarInformacionUni.add(btnMostrarUni, m);

        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 3;
        jtaMostrarUni = new JTextArea();
        jtaMostrarUni.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaMostrarUni);
        scrollPane.setPreferredSize(new Dimension(0, 100)); // Cambia 150 por la altura deseada
        panelMostrarInformacionUni.add(scrollPane, m);

        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 1;
        btnVolverAgregarUniDesdeMostrarUni = new JButton("Volver a agregar universidades");
        panelMostrarInformacionUni.add(btnVolverAgregarUniDesdeMostrarUni, m);
    }

    // Panel para modificar la U
    public void modificarU() {
        panelModificarU = new JPanel(new GridBagLayout());
        panelModificarU.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Modificar Universidad",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;
        //panelEscuelas = new JPanel();
        //panelEscuelas.setLayout(new BorderLayout());

        m.gridx = 0;
        m.gridy = 0;
        btnBuscarNombreU = new JButton();
        btnBuscarNombreU.setText("Buscar universidad");
        panelModificarU.add(btnBuscarNombreU, m);

        m.gridx++;
        txtName2 = new JTextField();
        panelModificarU.add(txtName2, m);


        m.gridx = 0;
        m.gridy = 2;
        panelModificarU.add(new JLabel("Direccion de la Universidad"), m);
        m.gridx++;
        txtAddress2 = new JTextField();
        panelModificarU.add(txtAddress2, m);


        m.gridx = 0;
        m.gridy = 1;
        panelModificarU.add(new JLabel("Telefono de la Universidad"), m);
        m.gridx++;
        txtNumber2 = new JTextField();
        panelModificarU.add(txtNumber2, m);

        m.gridy++;
        m.gridx = 2;
        btnModificar2 = new JButton("Modificar Universidad");
        btnModificar2.setPreferredSize(new Dimension(200, 40));
        btnModificar2.setEnabled(false);
        panelModificarU.add(btnModificar2, m);

        m.gridx = 0;
        m.gridy = 3;
        btnIrMostrarUni = new JButton("Ver la informacion de una universidad");
        panelModificarU.add(btnIrMostrarUni, m);

        m.gridx = 1;
        m.gridy = 3;
        btnVolver = new JButton("Volver a agregar universidad");
        panelModificarU.add(btnVolver, m);
    }
    //Panel para las escuelas
    public void panelFormularioEscuelas() {
        panelFormularioE = new JPanel(new GridBagLayout());
        panelFormularioE.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Agregar Escuela a una Universidad",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10);
        m.fill = GridBagConstraints.HORIZONTAL;
        m.anchor = GridBagConstraints.WEST;

        Font font = new Font("Arial", Font.PLAIN, 14);

        //Buscar universidad
        m.gridx = 0;
        m.gridy = 0;
        panelFormularioE.add(new JLabel("Nombre de la universidad:"), m);

        m.gridx = 1;
        txtNameEscuelaUniBuscar = new JTextField(20);
        txtNameEscuelaUniBuscar.setFont(font);
        panelFormularioE.add(txtNameEscuelaUniBuscar, m);

        m.gridx = 2;
        btnEscuelaBuscarUni = new JButton("Buscar universidad");
        btnEscuelaBuscarUni.setFont(font);
        panelFormularioE.add(btnEscuelaBuscarUni, m);

        //Espacio
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 3;
        panelFormularioE.add(new JLabel(" "), m);
        m.gridwidth = 1;

        //   agregar escuela
        m.gridy++;
        m.gridx = 0;
        lblEscribirEscuela = new JLabel("Nombre de la nueva escuela:");
        lblEscribirEscuela.setFont(font);
        lblEscribirEscuela.setVisible(false);
        panelFormularioE.add(lblEscribirEscuela, m);

        m.gridx = 1;
        txtNameEscuela = new JTextField(20);
        txtNameEscuela.setFont(font);
        txtNameEscuela.setVisible(false);
        panelFormularioE.add(txtNameEscuela, m);

        m.gridx = 2;
        btnAgregarEscuela = new JButton("Agregar Escuela");
        btnAgregarEscuela.setFont(font);
        btnAgregarEscuela.setEnabled(false);
        panelFormularioE.add(btnAgregarEscuela, m);

        // Botoness
        m.gridy++;
        m.gridx = 0;
        btnConsultarE = new JButton("Consultar lista de escuelas");
        btnConsultarE.setFont(font);
        panelFormularioE.add(btnConsultarE, m);

        m.gridx = 1;
        btnCambiar2 = new JButton("Volver al registro de universidades");
        btnCambiar2.setFont(font);
        panelFormularioE.add(btnCambiar2, m);

        m.gridx = 2;
    }
    //Panel para consultar la escuela
    public void panelConsultarE() {
        panelConsultaE = new JPanel(new GridBagLayout());
        panelConsultaE.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(86, 136, 177)), "Consultar escuelas",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 20, 10, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Arial", Font.PLAIN, 14);

        // buscar universidad
        m.gridx = 0;
        m.gridy = 0;
        m.gridwidth = 2;
        btnBuscarNombreUniE = new JButton("Buscar universidad para mostrar sus escuelas");
        btnBuscarNombreUniE.setFont(font);
        panelConsultaE.add(btnBuscarNombreUniE, m);

        m.gridy++;
        txtNameUniConsultarE = new JTextField();
        txtNameUniConsultarE.setPreferredSize(new Dimension(250, 30));
        txtNameUniConsultarE.setFont(font);
        panelConsultaE.add(txtNameUniConsultarE, m);

        //titulo
        m.gridy++;
        JLabel labelEscuelas = new JLabel("Escuelas asociadas a la universidad");
        labelEscuelas.setFont(new Font("Arial", Font.BOLD, 15));
        panelConsultaE.add(labelEscuelas, m);

        //  con JScrollPane
        m.gridy++;
        jtaEscuelasEnUni = new JTextArea(7, 30);
        jtaEscuelasEnUni.setFont(font);
        jtaEscuelasEnUni.setEditable(false);
        jtaEscuelasEnUni.setLineWrap(true);
        jtaEscuelasEnUni.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(jtaEscuelasEnUni);
        panelConsultaE.add(scrollPane, m);

        // Botones
        m.gridy++;
        m.gridwidth = 1;
        m.gridx = 0;
        btnVolverAgregarEscuela = new JButton("Volver a agregar escuela");
        btnVolverAgregarEscuela.setFont(font);
        panelConsultaE.add(btnVolverAgregarEscuela, m);

        m.gridx = 1;
        btnCambiar3 = new JButton("Volver a agregar universidades");
        btnCambiar3.setFont(font);
        panelConsultaE.add(btnCambiar3, m);
    }
    //avance 2
    //panel de agregar cursos
    public void panelAgregarCursos() {
        panelAgregarCurso = new JPanel(new GridBagLayout());
        panelAgregarCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)),
                "Agregar curso",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.CENTER_BASELINE, 56),
                Color.WHITE));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10);
        m.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Arial", Font.PLAIN, 14);

        // --- Buscar universidad ---
        m.gridx = 0;
        m.gridy = 0;
        JLabel labelBuscarUni = new JLabel("Ingrese la universidad en la que desea registrar un curso:");
        labelBuscarUni.setFont(font);
        panelAgregarCurso.add(labelBuscarUni, m);

        m.gridx = 1;
        txtBuscarUniRegistrarCurso = new JTextField(20);
        txtBuscarUniRegistrarCurso.setFont(font);
        panelAgregarCurso.add(txtBuscarUniRegistrarCurso, m);

        m.gridx = 2;
        btnBuscarUniRegistrarCurso = new JButton("Buscar universidad");
        btnBuscarUniRegistrarCurso.setFont(font);
        panelAgregarCurso.add(btnBuscarUniRegistrarCurso, m);

        m.gridx = 3;
        btnBuscarNuevaUni = new JButton("Buscar otra universidad");
        btnBuscarNuevaUni.setEnabled(false);
        btnBuscarNuevaUni.setFont(font);
        panelAgregarCurso.add(btnBuscarNuevaUni, m);

        // --- ComboBox de escuelas ---
        m.gridx = 0;
        m.gridy++;
        JLabel labelEscuela = new JLabel("Seleccione una escuela donde se agregará el curso:");
        labelEscuela.setFont(font);
        panelAgregarCurso.add(labelEscuela, m);

        m.gridx = 1;
        cbEscuelasRegistrarCurso = new JComboBox<>();
        cbEscuelasRegistrarCurso.addItem("Aca se mostrarán las escuelas de los cursos");
        cbEscuelasRegistrarCurso.setFont(font);
        panelAgregarCurso.add(cbEscuelasRegistrarCurso, m);

        // --- Campo Sigla del Curso ---
        m.gridx = 0;
        m.gridy++;
        JLabel labelSigla = new JLabel("Ingrese la sigla del curso:");
        labelSigla.setFont(font);
        panelAgregarCurso.add(labelSigla, m);

        m.gridy++;
        txtSiglaCursoAgregar = new JTextField(10);
        txtSiglaCursoAgregar.setFont(font);
        panelAgregarCurso.add(txtSiglaCursoAgregar, m);

        // --- Campo Nombre del Curso ---
        m.gridy++;
        JLabel labelNombreCurso = new JLabel("Ingrese el nombre del curso a agregar:");
        labelNombreCurso.setFont(font);
        panelAgregarCurso.add(labelNombreCurso, m);

        m.gridy++;
        txtNombreCursoAgregar = new JTextField(20);
        txtNombreCursoAgregar.setFont(font);
        panelAgregarCurso.add(txtNombreCursoAgregar, m);

        // --- Botón Agregar Curso ---
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 2;
        btnRegistrarCurso = new JButton("Agregar!");
        btnRegistrarCurso.setBackground(Color.BLUE);
        btnRegistrarCurso.setEnabled(false);
        btnRegistrarCurso.setFont(font);
        panelAgregarCurso.add(btnRegistrarCurso, m);

        // --- Botón Consultar Curso ---
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 1;
        btnConsultarCurso = new JButton("Ver información");
        btnConsultarCurso.setFont(font);
        btnConsultarCurso.setBackground(new Color(0, 120, 215));
        panelAgregarCurso.add(btnConsultarCurso, m);

        // --- Botón Eliminar Curso ---
        m.gridx = 1;
        btnIrEliminarCurso = new JButton("Eliminar");
        btnIrEliminarCurso.setFont(font);
        btnIrEliminarCurso.setBackground(new Color(220, 53, 69));
        panelAgregarCurso.add(btnIrEliminarCurso, m);

        // --- Botón Modificar Curso ---
        m.gridy++;
        m.gridx = 0;
        btnModificarCurso = new JButton("Modificar información de un curso");
        btnModificarCurso.setFont(font);
        btnModificarCurso.setBackground(new Color(0, 120, 215));
        panelAgregarCurso.add(btnModificarCurso, m);

        // --- Botón Ver Cursos ---
        m.gridx = 1;
        btnverLisCursos = new JButton("Ver cursos");
        btnverLisCursos.setFont(font);
        btnverLisCursos.setBackground(new Color(0, 120, 215));
        panelAgregarCurso.add(btnverLisCursos, m);

        // --- Botón Volver ---
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 2;
        btnCambiar4 = new JButton("Volver");
        btnCambiar4.setFont(font);
        panelAgregarCurso.add(btnCambiar4, m);
    }


    //Panel para mostrar los cursos
    public void mostrarCurso() {
        panelMostrarCurso = new JPanel(new GridBagLayout());
        panelMostrarCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.green), "Buscar curso por su sigla",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10);
        m.fill = GridBagConstraints.HORIZONTAL;
        m.anchor = GridBagConstraints.WEST;

        Font font = new Font("Arial", Font.PLAIN, 14);

        //campo para digitar la sigla
        m.gridx = 0;
        m.gridy = 0;
        m.gridwidth = 2;
        JLabel instruccion = new JLabel("Digite la sigla del curso y presione el boton para mostrar su informacion:");
        instruccion.setFont(font);
        panelMostrarCurso.add(instruccion, m);

        m.gridy++;
        m.gridwidth = 1;
        panelMostrarCurso.add(new JLabel("Sigla del curso:"), m);
        // campo de texto para buscar cursos por la sigla
        m.gridx = 1;
        txtBuscarCursoPorSigla = new JTextField(20);
        txtBuscarCursoPorSigla.setFont(font);
        panelMostrarCurso.add(txtBuscarCursoPorSigla, m);

        //Boton buscar
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 2;
        btnBuscarCursoPorSigla = new JButton("Buscar");
        btnBuscarCursoPorSigla.setFont(font);
        panelMostrarCurso.add(btnBuscarCursoPorSigla, m);

        //Nombre del curso
        m.gridy++;
        m.gridwidth = 1;
        m.gridx = 0;
        panelMostrarCurso.add(new JLabel("Nombre del curso:"), m);

        m.gridx = 1;
        txtNombreCursoM = new JTextField(20);
        txtNombreCursoM.setEditable(false);
        txtNombreCursoM.setFont(font);
        panelMostrarCurso.add(txtNombreCursoM, m);

        // Escuela del curso
        m.gridy++;
        m.gridx = 0;
        panelMostrarCurso.add(new JLabel("Escuela a la que pertenece:"), m);

        m.gridx = 1;
        txtEscuelaCursoM = new JTextField(20);
        txtEscuelaCursoM.setEditable(false);
        txtEscuelaCursoM.setFont(font);
        panelMostrarCurso.add(txtEscuelaCursoM, m);

        // Boton volver
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 2;
        btnVolverAgregarCursos = new JButton("Volver");
        btnVolverAgregarCursos.setFont(font);
        panelMostrarCurso.add(btnVolverAgregarCursos, m);
    }
    //panel para mostrar los cursos
    public void metodoMostrarCursos() {
        panelVerCursos = new JPanel(new GridBagLayout());
        panelVerCursos.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.green), "Recuperacion de cursos",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10);
        m.fill = GridBagConstraints.HORIZONTAL;
        m.anchor = GridBagConstraints.WEST;

        Font font = new Font("Arial", Font.PLAIN, 14);

        // Buscar por nombre escuela
        m.gridx = 0;
        m.gridy = 0;
        panelVerCursos.add(new JLabel("Buscar por nombre de escuela:"), m);

        m.gridx = 1;
        txtBuscarCursoEscuela = new JTextField(20);
        txtBuscarCursoEscuela.setFont(font);
        panelVerCursos.add(txtBuscarCursoEscuela, m);
        //para buscar la escuela
        m.gridx = 2;
        btnBuscarCursoEscuela = new JButton("Buscar escuela");
        btnBuscarCursoEscuela.setFont(font);
        panelVerCursos.add(btnBuscarCursoEscuela, m);

        // ComboBox de cursos
        m.gridy++;
        m.gridx = 0;
        panelVerCursos.add(new JLabel("cursos impartidos por la escuela:"), m);

        m.gridx = 1;
        m.gridwidth = 2;
        cbCursoEscuela = new JComboBox<>();
        cbCursoEscuela.addItem("Seleccione una opcion");
        cbCursoEscuela.setFont(font);
        panelVerCursos.add(cbCursoEscuela, m);

        m.gridwidth = 1;

        // Buscar todos los cursos por universidad
        m.gridy++;
        m.gridx = 0;
        panelVerCursos.add(new JLabel("Nombre de la universidad:"), m);

        m.gridx = 1;
        txtBuscarListaUE = new JTextField(20);
        txtBuscarListaUE.setFont(font);
        panelVerCursos.add(txtBuscarListaUE, m);

        m.gridx = 2;
        btnTodosCurso = new JButton("Buscar cursos impartidos por la universidad");
        btnTodosCurso.setFont(font);
        panelVerCursos.add(btnTodosCurso, m);

        // area de resultados
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 3;
        jtaMostrarUYEscuela = new JTextArea(15, 40);
        jtaMostrarUYEscuela.setFont(font);
        jtaMostrarUYEscuela.setEditable(false);
        jtaMostrarUYEscuela.setBackground(new Color(30, 40, 30)); // modo oscuro
        jtaMostrarUYEscuela.setForeground(Color.WHITE);
        jtaMostrarUYEscuela.setLineWrap(true);
        jtaMostrarUYEscuela.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(jtaMostrarUYEscuela);
        panelVerCursos.add(scroll, m);

        // Boton volver
        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 3;
        btnVolUni = new JButton("Volver");
        btnVolUni.setFont(font);
        panelVerCursos.add(btnVolUni, m);
    }
    //panel para modificar los cursos
    public void modificarCurso() {

        panelModificarCurso = new JPanel(new GridBagLayout());
        panelModificarCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.green), "Modificar curso",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Busqueda de curso
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelModificarCurso.add(new JLabel("Sigla del curso a modificar:"), gbc);
        //Campo de texto para ingresar el curso por sigla
        gbc.gridx = 1;
        txtModBCursoPorSigla = new JTextField(15);
        panelModificarCurso.add(txtModBCursoPorSigla, gbc);
        //boton para buscar el curso
        gbc.gridx = 2;
        btnBuscarSiglaCurso = new JButton("Buscar curso");
        panelModificarCurso.add(btnBuscarSiglaCurso, gbc);

        //Nuevo nombre
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelModificarCurso.add(new JLabel("Nuevo nombre del curso:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtNuevoNombreCurso = new JTextField(20);
        panelModificarCurso.add(txtNuevoNombreCurso, gbc);
        gbc.gridwidth = 1;

        //  Boton modificar
        gbc.gridx = 0;
        gbc.gridy = 3;
        btnModCursoP = new JButton("Modificar curso");
        btnModCursoP.setEnabled(false);
        panelModificarCurso.add(btnModCursoP, gbc);

        //Botoo volver
        gbc.gridx = 1;
        btnVolverACursos = new JButton("Volver a cursos");
        panelModificarCurso.add(btnVolverACursos, gbc);

    }
    //panel para eliminar los cursos
    public void eliminarCurso() {
        panelEliminarCurso = new JPanel(new GridBagLayout());
        panelEliminarCurso.setBackground(Color.darkGray);

        panelEliminarCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(144, 47, 77)), "Eliminar curso",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 16),
                new Color(120, 23, 49)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //   Etiqueta
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        JLabel lblSigla = new JLabel("Sigla del curso a eliminar:");
        lblSigla.setFont(new Font("UI", Font.PLAIN, 14));
        lblSigla.setForeground(Color.WHITE);
        panelEliminarCurso.add(lblSigla, gbc);

        // Campo de texto
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        txtEliminarCursoPorSigla = new JTextField(15);
        txtEliminarCursoPorSigla.setFont(new Font("", Font.PLAIN, 14));
        panelEliminarCurso.add(txtEliminarCursoPorSigla, gbc);

        //  Botón Eliminar
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        btnEliminarCurso = new JButton(" Eliminar curso");
        // btnEliminarCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEliminarCurso.setBackground(new Color(220, 53, 69)); // Rojo moderno
        btnEliminarCurso.setForeground(Color.WHITE);
        btnEliminarCurso.setFocusPainted(false);
        btnEliminarCurso.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelEliminarCurso.add(btnEliminarCurso, gbc);

        // Botón Volver
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        btnVolverAlCurso = new JButton(" Volver a cursos");
        btnVolverAlCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVolverAlCurso.setBackground(new Color(0, 120, 215)); // Azul moderno
        btnVolverAlCurso.setForeground(Color.WHITE);
        btnVolverAlCurso.setFocusPainted(false);
        btnVolverAlCurso.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelEliminarCurso.add(btnVolverAlCurso, gbc);

    }
    //Panel para agregar un grupo al curso
    public void agregarGrupoACurso(){
        panelAgregarGrupoACurso = new JPanel(new GridBagLayout());
        panelAgregarGrupoACurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(100, 120, 215)), "Panel para agregar un nuevo grupo a un curso existente",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 30), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 50, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        m.gridy = 0;
        m.gridx = 0;
        panelAgregarGrupoACurso.add(new JLabel("Seleccione la universidad a la que pertenece el curso donde se agregara el grupo"), m);

        m.gridx++;
        txtBuscarUniAgregarGrupo = new JTextField(15);
        panelAgregarGrupoACurso.add(txtBuscarUniAgregarGrupo, m);
        //boton para buscar la U
        m.gridx++;
        btnBuscarUniAgregarGrupo = new JButton("Buscar universidad");
        panelAgregarGrupoACurso.add(btnBuscarUniAgregarGrupo, m);
        //agregar un JLabel para seleccionar
        m.gridy++;
        m.gridx = 1;
        panelAgregarGrupoACurso.add(new JLabel("Seleccione una escuela para mostrar sus cursos disponibles"), m);
        //ComboBox de las escuelas para seleccionar
        m.gridx++;
        cbEscuelasAgregarGrupo = new JComboBox<>();
        cbEscuelasAgregarGrupo.setEnabled(false);
        panelAgregarGrupoACurso.add(cbEscuelasAgregarGrupo, m);

        m.gridy++;
        m.gridx = 1;
        panelAgregarGrupoACurso.add(new JLabel("Seleccione el curso donde se agregará el nuevo grupo"), m);

        m.gridx++;
        cbCursosAgregarGrupo = new JComboBox<>();
        cbCursosAgregarGrupo.setEnabled(false);
        panelAgregarGrupoACurso.add(cbCursosAgregarGrupo, m);

        m.gridy++;
        m.gridx = 1;
        panelAgregarGrupoACurso.add(new JLabel("Escriba la sigla del grupo a agregar al curso"), m);

        m.gridx++;
        txtSiglaGrupoAgregarGrupo = new JTextField(15);
        txtSiglaGrupoAgregarGrupo.setEditable(false);
        panelAgregarGrupoACurso.add(txtSiglaGrupoAgregarGrupo, m);
        //boton para regresar al panel de la U
        m.gridy++;
        m.gridx = 0;
        btnVolverAgregarUniDesdeAgregarGrupo = new JButton("Volver a agregar universidad");
        panelAgregarGrupoACurso.add(btnVolverAgregarUniDesdeAgregarGrupo, m);
        //Boton para agregar el grupo
        m.gridx++;
        m.gridwidth = 2;
        btnAgregarGrupoACurso = new JButton("Agregar grupo");
        btnAgregarGrupoACurso.setEnabled(false);
        panelAgregarGrupoACurso.add(btnAgregarGrupoACurso, m);
    }

    //parte del avance 3
    //Panel, menu para gestionar los profesores
    public void gestionarProfesores() {
        panelGestionarProfesores = new JPanel(new GridBagLayout());
        panelGestionarProfesores.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(100, 120, 215)), "Seleccione lo que desea hacer",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 30), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 50, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        m.gridy = 0;
        m.gridx = 0;
        panelGestionarProfesores.add(new JLabel("Botón para ir a gestionar profesores"), m);

        m.gridx = 1;
        panelGestionarProfesores.add(new JLabel("Botones para gestionar o consultar cursos"), m);

        m.gridx = 2;
        panelGestionarProfesores.add(new JLabel("Bonton ir a consulta general"), m);

//  Botones funcionales
        //Boton para gestionar profes
        m.gridy = 1;
        m.gridx = 0;
        btnGestionarProfesores = new JButton("Gestionar profesores");
        btnGestionarProfesores.setPreferredSize(new Dimension(200, 50));
        panelGestionarProfesores.add(btnGestionarProfesores, m);
//Boton para gestionar cursos
        m.gridx = 1;
        btnGestionCursosProfesores = new JButton("Gestionar cursos");
        btnGestionCursosProfesores.setPreferredSize(new Dimension(200, 50));
        panelGestionarProfesores.add(btnGestionCursosProfesores, m);


//Boton para volver al panel de universidad

        m.gridx = 0;
        m.gridy = 2;
        m.gridwidth = 5;
        btnVolverAgregarUniDesdeGestionarProfesores = new JButton("Volver");
        btnVolverAgregarUniDesdeGestionarProfesores.setPreferredSize(new Dimension(200, 50));
        panelGestionarProfesores.add(btnVolverAgregarUniDesdeGestionarProfesores, m);

//  Botón adicional
        m.gridy = 1;
        m.gridx = 2;
        btnIrConsultaGeneral = new JButton("Ir a consulta general");
        btnIrConsultaGeneral.setPreferredSize(new Dimension(200, 50));
        panelGestionarProfesores.add(btnIrConsultaGeneral, m);
        m.gridwidth = 1;

    }
    //Panel para agregar un profe a una escuela
    public void agregarProfesorEscuela() {
        panelAgregarProfesor = new JPanel(new GridBagLayout());
        panelAgregarProfesor.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GREEN),
                "Agregar un nuevo profesor a una escuela",
                TitledBorder.CENTER, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 16),
                Color.WHITE));

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(15, 15, 15, 15);
        g.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: Buscar universidad
        g.gridy = 0;
        g.gridx = 0;
        panelAgregarProfesor.add(new JLabel("Digite el nombre de la universidad:"), g);

        g.gridx = 1;
        txtBuscarUniAgregarProfesor = new JTextField();
        panelAgregarProfesor.add(txtBuscarUniAgregarProfesor, g);

        g.gridx = 2;
        btnBuscarUniProfesores = new JButton("Buscar universidad");
        panelAgregarProfesor.add(btnBuscarUniProfesores, g);

        // Fila 1: ComboBox escuelas
        g.gridy++;
        g.gridx = 0;
        panelAgregarProfesor.add(new JLabel("Seleccione la escuela donde se agregará el profesor:"), g);

        g.gridx = 1;
        cbEscuelasAgregarProfesor = new JComboBox<>();
        cbEscuelasAgregarProfesor.addItem("Aca se mostraran las escuelas de la universidad encontrada");
        panelAgregarProfesor.add(cbEscuelasAgregarProfesor, g);

        // Fila 2: Número de cédula
        g.gridy++;
        g.gridx = 0;
        panelAgregarProfesor.add(new JLabel("Número de cédula del profesor:"), g);

        g.gridx = 1;
        txtNumeroCedulaProfesor = new JTextField();
        txtNumeroCedulaProfesor.setEnabled(false);
        panelAgregarProfesor.add(txtNumeroCedulaProfesor, g);

        // Fila 3: Nombre
        g.gridy++;
        g.gridx = 0;
        panelAgregarProfesor.add(new JLabel("Nombre del profesor:"), g);

        g.gridx = 1;
        txtNombreProfesor = new JTextField();
        txtNombreProfesor.setEnabled(false);
        panelAgregarProfesor.add(txtNombreProfesor, g);

        // Fila 4: Primer apellido
        g.gridy++;
        g.gridx = 0;
        panelAgregarProfesor.add(new JLabel("Primer apellido del profesor:"), g);

        g.gridx = 1;
        txtApellido1Profesor = new JTextField();
        txtApellido1Profesor.setEnabled(false);
        panelAgregarProfesor.add(txtApellido1Profesor, g);

        // Fila 5: Segundo apellido
        g.gridy++;
        g.gridx = 0;
        panelAgregarProfesor.add(new JLabel("Segundo apellido del profesor:"), g);

        g.gridx = 1;
        txtApellido2Profesor = new JTextField();
        txtApellido2Profesor.setEnabled(false);
        panelAgregarProfesor.add(txtApellido2Profesor, g);

        // Fila 6: RadioButton director
        g.gridy++;
        g.gridx = 0;
        jrbDirector = new JRadioButton("Marcar al profesor como director");
        jrbDirector.setEnabled(false);
        panelAgregarProfesor.add(jrbDirector, g);

        // Fila 6: Botón volver
        g.gridx = 1;
        btnVolverGestionarProfesores1 = new JButton("Volver a la sección de selección");
        panelAgregarProfesor.add(btnVolverGestionarProfesores1, g);

        // Fila 7: Botones de acciones
        g.gridy++;
        g.gridx = 0;
        btnModificarProfesor = new JButton("Modificar la información de un profesor");
        panelAgregarProfesor.add(btnModificarProfesor, g);

        g.gridx = 1;
        btnConsultarInformacionProfesor = new JButton("Consultar la información de un profesor");
        panelAgregarProfesor.add(btnConsultarInformacionProfesor, g);

        g.gridx = 2;
        btnAgregarProfesor = new JButton("Agregar profesor!");
        btnAgregarProfesor.setEnabled(false);
        panelAgregarProfesor.add(btnAgregarProfesor, g);
    }
    // Panel para modificar profesor
    public void modificarProfesor() {
        panelModificarProfesor = new JPanel(new GridBagLayout());
        panelModificarProfesor.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Modificar al informacion del profesor",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        m.gridy = 0;
        m.gridx = 0;
        //Aregando los componentes
        lblEscribirUniModificarProfe = new JLabel("Escriba la universidad donde pertenece el profesor a modificar");
        panelModificarProfesor.add(lblEscribirUniModificarProfe, m);

        m.gridx++;
        txtBuscarUniModificarProfe = new JTextField("");
        panelModificarProfesor.add(txtBuscarUniModificarProfe, m);
        //Boton para buscar la universidad
        m.gridx++;
        btnBuscarUniModificarProfesor = new JButton("Buscar universidad");
        panelModificarProfesor.add(btnBuscarUniModificarProfesor, m);

        m.gridy = 1;
        m.gridx = 0;
        lblEscribirCedulaModificarProfe = new JLabel("Escriba la cedula del profesor para que pueda modificar su informacion");
        lblEscribirCedulaModificarProfe.setVisible(false);
        panelModificarProfesor.add(lblEscribirCedulaModificarProfe, m);

        m.gridx++;
        txtEscribirCedulaModificarProfe = new JTextField();
        txtEscribirCedulaModificarProfe.setVisible(false);
        panelModificarProfesor.add(txtEscribirCedulaModificarProfe, m);
        //boton para buscar profesor
        m.gridx++;
        btnBuscarProfeConCedulaModificarProfe = new JButton("Buscar profesor");
        btnBuscarProfeConCedulaModificarProfe.setVisible(false);
        panelModificarProfesor.add(btnBuscarProfeConCedulaModificarProfe, m);

        m.gridy = 2;
        m.gridx = 1;
        panelModificarProfesor.add(new JLabel("Numero de cedula"), m);

        m.gridx++;
        txtCedulaProfeModificarProfe = new JTextField();
        txtCedulaProfeModificarProfe.setEditable(false);
        panelModificarProfesor.add(txtCedulaProfeModificarProfe, m);

        m.gridy = 3;
        m.gridx = 1;
        panelModificarProfesor.add(new JLabel("Nombre del profesor"), m);

        m.gridx++;
        txtNombreProfeModificarProfe = new JTextField();
        txtNombreProfeModificarProfe.setEditable(false);
        panelModificarProfesor.add(txtNombreProfeModificarProfe, m);

        m.gridy = 4;
        m.gridx = 1;
        panelModificarProfesor.add(new JLabel("Primer apellido del profesor"), m);

        m.gridx++;
        txtApellido1ProfeModificarProfe = new JTextField();
        txtApellido1ProfeModificarProfe.setEditable(false);
        panelModificarProfesor.add(txtApellido1ProfeModificarProfe, m);

        m.gridy = 5;
        m.gridx = 1;
        panelModificarProfesor.add(new JLabel("Segundo apellido del profesor"), m);

        m.gridx++;
        txtApellido2ProfeModificarProfe = new JTextField();
        txtApellido2ProfeModificarProfe.setEditable(false);
        panelModificarProfesor.add(txtApellido2ProfeModificarProfe, m);

        m.gridy = 6;
        m.gridx = 1;
        btnVolverAgregarProfesor = new JButton("Volver a profesores");
        panelModificarProfesor.add(btnVolverAgregarProfesor, m);

        m.gridx++;
        btnModificarInformacionProfesor = new JButton("Modificar informacion del profesor");
        btnModificarInformacionProfesor.setEnabled(false);
        panelModificarProfesor.add(btnModificarInformacionProfesor, m);
    }
    //Panel para mostrar la informacion del profesor
    public void mostrarInformacionProfesor() {
        panelMostrarInformacionProfesor = new JPanel(new GridBagLayout());
        panelMostrarInformacionProfesor.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Mostrar la informacion del profesor",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        m.gridy = 0;
        m.gridx = 0;
        lblEscribirUniMostrarProfesor = new JLabel("Digite el nombre de la universidad a la cual pertenece el profesor");
        panelMostrarInformacionProfesor.add(lblEscribirUniMostrarProfesor, m);
        //Agregando los componentes al panel
        m.gridx++;
        txtBuscarUniMostrarProfesor = new JTextField(15);
        panelMostrarInformacionProfesor.add(txtBuscarUniMostrarProfesor, m);

        m.gridx++;
        btnBuscarUniMostrarProfesor = new JButton("Buscar universidad");
        panelMostrarInformacionProfesor.add(btnBuscarUniMostrarProfesor, m);

        m.gridy++;
        m.gridx = 0;
        lblEscribirProfesorMostrarProfesor = new JLabel("Digite el numero de cedula del profesor para mostrar su informacion");
        lblEscribirProfesorMostrarProfesor.setVisible(false);
        panelMostrarInformacionProfesor.add(lblEscribirProfesorMostrarProfesor, m);

        m.gridx++;
        txtBuscarProfesorMostrarProfesor = new JTextField(15);
        txtBuscarProfesorMostrarProfesor.setVisible(false);
        panelMostrarInformacionProfesor.add(txtBuscarProfesorMostrarProfesor, m);

        m.gridx++;
        btnBuscarProfesorMostrarProfesor = new JButton("Buscar profesor");
        btnBuscarProfesorMostrarProfesor.setVisible(false);
        panelMostrarInformacionProfesor.add(btnBuscarProfesorMostrarProfesor, m);

        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 3;
        jtaMostrarInformacionProfesor = new JTextArea();
        jtaMostrarInformacionProfesor.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaMostrarInformacionProfesor);
        scrollPane.setPreferredSize(new Dimension(0, 100)); // Cambia 150 por la altura deseada
        panelMostrarInformacionProfesor.add(scrollPane, m);

        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 1;
        btnVolverAgregarProfesorDesdeMostrarProfesor = new JButton("Volver a agregar profesores");
        panelMostrarInformacionProfesor.add(btnVolverAgregarProfesorDesdeMostrarProfesor, m);

        m.gridx++;
        m.gridwidth = 2;
        btnBuscarOtraUniMostrarProfesor = new JButton("Buscar un profesor en otra universidad");
        btnBuscarOtraUniMostrarProfesor.setVisible(false);
        panelMostrarInformacionProfesor.add(btnBuscarOtraUniMostrarProfesor, m);
    }
    //Panel para la lista de profesores de una escuela
    public void ListaProfesDeUnaEscuela() {
        panelListaProfesDeUnaEscuela = new JPanel(new GridBagLayout());
        panelListaProfesDeUnaEscuela.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)),
                "Lista de profesores de una escuela",
                TitledBorder.CENTER, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 36), Color.WHITE));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10);
        m.fill = GridBagConstraints.HORIZONTAL;

        //agrega los componenentes al panel

        m.gridx = 0;
        m.gridy = 0;
        panelListaProfesDeUnaEscuela.add(new JLabel("Digite el nombre de la universidad:"), m);

        m.gridx = 1;
        txtListaProfesDeUnaEscuela = new JTextField(20);
        panelListaProfesDeUnaEscuela.add(txtListaProfesDeUnaEscuela, m);

//  Botón buscar universidad
        m.gridx = 0;
        m.gridy = 1;
        m.gridwidth = 2;
        btnBuscarUListaProfesDeUnaEscuela = new JButton("Buscar universidad");
        panelListaProfesDeUnaEscuela.add(btnBuscarUListaProfesDeUnaEscuela, m);

        m.gridy = 2;
        m.gridwidth = 1;
        m.gridx = 0;
        panelListaProfesDeUnaEscuela.add(new JLabel("Seleccione una escuela:"), m);

        m.gridx = 1;
        cbListaEscuelas = new JComboBox<>();
        cbListaEscuelas.addItem(null);
        panelListaProfesDeUnaEscuela.add(cbListaEscuelas, m);

        //boton para mostrar la lista de profesores
        m.gridx = 0;
        m.gridy = 3;
        m.gridwidth = 2;
        btnMostrarListaProfesDeUnaEscuela = new JButton("Mostrar lista de profesores");
        panelListaProfesDeUnaEscuela.add(btnMostrarListaProfesDeUnaEscuela, m);


        m.gridx = 0;
        m.gridy = 4;
        m.gridwidth = 2;
        m.fill = GridBagConstraints.BOTH;
        m.weightx = 1.0;
        m.weighty = 1.0;

        jtaListaProfesDeUnaEscuela = new JTextArea(10, 30);
        jtaListaProfesDeUnaEscuela.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaListaProfesDeUnaEscuela);
        panelListaProfesDeUnaEscuela.add(scrollPane, m);


        m.gridx = 0;
        m.gridy = 5;
        m.gridwidth = 2;
        m.fill = GridBagConstraints.NONE;
        m.anchor = GridBagConstraints.CENTER;
        m.weighty = 0;
        //Boton para volver a la lista de profesores
        btnVolverListaProfesDeUnaEscuela = new JButton("Volver");
        panelListaProfesDeUnaEscuela.add(btnVolverListaProfesDeUnaEscuela, m);


    }
    //Panel asignar el profesor a un curso
    public void asignarProfesorCurso() {
        panelAsignarProfeCurso = new JPanel(new GridBagLayout());
        panelAsignarProfeCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "asignar profesor a curso",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        panelAsignarProfeCurso = new JPanel(new GridBagLayout());
        panelAsignarProfeCurso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Asignar profesor a curso",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10);
        m.fill = GridBagConstraints.HORIZONTAL;

// Label universidad
        m.gridx = 0;
        m.gridy = 0;
        panelAsignarProfeCurso.add(new JLabel("Digite el nombre de la universidad:"), m);

// TextField universidad
        m.gridx = 1;
        txtBuscarUniversidad = new JTextField(20);
        panelAsignarProfeCurso.add(txtBuscarUniversidad, m);

//  Botón buscar universidad
        m.gridx = 0;
        m.gridy = 1;
        btnBuscarUniverdad = new JButton("Buscar");
        panelAsignarProfeCurso.add(btnBuscarUniverdad, m);

//  Botón volver
        m.gridx = 1;
        btnVolverr = new JButton("Volver");
        panelAsignarProfeCurso.add(btnVolverr, m);

//  Label seleccionar profesor
        m.gridx = 0;
        m.gridy = 2;
        panelAsignarProfeCurso.add(new JLabel("Seleccione un profesor:"), m);

// ComboBox profesores
        m.gridx = 1;
        cbListaProfes = new JComboBox<>();
        cbListaProfes.addItem(null);
        panelAsignarProfeCurso.add(cbListaProfes, m);

//  Label seleccionar curso
        m.gridx = 0;
        m.gridy = 3;
        panelAsignarProfeCurso.add(new JLabel("Seleccione un curso:"), m);

//  ComboBox cursos
        m.gridx = 1;
        cbListaCursos = new JComboBox<>();
        cbListaCursos.addItem(null);
        panelAsignarProfeCurso.add(cbListaCursos, m);

//  ComboBox grupo/s del curso
        m.gridx = 0;
        m.gridy = 4;
        panelAsignarProfeCurso.add(new JLabel("Seleccione un grupo del curso donde se asignara el profesor"), m);

//
        m.gridx++;
        cbGruposDelCurso = new JComboBox<>();
        panelAsignarProfeCurso.add(cbGruposDelCurso, m);

//  Botón asignar profesor
        m.gridx = 0;
        m.gridy = 5;
        btnAsignarProfeCurso = new JButton("Asignar profesor");
        panelAsignarProfeCurso.add(btnAsignarProfeCurso, m);

//  Botón desasignar profesor
        m.gridx = 1;
        btnDesasignarProfeCurso = new JButton("Desasignar profesor");
        panelAsignarProfeCurso.add(btnDesasignarProfeCurso, m);

//  Botón ir a lista de cursos asignados
        m.gridx = 0;
        m.gridy = 6;

        btnIrListaCurososAsigandosProfesor = new JButton("Ir a lista de cursos asignados al profesor");
        panelAsignarProfeCurso.add(btnIrListaCurososAsigandosProfesor, m);
//  lista de profesores en una escuela
        m.gridx = 1;
        btnIrListaProfesDeUnaEscuela = new JButton("Ir a lista de profesores de una escuela");
        panelAsignarProfeCurso.add(btnIrListaProfesDeUnaEscuela, m);
    }
    //Panel para mostrar la lista de los cursos asignados a un profesor
    public void mostrarListaCursosAsignadosProfesor() {
        panelListaCursosAsignadosProfesor = new JPanel(new GridBagLayout());
        panelListaCursosAsignadosProfesor.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Cursos asignados al profesor",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10);
        m.fill = GridBagConstraints.HORIZONTAL;
//Agregando los commponentes al panel:

// Label universidad
        m.gridx = 0;
        m.gridy = 0;
        panelListaCursosAsignadosProfesor.add(new JLabel("Digite el nombre de la universidad:"), m);

//  TextField universidad
        m.gridx = 0;
        m.gridy = 1;
        txtBucarUniversidadListaCursosAsignadosProfesor = new JTextField(20);
        panelListaCursosAsignadosProfesor.add(txtBucarUniversidadListaCursosAsignadosProfesor, m);

//  Botón buscar
        m.gridx = 0;
        m.gridy = 2;
        btnBuscarUniversidadListaCursosAsignadosProfesor = new JButton("Buscar");
        panelListaCursosAsignadosProfesor.add(btnBuscarUniversidadListaCursosAsignadosProfesor, m);

//  Label profesor
        m.gridx = 0;
        m.gridy = 3;
        panelListaCursosAsignadosProfesor.add(new JLabel("Seleccione un profesor:"), m);

//  ComboBox profesores
        m.gridx = 0;
        m.gridy = 4;
        cbListaProfes2 = new JComboBox<>();
        cbListaProfes2.addItem(null);
        panelListaCursosAsignadosProfesor.add(cbListaProfes2, m);

// Botón mostrar lista de cursos asignados
        m.gridx = 0;
        m.gridy = 5;
        btnMostrarListaCursosAsignadosProfesor = new JButton("Mostrar lista de cursos asignados al profesor");
        panelListaCursosAsignadosProfesor.add(btnMostrarListaCursosAsignadosProfesor, m);

//  Botón volver
        m.gridx = 0;
        m.gridy = 6;
        btnVolverUniversidadListaCursosAsignadosProfesor = new JButton("Volver");
        panelListaCursosAsignadosProfesor.add(btnVolverUniversidadListaCursosAsignadosProfesor, m);
        m.gridx = 1;
        m.gridwidth = 2;
        jtaCursosAsignadosProfesor = new JTextArea();
        panelListaCursosAsignadosProfesor.add(jtaCursosAsignadosProfesor);
    }
    //Panel de la consulta general de profesores
    public void crearPanelConsultaGeneralP() {
        panelConsultaGeneralProfesores = new JPanel(new GridBagLayout());
        panelConsultaGeneralProfesores.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE), "Consulta General de Profesores",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14)));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(10, 10, 10, 10); // espacio entre componentes
        m.fill = GridBagConstraints.HORIZONTAL;
        //agregando los componentes al panel:

        //ComboBox para la realizar la consulta
        m.gridx = 0;
        m.gridy = 0;
        m.gridwidth = 2;
        cbConsultaGeneralProfes = new JComboBox<>(new String[]{
                "Profesores de un curso",
                "Lista de cursos con profesores",
                "Escuela con detalles de cursos y profesores"
        });
        panelConsultaGeneralProfesores.add(cbConsultaGeneralProfes, m);

        m.gridy = 1;
        m.gridwidth = 2;
        jtaMostrarConsultaGeneralProfes = new JTextArea(20, 40);
        jtaMostrarConsultaGeneralProfes.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaMostrarConsultaGeneralProfes);
        panelConsultaGeneralProfesores.add(scrollPane, m);


        m.gridy = 2;
        m.gridx = 0;
        m.gridwidth = 1;
        btnConsultaGeneralProfes = new JButton("Consultar");
        panelConsultaGeneralProfesores.add(btnConsultaGeneralProfes, m);

        m.gridx = 1;
        btnVolverAPanelUni = new JButton("Volver a gestionar profesores");
        panelConsultaGeneralProfesores.add(btnVolverAPanelUni, m);
    }

    //punto 4, cuarto avence
    //Panel para gestionar los estudiantes
    public void gestionarEstudiante() {
        panelGestionarEstudiantes = new JPanel(new GridBagLayout());
        panelGestionarEstudiantes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Seleccione que desea hacer",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        //Agregando los componenetes al panel
        m.gridx = 0;
        m.gridy = 1;
        btnVolverAgregarUniDesdeGestionarEstudiantes = new JButton("Volver");
        panelGestionarEstudiantes.add(btnVolverAgregarUniDesdeGestionarEstudiantes, m);

        m.gridx++;
        m.gridy = 0;
        panelGestionarEstudiantes.add(new JLabel("Agregar / Mostrar datos / Modificar estudiantes / Consulta general estudiantil"), m);

        m.gridy++;
        btnIrAgregarEstudiante = new JButton("agregar estudiante");
        panelGestionarEstudiantes.add(btnIrAgregarEstudiante, m);

        m.gridy++;
        btnIrMostrarInformacionEstudiante = new JButton("mostrar informacion de estudiantes");
        panelGestionarEstudiantes.add(btnIrMostrarInformacionEstudiante, m);
        m.gridy++;
        btnIrModificarEstudiante = new JButton("modificar estudiante");
        panelGestionarEstudiantes.add(btnIrModificarEstudiante, m);

        m.gridx++;
        m.gridy = 0;
        panelGestionarEstudiantes.add(new JLabel("Matricular / Consultar aranceles / Consulta general estudiantil"), m);

        m.gridy++;
        btnMatriculaIr = new JButton("Matricular estudiante");
        panelGestionarEstudiantes.add(btnMatriculaIr, m);

        m.gridy++;
        //boton para el calculo de aranceles
        btnArancelesIr = new JButton("consulta de aranceles");
        panelGestionarEstudiantes.add(btnArancelesIr, m);

        //boton para ir a la consulta general
        m.gridy++;
        btnIrConsultaGenEstudiante = new JButton("consulta general estudiantil");
        panelGestionarEstudiantes.add(btnIrConsultaGenEstudiante,m);
    }
    //Panel para agregar estudiantes
    public void agregarEstudiantes() {
        panelAgregarEstudiantes = new JPanel(new GridBagLayout());
        panelAgregarEstudiantes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Seleccione que desea hacer",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;
        //Agregando los componenetes al panel
        m.gridx = 0;
        m.gridy = 0;

        panelAgregarEstudiantes.add(new JLabel("Digite el nombre de la universidad donde se agregara el estudiante"), m);

        m.gridx++;
        txtBuscarUniAgregarEstudiante = new JTextField(15);
        panelAgregarEstudiantes.add(txtBuscarUniAgregarEstudiante, m);

        m.gridx++;
        btnBuscarUniAgregarEstudiante = new JButton("Buscar universidad");
        panelAgregarEstudiantes.add(btnBuscarUniAgregarEstudiante, m);
//1. numero de cedula del estudiante
        m.gridy++;
        m.gridx = 1;
        panelAgregarEstudiantes.add(new JLabel("Numero de cedula del estudiante"), m);

        m.gridx++;
        txtNumeroCedulaEstudiante = new JTextField();
        txtNumeroCedulaEstudiante.setEditable(false);
        panelAgregarEstudiantes.add(txtNumeroCedulaEstudiante, m);
//2. Numero de carnet del estudiante
        m.gridy++;
        m.gridx = 1;
        panelAgregarEstudiantes.add(new JLabel("Numero de carnet del estudiante"), m);

        m.gridx++;
        txtNumeroCarnetEstudiante = new JTextField();
        txtNumeroCarnetEstudiante.setEditable(false);
        panelAgregarEstudiantes.add(txtNumeroCarnetEstudiante, m);
//3. Nombre del estudiante
        m.gridy++;
        m.gridx = 1;
        panelAgregarEstudiantes.add(new JLabel("Nombre del estudiante"), m);

        m.gridx++;
        txtNombreEstudiante = new JTextField();
        txtNombreEstudiante.setEditable(false);
        panelAgregarEstudiantes.add(txtNombreEstudiante, m);
//4. Primer apellido del estudiante
        m.gridy++;
        m.gridx = 1;
        panelAgregarEstudiantes.add(new JLabel("Primer apellido del estudiante"), m);

        m.gridx++;
        txtApellido1Estudiante = new JTextField();
        txtApellido1Estudiante.setEditable(false);
        panelAgregarEstudiantes.add(txtApellido1Estudiante, m);
//4. Segundo apellido del estudiante
        m.gridy++;
        m.gridx = 1;
        panelAgregarEstudiantes.add(new JLabel("Segundo apellido del estudiante"), m);

        m.gridx++;
        txtApellido2Estudiante = new JTextField();
        txtApellido2Estudiante.setEditable(false);
        panelAgregarEstudiantes.add(txtApellido2Estudiante, m);
        //ComboBox para seleccionar la nacionalidad del estudiante
        m.gridy++;
        m.gridx = 2;
        cbEscogerNacionalidad = new JComboBox<>();
        cbEscogerNacionalidad.addItem("Nacional");
        cbEscogerNacionalidad.addItem("Extranjero");
        cbEscogerNacionalidad.setEnabled(false);
        panelAgregarEstudiantes.add(cbEscogerNacionalidad, m);
        //ComboBox para seleccionar la cantidad de beca al estudiante
        m.gridy++;
        m.gridx = 2;
        cbEscogerCantidadBeca = new JComboBox<>();
        cbEscogerCantidadBeca.addItem("0%");
        cbEscogerCantidadBeca.addItem("20%");
        cbEscogerCantidadBeca.addItem("40%");
        cbEscogerCantidadBeca.addItem("60%");
        cbEscogerCantidadBeca.addItem("80%");
        cbEscogerCantidadBeca.addItem("100%");
        cbEscogerCantidadBeca.setEnabled(false);
        panelAgregarEstudiantes.add(cbEscogerCantidadBeca, m);

        //Boton para volver al panel de Gestion Estudiantil
        m.gridy++;
        m.gridx = 0;
        btnVolverGestionarEstudiantesDesdeAgregarEstudiante = new JButton("Volver");
        panelAgregarEstudiantes.add(btnVolverGestionarEstudiantesDesdeAgregarEstudiante, m);
//Boton para agregar estudiante
        m.gridx = 1;
        m.gridwidth = 2;
        btnAgregarEstudiante = new JButton("Agregar estudiante");
        btnAgregarEstudiante.setEnabled(false);
        panelAgregarEstudiantes.add(btnAgregarEstudiante, m);
    }
    //Panel para mostrar la informacion estudiantil
    public void mostrarInformacionEstudiante() {
        panelMostrarInformacionEstudiante = new JPanel(new GridBagLayout());
        panelMostrarInformacionEstudiante.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Seleccione que desea hacer",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;
        //Agregando los componentes
        m.gridx = 0;
        m.gridy = 0;
        lblEscribirUniMostrarInfoEstudiante = new JLabel("Digite el nombre de la universidad donde se buscara el estudiante");
        panelMostrarInformacionEstudiante.add(lblEscribirUniMostrarInfoEstudiante, m);

        m.gridx++;
        txtBuscarUniMostrarInfoEstudiante = new JTextField(15);
        panelMostrarInformacionEstudiante.add(txtBuscarUniMostrarInfoEstudiante, m);

        m.gridx++;
        btnBuscarUniMostrarInfoEstudiante = new JButton("Buscar universidad");
        panelMostrarInformacionEstudiante.add(btnBuscarUniMostrarInfoEstudiante, m);

        m.gridy++;
        m.gridx = 0;
        lblEscribirCedulaCarnetMostrarInfoEstudiante = new JLabel("Escriba la cedula o carnet del estudiante para mostrar su informacion");
        lblEscribirCedulaCarnetMostrarInfoEstudiante.setVisible(false);
        panelMostrarInformacionEstudiante.add(lblEscribirCedulaCarnetMostrarInfoEstudiante, m);

        m.gridx++;
        txtBuscarEstConCedulaCarnetMostrarInfoEst = new JTextField(15);
        txtBuscarEstConCedulaCarnetMostrarInfoEst.setVisible(false);
        panelMostrarInformacionEstudiante.add(txtBuscarEstConCedulaCarnetMostrarInfoEst, m);

        m.gridx++;
        btnBuscarEstConCedulaCarnetMostrarInfoEst = new JButton("Buscar estudiante");
        btnBuscarEstConCedulaCarnetMostrarInfoEst.setVisible(false);
        panelMostrarInformacionEstudiante.add(btnBuscarEstConCedulaCarnetMostrarInfoEst, m);

        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 3;
        jtaMostrarInformacionEstudiante = new JTextArea();
        jtaMostrarInformacionEstudiante.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaMostrarInformacionEstudiante);
        scrollPane.setPreferredSize(new Dimension(0, 100)); // Cambia 150 por la altura deseada
        panelMostrarInformacionEstudiante.add(scrollPane, m);

        m.gridy++;
        m.gridx = 0;
        m.gridwidth = 1;
        btnVolverGestionarEstudiantesDesdeMostraInforEst = new JButton("Volver");
        panelMostrarInformacionEstudiante.add(btnVolverGestionarEstudiantesDesdeMostraInforEst, m);

        m.gridx++;
        m.gridwidth = 2;
        btnBuscarOtraUniMostrarInfoEst = new JButton("Buscar otra estudiantes en otra universidad");
        btnBuscarOtraUniMostrarInfoEst.setEnabled(false);
        panelMostrarInformacionEstudiante.add(btnBuscarOtraUniMostrarInfoEst, m);
    }
    //Panel para modificar al estudiante
    public void modificarEstudiante() {
        panelModificarEstudiante = new JPanel(new GridBagLayout());
        panelModificarEstudiante.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Modificar la información de un estudiante",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        m.gridx = 0;
        m.gridy = 0;
        panelModificarEstudiante.add(new JLabel("Digite el nombre de la universidad donde se buscara el estudiante"), m);

        m.gridx++;
        txtBuscarUniModificarEstudiante = new JTextField(15);
        panelModificarEstudiante.add(txtBuscarUniModificarEstudiante, m);

        m.gridx++;
        btnBuscarUniModificarEstudiante = new JButton("Buscar universidad");
        panelModificarEstudiante.add(btnBuscarUniModificarEstudiante, m);

        m.gridx = 0;
        m.gridy++;
        panelModificarEstudiante.add(new JLabel("Escriba la cedula o carnet del estudiante para modificar su informacion"), m);

        m.gridx++;
        txtBuscarEstudianteModificarEstudiante = new JTextField(15);
        txtBuscarEstudianteModificarEstudiante.setEditable(false);
        panelModificarEstudiante.add(txtBuscarEstudianteModificarEstudiante, m);

        m.gridx++;
        btnEcontrarEstudianteConCarnetCedula = new JButton("Buscar estudiante");
        btnEcontrarEstudianteConCarnetCedula.setEnabled(false);
        panelModificarEstudiante.add(btnEcontrarEstudianteConCarnetCedula, m);

        m.gridx = 1;
        m.gridy++;
        panelModificarEstudiante.add(new JLabel("Nombre del estudiante"), m);

        m.gridx++;
        txtNombreModificarEstudiante = new JTextField();
        txtNombreModificarEstudiante.setEditable(false);
        panelModificarEstudiante.add(txtNombreModificarEstudiante, m);

        m.gridy++;
        m.gridx = 1;
        panelModificarEstudiante.add(new JLabel("Primer apellido del estudiante"), m);

        m.gridx++;
        txtApellido1ModificarEstudiante = new JTextField();
        txtApellido1ModificarEstudiante.setEditable(false);
        panelModificarEstudiante.add(txtApellido1ModificarEstudiante, m);

        m.gridy++;
        m.gridx = 1;
        panelModificarEstudiante.add(new JLabel("Segundo apellido del estudiante"), m);

        m.gridx++;
        txtApellido2ModificarEstudiante = new JTextField();
        txtApellido2ModificarEstudiante.setEditable(false);
        panelModificarEstudiante.add(txtApellido2ModificarEstudiante, m);

        // Nacionalidad
        m.gridy++;
        m.gridx = 1;
        panelModificarEstudiante.add(new JLabel("Nacionalidad del estudiante"), m);

        m.gridx++;
        cbNacionalidadEstudianteModificarEstudiante = new JComboBox<>();
        cbNacionalidadEstudianteModificarEstudiante.addItem("Nacional");
        cbNacionalidadEstudianteModificarEstudiante.addItem("Extranjero");
        cbNacionalidadEstudianteModificarEstudiante.setEnabled(false);
        panelModificarEstudiante.add(cbNacionalidadEstudianteModificarEstudiante, m);

        // Beca
        m.gridy++;
        m.gridx = 1;
        panelModificarEstudiante.add(new JLabel("Cantidad de beca"), m);

        m.gridx++;
        cbCantidadBecaModificarEstudiante = new JComboBox<>();
        cbCantidadBecaModificarEstudiante.addItem("0%");
        cbCantidadBecaModificarEstudiante.addItem("20%");
        cbCantidadBecaModificarEstudiante.addItem("40%");
        cbCantidadBecaModificarEstudiante.addItem("60%");
        cbCantidadBecaModificarEstudiante.addItem("80%");
        cbCantidadBecaModificarEstudiante.addItem("100%");
        cbCantidadBecaModificarEstudiante.setEnabled(false);
        panelModificarEstudiante.add(cbCantidadBecaModificarEstudiante, m);

        // Botones finales
        m.gridy++;
        m.gridx = 0;
        btnVolverGestionarEstudiantesDesdeModificarEstudiante = new JButton("Volver");
        panelModificarEstudiante.add(btnVolverGestionarEstudiantesDesdeModificarEstudiante, m);

        m.gridx++;
        m.gridwidth = 2;
        btnModificarEstudiante = new JButton("Modificar estudiante");
        btnModificarEstudiante.setEnabled(false);
        panelModificarEstudiante.add(btnModificarEstudiante, m);

    }

    // panel matricula del estudiante
    public void panelMatricularEstudiante() {
        panelMatricularEstudiante = new JPanel(new GridBagLayout());
        panelMatricularEstudiante.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215)), "Seleccione que desea hacer",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));

        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        int fila = 0;

        // Universidad
        m.gridx = 0;
        m.gridy = fila;
        panelMatricularEstudiante.add(new JLabel("Digite el nombre de la universidad:"), m);

        m.gridx = 1;
        txtBuscarUMatriculaEstudiante = new JTextField(15);
        panelMatricularEstudiante.add(txtBuscarUMatriculaEstudiante, m);

        m.gridx = 2;
        btnMatricularBuscar = new JButton("Buscar universidad");
        panelMatricularEstudiante.add(btnMatricularBuscar, m);

        // Estudiante
        fila++;
        m.gridy = fila;
        m.gridx = 1;
        panelMatricularEstudiante.add(new JLabel("Estudiante:"), m);

        m.gridx = 2;
        cbListaEstudiantes = new JComboBox<>();
        cbListaEstudiantes.setPreferredSize(new Dimension(150, 25));
        cbListaEstudiantes.addItem(null);
        panelMatricularEstudiante.add(cbListaEstudiantes, m);

        // Curso
        fila++;
        m.gridy = fila;
        m.gridx = 1;
        panelMatricularEstudiante.add(new JLabel("Curso:"), m);

        m.gridx = 2;
        cbListaCursos2 = new JComboBox<>();
        cbListaCursos2.setPreferredSize(new Dimension(150, 25));
        cbListaCursos2.addItem(null);
        panelMatricularEstudiante.add(cbListaCursos2, m);

        // Grupo
        fila++;
        m.gridy = fila;
        m.gridx = 1;
        panelMatricularEstudiante.add(new JLabel("Grupo:"), m);

        m.gridx = 2;
        cbGruposDelCurso2 = new JComboBox<>();
        cbGruposDelCurso2.setPreferredSize(new Dimension(150, 25));
        cbGruposDelCurso2.addItem(null);
        panelMatricularEstudiante.add(cbGruposDelCurso2, m);

        // Botones de acción
        fila++;
        m.gridy = fila;
        m.gridx = 0;
        btnMatricular = new JButton("Matricular estudiante");
        panelMatricularEstudiante.add(btnMatricular, m);

        m.gridx = 1;
        btnDesMatricular = new JButton("Desmatricular estudiante");
        panelMatricularEstudiante.add(btnDesMatricular, m);

        m.gridx = 2;
        btnMatriculaVolver = new JButton("Volver a gestionar estudiantes");
        panelMatricularEstudiante.add(btnMatriculaVolver, m);
    }




    //Panel para el calculo de aranceles al estudiante
    public void calculoDeAranceles() {
        panelCalculoAranceles = new JPanel(new GridBagLayout());
        panelCalculoAranceles.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 120, 215)), "Bienvenido al calculo de aranceles :D",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), Color.WHITE));
        GridBagConstraints m = new GridBagConstraints();
        m.insets = new Insets(20, 20, 20, 20);
        m.fill = GridBagConstraints.HORIZONTAL;

        panelCalculoAranceles.add(new JLabel("Escriba el nombre de la Universidad"), m);
        txtCalculoArancelesBuscarU = new JTextField(15);
        panelCalculoAranceles.add(txtCalculoArancelesBuscarU, m);
        m.gridy = 1;
        panelCalculoAranceles.add(new JLabel("Escriba el ID del estudiante"), m);
        txtCalculoArancelesBuscarID = new JTextField(15);
        panelCalculoAranceles.add(txtCalculoArancelesBuscarID, m);

        m.gridx = 2;
        btnArancelesMostrar = new JButton("Mostrar todos los calculos");
        panelCalculoAranceles.add(btnArancelesMostrar, m);
        m.gridx = 3;
        btnAraancelesVolver = new JButton("Volver");
        panelCalculoAranceles.add(btnAraancelesVolver, m);
    }

    //panel de consulta general de estudiantes
    public void consultaGeneralEstudiantil() {
        panelListaGeneralEstudiantil = new JPanel(new GridBagLayout());
        panelListaGeneralEstudiantil.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE),
                "Consulta General de Estudiantes por Curso",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 14)));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;

        // ComboBox para seleccionar la consulta
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        cbConsultaGeneralEstudiantesporCurso = new JComboBox<>(new String[]{
                "Estudiantes nacionales por curso",
                "Estudiantes extranjeros por curso",
                "Todos los estudiantes por curso"
        });
        panelListaGeneralEstudiantil.add(cbConsultaGeneralEstudiantesporCurso, c);

        // JTextArea para mostrar el resultado
        c.gridy = 1;
        c.gridwidth = 2;
        jtaMostrarConsultaGeneralEstudiantes = new JTextArea(20, 40);
        jtaMostrarConsultaGeneralEstudiantes.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaMostrarConsultaGeneralEstudiantes);
        panelListaGeneralEstudiantil.add(scrollPane, c);

        // Botón de consulta
        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = 1;
        btnConsultaGeneralEstudianteLista = new JButton("Consultar");
        panelListaGeneralEstudiantil.add(btnConsultaGeneralEstudianteLista, c);

        // Botón para volver
        c.gridx = 1;
        btnVolverAGestionarEstudiantes = new JButton("Volver a gestionar estudiantes");
        panelListaGeneralEstudiantil.add(btnVolverAGestionarEstudiantes, c);
        c.gridy = 0;
        c.gridx = 2;
        btnMostrarGrupos = new JButton("Mostrar todos los grupos");
        panelListaGeneralEstudiantil.add(btnMostrarGrupos, c);
        c.gridy = 1;
        c.gridx = 2;
        jtaMostrarGrupos = new JTextArea(20, 40);
        jtaMostrarGrupos.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(jtaMostrarGrupos);
        panelListaGeneralEstudiantil.add(scrollPane2, c);


    }

    //gets para acceder a al componente comboBox
    public JComboBox<String> getCbConsultaGeneralEstudiantesporCurso(){
        return cbConsultaGeneralEstudiantesporCurso;
    }

    public JComboBox<String> getCbCantidadBecaModificarEstudiante(){
        return cbCantidadBecaModificarEstudiante;
    }
}