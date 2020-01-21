package sopra.projet.freebet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.projet.freebet.model.Admin;
import sopra.projet.freebet.model.Adress;
import sopra.projet.freebet.model.Bet;
import sopra.projet.freebet.model.Bettor;
import sopra.projet.freebet.model.ChampionShip;
import sopra.projet.freebet.model.Civility;
import sopra.projet.freebet.model.Code;
import sopra.projet.freebet.model.Duree;
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

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FormationTestSpring {
	@Autowired
	private ISportRepository sportRepo;

	@Autowired
	private IOpponentRepository OpponentRepo;

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
		Sport Tennis = new Sport("Tennis", TypeSport.two);
		sportRepo.save(Tennis);

		Opponent Hawks = new Opponent("Atlanta Hawks", ChampionShip.NBA,Basket);
		Opponent Celtics = new Opponent("Boston Celtics", ChampionShip.NBA,Basket);
		Opponent Bulls = new Opponent("Chicago Bulls", ChampionShip.NBA,Basket);
		Opponent Hornets = new Opponent("Charlotte Hornets", ChampionShip.NBA,Basket);
		Opponent Nets = new Opponent("Brooklyn Nets", ChampionShip.NBA,Basket);
		Opponent Cavaliers = new Opponent("Cleveland Cavaliers", ChampionShip.NBA,Basket);
		Opponent Heat = new Opponent("Miami Heat", ChampionShip.NBA,Basket);
		Opponent Knicks = new Opponent("New York Knicks", ChampionShip.NBA,Basket);
		Opponent Pistons = new Opponent("Detroit Pistons", ChampionShip.NBA,Basket);
		Opponent Magic = new Opponent("Orlando Magic", ChampionShip.NBA,Basket);
		Opponent Sixers = new Opponent("Philadelphia Sixers", ChampionShip.NBA,Basket);
		Opponent Pacers = new Opponent("Indiana Pacers", ChampionShip.NBA,Basket);
		Opponent Wizards = new Opponent("Washinghton Wizards", ChampionShip.NBA,Basket);
		Opponent Raptors = new Opponent("Toronto Raptors", ChampionShip.NBA,Basket);
		Opponent Bucks = new Opponent("Milwaukee Bucks", ChampionShip.NBA,Basket);
		Opponent Mavs = new Opponent("Dallas Mavericks", ChampionShip.NBA,Basket);
		Opponent Nuggets = new Opponent("Denver Nuggets", ChampionShip.NBA,Basket);
		Opponent Warriors = new Opponent("Golden State Warriors", ChampionShip.NBA,Basket);
		Opponent Rocks = new Opponent("Houston Rockets", ChampionShip.NBA,Basket);
		Opponent Timberwolves = new Opponent("Minnesota Timberwolves", ChampionShip.NBA,Basket);
		Opponent Clippers = new Opponent("Los Angeles Clippers", ChampionShip.NBA,Basket);
		Opponent Grizz = new Opponent("Memphis Grizzlies", ChampionShip.NBA,Basket);
		Opponent Thunder = new Opponent("Oklohoma City Thunder", ChampionShip.NBA,Basket);
		Opponent Lakers = new Opponent("Los Angeles Lakers", ChampionShip.NBA,Basket);
		Opponent Pels = new Opponent("New Orleans Pelicans", ChampionShip.NBA,Basket);
		Opponent Blazers = new Opponent("Portland Trail Blazers", ChampionShip.NBA,Basket);
		Opponent Suns = new Opponent("Phoenix Suns", ChampionShip.NBA,Basket);
		Opponent Spurs = new Opponent("San Antonio Spurs", ChampionShip.NBA,Basket);
		Opponent Jazz = new Opponent("Utah Jazz", ChampionShip.NBA,Basket);
		Opponent Kings = new Opponent("Sacramento Kings", ChampionShip.NBA,Basket);
		OpponentRepo.save(Hawks);
		OpponentRepo.save(Celtics);
		OpponentRepo.save(Bulls);
		OpponentRepo.save(Hornets);
		OpponentRepo.save(Nets);
		OpponentRepo.save(Cavaliers);
		OpponentRepo.save(Heat);
		OpponentRepo.save(Knicks);
		OpponentRepo.save(Pistons);
		OpponentRepo.save(Magic);
		OpponentRepo.save(Sixers);
		OpponentRepo.save(Pacers);
		OpponentRepo.save(Wizards);
		OpponentRepo.save(Raptors);
		OpponentRepo.save(Bucks);
		OpponentRepo.save(Mavs);
		OpponentRepo.save(Nuggets);
		OpponentRepo.save(Warriors);
		OpponentRepo.save(Rocks);
		OpponentRepo.save(Timberwolves);
		OpponentRepo.save(Clippers);
		OpponentRepo.save(Grizz);
		OpponentRepo.save(Thunder);
		OpponentRepo.save(Lakers);
		OpponentRepo.save(Pels);
		OpponentRepo.save(Blazers);
		OpponentRepo.save(Suns);
		OpponentRepo.save(Spurs);
		OpponentRepo.save(Jazz);
		OpponentRepo.save(Kings);

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

		List<Opponent> opps1 = new ArrayList<Opponent>();
		opps1.add(Blazers);
		opps1.add(Lakers);
		List<Opponent> opps2 = new ArrayList<Opponent>();
		opps2.add(Pacers);
		opps2.add(Pels);
		
		Game dgame1 = new Game(dtevent1, 1.06F, null, 9.30F, true,opps1, stats1);
		Game dgame2 = new Game(dtevent2, 9.10F, null, 1.07F, true,opps2, stats2);
		gameRepo.save(dgame1);
		gameRepo.save(dgame2);
		
		Game dgame3 = new Game(dtevent1, 1.26F, null, 6.30F, true,Tennis, stats1);
		Game dgame4 = new Game(dtevent2, 7.10F, null, 1.17F, true,Tennis, stats2);
		gameRepo.save(dgame3);
		gameRepo.save(dgame4);
		
		Opponent opp1 = new Opponent("Medvedev",ChampionShip.ATP,Tennis, dgame3);
		Opponent opp2 = new Opponent("Federer",ChampionShip.ATP,Tennis, dgame3);
		Opponent opp3 = new Opponent("Nadal",ChampionShip.ATP,Tennis, dgame4);
		Opponent opp4 = new Opponent("Djokovic",ChampionShip.ATP,Tennis, dgame4);
		OpponentRepo.save(opp1);
		OpponentRepo.save(opp2);
		OpponentRepo.save(opp3);
		OpponentRepo.save(opp4);
		
		List<Game> games1 = new ArrayList<Game>();
		games1.add(dgame3);
		List<Game> games2 = new ArrayList<Game>();
		games2.add(dgame3);
		games2.add(dgame4);

		Bet dbet1 = new Bet(20f, false, TypeBet.simple, dtpari1, 186F, games1);
		Bet dbet2 = new Bet(10f, true, TypeBet.combined, dtpari2, 11.34F, games2);
		betRepo.save(dbet1);
		betRepo.save(dbet2);

	}

	@Test
	public void testTwo() throws ParseException {

		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat Dateevent = new SimpleDateFormat(pattern);
		Date date1 = Dateevent.parse("2019-12-21 20:00:00");
		Date date2 = Dateevent.parse("2020-01-10 20:00:00");
		Date ddp1 = Dateevent.parse("2019-12-20 20:00:00");
		Date ddp2 = Dateevent.parse("2019-12-19 20:00:00");

		String pattern1 = "yyyy-MM-dd";
		SimpleDateFormat DateBirth = new SimpleDateFormat(pattern1);

		Date ddn1 = DateBirth.parse("1998-01-01");
		Date ddn2 = DateBirth.parse("1992-08-08");

		Sport foot = new Sport("Football", TypeSport.three);
		sportRepo.save(foot);

		Opponent psg = new Opponent("Paris Saint-Germain", ChampionShip.Ligue1,foot);
		Opponent amiens = new Opponent("Amiens SC", ChampionShip.Ligue1,foot);
		Opponent dijon = new Opponent("Dijon FCO", ChampionShip.Ligue1,foot);
		Opponent rennes = new Opponent("Stade Rennais", ChampionShip.Ligue1,foot);
		Opponent bordeau = new Opponent("Girondins de Bordeaux", ChampionShip.Ligue1,foot);
		Opponent strasbourg = new Opponent("Strasbourg", ChampionShip.Ligue1,foot);
		Opponent saintetienne = new Opponent("AS Saint-Etienne", ChampionShip.Ligue1,foot);
		Opponent monaco = new Opponent("Monaco", ChampionShip.Ligue1,foot);
		Opponent lille = new Opponent("Lille OSC", ChampionShip.Ligue1,foot);
		Opponent reims = new Opponent("Stade de Reims", ChampionShip.Ligue1,foot);
		Opponent lyon = new Opponent("Olympique Lyonnais", ChampionShip.Ligue1,foot);
		Opponent nantes = new Opponent("Nantes", ChampionShip.Ligue1,foot);
		Opponent angers = new Opponent("SCO Angers", ChampionShip.Ligue1,foot);
		Opponent nice = new Opponent("OGC Nice", ChampionShip.Ligue1,foot);
		Opponent toulouse = new Opponent("Toulouse FC", ChampionShip.Ligue1,foot);
		Opponent montpellier = new Opponent("Montpellier Hérault", ChampionShip.Ligue1,foot);
		Opponent brest = new Opponent("Stade Brestois", ChampionShip.Ligue1,foot);
		Opponent marseille = new Opponent("Olympique de Marseille", ChampionShip.Ligue1,foot);
		Opponent nimes = new Opponent("Nîmes", ChampionShip.Ligue1,foot);

		OpponentRepo.save(psg);
		OpponentRepo.save(amiens);
		OpponentRepo.save(dijon);
		OpponentRepo.save(rennes);
		OpponentRepo.save(bordeau);
		OpponentRepo.save(strasbourg);
		OpponentRepo.save(saintetienne);
		OpponentRepo.save(monaco);
		OpponentRepo.save(lille);
		OpponentRepo.save(reims);
		OpponentRepo.save(lyon);
		OpponentRepo.save(nantes);
		OpponentRepo.save(angers);
		OpponentRepo.save(nice);
		OpponentRepo.save(toulouse);
		OpponentRepo.save(montpellier);
		OpponentRepo.save(brest);
		OpponentRepo.save(marseille);
		OpponentRepo.save(nimes);

		Adress lad1 = new Adress("11 rue des palourdes", "toulouse", "31000", "France");
		Adress lad2 = new Adress("12 rue des palourdes", "toulouse", "31000", "France");
		Adress lad3 = new Adress("13 rue des palourdes", "toulouse", "31000", "France");

		Login ll1 = new Login("Cucupidon", "louis@gmail.com", "abcd1234");
		Login ll2 = new Login("patapouf", "patapouf@gmail.com", "azerty");
		Login ll3 = new Login("flicflac", "flicflouf@gmail.com", "motdepasse");

		loginRepo.save(ll1);
		loginRepo.save(ll2);
		loginRepo.save(ll3);

		Admin la = new Admin("louis", "auffret", lad1, ll1);
		adminRepo.save(la);

		Bettor l1bet = new Bettor("Eric", "Sultant", ddn1, 20F, Civility.MR, lad2, ll2);
		Bettor l2bet = new Bettor("luc", "Blanchot", ddn2, 100F, Civility.MR, lad3, ll3);

		bettorRepo.save(l1bet);
		bettorRepo.save(l2bet);
		
		List<Opponent> opps1 = new ArrayList<Opponent>();
		opps1.add(amiens);
		opps1.add(psg);
		List<Opponent> opps2 = new ArrayList<Opponent>();
		opps2.add(dijon);
		opps2.add(marseille);

		Game amienspsg = new Game(date1, 9.1F, 5.2F, 1.2F, opps1);
		Game dijonmetz = new Game(date1, 2.1F, 3.2F, 3.4F, opps2);
		Game toulousebrest = new Game(date2, 2.2F, 3.4F, 3.2F, false);

		Statistical st1 = new Statistical(Code.result1, 1);
		Statistical st2 = new Statistical(Code.result1, 4);
		Statistical st3 = new Statistical(Code.result1, 2);
		Statistical st4 = new Statistical(Code.result1, 2);
		
		

		List<Statistical> lstats1 = new ArrayList<Statistical>();
		lstats1.add(st1);
		lstats1.add(st2);
		List<Statistical> stats2 = new ArrayList<Statistical>();
		lstats1.add(st3);
		lstats1.add(st4);

		statisticalRepo.save(st1);
		statisticalRepo.save(st2);
		statisticalRepo.save(st3);
		statisticalRepo.save(st4);

		gameRepo.save(amienspsg);
		gameRepo.save(dijonmetz);
		gameRepo.save(toulousebrest);

		List<Game> amienspsg2 = new ArrayList<Game>();
		amienspsg2.add(amienspsg);
		List<Game> dijonmetz2 = new ArrayList<Game>();
		dijonmetz2.add(dijonmetz);

		Bet lb1 = new Bet(15.5F, true, TypeBet.simple, ddp1, 18.6F, amienspsg2);
		Bet lb2 = new Bet(100F, false, TypeBet.combined, ddp2, 340F, dijonmetz2);

		betRepo.save(lb1);
		betRepo.save(lb2);

		Sport sp = new Sport("balle", TypeSport.one, Duree.A);
		sportRepo.save(sp);
	}

}
