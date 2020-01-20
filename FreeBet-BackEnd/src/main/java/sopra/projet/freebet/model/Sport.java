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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Sport")
public class Sport {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "name")
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeSport sportType;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Duree duree;
	@OneToMany(mappedBy = "sport_game")
	@JsonView(Views.ViewSportDetail.class)
	List <Game> games = new ArrayList<Game>();
	
	@OneToMany(mappedBy = "sport_opponent")
	@JsonView(Views.ViewSport.class)
	List<Opponent> opponentSport = new ArrayList<Opponent>();

	public Sport() {
		super();
	}

	public Sport(String nom, TypeSport sportType) {
		super();
		this.nom = nom;
		this.sportType = sportType;
	}

		
	
	public Sport(String nom, TypeSport sportType, Duree duree) {
		super();
		this.nom = nom;
		this.sportType = sportType;
		this.duree = duree;
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

	public Duree getDuree() {
		return duree;
	}

	public void setDuree(Duree duree) {
		this.duree = duree;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<Opponent> getOpponentSport() {
		return opponentSport;
	}

	public void setOpponentSport(List<Opponent> opponentSport) {
		this.opponentSport = opponentSport;
	}

}