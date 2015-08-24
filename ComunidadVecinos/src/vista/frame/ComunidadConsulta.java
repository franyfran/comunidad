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
import modelo.dao.ComunidadDAO;

public class ComunidadConsulta extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5210171233658605069L;

	private JTable table;
	private static final String[] NOMBRE_COLUMNAS = { "Id", "Edificio",
			"Calle", "Numero", "Puerta", "Poblacion", "Cod Postal",
			"Provincia", "No Cuenta Banco" };
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnVolver;

	/**
	 * Create the panel.
	 */
	public ComunidadConsulta() {

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
		
		ComunidadDAO cDAO = new ComunidadDAO();
		List<Comunidad> comunidades = cDAO.consultaAll();
		pintarComunidades(comunidades);
	}

	private void pintarComunidades(List<Comunidad> comunidades) {
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		if (comunidades != null) {
			Object[][] datos = new String[comunidades.size()][NOMBRE_COLUMNAS.length];
			for (int i = 0; i < comunidades.size(); i++) {
				String id = comunidades.get(i).getIdComunidad().toString();
				String nombreEdificio = comunidades.get(i).getNombreEdificio();
				String calle = comunidades.get(i).getCalle();
				String numero = comunidades.get(i).getNumero();
				String poblacion = comunidades.get(i).getPoblacion();
				String codigoPostal = comunidades.get(i).getCodigoPostal();
				String provincia = comunidades.get(i).getProvincia();
				String numeroCuenta = comunidades.get(i).getCuentaBanco()
						.toString();
				datos[i][0] = id;
				datos[i][1] = nombreEdificio;
				datos[i][2] = calle;
				datos[i][3] = numero;
				datos[i][4] = poblacion;
				datos[i][5] = codigoPostal;
				datos[i][6] = provincia;
				datos[i][7] = numeroCuenta;
			}
			modelo.setDataVector(datos, NOMBRE_COLUMNAS);

		}

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		ComunidadDAO cDao = new ComunidadDAO();
		
		int filaSeleccionada = table.getSelectedRow();
		Integer idComunidadSeleccionada = null;
		if (filaSeleccionada != -1) {
			String idComunidadStr = (String) table.getValueAt(filaSeleccionada, 0);
			idComunidadSeleccionada = Integer.valueOf(idComunidadStr);
		}
		
		if(btnVolver == evento.getSource()){
			this.setVisible(false);
			this.revalidate();
		}
		
		if(btnBorrar == evento.getSource() && idComunidadSeleccionada != null){
			cDao.baja(idComunidadSeleccionada);
			((DefaultTableModel)table.getModel()).removeRow(filaSeleccionada);
		}
		
		if(btnModificar == evento.getSource() && idComunidadSeleccionada != null){
			
			Comunidad comunidad = cDao.consulta(idComunidadSeleccionada);
			comunidad.setNombreEdificio((String) table.getValueAt(filaSeleccionada, 1));
			comunidad.setCalle((String) table.getValueAt(filaSeleccionada, 2));
			comunidad.setNumero((String) table.getValueAt(filaSeleccionada, 3));
			comunidad.setPoblacion((String) table.getValueAt(filaSeleccionada, 4));
			comunidad.setCodigoPostal((String) table.getValueAt(filaSeleccionada, 5));
			comunidad.setProvincia((String) table.getValueAt(filaSeleccionada, 6));
			cDao.modificacion(comunidad);	
		}	
	}
}
