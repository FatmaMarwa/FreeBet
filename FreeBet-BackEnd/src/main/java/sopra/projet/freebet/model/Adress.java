package sopra.projet.freebet.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adress {

	@Column(name = "street", length = 100)
	private String rue;

	@Column(name = "city", length = 50)
	private String ville;

	@Column(name = "postal_code", length = 50)
	private String codePostal;

	@Column(name = "country", length = 100)
	private String pays;

	public Adress() {
		super();
	}

	public Adress(String rue, String ville, String codepostal, String pays) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codepostal;
		this.pays = pays;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codePostal;
	}

	public void setCodepostal(String codepostal) {
		this.codePostal = codepostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
