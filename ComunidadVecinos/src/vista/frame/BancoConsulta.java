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

import modelo.bancario.Banco;
import modelo.comunidad.Comunidad;
import modelo.dao.BancoDAO;

public class BancoConsulta extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5191758352081000994L;
	private JTable table;
	private static final String[] NOMBRE_COLUMNAS = { "Id", "Nombre",
			"Sucursal", "Numero Cuenta" };
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnVolver;

	/**
	 * Create the panel.
	 */

	public BancoConsulta() {

		init();
	}

	public void init() {
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

		BancoDAO bDAO = new BancoDAO();
		List<Banco> bancos = bDAO.consultaAll();
		pintarBancos(bancos);
	}

	private void pintarBancos(List<Banco> bancos) {
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		if (bancos != null) {
			Object[][] datos = new String[bancos.size()][NOMBRE_COLUMNAS.length];
			for (int i = 0; i < bancos.size(); i++) {
				String id = bancos.get(i).getIdCuentaBanco().toString();
				String Nombre = bancos.get(i).getNombreBanco().toString();
				String Sucursal = bancos.get(i).getSucursal().toString();
				String NumeroCuenta = bancos.get(i).getIdCuentaBanco()
						.toString();
				datos[i][0] = id;
				datos[i][1] = Nombre;
				datos[i][2] = Sucursal;
				datos[i][3] = NumeroCuenta;
			}
			modelo.setDataVector(datos, NOMBRE_COLUMNAS);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BancoDAO bDao = new BancoDAO();

		int filaSeleccionada = table.getSelectedRow();
		Integer IdBancoSeleccionado = null;
		if (filaSeleccionada != -1) {
			String IdBancoStr = (String) table.getValueAt(filaSeleccionada, 0);
			IdBancoSeleccionado = Integer.valueOf(IdBancoStr);
		}

		if (btnVolver == e.getSource()) {
			this.setVisible(false);
			this.revalidate();
		}

		if (btnBorrar == e.getSource() && IdBancoSeleccionado != null) {
			bDao.baja(IdBancoSeleccionado);
			((DefaultTableModel) table.getModel()).removeRow(filaSeleccionada);
		}

		if (btnModificar == e.getSource()
				&& IdBancoSeleccionado != null) {

			Banco banco = bDao.consulta(IdBancoSeleccionado);
			banco.setNombreBanco((String) table.getValueAt(filaSeleccionada, 1));
			banco.setSucursal((String) table.getValueAt(filaSeleccionada, 2));
			banco.setNumeroCuenta((String) table.getValueAt(filaSeleccionada, 3));
			bDao.modificacion(banco);
		}
	}

}
