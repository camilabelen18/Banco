package ar.edu.unlam.pb2.banco;

public class CuentaCorriente extends Cuenta{
	
	private final Double COMISION = 0.05;
	private final Double DESCUBIERTO_MAXIMO=150.0;
	private Double descubiertoAusar;//no se utiliza siempre el descubierto total
	private Double deuda;

	public CuentaCorriente(String nombreTitular) {
		super(nombreTitular);
		this.descubiertoAusar = 0.0;
		this.deuda = 0.0;
	}

	@Override
	public Boolean extraer(Double montoAextraer) {
		//Cuando quiero extraer hasta la cantidad que tengo
		if(montoAextraer<=super.getSaldo()) {
			super.setSaldo(super.getSaldo()-montoAextraer);
			return true;
		}else {
			//si quiero extraer mas de lo que tengo
			if(montoAextraer<=(super.getSaldo()+(this.DESCUBIERTO_MAXIMO-this.descubiertoAusar))) {
				this.descubiertoAusar+=montoAextraer-super.getSaldo();
				super.setSaldo(0.0);
				this.deuda=this.descubiertoAusar*COMISION;
				return true;
	
			}
			
		}
		return false;
	}

	@Override
	public Boolean depositar(Double montoAdepositar) {
		if(montoAdepositar>0.0) {
			if(montoAdepositar>=(this.descubiertoAusar+this.deuda)) {
//				montoAdepositar-=(this.deuda+this.descubiertoAusar);
				super.setSaldo(montoAdepositar-(this.deuda+this.descubiertoAusar));
				this.deuda=0.0;
				this.descubiertoAusar=0.0;
//				super.setSaldo(montoAdepositar);
				return true;
			}
			else if(montoAdepositar>=this.deuda){
				this.descubiertoAusar-=montoAdepositar-this.deuda;
				this.deuda=0.0;
			}else {
				this.deuda-=montoAdepositar;
			}
	
		}
		return false;
	}

	public Double getDescubiertoAusar() {
		return descubiertoAusar;
	}

	public void setDescubiertoAusar(Double descubiertoAusar) {
		this.descubiertoAusar = descubiertoAusar;
	}

	public Double getDeuda() {
		return deuda;
	}

	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [COMISION=" + COMISION + ", DESCUBIERTO_MAXIMO=" + DESCUBIERTO_MAXIMO
				+ ", descubiertoAusar=" + descubiertoAusar + ", deuda=" + deuda + "]";
	}
	
	
	

}
