package sopra.projet.freebet.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.projet.freebet.exception.NotFoundException;
import sopra.projet.freebet.model.Bet;
import sopra.projet.freebet.model.Bettor;
import sopra.projet.freebet.model.TypeBet;
import sopra.projet.freebet.model.Views;
import sopra.projet.freebet.repository.IBetRepository;
import sopra.projet.freebet.repository.IBettorRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/bet")

public class BetControllerRest {

	@Autowired
	private IBetRepository betRepo;
	@Autowired
	private IBettorRepository bettorRepo;

	@GetMapping("")
	@JsonView(Views.ViewBet.class)
	public List<Bet> list() {
		List<Bet> bets = betRepo.findAll();

		return bets;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewBetDetail.class)
	public Bet find(@PathVariable Long id) {
		Optional<Bet> opt = betRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewBet.class)
	public Bet create(@RequestBody Bet bet) {
		bet = betRepo.save(bet);
		Bettor bettor = bet.getBettorr();
		bettor = bettorRepo.save(bettor);
		bet.setBettorr(bettor);
		return bet;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewBet.class)
	public Bet update(@RequestBody Bet bet, @PathVariable Long id) {
		bet = betRepo.save(bet);
		Bettor bettor = bet.getBettorr();
		bettor = bettorRepo.save(bettor);
		bet.setBettorr(bettor);
		return bet;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		betRepo.deleteById(id);
	}

	@GetMapping("/typeBet")
	public TypeBet[] typeBet() {
		return TypeBet.values();
	}

}