package ar.edu.unlam.pb2.banco;

public abstract class Cuenta implements Transferible{
	
	private Double saldo;
	private String nombreTitular;
	private Integer numero;
	private String apellidoTitular;

	
	public Cuenta(String nombreTitular) {
		this.nombreTitular=nombreTitular;
		this.saldo=0.0;
	}


	public abstract Boolean extraer(Double montoAextraer);
	public abstract Boolean depositar(Double montoAdepositar);
	
	//Cuentas y Cuenta y Celular
	@Override
	public void transferir(Transferible cuentaOrigen, Transferible cuentaDestino, Double monto) {
		if(cuentaOrigen instanceof Cuenta && cuentaDestino instanceof Cuenta) {
				((Cuenta)cuentaOrigen).extraer(monto);
				((Cuenta)cuentaDestino).depositar(monto);
		}else if(cuentaOrigen instanceof Cuenta && cuentaDestino instanceof Celular) {
					((Cuenta)cuentaOrigen).extraer(monto);
					((Celular)cuentaDestino).depositar(monto);
					
				}else if(cuentaOrigen instanceof Celular && cuentaDestino instanceof Cuenta) {
					((Celular)cuentaOrigen).extraer(monto);
					((Cuenta)cuentaDestino).depositar(monto);
				}
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	
	

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getApellidoTitular() {
		return apellidoTitular;
	}

	public void setApellidoTitular(String apellidoTitular) {
		this.apellidoTitular = apellidoTitular;
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", nombreTitular=" + nombreTitular + "]";
	}
	
	
}
