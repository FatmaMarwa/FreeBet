package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.projet.freebet.model.Login;

public interface ILoginRepository  extends JpaRepository<Login, Long>{

	@Query("select l from Login l where l.pseudo= :pseudo and l.motDePasse= :motDePasse")
	public Login findByLoginAndPassword(@Param("pseudo") String pseudo,@Param("motDePasse")String motDePasse);

}
