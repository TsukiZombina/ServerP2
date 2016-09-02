package Proyecto2;

import java.rmi.RemoteException;

public class Otros extends java.rmi.server.UnicastRemoteObject implements IOtros {

	protected Otros() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calcularPropina(float consumo, int porcentaje) throws RemoteException {	
		
		return consumo * (porcentaje/100f);
	}

	@Override
	public float calcularDescuento(float precio, int descuento) throws RemoteException {
		
		return precio - (precio * (descuento/100f));
	}

	@Override
	public float calcularInteres(float deuda, float pago, float interes) throws RemoteException {
		
		float intAPagar = 0;
		
		if(pago < deuda){
			intAPagar = (deuda - pago) * (interes/100f);
		}
		
		return intAPagar;
	}

}
