package ar.edu.unlam.pb2.banco;

public interface Transferible {

	public abstract void transferir(Transferible cuentaOrigen, Transferible cuentaDestino, Double monto);
	
	
	
}
