package main;

public class DureeReservation {

  private float tauxDuree;
  private String dureeReservation; // SOIREE, DEMI_JOURNEE_MATIN, DEMI_JOURNEE_APREM, JOURNEE

  public DureeReservation(float tauxDuree, String dureeReservation) {
    this.tauxDuree = tauxDuree;
    this.dureeReservation = dureeReservation;
  }

  public float getTauxDuree() {
    return tauxDuree;
  }

  public String getDureeReservation() {
    return dureeReservation;
  }

}
