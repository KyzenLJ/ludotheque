package co.simplon.ludotheque.controller;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.repository.PagingAndSortingRepository;

import co.simplon.ludotheque.Enum.MecaniqueEnum;
import co.simplon.ludotheque.exception.ResourceNotFoundException;
import co.simplon.ludotheque.model.Jeu;
import co.simplon.ludotheque.model.Mecanique;
import co.simplon.ludotheque.repository.JeuRepository;
import co.simplon.ludotheque.service.impl.JeuServiceJpaImpl;
import co.simplon.ludotheque.model.PaginationModel;

@Controller
public class JeuController {
	
//    private static final int BOUTONS_A_AFFICHER = 5;
//    private static final int PREMIERE_PAGE = 0;
//    private static final int TAILLE_DE_PAGE_INITIALE= 10;
//    private static final int[] TAILLES_DE_PAGE = { 10, 20};
	
	@Autowired
	private JeuRepository jeuRepository;
	
	private JeuServiceJpaImpl jeuServiceJpaImpl;
	
	@GetMapping("/catalogue")
	public String getJeuxPage (Model model) {
		model.addAttribute("jeuxFirstPage", jeuRepository.findAll(PageRequest.of(0,10)));
		return "catalogue";
	}	
	

//    @GetMapping("/catalogue")
//    public ModelAndView homepage(@RequestParam("tailleDePage") Optional<Integer> tailleDePage,
//            @RequestParam("page") Optional<Integer> page){
//        if(jeuRepository.count()!=0){
//            ;//OK
//        }else{
//            return null;
//        }
//        ModelAndView modelAndView = new ModelAndView("index");
//        //
//        // Evalue la taille de la page. Si le paramètre recquis est null, il retourne
//        // la taille initiale de la page
//        int evalTailleDePage = tailleDePage.orElse(TAILLE_DE_PAGE_INITIALE);
//        // Evalue la page. Si le paramètre recquis est null ou <0 (afin
//        // de prévenir les exceptions), retourn la taille initiale. Sinon, retourne la valeur
//        // du paramètre réduit de 1.
//        int evalPage = (page.orElse(0) < 1) ? PREMIERE_PAGE : page.get() - 1;
//        Page<Jeu> jeuList = jeuRepository.findAll(new PageRequest(evalPage, evalTailleDePage));
//        PaginationModel pagination = new PaginationModel(jeuList.getPagesTotales(),jeuList.getNumber(),BOUTONS_A_AFFICHER);
//        // add le model Jeu
//        modelAndView.addObject("jeuList",jeuList);
//        // évalue la taille de la page
//        modelAndView.addObject("taillePageSelectionnee", taillePageSelectionnee);
//        // add les tailles de page
//        modelAndView.addObject("taillesDePage", TAILLES_DE_PAGE);
//        // add pagination
//        modelAndView.addObject("pagination", pagination);
//        return modelAndView;
//    }
	
//	@GetMapping("/catalogue/detail/{id}")
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
 
//    @RequestMapping(value = { "/gestionCatalogue" }, method = RequestMethod.POST)
//    public String saveJeu(Model model, //
//    			@RequestBody Jeu jeu) {
//    	System.out.println("Jeu" + jeu);
//        String titre = jeu.getTitre();
//        String description = jeu.getDescription();
//        String theme = jeu.getTheme();
//        int joueurMin = jeu.getJoueurMin();
//        int joueurMax = jeu.getJoueurMax();
//        int exemplaireCatalogue = jeu.getExemplaireCatalogue();
//        int exemplaireDispo = jeu.getExemplaireDispo();
//        Set<Mecanique> mecanique = jeu.getMecanique();
//        
//        Jeu newJeu = new Jeu();
//        jeuRepository.save(newJeu);
// 
//            return "redirect:/catalogue";
//        }    
    
//	@PostMapping("/gestionCatalogue")
//	public Jeu createJeu(@RequestBody Jeu jeu) {
//		return jeuRepository.save(jeu);
//	}
	
//	@PutMapping("/gestionCatalogue/{id}")
//	public Jeu updateJeu(@PathVariable Long id,
//						@Valid @RequestBody Jeu jeuRequest) {
//		return jeuRepository.findById(id)
//				.map(jeu -> {
//					jeu.setTitre(jeuRequest.getTitre());
//					jeu.setDescription(jeuRequest.getDescription());
//					jeu.setTheme(jeuRequest.getTheme());
//					jeu.setJoueurMin(jeuRequest.getJoueurMin());
//					jeu.setJoueurMax(jeuRequest.getJoueurMax());
//					jeu.setExemplaireCatalogue(jeuRequest.getExemplaireCatalogue());
//					jeu.setExemplaireDispo(jeuRequest.getExemplaireDispo());
//					jeu.setMecanique(jeuRequest.getMecanique());
//					return jeuRepository.save(jeu);
//				}).orElseThrow(() -> new ResourceNotFoundException("Jeu inconnu avec l'id " + id));
//	}
    
//    @PutMapping("/gestionCatalogue/{id}")
//    public String modifJeu(@PathVariable(value = "id") Long id,
//                       @Valid @RequestBody Jeu jeu) {
//
//        Optional<Jeu> ancienneVersion = jeuRepository.findById(id);
//        if (ancienneVersion.isPresent()) {
//            Jeu nouvelleVersion = ancienneVersion.get();
//            if (jeu.getTitre() != null) {
//            	nouvelleVersion.setTitre(jeu.getTitre());
//            }
//            if (jeu.getDescription() != null) {
//            	nouvelleVersion.setDescription(jeu.getDescription());
//            }
//            if (jeu.getTheme() != null) {
//            	nouvelleVersion.setTheme(jeu.getTheme());
//            }
//            if (jeu.getJoueurMin() != null) {
//            	nouvelleVersion.setJoueurMin(jeu.getJoueurMin());
//            }
//            if (jeu.getJoueurMax() != null) {
//            	nouvelleVersion.setJoueurMax(jeu.getJoueurMax());
//            }
//            if (jeu.getExemplaireCatalogue() != null) {
//            	nouvelleVersion.setExemplaireCatalogue(jeu.getExemplaireCatalogue());
//            }
//            if (jeu.getExemplaireDispo() != null) {
//            	nouvelleVersion.setExemplaireDispo(jeu.getExemplaireDispo());
//            }
//             jeuRepository.save(nouvelleVersion);
//        }
//        
//        return "redirect:/catalogue";
//    }
    
