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

import modelo.dao.FincaDAO;
import modelo.propietario.Finca;

public class FincaForm {

	private JFrame frame;
	private JTextField tfPlanta;
	private JTextField tfPuerta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FincaForm window = new FincaForm();
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
	public FincaForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Alta Finca");
		frame.setBounds(100, 100, 300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelPlanta = new JLabel("Planta:");
		labelPlanta.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPlanta.setBounds(20, 45, 90, 30);
		frame.getContentPane().add(labelPlanta);
		
		JLabel labelPuerta = new JLabel("Puerta:");
		labelPuerta.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPuerta.setBounds(20, 95, 90, 30);
		frame.getContentPane().add(labelPuerta);
		
		tfPlanta = new JTextField();
		tfPlanta.setBounds(143, 46, 131, 28);
		frame.getContentPane().add(tfPlanta);
		//tfUsuario.setColumns(1);
		
		tfPuerta = new JTextField();
		//tfPuerta.setColumns(1);
		tfPuerta.setBounds(143, 96, 131, 28);
		frame.getContentPane().add(tfPuerta);
		
		JButton btnAceptarFinca = new JButton("Aceptar");
		btnAceptarFinca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfPlanta.getText().isEmpty() && !tfPuerta.getText().isEmpty()){
					Finca finca = new Finca(Integer.parseInt(tfPlanta.getText()), tfPuerta.getText());
					FincaDAO fdao = new FincaDAO();
					fdao.alta(finca);
					if(finca.getIdFinca() != null){
						JOptionPane.showMessageDialog(null, "La finca ha sido dada de alta correctamente en el sistema.");
					} else{
						JOptionPane.showMessageDialog(null, "Error dando de alta la finca.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debes especificar todos los campos.");
				}
			}
		});
		btnAceptarFinca.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptarFinca.setBounds(184, 152, 90, 25);
		frame.getContentPane().add(btnAceptarFinca);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(20, 152, 90, 25);
		frame.getContentPane().add(btnCancelar);
		
		frame.setLocationRelativeTo(null);
	}
}
