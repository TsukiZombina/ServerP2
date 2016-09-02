package Proyecto2;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {

	private static String dbUrl = "jdbc:mysql://localhost:3306/practica2sd";
    private static String dbUsername = ""; //Usuario
    private static String dbPassword = ""; //Contrase�a
    private static Connection conn = null;
    
    public DataBase(){
    }
    
    public boolean connect(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        return true;
    }
    
    public void disconnect(){
    	try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public Double getDouble(String statement, String columna){
    	
    	Statement stmt;
    	Double valor = null;
    	
		try {
			stmt = conn.createStatement();
			String sql = statement;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				valor = rs.getDouble(columna);
			}
			rs.close();
		    stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		return valor;
    }
    
	public String getString(String statement, String columna){
	    	
	    	Statement stmt;
	    	String valor = null;
	    	
			try {
				stmt = conn.createStatement();
				String sql = statement;
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					valor = rs.getString(columna);
				}
				rs.close();
			    stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		     
			return valor;
	    }

	public Profesor getProfesor(String profesor){
    	
    	Statement stmt;
    	Profesor prof = null;
    	
		try {
			stmt = conn.createStatement();
			String sql = "SELECT profesorNombre, profesorTel, profesorCorreo, espaciofisNombre as cubiculo FROM profesor "
					+ "JOIN espaciofis ON idespaciofis = espaciofis_idespaciofis WHERE profesorNombre rlike \"" + profesor + "\"";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String nombre = rs.getString("profesorNombre");
				String telefono = rs.getString("profesorTel");
				String correo = rs.getString("profesorCorreo");
				String cub = rs.getString("cubiculo");
				prof = new Profesor(nombre, cub, telefono, correo);
			}
			rs.close();
		    stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		return prof;
    }

	public ArrayList<String> getMaterias(String profesor){
		Statement stmt;
    	ArrayList<String> materias = new ArrayList<String>();
    	
		try {
			stmt = conn.createStatement();
			String sql = "SELECT ueaNombre FROM uea JOIN impartir ON iduea = uea_iduea "
					+ "JOIN profesor ON idprofesor = profesor_idprofesor WHERE profesorNombre rlike \"" + profesor + "\"";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				materias.add(rs.getString("ueaNombre"));
			}
			rs.close();
		    stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		return materias;
	}
	
	public ArrayList<Funcion> getCineHorarios(int codigoPelicula){
		Statement stmt;
    	ArrayList<Funcion> funciones = new ArrayList<Funcion>();
    	
		try {
			stmt = conn.createStatement();
			String sql = "SELECT peliculaNombre, cineNombre, horariosInicio, horariosFin "
						+ "FROM horarios JOIN pelicula ON idpelicula = pelicula_idpelicula "
						+ " JOIN cine ON idcine = cine_idcine WHERE idpelicula = " + codigoPelicula;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Funcion fn = new Funcion();
				fn.setNombre(rs.getString(1));
				fn.setRecinto(rs.getString(2));
				fn.setHoraInicio(rs.getTime(3).toString());
				fn.setHoraFin(rs.getTime(4).toString());
				funciones.add(fn);
			}
			rs.close();
		    stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		return funciones;
	}
	
	public ArrayList<Funcion> getCostoObra(int codigoObra){
		Statement stmt;
    	ArrayList<Funcion> funciones = new ArrayList<Funcion>();
    	
		try {
			stmt = conn.createStatement();
			String sql = "SELECT obraNombre, teatroNombre, costoCosto "
						+ "FROM costo JOIN obra ON idobra = obra_idobra "
						+ "JOIN teatro ON idteatro = teatro_idteatro WHERE idobra= " + codigoObra;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Funcion fn = new Funcion();
				fn.setNombre(rs.getString(1));
				fn.setRecinto(rs.getString(2));
				fn.setCosto(rs.getString(3));
				funciones.add(fn);
			}
			rs.close();
		    stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
		return funciones;
	}
}
