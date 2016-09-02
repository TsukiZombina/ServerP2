package Proyecto2;

import java.rmi.Naming;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;


public class Server {

	public static void main(String[] args) {
		
		try {
			
			//Crear el registro
			LocateRegistry.createRegistry(1099);
			
			//Crear y unir los servicios
			//Turismo
			ITurismo turismo = new Turismo(); 			
			Naming.bind("rmi://localhost:1099/Turismo", turismo);
			
			//Geografico
			IGeografico geografico = new Geografico();
			Naming.bind("rmi://localhost:1099/Geografico", geografico);
			
			//Entretenimiento
			IEntretenimiento entretenimiento = new Entretenimiento();
			Naming.bind("rmi://localhost:1099/Entretenimiento", entretenimiento);
			
			//Otros
			IOtros otros = new Otros();
			Naming.bind("rmi://localhost:1099/Otros", otros);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
