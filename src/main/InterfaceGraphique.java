package main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import representation.AdresseImpl;
import representation.BatimentImpl;
import representation.MaterielImpl;
import representation.ReservationImpl;
import representation.SalleImpl;

public interface InterfaceGraphique {

  public boolean creationAdresse(int noRue, String rue, int codePostal, String ville,
      String complement);
  public List<String> affichageAdresses();
  public  AdresseImpl getAdresseDeKey(String key);
  public boolean retirerAdresse(String key);
  
  public boolean creationSalle(int noEtage, int noSalle, String idBat, int superficie,
      String typeSalle);
  public List<String> affichageSalles();
  public SalleImpl getSalleDeKey(String key);
  public List<String> affichageMaterielDeSalle(String idSalle);
  public boolean retirerSalle(String key);
  
  public boolean creationBatiment(String idAdr);
  public List<String> affichageBatiments();
  public List<String> getSallesDeBatiment(String idbat);
  public BatimentImpl getBatimentDeKey(String key);
  public boolean retirerBatiment(String idBat);
  
  public boolean creationMateriel(String codeMateriel, String nomMateriel,
      String descrMateriel, double tarif);
  public List<String> affichageMateriaux(GregorianCalendar dateDeb, GregorianCalendar dateFin);
  public MaterielImpl getMaterielDeKey(String key);
  public void libererMat(Calendar cd, String idSalle, String idMat);
  public void fixerMat(Calendar cd, String idSalle, String idMat);
  public void retirerMateriel(String idMat);
  
  public String creationReservation(String salleReservee, Calendar dateDebutReserve, Calendar dateFinReserve,
      String idClient);
  public List<String> affichageReservations();
  public ReservationImpl getReservationDeKey(String key);
  public boolean retirerReservation(String idReservation, String idDemandeur);
}
