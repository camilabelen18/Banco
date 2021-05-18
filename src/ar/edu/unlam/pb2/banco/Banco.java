package ar.edu.unlam.pb2.banco;

public class Banco implements Celular{
	
	
	public void transferir(Cuenta cuentaOrigen,Cuenta cuentaDestino,Double monto) {
		cuentaOrigen.extraer(monto);
		cuentaDestino.depositar(monto);
	}
	
	//REALIZAR TRANSFERENCIAS ENTRE DOS TELEFONOS CELULARES

	@Override
	public void transferirEntreCelulares(Modo cuentaOrigen, Modo cuentaDestino, Double monto) {
		cuentaOrigen.extraer(monto);
		cuentaDestino.depositar(monto);	
	}
	

	@Override
	public void transferirEntreCelulares(Modo cuentaOrigen, Cuenta cuentaDestino, Double monto) {
		cuentaOrigen.extraer(monto);
		cuentaDestino.depositar(monto);	
	}
	
}