    @RequestMapping(value={"/gestionCatalogue","/gestionCatalogue/modif/{id}"}, method = RequestMethod.GET)
    public String modifJeuForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("jeu", jeuRepository.findById(id));
        } else {
            model.addAttribute("jeu", new Jeu());
        }
        return "gestionCatalogue";
    }

    @RequestMapping(value="/gestionCatalogue", method = RequestMethod.POST)
    public String modifJeu(Model model, Jeu jeu) {
    	System.out.println("quoi dans jeu " + jeu.getId());
        jeuRepository.save(jeu);
        model.addAttribute("catalogue", jeuRepository.findAll());
        return "redirect:/catalogue";
    }
	
    @RequestMapping(value="/supprimeJeu/{id}", method = RequestMethod.GET)
    public String deleteJeu(Model model, @PathVariable(required = true, name = "id") Long id) {
        jeuRepository.deleteById(id);
        model.addAttribute("getJeuxPage", jeuRepository.findAll());
        return "redirect:/catalogue";
    }
    
//    @RequestMapping(value = { "/gestionCatalogue" }, method = RequestMethod.GET)
//    public String showCreaJeuPage(Model model) {
// 
//        Jeu jeu = new Jeu();
//        model.addAttribute("jeu", jeu);
//        model.addAttribute("mecaniquesEnum", MecaniqueEnum.values());
//        return "gestionCatalogue";
//    }
//    
//    @RequestMapping(value="/gestionCatalogue")
//    public String saveJeu(
//            final Jeu jeu, final BindingResult bindingResult, final ModelMap model) {
//        if (bindingResult.hasErrors()) {
//            return "gestionCatalogue";
//        }
//        this.jeuRepository.save(jeu);
//        model.clear();
//        return "redirect:/catalogue";
//    }  

}
