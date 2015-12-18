package representation;

import java.util.ArrayList;
import java.util.List;

public class BatimentImpl implements Batiment {

  private String idAdresse;
  private List<String> salles;

  public BatimentImpl(String idAdresse) {
    this.idAdresse = idAdresse;
    this.salles = new ArrayList<String>();
  }
  
  public BatimentImpl(String idAdresse, List<String> list) {
    this.idAdresse = idAdresse;
    this.salles = list;
  }

  public String getAdresseBat() {
    return idAdresse;
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
