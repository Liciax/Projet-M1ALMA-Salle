package BDD;

import java.util.Map;
import java.util.TreeMap;

import representation.Batiment;
import representation.Salle;

public class TableDeSalle implements Table {


  private Map<String, Salle> tableSalle;
  
  /**
   * 
   */
  public TableDeSalle() {
    this.tableSalle = new TreeMap<String, Salle>();
  }
  
  @Override
  public boolean containsKey(String key) {
    return tableSalle.containsKey(key);
  }

  @Override
  public Object get(String key) {
    return tableSalle.get(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return tableSalle.containsValue(value);
  }

  @Override
  public String put(Object value) {
    String valfin;
    if (tableSalle.isEmpty()) {
      valfin = "S10001";
    } else {
      String val = ((TreeMap<String, Salle>) tableSalle).lastKey();
      val = val.substring(1);
      int newval = Integer.parseInt(val) + 1;
      valfin = "S" + newval;
    }

    tableSalle.put(valfin, (Salle) value);
    return valfin;
  }

  @Override
  public boolean update(String key, Object newval) {
    return (tableSalle.put(key, (Salle) newval) != null);
  }

  @Override
  public boolean remove(String key) {
    return (tableSalle.remove(key) != null);
  }

}
