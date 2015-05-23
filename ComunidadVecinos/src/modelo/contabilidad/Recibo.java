package modelo.contabilidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import modelo.propietario.Propietario;

@Entity
@Table (name = "RECIBO")
public class Recibo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6129933480339291108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID_RECIBO")
	private Integer idRecibo;
	
	@Column (name = "FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column (name = "IMPORTE")
	private Double importe;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROPIETARIO")
	private Propietario propietario;
	
	
	
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Integer getIdRecibo() {
		return idRecibo;
	}
	public void setIdRecibo(Integer idRecibo) {
		this.idRecibo = idRecibo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRecibo == null) ? 0 : idRecibo.hashCode());
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
		Recibo other = (Recibo) obj;
		if (idRecibo == null) {
			if (other.idRecibo != null)
				return false;
		} else if (!idRecibo.equals(other.idRecibo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Recibo [idRecibo=" + idRecibo + ", fecha=" + fecha
				+ ", importe=" + importe + ", propietario=" + propietario + "]";
	} 

	
}
