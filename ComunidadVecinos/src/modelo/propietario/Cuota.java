package modelo.propietario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUOTA")
public class Cuota implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2021988168204508605L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID_CUOTA")
	private Integer idCuota;
	
	@Column(name = "IMPORTE")
	private double importe;
	
	@Enumerated(EnumType.ORDINAL)
	private Periodicidad periodo;
	
	public double getImporte() {
		return importe;
	}
	public void setImporte(double cuota) {
		this.importe = cuota;
	}
	public Integer getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(Integer idCuota) {
		this.idCuota = idCuota;
	}
	public Periodicidad getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodicidad periodo) {
		this.periodo = periodo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCuota == null) ? 0 : idCuota.hashCode());
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
		Cuota other = (Cuota) obj;
		if (idCuota == null) {
			if (other.idCuota != null)
				return false;
		} else if (!idCuota.equals(other.idCuota))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cuota [idCuota=" + idCuota + ", importe=" + importe
				+ ", periodo=" + periodo + "]";
	}
	
}
