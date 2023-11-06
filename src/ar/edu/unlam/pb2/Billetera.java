package ar.edu.unlam.pb2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Billetera implements Pagadora {
	String nombre;
	private Set<Comercio> comercios;
	private Set<Consumidor> consumidores;
	static Integer codigoQR = 0;
	
	public Billetera(String nombre) {
		this.nombre = nombre;
		comercios = new HashSet<>();
		consumidores = new TreeSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarComercio(Comercio comercio) {
		comercios.add(comercio);
		
	}

	public Integer getCantidadDeComercios() {
		return comercios.size();
	}

	public void agregarConsumidor(Consumidor consumidor) {
		consumidores.add(consumidor);
	}

	public Integer getCantidadDeConsumidores() {
		return consumidores.size();
	}

	public void agregarMedioDePago(Integer dni, MedioDePago mp) throws NoCoincideTitularException {
		Consumidor consumidor = getConsumidor(dni);
		consumidor.agregarMedioPagador(mp);
	}

	public Consumidor getConsumidor(Integer dni) throws NoCoincideTitularException {
		for(Consumidor c: consumidores) {
			if(c.getDni().equals(dni))
				return c;
		}
		throw new NoCoincideTitularException();
	}

	public Integer getCantidadDeMediosDePago(Integer dni) throws NoCoincideTitularException {
		Consumidor consumidor = getConsumidor(dni);
		
		return consumidor.getCantidadDeMediosPagadores();
//		Collection<Integer> titulares = mediosDePago.values();
//		for(Integer i: titulares) {
//			if(i == dni)
//				contador++;
//		}
	}

	public Compra generarCodigoQR(Long cuit, Double importe) {
		Compra QR = new Compra(codigoQR, cuit, importe);
		codigoQR++;
		return QR;
	}


	@Override
	public Boolean pagar(Compra codigoQR, MedioDePago medioDePago) throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		if(medioDePago instanceof Cuenta)
			return false;
		
		if(medioDePago instanceof TarjetaDeCredito) {
			TarjetaDeCredito tarjeta = (TarjetaDeCredito) medioDePago;
			if(codigoQR.getImporte() > tarjeta.getSaldo())
				throw new ExcedeLimiteDeCompraException();
		} else {
			TarjetaDeDebito tarjeta = (TarjetaDeDebito) medioDePago;		
			if(codigoQR.getImporte() > tarjeta.getSaldo())
				throw new SaldoInsuficienteException();
		}
		
		return true;
	}

	public Boolean transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, Double saldo) throws SaldoInsuficienteException {
		cuentaOrigen.extraer(saldo);
		cuentaDestino.depositar(saldo);
		return true;
	}

}
