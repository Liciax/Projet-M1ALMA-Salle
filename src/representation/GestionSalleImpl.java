/**
 * 
 */
package representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import BDD.BaseDeDonnee;

/**
 * @author Lenny Lucas but: implemente la construction de tout les objets de la BDD ainsi que toutes
 *         les fonctions. on suppose que l'interface a deja trouvé les id des elements.
 */
public class GestionSalleImpl implements GestionSalle {


  private BaseDeDonnee bdd;
  private FactorySalle factSalle;
  private List<String> listeDesClefs;


  public GestionSalleImpl() {
    this.bdd = new BaseDeDonnee();
    this.factSalle = new FactorySalleImpl();
    this.listeDesClefs = new ArrayList<String>();
  }

  public boolean testAdresse(int noRue, String rue, int codePostal, String ville, String complement) {

    Adresse a = factSalle.createAdresse(noRue, rue, codePostal, ville, complement);
    String key = bdd.put(a);
    listeDesClefs.add(key);
    return true;
  }
  
  public HashMap<String,Adresse> testAffAdresse() {
    HashMap<String,Adresse> liste = new HashMap<String, Adresse>(); 
    for(String s:listeDesClefs) {
      if (s.charAt(0)=='A') {
        liste.put(s, (Adresse) bdd.get(s));
      }
    }
    return liste;
  }

  public boolean removeAdresse(String idAdr) {
    return (bdd.remove(idAdr) || listeDesClefs.remove(idAdr));
  }
}
