package Classe_Info;

public class Date {
	// Liste des attributs
	public int jour;
	public int mois;
	public int annee;

	// Constructeur Methode 1 :
	public Date() {
		jour = 1;
		mois = 1;
		annee = 1900;
	}

	// Constructeur Methode 2 :
	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	// Getters and Setters
	public int getJour() {
		return this.jour;
	}

	public void setJour(int jour) {
		if (jour >= 1 && jour <= 31) {
			this.jour = jour;
		}
	}

	public int getMois() {
		return this.mois;
	}

	public void setMois(int mois) {
		if (mois >= 1 && mois <= 12) {
			this.mois = mois;
		}
	}

	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		if (annee >= 1 && annee <= 31) {
			this.annee = annee;
		}
	}

	// Method toString
	public String toString() {
		String date = this.getAnnee() + "-" + this.getMois() + "-" + this.getJour();
		return date;
	}
//Created by EL-AMIRI YOUSSEF 
}
