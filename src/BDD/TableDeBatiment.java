/**
 * 
 */
package BDD;

import java.util.Map;
import java.util.TreeMap;

import representation.Batiment;
import representation.Reservation;

/**
 * @author Lenny Lucas
 *
 */
public class TableDeBatiment implements Table {

  private Map<String, Batiment> tableBat;
  
  /**
   * 
   */
  public TableDeBatiment() {
    this.tableBat = new TreeMap<String, Batiment>();
  }

  /* (non-Javadoc)
   * @see BDD.Table#put(java.lang.Object)
   */
  @Override
  public String put(Object value) {
    String valfin;
    if (tableBat.isEmpty()) {
      valfin = "B10001";
    } else {
      String val = ((TreeMap<String, Batiment>) tableBat).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "B" + newval;
    }

    tableBat.put(valfin, (Batiment) value);
    return valfin;
  }
  
  /* (non-Javadoc)
   * @see BDD.Table#containsKey(java.lang.String)
   */
  @Override
  public boolean containsKey(String key) {
    return tableBat.containsKey(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#get(java.lang.String)
   */
  @Override
  public Object get(String key) {
    return tableBat.get(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#ContainsValue(java.lang.Object)
   */
  @Override
  public boolean containsValue(Object value) {
    return tableBat.containsValue(value);
  }


  /* (non-Javadoc)
   * @see BDD.Table#update(java.lang.String, java.lang.Object)
   */
  @Override
  public boolean update(String key, Object newval) {
    return (tableBat.put(key, (Batiment) newval) != null);
  }

  /* (non-Javadoc)
   * @see BDD.Table#remove(java.lang.String)
   */
  @Override
  public boolean remove(String key) {
    return (tableBat.remove(key) != null);
  }

  public Map<String, Batiment> getTableBat() {
    return tableBat;
  }

}
