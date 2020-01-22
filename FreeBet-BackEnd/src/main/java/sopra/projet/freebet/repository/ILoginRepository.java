package sopra.projet.freebet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.projet.freebet.model.Login;

public interface ILoginRepository  extends JpaRepository<Login, Long>{

	public Login findOneByLoginAndMotDePasse(String pseudo, String motDePasse);

	public int countBypseudo(String pseudo);
}
