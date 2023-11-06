package ar.edu.unlam.pb2;

public abstract class Cuenta extends MedioDePago implements Transferible{
	String entidad;
	
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	
	public abstract String getNumero();
	
	public abstract void setNumero(String numero) throws CBUInvalidoException, CVUInvalidoException;
	
	@Override
	public void depositar(Double importe) {
		setSaldo(getSaldo()+importe);
		
	}

	@Override
	public Boolean extraer(Double importe) throws SaldoInsuficienteException {
		if(importe > getSaldo())
			throw new SaldoInsuficienteException();
		
		setSaldo(getSaldo()-importe);
		return true;
	}
}
