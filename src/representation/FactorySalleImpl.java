package representation;

import java.util.Calendar;
import java.util.List;

public class FactorySalleImpl implements FactorySalle {

  public Adresse createAdresse(int noRue, String rue, int codePostal, String ville,
      String complement) {
    Adresse adr = new AdresseImpl(noRue, rue, codePostal, ville, complement);
    return adr;
  }

  public Batiment createBatiment(String adresseBat) {
    Batiment bat = new BatimentImpl(adresseBat);
    return bat;
  }

//  public Batiment createBatiment(String adresseBat, List<String> list) {
//    Batiment bat = new BatimentImpl(adresseBat,list);
//    return bat;
//  }

  public Demandeur createDemandeur(String idDemandeur, String nomDemandeur,
      OrigineDemandeur origineDemandeur, TitreDemandeur titreDemandeur, String idAdresseDemandeur) {
    Demandeur dem =
        new DemandeurImpl(idDemandeur, nomDemandeur, origineDemandeur, titreDemandeur,
            idAdresseDemandeur);
    return dem;
  }// retirer idDemandeur?


  public Materiel createMateriel(String idSalle, String codeMateriel, String nomMateriel,
      String descrMateriel) {
    Materiel mat = new MaterielImpl(idSalle, codeMateriel, nomMateriel, descrMateriel);
    return mat;
  }


  public Reservation createReservation(String salleReservee, Calendar dateDebutReserve,
      Calendar dateFinReserve, String idClient, DureeReservation dureeReservation) {
    Reservation res =
        new ReservationImpl(salleReservee, dateDebutReserve, dateFinReserve, idClient,
            dureeReservation);
    return res;
  }


  public Salle createSalle(int noEtage, int noSalle, String idBat, int superficie, String typeSalle) {
    Salle sal = new SalleImpl(noEtage, noSalle, idBat, superficie, typeSalle);
    return sal;
  }// retirer idSalle, changer noBat en idBat (string)?


}
