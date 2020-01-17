package sopra.projet.freebet.model;

public enum Duree {
A(130), B(180), C(400);
	
	private int duree;

    Duree(int duree) {
        this.duree = duree;
    }

    public int getNumVal() {
        return duree;
    }
}

