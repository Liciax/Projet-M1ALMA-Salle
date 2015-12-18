package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import representation.Adresse;
import representation.AdresseImpl;
import representation.Batiment;
import representation.BatimentImpl;
import representation.GestionSalleImpl;
import representation.Salle;
import representation.SalleImpl;

public class tempInterfaceConsole implements InterfaceGraphique {


  private static final GestionSalleImpl instance = new GestionSalleImpl();

  private tempInterfaceConsole() {}

  @Override
  public void ReservationSalle() {
    // TODO Auto-generated method stub

  }

  @Override
  public void AjoutSalle() {
    System.out.println("rentrez les infos sur la salle:");
    System.out.println("rentrez les infos sur la salle:");

  }

  // --------------------------------------------------------------------//
  // pour les Adresses //
  // --------------------------------------------------------------------//

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
  
  public static void affichageAdresseUnique(AdresseImpl entree) {
    System.out.println("adresse: " + entree.getNoRue());
    System.out.println("rue " + entree.getRue());
    System.out.println("code postal: " + entree.getCodePostal());
    System.out.println("ville: " + entree.getVille());
    System.out.println("complement d'adresse: " + entree.getComplement());
  }

  public static List<String> affichageAdresses() {
    HashMap<String, Adresse> liste = instance.affichageAdresse();
    List<String> resultat = new ArrayList<String>();
    int i = 0;
    for (Entry<String, Adresse> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        System.out.print(i + ": ");
        affichageAdresseUnique((AdresseImpl) entree.getValue());
        System.out.println("####################");
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

  // --------------------------------------------------------------------//
  // pour les Salles //
  // --------------------------------------------------------------------//

  public static String creationSalle() {
    // (int noEtage, int noSalle, int superficie,
    // String typeSalle)
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

  public static void affichageSalleUnique(SalleImpl entree) {
    //etoffer affichage: affichage uniquement a partir de son batiment? 
    //impossible d'avoir une salle sans batiment...
    System.out.println("id du batiment: " + entree.getIdBat());//?
    System.out.println("cette Salle est sur l'etage " + entree.getNoEtage());
    System.out.println("au numero " + entree.getNoSalle());
    System.out.println("il s'agit d'une Salle de type " + entree.getTypeSalle());
    System.out.println("de taille " + entree.getSuperficie());
  }
  
  public static List<String> affichageSalles() {
    HashMap<String, Salle> liste = instance.affichageSalle();
    List<String> resultat = new ArrayList<String>();
    int i = 0;
    for (Entry<String, Salle> entree : liste.entrySet()) {
      if (entree.getValue() != null) {
        System.out.println(i + ": ");
        affichageSalleUnique((SalleImpl)entree.getValue());
        System.out.println("####################");
        i++;
        resultat.add(entree.getKey());
      }
    }
    return resultat;
  }

  // public static boolean retirerSalle() {
  // System.out.println("liste des rues: ");
  // List<String> liste = affichageSalles();
  // Scanner sc = new Scanner(System.in);
  // System.out.print("numero? : ");
  // int number = sc.nextInt();
  // return instance.removeSalle(liste.get(number));
  // }

  // --------------------------------------------------------------------//
  // pour les Batiments //
  // --------------------------------------------------------------------//

  public static boolean creationBatiment() {
    List<String> adr = affichageAdresses();
    Scanner sc = new Scanner(System.in);
    System.out.print("Construire le Batiment a quelle adresse? : ");
    int adresseChoisie = sc.nextInt();
    String keyBat = instance.creationBatiment(adr.get(adresseChoisie));
    String keySalle;
    boolean result = true;
    System.out.println("ajouter une autre Salle? o/n");
    String rep = sc.next();
    while(rep.charAt(0) == 'o') {
      keySalle = creationSalle();
      result = result && instance.ajouterSallesABatiment(keySalle, keyBat);
      System.out.println("ajouter une autre Salle? o/n");
      rep = sc.next();
    }
    return result;
  }
  
  

  public static void affichageBatimentUnique(BatimentImpl entree) {
    affichageAdresseUnique((AdresseImpl)instance.get(entree.getAdresseBat()));
    for(String s:entree.getSalles()) {
      System.out.println("%%%%%%%%%%%%%%%%%%");
      affichageSalleUnique((SalleImpl) instance.get(s));
      System.out.println("%%%%%%%%%%%%%%%%%%");
    }
    
  }
  
  public static List<String> affichageBatiments() {
      HashMap<String,Batiment> liste = instance.affichageBatiment();
      List<String> resultat = new ArrayList<String>();
      int i = 0;
      for(Entry<String, Batiment> entree :liste.entrySet()) {
        if(entree.getValue() != null) {
          System.out.println(i + ": ");
          affichageBatimentUnique((BatimentImpl)entree.getValue());
          System.out.println("####################");
          i++;
          resultat.add(entree.getKey());
        }
      }
      return resultat;
    }


//((BatimentImpl) entree.getValue())
    
  public static void main(String[] args) {
    creationAdresse();
    affichageAdresses();
    creationBatiment();
    affichageBatiments();
    
  }

}
