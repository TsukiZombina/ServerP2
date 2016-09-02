package Proyecto2;

import java.util.ArrayList;

public interface IGeografico extends java.rmi.Remote {
	
	/**
	 * Regresa la ubicacion de un determinado espacio fisico de la UAM
	 *
	 * @param espacio El nombre del espacio fisico segun la base de datos 
	 * @return La ubicacion como cadena de texto
	 */
	public String ubicacionDe(String espacio) throws java.rmi.RemoteException ;
	
	/**
	 * Devuelve un Profesor de la UAM con sus datos(cubiculo, telefono, oficina, correo)
	 *
	 * @param profesor El nombre del profesor segun la base de datos
	 * @return Un Profesor con todos sus datos
	 */
	public Profesor getDatosProfesor(String profesor) throws java.rmi.RemoteException;
	
	/**
	 * Devuelve una lista de las materias impartidas por profesor
	 *
	 * @param profesor El nombre del profesor segun la base de datos
	 * @return una lista con los ueas impartidas por un profesor
	 */
	public ArrayList<String> materiasImpartidas(String profesor) throws java.rmi.RemoteException;

}

