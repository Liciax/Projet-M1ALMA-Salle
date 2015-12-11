package representation;

import java.util.Calendar;
import java.util.List;

public interface FactorySalle {


  public Adresse createAdresse(int noRue, String rue, int codePostal, String ville, String complement);


  public Batiment createBatiment(String idBat, Adresse adresseBat, List<String> listIdSalles);


  public Demandeur createDemandeur(String idDemandeur, String nomDemandeur,
      OrigineDemandeur origineDemandeur, TitreDemandeur titreDemandeur, String idAdresseDemandeur);

  
  public Materiel createMateriel(String idSalle, String codeMateriel, String nomMateriel,
      String descrMateriel);

  
  public Reservation createReservation(String salleReservee, Calendar dateDebutReserve,
      Calendar dateFinReserve, String idClient, DureeReservation dureeReservation);

  
  public Salle createSalle(int noEtage, int noSalle, String idSalle, int noBat, int superficie,
      String typeSalle); 

  


}
