package ar.edu.unlam.pb2;


public abstract class Tarjeta extends MedioDePago{
	private String fechaDeVencimiento;
	private Integer codigoDeSeguridad;
	

	public void setNumero(String numero) throws NumeroDeTarjetaInvalidoException {
		Integer extension = numero.toString().length();
		
		if(extension != 16)
			throw new NumeroDeTarjetaInvalidoException();
		
		this.numero = numero;
	}

	public Integer getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}
	public void setCodigoDeSeguridad(Integer codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}
	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}
	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	
	
	
}
