package vista.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.propietario.*;
import modelo.bancario.*;
import modelo.contabilidad.*;
import modelo.comunidad.Comunidad;
import modelo.contabilidad.Recibo;
import modelo.dao.ComunidadDAO;
import modelo.dao.ReciboDAO;

public class ReciboConsulta extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7735891813248270584L;
	
	private static final String[] NOMBRE_COLUMNAS = { "Nº_RECIBO", "PROPIETARIO", "FECHA DE EMISION", "FECHA DE VENCIMIENTO", "IMPORTE", "CONCEPTO", "BANCO_EMISOR", "BANCO_RECEPTOR", "PAGADO"};
	private JTable table;
	private DefaultTableModel modelo;
	JScrollPane scrollPane;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnVolver;
	private JButton btnImprimir;
	
	public ReciboConsulta() {
		init();
	}
	
	private void init(){
		
		setLayout(null);
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 452, 185);
		this.add(scrollPane);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(250, 212, 97, 33);
		btnModificar.addActionListener(this);
		add(btnModificar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.setBounds(120, 212, 97, 33);
		btnBorrar.addActionListener(this);
		add(btnBorrar);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(10, 212, 97, 33);
		btnVolver.addActionListener(this);
		add(btnVolver);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnImprimir.setBounds(350, 212, 97, 33);
		btnImprimir.addActionListener(this);
		add(btnImprimir);
		
		ReciboDAO reDao = new ReciboDAO();
		List<Recibo> recibos = reDao.consultaAll();
		pintarRecibos(recibos);
	}
	
	private void pintarRecibos(List<Recibo> recibos){
		
		modelo = new DefaultTableModel(){
			@Override
	        public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	        }
		};
		table.setModel(modelo);
		
		if (recibos != null) {
			Object[][] datos = new Object[recibos.size()][NOMBRE_COLUMNAS.length];
			for (int i = 0; i < recibos.size(); i++) {
				Integer numRecibo = recibos.get(i).getNumRecibo();
				Propietario propietario = recibos.get(i).getPropietario();
				Date feEmision = recibos.get(i).getFechaEmision();
				Date feVencimiento = recibos.get(i).getFechaVencimiento();
				Double importe = recibos.get(i).getImporte();
				String concepto = recibos.get(i).getConcepto();
				Banco bancoEmisor = recibos.get(i).getBancoEmisor();
				Banco bancoReceptor = recibos.get(i).getBancoReceptor();
				boolean pagado = recibos.get(i).isPagado();
				
				datos[i][0] = numRecibo;
				datos[i][1] = propietario;
				datos[i][2] = feEmision;
				datos[i][3] = feVencimiento;
				datos[i][4] = importe;
				datos[i][5] = concepto;
				datos[i][6] = bancoEmisor;
				datos[i][7] = bancoReceptor;
				datos[i][8] = pagado;
				
			}
			
			modelo.setDataVector(datos, NOMBRE_COLUMNAS);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		Recibo recibo = null;
		ReciboDAO reDAO = new ReciboDAO();

		int filaSeleccionada = table.getSelectedRow();
		Integer numRegistroSeleccionado = null;
		if (filaSeleccionada != -1) {
			numRegistroSeleccionado = (Integer) table.getValueAt(filaSeleccionada, 0);
		}
		if(numRegistroSeleccionado != null){
			recibo = reDAO.consulta(numRegistroSeleccionado);
		}
		
		if(btnVolver == evento.getSource()){
			this.setVisible(false);
			this.revalidate();
		}
		
		if(btnBorrar == evento.getSource() && numRegistroSeleccionado != null){
			reDAO.baja(numRegistroSeleccionado);
			((DefaultTableModel)table.getModel()).removeRow(filaSeleccionada);
		}
		
		if(btnModificar == evento.getSource() && numRegistroSeleccionado != null){
			/* Permitimos modificar solo los campos que nos interesan */
			recibo.setFechaEmision((Date) table.getValueAt(filaSeleccionada, 2));
			recibo.setFechaVencimiento((Date) table.getValueAt(filaSeleccionada, 3));
			recibo.setImporte((Double) table.getValueAt(filaSeleccionada, 4));
			recibo.setConcepto((String) table.getValueAt(filaSeleccionada, 5));
			recibo.setPagado((Boolean) table.getValueAt(filaSeleccionada, 8)) ;
			reDAO.modificacion(recibo);	
		}
		
		if(btnImprimir == evento.getSource() && numRegistroSeleccionado != null){
			InformeUtil.generarPdf(recibo);
		}
		
	}
	
	
}
