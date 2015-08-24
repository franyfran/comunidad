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

import modelo.contabilidad.Recibo;
import modelo.dao.PropietarioDAO;
import modelo.dao.ReciboDAO;
import modelo.propietario.Propietario;

import com.toedter.calendar.JDateChooser;

public class ReciboForm extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1106223729094803289L;
	
	private JLabel lblPropietario;
	private JLabel lblFeEmision;
	private JLabel lblFeVencimiento;
	private JLabel lblImporte;
	private JLabel lblConcepto;
	private JLabel lblBancoEmisor;
	private JLabel lblBancoReceptor;
	
	private JComboBox<Propietario> comboPropietario;
	private JDateChooser jDateChooserEmision;
	private JDateChooser jDateChooserVencimiento;
	private JTextField jtfImporte;
	private JTextField jtfConcepto;
	private JTextField jtfBancoEmisor;
	private JTextField jtfBancoReceptor;
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	
	
	public ReciboForm(){
		initialize();
	}
	
	private void initialize(){
		this.setBounds(100, 100, 450, 350);
		this.setLayout(null);
		
		lblPropietario = new JLabel("Propietario:");
		lblPropietario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPropietario.setBounds(10, 55, 115, 20);
		this.add(lblPropietario);
		
		lblFeEmision = new JLabel("Fecha de Emisdión:");
		lblFeEmision.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFeEmision.setBounds(10, 90, 115, 20);
		this.add(lblFeEmision);
		
		lblFeVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFeVencimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFeVencimiento.setBounds(10, 125, 130, 20);
		this.add(lblFeVencimiento);
		
		lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblImporte.setBounds(10, 160, 115, 20);
		this.add(lblImporte);
		
		lblConcepto = new JLabel("Concepto:");
		lblConcepto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConcepto.setBounds(10, 195, 115, 20);
		this.add(lblConcepto);
		
		lblBancoEmisor = new JLabel("Banco Emisor:");
		lblBancoEmisor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBancoEmisor.setBounds(10, 230, 115, 20);
		this.add(lblBancoEmisor);
		
		lblBancoReceptor = new JLabel("Banco Receptor:");
		lblBancoReceptor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBancoReceptor.setBounds(10, 265, 115, 20);
		this.add(lblBancoReceptor);
		
		
		jDateChooserEmision = new JDateChooser();
		jDateChooserEmision.setBounds(145, 90, 195, 20);
		this.add(jDateChooserEmision);
		
		jDateChooserVencimiento = new JDateChooser();
		jDateChooserVencimiento.setBounds(145, 125, 195, 20);
		this.add(jDateChooserVencimiento);
		
		jtfImporte = new JTextField();
		jtfImporte.setBounds(145, 160, 195, 20);
		this.add(jtfImporte);
		jtfImporte.setColumns(10);
		
		jtfConcepto = new JTextField();
		jtfConcepto.setBounds(145, 195, 195, 20);
		this.add(jtfConcepto);
		jtfConcepto.setColumns(10);
		
		jtfBancoEmisor = new JTextField();
		jtfBancoEmisor.setBounds(145, 230, 195, 20);
		this.add(jtfBancoEmisor);
		jtfBancoEmisor.setColumns(10);
		jtfBancoEmisor.setEnabled(false);
		
		jtfBancoReceptor = new JTextField();
		jtfBancoReceptor.setBounds(145, 265, 195, 20);
		this.add(jtfBancoReceptor);
		jtfBancoReceptor.setColumns(10);
		jtfBancoReceptor.setEnabled(false);
		
		comboPropietario = new JComboBox<Propietario>();
		comboPropietario.setBounds(145, 55, 195, 20);
		comboPropietario.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				cargarCuentasBancarias();
			}
			
		});
		this.add(comboPropietario);
		cargarComboPropietarios();
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(this.validarEntrada()){
					Recibo recibo = new Recibo();
					Propietario propietarioSeleccionado = (Propietario) comboPropietario.getSelectedItem();
					recibo.setPropietario(propietarioSeleccionado); 
					recibo.setFechaEmision(jDateChooserEmision.getDate());
					recibo.setFechaVencimiento(jDateChooserVencimiento.getDate());
					recibo.setImporte(Double.valueOf(jtfImporte.getText()));
					recibo.setConcepto(jtfConcepto.getText()); 
					recibo.setBancoEmisor(propietarioSeleccionado.getComunidad().getCuentaBanco());
					recibo.setBancoReceptor(propietarioSeleccionado.getCuentaBanco());
					ReciboDAO reDao = new ReciboDAO();
					reDao.alta(recibo);
					if(recibo.getNumRecibo() != null){
						JOptionPane.showMessageDialog(null, "El Recibo ha sido dada de alta correctamente en el sistema.");
					} else{
						JOptionPane.showMessageDialog(null, "Error dando de alta al Recibo.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debes especificar todos los campos.");
				}
			}
			
			private boolean validarEntrada() {
				return (comboPropietario.getSelectedItem() != null
						&& jDateChooserEmision.getDate() != null
						&& jDateChooserVencimiento.getDate() != null
						&& !jtfImporte.getText().isEmpty()
						&& !jtfConcepto.getText().isEmpty()
						&& !jtfBancoEmisor.getText().isEmpty()
						&& !jtfBancoReceptor.getText().isEmpty());
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(355, 195, 90, 25);
		this.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(355, 245, 90, 25);
		this.add(btnCancelar);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		this.revalidate();
		
	}
	
	private void cargarComboPropietarios() {
		PropietarioDAO propietrarioDao = new PropietarioDAO();
		List<Propietario> propietarios = propietrarioDao.consultaAll();
		if (propietarios != null) {
			for (Propietario propietario : propietarios) {
				comboPropietario.addItem(propietario);
			}
		}
	}
	
	private void cargarCuentasBancarias(){
		Propietario propietarioSeleccionado = (Propietario) comboPropietario.getSelectedItem();
		if(propietarioSeleccionado != null){
			jtfBancoEmisor.setText(propietarioSeleccionado.getComunidad().getCuentaBanco().toString());
			jtfBancoReceptor.setText(propietarioSeleccionado.getCuentaBanco().toString());
		} else{
			jtfBancoEmisor.setText("");
			jtfBancoReceptor.setText("");
		}
	}

}
