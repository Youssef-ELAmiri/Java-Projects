package Classe_Info;
import java.util.ArrayList;

public class Classe {

	String filiere_name;
	ArrayList<Module> modules = new ArrayList<Module>();
	ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
	int module_nbr = modules.size();
	int etudiant_nbr = etudiants.size();

	

	public Classe(String filiere_name) {
		this.filiere_name = filiere_name;
	}

	public void creerModule(String name,String prof_name) {
		// String module = name+"1";
		Module module = new Module(name,prof_name);
		modules.add(module);
	}
	
	public int getModule_nbr() {
		return module_nbr;
	}

	public int getEtudiant_nbr() {
		return etudiant_nbr;
	}

	public void creerEtudiant(int nbr, String Fullname, Date date_de_naissance, String Email) {
		Etudiant etudiant = new Etudiant(nbr, Fullname, date_de_naissance, Email);
		etudiants.add(etudiant);
	}

	public String getFiliere_name() {
		return filiere_name;
	}

	public void setFiliere_name(String filiere_name) {
		this.filiere_name = filiere_name;
	}
	
//Created by EL-AMIRI YOUSSEF 
}
