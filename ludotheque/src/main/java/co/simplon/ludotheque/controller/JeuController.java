package co.simplon.ludotheque.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.simplon.ludotheque.Enum.MecaniqueEnum;
import co.simplon.ludotheque.exception.ResourceNotFoundException;
import co.simplon.ludotheque.model.Jeu;
import co.simplon.ludotheque.model.Mecanique;
import co.simplon.ludotheque.repository.JeuRepository;
import co.simplon.ludotheque.service.impl.JeuServiceJpaImpl;

@Controller
public class JeuController {
	
	@Autowired
	private JeuRepository jeuRepository;
	
	private JeuServiceJpaImpl jeuServiceJpaImpl;
	
	@GetMapping("/catalogue")
	public String getJeuxPage (Model model) {
		model.addAttribute("jeuxFirstPage", jeuRepository.findAll(PageRequest.of(0,10)));
		return "catalogue";
	}	
	
//	@GetMapping("/catalogue/detail/{jeuID}")
//	public String view(@PathVariable("id") Long id, Model model) {
//		Jeu jeu = jeu.findById(id);
//		model.addAttribute("jeu", jeu);
//		return "catalogue/detail";
//	}
	
//    @GetMapping("/gestionCatalogue")
//    public String formCreateJeu(Model model) {
// 
//        Jeu jeu = new Jeu();
//        model.addAttribute("nouveauJeu", jeuRepository.save(jeu));
// 
//        return "gestionCatalogue";
//    }
	
    @RequestMapping(value = { "/gestionCatalogue" }, method = RequestMethod.GET)
    public String showCreaJeuPage(Model model) {
 
        Jeu jeu = new Jeu();
        model.addAttribute("jeu", jeu);
        model.addAttribute("mecaniquesEnum", MecaniqueEnum.values());
        return "gestionCatalogue";
    }
 
//    @RequestMapping(value = { "/gestionCatalogue" }, method = RequestMethod.POST)
//    public String saveJeu(Model model, //
//    			@RequestBody Jeu jeu) {
//    	System.out.println("Jeu" + jeu);
//        String titre = jeu.getTitre();
//        String description = jeu.getDescription();
//        String theme = jeu.getTheme();
//        int joueur_min = jeu.getJoueur_min();
//        int joueur_max = jeu.getJoueur_max();
//        boolean disponible = jeu.isDisponible();
//        int exemplaire_catalogue = jeu.getExemplaire_catalogue();
//        int exemplaire_dispo = jeu.getExemplaire_dispo();
//        Set<Mecanique> mecanique = jeu.getMecanique();
//        
//        Jeu newJeu = new Jeu();
//        jeuRepository.save(newJeu);
// 
//            return "redirect:/catalogue";
//        }
    
    @RequestMapping(value="/gestionCatalogue")
    public String saveJeu(
            final Jeu jeu, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "gestionCatalogue";
        }
        this.jeuRepository.save(jeu);
        model.clear();
        return "redirect:/catalogue";
    }    
    
//	@PostMapping("/gestionCatalogue")
//	public Jeu createJeu(@RequestBody Jeu jeu) {
//		return jeuRepository.save(jeu);
//	}
	
	@PutMapping("/catalogue/detailJeu/{jeuId}")
	public Jeu updateJeu(@PathVariable Long jeuId,
						@Valid @RequestBody Jeu jeuRequest) {
		return jeuRepository.findById(jeuId)
				.map(jeu -> {
					jeu.setTitre(jeuRequest.getTitre());
					jeu.setDescription(jeuRequest.getDescription());
					jeu.setTheme(jeuRequest.getTheme());
					jeu.setJoueurMin(jeuRequest.getJoueurMin());
					jeu.setJoueurMax(jeuRequest.getJoueurMax());
					jeu.setExemplaireCatalogue(jeuRequest.getExemplaireCatalogue());
					jeu.setExemplaireDispo(jeuRequest.getExemplaireDispo());
					jeu.setMecanique(jeuRequest.getMecanique());
					return jeuRepository.save(jeu);
				}).orElseThrow(() -> new ResourceNotFoundException("Jeu inconnu avec l'id " + jeuId));
	}
	
	@DeleteMapping("/catalogue/{jeuId}")
	public ResponseEntity<?> deleteJeu(@PathVariable Long jeuId) {
		return jeuRepository.findById(jeuId)
				.map(jeu -> {
					jeuRepository.delete(jeu);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Jeu inconnu avec l'id " + jeuId));
	}

}
