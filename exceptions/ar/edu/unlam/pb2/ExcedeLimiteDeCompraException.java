package ar.edu.unlam.pb2;

public class ExcedeLimiteDeCompraException extends Exception {

	public ExcedeLimiteDeCompraException() {
		super("La compra excede el limite de compra");
	}
}
