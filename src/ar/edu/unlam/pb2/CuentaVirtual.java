package ar.edu.unlam.pb2;

public class CuentaVirtual extends Cuenta {
	
	public CuentaVirtual(String cvu, String entidad, String titular) throws CVUInvalidoException {
		setNumero(cvu);
		setEntidad(entidad);
		setTitular(titular);
		setSaldo(0.0);
	}

	@Override
	public String getNumero() {
		return numero;
	}

	@Override
	public void setNumero(String cvu) throws CVUInvalidoException {
		Integer extension = cvu.length();
		if(extension!=23)
			throw new CVUInvalidoException();
		
		this.numero = cvu;
	}

	@Override
	public Double getSaldo() {
		return saldo;
	}

	

}
