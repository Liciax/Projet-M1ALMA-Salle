package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import representation.AdresseImpl;
import representation.Demandeur;
import representation.DemandeurImpl;
import BDD.TableDeAdresse;
import BDD.TableDeDemandeur;

public class TableDeDemandeurTest {

  private TableDeDemandeur tabdd;
  private DemandeurImpl dem;
  
  @Before
  public void setUp() throws Exception {
    tabdd = new TableDeDemandeur();
    dem = new DemandeurImpl(null, null, null, null);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testTableDeDemandeur() {
    TableDeDemandeur tab = new TableDeDemandeur();
    assertNotNull(tab);
  }

  @Test
  public void testPut() {
    String key = tabdd.put(dem);
    assert tabdd.getTableDemandeur().containsKey(key);
  }

  @Test
  public void testMultiplePut() {
    String key = tabdd.put(dem);
    DemandeurImpl dem2 = new DemandeurImpl("hello", null, null, null);
    String key2 = tabdd.put(dem2);
    assert key.compareTo(key2)<0;
  }
  
  @Test
  public void testContainsKey() {
    String key = tabdd.put(dem);
    assert tabdd.containsKey(key);
  }

  @Test
  public void testGet() {
    
    String key = tabdd.put(dem);
    assert tabdd.get(key).equals(dem);
  }

  @Test
  public void testContainsValue() {
    String key = tabdd.put(dem);
    assert tabdd.containsValue(dem);
  }

  @Test
  public void testUpdate() {
    String key = tabdd.put(dem);
    DemandeurImpl dem2 = new DemandeurImpl("hello", null, null, null);
    tabdd.update(key, dem2);
    assert tabdd.containsValue(dem2);
  }

  @Test
  public void testRemove() {
    String key = tabdd.put(dem);
    tabdd.remove(key);
    assert tabdd.getTableDemandeur().isEmpty();
  }


}
