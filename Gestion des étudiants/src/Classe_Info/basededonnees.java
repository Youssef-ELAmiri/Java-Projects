package Classe_Info;
import java.util.ArrayList;

import java.sql.Driver;
import java.sql.DriverManager;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.ResultSet;

public class basededonnees {
	
			String URL = "jdbc:mysql://localhost:3306/Gestion_Etudiant";
		    String USER = "root";
		    String PASSWORD = "";
			
			public ArrayList<Classe> getClasses() {
		        ArrayList<Classe> classes = new ArrayList<>();
		        try (Connection connexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
		            DatabaseMetaData metaData = (DatabaseMetaData) connexion.getMetaData();
		            try (ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"})) {
		                while (tables.next()) {
		                    String tableName = tables.getString("TABLE_NAME");
		                    classes.add(new Classe(tableName));
		                }
		            }
		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        }
		        return classes;
		    }
	
		    public ArrayList<Etudiant> getEtudiants(Classe classe) {
		        ArrayList<Etudiant> etudiants = new ArrayList<>();
		        try (Connection connexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
		            String query = "SELECT nbr, nom, date, email FROM " + classe.getFiliere_name() + ";";
		            try (Statement statement = connexion.createStatement();
		                 ResultSet resultSet = statement.executeQuery(query)) {
		                while (resultSet.next()) {
		                    int nbr = resultSet.getInt("nbr");
		                    String nom = resultSet.getString("nom");
		                    java.sql.Date date = resultSet.getDate("date");
		                    LocalDate localDate = date.toLocalDate();
		                    int day = localDate.getDayOfMonth();
		                    int month = localDate.getMonthValue();
		                    int year = localDate.getYear();
		                    Date date1 = new Date(day, month, year);
		                    String email = resultSet.getString("email");
		                    
		                    etudiants.add(new Etudiant(nbr, nom, date1, email));
		                }
		            }
		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        }
		        return etudiants;
		    }
		
		    public ArrayList<Module> getModules(Classe classe) {
		        ArrayList<Module> modules = new ArrayList<>();
		        try (Connection connexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
		            String query = "SHOW COLUMNS FROM " + classe.getFiliere_name() + ";";
		            try (Statement statement = connexion.createStatement();
		                 ResultSet resultSet = statement.executeQuery(query)) {
		                while (resultSet.next()) {
		                    String columnName = resultSet.getString("Field");
		                    if (!columnName.equals("nbr") && !columnName.equals("nom") && 
		                        !columnName.equals("date") && !columnName.equals("email")) {
		                        modules.add(new Module(columnName, null));
		                    }
		                }
		            }
		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        }
		        return modules;
		    }


	public static void main(String[] args) {
		
		basededonnees db = new basededonnees();
//		Classe classe = new Classe("ISEIA");
		
		ArrayList<Classe> classes = new ArrayList<Classe>();
		classes = db.getClasses();
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
//		etudiants = db.getEtudiants(classe);
//		ArrayList<Module> modules = new ArrayList<Module>();
//		modules = db.getModules(classe);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("classe : "+classes.get(i).getFiliere_name());
		}
		System.out.println("Classe : \n ");
		
		 
	}
//Created by EL-AMIRI YOUSSEF 
}
