package sopra.projet.freebet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Login")
public class Login {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;

	@Column(name = "pseudo", length = 50)
	private String pseudo;

	@Column(name = "mail", length = 100)
	private String mail;

	@Column(name = "password", length = 50)
	private String motDePasse;

	@OneToOne(mappedBy = "login")
	private Admin admin;

	@OneToOne(mappedBy = "login")
	private Bettor bettor;

	public Login() {
		super();
	}

	public Login(Long id, int version, String pseudo, String mail, String motdepasse) {
		super();
		this.id = id;
		this.version = version;
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motdepasse;
	}
	
	

	public Login(String pseudo, String mail, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motDePasse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotdepasse() {
		return motDePasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motDePasse = motdepasse;
	}

}
