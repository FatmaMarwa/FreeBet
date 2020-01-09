package sopra.projet.freebet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Opponent")
public class Opponent {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;

	@Column(name = "name")
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "championship")
	private ChampionShip championnat;

	@ManyToOne
	@JoinColumn(name = "SPORT_NAME")
	private Sport sport_opponent;

	@ManyToOne
	@JoinColumn(name = "GAME_ID")
	private Game game_opponent;

	public Opponent() {
		super();
	}

	public Opponent(String nom, ChampionShip championnat) {
		super();
		this.nom = nom;
		this.championnat = championnat;
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

	public ChampionShip getChampionnat() {
		return championnat;
	}

	public void setChampionnat(ChampionShip championnat) {
		this.championnat = championnat;
	}

	public Sport getSport_opponent() {
		return sport_opponent;
	}

	public void setSport_opponent(Sport sport_opponent) {
		this.sport_opponent = sport_opponent;
	}

	public Game getGame_opponent() {
		return game_opponent;
	}

	public void setGame_opponent(Game game_opponent) {
		this.game_opponent = game_opponent;
	}

}
