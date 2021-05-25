package ar.edu.unlam.pb2.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	List <Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public void transferirBanco(Transferible cuentaOrigen,Transferible cuentaDestino,Double monto) {
		if(cuentaOrigen instanceof Cuenta && cuentaDestino instanceof Cuenta) {
			((Cuenta)cuentaOrigen).extraer(monto);
			((Cuenta)cuentaDestino).depositar(monto);
	}else if(cuentaOrigen instanceof Cuenta && cuentaDestino instanceof Celular) {
				((Cuenta)cuentaOrigen).extraer(monto);
				((Celular)cuentaDestino).depositar(monto);
				
			}else if(cuentaOrigen instanceof Celular && cuentaDestino instanceof Cuenta) {
				((Celular)cuentaOrigen).extraer(monto);
				((Cuenta)cuentaDestino).depositar(monto);
			}else if(cuentaOrigen instanceof Celular && cuentaDestino instanceof Celular) {
				((Celular)cuentaOrigen).extraer(monto);
				((Celular)cuentaDestino).depositar(monto);
				
			}
	}
	
	

	
}
