package modelo.bancario;

public class CuentaBanco {

	private String nombreBanco;
	private String sucursal;
	private String numeroCuenta;
	
	public CuentaBanco() {
		super();
	}

	public CuentaBanco(String nombreBanco, String sucursal, String numeroCuenta) {
		super();
		this.nombreBanco = nombreBanco;
		this.sucursal = sucursal;
		this.numeroCuenta = numeroCuenta;
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
				+ ((numeroCuenta == null) ? 0 : numeroCuenta.hashCode());
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
		CuentaBanco other = (CuentaBanco) obj;
		if (numeroCuenta == null) {
			if (other.numeroCuenta != null)
				return false;
		} else if (!numeroCuenta.equals(other.numeroCuenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CuentaBanco [nombreBanco=" + nombreBanco + ", sucursal="
				+ sucursal + ", numeroCuenta=" + numeroCuenta + "]";
	}
	
	
}
