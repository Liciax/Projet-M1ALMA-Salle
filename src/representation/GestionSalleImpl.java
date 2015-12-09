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


  private static final GestionSalleImpl instance = new GestionSalleImpl();
  private BaseDeDonnee bdd;



  /**
   * @param bdd
   */
  private GestionSalleImpl() {
    this.bdd = new BaseDeDonnee();
  }

  @Override
  public String createAdresse(int noRue, String rue, int codePostal, String ville, String complement) {
    Adresse adr = new Adresse(noRue, rue, codePostal, ville, complement);
    return bdd.put(adr);
  }

  @Override
  public String createBatiment(String idBat, Adresse adresseBat, List<String> listIdSalles) {
    Batiment bat = new Batiment(idBat, adresseBat, listIdSalles);
    return bdd.put(bat);
  }//liste nulle au depart? retirer idBat? changer adresseBat en string (id d'adresse)?

  @Override
  public String createDemandeur(String idDemandeur, String nomDemandeur,
      OrigineDemandeur origineDemandeur, TitreDemandeur titreDemandeur, String idAdresseDemandeur) {
    Demandeur dem =
        new Demandeur(idDemandeur, nomDemandeur, origineDemandeur, titreDemandeur,
            idAdresseDemandeur);
    return bdd.put(dem);
  }//retirer idDemandeur?

  @Override
  public String createMateriel(String idSalle, String codeMateriel, String nomMateriel,
      String descrMateriel) {
    Materiel mat = new Materiel(idSalle, codeMateriel, nomMateriel, descrMateriel);
    return bdd.put(mat);
  }

  @Override
  public String createReservation(String salleReservee, Calendar dateDebutReserve,
      Calendar dateFinReserve, String idClient, DureeReservation dureeReservation) {
    Reservation res = new Reservation(salleReservee, dateDebutReserve, dateFinReserve, idClient, dureeReservation);
    return bdd.put(res);
  }

  @Override
  public String createSalle(int noEtage, int noSalle, String idSalle, int noBat, int superficie,
      String typeSalle) {
    Salle sal = new Salle(noEtage, noSalle, idSalle, noBat, superficie, typeSalle);
    return bdd.put(sal);
  }//retirer idSalle, changer noBat en idBat (string)?

  


}
