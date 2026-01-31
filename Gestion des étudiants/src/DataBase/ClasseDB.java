package DataBase;

import Classe_Info.*;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ClasseDB {
	
	
		public String creerclasse(String classeName) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestion_Etudiant","root","");
				
				Statement statement = connexion.createStatement();
				
				String query = "CREATE TABLE IF NOT EXISTS "+classeName+"(nbr INT NOT NULL PRIMARY KEY , nom VARCHAR(30) , date DATE , email VARCHAR(45)); ";
				
				boolean resultat = statement.execute(query);
				
				connexion.close();
				return null;
				
			} catch (Exception e) {
				return e.getMessage();
			
			}
		}
		public String ajouterModule(String moduleName,String classe) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestion_Etudiant","root","");
				
				Statement statement = connexion.createStatement();
				
				String query = "ALTER TABLE "+classe+" ADD "+moduleName+" DECIMAL(4,2) ;" ;
				
				boolean resultat = statement.execute(query);
				
				connexion.close();
				return null;
						
			} catch (Exception e) {
				return e.getMessage();
			
			}
			}
		public String ajouterEtudiant(String classe,int nbr, String Fullname, Date date_de_naissance, String Email) {
			try {
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestion_Etudiant","root","");
				
				Statement statement = connexion.createStatement();
				
				String query = "INSERT INTO "+classe+" (nbr, nom, date, email) VALUES ('"+nbr+"', '"+Fullname+"', '"+date_de_naissance.toString()+"', '"+Email+"');" ;
				
				boolean resultat = statement.execute(query);
				
				connexion.close();
				return null;
			} catch (Exception e) {
				
				return e.getMessage();
			
			}
		}
		public String ajouterNote(String classe, String module, float note_exam, float note_TP, String etudiant) {
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");

		        Connection connexion = DriverManager.getConnection(URL, USER, PASSWORD);

		        Module moduleClasse = new Module(module,50);
		        float moy =( note_exam + note_TP) /2;

		        String query = "UPDATE " + classe + " SET " + module + " = ? WHERE nom = ?;";

		        PreparedStatement preparedStatement = connexion.prepareStatement(query);
		        preparedStatement.setFloat(1, moy);
		        preparedStatement.setString(2, etudiant);

		        int rowsAffected = preparedStatement.executeUpdate();

		        connexion.close();

		        if (rowsAffected > 0) {
		            return "Note ajout閑 avec succ鑣.";
		        } else {
		            return "蒫hec : 蓆udiant introuvable dans la classe.";
		        }
		    } catch (Exception e) {
		        return "Erreur : " + e.getMessage();
		    }
		}

		
		static String URL = "jdbc:mysql://localhost:3306/Gestion_Etudiant";
	    static String USER = "root";
	    static String PASSWORD = "";
		
	    public ArrayList<Classe> getClasses() {
	        ArrayList<Classe> classes = new ArrayList<>();
	        try (Connection connexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
	            java.sql.DatabaseMetaData metaData = connexion.getMetaData();
	            
	            try (ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"})) {
	                while (tables.next()) {
	                    String tableName = tables.getString("TABLE_NAME");
	                    
	                    if (!tableName.startsWith("information_schema") && 
	                        !tableName.startsWith("sys_config") &&
	                        !tableName.startsWith("mysql") &&
	                        !tableName.startsWith("performance_schema")) {
	                        classes.add(new Classe(tableName));
	                    }
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	        return classes;
	    }
	    
	    public int getNbrLigne(String classe) {
	        int nbrligne = 0;
	        try (Connection connexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
	            String query = "SELECT COUNT(*) AS row_count FROM " + classe;
	            try (Statement statement = connexion.createStatement();
	                 ResultSet resultSet = statement.executeQuery(query)) {
	                if (resultSet.next()) {
	                	nbrligne = resultSet.getInt("row_count");
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	        return nbrligne;
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
	    
	    public ArrayList<String> getModulesForClass(String className) {
	        ArrayList<String> modules = new ArrayList<>();
	        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + className + "' AND COLUMN_NAME NOT IN ('nbr', 'nom', 'date', 'email')";
	        
	        try (Connection connexion = DriverManager.getConnection(URL, USER, PASSWORD);
	             Statement statement = connexion.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {
	                String moduleName = resultSet.getString("COLUMN_NAME");
	                modules.add(moduleName);
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur lors de la r閏up閞ation des modules : " + e.getMessage());
	        }

	        return modules;
	    }
	
//Created by EL-AMIRI YOUSSEF 
}
