package representation;

public class Manifestation {

  private float tauxManifestation;
  private String manifestation; // REUNION, BANQUET, SPECTACLE

  public Manifestation(float tauxManifestation, String manifestation) {
    this.tauxManifestation = tauxManifestation;
    this.manifestation = manifestation;
  }

  public float getTauxManifestation() {
    return tauxManifestation;
  }

  public String getManifestation() {
    return manifestation;
  }

}
