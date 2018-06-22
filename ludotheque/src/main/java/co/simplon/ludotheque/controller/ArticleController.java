package co.simplon.ludotheque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.simplon.ludotheque.exception.ResourceNotFoundException;
import co.simplon.ludotheque.model.Article;
import co.simplon.ludotheque.model.Jeu;
import co.simplon.ludotheque.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/")
	public String getArticlesPage (Model model) {
		model.addAttribute("articlesFirstPage", articleService.findAll(PageRequest.of(0, 10)));
		return "index";
	}
	
	  @RequestMapping(value={"/creationArticle","/creationArticle/modif/{id}"}, method = RequestMethod.GET)
	    public String modifArticleForm(Model model, @PathVariable(required = false, name = "id") Long id) {
	        if (null != id) {
	            model.addAttribute("article", articleService.findById(id));
	        } else {
	            model.addAttribute("article", new Article());
	        }
	        return "creationArticle";
	    }

	    @RequestMapping(value="/creationArticle", method = RequestMethod.POST)
	    public String modifArticle(Model model, Article article) {
	    	articleService.save(article);
	        model.addAttribute("index", articleService.findAll());
	        return "redirect:/";
	    }
		
	    @RequestMapping(value="/supprimeArticle/{id}", method = RequestMethod.GET)
	    public String deleteArticle(Model model, @PathVariable(required = true, name = "id") Long id) {
	    	articleService.deleteById(id);
	        model.addAttribute("getArticlesPage", articleService.findAll());
	        return "redirect:/";
	    }
}
