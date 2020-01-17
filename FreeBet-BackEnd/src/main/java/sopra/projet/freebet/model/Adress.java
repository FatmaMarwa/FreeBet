package sopra.projet.freebet.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adress {

	@Column(name = "street", length = 100)
	@JsonView(Views.ViewCommon.class)
	private String rue;

	@Column(name = "city", length = 50)
	@JsonView(Views.ViewCommon.class)
	private String ville;

	@Column(name = "postal_code", length = 50)
	@JsonView(Views.ViewCommon.class)
	private String codePostal;

	@Column(name = "country", length = 100)
	@JsonView(Views.ViewCommon.class)
	private String pays;

	public Adress() {
		super();
	}

	public Adress(String rue, String ville, String codePostal, String pays) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
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

	public void setCodepostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}
