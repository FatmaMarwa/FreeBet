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
import sopra.projet.freebet.model.Admin;
import sopra.projet.freebet.model.Game;
import sopra.projet.freebet.repository.IAdminRepository;
import sopra.projet.freebet.repository.IGameRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/game")

public class GameControllerRest {
	
	@Autowired
	private IGameRepository gameRepo;
	
	@GetMapping("")
	public List<Game> list() {
		List<Game> games = gameRepo.findAll();

		return games;
	}
	
	@GetMapping("/{id}")
	public Game find(@PathVariable Long id) {
		Optional<Game> opt = gameRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Game create(@RequestBody Game game) {
		game = gameRepo.save(game);

		return game;
	}

	@PutMapping("/{id}")
	public Game update(@RequestBody Game game, @PathVariable Long id) {
		game = gameRepo.save(game);

		return game;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		gameRepo.deleteById(id);
	}
	
}