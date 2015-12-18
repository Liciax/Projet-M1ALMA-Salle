package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import representation.AdresseImpl;
import BDD.Table;
import BDD.TableDeAdresse;

public class TableDeAdresseTest {

  private TableDeAdresse tabda;
  private AdresseImpl adr;
  
  @Before
  public void setUp() throws Exception {
    tabda = new TableDeAdresse();
    adr = new AdresseImpl(0, null, 0, null, null);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testTableDeAdresse() {
    Table tab = new TableDeAdresse();
    assertNotNull(tab);
  }

  @Test
  public void testPut() {
    String key = tabda.put(adr);
    assert tabda.getTableAdresse().containsKey(key);
  }
  
  @Test
  public void testMultiplePut() {
    String key = tabda.put(adr);
    AdresseImpl adr2 = new AdresseImpl(0, "lol", 0, null, null);
    String key2 = tabda.put(adr2);
    assert key.compareTo(key2)<0;
  }

  @Test
  public void testContainsKey() {
    String key = tabda.put(adr);
    assert tabda.containsKey(key);
  }

  @Test
  public void testGet() {
    
    String key = tabda.put(adr);
    assert tabda.get(key).equals(adr);
  }

  @Test
  public void testContainsValue() {
    String key = tabda.put(adr);
    assert tabda.containsValue(adr);
  }

  @Test
  public void testUpdate() {
    String key = tabda.put(adr);
    AdresseImpl adr2 = new AdresseImpl(0, "lol", 0, null, null);
    tabda.update(key, adr2);
    assert tabda.containsValue(adr2);
  }

  @Test
  public void testRemove() {
    String key = tabda.put(adr);
    tabda.remove(key);
    assert tabda.getTableAdresse().isEmpty();
  }

  
}
