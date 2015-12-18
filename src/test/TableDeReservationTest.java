package test;

import static org.junit.Assert.*;

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
    res = new ReservationImpl(null, null, null, null, null);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testPut() {
    fail("Not yet implemented");
  }

  @Test
  public void testContainsKey() {
    fail("Not yet implemented");
  }

  @Test
  public void testGet() {
    fail("Not yet implemented");
  }

  @Test
  public void testContainsValue() {
    fail("Not yet implemented");
  }

  @Test
  public void testUpdate() {
    fail("Not yet implemented");
  }

  @Test
  public void testRemove() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetTableRes() {
    fail("Not yet implemented");
  }

}
