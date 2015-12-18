/**
 * 
 */
package BDD;

import java.util.Map;
import java.util.TreeMap;

import representation.Adresse;

/**
 * @author Lenny Lucas
 *
 */
public class TableDeAdresse implements Table {

  private Map<String, Adresse> tableAdresse;

  public TableDeAdresse() {
    this.tableAdresse = new TreeMap<String, Adresse>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see BDD.Table#put(java.lang.Object)
   */
  @Override
  public String put(Object value) {
    String valfin;
    if (tableAdresse.isEmpty()) {
      valfin = "A10001";
    } else {
      String val = ((TreeMap<String, Adresse>) tableAdresse).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "A" + newval;
    }

    tableAdresse.put(valfin, (Adresse) value);
    return valfin;
  }

  /*
   * (non-Javadoc)
   * 
   * @see BDD.Table#containsKey(java.lang.String)
   */
  @Override
  public boolean containsKey(String key) {
    return tableAdresse.containsKey(key);
  }

  /*
   * (non-Javadoc)
   * 
   * @see BDD.Table#get(java.lang.String)
   */
  @Override
  public Object get(String key) {
    return tableAdresse.get(key);
  }

  /*
   * (non-Javadoc)
   * 
   * @see BDD.Table#ContainsValue(java.lang.Object)
   */
  @Override
  public boolean containsValue(Object value) {
    return tableAdresse.containsValue(value);
  }



  /*
   * (non-Javadoc)
   * 
   * @see BDD.Table#update(java.lang.String, java.lang.Object)
   */
  @Override
  public boolean update(String key, Object newval) {
    return (tableAdresse.put(key, (Adresse) newval) != null);
  }

  /*
   * (non-Javadoc)
   * 
   * @see BDD.Table#remove(java.lang.String)
   */
  @Override
  public boolean remove(String key) {
    return (tableAdresse.remove(key) != null);
  }

  public Map<String, Adresse> getTableAdresse() {
    return tableAdresse;
  }


}
