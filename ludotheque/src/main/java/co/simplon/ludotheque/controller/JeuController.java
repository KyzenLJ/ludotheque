package co.simplon.ludotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import co.simplon.ludotheque.model.Jeu;
import co.simplon.ludotheque.service.JeuService;

@Controller
public class JeuController {
	

	
	@Autowired
	private JeuService jeuService;
	
	@GetMapping("/catalogue")
	public String getJeuxPage (Model model) {
		model.addAttribute("jeuxFirstPage", jeuService.findAll(PageRequest.of(0,20)));
		return "catalogue";
	}	
	
    
    @RequestMapping(value={"/gestionCatalogue","/gestionCatalogue/modif/{id}"}, method = RequestMethod.GET)
    public String modifJeuForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("jeu", jeuService.findById(id));
        } else {
            model.addAttribute("jeu", new Jeu());
        }
        return "gestionCatalogue";
    }

    @RequestMapping(value="/gestionCatalogue", method = RequestMethod.POST)
    public String modifJeu(Model model, Jeu jeu) {
    	jeuService.save(jeu);
        model.addAttribute("catalogue", jeuService.findAll());
        return "redirect:/catalogue";
    }
	
    @RequestMapping(value="/supprimeJeu/{id}", method = RequestMethod.GET)
    public String deleteJeu(Model model, @PathVariable(required = true, name = "id") Long id) {
    	jeuService.deleteById(id);
        model.addAttribute("getJeuxPage", jeuService.findAll());
        return "redirect:/catalogue";
    }
    

}
