package Proyecto2;



import java.rmi.RemoteException;
import java.util.ArrayList;

public class Geografico extends java.rmi.server.UnicastRemoteObject implements IGeografico {

	protected Geografico() throws RemoteException {
		super();
	}

	@Override
	public String ubicacionDe(int codigoEspacio) throws RemoteException {
		
		DataBase db = new DataBase();
		if(db.connect()){
			String col = "espaciofisUbicacion";
			String res = db.getString("SELECT " + col + " FROM espaciofis WHERE idespaciofis = " + codigoEspacio , col);
			db.disconnect();
			return res;
		}else{
			return null;
		}
	}

	@Override
	public Profesor getDatosProfesor(int codigoProfesor) throws RemoteException {
		DataBase db = new DataBase();
		if(db.connect()){
			Profesor res = db.getProfesor(codigoProfesor);
			db.disconnect();
			return res;
		}else{
			return null;
		}
	}

	@Override
	public ArrayList<String> materiasImpartidas(int codigoProfesor) throws RemoteException {
		DataBase db = new DataBase();
		if(db.connect()){
			ArrayList<String> res = db.getMaterias(codigoProfesor);
			db.disconnect();
			return res;
		}else{
			return null;
		}
	}

}
