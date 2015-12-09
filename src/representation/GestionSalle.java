package representation;

import java.util.Calendar;
import java.util.List;

public interface GestionSalle {


  public String createAdresse(int noRue, String rue, int codePostal, String ville, String complement);

  public String createBatiment(String idBat, Adresse adresseBat, List<String> listIdSalles);

  public String createDemandeur(String idDemandeur, String nomDemandeur,
      OrigineDemandeur origineDemandeur, TitreDemandeur titreDemandeur, String idAdresseDemandeur);

  public String createMateriel(String idSalle, String codeMateriel, String nomMateriel,
      String descrMateriel);

  public String createReservation(String salleReservee, Calendar dateDebutReserve,
      Calendar dateFinReserve, String idClient, DureeReservation dureeReservation);

  public String createSalle(int noEtage, int noSalle, String idSalle, int noBat, int superficie,
      String typeSalle);
}
