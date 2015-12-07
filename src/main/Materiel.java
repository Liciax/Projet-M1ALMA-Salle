package main;

public class Materiel {
	
	private Salle salle;
	private int codeMateriel;
	private String nomMateriel;
	private String descrMateriel;
	private double tarifMateriel;
	
	public Materiel(Salle salle, int codeMateriel, String nomMateriel, String descrMateriel) {
		this.salle = salle;
		this.codeMateriel = codeMateriel;
		this.nomMateriel = nomMateriel;
		this.descrMateriel = descrMateriel;
		// a calculer
		this.tarifMateriel = 0;
	}
	
	
}
