package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import representation.Batiment;
import representation.BatimentImpl;
import representation.Salle;
import representation.SalleImpl;

import BDD.TableDeBatiment;
import BDD.TableDeSalle;

public class TableDeSalleTest {

  private TableDeSalle ts;
  private Salle salle;
  private String key;

  @Before
  public void setUp() throws Exception {
    ts = new TableDeSalle();
    salle = new SalleImpl(1, 1, "A1", 20, "concert");
    key = ts.put(salle);
  }

  @Test
  public void testTableDeSalle() {
    assertNotNull(ts);
  }

  @Test
  public void testPut() {
    Salle salle2 = new SalleImpl(1, 2, "A1", 50, "réunion");
    String key2 = ts.put(salle2);
    assert ts.getTableSalle().containsValue(salle2);
    assert ts.getTableSalle().containsKey(key2);
  }

  @Test
  public void testContainsKey() {
    assertTrue(true == ts.containsKey(key));
    Salle salle2 = new SalleImpl(1, 2, "A1", 50, "réunion");
    String key2 = ts.put(salle2);
    assertTrue(true == ts.containsKey(key2));
  }

  @Test
  public void testGet() {
    assert ts.get(key) == ts.getTableSalle().get(key);
  }

  @Test
  public void testContainsValue() {
    assertTrue(true == ts.containsValue(salle));
  }

  @Test
  public void testUpdate() {
    Salle salle2 = new SalleImpl(1, 2, "A1", 50, "réunion");
    boolean res = ts.update(key, salle2);
    assert res == true;
    assert ts.containsValue(salle2);
  }

  @Test
  public void testRemove() {
    Salle salle2 = new SalleImpl(1, 2, "A1", 50, "réunion");
    String key2 = ts.put(salle2);
    ts.remove(key2);
    assert ts.containsKey(key2) == false;
    assert ts.containsValue(salle2) == false;
  }

}
