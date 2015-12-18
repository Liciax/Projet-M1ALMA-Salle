package BDD;

import representation.Reservation;

public interface Table {

  public String put(Object value);

  public boolean containsKey(String key);

  public Object get(String key);

  public boolean containsValue(Object value);

  public boolean update(String key, Object newval);

  public boolean remove(String key);
}
