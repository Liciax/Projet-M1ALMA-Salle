package principal;

public class Adresse {

	private int noRue;
	private String rue;
	private int codePostal;
	private String ville;
	private String complement;
	
	public Adresse(int noRue, String rue, int codePostal, String ville, String complement) {
		this.noRue = noRue;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.complement = complement;
	}

	public int getNoRue() {
		return noRue;
	}

	public String getRue() {
		return rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getComplement() {
		return complement;
	}
	
}
