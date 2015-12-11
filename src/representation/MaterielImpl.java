package representation;

public class MaterielImpl implements Materiel{

  private String idSalle;
  private String codeMateriel;
  private String nomMateriel;
  private String descrMateriel;
  private double tarifMateriel;

  public MaterielImpl(String idSalle, String codeMateriel, String nomMateriel, String descrMateriel) {
    this.idSalle = idSalle;
    this.codeMateriel = codeMateriel;
    this.nomMateriel = nomMateriel;
    this.descrMateriel = descrMateriel;
    // a calculer
    this.tarifMateriel = 0;
  }

}
