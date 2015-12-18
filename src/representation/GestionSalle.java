package representation;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public interface GestionSalle {

  public boolean creationAdresse(int noRue, String rue, int codePostal, String ville,
      String complement);
  public HashMap<String, Adresse> affichageAdresse();
  public boolean removeAdresse(String idAdr);
  
  public boolean creationBatiment(String adresseBat);
  public HashMap<String, Batiment> affichageBatiment();
  public boolean removeBatiment(String idBat);
  public boolean ajouterSalleABatiment(String idSalle, String idBat);
  public boolean retirerSalleABatiment(String idSalle, String idBat);
  
  public String creationSalle(int noEtage, int noSalle, int superficie, String typeSalle);
  public HashMap<String, Salle> affichageSalle();
  public boolean removeSalle(String idSalle);
  
  public boolean creationMateriaux(String codeMateriel, String nomMateriel, String descrMateriel,
      double tarif);
  public HashMap<String, Materiel> affichageMateriaux(Calendar cd, Calendar cf);
  public void fixerMat(Calendar cd, String idSalle, String idMat);
  public void libererMat(Calendar cd, String idSalle, String idMat);
  
  public String creationReservation(String salleReservee, Calendar dateDebutReserve,
      Calendar dateFinReserve, String idClient);
  public HashMap<String, Reservation> affichageReservation();
  public boolean removeReservation(String idReservation, String idDemandeur);
}
