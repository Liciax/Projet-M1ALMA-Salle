package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import representation.Adresse;
import representation.AdresseImpl;
import representation.GestionSalleImpl;

public class tempInterfaceConsole implements InterfaceGraphique {


  private static final GestionSalleImpl instance = new GestionSalleImpl();

  private tempInterfaceConsole() {

  }

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
    System.out.print("no de rue? : ");
    int noRue = sc.nextInt();
    System.out.print("nom de la rue? : ");
    String rue = sc.next();
    System.out.print("code postal? : ");
    int codePostal = sc.nextInt();
    System.out.print("nom de la ville? : ");
    String ville = sc.next();
    System.out.print("un complement? : ");
    String complement = sc.next();
    return instance.testAdresse(noRue, rue, codePostal, ville, complement);
  }
  
  public static List<String> testAffAdresses()
  {
    HashMap<String,Adresse> liste = instance.testAffAdresse();
    List<String> resultat = new ArrayList<String>();
    int i = 0;
    for(Entry<String, Adresse> entree :liste.entrySet()) {
      if(entree.getValue() != null) {
        System.out.println(i + ": " + ((AdresseImpl) entree.getValue()).getVille());
        i++;
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }
  
  public static boolean testRemoveAdresse() {
    System.out.println("liste des rues: ");
    List<String> liste = testAffAdresses();
    Scanner sc = new Scanner(System.in);
    System.out.print("numero? : ");
    int number = sc.nextInt();
    return instance.removeAdresse(liste.get(number));
  }

  public static void main(String[] args) {
    testAddAdresse();
    testAffAdresses();
    testAddAdresse();
    testRemoveAdresse();
    testRemoveAdresse();
    testAffAdresses();

  }

}
