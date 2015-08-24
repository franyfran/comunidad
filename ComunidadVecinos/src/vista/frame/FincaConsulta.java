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
import modelo.dao.FincaDAO;
import modelo.propietario.Finca;

public class FincaConsulta extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6610831217887305872L;

	private JTable table;
	private static final String[] NOMBRE_COLUMNAS = { "Id", "Planta", "Puerta" };
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnVolver;

	/**
	 * Create the panel.
	 */
	public FincaConsulta() {

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

		FincaDAO fDAO = new FincaDAO();
		List<Finca> fincas = fDAO.consultaAll();
		pintarFincas(fincas);
	}

	private void pintarFincas(List<Finca> fincas) {
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		if (fincas != null) {
			Object[][] datos = new String[fincas.size()][NOMBRE_COLUMNAS.length];
			for (int i = 0; i < fincas.size(); i++) {
				String id = fincas.get(i).getIdFinca().toString();
				String planta = Integer.toString(fincas.get(i).getPlanta());
				String puerta = fincas.get(i).getPuerta();
				datos[i][0] = id;
				datos[i][1] = planta;
				datos[i][2] = puerta;
			}
			modelo.setDataVector(datos, NOMBRE_COLUMNAS);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FincaDAO fDAO = new FincaDAO();

		int filaSeleccionada = table.getSelectedRow();
		Integer idFincaSeleccionada = null;
		if (filaSeleccionada != -1) {
			String idFincaStr = (String) table.getValueAt(filaSeleccionada, 0);
			idFincaSeleccionada = Integer.valueOf(idFincaStr);
		}

		if (btnVolver == e.getSource()) {
			this.setVisible(false);
			this.revalidate();
		}

		if (btnBorrar == e.getSource() && idFincaSeleccionada != null) {
			fDAO.baja(idFincaSeleccionada);
			((DefaultTableModel) table.getModel()).removeRow(filaSeleccionada);
		}

		if (btnModificar == e.getSource() && idFincaSeleccionada != null) {

			Finca finca = fDAO.consulta(idFincaSeleccionada);
			finca.setPlanta ((Integer) table.getValueAt(filaSeleccionada, 1));
			finca.setPuerta((String) table.getValueAt(filaSeleccionada, 2));
			fDAO.modificacion(finca);
		}
	}
}
