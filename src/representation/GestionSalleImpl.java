/**
 * 
 */
package representation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import BDD.BaseDeDonnee;

/**
 * @author Lenny Lucas but: implemente la construction de tout les objets de la BDD ainsi que toutes
 *         les fonctions. on suppose que l'interface a deja trouvé les id des elements.
 */
public class GestionSalleImpl implements GestionSalle {


  private static final GestionSalleImpl instance = new GestionSalleImpl(); // une et une seule
                                                                           // gestion de salle
  private BaseDeDonnee bdd;
  private FactorySalle factSalle;
  private List<String> listeDesClefs;


  private GestionSalleImpl() {
    this.bdd = new BaseDeDonnee();
    this.factSalle = new FactorySalleImpl();
    this.listeDesClefs = new ArrayList<String>();
  }

  public boolean testAdresse(int noRue, String rue, int codePostal, String ville, String complement) {

    Adresse a = factSalle.createAdresse(noRue, rue, codePostal, ville, complement);
    String key = bdd.put(a);
    listeDesClefs.add(key);
    //vu que c'est un test, on va verif que sa a marche. tout ce qui est apres est a virer
    System.out.println(key);
    System.out.println(((AdresseImpl) a).getVille());
    AdresseImpl b = (AdresseImpl)bdd.get(key);
    System.out.println(b.getVille());
    return true;
  }

}
