package ar.edu.unlam.pb2;

public class CVUInvalidoException extends Exception {

	public CVUInvalidoException() {
		super("El numero de tarjeta debe estar compuesto de 23 digitos");
	}
}
