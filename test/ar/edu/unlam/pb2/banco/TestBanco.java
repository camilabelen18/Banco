package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBanco {

	@Test
	public void testQueVerifiqueQueSePuedaTransferir() {
		String nombreTitular = "Lorena";
		final Double valorEsperado1 = 0.0;
		final Double valorEsperado2 = 200.0;
		final Double monto = 100.0;
		
		Cuenta cuentaCorriente = new CuentaCorriente(nombreTitular);
		Cuenta cuentaSueldo = new CuentaSueldo(nombreTitular);
		
		Banco banco = new Banco();
		
		cuentaCorriente.depositar(monto);
		cuentaSueldo.depositar(monto);
		
		banco.transferirBanco(cuentaCorriente, cuentaSueldo, monto);
		
		assertEquals(valorEsperado1,cuentaCorriente.getSaldo());
		assertEquals(valorEsperado2,cuentaSueldo.getSaldo());
	}
	
	@Test 
	public void testQueVerifiqueQueSePuedaTransferirEntreCuentaYCelular() {
		String nombreTitular = "Lorena";
		final Double valorEsperado2 = 200.0;
		final Double monto = 100.0;
		
		Cuenta cuentaCorriente = new CuentaCorriente(nombreTitular);
		Celular celular = new Celular(1520304060, 04);
		
		Banco banco = new Banco();
		
		cuentaCorriente.depositar(monto);
		celular.depositar(monto);
		
		banco.transferirBanco(cuentaCorriente, celular, monto);
		
		assertEquals(valorEsperado2,celular.getSaldo());
	}
	
	@Test 
	public void testQueVerifiqueQueSePuedaTransferirEntreCelulares() {
		final Double valorEsperado2 = 400.0;
		final Double monto = 200.0;
		
		
		Celular celular = new Celular(1520304070, 05);
		Celular celular1 = new Celular(1520304080, 04);
		
		Banco banco = new Banco();
		
		
		celular.depositar(monto);
		celular1.depositar(monto);
		
		banco.transferirBanco(celular, celular1, monto);
		
		assertEquals(valorEsperado2,celular1.getSaldo());
	}
	

}
