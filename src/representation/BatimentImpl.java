package representation;

import java.util.List;

public class BatimentImpl implements Batiment {

  private String idBat;
  private Adresse adresseBat;
  private List<String> salles;

  public BatimentImpl(String idBat, Adresse adresseBat, List<String> salles) {
    this.idBat = idBat;
    this.adresseBat = adresseBat;
    this.salles = salles;
  }

  public String getIdBat() {
    return idBat;
  }

  public Adresse getAdresseBat() {
    return adresseBat;
  }

  public List<String> getSalles() {
    return salles;
  }
}
