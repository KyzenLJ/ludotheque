package co.simplon.ludotheque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ludotheque.exception.ResourceNotFoundException;
import co.simplon.ludotheque.model.Compte;
import co.simplon.ludotheque.repository.CompteRepository;
import co.simplon.ludotheque.service.CompteService;

@Controller
public class CompteController {
	
	@Autowired
	private CompteService compteService;
	
	//afficher les comptes utilisateur
	@GetMapping("/gestionCompte")
	public String getPageComptes (Model model) {
		model.addAttribute("compteesFirstPage", compteService.findAll(PageRequest.of(0,20)));
		return "gestionCompte";
	}

	
//	@DeleteMapping("/gestionComptes/{compteId}")
//	public String deleteCompte
//	}
}
