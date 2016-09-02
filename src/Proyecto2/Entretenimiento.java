package Proyecto2;



import java.rmi.RemoteException;
import java.util.ArrayList;

public class Entretenimiento extends java.rmi.server.UnicastRemoteObject implements IEntretenimiento {

	protected Entretenimiento() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<Funcion> cinesYHorarios(int codigoPelicula) throws RemoteException {
		DataBase db = new DataBase();
		if(db.connect()){
			ArrayList<Funcion> res = db.getCineHorarios(codigoPelicula);
			db.disconnect();
			return res;
		}else{
			return null;
		}
	}

	@Override
	public String horarioMuseo(int codigoMuseo) throws RemoteException {
		DataBase db = new DataBase();
		if(db.connect()){
			String col = "museoHorario";
			String res = db.getString("SELECT " + col + " FROM museo WHERE idmuseo = " + codigoMuseo , col);
			db.disconnect();
			return res;
		}else{
			return null;
		}
	}

	@Override
	public ArrayList<Funcion> costoPorFuncion(int codigoObra) throws RemoteException {
		DataBase db = new DataBase();
		if(db.connect()){
			ArrayList<Funcion> res = db.getCostoObra(codigoObra);
			db.disconnect();
			return res;
		}else{
			return null;
		}
	}

}
