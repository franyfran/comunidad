package vista.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.bancario.Banco;
import modelo.dao.BancoDAO;

public class BancoForm extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5125990378766119597L;
	private JTextField tfNombre;
	private JTextField tfSucursal;
	private JTextField tfCuenta;
	private JButton btnCancelar;

	/**
	 * Create the application.
	 */
	public BancoForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setLayout(null);
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 20, 115, 20);
		this.add(lblNewLabel);

		JLabel label = new JLabel("Sucursal:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 55, 115, 20);
		this.add(label);

		JLabel label_1 = new JLabel("Nº de Cuenta:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 90, 115, 20);
		this.add(label_1);

		tfNombre = new JTextField();
		tfNombre.setBounds(130, 20, 194, 20);
		this.add(tfNombre);
		tfNombre.setColumns(10);

		tfSucursal = new JTextField();
		tfSucursal.setColumns(10);
		tfSucursal.setBounds(130, 55, 194, 20);
		this.add(tfSucursal);

		tfCuenta = new JTextField();
		tfCuenta.setColumns(10);
		tfCuenta.setBounds(130, 90, 194, 20);
		this.add(tfCuenta);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(110, 171, 90, 25);
		this.add(btnCancelar);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!tfNombre.getText().isEmpty() && !tfSucursal.getText().isEmpty() && !tfCuenta.getText().isEmpty()){
					Banco banco = new Banco(tfNombre.getText(),tfSucursal.getText(),tfCuenta.getText());
					BancoDAO dao = new BancoDAO();
					dao.alta(banco);
					if(banco.getIdCuentaBanco() != null){
						JOptionPane.showMessageDialog(null, "La cuenta ha sido dada de alta correctamente en el sistema.");
					} else{
						JOptionPane.showMessageDialog(null, "Error dando de alta la cuenta bancaria.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debes especificar todos los campos.");
				}

			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(234, 171, 90, 25);
		this.add(btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		this.revalidate();
	}
}
