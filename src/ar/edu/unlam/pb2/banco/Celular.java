package ar.edu.unlam.pb2.banco;

public interface Celular {

	
	public void transferirEntreCelulares(Modo cuentaOrigen,Modo cuentaDestino,Double monto) ;

	public void transferirEntreCelulares(Modo cuentaOrigen, Cuenta cuentaDestino, Double monto);
	
}
