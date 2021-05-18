package ar.edu.unlam.pb2.banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaSueldo {

	@Test
	public void testQuePermitaCrearUnaCuentaSueldo() {
		//Datos de entrada
		String nombreTitular="Camila";
		CuentaSueldo cuentaSueldo= new CuentaSueldo(nombreTitular);
		
		//Verificacion
		assertNotNull(cuentaSueldo);
	}
	
	@Test
	public void testQuePermitaDepositarEnUnaCuentaSueldo() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double valorEsperado=100.0;
		CuentaSueldo cuentaSueldo= new CuentaSueldo(nombreTitular);
		
		//Ejecucion
		cuentaSueldo.depositar(montoAdepositar);
		final Double valorObtenido=cuentaSueldo.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQueAcumuleLosDepositosEnUnaCuentaSueldo() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double montoAdepositar2=200.0;
		final Double valorEsperado=300.0;
		CuentaSueldo cuentaSueldo= new CuentaSueldo(nombreTitular);
		
		//Ejecucion
		cuentaSueldo.depositar(montoAdepositar);
		cuentaSueldo.depositar(montoAdepositar2);
		final Double valorObtenido=cuentaSueldo.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQuePermitaExtraerEnUnaCuentaSueldo() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double montoAextraer=100.0;
		final Double valorEsperado=0.0;
		CuentaSueldo cuentaSueldo= new CuentaSueldo(nombreTitular);
		
		//Ejecucion
		cuentaSueldo.depositar(montoAdepositar);
		cuentaSueldo.extraer(montoAextraer);
		final Double valorObtenido=cuentaSueldo.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
		
	}
	
	@Test
	public void testQueNoPermitaExtraerEnUnaCuentaSueldoCuandoElMontoAextraerSeaMayorAmiSaldo() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double montoAextraer=200.0;
		final Double valorEsperado=100.0;
		CuentaSueldo cuentaSueldo= new CuentaSueldo(nombreTitular);
		
		//Ejecucion
		cuentaSueldo.depositar(montoAdepositar);
		cuentaSueldo.extraer(montoAextraer);
		final Double valorObtenido=cuentaSueldo.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void testQueNoPermitaExtraerEnUnaCuentaSueldoCuandoElMontoAextraerSeaMenorAcero() {
		//Datos de entrada
		String nombreTitular="Camila";
		final Double montoAdepositar=100.0;
		final Double montoAextraer=-200.0;
		final Double valorEsperado=100.0;
		CuentaSueldo cuentaSueldo= new CuentaSueldo(nombreTitular);
		
		//Ejecucion
		cuentaSueldo.depositar(montoAdepositar);
		cuentaSueldo.extraer(montoAextraer);
		final Double valorObtenido=cuentaSueldo.getSaldo();
				
		//Verificacion
		assertEquals(valorEsperado,valorObtenido);
	}

}
