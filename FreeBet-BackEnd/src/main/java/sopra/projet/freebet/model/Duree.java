package sopra.projet.freebet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonPropertyOrder({"name", "duree"})
public enum Duree {
	A(130), B(180), C(400);

	private int duree;

	Duree(int duree) {
		this.duree = duree;
	}
	
	public String getName() {
		return name();
	}

	public int getDuree() {
		return duree;
	}

}
