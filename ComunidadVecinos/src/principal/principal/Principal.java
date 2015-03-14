package principal.principal;

import java.util.Scanner;

public class Principal {
	
	private final static int CREAR_COMUNIDAD = 1;
	private final static int INSERTAR_PROPIETARIO = 2;
	private final static int SALIR = 3;

	public static void imprimirMenuPrincipal() {
		String imprimir = new String();
		imprimir += CREAR_COMUNIDAD + ". CREAR COMUNIDAD\n";
		imprimir += INSERTAR_PROPIETARIO + ". INSERTAR PROPIETARIO\n";
		imprimir += SALIR + ". SALIR\n";
		System.out.println(imprimir);
	}

	public static void main(String[] args) {
		boolean finalizar = false;
		
		Scanner teclado = new Scanner(System.in);
		int opcionElegida;
		while (!finalizar) {
			imprimirMenuPrincipal();
			opcionElegida = teclado.nextInt();
			switch (opcionElegida){
			case CREAR_COMUNIDAD:
				//TODO: IMPLEMENTAR
				break;
			case INSERTAR_PROPIETARIO:
				//TODO: IMPLEMENTAR
				break;
			case SALIR:
				finalizar = true;
				break;
			}
		}
		teclado.close();
	}
}
