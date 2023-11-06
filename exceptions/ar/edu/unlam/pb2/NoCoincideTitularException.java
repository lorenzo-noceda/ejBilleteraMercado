package ar.edu.unlam.pb2;

public class NoCoincideTitularException extends Exception {

	public NoCoincideTitularException() {
		super("El titular no fue encontrado");
	}
}
