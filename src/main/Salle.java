package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Salle {

  private int noEtage;
  private int noSalle;
  private int idSalle;
  private int noBat;
  private int superficie;
  private String typeSalle;
  private List<Materiel> materiauxFixes;
  private double tarif;

  public Salle(int noEtage, int noSalle, int idSalle, int noBat, int superficie, String typeSalle) {
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

  public int getIdSalle() {
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
