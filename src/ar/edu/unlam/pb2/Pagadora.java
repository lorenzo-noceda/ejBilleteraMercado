package ar.edu.unlam.pb2;

public interface Pagadora {

	Boolean pagar(Compra compra, MedioDePago mp) throws ExcedeLimiteDeCompraException, SaldoInsuficienteException;

}
