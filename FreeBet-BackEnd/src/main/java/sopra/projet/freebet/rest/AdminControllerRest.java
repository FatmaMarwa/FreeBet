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
import sopra.projet.freebet.model.Admin;
import sopra.projet.freebet.model.Civility;
import sopra.projet.freebet.model.Login;
import sopra.projet.freebet.model.Views;
import sopra.projet.freebet.repository.IAdminRepository;
import sopra.projet.freebet.repository.ILoginRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")

public class AdminControllerRest {
	
	@Autowired
	private IAdminRepository adminRepo;
	@Autowired
	private ILoginRepository loginRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewAdmin.class)
	public List<Admin> list() {
		List<Admin> admins = adminRepo.findAll();

		return admins;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewAdminDetail.class)
	public Admin find(@PathVariable Long id) {
		Optional<Admin> opt = adminRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new NotFoundException();
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewAdmin.class)
	public Admin create(@RequestBody Admin admin) {
		Login login = loginRepo.save(admin.getLogin());
		admin.setLogin(login);
		admin = adminRepo.save(admin);

		return admin;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin update(@RequestBody Admin admin, @PathVariable Long id) {
		admin = adminRepo.save(admin);

		return admin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		adminRepo.deleteById(id);
	}
	
	@GetMapping("/civilites")
	public Civility[] civilite() {
		return Civility.values();
	}
	
}