package vista.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaPrincipal implements ActionListener {

	private JFrame frame;
	JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnComunidades;
	private JMenu mnCuentasBancarias;
	private JMenu mnFincas;
	private JMenu mnCuotas;
	private JMenu mnPropietario;
	
	private JMenu mnRecibos;
	private JMenu mnRecibo;
	
	private JMenu mnInformes;
	
	private JMenu mnAyuda;
	
	private JMenuItem mntmCrearComunidad;
	private JMenuItem mntmConsultarComunidades;
	private JMenuItem mntmCrearCuentaBancaria;
	private JMenuItem mntmConsultarCuentas;
	private JMenuItem mntmCrearFinca;
	private JMenuItem mntmConsultarFincas;
	private JMenuItem mntmCrearCuota;
	private JMenuItem mntmConsultarCuotas;
	private JMenuItem mntmCrearPropietario;
	private JMenuItem mntmConsultarPropietarios;
	private JMenuItem mntmCrearRecibo;
	private JMenuItem mntmConsultarRecibos;
	private JMenuItem reciboPend;
	private JPanel panel;
	private Toolkit miPantalla;
	Image miIcono;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Ventana Principal");
		frame.setSize(500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		//Cambiar Icono de Java.
		miPantalla = Toolkit.getDefaultToolkit();
		miIcono = miPantalla.getImage("src/graficos/icono.jpg");
		frame.setIconImage(miIcono);
		
		//Asigno una Barra de Menú al Frame.
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		//Asigno al la Barra de Menú los Menú de Mantenimiento, Comunidades, Cuentas bancarias, Fincas, Cuotas, y Propietarios
		//Y a estos les asigno sus diferentes Item con JmenuItem
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mnComunidades = new JMenu("Comunidades");
		mnMantenimiento.add(mnComunidades);

		mntmCrearComunidad = new JMenuItem("Crear Comunidad");
		mntmCrearComunidad.addActionListener(this);
		mnComunidades.add(mntmCrearComunidad);

		mntmConsultarComunidades = new JMenuItem("Consultar Comunidades");
		mntmConsultarComunidades.addActionListener(this);
		mnComunidades.add(mntmConsultarComunidades);

		mnCuentasBancarias = new JMenu("Cuentas Bancarias");
		mnMantenimiento.add(mnCuentasBancarias);

		mntmCrearCuentaBancaria = new JMenuItem("Crear Cuenta Bancaria");
		mntmCrearCuentaBancaria.addActionListener(this);
		mnCuentasBancarias.add(mntmCrearCuentaBancaria);

		mntmConsultarCuentas = new JMenuItem("Consultar Cuentas");
		mntmConsultarCuentas.addActionListener(this);
		mnCuentasBancarias.add(mntmConsultarCuentas);

		mnFincas = new JMenu("Fincas");
		mnMantenimiento.add(mnFincas);

		mntmCrearFinca = new JMenuItem("Crear Finca");
		mntmCrearFinca.addActionListener(this);
		mnFincas.add(mntmCrearFinca);

		mntmConsultarFincas = new JMenuItem("Consultar Fincas");
		mntmConsultarFincas.addActionListener(this);
		mnFincas.add(mntmConsultarFincas);

		mnCuotas = new JMenu("Cuotas");
		mnMantenimiento.add(mnCuotas);

		mntmCrearCuota = new JMenuItem("Crear Cuota");
		mntmCrearCuota.addActionListener(this);
		mnCuotas.add(mntmCrearCuota);

		mntmConsultarCuotas = new JMenuItem("Consultar Cuotas");
		mntmConsultarCuotas.addActionListener(this);
		mnCuotas.add(mntmConsultarCuotas);

		mnPropietario = new JMenu("Propietario");
		mnMantenimiento.add(mnPropietario);

		mntmCrearPropietario = new JMenuItem("Crear Propietario");
		mntmCrearPropietario.addActionListener(this);
		mnPropietario.add(mntmCrearPropietario);

		mntmConsultarPropietarios = new JMenuItem("Consultar Propietarios");
		mntmConsultarPropietarios.addActionListener(this);
		mnPropietario.add(mntmConsultarPropietarios);

		mnRecibos = new JMenu("Recibos");
		menuBar.add(mnRecibos);
		
		mnRecibo = new JMenu("Recibo");
		mnRecibos.add(mnRecibo);
		
		mntmCrearRecibo = new JMenuItem(" Crear Recibo");
		mntmCrearRecibo.addActionListener(this);
		mnRecibo.add(mntmCrearRecibo);
		
		mntmConsultarRecibos = new JMenuItem("Consultar Recibos");
		mntmConsultarRecibos.addActionListener(this);
		mnRecibo.add(mntmConsultarRecibos);
		
		reciboPend = new JMenuItem("Recibos Pendientes");
		mnRecibo.add(reciboPend);
		
		mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		panel = new Background();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.repaint();
		panel.setVisible(true);
		frame.revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		frame.getContentPane().removeAll();

		if (event.getSource() == mntmCrearComunidad) {
			panel = new ComunidadForm();
		} else if (event.getSource() == mntmConsultarComunidades) {
			panel = new ComunidadConsulta();
		} else if (event.getSource() == mntmCrearCuentaBancaria) {
			panel = new BancoForm();
		} else if (event.getSource() == mntmConsultarCuentas) {
			panel = new BancoConsulta();
		} else if (event.getSource() == mntmCrearCuota) {
			panel = new CuotaForm();
		} else if (event.getSource() == mntmConsultarCuotas) {
			panel = new CuotaConsulta();
		} else if (event.getSource() == mntmCrearFinca) {
			panel = new FincaForm();
		} else if (event.getSource() == mntmConsultarFincas) {
			panel = new FincaConsulta();
		} else if (event.getSource() == mntmCrearPropietario) {
			panel = new PropietarioForm();
		} else if (event.getSource() == mntmConsultarPropietarios) {
			panel = new PropietarioConsulta();
		} else if (event.getSource() == mntmCrearRecibo){
			panel = new ReciboForm();
		} else if(event.getSource() == mntmConsultarRecibos){
			panel = new ReciboConsulta();
		}

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		frame.revalidate();
	}

}
