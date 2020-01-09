package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.freebet.model.Opponent;

public interface IOpponentRepository  extends JpaRepository<Opponent, Long>{

}
