package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.freebet.model.Bettor;

public interface IBettorRepository extends JpaRepository<Bettor, Long> {

}
