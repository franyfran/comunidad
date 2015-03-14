package modelo.reuniones;

import java.util.Date;
import java.util.List;

public class Reunion {

	private String asunto;
	private Date fecha;
	private List<String> ordenDelDia;
	public Reunion() {
		super();
	}
	public Reunion(String asunto, Date fecha, List<String> ordenDelDia) {
		super();
		this.asunto = asunto;
		this.fecha = fecha;
		this.ordenDelDia = ordenDelDia;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<String> getOrdenDelDia() {
		return ordenDelDia;
	}
	public void setOrdenDelDia(List<String> ordenDelDia) {
		this.ordenDelDia = ordenDelDia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Reunion other = (Reunion) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reunion [asunto=" + asunto + ", fecha=" + fecha
				+ ", ordenDelDia=" + ordenDelDia + "]";
	}
	
	
}
