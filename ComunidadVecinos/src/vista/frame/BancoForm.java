package vista.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.bancario.Banco;
import modelo.dao.BancoDAO;

public class BancoForm {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfSucursal;
	private JTextField tfCuenta;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoForm window = new BancoForm();
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
	public BancoForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Alta Banco");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 20, 115, 20);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("Sucursal:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 55, 115, 20);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("Nº de Cuenta:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 90, 115, 20);
		frame.getContentPane().add(label_1);

		tfNombre = new JTextField();
		tfNombre.setBounds(130, 20, 194, 20);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		tfSucursal = new JTextField();
		tfSucursal.setColumns(10);
		tfSucursal.setBounds(130, 55, 194, 20);
		frame.getContentPane().add(tfSucursal);

		tfCuenta = new JTextField();
		tfCuenta.setColumns(10);
		tfCuenta.setBounds(130, 90, 194, 20);
		frame.getContentPane().add(tfCuenta);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(110, 171, 90, 25);
		frame.getContentPane().add(btnCancelar);

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
		frame.getContentPane().add(btnAceptar);

		frame.setLocationRelativeTo(null);
	}
}
