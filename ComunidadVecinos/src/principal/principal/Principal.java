package principal.principal;

import java.util.Scanner;

import modelo.comunidad.Comunidad;
import modelo.comunidad.ComunidadUtil;

public class Principal {
	
	private final static int INSERTAR_PROPIETARIO = 1;
	private final static int SALIR = 2;

	public static void imprimirMenuPrincipal() {
		String imprimir = new String();
		imprimir += INSERTAR_PROPIETARIO + ". INSERTAR PROPIETARIO\n";
		imprimir += SALIR + ". SALIR\n";
		System.out.println(imprimir);
	}

	public static void main(String[] args) {
		
		Comunidad comunidad = ComunidadUtil.crearComunidad();
		
		boolean finalizar = false;
		
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		int opcionElegida;
		while (!finalizar) {
			imprimirMenuPrincipal();
			opcionElegida = teclado.nextInt();
			switch (opcionElegida){
			case INSERTAR_PROPIETARIO:
				//TODO: IMPLEMENTAR
				break;
			case SALIR:
				finalizar = true;
				break;
			}
		}
	}
}
