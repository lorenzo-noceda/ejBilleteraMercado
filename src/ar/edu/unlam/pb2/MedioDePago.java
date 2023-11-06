package ar.edu.unlam.pb2;

import java.util.Objects;

public abstract class MedioDePago {
	String titular;
	Double saldo;
	String numero;
	
	public String getNumero() {
		return numero;
	}
	public abstract void setNumero(String numero) throws CBUInvalidoException, CVUInvalidoException, NumeroDeTarjetaInvalidoException;
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public abstract Double getSaldo();
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MedioDePago))
			return false;
		MedioDePago other = (MedioDePago) obj;
		return Objects.equals(numero, other.numero);
	}
	
	
}
