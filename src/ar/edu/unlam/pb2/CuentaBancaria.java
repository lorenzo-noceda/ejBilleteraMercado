package ar.edu.unlam.pb2;

public class CuentaBancaria extends Cuenta {	
	public CuentaBancaria(String cbu, String entidad, String titular) throws CBUInvalidoException {
		setNumero(cbu);
		setEntidad(entidad);
		setTitular(titular);
		setSaldo(0.0);
	}

	@Override
	public String getNumero() {
		return numero;
	}

	
	public void setNumero(String cbu) throws CBUInvalidoException {
		Integer extension = cbu.length();
		if(extension!=20)
			throw new CBUInvalidoException();
		
		this.numero = cbu;
	}

	@Override
	public Double getSaldo() {
		return saldo;
	}

}

