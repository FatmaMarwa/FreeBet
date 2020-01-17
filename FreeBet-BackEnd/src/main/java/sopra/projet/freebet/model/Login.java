package sopra.projet.freebet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Login")
public class Login {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;

	@Column(name = "pseudo", length = 50)
	@JsonView(Views.ViewCommon.class)
	private String pseudo;

	@Column(name = "mail", length = 100)
	@JsonView(Views.ViewCommon.class)
	private String mail;

	@Column(name = "password", length = 50)
	@JsonView(Views.ViewCommon.class)
	private String motDePasse;

	@OneToOne(mappedBy = "login")
	@JsonView(Views.ViewLogin.class)
	private Admin admin;

	@OneToOne(mappedBy = "login")
	@JsonView(Views.ViewLogin.class)
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

	public Login(String pseudo, String mail, String motdepasse) {
		super();
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motdepasse;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motdepasse) {
		this.motDePasse = motdepasse;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Bettor getBettor() {
		return bettor;
	}

	public void setBettor(Bettor bettor) {
		this.bettor = bettor;
	}

}
