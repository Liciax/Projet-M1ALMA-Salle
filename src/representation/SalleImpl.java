package representation;

import java.util.ArrayList;
import java.util.List;

public class SalleImpl implements Salle {


  private int noEtage;
  private int noSalle;
  private String idBat;
  private int superficie;
  private String typeSalle;
  private List<Materiel> materiauxFixes;
  private double tarif;

  public SalleImpl(int noEtage, int noSalle, String idBat, int superficie, String typeSalle) {
    this.noEtage = noEtage;
    this.noSalle = noSalle;
    this.idBat = idBat;
    this.superficie = superficie;
    this.typeSalle = typeSalle;
    this.materiauxFixes = new ArrayList<Materiel>();
    // a calculer
    // this.tarif = tarif;
  }

  public String getIdBat() {
    return idBat;
  }

  public void setIdBat(String idBat) {
    this.idBat = idBat;
  }


  public int getNoEtage() {
    return noEtage;
  }

  public int getNoSalle() {
    return noSalle;
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
