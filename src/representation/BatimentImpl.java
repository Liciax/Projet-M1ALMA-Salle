package representation;

import java.util.ArrayList;
import java.util.List;

public class BatimentImpl implements Batiment {

  private String adresseBat;
  private List<String> salles;

  public BatimentImpl(String adresseBat) {
    this.adresseBat = adresseBat;
    this.salles = new ArrayList<String>();
  }

  public String getAdresseBat() {
    return adresseBat;
  }

  public List<String> getSalles() {
    return salles;
  }
  
  public void addSalle(String idSalle) {
    salles.add(idSalle);
  }
  
  public void removeSalle(String idSalle) {
    salles.remove(idSalle);
  }
}
