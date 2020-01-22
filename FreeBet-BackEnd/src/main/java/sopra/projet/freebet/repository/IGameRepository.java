package sopra.projet.freebet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.projet.freebet.model.Game;

public interface IGameRepository  extends JpaRepository<Game, Long>{
	@Query("select g from Game g where g.sport_game.id = :id")
	List<Game> findAllBySport(@Param("id") Long id);
}
