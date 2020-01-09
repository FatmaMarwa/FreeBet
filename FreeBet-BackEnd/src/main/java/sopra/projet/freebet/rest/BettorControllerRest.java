package sopra.projet.freebet.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sopra.projet.freebet.exception.NotFoundException;
import sopra.projet.freebet.model.Bettor;
import sopra.projet.freebet.repository.IBettorRepository;

@RestController
@RequestMapping("/bettor")

public class BettorControllerRest {
	
	@Autowired
	private IBettorRepository bettorRepo;
	
	@GetMapping("")
	public List<Bettor> list() {
		List<Bettor> bettors = bettorRepo.findAll();

		return bettors;
	}
	
	@GetMapping("/{id}")
	public Bettor find(@PathVariable Long id) {
		Optional<Bettor> opt = bettorRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Bettor create(@RequestBody Bettor bettor) {
		bettor = bettorRepo.save(bettor);

		return bettor;
	}

	@PutMapping("/{id}")
	public Bettor update(@RequestBody Bettor bettor, @PathVariable Long id) {
		bettor = bettorRepo.save(bettor);

		return bettor;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bettorRepo.deleteById(id);
	}
	
}