package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.freebet.model.Bet;

public interface IBetRepository  extends JpaRepository<Bet, Long>{

}
