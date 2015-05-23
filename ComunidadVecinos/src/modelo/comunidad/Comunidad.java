package modelo.comunidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.bancario.CuentaBanco;
import modelo.propietario.Propietario;

@Entity
@Table(name = "COMUNIDAD")
public class Comunidad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2881126122273086720L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column (name="ID_COMUNIDAD")
	private Integer idComunidad;
	
	@Column (name="NOMBRE_EDIFICIO")
	private String nombreEdificio;
	
	@Column (name="DIRECCION")
	private String direccion ;
	
	@Column (name="POBLACION")
	private String poblacion;
	
	@Column (name="CODIGO_POSTAL")
	private String codigoPostal;
	
	@Column (name="PROVINCIA")
	private String provincia;
	
	@OneToMany(mappedBy = "comunidad",cascade=CascadeType.ALL)
	private List<Propietario> propietarios;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUENTA_BANCO")
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

	public Integer getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(Integer idComunidad) {
		this.idComunidad = idComunidad;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComunidad == null) ? 0 : idComunidad.hashCode());
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
		if (idComunidad == null) {
			if (other.idComunidad != null)
				return false;
		} else if (!idComunidad.equals(other.idComunidad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comunidad [idComunidad=" + idComunidad + ", nombreEdificio="
				+ nombreEdificio + ", direccion=" + direccion + ", poblacion="
				+ poblacion + ", codigoPostal=" + codigoPostal + ", provincia="
				+ provincia + ", propietarios=" + propietarios
				+ ", cuentaBanco=" + cuentaBanco + "]";
	}

	
	
	
}
