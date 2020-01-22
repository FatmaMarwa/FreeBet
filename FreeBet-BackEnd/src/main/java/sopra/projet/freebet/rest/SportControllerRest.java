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
import sopra.projet.freebet.model.Duree;
import sopra.projet.freebet.model.Game;
import sopra.projet.freebet.model.Sport;
import sopra.projet.freebet.model.TypeSport;
import sopra.projet.freebet.model.Views;
import sopra.projet.freebet.repository.IGameRepository;
import sopra.projet.freebet.repository.ISportRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/sport")

public class SportControllerRest {

	@Autowired
	private ISportRepository sportRepo;
	
	@Autowired
	private IGameRepository gameRepo;

	@GetMapping("")
	@JsonView(Views.ViewSport.class)
	public List<Sport> list() {
		List<Sport> sports = sportRepo.findAll();

		return sports;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSport.class)
	public Sport find(@PathVariable Long id) {
		Optional<Sport> opt = sportRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewSportDetail.class)
	public Sport detail(@PathVariable Long id) {
		Sport sport = sportRepo.findByIdWithGames(id);

		if (sport != null) {
			return sport;
		} else {
			throw new NotFoundException();
		}
	}
	
	@GetMapping("/{id}/games")
	@JsonView(Views.ViewGame.class)
	public List<Game> findAllGames(@PathVariable Long id) {
		return gameRepo.findAllBySport(id);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewSport.class)
	public Sport create(@RequestBody Sport sport) {
		sport = sportRepo.save(sport);

		return sport;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSport.class)
	public Sport update(@RequestBody Sport sport, @PathVariable Long id) {
		sport = sportRepo.save(sport);

		return sport;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		sportRepo.deleteById(id);
	}

	@GetMapping("/typeSports")
	public TypeSport[] typesport() {
		return TypeSport.values();
	}

	@GetMapping("/durees")
	public Duree[] duree() {
		return Duree.values();
	}
}