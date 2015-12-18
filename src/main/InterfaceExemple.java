package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import representation.Adresse;
import representation.AdresseImpl;
import representation.Batiment;
import representation.BatimentImpl;
import representation.GestionSalleImpl;
import representation.Materiel;
import representation.MaterielImpl;
import representation.Reservation;
import representation.ReservationImpl;
import representation.Salle;
import representation.SalleImpl;

public class InterfaceExemple implements InterfaceGraphique {


  private  final GestionSalleImpl instance = new GestionSalleImpl();

  private InterfaceExemple() {}


  // --------------------------------------------------------------------//
  // pour les Adresses //
  // --------------------------------------------------------------------//

  public boolean creationAdresse(int noRue, String rue, int codePostal, String ville,
      String complement) {
    return instance.creationAdresse(noRue, rue, codePostal, ville, complement);
  }

  public List<String> affichageAdresses() {
    HashMap<String, Adresse> liste = instance.affichageAdresse();
    List<String> resultat = new ArrayList<String>();
    for (Entry<String, Adresse> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }

  public AdresseImpl getAdresseDeKey(String key) {
    return (AdresseImpl) instance.get(key);
  }

  public boolean retirerAdresse(String key) {
    return instance.removeAdresse(key);
  }

  // --------------------------------------------------------------------//
  // pour les Salles //
  // --------------------------------------------------------------------//

  public boolean creationSalle(int noEtage, int noSalle, String idBat, int superficie,
      String typeSalle) {
    if (instance.clefExiste(idBat)) {
      String key = instance.creationSalle(noEtage, noSalle, superficie, typeSalle);
      return instance.ajouterSalleABatiment(key, idBat);
    } else {
      return false; //il faut créer le batiment en 1er! si cette methode renvoie faux il faut créer un batiment dans l'interface
    }
  }

  public List<String> affichageSalles() {
    HashMap<String, Salle> liste = instance.affichageSalle();
    List<String> resultat = new ArrayList<String>();
    for (Entry<String, Salle> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }

  public SalleImpl getSalleDeKey(String key) {
    return (SalleImpl) instance.get(key);
  }

  public List<String> affichageMaterielDeSalle(String idSalle) {
    HashMap<String, Materiel> liste = instance.afficherMaterielDeSalle(idSalle);
    List<String> resultat = new ArrayList<String>();
    for (Entry<String, Materiel> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }

  public boolean retirerSalle(String key) {
    return instance.removeSalle(key);
  }



  // --------------------------------------------------------------------//
  // pour les Batiments //
  // --------------------------------------------------------------------//

  public boolean creationBatiment(String idAdr) {
    if(instance.clefExiste(idAdr)) {
      return instance.creationBatiment(idAdr);
    } else {
      return false;
    }
  }

  public List<String> affichageBatiments() {
    HashMap<String, Batiment> liste = instance.affichageBatiment();
    List<String> resultat = new ArrayList<String>();
    for (Entry<String, Batiment> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }

  public List<String> getSallesDeBatiment(String idbat) {
    HashMap<String, Salle> liste = instance.afficherSallesDeBatiment(idbat);
    List<String> resultat = new ArrayList<String>();
    for (Entry<String, Salle> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }

  public BatimentImpl getBatimentDeKey(String key) {
    return (BatimentImpl) instance.get(key);
  }

  

  public boolean retirerBatiment(String idBat) {
    return instance.removeBatiment(idBat);
  }

  // --------------------------------------------------------------------//
  // pour les Materiaux //
  // --------------------------------------------------------------------//

  public boolean creationMateriel(String codeMateriel, String nomMateriel,
      String descrMateriel, double tarif) {
    return instance.creationMateriaux(codeMateriel, nomMateriel, descrMateriel, tarif);
  }


  public List<String> affichageMateriaux(GregorianCalendar dateDeb, GregorianCalendar dateFin) {
    HashMap<String, Materiel> liste = instance.affichageMateriaux(dateDeb, dateFin);
    List<String> resultat = new ArrayList<String>();
    for (Entry<String, Materiel> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }
  
  public MaterielImpl getMaterielDeKey(String key) {
    return (MaterielImpl) instance.get(key);
  }

  public void libererMat(Calendar cd, String idSalle, String idMat) {
    instance.libererMat(cd, idSalle, idMat);
  }

  public void fixerMat(Calendar cd, String idSalle, String idMat) {
    if(instance.clefExiste(idSalle)) {
      instance.fixerMat(cd, idSalle, idMat);
    }
  }

  public void retirerMateriel(String idMat) {
    instance.removeMateriaux(idMat);
  }


  
  // --------------------------------------------------------------------//
  // pour les Reservations //
  // --------------------------------------------------------------------//
  
  public String creationReservation(String salleReservee, Calendar dateDebutReserve, Calendar dateFinReserve,
      String idClient) {
    return instance.creationReservation(salleReservee, dateDebutReserve, dateFinReserve, idClient);
  }
  
  public List<String> affichageReservations() {
    HashMap<String, Reservation> liste = instance.affichageReservation();
    List<String> resultat = new ArrayList<String>();
    for (Entry<String, Reservation> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }
  
  public ReservationImpl getReservationDeKey(String key) {
    return (ReservationImpl) instance.get(key);
  }
  
  public boolean retirerReservation(String idReservation, String idDemandeur) {
    return instance.removeReservation(idReservation, idDemandeur);
  }

}
