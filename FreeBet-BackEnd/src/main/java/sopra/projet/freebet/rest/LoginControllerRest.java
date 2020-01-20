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
import sopra.projet.freebet.model.Login;
import sopra.projet.freebet.model.Views;
import sopra.projet.freebet.repository.ILoginRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")

public class LoginControllerRest {

	@Autowired
	private ILoginRepository loginRepo;

	@GetMapping("")
	@JsonView(Views.ViewLogin.class)
	public List<Login> list() {
		List<Login> logins = loginRepo.findAll();

		return logins;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLoginDetail.class)
	public Login find(@PathVariable Long id) {
		Optional<Login> opt = loginRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewLogin.class)
	public Login create(@RequestBody Login login) {
		login = loginRepo.save(login);

		return login;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLogin.class)
	public Login update(@RequestBody Login login, @PathVariable Long id) {
		System.out.println(login);
		login = loginRepo.save(login);

		return login;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		loginRepo.deleteById(id);
	}

}