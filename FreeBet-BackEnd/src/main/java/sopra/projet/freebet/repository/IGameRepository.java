package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.projet.freebet.model.Game;

public interface IGameRepository  extends JpaRepository<Game, Long>{
}
