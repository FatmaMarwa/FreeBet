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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Statistical")
public class Statistical {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;

	@Enumerated(EnumType.STRING)
	@Column(name = "code")
	@JsonView(Views.ViewCommon.class)
	private Code code;
	@Column(name = "result")
	@JsonView(Views.ViewCommon.class)
	private int resultat;

	@ManyToOne
	@JoinColumn(name = "GAME_ID")
	@JsonView(Views.ViewStatistical.class)
	private Game game_stat;

	public Statistical() {
		super();
	}

	public Statistical(Code code, int resultat) {
		super();
		this.code = code;
		this.resultat = resultat;
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

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

}
