package Classe_Info;

public class Module {

	String nom;
	String prof_nom;
	private float note_exam;
	private float note_TP;
	 int exam_percent ;

	public Module(String nom,String prof_nom) {
		this.nom = nom;
	}
	
	public Module(String nom,int exam_percent) {
		this.nom = nom;
		this.exam_percent = exam_percent;
	}


	public Module(String nom,String prof_nom, float note_exam, float note_TP) {
		this.nom = nom;
		this.note_exam = note_exam;
		this.note_TP = note_TP;
		this.prof_nom = prof_nom;
		
	}
	
	public int getExam_percent() {
		return exam_percent;
	}

	public void setExam_percent(int exam_percent) {
		this.exam_percent = exam_percent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getNote_exam() {
		return note_exam;
	}

	public void setNote_exam(float note_exam) {
		this.note_exam = note_exam;
	}

	public float getNote_TP() {
		return note_TP;
	}

	public void setNote_TP(float note_TP) {
		this.note_TP = note_TP;
	}

//Created by EL-AMIRI YOUSSEF 
}