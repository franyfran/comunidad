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
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.bancario.Banco;
import modelo.comunidad.Comunidad;
import modelo.dao.BancoDAO;
import modelo.dao.ComunidadDAO;

public class ComunidadForm extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 32052937542943884L;
	private JTextField nombreEdificio;
	private JTextField nombreCalle;
	private JTextField numero;
	private JTextField puerta;
	private JTextField poblacion;
	private JTextField codigoPostal;
	private JTextField provincia;
	private JComboBox<Banco> listaBancos;

	/**
	 * Create the application.
	 */
	public ComunidadForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 350);
		this.setLayout(null);

		JLabel label = new JLabel("Nombre de Edificio:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 20, 115, 20);
		this.add(label);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCalle.setBounds(10, 55, 115, 20);
		this.add(lblCalle);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNmero.setBounds(10, 90, 115, 20);
		this.add(lblNmero);

		JLabel lblPlantaPuerta = new JLabel("Puerta:");
		lblPlantaPuerta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlantaPuerta.setBounds(10, 125, 115, 20);
		this.add(lblPlantaPuerta);

		JLabel lblPoblacin = new JLabel("Poblaci\u00F3n:");
		lblPoblacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPoblacin.setBounds(10, 160, 115, 20);
		this.add(lblPoblacin);

		JLabel lblCdigoPostal = new JLabel("C\u00F3digo Postal:");
		lblCdigoPostal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigoPostal.setBounds(10, 195, 115, 20);
		this.add(lblCdigoPostal);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProvincia.setBounds(10, 230, 115, 20);
		this.add(lblProvincia);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (this.validarEntrada()) {
					Comunidad comunidad = new Comunidad();
					comunidad.setNombreEdificio(nombreEdificio.getText());
					comunidad.setCalle(nombreCalle.getText());
					comunidad.setCodigoPostal(codigoPostal.getText());
					comunidad.setNumero(numero.getText());
					comunidad.setPoblacion(poblacion.getText());
					comunidad.setProvincia(provincia.getText());
					comunidad.setPuerta(puerta.getText());
					comunidad.setCuentaBanco((Banco) listaBancos.getSelectedItem());
					ComunidadDAO cdao = new ComunidadDAO();
					cdao.alta(comunidad);
					if(comunidad.getIdComunidad() != null){
						JOptionPane.showMessageDialog(null, "La Comunidad ha sido dada de alta correctamente en el sistema.");
					} else{
						JOptionPane.showMessageDialog(null, "Error dando de alta la Comunidad.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes especificar todos los campos.");
				}
			}

			private boolean validarEntrada() {
				return (!nombreEdificio.getText().isEmpty()
						&& !nombreCalle.getText().isEmpty()
						&& !numero.getText().isEmpty()
						&& !puerta.getText().isEmpty()
						&& !poblacion.getText().isEmpty()
						&& !codigoPostal.getText().isEmpty() && !provincia
						.getText().isEmpty() && listaBancos.getSelectedItem() != null);
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(335, 195, 90, 25);
		this.add(btnAceptar);

		nombreEdificio = new JTextField();
		nombreEdificio.setBounds(130, 20, 194, 20);
		this.add(nombreEdificio);
		nombreEdificio.setColumns(10);

		nombreCalle = new JTextField();
		nombreCalle.setColumns(10);
		nombreCalle.setBounds(130, 55, 194, 20);
		this.add(nombreCalle);

		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(130, 90, 194, 20);
		this.add(numero);

		puerta = new JTextField();
		puerta.setColumns(10);
		puerta.setBounds(130, 125, 194, 20);
		this.add(puerta);

		poblacion = new JTextField();
		poblacion.setColumns(10);
		poblacion.setBounds(130, 160, 194, 20);
		this.add(poblacion);

		codigoPostal = new JTextField();
		codigoPostal.setColumns(10);
		codigoPostal.setBounds(130, 195, 194, 20);
		this.add(codigoPostal);

		provincia = new JTextField();
		provincia.setColumns(10);
		provincia.setBounds(130, 230, 194, 20);
		this.add(provincia);

		JLabel lblBanco = new JLabel("Banco:");
		lblBanco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBanco.setBounds(10, 268, 115, 20);
		this.add(lblBanco);

		listaBancos = new JComboBox<Banco>();
		listaBancos.setBounds(130, 268, 194, 20);
		this.cargarComboBancos();
		this.add(listaBancos);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(335, 244, 90, 25);
		this.add(btnCancelar);
	}

	private void cargarComboBancos() {
		BancoDAO bancoDAO = new BancoDAO();
		List<Banco> bancos = bancoDAO.consultaAll();
		if (bancos != null) {
			for (Banco banco : bancos) {
				listaBancos.addItem(banco);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		this.revalidate();
		
	}
}
