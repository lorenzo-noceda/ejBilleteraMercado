package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaCrearUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final String NUMERO_ESPERADO = "5446789813221201";
		final String TITULAR_ESPERADO = "CAMILA CIENFUEGOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 123;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2022";
		final double SALDO_ESPERADO = 10000.0;
		
		// Ejecuci�n
		Tarjeta tarjetaDeDebito = new TarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO);
		tarjetaDeDebito.setSaldo(10000.0);
		
		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, tarjetaDeDebito.getNumero());
		assertEquals(TITULAR_ESPERADO, tarjetaDeDebito.getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeDebito.getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeDebito.getFechaDeVencimiento());
		assertEquals(SALDO_ESPERADO, tarjetaDeDebito.getSaldo(), 0.01);
	}
	@Test
	public void queSePuedaCrearUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final String NUMERO_ESPERADO = "4246789813221201";
		final String TITULAR_ESPERADO = "SOFIA BARRIENTOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 567;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2025";
		final Double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final Double LIMITE_COMPRA_EN_DOLARES = 1000.0;
		
		// Ejecuci�n
		Tarjeta tarjetaDeCredito = new TarjetaDeCredito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO, LIMITE_COMPRA_EN_PESOS, LIMITE_COMPRA_EN_DOLARES);

		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, tarjetaDeCredito.getNumero());
		assertEquals(TITULAR_ESPERADO, tarjetaDeCredito.getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeCredito.getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeCredito.getFechaDeVencimiento());
		assertEquals(LIMITE_COMPRA_EN_PESOS, ((TarjetaDeCredito)tarjetaDeCredito).getLimiteDeCompraEnPesos(), 0.1);
		assertEquals(LIMITE_COMPRA_EN_DOLARES, ((TarjetaDeCredito)tarjetaDeCredito).getLimiteDeCompraEnDolares(), 0.1);
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaBancaria() throws CBUInvalidoException{
		// Preparaci�n 
		final String CBU_ESPERADO = "01702046600000087865";
		final String ENTIDAD_ESPERADA = "Santander";
		final String TITULAR_ESPERADO = "Vicente De La Pradera";
		
		// Ejeruci�n
		Cuenta cuentaBancaria = new CuentaBancaria(CBU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificaci�n
		assertEquals(CBU_ESPERADO, cuentaBancaria.getNumero());
		assertEquals(ENTIDAD_ESPERADA, cuentaBancaria.getEntidad());
		assertEquals(TITULAR_ESPERADO, cuentaBancaria.getTitular());
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaVirtual() throws CVUInvalidoException{
		// Preparaci�n 
		final String CVU_ESPERADO = "46467898132212011234552";
		final String ENTIDAD_ESPERADA = "Mercado Pago";
		final String TITULAR_ESPERADO = "Leticia Bridgeton";
		
		// Ejecuci�n
		Cuenta cuentaVirtual = new CuentaVirtual(CVU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificaci�n
		assertEquals(CVU_ESPERADO, cuentaVirtual.getNumero());
		assertEquals(ENTIDAD_ESPERADA, cuentaVirtual.getEntidad());
		assertEquals(TITULAR_ESPERADO, cuentaVirtual.getTitular());
	}
	
	@Test
	public void queSePuedaCrearUnComercio() throws CuitInvalidoException{
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "El almacen de la esquina";
		final Long CUIT_ESPERADO = 30215654124L;
		
		// Ejecuci�n
		Comercio elAlmacen = new Comercio(CUIT_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, elAlmacen.getNombre());
		assertEquals(CUIT_ESPERADO, elAlmacen.getCuit());
	}
	
	@Test
	public void queSePuedaCrearUnConsumidor() {
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "Erika Romeo";
		final Integer DNI_ESPERADO = 33458712;
		
		// Ejecuci�n
		Consumidor nuevo = new Consumidor(DNI_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, nuevo.getNombre());
		assertEquals(DNI_ESPERADO, nuevo.getDni());
	}
	
	@Test
	public void queSePuedanAgregarComerciosALaBilletera() throws CuitInvalidoException{
		// Preparaci�n 
		final Integer CANTIDAD_DE_COMERCIOS_ESPERADOS = 2;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("Ank");
		
		mataGalan.agregarComercio(new Comercio(30456213545L, "Supermercado"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panader�a"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panader�a"));
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_COMERCIOS_ESPERADOS, mataGalan.getCantidadDeComercios());
	}
	
	@Test
	public void queSePuedanAgregarConsumidoresALaBilletera() {
		// Preparaci�n 
		final Integer CANTIDAD_DE_CONSUMIDORES_ESPERADOS = 2;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("Bna+");
		
		mataGalan.agregarConsumidor(new Consumidor(36541231, "Sofia Molina"));
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_CONSUMIDORES_ESPERADOS, mataGalan.getCantidadDeConsumidores());
	}
	
	@Test
	public void queSePuedanAgregarDistintosMediosDePagoALaBilleteraDeUnConsumidor() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, NoCoincideTitularException{
		// Preparaci�n 
		final Integer CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS = 4;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("MercadoPago");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito("4833256215325462", "Luis Gomez", "10/10/2026", 265));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito("4833256215325462", "Luis Gomez", "10/10/2026", 312));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito("5423542385612354", "Luis Gomez", "10/10/2026", 153));
		mataGalan.agregarMedioDePago(27541231, new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new CuentaVirtual("00000031000365215718062", "Mercado Pago", "Luis Gomez"));
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS, mataGalan.getCantidadDeMediosDePago(27541231));
	}
	
	@Test
	public void queSePuedaPagarConUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, ExcedeLimiteDeCompraException, NoCoincideTitularException, CuitInvalidoException, MedioNoEncontradoException, SaldoInsuficienteException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito("4833256215325462", "Luis Gomez", "10/10/2026", 265, 100000.0, 1000.0));
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1000.0);
		Boolean resultado = mataGalan.pagar(codigoQR, mataGalan.getConsumidor(27541231).getMedioPagador("4833256215325462"));
		
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaTransferirDeUnaCuentaAOtra() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, SaldoInsuficienteException, NoCoincideTitularException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ual�");
		Cuenta cuentaOrigen = new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez");
		cuentaOrigen.setSaldo(15000.0);
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		mataGalan.agregarMedioDePago(27541231, cuentaOrigen);
		
		Cuenta cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, cuentaDestino);
				
		// Ejecuci�n
		Boolean resultado = mataGalan.transferir(cuentaOrigen, cuentaDestino, 1000.0);
				
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaTransferirSiElSaldoNoEsSuficiente() throws CBUInvalidoException, NoCoincideTitularException, SaldoInsuficienteException {
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ual�");
		Cuenta cuentaOrigen = new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez");
		cuentaOrigen.setSaldo(15000.0);
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		mataGalan.agregarMedioDePago(27541231, cuentaOrigen);
		
		Cuenta cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, cuentaDestino);
				
		mataGalan.transferir(cuentaOrigen, cuentaDestino, 100000.0);
	}
	
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaComprarSiElSaldoDeLaTarjetaDeDebitoEsInsuficiente() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, ExcedeLimiteDeCompraException, NoCoincideTitularException, CuitInvalidoException, MedioNoEncontradoException, SaldoInsuficienteException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito("4833256215325462", "Luis Gomez", "10/10/2026", 265));
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1000.0);
		mataGalan.pagar(codigoQR, mataGalan.getConsumidor(27541231).getMedioPagador("4833256215325462"));
	
	}
	
	@Test (expected=ExcedeLimiteDeCompraException.class)
	public void queNoSePuedaComprarSiSeExcedeElLimiteDeCompraDeLaTarjetaDeCredito() throws NoCoincideTitularException, NumeroDeTarjetaInvalidoException, CuitInvalidoException, ExcedeLimiteDeCompraException, SaldoInsuficienteException, MedioNoEncontradoException {
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito("4833256215325462", "Luis Gomez", "10/10/2026", 265, 10000.0, 1000.0));
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 20000.0);
		mataGalan.pagar(codigoQR, mataGalan.getConsumidor(27541231).getMedioPagador("4833256215325462"));

	}

}
