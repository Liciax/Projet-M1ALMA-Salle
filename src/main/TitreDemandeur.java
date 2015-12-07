package main;

public class TitreDemandeur {

  private float tauxtitre;
  private String titreDemandeur; // PARTICULIER, ASSOCIATION, ENTREPRISE

  public TitreDemandeur(float tauxtitre, String titreDemandeur) {
    this.tauxtitre = tauxtitre;
    this.titreDemandeur = titreDemandeur;
  }

  public float getTauxtitre() {
    return tauxtitre;
  }

  public String getTitreDemandeur() {
    return titreDemandeur;
  }

}
