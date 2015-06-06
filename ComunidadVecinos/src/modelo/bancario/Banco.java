package modelo.bancario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CUENTA_BANCO")
public class Banco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2939801543035189756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID_CUENTA_BANCO")
	private Integer idCuentaBanco;
	
	@Column (name="NOMBRE")
	private String nombreBanco;
	
	@Column (name="SUCURSAL")
	private String sucursal;
	
	@Column (name="NUMERO_CUENTA")
	private String numeroCuenta;
	
	public Banco() {
		super();
	}

	public Banco(String nombreBanco, String sucursal, String numeroCuenta) {
		super();
		this.nombreBanco = nombreBanco;
		this.sucursal = sucursal;
		this.numeroCuenta = numeroCuenta;
	}
	
	

	public Integer getIdCuentaBanco() {
		return idCuentaBanco;
	}

	public void setIdCuentaBanco(Integer idCuentaBanco) {
		this.idCuentaBanco = idCuentaBanco;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCuentaBanco == null) ? 0 : idCuentaBanco.hashCode());
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
		Banco other = (Banco) obj;
		if (idCuentaBanco == null) {
			if (other.idCuentaBanco != null)
				return false;
		} else if (!idCuentaBanco.equals(other.idCuentaBanco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getNombreBanco() + " " + this.getSucursal() + " " + this.getNumeroCuenta();
	}

	
}
