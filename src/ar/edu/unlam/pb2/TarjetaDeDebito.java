package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends Tarjeta {
	
	public TarjetaDeDebito(String numero, String titular, String fechaDeVencimiento, Integer codigoDeSeguridad) throws NumeroDeTarjetaInvalidoException {
		setNumero(numero);
		setTitular(titular);
		setFechaDeVencimiento(fechaDeVencimiento);
		setCodigoDeSeguridad(codigoDeSeguridad);
		setSaldo(0.0);
	}

	@Override
	public Double getSaldo() {
		return saldo;
	}

	
}
