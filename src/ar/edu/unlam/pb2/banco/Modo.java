package ar.edu.unlam.pb2.banco;

public class Modo extends Cuenta {
	
	//Modo seria como una cuenta bancaria

	public Modo(String nombreTitular) {
		super(nombreTitular);
		}

	@Override
	public Boolean extraer(Double montoAextraer) {

		if(montoAextraer>0.0) {
			super.setSaldo(super.getSaldo()-montoAextraer);
			return true;
		}
		return false;
	}

	@Override
	public Boolean depositar(Double montoAdepositar) {
		if(montoAdepositar > 0.0) {
			super.setSaldo(super.getSaldo()+montoAdepositar);
			return true;
		}
		return false;
	}

}
