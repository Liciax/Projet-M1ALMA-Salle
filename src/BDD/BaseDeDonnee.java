/**
 * 
 */
package BDD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


import representation.Adresse;
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

private Table tableDeReservation;
private Table tableDeBatiment;
private Table tableDeSalle;
private Table tableDeDemandeur;
private Table tableDeMateriel;
private Table tableDeAdresse;


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
    case 'A':
      return tableDeAdresse.containsKey(key);
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
    case 'A':
      return tableDeAdresse.get(key);
    default:
      return null;
  }
}

public boolean containsValue(Object value) {
  if(value instanceof Reservation) {
    return tableDeReservation.containsValue(value);
  } else if(value instanceof Batiment) {
    return tableDeBatiment.containsValue(value);
  } else if(value instanceof Salle) {
    return tableDeSalle.containsValue(value);
  } else if(value instanceof Demandeur) {
    return tableDeDemandeur.containsValue(value);
  } else if(value instanceof Materiel) {
    return tableDeMateriel.containsValue(value);
  } else if(value instanceof Adresse) {
    return tableDeAdresse.containsValue(value);
  } else {
    return false;
  }
}

public String put(Object value) {
  if(value instanceof Reservation) {
    return tableDeReservation.put(value);
  } else if(value instanceof Batiment) {
    return tableDeBatiment.put(value);
  } else if(value instanceof Salle) {
    return tableDeSalle.put(value);
  } else if(value instanceof Demandeur) {
    return tableDeDemandeur.put(value);
  } else if(value instanceof Materiel) {
    return tableDeMateriel.put(value);
  } else if(value instanceof Adresse) {
    return tableDeAdresse.put(value);
  } else {
    return "err";
  }
}

public boolean update(String key, Object newval) {
  if(newval instanceof Reservation) {
    return (tableDeReservation.update(key, newval));
  } else if(newval instanceof Batiment) {
    return (tableDeBatiment.update(key, newval));
  } else if(newval instanceof Salle) {
    return (tableDeSalle.update(key, newval));
  } else if(newval instanceof Demandeur) {
    return (tableDeDemandeur.update(key, newval));
  } else if(newval instanceof Materiel) {
    return (tableDeMateriel.update(key, newval));
  } else if(newval instanceof Adresse) {
    return (tableDeAdresse.update(key, newval));
  } else {
    return false;
  }
}

public boolean remove(String key) {
  switch (key.charAt(0)) {
    case 'R':
      return (tableDeReservation.remove(key));
    case 'B':
      return (tableDeBatiment.remove(key));
    case 'S':
      return (tableDeSalle.remove(key));
    case 'D':
      return (tableDeDemandeur.remove(key));
    case 'M':
      return (tableDeMateriel.remove(key));
    case 'A':
      return (tableDeAdresse.remove(key));
    default:
      return false;
  }
}

//
  
