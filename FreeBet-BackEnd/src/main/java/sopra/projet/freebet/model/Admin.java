package sopra.projet.freebet.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;

	@Column(name = "lastname", length = 100)
	@JsonView(Views.ViewCommon.class)
	private String nom;

	@Column(name = "firstname", length = 100)
	@JsonView(Views.ViewCommon.class)
	private String prenom;

	@Embedded
	@Column(name = "adress")
	@JsonView(Views.ViewCommon.class)
	private Adress adress;

	@OneToOne
	@JsonView(Views.ViewAdminDetail.class)
	private Login login;

	public Admin() {
		super();
	}

	public Admin(Long id, int version, String nom, String prenom, Adress adress, Login login) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.login = login;
	}

	public Admin(String nom, String prenom, Adress adress, Login login) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.login = login;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
