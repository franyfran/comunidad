package principal.principal;

import modelo.bancario.Banco;
import modelo.dao.BancoDAO;




public class Principal {
	
	public static void main(String[] args) {
		Banco banco = new Banco();
		banco.setNombreBanco("Santander");
		banco.setNumeroCuenta("2040");
		banco.setSucursal("Nueva");
		BancoDAO dao = new BancoDAO();
		dao.alta(banco);
	}
}