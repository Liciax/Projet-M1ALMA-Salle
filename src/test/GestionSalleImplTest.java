package test;

import static org.junit.Assert.*;

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
    assert gsi.getBdd().containsValue(a);
  }

  @Test
  public void testAffichageAdresse() {
  }

  @Test
  public void testRemoveAdresse() {
    fail("Not yet implemented");
  }

  @Test
  public void testCreationBatiment() {
    fail("Not yet implemented");
  }

  @Test
  public void testAffichageBatiment() {
    fail("Not yet implemented");
  }

  @Test
  public void testRemoveBatiment() {
    fail("Not yet implemented");
  }

  @Test
  public void testAjouterSalleABatiment() {
    fail("Not yet implemented");
  }

  @Test
  public void testRetirerSalleABatiment() {
    fail("Not yet implemented");
  }

  @Test
  public void testCreationSalle() {
    fail("Not yet implemented");
  }

  @Test
  public void testAffichageSalle() {
    fail("Not yet implemented");
  }

  @Test
  public void testAjouterMaterielASalle() {
    fail("Not yet implemented");
  }

  @Test
  public void testRetirerMaterielASalle() {
    fail("Not yet implemented");
  }

  @Test
  public void testRemoveSalle() {
    fail("Not yet implemented");
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

}
