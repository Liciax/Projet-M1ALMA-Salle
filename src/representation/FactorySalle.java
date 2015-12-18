package representation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface FactorySalle {


  public Adresse createAdresse(int noRue, String rue, int codePostal, String ville,
      String complement);


  public Batiment createBatiment(String adresseBat);


  public Demandeur createDemandeur(String nomDemandeur, OrigineDemandeur origineDemandeur,
      TitreDemandeur titreDemandeur, String idAdresseDemandeur);


  public Materiel createMateriel(String codeMateriel, String nomMateriel, String descrMateriel,
      double tarif);


  public Reservation createReservation(String salleReservee, Calendar dateDebutReserve,
      Calendar dateFinReserve, String idClient);


  public Salle createSalle(int noEtage, int noSalle, String idBat, int superficie, String typeSalle);



}
