package modelo.contabilidad;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.comunidad.Comunidad;
import modelo.dao.ReciboDAO;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class InformeUtil {
	/**
	 * Clase encargada de generar un pdf para un recibo
	 * @param recibo
	 * @param nombreComunidad
	 */
	public static void generarPdf(Recibo recibo){
		StringBuilder rutaFicheroSalida = new StringBuilder("recibo/").append(recibo.getNumRecibo()).append(".pdf");
		
		Map<String, Object> parametros = new HashMap<String, Object>(); //clave es el nombre del parametro en el jasper, y el valor es el parametro que le pasamos al método
		parametros.put("recibo", recibo);
		
		try {
			File file = new File("informes/Recibos.jasper");
			JasperReport reporte = (JasperReport) JRLoader.loadObject(file);
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					rutaFicheroSalida.toString());
			
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Clase encargada de generar un pdf para un recibo
	 * @param recibo
	 * @param nombreComunidad
	 */
	public static void generarPdf(Comunidad comunidad){
		StringBuilder rutaFicheroSalida = new StringBuilder("recibo/").append(comunidad.getIdComunidad()).append("_pendientes.pdf");
		Map<String, Object> parametros = new HashMap<String, Object>(); //clave es el nombre del parametro en el jasper, y el valor es el parametro que le pasamos al método
		parametros.put("comunidad", comunidad);
		ReciboDAO reciboDao = new ReciboDAO();
		List<Recibo> recibosPendientes = reciboDao.obtenerRecibosPendientes(comunidad.getIdComunidad());
		
		try {
			File file = new File("informes/RecibosPendientes.jasper");
			JasperReport reporte = (JasperReport) JRLoader.loadObject(file);
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(recibosPendientes));
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					rutaFicheroSalida.toString());
			
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}
}
