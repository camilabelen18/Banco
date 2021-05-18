package ar.edu.unlam.pb2.banco;

public abstract class Cuenta {
	
	private Double saldo;
	private String nombreTitular;
	
	public Cuenta(String nombreTitular) {
		this.nombreTitular=nombreTitular;
		this.saldo=0.0;
	}

	public abstract Boolean extraer(Double montoAextraer);
	public abstract Boolean depositar(Double montoAdepositar);

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

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", nombreTitular=" + nombreTitular + "]";
	}
	
	
}
