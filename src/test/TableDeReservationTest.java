package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import representation.AdresseImpl;
import representation.Reservation;
import representation.ReservationImpl;
import BDD.TableDeAdresse;
import BDD.TableDeDemandeur;
import BDD.TableDeReservation;

public class TableDeReservationTest {

  private TableDeReservation tabdr;
  private ReservationImpl res;

  @Before
  public void setUp() throws Exception {
    tabdr = new TableDeReservation();
    Calendar cd = new GregorianCalendar(2015, 12, 5, 14, 0);
    Calendar cf = new GregorianCalendar(2015, 12, 5, 18, 0);
    res = new ReservationImpl("S10001", cd, cf, "D10001");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testPut() {
    String key = tabdr.put(res);
    assert tabdr.getTableRes().containsKey(key);
  }

  @Test
  public void testMultiplePut() {
    String key = tabdr.put(res);
    Calendar cd = new GregorianCalendar(2015, 12, 6, 14, 0);
    Calendar cf = new GregorianCalendar(2015, 12, 6, 18, 0);
    ReservationImpl res2 = new ReservationImpl("S10001", cd, cf, "D10001");
    String key2 = tabdr.put(res2);
    assert key.compareTo(key2) < 0;
  }

  @Test
  public void testConflitPut() {
    String key = tabdr.put(res);
    Calendar cd = new GregorianCalendar(2015, 12, 5, 15, 0);
    Calendar cf = new GregorianCalendar(2015, 12, 6, 18, 0);
    ReservationImpl res2 = new ReservationImpl("S10001", cd, cf, "D10001");
    String key2 = tabdr.put(res2);
    assertTrue(key2, key2.equals("err"));
    assert tabdr.getTableRes().size() == 1;
  }

  @Test
  public void testContainsKey() {
    String key = tabdr.put(res);
    assert tabdr.containsKey(key);
  }

  @Test
  public void testGet() {

    String key = tabdr.put(res);
    assert tabdr.get(key).equals(res);
  }

  @Test
  public void testContainsValue() {
    String key = tabdr.put(res);
    assert tabdr.containsValue(res);
  }

  @Test
  public void testUpdate() {
    String key = tabdr.put(res);
    Calendar cd = new GregorianCalendar(2015, 12, 5, 15, 0);
    Calendar cf = new GregorianCalendar(2015, 12, 6, 18, 0);
    ReservationImpl res2 = new ReservationImpl("S10001", cd, cf, "D10001");
    tabdr.update(key, res2);
    assert tabdr.containsValue(res2);
  }

  @Test
  public void testRemove() {
    String key = tabdr.put(res);
    tabdr.remove(key);
    assert tabdr.getTableRes().isEmpty();
  }


}
