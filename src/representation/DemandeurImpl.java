package representation;

import java.util.Calendar;
import java.util.List;

public class DemandeurImpl implements Demandeur {

  private String nomDemandeur;
  private OrigineDemandeur origineDemandeur;
  private TitreDemandeur titreDemandeur;
  private String idAdresseDemandeur;

  public DemandeurImpl(String nomDemandeur, OrigineDemandeur origineDemandeur,
      TitreDemandeur titreDemandeur, String idAdresseDemandeur) {
    this.nomDemandeur = nomDemandeur;
    this.origineDemandeur = origineDemandeur;
    this.titreDemandeur = titreDemandeur;
    this.idAdresseDemandeur = idAdresseDemandeur;
  }

  // public void reserverSalle(Calendar dateDebut, Calendar dateFin, Salle salle,
  // DureeReservation duree, List<Materiel> materielEnSupp) {
  // // Reservation reserv = new Reservation(salle, dateDebut, dateFin, idDemandeur, duree);
  // // switch (duree) {
  // // case SOIREE :
  // // break;
  // // case DEMI_JOURNEE_MATIN :
  // // break;
  // // case DEMI_JOURNEE_APREM :
  // // break;
  // // case JOURNEE :
  // // break;
  // // }
  // }

  public String getNomDemandeur() {
    return nomDemandeur;
  }

  public OrigineDemandeur getOrigineDemandeur() {
    return origineDemandeur;
  }

  public TitreDemandeur getTitreDemandeur() {
    return titreDemandeur;
  }

  public String getAdresseDemandeur() {
    return idAdresseDemandeur;
  }

  // Reservation(Salle salleReservee, Calendar dateDebutReserve, Calendar dateFinReserve, Demandeur
  // client, DureeReservation dureeReservation)

}
