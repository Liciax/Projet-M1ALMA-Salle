package representation;

import java.util.ArrayList;
import java.util.List;

public class SalleImpl implements Salle {


  private String idSalle;
  private int noEtage;
  private int noSalle;
  private int noBat;
  private int superficie;
  private String typeSalle;
  private List<Materiel> materiauxFixes;
  private double tarif;

  public SalleImpl(int noEtage, int noSalle, String idSalle, int noBat, int superficie, String typeSalle) {
    this.noEtage = noEtage;
    this.noSalle = noSalle;
    this.idSalle = idSalle;
    this.noBat = noBat;
    this.superficie = superficie;
    this.typeSalle = typeSalle;
    this.materiauxFixes = new ArrayList<Materiel>();
    // a calculer
    // this.tarif = tarif;
  }

  public int getNoEtage() {
    return noEtage;
  }

  public int getNoSalle() {
    return noSalle;
  }

  public String getIdSalle() {
    return idSalle;
  }

  public int getNoBat() {
    return noBat;
  }

  public int getSuperficie() {
    return superficie;
  }

  public String getTypeSalle() {
    return typeSalle;
  }

  public List<Materiel> getMateriauxFixes() {
    return materiauxFixes;
  }

  public double getTarif() {
    return tarif;
  }


}
