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
		
		banco.transferir(cuentaCorriente, cuentaSueldo, monto);
		
		assertEquals(valorEsperado1,cuentaCorriente.getSaldo());
		assertEquals(valorEsperado2,cuentaSueldo.getSaldo());
	}
	
	@Test
	public void testQueVerifiqueQueSePuedaTransferirEntreCelulares() {
		Double monto = 100.0;
		Double valorEsperado1 = 0.0;
		Double valorEsperado2 = 200.0;
		Modo cuenta1 = new Modo("Amanda");
		Modo cuenta2 = new Modo("Estela");
		
		Banco banco = new Banco();
		
		cuenta1.depositar(monto);
		cuenta2.depositar(monto);
		
		banco.transferirEntreCelulares(cuenta1, cuenta2, monto);
		
		assertEquals(valorEsperado1,cuenta1.getSaldo());
		assertEquals(valorEsperado2,cuenta2.getSaldo());
	}
	
	@Test
	public void testQueVerifiqueQueSePuedaTransferirEntreCelularYCuenta() {
		Double monto = 100.0;
		Double valorEsperado1 = 0.0;
		Double valorEsperado2 = 200.0;
		Modo cuenta1 = new Modo("Amanda");
		Cuenta cuenta2 = new CuentaSueldo("Rocio");
		
		Banco banco = new Banco();
		
		cuenta1.depositar(monto);
		cuenta2.depositar(monto);
		
		banco.transferirEntreCelulares(cuenta1, cuenta2, monto);
		
		assertEquals(valorEsperado1,cuenta1.getSaldo());
		assertEquals(valorEsperado2,cuenta2.getSaldo());
	}

}
