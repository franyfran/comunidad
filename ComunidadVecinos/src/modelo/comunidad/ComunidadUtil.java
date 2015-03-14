package modelo.comunidad;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bancario.CuentaBanco;
import modelo.propietario.Propietario;

public class ComunidadUtil {
	
	public static Comunidad crearComunidad(){
		
		Comunidad comunidad = new Comunidad();
		
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzaca nombre del edificio");
		String nombreEdificio = teclado.nextLine();
		System.out.println("Introduzaca direccion");
		String direccion = teclado.nextLine();
		System.out.println("Introduzaca poblacion");
		String poblacion = teclado.nextLine();
		System.out.println("Introduzaca codigo postal");
		String codigoPostal = teclado.nextLine();
		System.out.println("Introduzaca provincia");
		String provincia = teclado.nextLine();
		
		comunidad.setNombreEdificio(nombreEdificio);
		comunidad.setDireccion(direccion);
		comunidad.setPoblacion(poblacion);
		comunidad.setCodigoPostal(codigoPostal);
		comunidad.setProvincia(provincia);
		comunidad.setCuentaBanco(new CuentaBanco());
		comunidad.setPropietarios(new ArrayList<Propietario>());
		
		return comunidad;
	}

}