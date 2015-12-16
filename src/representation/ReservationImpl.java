package representation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReservationImpl implements Reservation {

  private String idSalle;
  private String idClient;
  private String idReserve;
  private Calendar heureDebutReserve;
  private Calendar heureFinReserve;
  private DureeReservation dureeReservation;
  private List<Materiel> materiauxMobiles;

  public ReservationImpl(String salleReservee, Calendar dateDebutReserve, Calendar dateFinReserve,
      String idClient, DureeReservation dureeReservation) {
    this.idSalle = salleReservee;
    this.heureDebutReserve = dateDebutReserve;
    this.heureFinReserve = dateFinReserve; // a calculer a l'aide de durée
    this.idClient = idClient;
    this.idReserve =
        Integer.toString(heureDebutReserve.get(Calendar.HOUR_OF_DAY))
            + Integer.toString(heureDebutReserve.get(Calendar.HOUR_OF_DAY)) + idClient;
    this.dureeReservation = dureeReservation;
    this.materiauxMobiles = new ArrayList<Materiel>();


  }

  public String getIdSalle() {
    return idSalle;
  }

  public String getIdClient() {
    return idClient;
  }

  public String getIdReserve() {
    return idReserve;
  }

  public Calendar getHeureDebutReserve() {
    return heureDebutReserve;
  }

  public Calendar getHeureFinReserve() {
    return heureFinReserve;
  }

  public DureeReservation getDureeReservation() {
    return dureeReservation;
  }

  public List<Materiel> getMateriauxMobiles() {
    return materiauxMobiles;
  }


}