/**
 * 
 */
package BDD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import representation.Batiment;
import representation.Demandeur;
import representation.Materiel;
import representation.Reservation;
import representation.Salle;


/**
 * @author Lenny Lucas
 * 
 */
public class BaseDeDonnee {

  private Map<String, Reservation> tableDeReservation;
  private Map<String, Batiment> tableDeBatiment;
  private Map<String, Salle> tableDeSalle;
  private Map<String, Demandeur> tableDeDemandeur;
  private Map<String, Materiel> tableDeMateriel;

  /**
   * @param tableDeReservation
   * @param tableDeBatiment
   * @param tableDeSalle
   * @param tableDeDemandeur
   * @param tableDeMateriel
   */
  public BaseDeDonnee() {
<<<<<<< Updated upstream
    this.tableDeReservation = new TreeMap<String, Reservation>();
    this.tableDeBatiment = new TreeMap<String, Batiment>();
    this.tableDeSalle = new TreeMap<String, Salle>();
    this.tableDeDemandeur = new TreeMap<String, Demandeur>();
    this.tableDeMateriel = new TreeMap<String, Materiel>();
  }

  public boolean containsKeyReservation(String key) {
    return tableDeReservation.containsKey(key);
  }

  public boolean ContainsValueReservation(Reservation value) {
    return tableDeReservation.containsValue(value);
  }

  public Reservation GetReservation(String key) {
    return tableDeReservation.get(key);
  }

  public String putReservation(Reservation value) {
    String valfin;
    
    final List<Entry<String, Reservation>> entries = new ArrayList<Entry<String, Reservation>>(tableDeReservation.entrySet());
    
    Collections.sort(entries, new Comparator<Entry<String, Reservation>>() {
      public int compare(final Entry<String, Reservation> e1, final Entry<String, Reservation> e2) {
        return e1.getHeureDebutReserv().compareTo(e2.getHeureDebutReserv());
      }
    });
    
    if (tableDeReservation.isEmpty()) {
      valfin = "B10001";
    } else {
      String val = ((TreeMap<String, Reservation>) tableDeReservation).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "B" + newval;
    }

    tableDeReservation.put(valfin, value);
    return valfin;
  }

  public boolean removeReservation(String key) {
    return (tableDeReservation.remove(key) != null);
  }

  // ------------------------------------------------

  public boolean containsKeyBatiment(String key) {
    return tableDeBatiment.containsKey(key);
  }

  public boolean ContainsValueBatiment(Batiment value) {
    return tableDeBatiment.containsValue(value);
  }

  public Batiment GetBatiment(String key) {
    return tableDeBatiment.get(key);
  }

  public String putBatiment(Batiment value) {
    String valfin;
    if (tableDeBatiment.isEmpty()) {
      valfin = "B10001";
    } else {
      String val = ((TreeMap<String, Batiment>) tableDeBatiment).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "B" + newval;
    }

    tableDeBatiment.put(valfin, value);
    return valfin;
  }

  public boolean removeBatiment(String key) {
    return (tableDeBatiment.remove(key) != null);
  }

  // ------------------------------------------------

  public boolean containsKeySalle(String key) {
    return tableDeSalle.containsKey(key);
  }

  public boolean ContainsValueSalle(Salle value) {
    return tableDeSalle.containsValue(value);
  }

  public Salle GetSalle(String key) {
    return tableDeSalle.get(key);
  }

  public String putSalle(Salle value) {
    String valfin;
    if (tableDeSalle.isEmpty()) {
      valfin = "B10001";
    } else {
      String val = ((TreeMap<String, Salle>) tableDeSalle).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "B" + newval;
    }

    tableDeSalle.put(valfin, value);
    return valfin;
  }

  public boolean removeSalle(String key) {
    return (tableDeSalle.remove(key) != null);
  }

  // ------------------------------------------------

  public boolean containsKeyDemandeur(String key) {
    return tableDeDemandeur.containsKey(key);
  }

  public boolean ContainsValueDemandeur(Demandeur value) {
    return tableDeDemandeur.containsValue(value);
  }

  public Demandeur GetDemandeur(String key) {
    return tableDeDemandeur.get(key);
  }

  public String putDemandeur(Demandeur value) {
    String valfin;
    if (tableDeDemandeur.isEmpty()) {
      valfin = "B10001";
    } else {
      String val = ((TreeMap<String, Demandeur>) tableDeDemandeur).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "B" + newval;
    }

    tableDeDemandeur.put(valfin, value);
    return valfin;
  }

  public boolean removeDemandeur(String key) {
    return (tableDeDemandeur.remove(key) != null);
  }

  // ------------------------------------------------

  public boolean containsKeyMateriel(String key) {
    return tableDeMateriel.containsKey(key);
  }

  public boolean ContainsValueMateriel(Materiel value) {
    return tableDeMateriel.containsValue(value);
  }

  public Materiel GetMateriel(String key) {
    return tableDeMateriel.get(key);
  }

  public String putMateriel(Materiel value) {
    String valfin;
    if (tableDeMateriel.isEmpty()) {
      valfin = "B10001";
    } else {
      String val = ((TreeMap<String, Materiel>) tableDeMateriel).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "B" + newval;
    }

    tableDeMateriel.put(valfin, value);
    return valfin;
  }

  public boolean removeMateriel(String key) {
    return (tableDeMateriel.remove(key) != null);
  }

  // ------------------------------------------------
=======
    this.tableDeReservation = new HashMap<String, Reservation>();
    this.tableDeBatiment = new HashMap<String, Batiment>();
    this.tableDeSalle = new HashMap<String, Salle>();
    this.tableDeDemandeur = new HashMap<String, Demandeur>();
    this.tableDeMateriel = new HashMap<String, Materiel>();
  }

>>>>>>> Stashed changes


}
