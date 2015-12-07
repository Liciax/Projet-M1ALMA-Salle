/**
 * 
 */
package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lenny Lucas
 *
 */
public class BaseDeDonnée {

  private Map<String,Reservation> tableDeReservation;
  private Map<String,Batiment> tableDeBatiment;
  private Map<String,Salle> tableDeSalle;
  private Map<String,Demandeur> tableDeDemandeur;
  private Map<String,Materiel> tableDeMateriel;
  
  /**
   * @param tableDeReservation
   * @param tableDeBatiment
   * @param tableDeSalle
   * @param tableDeDemandeur
   * @param tableDeMateriel
   */
  public BaseDeDonnée() {
    this.tableDeReservation = new HashMap<String,Reservation>();
    this.tableDeBatiment = new HashMap<String,Batiment>();
    this.tableDeSalle = new HashMap<String,Salle>();
    this.tableDeDemandeur = new HashMap<String,Demandeur>();
    this.tableDeMateriel = new HashMap<String,Materiel>();
  }
  
  
  
  
  
}
