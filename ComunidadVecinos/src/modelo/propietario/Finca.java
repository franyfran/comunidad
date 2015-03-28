package modelo.propietario;

public class Finca {
	
	private Integer planta;
	private Character puerta;
	private Float superficie;
	
	
	
	public Finca() {
		super();
	}

	public Finca(int planta, char puerta, float superficie) {
		super();
		this.planta = planta;
		this.puerta = puerta;
		this.superficie = superficie;
	}
	
	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public char getPuerta() {
		return puerta;
	}

	public void setPuerta(char puerta) {
		this.puerta = puerta;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planta == null) ? 0 : planta.hashCode());
		result = prime * result + ((puerta == null) ? 0 : puerta.hashCode());
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
		Finca other = (Finca) obj;
		if (planta == null) {
			if (other.planta != null)
				return false;
		} else if (!planta.equals(other.planta))
			return false;
		if (puerta == null) {
			if (other.puerta != null)
				return false;
		} else if (!puerta.equals(other.puerta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Planta " + this.planta + ", Puerta " + this.puerta + ", superficie: " + this.superficie;
	}
	
	
}
