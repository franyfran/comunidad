package modelo.propietario;

public enum Periodicidad {

	MES(1, "Mensual"), BIMESTRE(2, "Bimestral"), TRIMESTRE(3, "Trimestral"), SEMESTRE(
			4, "Semestral"), ANUAL(5, "Anual");

	private Integer id;
	private String descripcion;

	Periodicidad(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
