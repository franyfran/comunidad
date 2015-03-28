package modelo.propietario;

import java.io.IOException;
import java.util.Scanner;

public class PropietarioUtil {

	public static Propietario crearPropietario(){
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca nombre del propietario");
		String nombrePropietario = teclado.nextLine();
		System.out.println("Introduzca los apellidos del propioetario");
		String apellidosPropietario = teclado.nextLine();
		System.out.println("Introduzca la planta");
		Integer planta = teclado.nextInt();
		System.out.println("Introduzca la puerta");
		Character puerta = null;
		try {
			puerta = (char) System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Introduzca la superficie");
		Float superficie = teclado.nextFloat();
		
		Finca finca = new Finca(planta, puerta, superficie);
		
		Propietario propietario = new Propietario(finca, nombrePropietario, apellidosPropietario);
		System.out.println(propietario);
		return propietario;
	}
}

