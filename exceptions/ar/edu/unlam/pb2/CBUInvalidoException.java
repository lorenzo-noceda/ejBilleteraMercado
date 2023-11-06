package ar.edu.unlam.pb2;

public class CBUInvalidoException extends Exception {

	public CBUInvalidoException() {
		super("El numero de tarjeta debe estar compuesto de 20 digitos");
	}
}
