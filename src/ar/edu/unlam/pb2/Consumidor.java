package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Consumidor implements Comparable<Consumidor> {
	private String nombre;
	private Integer dni;
	private Set<MedioDePago> mediosDePago;
	
	public Consumidor(Integer dni, String nombre) {
		this.nombre = nombre;
		this.dni = dni;
		mediosDePago = new HashSet<>();
	}
	
	public void agregarMedioPagador(MedioDePago medio) {
		mediosDePago.add(medio);
	}
	
	public MedioDePago getMedioPagador(String numero) throws MedioNoEncontradoException {
		for(MedioDePago mp: mediosDePago) {
			if(mp.getNumero().equals(numero))
				return mp;
		}
		throw new MedioNoEncontradoException();
	}
	
	public Integer getCantidadDeMediosPagadores() {
		return mediosDePago.size();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Override
	public int compareTo(Consumidor o) {
		return this.dni.compareTo(o.dni);
	}

	@Override
	public String toString() {
		return "Consumidor [nombre=" + nombre + ", dni=" + dni + "]";
	}

	
	
}
