package sopra.projet.freebet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Game")
public class Game {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_game")
	@JsonView(Views.ViewCommon.class)
	private Date gameDate;
	@Column(name = "date_gameend")
	@JsonView(Views.ViewCommon.class)
	private Date gameEnd;
	@Column(name = "odds1")
	@JsonView(Views.ViewCommon.class)
	private Float cote1;
	@Column(name = "oddsN")
	@JsonView(Views.ViewCommon.class)
	private Float coteN;
	@Column(name = "odds2")
	@JsonView(Views.ViewCommon.class)
	private Float cote2;
	@Column(name = "game_done")
	@JsonView(Views.ViewCommon.class)
	private Boolean resultatMatch;

	@ManyToMany(mappedBy = "games")
	@JsonView(Views.ViewGameDetail.class)
	List<Bet> bets_game = new ArrayList<Bet>();

	@ManyToOne
	@JoinColumn(name = "SPORT_ID")
	@JsonView(Views.ViewGame.class)
	private Sport sport_game;


	@OneToMany(mappedBy = "game_stat")
	@JsonView(Views.ViewGame.class)
	List<Statistical> stat = new ArrayList<Statistical>();
	
	@ManyToOne
	@JsonView(Views.ViewCommon.class)
	private Opponent opponent1;

	@ManyToOne
	@JsonView(Views.ViewCommon.class)
	private Opponent opponent2;
	
	
	

	

	

	public Game() {
		super();
	}



	public Game(Long id, int version, Date gameDate, Date gameEnd, Float cote1, Float coteN, Float cote2,
			Boolean resultatMatch, Sport sport_game, Opponent opponent1, Opponent opponent2) {
		super();
		this.id = id;
		this.version = version;
		this.gameDate = gameDate;
		this.gameEnd = gameEnd;
		this.cote1 = cote1;
		this.coteN = coteN;
		this.cote2 = cote2;
		this.resultatMatch = resultatMatch;
		this.sport_game = sport_game;
		this.opponent1 = opponent1;
		this.opponent2 = opponent2;
	}

	
	

	public Game(Date gameDate, Float cote1, Float coteN, Float cote2, Boolean resultatMatch, Opponent opponent1,
			Opponent opponent2) {
		super();
		this.gameDate = gameDate;
		this.cote1 = cote1;
		this.coteN = coteN;
		this.cote2 = cote2;
		this.resultatMatch = resultatMatch;
		this.opponent1 = opponent1;
		this.opponent2 = opponent2;
	}




	public Game(Date gameDate, Date gameEnd, Float cote1, Float coteN, Float cote2, Boolean resultatMatch,
			Sport sport_game, Opponent opponent1, Opponent opponent2) {
		super();
		this.gameDate = gameDate;
		this.gameEnd = gameEnd;
		this.cote1 = cote1;
		this.coteN = coteN;
		this.cote2 = cote2;
		this.resultatMatch = resultatMatch;
		this.sport_game = sport_game;
		this.opponent1 = opponent1;
		this.opponent2 = opponent2;
	}



	public Game(Date gameDate, Date gameEnd, Float cote1, Float cote2, Boolean resultatMatch, Sport sport_game,
			Opponent opponent1, Opponent opponent2) {
		super();
		this.gameDate = gameDate;
		this.gameEnd = gameEnd;
		this.cote1 = cote1;
		this.cote2 = cote2;
		this.resultatMatch = resultatMatch;
		this.sport_game = sport_game;
		this.opponent1 = opponent1;
		this.opponent2 = opponent2;
	}



	public Game(Date gameDate, Float cote1, Float coteN, Float cote2, Boolean resultatMatch, Sport sport_game,
			Opponent opponent1, Opponent opponent2) {
		super();
		this.gameDate = gameDate;
		this.cote1 = cote1;
		this.coteN = coteN;
		this.cote2 = cote2;
		this.resultatMatch = resultatMatch;
		this.sport_game = sport_game;
		this.opponent1 = opponent1;
		this.opponent2 = opponent2;
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
		return sport_game;
	}

	public void setSport(Sport sport) {
		this.sport_game = sport;
	}


	public List<Statistical> getStat() {
		return stat;
	}

	public void setStat(List<Statistical> stat) {
		this.stat = stat;
	}

	public Date getGameEnd() {
		return gameEnd;
	}

	public void setGameEnd(Date gameEnd) {
		this.gameEnd = gameEnd;
	}

	public Sport getSport_game() {
		return sport_game;
	}

	public void setSport_game(Sport sport_game) {
		this.sport_game = sport_game;
	}

	public Opponent getOpponent1() {
		return opponent1;
	}

	public void setOpponent1(Opponent opponent1) {
		this.opponent1 = opponent1;
	}

	public Opponent getOpponent2() {
		return opponent2;
	}

	public void setOpponent2(Opponent opponent2) {
		this.opponent2 = opponent2;
	}

}
