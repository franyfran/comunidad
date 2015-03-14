package modelo.contabilidad;

public class Servicios {

	private Float precioUnitAgua;
	private Float precioUnitGas;
	private Float precioUnitElectricidad;
	public Servicios() {
		super();
	}
	public Servicios(Float precioUnitAgua, Float precioUnitGas,
			Float precioUnitElectricidad) {
		super();
		this.precioUnitAgua = precioUnitAgua;
		this.precioUnitGas = precioUnitGas;
		this.precioUnitElectricidad = precioUnitElectricidad;
	}
	public Float getPrecioUnitAgua() {
		return precioUnitAgua;
	}
	public void setPrecioUnitAgua(Float precioUnitAgua) {
		this.precioUnitAgua = precioUnitAgua;
	}
	public Float getPrecioUnitGas() {
		return precioUnitGas;
	}
	public void setPrecioUnitGas(Float precioUnitGas) {
		this.precioUnitGas = precioUnitGas;
	}
	public Float getPrecioUnitElectricidad() {
		return precioUnitElectricidad;
	}
	public void setPrecioUnitElectricidad(Float precioUnitElectricidad) {
		this.precioUnitElectricidad = precioUnitElectricidad;
	}
	@Override
	public String toString() {
		return "Servicios [precioUnitAgua=" + precioUnitAgua
				+ ", precioUnitGas=" + precioUnitGas
				+ ", precioUnitElectricidad=" + precioUnitElectricidad + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((precioUnitAgua == null) ? 0 : precioUnitAgua.hashCode());
		result = prime
				* result
				+ ((precioUnitElectricidad == null) ? 0
						: precioUnitElectricidad.hashCode());
		result = prime * result
				+ ((precioUnitGas == null) ? 0 : precioUnitGas.hashCode());
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
		Servicios other = (Servicios) obj;
		if (precioUnitAgua == null) {
			if (other.precioUnitAgua != null)
				return false;
		} else if (!precioUnitAgua.equals(other.precioUnitAgua))
			return false;
		if (precioUnitElectricidad == null) {
			if (other.precioUnitElectricidad != null)
				return false;
		} else if (!precioUnitElectricidad.equals(other.precioUnitElectricidad))
			return false;
		if (precioUnitGas == null) {
			if (other.precioUnitGas != null)
				return false;
		} else if (!precioUnitGas.equals(other.precioUnitGas))
			return false;
		return true;
	}
	
	
}
