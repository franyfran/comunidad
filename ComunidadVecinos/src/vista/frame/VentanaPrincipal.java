package vista.frame;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal implements ActionListener{

	private JFrame frame;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu Configuración = new JMenu("Configuración");
		menuBar.add(Configuración);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenu mnComunidades = new JMenu("Comunidades");
		mnMantenimiento.add(mnComunidades);
		
		mntmCrearComunidad = new JMenuItem("Crear Comunidad");
		mntmCrearComunidad.addActionListener(this);
		mnComunidades.add(mntmCrearComunidad);
		
		mntmConsultarComunidades = new JMenuItem("Consultar Comunidades");
		mntmConsultarComunidades.addActionListener(this);
		mnComunidades.add(mntmConsultarComunidades);
		
		JMenu mnCuentasBancarias = new JMenu("Cuentas Bancarias");
		mnMantenimiento.add(mnCuentasBancarias);
		
		mntmCrearCuentaBancaria = new JMenuItem("Crear Cuenta Bancaria");
		mntmCrearCuentaBancaria.addActionListener(this);
		mnCuentasBancarias.add(mntmCrearCuentaBancaria);
		
		mntmConsultarCuentas = new JMenuItem("Consultar Cuentas");
		mntmConsultarCuentas.addActionListener(this);
		mnCuentasBancarias.add(mntmConsultarCuentas);
		
		JMenu mnFincas = new JMenu("Fincas");
		mnMantenimiento.add(mnFincas);
		
		mntmCrearFinca = new JMenuItem("Crear Finca");
		mntmCrearFinca.addActionListener(this);
		mnFincas.add(mntmCrearFinca);
		
		mntmConsultarFincas = new JMenuItem("Consultar Fincas");
		mntmConsultarFincas.addActionListener(this);
		mnFincas.add(mntmConsultarFincas);
		
		JMenu mnCuotas = new JMenu("Cuotas");
		mnMantenimiento.add(mnCuotas);
		
		mntmCrearCuota = new JMenuItem("Crear Cuota");
		mntmCrearCuota.addActionListener(this);
		mnCuotas.add(mntmCrearCuota);
		
		mntmConsultarCuotas = new JMenuItem("Consultar Cuotas");
		mntmConsultarCuotas.addActionListener(this);
		mnCuotas.add(mntmConsultarCuotas);
		
		JMenu mnPropietario = new JMenu("Propietario");
		mnMantenimiento.add(mnPropietario);
		
		mntmCrearPropietario = new JMenuItem("Crear Propietario");
		mntmCrearPropietario.addActionListener(this);
		mnPropietario.add(mntmCrearPropietario);
		
		mntmConsultarPropietarios = new JMenuItem("Consultar Propietarios");
		mntmConsultarPropietarios.addActionListener(this);
		mnPropietario.add(mntmConsultarPropietarios);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Frame frame = null;
		
		if(event.getSource() == mntmCrearComunidad){
			 new ComunidadForm();
		} else if(event.getSource() == mntmConsultarComunidades){
			
		}else if(event.getSource() == mntmCrearCuentaBancaria){
			
		}else if(event.getSource() == mntmConsultarCuentas){
			
		}else if(event.getSource() == mntmCrearCuota){
			
		}else if(event.getSource() == mntmConsultarCuotas){
			
		}else if(event.getSource() == mntmCrearFinca){
			
		}else if(event.getSource() == mntmConsultarFincas){
			
		}else if(event.getSource() == mntmCrearPropietario){
			
		}else if(event.getSource() == mntmConsultarPropietarios){
			
		}
		
	}

}
