package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sopra.projet.freebet.model.Sport;

public interface ISportRepository  extends JpaRepository<Sport, Long> {
	@Query("select s from Sport s left join fetch s.games sg where s.id = :id")
	Sport findByIdWithGames(@Param("id") Long id);
}
