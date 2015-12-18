/**
 * 
 */
package BDD;

import java.util.Map;
import java.util.TreeMap;

import representation.Batiment;
import representation.Materiel;

/**
 * @author Lenny Lucas
 *
 */
public class TableDeMateriel implements Table {


  private Map<String, Materiel> tableMateriel;
  
  public TableDeMateriel() {
    this.tableMateriel = new TreeMap<String, Materiel>();
  }
  /* (non-Javadoc)
   * @see BDD.Table#containsKey(java.lang.String)
   */
  @Override
  public boolean containsKey(String key) {
    return tableMateriel.containsKey(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#put(java.lang.Object)
   */
  @Override
  public String put(Object value) {
    String valfin;
    if (tableMateriel.isEmpty()) {
      valfin = "M10001";
    } else {
      String val = ((TreeMap<String, Materiel>) tableMateriel).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "M" + newval;
    }
    tableMateriel.put(valfin, (Materiel) value);
    return valfin;
  }
  
  /* (non-Javadoc)
   * @see BDD.Table#get(java.lang.String)
   */
  @Override
  public Object get(String key) {
    return tableMateriel.get(key);
  }

  /* (non-Javadoc)
   * @see BDD.Table#ContainsValue(java.lang.Object)
   */
  @Override
  public boolean containsValue(Object value) {
    return tableMateriel.containsValue(value);
  }

  /* (non-Javadoc)
   * @see BDD.Table#update(java.lang.String, java.lang.Object)
   */
  @Override
  public boolean update(String key, Object newval) {
    return (tableMateriel.put(key, (Materiel) newval) != null);
  }

  /* (non-Javadoc)
   * @see BDD.Table#remove(java.lang.String)
   */
  @Override
  public boolean remove(String key) {
    return (tableMateriel.remove(key) != null);
  }

  public Map<String, Materiel> getTableMateriel() {
    return tableMateriel;
  }

}
