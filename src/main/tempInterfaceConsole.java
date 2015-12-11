package main;

import java.util.Scanner;

import representation.GestionSalleImpl;

public class tempInterfaceConsole implements InterfaceGraphique {

  private static GestionSalleImpl GSI;
  @Override
  public void ReservationSalle() {
    // TODO Auto-generated method stub

  }

  @Override
  public void AjoutSalle() {
    System.out.println("rentrez les infos sur la salle:");
    System.out.println("rentrez les infos sur la salle:");

  }
  
  public static boolean testAddAdresse() {
    
    Scanner sc = new Scanner(System.in);
    int noRue = sc.nextInt();
    String rue = sc.next();
    int codePostal = sc.nextInt();
    String ville= sc.next();
    String complement= sc.next();
    return GSI.testAdresse(noRue, rue, codePostal, ville, complement);
    
  }

  public static void main(String[] args) {
    testAddAdresse();


  }

}
