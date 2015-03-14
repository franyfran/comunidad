package modelo.contabilidad;

public class Derrama {

	private String descripcion;
	private Float coste;
	public Derrama() {
		super();
	}
	public Derrama(String descripcion, Float coste) {
		super();
		this.descripcion = descripcion;
		this.coste = coste;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getCoste() {
		return coste;
	}
	public void setCoste(Float coste) {
		this.coste = coste;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coste == null) ? 0 : coste.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
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
		Derrama other = (Derrama) obj;
		if (coste == null) {
			if (other.coste != null)
				return false;
		} else if (!coste.equals(other.coste))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Derrama [descripcion=" + descripcion + ", coste=" + coste + "]";
	}
	
	
}
