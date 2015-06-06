package modelo.propietario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FINCA")
public class Finca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FINCA")
	private Integer idFinca;

	@Column(name = "PLANTA")
	private Integer planta;

	@Column(name = "PUERTA")
	private String puerta;

	public Finca() {
		super();
	}

	public Finca(int planta, String puerta) {
		super();
		this.planta = planta;
		this.puerta = puerta;

	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public Integer getIdFinca() {
		return idFinca;
	}

	public void setIdFinca(Integer idFinca) {
		this.idFinca = idFinca;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFinca == null) ? 0 : idFinca.hashCode());
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
		if (idFinca == null) {
			if (other.idFinca != null)
				return false;
		} else if (!idFinca.equals(other.idFinca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Planta " + planta + " Puerta " + puerta;
	}

}
