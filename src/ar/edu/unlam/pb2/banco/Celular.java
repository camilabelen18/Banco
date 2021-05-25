package ar.edu.unlam.pb2.banco;

public class Celular implements Transferible{
	
	public Integer numeroDeCelular;
	public Double saldo;
	public Integer codigoArea;
	
	public Celular(Integer numeroDeCelular, Integer codigoArea) {
		this.saldo=0.0;
		this.numeroDeCelular= numeroDeCelular;
		this.codigoArea= codigoArea;
	}
	

	
	public  Boolean extraer(Double montoAextraer) {
		if(this.saldo>=0.0 && montoAextraer<=this.saldo) {
			this.saldo-=montoAextraer;
			return true;
		}
		return false;
	}
	
	
	public  Boolean depositar(Double montoAdepositar) {
		if(montoAdepositar>0.0) {
			this.saldo+=montoAdepositar;
			return true;
		}
		return false;
	}
	
	//Celulares o Celular Cuenta
	@Override
	public void transferir(Transferible cuentaOrigen, Transferible cuentaDestino, Double monto) {
		if(cuentaOrigen instanceof Cuenta && cuentaDestino instanceof Celular) {
				((Cuenta)cuentaOrigen).extraer(monto);
				((Celular)cuentaDestino).depositar(monto);
		}else if(cuentaOrigen instanceof Celular && cuentaDestino instanceof Celular) {
					((Celular)cuentaOrigen).extraer(monto);
					((Celular)cuentaDestino).depositar(monto);
					
				}else if(cuentaOrigen instanceof Celular && cuentaDestino instanceof Cuenta) {
					((Celular)cuentaOrigen).extraer(monto);
					((Cuenta)cuentaDestino).depositar(monto);
				}
	}
	
	
	
	public Integer getNumeroDeCelular() {
		return numeroDeCelular;
	}
	public void setNumeroDeCelular(Integer numeroDeCelular) {
		this.numeroDeCelular = numeroDeCelular;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Integer getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}


	@Override
	public String toString() {
		return "Celular [numeroDeCelular=" + numeroDeCelular + ", saldo=" + saldo + ", codigoArea=" + codigoArea + "]";
	}




	
	

}
