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
import sopra.projet.freebet.model.ChampionShip;
import sopra.projet.freebet.model.Opponent;
import sopra.projet.freebet.model.Views;
import sopra.projet.freebet.repository.IOpponentRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/opponent")

public class OpponentControllerRest {

	@Autowired
	private IOpponentRepository opponentRepo;

	@GetMapping("")
	@JsonView(Views.ViewOpponent.class)
	public List<Opponent> list() {
		List<Opponent> opponents = opponentRepo.findAll();

		return opponents;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewOpponentDetail.class)
	public Opponent find(@PathVariable Long id) {
		Optional<Opponent> opt = opponentRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewOpponent.class)
	public Opponent create(@RequestBody Opponent opponent) {
		opponent = opponentRepo.save(opponent);

		return opponent;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewOpponent.class)
	public Opponent update(@RequestBody Opponent opponent, @PathVariable Long id) {
		opponent = opponentRepo.save(opponent);

		return opponent;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		opponentRepo.deleteById(id);
	}

	@GetMapping("/championship")
	public ChampionShip[] champ() {
		return ChampionShip.values();
	}
}