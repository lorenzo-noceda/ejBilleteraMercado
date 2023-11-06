package ar.edu.unlam.pb2;

public class MedioNoEncontradoException extends Exception {

	public MedioNoEncontradoException() {
		super("El medio de pago no fue encontrado");
	}
}
