package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCajaAhorro {

	@Test
	public void testQueVerifiqueQueSeCreeUnaCajaDeAhorro() {
		//Datos de entrada
		String nombreTitular = "Camila";
		CajaAhorro cajaAhorro= new CajaAhorro(nombreTitular);
		
		//Ejecucion
		assertNotNull(cajaAhorro);
	}
	
	@Test
	public void testQueVerifiqueQueSeDepositeEnUnaCajaDeAhorro() {
		//Datos de entrada
		String nombreTitular = "Camila";
		Double montoAdepositar = 220.0;
		final Double valorEsperado = 220.0;
		CajaAhorro cajaAhorro= new CajaAhorro(nombreTitular);
		
		//Ejecucion
		assertTrue(cajaAhorro.depositar(montoAdepositar));
		assertEquals(valorEsperado,cajaAhorro.getSaldo());
	}
	
	@Test
	public void testQuePermitaExtraerEnUnaCajaDeAhorro() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double montoAextraer=100.0;
		final Double valorEsperado=0.0;
		
		//Ejecucion
		CajaAhorro cajaAhorro= new CajaAhorro(nombreTitular);
		cajaAhorro.depositar(montoAdepositar);
		cajaAhorro.extraer(montoAextraer);
		final Double valorObtenido=cajaAhorro.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQuePermitaExtraerEnUnaCajaDeAhorroSinCobrarCostoAdicionalEnLaQuintaExtraccion() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double valorEsperado=50.0;
		
		//Ejecucion
		CajaAhorro cajaAhorro= new CajaAhorro(nombreTitular);
		cajaAhorro.depositar(montoAdepositar);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		final Double valorObtenido=cajaAhorro.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQuePermitaExtraerEnUnaCajaDeAhorroCobrandoCostoAdicional() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double valorEsperado=34.0;
		
		//Ejecucion
		CajaAhorro cajaAhorro= new CajaAhorro(nombreTitular);
		cajaAhorro.depositar(montoAdepositar);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		cajaAhorro.extraer(10.0);
		final Double valorObtenido=cajaAhorro.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
	}

}
