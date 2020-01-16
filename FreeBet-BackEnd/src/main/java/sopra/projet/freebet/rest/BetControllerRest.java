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

import sopra.projet.freebet.exception.NotFoundException;
import sopra.projet.freebet.model.Bet;
import sopra.projet.freebet.repository.IBetRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/bet")

public class BetControllerRest {
	
	@Autowired
	private IBetRepository betRepo;
	
	@GetMapping("")
	public List<Bet> list() {
		List<Bet> bets = betRepo.findAll();

		return bets;
	}
	
	@GetMapping("/{id}")
	public Bet find(@PathVariable Long id) {
		Optional<Bet> opt = betRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Bet create(@RequestBody Bet bet) {
		bet = betRepo.save(bet);

		return bet;
	}

	@PutMapping("/{id}")
	public Bet update(@RequestBody Bet bet, @PathVariable Long id) {
		bet = betRepo.save(bet);

		return bet;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		betRepo.deleteById(id);
	}
	
}