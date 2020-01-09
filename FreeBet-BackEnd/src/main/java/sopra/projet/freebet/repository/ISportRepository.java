package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.freebet.model.Sport;

public interface ISportRepository  extends JpaRepository<Sport, Long> {

}
