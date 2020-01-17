package sopra.projet.freebet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Sport")
public class Sport {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "name")
	private String nom;
	@Enumerated(EnumType.STRING)
	private TypeSport sportType;
	@Enumerated(EnumType.STRING)
	private Duree duree;
	@OneToOne(mappedBy = "sport")
	private Game game;

	@OneToMany(mappedBy = "sport_opponent")
	List<Opponent> opponentSport = new ArrayList<Opponent>();

	public Sport() {
		super();
	}

	public Sport(String nom, TypeSport sportType) {
		super();
		this.nom = nom;
		this.sportType = sportType;
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

	public TypeSport getSportType() {
		return sportType;
	}

	public void setSportType(TypeSport sportType) {
		this.sportType = sportType;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Opponent> getOpponentSport() {
		return opponentSport;
	}

	public void setOpponentSport(List<Opponent> opponentSport) {
		this.opponentSport = opponentSport;
	}

	public Duree getDuree() {
		return duree;
	}

	public void setDuree(Duree duree) {
		this.duree = duree;
	}

}
