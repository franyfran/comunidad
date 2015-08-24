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

import modelo.comunidad.Comunidad;
import modelo.dao.ComunidadDAO;
import modelo.dao.FincaDAO;
import modelo.propietario.Finca;

public class FincaForm extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8715001198163413583L;
	private JTextField tfPlanta;
	private JTextField tfPuerta;
	private JComboBox<Comunidad> jcbComunidad;

	

	/**
	 * Create the application.
	 */
	public FincaForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 300, 250);
		this.setLayout(null);
		
		JLabel labelComunidad = new JLabel("Comunidad:");
		labelComunidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelComunidad.setBounds(20, 30, 90, 30);
		this.add(labelComunidad);
		
		JLabel labelPlanta = new JLabel("Planta:");
		labelPlanta.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPlanta.setBounds(20, 60, 90, 30);
		this.add(labelPlanta);
		
		JLabel labelPuerta = new JLabel("Puerta:");
		labelPuerta.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelPuerta.setBounds(20, 95, 90, 30);
		this.add(labelPuerta);
		
		tfPlanta = new JTextField();
		tfPlanta.setBounds(143, 60, 131, 28);
		this.add(tfPlanta);
		//tfUsuario.setColumns(1);
		
		tfPuerta = new JTextField();
		//tfPuerta.setColumns(1);
		tfPuerta.setBounds(143, 96, 131, 28);
		this.add(tfPuerta);
		
		jcbComunidad = new JComboBox<Comunidad>();
		jcbComunidad.setBounds(143, 30, 131, 28);
		this.cargarComboComunidades();
		this.add(jcbComunidad);
		
		
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
		this.add(btnAceptarFinca);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(20, 152, 90, 25);
		this.add(btnCancelar);
	}

	private void cargarComboComunidades() {
		ComunidadDAO comunidadDao = new ComunidadDAO();
		List<Comunidad> comunidades = comunidadDao.consultaAll();
		
		for(Comunidad comunidad : comunidades){
			jcbComunidad.addItem(comunidad);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		this.revalidate();
		
	}
}
