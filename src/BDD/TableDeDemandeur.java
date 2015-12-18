/**
 * 
 */
package BDD;

import java.util.Map;
import java.util.TreeMap;

import representation.Demandeur;
import representation.Salle;

/**
 * @author Lenny Lucas
 *
 */
public class TableDeDemandeur implements Table {

  private Map<String, Demandeur> tableDemandeur;
  
  /**
   * 
   */
  public TableDeDemandeur() {
    this.tableDemandeur = new TreeMap<String, Demandeur>();
  }
  
  /* (non-Javadoc)
   * @see BDD.Table#containsKey(java.lang.String)
   */
  @Override
  public boolean containsKey(String key) {
    return tableDemandeur.containsKey(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#get(java.lang.String)
   */
  @Override
  public Object get(String key) {
    return tableDemandeur.get(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#ContainsValue(java.lang.Object)
   */
  @Override
  public boolean containsValue(Object value) {
    return tableDemandeur.containsValue(value);
  }

  /* (non-Javadoc)
   * @see BDD.Table#put(java.lang.Object)
   */
  @Override
  public String put(Object value) {
    String valfin;
    if (tableDemandeur.isEmpty()) {
      valfin = "D10001";
    } else {
      String val = ((TreeMap<String, Demandeur>) tableDemandeur).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "D" + newval;
    }

    tableDemandeur.put(valfin, (Demandeur) value);
    return valfin;
  }

  /* (non-Javadoc)
   * @see BDD.Table#update(java.lang.String, java.lang.Object)
   */
  @Override
  public boolean update(String key, Object newval) {
    return (tableDemandeur.put(key, (Demandeur) newval) != null);
  }

  /* (non-Javadoc)
   * @see BDD.Table#remove(java.lang.String)
   */
  @Override
  public boolean remove(String key) {
    return (tableDemandeur.remove(key) != null);
  }

}
