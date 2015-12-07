package principal;

import java.util.ArrayList;
import java.util.Calendar;

public class Demandeur {
	
	private int idDemandeur;
	private String nomDemandeur;
	private OrigineDemandeur origineDemandeur;
	private TitreDemandeur titreDemandeur;
	private Adresse adresseDemandeur;
	
	public Demandeur(int idDemandeur, String nomDemandeur, OrigineDemandeur origineDemandeur, TitreDemandeur titreDemandeur, Adresse adresseDemandeur) {
		this.idDemandeur = idDemandeur;
		this.nomDemandeur = nomDemandeur;
		this.origineDemandeur = origineDemandeur;
		this.titreDemandeur = titreDemandeur;
		this.adresseDemandeur = adresseDemandeur;
	}
	
	public void reserverSalle(Calendar dateDebut, Calendar dateFin, Salle salle, DureeReservation duree, ArrayList<Materiel> materielEnSupp) {
		Reservation reserv = new Reservation(salle, dateDebut, dateFin, this.idDemandeur, duree);
//		switch (duree) {
//			case SOIREE : 
//				break;
//			case DEMI_JOURNEE_MATIN :
//				break;
//			case DEMI_JOURNEE_APREM :
//				break;
//			case JOURNEE :
//				break;
//		}
	}

	public int getIdDemandeur() {
		return idDemandeur;
	}

	public String getNomDemandeur() {
		return nomDemandeur;
	}

	public OrigineDemandeur getOrigineDemandeur() {
		return origineDemandeur;
	}

	public TitreDemandeur getTitreDemandeur() {
		return titreDemandeur;
	}

	public Adresse getAdresseDemandeur() {
		return adresseDemandeur;
	}
	
	//Reservation(Salle salleReservee, Calendar dateDebutReserve, Calendar dateFinReserve, Demandeur client, DureeReservation dureeReservation)
	
	
}
