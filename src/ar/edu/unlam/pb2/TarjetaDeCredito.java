package ar.edu.unlam.pb2;

public class TarjetaDeCredito extends Tarjeta{
	private Double limiteDeCompraEnPesos;
	private Double limiteDeCompraEnDolares;

	public TarjetaDeCredito(String numero, String titular, String fechaDeVencimiento, Integer codigoDeSeguridad,
			Double limiteDeCompraEnPesos, Double limiteDeCompraEnDolares) throws NumeroDeTarjetaInvalidoException {
		setNumero(numero);
		setTitular(titular);
		setFechaDeVencimiento(fechaDeVencimiento);
		setCodigoDeSeguridad(codigoDeSeguridad);
		setSaldo(0.0);
		this.limiteDeCompraEnPesos = limiteDeCompraEnPesos;
		this.limiteDeCompraEnDolares = limiteDeCompraEnDolares;
	}

	public TarjetaDeCredito(String numero, String titular, String fechaDeVencimiento, Integer codigoDeSeguridad)
			throws NumeroDeTarjetaInvalidoException {
		setNumero(numero);
		setTitular(titular);
		setFechaDeVencimiento(fechaDeVencimiento);
		setCodigoDeSeguridad(codigoDeSeguridad);
		setSaldo(0.0);
	}

	public Double getLimiteDeCompraEnPesos() {
		return limiteDeCompraEnPesos;
	}

	public void setLimiteDeCompraEnPesos(Double limiteDeCompraEnPesos) {
		this.limiteDeCompraEnPesos = limiteDeCompraEnPesos;
	}

	public Double getLimiteDeCompraEnDolares() {
		return limiteDeCompraEnDolares;
	}

	public void setLimiteDeCompraEnDolares(Double limiteDeCompraEnDolares) {
		this.limiteDeCompraEnDolares = limiteDeCompraEnDolares;
	}

	public Double getSaldo() {
		return limiteDeCompraEnPesos;
	}


}
