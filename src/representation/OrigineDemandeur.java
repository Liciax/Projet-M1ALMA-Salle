package representation;

public class OrigineDemandeur {

  private float tauxOrigine;
  private String origineDemandeur; // RESIDENT, NON_RESIDENT

  public OrigineDemandeur(float tauxOrigine, String origineDemandeur) {
    this.tauxOrigine = tauxOrigine;
    this.origineDemandeur = origineDemandeur;
  }

  public float getTauxOrigine() {
    return tauxOrigine;
  }

  public String getOrigineDemandeur() {
    return origineDemandeur;
  }

}
