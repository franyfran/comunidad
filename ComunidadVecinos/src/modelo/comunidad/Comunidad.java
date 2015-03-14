package modelo.comunidad;

import java.util.List;

import modelo.bancario.CuentaBanco;
import modelo.propietario.Propietario;

public class Comunidad {

	private String nombreEdificio;
	private String direccion ;
	private String poblacion;
	private String codigoPostal;
	private String provincia;
	private List<Propietario> propietarios;
	private CuentaBanco cuentaBanco;
	
	public Comunidad() {
		super();
		
	}

	public Comunidad(String nombreEdificio, String direccion, String poblacion,
			String codigoPostal, String provincia,
			List<Propietario> propietarios, CuentaBanco cuentaBanco) {
		super();
		this.nombreEdificio = nombreEdificio;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.propietarios = propietarios;
		this.cuentaBanco = cuentaBanco;
	}

	public String getNombreEdificio() {
		return nombreEdificio;
	}

	public void setNombreEdificio(String nombreEdificio) {
		this.nombreEdificio = nombreEdificio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Propietario> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(List<Propietario> propietarios) {
		this.propietarios = propietarios;
	}

	public CuentaBanco getCuentaBanco() {
		return cuentaBanco;
	}

	public void setCuentaBanco(CuentaBanco cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	@Override
	public String toString() {
		return "Comunidad [nombreEdificio=" + nombreEdificio + ", direccion="
				+ direccion + ", poblacion=" + poblacion + ", codigoPostal="
				+ codigoPostal + ", provincia=" + provincia + ", propietarios="
				+ propietarios + ", cuentaBanco=" + cuentaBanco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoPostal == null) ? 0 : codigoPostal.hashCode());
		result = prime * result
				+ ((cuentaBanco == null) ? 0 : cuentaBanco.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result
				+ ((nombreEdificio == null) ? 0 : nombreEdificio.hashCode());
		result = prime * result
				+ ((poblacion == null) ? 0 : poblacion.hashCode());
		result = prime * result
				+ ((propietarios == null) ? 0 : propietarios.hashCode());
		result = prime * result
				+ ((provincia == null) ? 0 : provincia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comunidad other = (Comunidad) obj;
		if (codigoPostal == null) {
			if (other.codigoPostal != null)
				return false;
		} else if (!codigoPostal.equals(other.codigoPostal))
			return false;
		if (cuentaBanco == null) {
			if (other.cuentaBanco != null)
				return false;
		} else if (!cuentaBanco.equals(other.cuentaBanco))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (nombreEdificio == null) {
			if (other.nombreEdificio != null)
				return false;
		} else if (!nombreEdificio.equals(other.nombreEdificio))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		if (propietarios == null) {
			if (other.propietarios != null)
				return false;
		} else if (!propietarios.equals(other.propietarios))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}
	
	
}
