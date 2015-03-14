package modelo.propietario;

public class Propietario {
	
	private Integer codPropietario;  //En caso de que se use en BBDD y sea autoincrementable eliminamos este campo
	private Finca finca;
	private String nombrePropietario;
	private String apellidosPropietario;
	
	public Propietario() {
		super();
	}

	public Propietario(Integer codPropietario, Finca finca,
			String nombrePropietario, String apellidosPropietario) {
		super();
		this.codPropietario = codPropietario;
		this.finca = finca;
		this.nombrePropietario = nombrePropietario;
		this.apellidosPropietario = apellidosPropietario;
	}

	public Integer getCodPropietario() {
		return codPropietario;
	}

	public void setCodPropietario(Integer codPropietario) {
		this.codPropietario = codPropietario;
	}

	public Finca getFinca() {
		return finca;
	}

	public void setFinca(Finca finca) {
		this.finca = finca;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public String getApellidosPropietario() {
		return apellidosPropietario;
	}

	public void setApellidosPropietario(String apellidosPropietario) {
		this.apellidosPropietario = apellidosPropietario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finca == null) ? 0 : finca.hashCode());
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
		if (finca == null) {
			if (other.finca != null)
				return false;
		} else if (!finca.equals(other.finca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Propietario [codPropietario=" + codPropietario + ", finca="
				+ finca + ", nombrePropietario=" + nombrePropietario
				+ ", apellidosPropietario=" + apellidosPropietario + "]";
	}
	
	
	
}
