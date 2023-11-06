package ar.edu.unlam.pb2;

public interface Transferible {

	void depositar(Double importe);
	Boolean extraer(Double importe) throws SaldoInsuficienteException;

}
