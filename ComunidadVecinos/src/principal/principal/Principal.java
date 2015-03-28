package principal.principal;

import java.util.Scanner;

import modelo.comunidad.Comunidad;
import modelo.comunidad.ComunidadUtil;
import modelo.propietario.Propietario;
import modelo.propietario.PropietarioUtil;

public class Principal {
	
	private final static int INSERTAR_PROPIETARIO = 1;
	private final static int INFORMACION_COMUNIDAD = 2;
	private final static int SALIR = 3;

	public static void imprimirMenuPrincipal() {
		String imprimir = new String();
		imprimir += INSERTAR_PROPIETARIO + ". INSERTAR PROPIETARIO\n";
		imprimir += INFORMACION_COMUNIDAD + ". INFORMACION COMUNIDAD\n";
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
				Propietario nuevoPropietario = PropietarioUtil.crearPropietario();
				comunidad.getPropietarios().add(nuevoPropietario);
				break;
			case INFORMACION_COMUNIDAD:
				System.out.println(comunidad);
				break;
			case SALIR:
				finalizar = true;
				break;
			}
		}
	}
}
