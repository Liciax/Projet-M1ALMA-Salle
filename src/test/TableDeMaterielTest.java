package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import representation.Materiel;
import representation.MaterielImpl;
import representation.Salle;
import representation.SalleImpl;
import BDD.TableDeMateriel;
import BDD.TableDeSalle;

public class TableDeMaterielTest {

  private TableDeMateriel tm;
  private Materiel materiel;
  private String key;

  @Before
  public void setUp() throws Exception {
    tm = new TableDeMateriel();
    materiel = new MaterielImpl( "m1", "tableau", "à craie", 50);
    key = tm.put(materiel);
  }

  @Test
  public void testTableDeMateriel() {
    assertNotNull(tm);
  }

  @Test
  public void testContainsKey() {
    assertTrue(true == tm.containsKey(key));
    Materiel mat2 = new MaterielImpl( "m2", "vaisselle", "en porcelaine", 10);
    String key2 = tm.put(mat2);
    assertTrue(true == tm.containsKey(key2));
  }

  @Test
  public void testPut() {
    Materiel mat2 = new MaterielImpl( "m2", "vaisselle", "en porcelaine", 10);
    String key2 = tm.put(mat2);
    assert tm.getTableMateriel().containsValue(mat2);
    assert tm.getTableMateriel().containsKey(key2);
  }

  @Test
  public void testGet() {
    assert tm.get(key) == tm.getTableMateriel().get(key);
  }

  @Test
  public void testContainsValue() {
    assertTrue(true == tm.containsValue(materiel));
  }

  @Test
  public void testUpdate() {
    Materiel mat2 = new MaterielImpl( "m2", "vaisselle", "en porcelaine", 10);
    boolean res = tm.update(key, mat2);
    assert res == true;
    assert tm.containsValue(mat2);
  }

  @Test
  public void testRemove() {
    Materiel mat2 = new MaterielImpl( "m2", "vaisselle", "en porcelaine", 10);
    String key2 = tm.put(mat2);
    tm.remove(key2);
    assert tm.containsKey(key2) == false;
    assert tm.containsValue(mat2) == false;
  }

}
