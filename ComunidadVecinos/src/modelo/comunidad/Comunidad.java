package modelo.comunidad;

import java.util.List;

import modelo.bancario.CuentaBanco;
import modelo.propietario.Propietario;

public class Comunidad {

	private String nombreEdificio;
	private String direccion ;
	private String poblacion;
	private Integer codigoPostal;
	private String provincia;
	private List<Propietario> propietarios;
	private Float precioUnitAgua;
	private Float precioUnitGas;
	private Float precioUnitElectricidad;
	private CuentaBanco cuentaBanco;
	
	public Comunidad() {
		super();
	}
	
	public Comunidad(String nombreEdificio, String direccion, String poblacion,
			Integer codigoPostal, String provincia,
			List<Propietario> propietarios, Float precioUnitAgua,
			Float precioUnitGas, Float precioUnitElectricidad,
			CuentaBanco cuentaBanco) {
		super();
		this.nombreEdificio = nombreEdificio;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.propietarios = propietarios;
		this.precioUnitAgua = precioUnitAgua;
		this.precioUnitGas = precioUnitGas;
		this.precioUnitElectricidad = precioUnitElectricidad;
		this.cuentaBanco = cuentaBanco;
	}
	
	public String getNombreEdificio() {
		return nombreEdificio;
	}
	public void setNombreEdificio(String nombreEdificio) {
		this.nombreEdificio = nombreEdificio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public List<Propietario> getPropietarios() {
		return propietarios;
	}
	public void setPropietarios(List<Propietario> propietarios) {
		this.propietarios = propietarios;
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
	public CuentaBanco getCuentaBanco() {
		return cuentaBanco;
	}
	public void setCuentaBanco(CuentaBanco cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	@Override
	public String toString() {
		return "Comunidad [nombreEdificio=" + nombreEdificio + ", direccion="
				+ direccion + ", poblacion=" + poblacion + ", codigoPostal="
				+ codigoPostal + ", provincia=" + provincia + ", propietarios="
				+ propietarios + ", precioUnitAgua=" + precioUnitAgua
				+ ", precioUnitGas=" + precioUnitGas
				+ ", precioUnitElectricidad=" + precioUnitElectricidad
				+ ", cuentaBanco=" + cuentaBanco + "]";
	}
	
	
	
}
