package sopra.projet.freebet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Game")
public class Game {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_game")
	private Date gameDate;
	@Column(name = "odds1")
	private Float cote1;
	@Column(name = "oddsN")
	private Float coteN;
	@Column(name = "odds2")
	private Float cote2;
	@Column(name = "game_done")
	private Boolean resultatMatch;

	@ManyToMany(mappedBy = "games")
	List<Bet> bets_game = new ArrayList<Bet>();

	@OneToOne
	private Sport sport;

	@OneToMany(mappedBy = "game_opponent")
	List<Opponent> opponentGame = new ArrayList<Opponent>();

	@OneToMany(mappedBy = "game_stat")
	List<Statistical> stat = new ArrayList<Statistical>();

	public Game() {
		super();
	}

	public Game(Date gameDate, Float cote1, Float coteN, Float cote2, boolean resultatMatch) {
		super();
		this.gameDate = gameDate;
		this.cote1 = cote1;
		this.coteN = coteN;
		this.cote2 = cote2;
		this.resultatMatch = resultatMatch;
	}

	public Game(Date gameDate, Float cote1, Float coteN, Float cote2, Boolean resultatMatch, List<Statistical> stat) {
		super();
		this.gameDate = gameDate;
		this.cote1 = cote1;
		this.coteN = coteN;
		this.cote2 = cote2;
		this.resultatMatch = resultatMatch;
		this.stat = stat;
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

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Float getCote1() {
		return cote1;
	}

	public void setCote1(Float cote1) {
		this.cote1 = cote1;
	}

	public Float getCoteN() {
		return coteN;
	}

	public void setCoteN(Float coteN) {
		this.coteN = coteN;
	}

	public Float getCote2() {
		return cote2;
	}

	public void setCote2(Float cote2) {
		this.cote2 = cote2;
	}

	public Boolean getResultatMatch() {
		return resultatMatch;
	}

	public void setResultatMatch(Boolean resultatMatch) {
		this.resultatMatch = resultatMatch;
	}

	public List<Bet> getBets_game() {
		return bets_game;
	}

	public void setBets_game(List<Bet> bets_game) {
		this.bets_game = bets_game;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public List<Opponent> getOpponentGame() {
		return opponentGame;
	}

	public void setOpponentGame(List<Opponent> opponentGame) {
		this.opponentGame = opponentGame;
	}

	public List<Statistical> getStat() {
		return stat;
	}

	public void setStat(List<Statistical> stat) {
		this.stat = stat;
	}

}
