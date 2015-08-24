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
import modelo.dao.CuotaDAO;
import modelo.propietario.Cuota;
import modelo.propietario.Periodicidad;

public class CuotaConsulta extends JPanel implements ActionListener{
	
	private JTable table;
	private static final String[] NOMBRE_COLUMNAS = { "Id", "Importe", "Periodicidad"};
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnVolver;

	/**
	 * Create the panel.
	 */
	public CuotaConsulta() {

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
		
		CuotaDAO cuDAO = new CuotaDAO();
		List<Cuota> cuotas = cuDAO.consultaAll();
		pintarCuotas(cuotas);
	}

	private void pintarCuotas(List<Cuota> cuotas) {
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		if (cuotas != null) {
			Object[][] datos = new String[cuotas.size()][NOMBRE_COLUMNAS.length];
			for (int i = 0; i < cuotas.size(); i++) {
				String idCuota = cuotas.get(i).getIdCuota().toString();
				String importe = Double.toString(cuotas.get(i).getImporte());
				String periodo = cuotas.get(i).getPeriodo().toString();
				datos[i][0] = idCuota;
				datos[i][1] = importe;
				datos[i][2] = periodo;
			}
			modelo.setDataVector(datos, NOMBRE_COLUMNAS);

		}

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		CuotaDAO cuDao = new CuotaDAO();
		
		int filaSeleccionada = table.getSelectedRow();
		Integer idCuotaSeleccionada = null;
		if (filaSeleccionada != -1) {
			String idCuotaStr = (String) table.getValueAt(filaSeleccionada, 0);
			idCuotaSeleccionada = Integer.valueOf(idCuotaStr);
		}
		
		if(btnVolver == evento.getSource()){
			this.setVisible(false);
			this.revalidate();
		}
		
		if(btnBorrar == evento.getSource() && idCuotaSeleccionada != null){
			cuDao.baja(idCuotaSeleccionada);
			((DefaultTableModel)table.getModel()).removeRow(filaSeleccionada);
		}
		
		if(btnModificar == evento.getSource() && idCuotaSeleccionada != null){
			
			Cuota cuota = cuDao.consulta(idCuotaSeleccionada);
			cuota.setImporte ((Integer) table.getValueAt(filaSeleccionada, 1));
			cuota.setPeriodo((Periodicidad) table.getValueAt(filaSeleccionada, 2));
			cuDao.modificacion(cuota);	
		}	
	}
}
