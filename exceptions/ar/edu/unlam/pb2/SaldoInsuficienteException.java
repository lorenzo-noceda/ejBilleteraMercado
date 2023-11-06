package ar.edu.unlam.pb2;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException() {
		super("La compra excede el el saldo disponible");
	}
}
