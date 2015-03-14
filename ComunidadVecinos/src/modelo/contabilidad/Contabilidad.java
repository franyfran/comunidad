package modelo.contabilidad;

import java.util.List;

public class Contabilidad {
	
	private Float presupuesto;
	private Float cuota;
	private List<Derrama> derramas;
	private final static Float IVA = 21.0f;
	
	public Contabilidad() {
		super();
	}

	public Contabilidad(Float presupuesto, Float cuota, List<Derrama> derramas) {
		super();
		this.presupuesto = presupuesto;
		this.cuota = cuota;
		this.derramas = derramas;
	}

	public Float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Float getCuota() {
		return cuota;
	}

	public void setCuota(Float cuota) {
		this.cuota = cuota;
	}

	public List<Derrama> getDerramas() {
		return derramas;
	}

	public void setDerramas(List<Derrama> derramas) {
		this.derramas = derramas;
	}

	public static Float getIva() {
		return IVA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuota == null) ? 0 : cuota.hashCode());
		result = prime * result
				+ ((derramas == null) ? 0 : derramas.hashCode());
		result = prime * result
				+ ((presupuesto == null) ? 0 : presupuesto.hashCode());
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
		Contabilidad other = (Contabilidad) obj;
		if (cuota == null) {
			if (other.cuota != null)
				return false;
		} else if (!cuota.equals(other.cuota))
			return false;
		if (derramas == null) {
			if (other.derramas != null)
				return false;
		} else if (!derramas.equals(other.derramas))
			return false;
		if (presupuesto == null) {
			if (other.presupuesto != null)
				return false;
		} else if (!presupuesto.equals(other.presupuesto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contabilidad [presupuesto=" + presupuesto + ", cuota=" + cuota
				+ ", derramas=" + derramas + "]";
	}
	
	
}
