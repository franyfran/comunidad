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

import modelo.bancario.Banco;
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
	@Column (name="NUMERO_RECIBO")
	private Integer numRecibo;
	
	@Column (name = "FECHA_DE_EMISION")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@Column (name = "FECHA_DE_VENCIMIENTO")
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
	
	@Column (name = "IMPORTE")
	private Double importe;
	
	@Column (name = "CONCEPTO")
	private String concepto;
	
	@Column (name = "PAGADO")
	private boolean pagado;
	
	@ManyToOne
	@JoinColumn(name = "ID_BANCO_EMISOR")
	private Banco bancoEmisor;
	
	@ManyToOne
	@JoinColumn(name = "ID_BANCO_RECEPTOR")
	private Banco bancoReceptor;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROPIETARIO")
	private Propietario propietario;
	
	public Recibo(){
		super();
	}

	public Integer getNumRecibo() {
		return numRecibo;
	}

	public void setNumRecibo(Integer numRecibo) {
		this.numRecibo = numRecibo;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEMISION) {
		this.fechaEmision = fechaEMISION;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Banco getBancoEmisor() {
		return bancoEmisor;
	}

	public void setBancoEmisor(Banco bancoEmisor) {
		this.bancoEmisor = bancoEmisor;
	}

	public Banco getBancoReceptor() {
		return bancoReceptor;
	}

	public void setBancoReceptor(Banco bancoReceptor) {
		this.bancoReceptor = bancoReceptor;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bancoEmisor == null) ? 0 : bancoEmisor.hashCode());
		result = prime * result
				+ ((bancoReceptor == null) ? 0 : bancoReceptor.hashCode());
		result = prime * result
				+ ((concepto == null) ? 0 : concepto.hashCode());
		result = prime * result
				+ ((fechaEmision == null) ? 0 : fechaEmision.hashCode());
		result = prime
				* result
				+ ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
		result = prime * result + ((importe == null) ? 0 : importe.hashCode());
		result = prime * result
				+ ((numRecibo == null) ? 0 : numRecibo.hashCode());
		result = prime * result
				+ ((propietario == null) ? 0 : propietario.hashCode());
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
		if (bancoEmisor == null) {
			if (other.bancoEmisor != null)
				return false;
		} else if (!bancoEmisor.equals(other.bancoEmisor))
			return false;
		if (bancoReceptor == null) {
			if (other.bancoReceptor != null)
				return false;
		} else if (!bancoReceptor.equals(other.bancoReceptor))
			return false;
		if (concepto == null) {
			if (other.concepto != null)
				return false;
		} else if (!concepto.equals(other.concepto))
			return false;
		if (fechaEmision == null) {
			if (other.fechaEmision != null)
				return false;
		} else if (!fechaEmision.equals(other.fechaEmision))
			return false;
		if (fechaVencimiento == null) {
			if (other.fechaVencimiento != null)
				return false;
		} else if (!fechaVencimiento.equals(other.fechaVencimiento))
			return false;
		if (importe == null) {
			if (other.importe != null)
				return false;
		} else if (!importe.equals(other.importe))
			return false;
		if (numRecibo == null) {
			if (other.numRecibo != null)
				return false;
		} else if (!numRecibo.equals(other.numRecibo))
			return false;
		if (propietario == null) {
			if (other.propietario != null)
				return false;
		} else if (!propietario.equals(other.propietario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.numRecibo.toString();
	}

	
}
