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

import modelo.bancario.Banco;
import modelo.propietario.Finca;
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
	
	@Column (name="CALLE")
	private String calle ;
	
	@Column (name="NUMERO")
	private String numero ;
	
	@Column (name="POBLACION")
	private String poblacion ;
	
	@Column (name="CODIGO_POSTAL")
	private String codigoPostal;
	
	@Column (name="PROVINCIA")
	private String provincia;
	
	@OneToMany(mappedBy = "comunidad",cascade=CascadeType.ALL)
	private List<Propietario> propietarios;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUENTA_BANCO")
	private Banco cuentaBanco;
	
	public Comunidad() {
		super();
		
	}

	public Integer getIdComunidad() {
		return idComunidad;
	}

	public String getNombreEdificio() {
		return nombreEdificio;
	}

	public void setNombreEdificio(String nombreEdificio) {
		this.nombreEdificio = nombreEdificio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public Banco getCuentaBanco() {
		return cuentaBanco;
	}

	public void setCuentaBanco(Banco cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	@Override
	public String toString() {
		return nombreEdificio;
	}
	
	

	
}
