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
    this.tableDeReservation = new TreeMap<String, Reservation>();
    this.tableDeBatiment = new TreeMap<String, Batiment>();
    this.tableDeSalle = new TreeMap<String, Salle>();
    this.tableDeDemandeur = new TreeMap<String, Demandeur>();
    this.tableDeMateriel = new TreeMap<String, Materiel>();
  }

  public boolean containsKey(String key) {
    switch (key.charAt(0)) {
      case 'R':
        return tableDeReservation.containsKey(key);
      case 'B':
        return tableDeBatiment.containsKey(key);
      case 'S':
        return tableDeSalle.containsKey(key);
      case 'D':
        return tableDeDemandeur.containsKey(key);
      case 'M':
        return tableDeMateriel.containsKey(key);
      default:
        return false;
    }
  }

  public Object get(String key) {
    switch (key.charAt(0)) {
      case 'R':
        return tableDeReservation.get(key);
      case 'B':
        return tableDeBatiment.get(key);
      case 'S':
        return tableDeSalle.get(key);
      case 'D':
        return tableDeDemandeur.get(key);
      case 'M':
        return tableDeMateriel.get(key);
      default:
        return null;
    }
  }


  // public boolean containsKeyReservation(String key) {
  // return tableDeReservation.containsKey(key);
  // }

  public boolean ContainsValue(Reservation value) {
    return tableDeReservation.containsValue(value);
  }

  // public Reservation GetReservation(String key) {
  // return tableDeReservation.get(key);
  // }

  public String put(Reservation value) {
    String valfin;

    final List<Entry<String, Reservation>> entries =
        new ArrayList<Entry<String, Reservation>>(tableDeReservation.entrySet());
    
    Collections.sort(entries, new Comparator<Entry<String, Reservation>>() {
      public int compare(final Entry<String, Reservation> e1, final Entry<String, Reservation> e2) {
        return e1.getValue().getHeureDebutReserv().compareTo(e2.getValue().getHeureDebutReserv());
      }
    });
    
    int i = 0;
    while ((i < entries.size())
        && (value.getHeureDebutReserv().compareTo(entries.get(i).getValue().getHeureFinReserv()) >= 0)) {
      i++;// on avance jusqu'a trouver l'horaire de fin de reservation juste avant cette nouvelle
          // reservation
    }
    if (value.getHeureFinReserv().compareTo(entries.get(i).getValue().getHeureDebutReserv()) >= 0)
    {// pas de conflict
      if (tableDeReservation.isEmpty()) {
        valfin = "R10001";
      } else {
        String val = ((TreeMap<String, Reservation>) tableDeReservation).lastKey();
        val = val.substring(1);
        int newval = Integer.parseInt(val) + 1;
        valfin = "R" + newval;
      }
      tableDeReservation.put(valfin, value);
    } else {
      valfin = "err";
    }
    return valfin;
  }
  
  public boolean remove(String key) {
    switch (key.charAt(0)) {
      case 'R':
        return (tableDeReservation.remove(key) != null);
      case 'B':
        return (tableDeBatiment.remove(key) != null);
      case 'S':
        return (tableDeSalle.remove(key) != null);
      case 'D':
        return (tableDeDemandeur.remove(key) != null);
      case 'M':
        return (tableDeMateriel.remove(key) != null);
      default:
        return false;
    }
  }

//  public boolean removeReservation(String key) {
//    return (tableDeReservation.remove(key) != null);
//  }

  // -----------------------------------------------------------------------------------------------------------------

  // public boolean containsKeyBatiment(String key) {
  // return tableDeBatiment.containsKey(key);
  // }

  public boolean ContainsValue(Batiment value) {
    return tableDeBatiment.containsValue(value);
  }

  // public Batiment GetBatiment(String key) {
  // return tableDeBatiment.get(key);
  // }

  public String put(Batiment value) {
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

//  public boolean removeBatiment(String key) {
//    return (tableDeBatiment.remove(key) != null);
//  }

  // -----------------------------------------------------------------------------------------------------------------
  
  // public boolean containsKeySalle(String key) {
  // return tableDeSalle.containsKey(key);
  // }

  public boolean ContainsValue(Salle value) {
    return tableDeSalle.containsValue(value);
  }

  // public Salle GetSalle(String key) {
  // return tableDeSalle.get(key);
  // }

  public String put(Salle value) {
    String valfin;
    if (tableDeSalle.isEmpty()) {
      valfin = "S10001";
    } else {
      String val = ((TreeMap<String, Salle>) tableDeSalle).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "S" + newval;
    }

    tableDeSalle.put(valfin, value);
    return valfin;
  }

//  public boolean removeSalle(String key) {
//    return (tableDeSalle.remove(key) != null);
//  }

  // -----------------------------------------------------------------------------------------------------------------

  // public boolean containsKeyDemandeur(String key) {
  // return tableDeDemandeur.containsKey(key);
  // }

  public boolean ContainsValue(Demandeur value) {
    return tableDeDemandeur.containsValue(value);
  }

  // public Demandeur GetDemandeur(String key) {
  // return tableDeDemandeur.get(key);
  // }

  public String put(Demandeur value) {
    String valfin;
    if (tableDeDemandeur.isEmpty()) {
      valfin = "D10001";
    } else {
      String val = ((TreeMap<String, Demandeur>) tableDeDemandeur).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "D" + newval;
    }

    tableDeDemandeur.put(valfin, value);
    return valfin;
  }

//  public boolean removeDemandeur(String key) {
//    return (tableDeDemandeur.remove(key) != null);
//  }

  // -----------------------------------------------------------------------------------------------------------------

  // public boolean containsKeyMateriel(String key) {
  // return tableDeMateriel.containsKey(key);
  // }

  public boolean ContainsValue(Materiel value) {
    return tableDeMateriel.containsValue(value);
  }

  // public Materiel GetMateriel(String key) {
  // return tableDeMateriel.get(key);
  // }

  public String put(Materiel value) {
    String valfin;
    if (tableDeMateriel.isEmpty()) {
      valfin = "M10001";
    } else {
      String val = ((TreeMap<String, Materiel>) tableDeMateriel).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "M" + newval;
    }
    tableDeMateriel.put(valfin, value);
    return valfin;
  }

//  public boolean removeMateriel(String key) {
//    return (tableDeMateriel.remove(key) != null);
//  }

  // -----------------------------------------------------------------------------------------------------------------


}
