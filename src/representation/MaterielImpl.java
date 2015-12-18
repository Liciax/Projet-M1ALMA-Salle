package representation;

import java.util.Calendar;

public class MaterielImpl implements Materiel {

  private String idSalle;
  private String codeMateriel;
  private String nomMateriel;
  private String descrMateriel;
  private double tarifMateriel;
  private TypeMateriel type;
  private Calendar dateDeChangement;

  public MaterielImpl(String codeMateriel, String nomMateriel,
      String descrMateriel, double tarif) {
    this.idSalle = "";
    this.codeMateriel = codeMateriel;
    this.nomMateriel = nomMateriel;
    this.descrMateriel = descrMateriel;
    this.tarifMateriel = tarif;
    this.type = TypeMateriel.MOBILE;
  }
  
  
  
  public void fixMateriel(Calendar c, String idSalle) {
    this.type = TypeMateriel.FIXE;
    this.dateDeChangement = c;
    this.idSalle = idSalle;
  }

  public void freeMateriel(Calendar c) {
    this.type = TypeMateriel.MOBILE;
    this.dateDeChangement = c;
    this.idSalle = "";
  }



  public String getIdSalle() {
    return idSalle;
  }

  


  public void setIdSalle(String idSalle) {
    this.idSalle = idSalle;
  }



  public String getCodeMateriel() {
    return codeMateriel;
  }



  public String getNomMateriel() {
    return nomMateriel;
  }



  public String getDescrMateriel() {
    return descrMateriel;
  }



  public double getTarifMateriel() {
    return tarifMateriel;
  }



  public Calendar getDateDeChangement() {
    return dateDeChangement;
  }
  
  public TypeMateriel getType() {
    return type;
  }
  
}
