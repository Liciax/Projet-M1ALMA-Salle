package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import representation.Batiment;
import representation.BatimentImpl;

import BDD.TableDeBatiment;

public class TableDeBatimentTest {

  private TableDeBatiment tb;
  private Batiment bat;
  private String key;
  
  @Before
  public void setUp() throws Exception {
    tb = new TableDeBatiment();
    bat = new BatimentImpl("A1");
    key = tb.put(bat);
  }

  @Test
  public void testTableDeBatiment() {
    assertNotNull(tb);
  }

  @Test
  public void testPut() {
    Batiment bat2 = new BatimentImpl("A2");
    String key2 = tb.put(bat2);
    assert tb.getTableBat().containsValue(bat2);
    assert tb.getTableBat().containsKey(key2);
  }

  @Test
  public void testContainsKey() {
    assertTrue(true==tb.containsKey(key));
    assertTrue(false==tb.containsKey("B10002"));
    Batiment bat2 = new BatimentImpl("A2");
    String key2 = tb.put(bat2);
    assertTrue(true==tb.containsKey(key2));
  }

  @Test
  public void testget() {
    assert tb.get(key) == tb.getTableBat().get(key);
  }
  
  @Test
  public void testContainsValue() {
    assertTrue(true==tb.containsValue(bat));
  }

  @Test
  public void testUpdate() {
    Batiment bat2 = new BatimentImpl("A2");
    boolean res = tb.update(key, bat2);
    assert res == true;
    assert tb.containsValue(bat2);
  }

  @Test
  public void testRemove() {
    Batiment bat2 = new BatimentImpl("A2");
    String key2 = tb.put(bat2);
    tb.remove(key2);
    assert tb.containsKey(key2) == false;
    assert tb.containsValue(bat2) == false;
  }

}
