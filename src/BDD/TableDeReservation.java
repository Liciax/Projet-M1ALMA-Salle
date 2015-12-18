/**
 * 
 */
package BDD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import representation.Reservation;
import representation.ReservationImpl;

/**
 * @author Lenny Lucas
 *
 */
public class TableDeReservation implements Table {

  private Map<String, Reservation> tableRes;
  
  
  
  /**
   * 
   */
  public TableDeReservation() {
    this.tableRes = new TreeMap<String, Reservation>();
  }
  
  /* (non-Javadoc)
   * @see BDD.Table#put(java.lang.Object)
   */
  @Override
  public String put(Object value) {
    String valfin;

    final List<Entry<String, Reservation>> entries =
        new ArrayList<Entry<String, Reservation>>(tableRes.entrySet());

    Collections.sort(entries, new Comparator<Entry<String, Reservation>>() {
      public int compare(final Entry<String, Reservation> e1, final Entry<String, Reservation> e2) {
        int a =
            ((ReservationImpl) e1.getValue()).getIdSalle().compareTo(
                ((ReservationImpl) e2.getValue()).getIdSalle());
        if (a != 0) {
          return a;
        } else {
          return e1.getValue().getHeureDebutReserve()
              .compareTo(e2.getValue().getHeureDebutReserve());
        }
      }
    });

    int i = 0;
    while ((i < entries.size())
        && (((ReservationImpl) value).getIdSalle() != ((ReservationImpl) entries.get(i))
            .getIdSalle())
        && (((Reservation) value).getHeureDebutReserve().compareTo(entries.get(i).getValue().getHeureFinReserve()) >= 0)) {

      i++;// on avance jusqu'a trouver l'horaire de fin de reservation juste avant cette nouvelle
          // reservation
    }
    if ((((ReservationImpl) value).getIdSalle() != ((ReservationImpl) entries.get(i)).getIdSalle())
        || (((Reservation) value).getHeureFinReserve().compareTo(entries.get(i).getValue().getHeureDebutReserve()) >= 0)) {
      // pas de conflict ou pas de reservation
      if (tableRes.isEmpty()) {
        valfin = "R10001";
      } else {
        String val = ((TreeMap<String, Reservation>) tableRes).lastKey();
        val = val.substring(1);
        int newval = Integer.parseInt(val) + 1;
        valfin = "R" + newval;
      }
      tableRes.put(valfin, (Reservation) value);
    } else {
      valfin = "err";
    }
    return valfin;
  }

  /* (non-Javadoc)
   * @see BDD.Table#containsKey(java.lang.String)
   */
  @Override
  public boolean containsKey(String key) {
    return tableRes.containsKey(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#get(java.lang.String)
   */
  @Override
  public Object get(String key) {
    return tableRes.get(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#ContainsValue(java.lang.Object)
   */
  @Override
  public boolean containsValue(Object value) {
    return tableRes.containsValue(value);
  }


  /* (non-Javadoc)
   * @see BDD.Table#update(java.lang.String, java.lang.Object)
   */
  @Override
  public boolean update(String key, Object newval) {
    return (tableRes.put(key, (Reservation) newval) != null);
  }

  /* (non-Javadoc)
   * @see BDD.Table#remove(java.lang.String)
   */
  @Override
  public boolean remove(String key) {
    return (tableRes.remove(key) != null);
  }

  public Map<String, Reservation> getTableRes() {
    return tableRes;
  }

}
