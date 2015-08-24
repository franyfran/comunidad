package vista.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.bancario.Banco;
import modelo.comunidad.Comunidad;
import modelo.dao.BancoDAO;
import modelo.dao.ComunidadDAO;
import modelo.dao.CuotaDAO;
import modelo.dao.FincaDAO;
import modelo.dao.PropietarioDAO;
import modelo.propietario.Cuota;
import modelo.propietario.Finca;
import modelo.propietario.Propietario;

public class PropietarioForm extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7266154933143321042L;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfTelefono;
	private JButton btnAceptar;
	private JComboBox<Cuota> cbCuota;
	private JComboBox<Comunidad> cbComunidad;
	private JComboBox<Finca> cbFinca;
	private JComboBox<Banco> cbBanco;

	

	/**
	 * Create the application.
	 */
	public PropietarioForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 20, 115, 20);
		this.add(lblNewLabel);

		JLabel label = new JLabel("Apellidos:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 55, 115, 20);
		this.add(label);

		JLabel label_1 = new JLabel("Teléfono:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 90, 115, 20);
		this.add(label_1);

		JLabel lblCuota = new JLabel("Cuota:");
		lblCuota.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuota.setBounds(10, 125, 115, 20);
		this.add(lblCuota);

		JLabel lblComunidad = new JLabel("Comunidad:");
		lblComunidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComunidad.setBounds(10, 160, 115, 20);
		this.add(lblComunidad);

		JLabel lblFinca = new JLabel("Finca:");
		lblFinca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFinca.setBounds(10, 195, 115, 20);
		this.add(lblFinca);
		
		JLabel lblCuentaBanco = new JLabel("Cuenta Bancaria:");
		lblCuentaBanco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuentaBanco.setBounds(10, 230, 115, 20);
		this.add(lblCuentaBanco);

		tfNombre = new JTextField();
		tfNombre.setBounds(130, 20, 194, 20);
		this.add(tfNombre);
		// textField.setColumns(10);

		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(130, 55, 194, 20);
		this.add(tfApellidos);

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(130, 90, 194, 20);
		this.add(tfTelefono);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!tfNombre.getText().isEmpty()
						&& !tfApellidos.getText().isEmpty()
						&& !tfTelefono.getText().isEmpty()
						&& cbComunidad.getSelectedItem() != null
						&& cbCuota.getSelectedItem() != null
						&& cbFinca.getSelectedItem() != null
						&& cbBanco.getSelectedItem() != null) {
					Propietario propietario = new Propietario();
					propietario.setApellidosPropietario(tfApellidos.getText());
					propietario.setNombrePropietario(tfNombre.getText());
					propietario.setTelefono(tfTelefono.getText());
					propietario.setComunidad((Comunidad)cbComunidad.getSelectedItem());
					propietario.setCuota((Cuota)cbCuota.getSelectedItem());
					propietario.setFinca((Finca)cbFinca.getSelectedItem());
					propietario.setCuentaBanco((Banco) cbBanco.getSelectedItem());
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
		this.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(334, 194, 90, 25);
		this.add(btnCancelar);

		cbCuota = new JComboBox<Cuota>();
		cbCuota.setBounds(130, 125, 183, 20);
		this.add(cbCuota);
		cargarCuota();

		cbComunidad = new JComboBox<Comunidad>();
		cbComunidad.setBounds(130, 160, 183, 20);
		this.add(cbComunidad);
		cargarComunidad();

		cbFinca = new JComboBox<Finca>();
		cbFinca.setBounds(130, 195, 183, 20);
		this.add(cbFinca);
		cargarFinca();
		
		cbBanco = new JComboBox<Banco>();
		cbBanco.setBounds(130, 230, 194, 20);
		this.add(cbBanco);
		cargarBanco();
		

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
	
	void cargarBanco(){
		BancoDAO bancoDao = new BancoDAO();
		List<Banco> bancos = bancoDao.consultaAll();
		for(Banco banco : bancos){
			cbBanco.addItem(banco);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		this.revalidate();
		
	}
}
