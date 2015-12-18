package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BDD.BaseDeDonnee;
import representation.Adresse;
import representation.AdresseImpl;
import representation.Batiment;
import representation.BatimentImpl;
import representation.GestionSalleImpl;
import representation.Materiel;
import representation.MaterielImpl;
import representation.Reservation;
import representation.ReservationImpl;
import representation.SalleImpl;
import representation.TypeMateriel;

public class GestionSalleImplTest {

  private GestionSalleImpl gsi;
//  private BaseDeDonnee bdd;
  
  @Before
  public void setUp() throws Exception {
    gsi = new GestionSalleImpl();
//    bdd = new BaseDeDonnee();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGestionSalleImpl() {
    assertNotNull(gsi);
  }

//  @Test
//  public void testGet() {
//  }

  @Test
  public void testCreationAdresse() {
    Adresse a = new AdresseImpl(0, null, 0, null, null);
    gsi.creationAdresse(0, null, 0, null, null);
    assert gsi.getBdd().containsKey("A10001");
  }

  @Test
  public void testAffichageAdresse() {
    Adresse a = new AdresseImpl(0, null, 0, null, null);
    gsi.creationAdresse(0, null, 0, null, null);
    assert gsi.affichageAdresse().containsKey("A10001");
  }

  @Test
  public void testRemoveAdresse() {
    Adresse a = new AdresseImpl(0, null, 0, null, null);
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.removeAdresse("A10001");
    assert !gsi.getBdd().containsKey("A10001");
  }

  @Test
  public void testCreationBatiment() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    assert gsi.getBdd().containsKey("B10001");
  }

  @Test
  public void testAffichageBatiment() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    assert gsi.affichageBatiment().containsKey("B10001");
  }

  @Test
  public void testRemoveBatiment() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    gsi.removeBatiment("B10001");
    assert !gsi.getBdd().containsKey("B10001");
  }

  @Test
  public void testAjouterSalleABatiment() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
    assert ((BatimentImpl)gsi.get("B10001")).getSalles().get(0).equals("S10001");
  }

  @Test
  public void testRetirerSalleABatiment() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
    gsi.retirerSalleABatiment("S10001", "B10001");
    assert ((BatimentImpl)gsi.get("B10001")).getSalles().size() == 0;
  }
  
  @Test
  public void testAfficherSallesDeBatiment() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
    assert gsi.afficherSallesDeBatiment("B10001").containsKey("S10001");
  }

  @Test
  public void testCreationSalle() {
    gsi.creationSalle(0, 0, 0, null);
    assert ((SalleImpl)gsi.get("S10001")).getNoEtage() ==0;
  }

  @Test
  public void testAffichageSalle() {
    gsi.creationSalle(0, 0, 0, null);
    assert gsi.affichageSalle().containsKey("S10001");
    
  }

  @Test
  public void testRemoveSalle() {
    gsi.creationSalle(0, 0, 0, null);
    
  }

  @Test
  public void testAfficherMaterielDeSalle() {
    gsi.creationSalle(0, 0, 0, null);
    gsi.creationMateriaux("ok", null, null, 0);
    gsi.fixerMat(new GregorianCalendar(), "S10001", "M10001");
    assert gsi.afficherMaterielDeSalle("S10001").containsKey("M10001");
  }

  @Test
  public void testCreationMateriaux() {
    gsi.creationMateriaux("ok", null, null, 0);
    Materiel m = ((MaterielImpl) gsi.getBdd().get("M10001"));
    System.out.println(((MaterielImpl)m).getCodeMateriel());
    assert ((MaterielImpl) gsi.getBdd().get("M10001")).getCodeMateriel().equals("ok");
  }

  @Test
  public void testAffichageMateriaux() {
    Materiel m = new MaterielImpl(null, null, null, 0);
    Materiel m2 = new MaterielImpl(null, null, null, 100);
    gsi.creationMateriaux("marche", null, null, 0);
    gsi.creationMateriaux("marche_aussi", null, null, 0);
    HashMap<String, Materiel> map = gsi.affichageMateriaux(new GregorianCalendar(), new GregorianCalendar());
//    for(Entry<String,Materiel> ent:map.entrySet()) {
//      System.out.println(ent.getKey());
//    }
    assert ((MaterielImpl)map.get("M10001")).getCodeMateriel().equals("marche");
    assert ((MaterielImpl)map.get("M10002")).getCodeMateriel().equals("marche_aussi");
  }

  @Test
  public void testFixerMat() {
    //Adresse a = new AdresseImpl(0, null, 0, null, null);
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    //Batiment b = new BatimentImpl("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
//    Salle s = new SalleImpl(0, 0, null, 0, null)
    gsi.creationMateriaux("test", "testNom", "testDescr", 0);
    gsi.fixerMat(new GregorianCalendar(), "S10001", "M10001");
    //gsi.fixerMat(new GregorianCalendar(), "S10001", gsi.affichageMateriaux(new GregorianCalendar(), new GregorianCalendar()));
    assert ((SalleImpl) gsi.get("S10001")).getMateriauxFixes().contains("M10001");
    assert ((MaterielImpl) gsi.get("M10001")).getType() == TypeMateriel.FIXE;
    
  }

  @Test
  public void testLibererMat() {
    //Adresse a = new AdresseImpl(0, null, 0, null, null);
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    //Batiment b = new BatimentImpl("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
//    Salle s = new SalleImpl(0, 0, null, 0, null)
    gsi.creationMateriaux("test", "testNom", "testDescr", 0);
    gsi.fixerMat(new GregorianCalendar(), "S10001", "M10001");
    //gsi.fixerMat(new GregorianCalendar(), "S10001", gsi.affichageMateriaux(new GregorianCalendar(), new GregorianCalendar()));
    gsi.libererMat(new GregorianCalendar(), "S10001", "M10001");
    assert !((SalleImpl) gsi.get("S10001")).getMateriauxFixes().contains("M10001");
    assert ((MaterielImpl) gsi.get("M10001")).getType() == TypeMateriel.MOBILE;
    
  }

  @Test
  public void testRemoveMateriaux() {
    gsi.creationMateriaux("test", "testNom", "testDescr", 0);
    gsi.removeMateriaux("M10001");
    assert ((MaterielImpl)gsi.get("M10001")).getType() == TypeMateriel.A_DETRUIRE;
  }
  
  @Test
  public void testCreationReservation() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
    gsi.creationReservation("S10001", new GregorianCalendar(), new GregorianCalendar(), null);
    assert ((ReservationImpl)gsi.get("R10001")).getIdSalle().equals("S10001");
  }
  
  @Test
  public void testaAffichageReservation() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
    gsi.creationReservation("S10001", new GregorianCalendar(), new GregorianCalendar(), null);
    assert gsi.affichageReservation().containsKey("R10001");
  }
  
  @Test
  public void testRetirerReservation() {
    gsi.creationAdresse(0, null, 0, null, null);
    gsi.creationBatiment("A10001");
    gsi.creationSalle(0, 0, 0, null);
    gsi.ajouterSalleABatiment("S10001", "B10001");
    gsi.creationReservation("S10001", new GregorianCalendar(), new GregorianCalendar(), null);
    gsi.removeReservation("R10001");
    assert !gsi.affichageReservation().containsKey("R10001");
  }



}
