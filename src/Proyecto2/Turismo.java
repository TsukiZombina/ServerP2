package Proyecto2;



import java.rmi.RemoteException;
import java.util.TimeZone;

public class Turismo extends java.rmi.server.UnicastRemoteObject implements ITurismo{
	
	protected Turismo() throws RemoteException {
		super();
	}


	@Override
	public double convertirDivisa(int codigoDivisa1, double cantidad, int codigoDivisa2) {
		
		DataBase db = new DataBase();
		String col = "divisasValorDolar";
		if(db.connect()){
			double valor1 = db.getDouble("SELECT " + col + " FROM divisas WHERE iddivisas = " + codigoDivisa1, col);
			double valor2 = db.getDouble("SELECT " + col + " FROM divisas WHERE iddivisas = " + codigoDivisa2, col);
			db.disconnect();
			return (cantidad/valor1) * valor2;
		}else{
			System.out.println("Connection Refused");
			return 0;
		}

	}


	@Override
	public double getClima(int codigoCiudad) {
		
		DataBase db = new DataBase();
		String col = "ciudadClima";
		if(db.connect()){
			double clima = db.getDouble("SELECT " + col + " FROM ciudad WHERE idciudad = " + codigoCiudad, col);
			db.disconnect();
			return clima;
		}else{
			System.out.println("Connection Refused");
			return 0;
		}
	}


	@Override
	public TimeZone getHoraExacta(int codigoCiudad) {
		
		DataBase db = new DataBase();
		String col = "ciudadTimeZone";
		if(db.connect()){
			String tz = db.getString("SELECT " + col + " FROM ciudad WHERE idciudad = " + codigoCiudad, col);
			TimeZone hora = TimeZone.getTimeZone(tz);
			db.disconnect();
			return hora;
		}else{
			System.out.println("Connection Refused");
			return null;
		}
		
	}

}
