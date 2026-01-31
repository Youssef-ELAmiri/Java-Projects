package Classe_Info;

public class Etudiant {
	int nbr;
	String Fullname;
	Date date_de_naissance;
	String Email;

	public Etudiant(int nbr, String Fullname, Date date_de_naissance, String Email) {
		this.nbr = nbr;
		this.Fullname = Fullname;
		this.date_de_naissance = date_de_naissance;
		this.Email = Email;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public Date getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

//Created by EL-AMIRI YOUSSEF }
