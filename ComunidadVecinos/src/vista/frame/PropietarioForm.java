package vista.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.comunidad.Comunidad;
import modelo.dao.ComunidadDAO;
import modelo.dao.CuotaDAO;
import modelo.dao.FincaDAO;
import modelo.dao.PropietarioDAO;
import modelo.propietario.Cuota;
import modelo.propietario.Finca;
import modelo.propietario.Propietario;

public class PropietarioForm {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfTelefono;
	private JButton btnAceptar;
	private JComboBox<Cuota> cbCuota;
	private JComboBox<Comunidad> cbComunidad;
	private JComboBox<Finca> cbFinca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropietarioForm window = new PropietarioForm();
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
	public PropietarioForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Alta Propietario");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 20, 115, 20);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("Apellidos:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 55, 115, 20);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("Teléfono:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 90, 115, 20);
		frame.getContentPane().add(label_1);

		JLabel lblCuota = new JLabel("Cuota:");
		lblCuota.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuota.setBounds(10, 125, 115, 20);
		frame.getContentPane().add(lblCuota);

		JLabel lblComunidad = new JLabel("Comunidad:");
		lblComunidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComunidad.setBounds(10, 160, 115, 20);
		frame.getContentPane().add(lblComunidad);

		JLabel lblFinca = new JLabel("Finca:");
		lblFinca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFinca.setBounds(10, 195, 115, 20);
		frame.getContentPane().add(lblFinca);

		tfNombre = new JTextField();
		tfNombre.setBounds(130, 20, 194, 20);
		frame.getContentPane().add(tfNombre);
		// textField.setColumns(10);

		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(130, 55, 194, 20);
		frame.getContentPane().add(tfApellidos);

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(130, 90, 194, 20);
		frame.getContentPane().add(tfTelefono);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!tfNombre.getText().isEmpty()
						&& !tfApellidos.getText().isEmpty()
						&& !tfTelefono.getText().isEmpty()
						&& cbComunidad.getSelectedItem() != null
						&& cbCuota.getSelectedItem() != null
						&& cbFinca.getSelectedItem() != null) {
					Propietario propietario = new Propietario();
					propietario.setApellidosPropietario(tfApellidos.getText());
					propietario.setNombrePropietario(tfNombre.getText());
					propietario.setTelefono(tfTelefono.getText());
					propietario.setComunidad((Comunidad)cbComunidad.getSelectedItem());
					propietario.setCuota((Cuota)cbCuota.getSelectedItem());
					propietario.setFinca((Finca)cbFinca.getSelectedItem());
					PropietarioDAO pDAO = new PropietarioDAO();
					pDAO.alta(propietario);
					if(propietario.getIdPropietario() != null){
						JOptionPane.showMessageDialog(null, "El propietario ha sido dado de alta correctamente en el sistema.");
					} else{
						JOptionPane.showMessageDialog(null, "Error dando de alta propietario.");
					}
				} else{
					JOptionPane.showMessageDialog(null, "Debes especificar todos los campos.");
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(334, 138, 90, 25);
		frame.getContentPane().add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(334, 194, 90, 25);
		frame.getContentPane().add(btnCancelar);

		cbCuota = new JComboBox<Cuota>();
		cbCuota.setBounds(130, 125, 183, 20);
		frame.getContentPane().add(cbCuota);
		cargarCuota();

		cbComunidad = new JComboBox<Comunidad>();
		cbComunidad.setBounds(130, 160, 183, 20);
		frame.getContentPane().add(cbComunidad);
		cargarComunidad();

		cbFinca = new JComboBox<Finca>();
		cbFinca.setBounds(130, 195, 183, 20);
		frame.getContentPane().add(cbFinca);
		cargarFinca();
		frame.setLocationRelativeTo(null);
	}

	void cargarCuota() {
		CuotaDAO cDAO = new CuotaDAO();
		List<Cuota> cuotas = cDAO.consultaAll();
		for (Cuota c : cuotas) {
			cbCuota.addItem(c);
		}
	}

	void cargarFinca() {
		FincaDAO fDAO = new FincaDAO();
		List<Finca> fincas = fDAO.consultaAll();
		for (Finca f : fincas) {
			cbFinca.addItem(f);
		}
	}

	void cargarComunidad() {
		ComunidadDAO cDAO = new ComunidadDAO();
		List<Comunidad> comunidades = cDAO.consultaAll();
		for (Comunidad co : comunidades) {
			cbComunidad.addItem(co);
		}
	}
}
