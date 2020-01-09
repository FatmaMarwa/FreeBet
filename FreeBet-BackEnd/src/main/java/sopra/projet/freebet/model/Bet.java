package sopra.projet.freebet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Bet")
public class Bet {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;

	@Column(name = "stake")
	private Float mise;
	@Column(name = "bet_result")
	private Boolean resultatPari;
	@Enumerated(EnumType.STRING)
	@Column(name = "type_bet")
	private TypeBet type;
	@Temporal(TemporalType.DATE)
	@Column(name = "bet_date")
	private Date betDate;
	@Column(name = "gain")
	private Float gain;

	@ManyToMany
	@JoinTable(name = "Bet_Game", joinColumns = {
			@JoinColumn(name = "BET_ID") }, inverseJoinColumns = @JoinColumn(name = "GAME_ID"))
	private List<Game> games = new ArrayList<Game>();

	@ManyToOne
	@JoinColumn(name = "bettor_id")
	private Bettor bettorr;

	public Bet() {
		super();
	}

	public Bet(Float mise, boolean resultatPari, TypeBet type, Date date, Float gain) {
		super();
		this.mise = mise;
		this.resultatPari = resultatPari;
		this.type = type;
		this.betDate = date;
		this.gain = gain;
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

	public Float getMise() {
		return mise;
	}

	public void setMise(Float mise) {
		this.mise = mise;
	}

	public Boolean getResultatPari() {
		return resultatPari;
	}

	public void setResultatPari(Boolean resultatPari) {
		this.resultatPari = resultatPari;
	}

	public TypeBet getType() {
		return type;
	}

	public void setType(TypeBet type) {
		this.type = type;
	}

	public Date getBetDate() {
		return betDate;
	}

	public void setBetDate(Date betDate) {
		this.betDate = betDate;
	}

	public Float getGain() {
		return gain;
	}

	public void setGain(Float gain) {
		this.gain = gain;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Bettor getBettor() {
		return bettorr;
	}

	public void setBettor(Bettor bettor) {
		this.bettorr = bettor;
	}

}
