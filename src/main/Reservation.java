package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Reservation {

  private Salle salleReservee;
  private Calendar dateDebutReserve;
  private Calendar dateFinReserve;
  private int idClient;
  private String idReserve;
  private DureeReservation dureeReservation;
  private List<Materiel> materiauxMobiles;

  public Reservation(Salle salleReservee, Calendar dateDebutReserve, Calendar dateFinReserve,
      int idClient, DureeReservation dureeReservation) {
    this.salleReservee = salleReservee;
    this.dateDebutReserve = dateDebutReserve;
    this.dateFinReserve = dateFinReserve;
    this.idClient = idClient;
    this.idReserve =
        Integer.toString(dateDebutReserve.get(Calendar.DAY_OF_YEAR))
            + Integer.toString(dateDebutReserve.get(Calendar.YEAR)) + Integer.toString(idClient);
    this.dureeReservation = dureeReservation;
    this.materiauxMobiles = new ArrayList<Materiel>();


  }


}
