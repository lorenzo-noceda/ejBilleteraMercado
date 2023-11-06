package ar.edu.unlam.pb2;

import java.util.Objects;

public class Comercio {
	private String nombre;
	private Long cuit;
	
	public Comercio(Long cuit, String nombre) throws CuitInvalidoException {
		this.nombre = nombre;
		setCuit(cuit);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) throws CuitInvalidoException {
		Integer extension = cuit.toString().length();
		char primerDigito = cuit.toString().charAt(0);
		char segundoDigito = cuit.toString().charAt(1);
		
		if(extension!=11 || primerDigito!='3' || segundoDigito!='0')
			throw new CuitInvalidoException();
			
		this.cuit = cuit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comercio))
			return false;
		Comercio other = (Comercio) obj;
		return Objects.equals(cuit, other.cuit);
	}
	
}
