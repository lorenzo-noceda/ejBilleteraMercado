package ar.edu.unlam.pb2;

public class CuitInvalidoException extends Exception {

	public CuitInvalidoException() {
		super("El Cuit es incorrecto");
	}
}
