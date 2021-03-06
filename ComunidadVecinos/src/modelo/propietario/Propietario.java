package modelo.propietario;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.bancario.Banco;
import modelo.comunidad.Comunidad;
import modelo.contabilidad.Recibo;

@Entity
@Table(name = "PROPIETARIO")
public class Propietario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8797658051472378989L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID_PROPIETARIO")
	private Integer idPropietario;  //En caso de que se use en BBDD y sea autoincrementable eliminamos este campo
	
	@Column(name = "NOMBRE")
	private String nombrePropietario;
	
	@Column(name = "APELLIDOS")
	private String apellidosPropietario;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUOTA")
	private Cuota cuota;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMUNIDAD")
	private Comunidad comunidad;
	
	@OneToOne
	@JoinColumn (name = "ID_FINCA")
	private Finca finca;
	
	@OneToMany(mappedBy = "propietario",cascade=CascadeType.ALL)
	private List<Recibo> recibos;
	
	@ManyToOne
	@JoinColumn(name = "ID_CUENTA_BANCO")
	private Banco cuentaBanco;
	
	public Propietario() {
		super();
	}

	
	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}
	
	public Integer getIdPropietario() {
		return idPropietario;
	}
	
	public void setFinca(Finca finca) {
		this.finca = finca;
	}
	
	public Finca getFinca() {
		return finca;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setApellidosPropietario(String apellidosPropietario) {
		this.apellidosPropietario = apellidosPropietario;
	}

	public String getApellidosPropietario() {
		return apellidosPropietario;
	}

	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}
	
	public List<Recibo> getRecibos() {
		return recibos;
	}

	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}

	public Comunidad getComunidad() {
		return comunidad;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public Banco getCuentaBanco() {
		return cuentaBanco;
	}


	public void setCuentaBanco(Banco cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPropietario == null) ? 0 : idPropietario.hashCode());
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
		Propietario other = (Propietario) obj;
		if (idPropietario == null) {
			if (other.idPropietario != null)
				return false;
		} else if (!idPropietario.equals(other.idPropietario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return this.nombrePropietario + " " + this.apellidosPropietario;
	}

	
	
	
	
}
