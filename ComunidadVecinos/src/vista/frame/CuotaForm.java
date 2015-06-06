package vista.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.dao.CuotaDAO;
import modelo.propietario.Cuota;
import modelo.propietario.Periodicidad;

public class CuotaForm {

	private JFrame frame;
	private JTextField tfCuota;
	JComboBox<Periodicidad> cbPeriodicidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuotaForm window = new CuotaForm();
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
	public CuotaForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Establecer Cuota");
		frame.setBounds(100, 100, 300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel labelCuota = new JLabel("Cuota:");
		labelCuota.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCuota.setBounds(10, 28, 90, 30);
		frame.getContentPane().add(labelCuota);

		tfCuota = new JTextField();
		tfCuota.setBounds(110, 29, 137, 28);
		frame.getContentPane().add(tfCuota);
		// tfCuota.setColumns(1);

		JButton btnAceptarCuota = new JButton("Aceptar");
		btnAceptarCuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfCuota.getText().isEmpty() && cbPeriodicidad.getSelectedItem() != null){
					Cuota cuota = new Cuota();
					cuota.setImporte(Double.parseDouble(tfCuota.getText()));
					cuota.setPeriodo((Periodicidad) cbPeriodicidad.getSelectedItem());
					CuotaDAO cudao = new CuotaDAO();
					cudao.alta(cuota);
					if(cuota.getIdCuota() != null){
						JOptionPane.showMessageDialog(null, "La cuota ha sido dada de alta correctamente en el sistema.");
					} else{
						JOptionPane.showMessageDialog(null, "Error dando de alta la cuota.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debes especificar todos los campos.");
				}
			}
		});
		btnAceptarCuota.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptarCuota.setBounds(137, 145, 90, 25);
		frame.getContentPane().add(btnAceptarCuota);

		JLabel labelPeriocidad = new JLabel("Periocidad:");
		labelPeriocidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPeriocidad.setBounds(10, 91, 90, 30);
		frame.getContentPane().add(labelPeriocidad);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(23, 147, 90, 25);
		frame.getContentPane().add(btnCancelar);

		cbPeriodicidad = new JComboBox<Periodicidad>();
		cbPeriodicidad.setBounds(110, 96, 137, 20);
		this.cargarComboPeriodicidad();

		frame.getContentPane().add(cbPeriodicidad);

		frame.setLocationRelativeTo(null);
	}

	private void cargarComboPeriodicidad() {
		for (Periodicidad periodo : Periodicidad.values()) {
			cbPeriodicidad.addItem(periodo);
		}

	}
}
