package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import representation.Adresse;
import representation.AdresseImpl;
import representation.Batiment;
import representation.GestionSalleImpl;
import representation.Salle;
import representation.SalleImpl;

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
  
  //--------------------------------------------------------------------//
  //                     pour les Adresses                              //
  //--------------------------------------------------------------------// 

  public static boolean creationAdresse() {
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
    return instance.creationAdresse(noRue, rue, codePostal, ville, complement);
  }
  
  public static List<String> affichageAdresses()
  {
    HashMap<String,Adresse> liste = instance.affichageAdresse();
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
  
  public static boolean retirerAdresse() {
    System.out.println("liste des rues: ");
    List<String> liste = affichageAdresses();
    Scanner sc = new Scanner(System.in);
    System.out.print("numero? : ");
    int number = sc.nextInt();
    return instance.removeAdresse(liste.get(number));
  }
  
  //--------------------------------------------------------------------//
  //                       pour les Salles                              //
  //--------------------------------------------------------------------// 
  
  public static boolean creationSalle() {
    //(int noEtage, int noSalle, int superficie,
      //  String typeSalle)
    Scanner sc = new Scanner(System.in);
    System.out.print("no d'etage? : ");
    int noEtage = sc.nextInt();
    System.out.print("no de salle? : ");
    int noSalle = sc.nextInt();
    System.out.print("superficie? : ");
    int superficie = sc.nextInt();
    System.out.print("type de la salle? : ");
    String typeSalle = sc.next();
    return instance.creationSalle(noEtage, noSalle, superficie, typeSalle);
  }
  
  public static List<String> affichageSalles()
  {
    HashMap<String,Salle> liste = instance.affichageSalle();
    List<String> resultat = new ArrayList<String>();
    int i = 0;
    for(Entry<String, Salle> entree :liste.entrySet()) {
      if(entree.getValue() != null) {
        System.out.println(i + ": " + ((SalleImpl) entree.getValue()).getNoSalle());
        System.out.println(((SalleImpl) entree.getValue()).getNoEtage());
        System.out.println(((SalleImpl) entree.getValue()).getIdBat());
        i++;
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }
  
//  public static boolean retirerSalle() {
//    System.out.println("liste des rues: ");
//    List<String> liste = affichageSalles();
//    Scanner sc = new Scanner(System.in);
//    System.out.print("numero? : ");
//    int number = sc.nextInt();
//    return instance.removeSalle(liste.get(number));
//  }
  
  //--------------------------------------------------------------------//
  //                      pour les Batiments                            //
  //--------------------------------------------------------------------// 
  
  public static boolean creationBatiment() {
    List<String> adr = affichageAdresses();
    Scanner sc = new Scanner(System.in);
    System.out.print("Construire le Batiment a quelle adresse? : ");
    int adresseChoisie = sc.nextInt();
    return instance.creationBatiment(adr.get(adresseChoisie));
  }
  
//  public static boolean affichageBatiment() {
//    //Todo
//  }
  

  public static void main(String[] args) {
    creationAdresse();
    affichageAdresses();
    creationAdresse();
    retirerAdresse();
    retirerAdresse();
    affichageAdresses();
  }

}
