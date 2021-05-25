package ar.edu.unlam.pb2.banco;

public class CuentaSueldo extends Cuenta{

	public CuentaSueldo(String nombreTitular) {
		super(nombreTitular);
	}

	@Override
	public Boolean extraer(Double montoAextraer) {
		if(montoAextraer>0.0&&super.getSaldo()>0.0&&montoAextraer<=super.getSaldo()) {
			super.setSaldo(super.getSaldo()-montoAextraer);
			return true;
		}
		return false;
	}

	@Override
	public Boolean depositar(Double montoAdepositar) {
		if(montoAdepositar>0.0) {
			super.setSaldo(super.getSaldo()+montoAdepositar);
			return true;
		}
		return false;
	}





}