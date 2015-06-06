package vista.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class LoginForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField tfUsuario;
	private JTextField tfContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelUsuario.setBounds(10, 45, 90, 30);
		frame.getContentPane().add(labelUsuario);
		
		JLabel labelContrasenia = new JLabel("Contrase\u00F1a:");
		labelContrasenia.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelContrasenia.setBounds(10, 95, 90, 30);
		frame.getContentPane().add(labelContrasenia);
		
		JButton btnAceptarLogin = new JButton("Aceptar");
		btnAceptarLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptarLogin.setBounds(131, 151, 90, 25);
		frame.getContentPane().add(btnAceptarLogin);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(95, 45, 180, 28);
		frame.getContentPane().add(tfUsuario);
		//tfUsuario.setColumns(1);
		
		tfContrasenia = new JTextField();
		tfContrasenia.setColumns(1);
		tfContrasenia.setBounds(95, 95, 180, 28);
		frame.getContentPane().add(tfContrasenia);

		frame.setLocationRelativeTo(null);
	}
}
