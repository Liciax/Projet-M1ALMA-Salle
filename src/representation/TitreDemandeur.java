package representation;


public class TitreDemandeur {

  private float tauxTitre;
  private String titreDemandeur; // PARTICULIER, ASSOCIATION, ENTREPRISE

  public TitreDemandeur(float tauxtitre, String titreDemandeur) {
    this.tauxTitre = tauxtitre;
    this.titreDemandeur = titreDemandeur;
  }

  public float getTauxtitre() {
    return tauxTitre;
  }

  public String getTitreDemandeur() {
    return titreDemandeur;
  }

}
