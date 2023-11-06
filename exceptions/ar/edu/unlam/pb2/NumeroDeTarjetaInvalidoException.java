package ar.edu.unlam.pb2;

public class NumeroDeTarjetaInvalidoException extends Exception {

	public NumeroDeTarjetaInvalidoException() {
		super("El numero de tarjeta debe estar compuesto de 16 digitos");
	}
}
