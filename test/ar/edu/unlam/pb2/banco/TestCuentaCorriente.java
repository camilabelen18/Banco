package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaCorriente {

	@Test
	public void testQueVerifiqueQueSePuedaCrearUnaCuentaCorriente() {
		//Datos de entrada
		String nombreTitular= "Luz";
		CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreTitular);
		
		//Verificacion
		
		assertNotNull(cuentaCorriente);
		
	}
	
	@Test
	public void testQueVerifiqueQueSePuedaDepositar() {
		//Datos de entrada
		String nombreTitular= "Luz";
		final Double montoAdepositar = 100.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreTitular);
		
		//Verificacion
		assertTrue(cuentaCorriente.depositar(montoAdepositar));
		
	}
	
	@Test
	public void testQueVerifiqueQueSePuedaExtraer() {
		//Datos de entrada
		String nombreTitular= "Luz";
		final Double montoAdepositar = 100.0;
		final Double montoAextraer = 100.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreTitular);
		
		//Verificacion
		cuentaCorriente.depositar(montoAdepositar);
		assertTrue(cuentaCorriente.extraer(montoAextraer));
	}
	
	@Test
	public void testQueVerifiqueQueCuandoSeDepositeSoloSeCubraLaDeuda() {
		//Datos de entrada
		String nombreTitular= "Luz";
		final Double montoAdepositar = 100.0;
		final Double montoAextraer = 150.0;
		final Double montoAdepositar2 = 2.5;
		final Double deudaEsperada = 0.0;
		final Double descubiertoEsperado = 50.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreTitular);
		
		//Verificacion
		cuentaCorriente.depositar(montoAdepositar);
		cuentaCorriente.extraer(montoAextraer);
		cuentaCorriente.depositar(montoAdepositar2);
		
		assertEquals(deudaEsperada,cuentaCorriente.getDeuda());
		assertEquals(descubiertoEsperado,cuentaCorriente.getDescubiertoAusar());
		
	}
	
	@Test
	public void testQueVerifiqueQueCuandoSeDepositeSoloSeCubraLaDeudaYelDescubierto() {
		//Datos de entrada
		String nombreTitular= "Luz";
		final Double montoAdepositar = 100.0;
		final Double montoAextraer = 150.0;
		final Double montoAdepositar2 = 52.5;
		final Double deudaEsperada = 0.0;
		final Double descubiertoEsperado = 0.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreTitular);
		
		//Verificacion
		cuentaCorriente.depositar(montoAdepositar);
		cuentaCorriente.extraer(montoAextraer);
		cuentaCorriente.depositar(montoAdepositar2);
		
		assertEquals(deudaEsperada,cuentaCorriente.getDeuda());
		assertEquals(descubiertoEsperado,cuentaCorriente.getDescubiertoAusar());
		
	}
	
	@Test
	public void testQueVerifiqueQueCuandoSeDepositeSoloSeCubraLaDeudaElDescubiertoYpuedaDepositar() {
		//Datos de entrada
		String nombreTitular= "Luz";
		final Double montoAdepositar = 100.0;
		final Double montoAextraer = 150.0;
		final Double montoAdepositar2 = 152.5;
		final Double deudaEsperada = 0.0;
		final Double descubiertoEsperado = 0.0;
		final Double saldoEsperado = 100.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreTitular);
		
		//Verificacion
		cuentaCorriente.depositar(montoAdepositar);
		cuentaCorriente.extraer(montoAextraer);
		cuentaCorriente.depositar(montoAdepositar2);
		
		assertEquals(deudaEsperada,cuentaCorriente.getDeuda());
		assertEquals(descubiertoEsperado,cuentaCorriente.getDescubiertoAusar());
		assertEquals(saldoEsperado,cuentaCorriente.getSaldo());
	}
	

}
