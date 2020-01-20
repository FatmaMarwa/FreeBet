package sopra.projet.freebet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonPropertyOrder({"name", "duree"})
public enum Duree {
	A(130), B(180), C(400);

	private int duree;

	Duree(int duree) {
		this.duree = duree;
	}
	@JsonView(Views.ViewCommon.class)
	public String getName() {
		return name();
	}
	@JsonView(Views.ViewCommon.class)
	public int getDuree() {
		return duree;
	}

}
