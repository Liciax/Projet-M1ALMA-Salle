/**
 * 
 */
package representation;

import java.util.Calendar;
import java.util.List;

import BDD.BaseDeDonnee;

/**
 * @author Lenny Lucas but: implemente la construction de tout les objets de la BDD ainsi que toutes
 *         les fonctions. on suppose que l'interface a deja trouvé les id des elements.
 */
public class GestionSalleImpl implements GestionSalle {


  private static final GestionSalleImpl instance = new GestionSalleImpl(); // une et une seule gestion de salle
  private BaseDeDonnee bdd;
  private FactorySalle factSalle;

  
  private GestionSalleImpl() {
    this.bdd = new BaseDeDonnee();
    this.factSalle = new FactorySalleImpl();
  }

}
