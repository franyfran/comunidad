package vista.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.comunidad.Comunidad;
import modelo.dao.PropietarioDAO;
import modelo.propietario.Cuota;
import modelo.propietario.Finca;
import modelo.propietario.Propietario;

public class PropietarioConsulta extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5236835734300825020L;
	private JTable table;
	private static final String[] NOMBRE_COLUMNAS = { "Id", "Nombre",
			"Apellidos", "Telefono", "Cuota", "Comunidad", "Finca"};
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnVolver;

	/**
	 * Create the panel.
	 */
	public PropietarioConsulta() {

		init();
	}

	private void init() {
		setLayout(null);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 452, 185);
		this.add(scrollPane);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(365, 212, 97, 33);
		btnModificar.addActionListener(this);
		add(btnModificar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.setBounds(243, 212, 97, 33);
		btnBorrar.addActionListener(this);
		add(btnBorrar);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(10, 212, 97, 33);
		btnVolver.addActionListener(this);
		add(btnVolver);
		
		PropietarioDAO pDAO = new PropietarioDAO();
		List<Propietario> propietarios = pDAO.consultaAll();
		pintarPropietarios(propietarios);
	}

	private void pintarPropietarios(List<Propietario> propietarios) {
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		if (propietarios != null) {
			Object[][] datos = new String[propietarios.size()][NOMBRE_COLUMNAS.length];
			for (int i = 0; i < propietarios.size(); i++) {
				String idPropietario = propietarios.get(i).getIdPropietario().toString();
				String nombre = propietarios.get(i).getNombrePropietario();
				String apellidos = propietarios.get(i).getApellidosPropietario();
				String telefono = propietarios.get(i).getTelefono();
				String cuota = propietarios.get(i).getCuota().toString();
				String comunidad = propietarios.get(i).getComunidad().toString();
				String finca = propietarios.get(i).getFinca().toString();
				datos[i][0] = idPropietario;
				datos[i][1] = nombre;
				datos[i][2] = apellidos;
				datos[i][3] = telefono;
				datos[i][4] = cuota;
				datos[i][5] = comunidad;
				datos[i][6] = finca;
			}
			modelo.setDataVector(datos, NOMBRE_COLUMNAS);

		}

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		PropietarioDAO pDAO = new PropietarioDAO();
		
		int filaSeleccionada = table.getSelectedRow();
		Integer idPropietarioSeleccionado = null;
		if (filaSeleccionada != -1) {
			String idPropietarioStr = (String) table.getValueAt(filaSeleccionada, 0);
			idPropietarioSeleccionado = Integer.valueOf(idPropietarioStr);
		}
		
		if(btnVolver == evento.getSource()){
			this.setVisible(false);
			this.revalidate();
		}
		
		if(btnBorrar == evento.getSource() && idPropietarioSeleccionado != null){
			pDAO.baja(idPropietarioSeleccionado);
			((DefaultTableModel)table.getModel()).removeRow(filaSeleccionada);
		}
		
		if(btnModificar == evento.getSource() && idPropietarioSeleccionado != null){
			
			Propietario propietario = pDAO.consulta(idPropietarioSeleccionado);
			propietario.setNombrePropietario((String) table.getValueAt(filaSeleccionada, 1));
			propietario.setApellidosPropietario((String) table.getValueAt(filaSeleccionada, 2));
			propietario.setTelefono((String) table.getValueAt(filaSeleccionada, 3));
			propietario.setCuota((Cuota) table.getValueAt(filaSeleccionada, 4));
			propietario.setComunidad((Comunidad) table.getValueAt(filaSeleccionada, 5));
			propietario.setFinca((Finca) table.getValueAt(filaSeleccionada, 6));
			pDAO.modificacion(propietario);	
		}	
	}
}
