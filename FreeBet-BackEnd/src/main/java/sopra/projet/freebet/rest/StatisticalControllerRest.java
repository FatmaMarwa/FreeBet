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
import sopra.projet.freebet.model.Code;
import sopra.projet.freebet.model.Statistical;
import sopra.projet.freebet.repository.IStatisticalRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/statistical")

public class StatisticalControllerRest {
	
	@Autowired
	private IStatisticalRepository statisticalRepo;
	
	@GetMapping("")
	public List<Statistical> list() {
		List<Statistical> stats = statisticalRepo.findAll();

		return stats;
	}
	
	@GetMapping("/{id}")
	public Statistical find(@PathVariable Long id) {
		Optional<Statistical> opt = statisticalRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	public Statistical create(@RequestBody Statistical statistical) {
		statistical = statisticalRepo.save(statistical);

		return statistical;
	}

	@PutMapping("/{id}")
	public Statistical update(@RequestBody Statistical statistical, @PathVariable Long id) {
		statistical = statisticalRepo.save(statistical);

		return statistical;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		statisticalRepo.deleteById(id);
	}
	
	@GetMapping("/code")
	public Code[] codes() {
		return Code.values();
	}
	
}