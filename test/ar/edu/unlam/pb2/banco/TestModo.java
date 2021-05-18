package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestModo {
	@Test
	public void testQuePermitaCrearUnModo() {
		//Datos de entrada
		String nombreTitular="Camila";
		Modo cuenta = new Modo(nombreTitular);		
		
		//Verificacion
		assertNotNull(cuenta);
	}
	
	@Test
	public void testQuePermitaDepositar() {
		//Datos de entrada
		String nombreTitular="Camila";
		Modo cuenta = new Modo(nombreTitular);	
		Double montoAdepositar = 160.0;
		Double valorEsperado = 160.0;
		
		//Verificacion
		
		assertTrue(cuenta.depositar(montoAdepositar));
		assertEquals(valorEsperado, cuenta.getSaldo());
	}
	
	@Test
	public void testQuePermitaExtraer() {
		//Datos de entrada
		String nombreTitular="Camila";
		Modo cuenta = new Modo(nombreTitular);	
		Double montoAdepositar = 160.0;
		Double montoAextraer = 60.0;
		Double valorEsperado = 100.0;
		
		//Verificacion
		cuenta.depositar(montoAdepositar);
		assertTrue(cuenta.extraer(montoAextraer));
		assertEquals(valorEsperado, cuenta.getSaldo());
	}
}
