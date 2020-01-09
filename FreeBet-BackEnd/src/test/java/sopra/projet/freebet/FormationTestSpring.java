package sopra.projet.freebet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.projet.freebet.model.Admin;
import sopra.projet.freebet.model.Adress;
import sopra.projet.freebet.model.Bet;
import sopra.projet.freebet.model.Bettor;
import sopra.projet.freebet.model.ChampionShip;
import sopra.projet.freebet.model.Civility;
import sopra.projet.freebet.model.Code;
import sopra.projet.freebet.model.Game;
import sopra.projet.freebet.model.Login;
import sopra.projet.freebet.model.Opponent;
import sopra.projet.freebet.model.Sport;
import sopra.projet.freebet.model.Statistical;
import sopra.projet.freebet.model.TypeBet;
import sopra.projet.freebet.model.TypeSport;
import sopra.projet.freebet.repository.IAdminRepository;
import sopra.projet.freebet.repository.IBetRepository;
import sopra.projet.freebet.repository.IBettorRepository;
import sopra.projet.freebet.repository.IGameRepository;
import sopra.projet.freebet.repository.ILoginRepository;
import sopra.projet.freebet.repository.IOpponentRepository;
import sopra.projet.freebet.repository.ISportRepository;
import sopra.projet.freebet.repository.IStatisticalRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class FormationTestSpring {
	@Autowired
	private ISportRepository sportRepo;

	@Autowired
	private IOpponentRepository opponentRepo;

	@Autowired
	private IGameRepository gameRepo;
	@Autowired
	private IBetRepository betRepo;
	@Autowired
	private IBettorRepository bettorRepo;
	@Autowired
	private ILoginRepository loginRepo;
	@Autowired
	private IAdminRepository adminRepo;
	@Autowired
	private IStatisticalRepository statisticalRepo;

	@Test
	public void testOne() throws ParseException {
		String pattern1 = "yyyy-MM-dd";
		SimpleDateFormat dtdn = new SimpleDateFormat(pattern1);
		String pattern2 = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat dth = new SimpleDateFormat(pattern2);

		Date dddn1 = dtdn.parse("1990-12-21");
		Date dddn2 = dtdn.parse("1992-01-10");

		Date dtevent1 = dth.parse("2020-01-09 03:00:00");
		Date dtevent2 = dth.parse("2020-01-09 04:00:00");
		Date dtevent3 = dth.parse("2020-01-12 01:30:00");

		Date dtpari1 = dth.parse("2020-01-05 21:00:00");
		Date dtpari2 = dth.parse("2020-01-05 19:00:00");

		Sport Basket = new Sport("Basketball", TypeSport.two);
		sportRepo.save(Basket);

		Opponent Hawks = new Opponent("Atlanta Hawks", ChampionShip.NBA);
		Opponent Celtics = new Opponent("Boston Celtics", ChampionShip.NBA);
		Opponent Bulls = new Opponent("Chicago Bulls", ChampionShip.NBA);
		Opponent Hornets = new Opponent("Charlotte Hornets", ChampionShip.NBA);
		Opponent Nets = new Opponent("Brooklyn Nets", ChampionShip.NBA);
		Opponent Cavaliers = new Opponent("Cleveland Cavaliers", ChampionShip.NBA);
		Opponent Heat = new Opponent("Miami Heat", ChampionShip.NBA);
		Opponent Knicks = new Opponent("New York Knicks", ChampionShip.NBA);
		Opponent Pistons = new Opponent("Detroit Pistons", ChampionShip.NBA);
		Opponent Magic = new Opponent("Orlando Magic", ChampionShip.NBA);
		Opponent Sixers = new Opponent("Philadelphia Sixers", ChampionShip.NBA);
		Opponent Pacers = new Opponent("Indiana Pacers", ChampionShip.NBA);
		Opponent Wizards = new Opponent("Washinghton Wizards", ChampionShip.NBA);
		Opponent Raptors = new Opponent("Toronto Raptors", ChampionShip.NBA);
		Opponent Bucks = new Opponent("Milwaukee Bucks", ChampionShip.NBA);
		Opponent Mavs = new Opponent("Dallas Mavericks", ChampionShip.NBA);
		Opponent Nuggets = new Opponent("Denver Nuggets", ChampionShip.NBA);
		Opponent Warriors = new Opponent("Golden State Warriors", ChampionShip.NBA);
		Opponent Rocks = new Opponent("Houston Rockets", ChampionShip.NBA);
		Opponent Timberwolves = new Opponent("Minnesota Timberwolves", ChampionShip.NBA);
		Opponent Clippers = new Opponent("Los Angeles Clippers", ChampionShip.NBA);
		Opponent Grizz = new Opponent("Memphis Grizzlies", ChampionShip.NBA);
		Opponent Thunder = new Opponent("Oklohoma City Thunder", ChampionShip.NBA);
		Opponent Lakers = new Opponent("Los Angeles Lakers", ChampionShip.NBA);
		Opponent Pels = new Opponent("New Orleans Pelicans", ChampionShip.NBA);
		Opponent Blazers = new Opponent("Portland Trail Blazers", ChampionShip.NBA);
		Opponent Suns = new Opponent("Phoenix Suns", ChampionShip.NBA);
		Opponent Spurs = new Opponent("San Antonio Spurs", ChampionShip.NBA);
		Opponent Jazz = new Opponent("Utah Jazz", ChampionShip.NBA);
		Opponent Kings = new Opponent("Sacramento Kings", ChampionShip.NBA);
		opponentRepo.save(Hawks);
		opponentRepo.save(Celtics);
		opponentRepo.save(Bulls);
		opponentRepo.save(Hornets);
		opponentRepo.save(Nets);
		opponentRepo.save(Cavaliers);
		opponentRepo.save(Heat);
		opponentRepo.save(Knicks);
		opponentRepo.save(Pistons);
		opponentRepo.save(Magic);
		opponentRepo.save(Sixers);
		opponentRepo.save(Pacers);
		opponentRepo.save(Wizards);
		opponentRepo.save(Raptors);
		opponentRepo.save(Bucks);
		opponentRepo.save(Mavs);
		opponentRepo.save(Nuggets);
		opponentRepo.save(Warriors);
		opponentRepo.save(Rocks);
		opponentRepo.save(Timberwolves);
		opponentRepo.save(Clippers);
		opponentRepo.save(Grizz);
		opponentRepo.save(Thunder);
		opponentRepo.save(Lakers);
		opponentRepo.save(Pels);
		opponentRepo.save(Blazers);
		opponentRepo.save(Suns);
		opponentRepo.save(Spurs);
		opponentRepo.save(Jazz);
		opponentRepo.save(Kings);

		Adress da1 = new Adress("37 rue Corneille", "31100", "Toulouse", "FRANCE");
		Adress da2 = new Adress("2 rue de la Paix", "75008", "Paris", "FRANCE");
		Adress da3 = new Adress("9 rue L�opold", "1000", "Bruxelles", "BELGIQUE");

		Login dlg1 = new Login("djam", "admindm@gmail.com", "admin00");
		Login dlg2 = new Login("dada", "dada@gmail.com", "dada00");
		Login dlg3 = new Login("cucu", "cucu@gmail.com", "cucu00");
		loginRepo.save(dlg1);
		loginRepo.save(dlg2);
		loginRepo.save(dlg3);

		Admin Djamil = new Admin("MOHAMED", "Djamil", da1, dlg1);
		adminRepo.save(Djamil);

		Bettor dbettor1 = new Bettor("DNOM1", "DPRENOM1", dddn1, 80F, Civility.MR, da2, dlg2);
		Bettor dbettor2 = new Bettor("DNOM2", "DPRENOM2", dddn2, 45.5F, Civility.MME, da3, dlg3);
		bettorRepo.save(dbettor1);
		bettorRepo.save(dbettor2);

		Statistical dst1 = new Statistical(Code.result1, 128);
		Statistical dst2 = new Statistical(Code.result2, 104);
		Statistical dst3 = new Statistical(Code.result1, 98);
		Statistical dst4 = new Statistical(Code.result2, 107);
		statisticalRepo.save(dst1);
		statisticalRepo.save(dst2);
		statisticalRepo.save(dst3);
		statisticalRepo.save(dst4);

		List<Statistical> stats1 = new ArrayList<Statistical>();
		stats1.add(dst1);
		stats1.add(dst2);
		List<Statistical> stats2 = new ArrayList<Statistical>();
		stats1.add(dst3);
		stats1.add(dst4);

		Game dgame1 = new Game(dtevent1, 1.06F, null, 9.30F, true, stats1);
		Game dgame2 = new Game(dtevent2, 9.10F, null, 1.07F, true, stats2);
		gameRepo.save(dgame1);
		gameRepo.save(dgame2);

		List<Game> games1 = new ArrayList<Game>();
		games1.add(dgame1);
		List<Game> games2 = new ArrayList<Game>();
		games2.add(dgame1);
		games2.add(dgame2);

		Bet dbet1 = new Bet(20f, false, TypeBet.simple, dtpari1, 186F, games1);
		Bet dbet2 = new Bet(10f, true, TypeBet.combined, dtpari2, 11.34F, games2);
		betRepo.save(dbet1);
		betRepo.save(dbet2);

	}

	@Test
	public void testTwo() {

	}

}
