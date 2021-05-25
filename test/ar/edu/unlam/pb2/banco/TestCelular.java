package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCelular {

	@Test
	public void testQueVerifiqueQueSePuedaDepositarDeUnCelular() {
		Integer numeroDeCelular = 1230405060;
		Integer codigoArea = 03;
		Double montoAdepositar = 2000.0;
		Double valorEsperado = 2000.0;
		Celular celular = new Celular(numeroDeCelular, codigoArea);
		
		assertTrue(celular.depositar(montoAdepositar));
		assertEquals(valorEsperado,celular.getSaldo());
	}
	
	@Test
	public void testQueVerifiqueQueSePuedaExtraerDeUnCelular() {
		Integer numeroDeCelular = 1230405060;
		Integer codigoArea = 03;
		Double montoAdepositar = 2000.0;
		Double montoAextraer = 2000.0;
		Double valorEsperado = 0.0;
		Celular celular = new Celular(numeroDeCelular, codigoArea);
		
		celular.depositar(montoAdepositar);
		assertTrue(celular.extraer(montoAextraer));
		assertEquals(valorEsperado,celular.getSaldo());
	}

}