//  private Map<String, Reservation> tableDeReservation;
//  private Map<String, Batiment> tableDeBatiment;
//  private Map<String, Salle> tableDeSalle;
//  private Map<String, Demandeur> tableDeDemandeur;
//  private Map<String, Materiel> tableDeMateriel;
//  private Map<String, Adresse> tableDeAdresse;
//
//
//  /**
//   * @param tableDeReservation
//   * @param tableDeBatiment
//   * @param tableDeSalle
//   * @param tableDeDemandeur
//   * @param tableDeMateriel
//   */
//  public BaseDeDonnee() {
//    this.tableDeReservation = new TreeMap<String, Reservation>();
//    this.tableDeBatiment = new TreeMap<String, Batiment>();
//    this.tableDeSalle = new TreeMap<String, Salle>();
//    this.tableDeDemandeur = new TreeMap<String, Demandeur>();
//    this.tableDeMateriel = new TreeMap<String, Materiel>();
//    this.tableDeAdresse = new TreeMap<String, Adresse>();
//  }
//
//  // ---------------------------------------------------------------------//
//  // -----------------------------containsKey-----------------------------//
//  // ---------------------------------------------------------------------//
//  public boolean containsKey(String key) {
//    switch (key.charAt(0)) {
//      case 'R':
//        return tableDeReservation.containsKey(key);
//      case 'B':
//        return tableDeBatiment.containsKey(key);
//      case 'S':
//        return tableDeSalle.containsKey(key);
//      case 'D':
//        return tableDeDemandeur.containsKey(key);
//      case 'M':
//        return tableDeMateriel.containsKey(key);
//      case 'A':
//        return tableDeAdresse.containsKey(key);
//      default:
//        return false;
//    }
//  }
//
//  // ---------------------------------------------------------------------//
//  // ---------------------------------get---------------------------------//
//  // ---------------------------------------------------------------------//
//
//  public Object get(String key) {
//    switch (key.charAt(0)) {
//      case 'R':
//        return tableDeReservation.get(key);
//      case 'B':
//        return tableDeBatiment.get(key);
//      case 'S':
//        return tableDeSalle.get(key);
//      case 'D':
//        return tableDeDemandeur.get(key);
//      case 'M':
//        return tableDeMateriel.get(key);
//      case 'A':
//        return tableDeAdresse.get(key);
//      default:
//        return null;
//    }
//  }
//
//  // ---------------------------------------------------------------------//
//  // ----------------------------ContainsValue----------------------------//
//  // ---------------------------------------------------------------------//
//
//
//  public boolean ContainsValue(Reservation value) {
//    return tableDeReservation.containsValue(value);
//  }
//
//  public boolean ContainsValue(Batiment value) {
//    return tableDeBatiment.containsValue(value);
//  }
//
//  public boolean ContainsValue(Salle value) {
//    return tableDeSalle.containsValue(value);
//  }
//
//  public boolean ContainsValue(Demandeur value) {
//    return tableDeDemandeur.containsValue(value);
//  }
//
//  public boolean ContainsValue(Materiel value) {
//    return tableDeMateriel.containsValue(value);
//  }
//
//  public boolean ContainsValue(Adresse value) {
//    return tableDeAdresse.containsValue(value);
//  }
//
//  // ---------------------------------------------------------------------//
//  // ---------------------------------put---------------------------------//
//  // ---------------------------------------------------------------------//
//
//  public String put(Reservation value) {
//    String valfin;
//
//    final List<Entry<String, Reservation>> entries =
//        new ArrayList<Entry<String, Reservation>>(tableDeReservation.entrySet());
//
//    Collections.sort(entries, new Comparator<Entry<String, Reservation>>() {
//      public int compare(final Entry<String, Reservation> e1, final Entry<String, Reservation> e2) {
//        int a =
//            ((ReservationImpl) e1.getValue()).getIdSalle().compareTo(
//                ((ReservationImpl) e2.getValue()).getIdSalle());
//        if (a != 0) {
//          return a;
//        } else {
//          return e1.getValue().getHeureDebutReserve()
//              .compareTo(e2.getValue().getHeureDebutReserve());
//        }
//      }
//    });
//
//    int i = 0;
//    while ((i < entries.size())
//        && (((ReservationImpl) value).getIdSalle() != ((ReservationImpl) entries.get(i))
//            .getIdSalle())
//        && (value.getHeureDebutReserve().compareTo(entries.get(i).getValue().getHeureFinReserve()) >= 0)) {
//
//      i++;// on avance jusqu'a trouver l'horaire de fin de reservation juste avant cette nouvelle
//          // reservation
//    }
//    if ((((ReservationImpl) value).getIdSalle() != ((ReservationImpl) entries.get(i)).getIdSalle())
//        || (value.getHeureFinReserve().compareTo(entries.get(i).getValue().getHeureDebutReserve()) >= 0)) {
//      // pas de conflict ou pas de reservation
//      if (tableDeReservation.isEmpty()) {
//        valfin = "R10001";
//      } else {
//        String val = ((TreeMap<String, Reservation>) tableDeReservation).lastKey();
//        val = val.substring(1);
//        int newval = Integer.parseInt(val) + 1;
//        valfin = "R" + newval;
//      }
//      tableDeReservation.put(valfin, value);
//    } else {
//      valfin = "err";
//    }
//    return valfin;
//  }
//
//  public String put(Batiment value) {
//    String valfin;
//    if (tableDeBatiment.isEmpty()) {
//      valfin = "B10001";
//    } else {
//      String val = ((TreeMap<String, Batiment>) tableDeBatiment).lastKey();
//      val = val.substring(1);
//      int newval = Integer.parseInt(val) + 1;
//      valfin = "B" + newval;
//    }
//
//    tableDeBatiment.put(valfin, value);
//    return valfin;
//  }
//
//  public String put(Salle value) {
//    String valfin;
//    if (tableDeSalle.isEmpty()) {
//      valfin = "S10001";
//    } else {
//      String val = ((TreeMap<String, Salle>) tableDeSalle).lastKey();
//      val = val.substring(1);
//      int newval = Integer.parseInt(val) + 1;
//      valfin = "S" + newval;
//    }
//
//    tableDeSalle.put(valfin, value);
//    return valfin;
//  }
//
//  public String put(Demandeur value) {
//    String valfin;
//    if (tableDeDemandeur.isEmpty()) {
//      valfin = "D10001";
//    } else {
//      String val = ((TreeMap<String, Demandeur>) tableDeDemandeur).lastKey();
//      val = val.substring(1);
//      int newval = Integer.parseInt(val) + 1;
//      valfin = "D" + newval;
//    }
//
//    tableDeDemandeur.put(valfin, value);
//    return valfin;
//  }
//
//  public String put(Materiel value) {
//    String valfin;
//    if (tableDeMateriel.isEmpty()) {
//      valfin = "M10001";
//    } else {
//      String val = ((TreeMap<String, Materiel>) tableDeMateriel).lastKey();
//      val = val.substring(1);
//      int newval = Integer.parseInt(val) + 1;
//      valfin = "M" + newval;
//    }
//    tableDeMateriel.put(valfin, value);
//    return valfin;
//  }
//
//  public String put(Adresse value) {
//    String valfin;
//    if (tableDeAdresse.isEmpty()) {
//      valfin = "A10001";
//    } else {
//      String val = ((TreeMap<String, Adresse>) tableDeAdresse).lastKey();
//      val = val.substring(1);
//      int newval = Integer.parseInt(val) + 1;
//      valfin = "A" + newval;
//    }
//
//    tableDeAdresse.put(valfin, value);
//    return valfin;
//  }
//
//  // ---------------------------------------------------------------------//
//  // -------------------------------update--------------------------------//
//  // ---------------------------------------------------------------------//
//
//  public boolean update(String key, Reservation newval) {
//    return (tableDeReservation.put(key, newval) != null);
//  }
//
//  public boolean update(String key, Batiment newval) {
//    return (tableDeBatiment.put(key, newval) != null);
//  }
//
//  public boolean update(String key, Salle newval) {
//    return (tableDeSalle.put(key, newval) != null);
//  }
//
//  public boolean update(String key, Demandeur newval) {
//    return (tableDeDemandeur.put(key, newval) != null);
//  }
//
//  public boolean update(String key, Materiel newval) {
//    return (tableDeMateriel.put(key, newval) != null);
//  }
//
//  public boolean update(String key, Adresse newval) {
//    return (tableDeAdresse.put(key, newval) != null);
//  }
//
//  // ---------------------------------------------------------------------//
//  // -------------------------------remove--------------------------------//
//  // ---------------------------------------------------------------------//
//
//  public boolean remove(String key) {
//    switch (key.charAt(0)) {
//      case 'R':
//        return (tableDeReservation.remove(key) != null);
//      case 'B':
//        return (tableDeBatiment.remove(key) != null);
//      case 'S':
//        return (tableDeSalle.remove(key) != null);
//      case 'D':
//        return (tableDeDemandeur.remove(key) != null);
//      case 'M':
//        return (tableDeMateriel.remove(key) != null);
//      case 'A':
//        return (tableDeAdresse.remove(key) != null);
//      default:
//        return false;
//    }
//  }

}
