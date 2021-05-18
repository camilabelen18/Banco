package ar.edu.unlam.pb2.banco;

public class CajaAhorro extends Cuenta{

	final Double costoAdicional = 6.0;
	Integer cantidadExtracciones;
	
	public CajaAhorro(String nombreTitular) {
		super(nombreTitular);
		this.cantidadExtracciones=0;
	}

	@Override
	public Boolean extraer(Double montoAextraer) {
		this.cantidadExtracciones++;

		if(this.cantidadExtracciones>5) {
			super.setSaldo(super.getSaldo()-montoAextraer-costoAdicional);
			this.cantidadExtracciones++;
			return true;
		}
		if(montoAextraer>0.0&&super.getSaldo()>0.0&&montoAextraer<=super.getSaldo()) {
			super.setSaldo(super.getSaldo()-montoAextraer);
//			this.cantidadExtracciones++; lo habia puesto aca pero cuando era mi primer extraccion
//			yo la tenia en 0 y se incrementaba cuando llegaba aca.
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
