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
import sopra.projet.freebet.model.Sport;
import sopra.projet.freebet.model.TypeSport;
import sopra.projet.freebet.repository.ISportRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/sport")

public class SportControllerRest {
	
	@Autowired
	private ISportRepository sportRepo;
	
	@GetMapping("")
	public List<Sport> list() {
		List<Sport> sports = sportRepo.findAll();

		return sports;
	}
	
	@GetMapping("/{id}")
	public Sport find(@PathVariable Long id) {
		Optional<Sport> opt = sportRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Sport create(@RequestBody Sport sport) {
		sport = sportRepo.save(sport);

		return sport;
	}

	@PutMapping("/{id}")
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
	
}