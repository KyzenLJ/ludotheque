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

@Controller
public class CompteController {
	
	@Autowired
	private CompteRepository compteRepository;
	
	//afficher les comptes utilisateur
	@GetMapping("/gestionCompte")
	public String getProfilPage (Model model) {
		model.addAttribute("profilesFirstPage", compteRepository.findAll(PageRequest.of(0,10)));
		return "gestionCompte";
	}
//	// formulaire de création de compte
//	@RequestMapping(value={ "/gestionCompte" }, method = RequestMethod.GET)
//    public String showCreaCompteForm(Model model) {
// 
//        Compte compte = new Compte();
//        model.addAttribute("compte", compte);
// 
//        return "gestionCompte";
//   }
//    // injection des infos du compte en BDD à la création
//    public String saveCompte(
//            final Compte compte, final BindingResult bindingResult, final ModelMap model) {
//        if (bindingResult.hasErrors()) {
//            return "gestionCompte";
//        }
//        this.compteRepository.save(compte);
//        model.clear();
//        return "/gestionCompte";
//    }  

	@PutMapping("/profil/{compteId}")
	public Compte updateCompte(@PathVariable Long compteId,
								@Valid @RequestBody Compte compteRequest) {
		return compteRepository.findById(compteId)
				.map(compte -> {
					compte.setNom(compteRequest.getNom());
					compte.setPrenom(compteRequest.getPrenom());
					compte.setEmail(compteRequest.getEmail());
					compte.setMdp(compteRequest.getMdp());
					compte.setPseudo(compteRequest.getPseudo());
					return compteRepository.save(compte);
				}).orElseThrow(() -> new ResourceNotFoundException("Compte inconnu pour l'id " + compteId));
	}
	
	@DeleteMapping("/gestionComptes/{compteId}")
	public ResponseEntity<?> deleteCompte(@PathVariable Long compteId) {
		return compteRepository.findById(compteId)
				.map(compte -> {
					compteRepository.delete(compte);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Compte inconnu pour l'id " + compteId));
	}
}
