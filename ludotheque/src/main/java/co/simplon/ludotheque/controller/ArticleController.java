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
import co.simplon.ludotheque.exception.ResourceNotFoundException;
import co.simplon.ludotheque.model.Article;
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
	
	@PostMapping("/index")
	public Article createArticle(@Valid @RequestBody Article article) {
		return articleService.save(article);
	}
	
	@PutMapping("/index/details/{articleId}")
	public Article updateArticle(@PathVariable Long articleId,
								@Valid @RequestBody Article articleRequest) {
		return articleService.findById(articleId)
				.map(article -> {
					article.setTitre(articleRequest.getTitre());
					article.setTexte(articleRequest.getTexte());
					article.setDate(articleRequest.getDate());
					return articleService.save(article);
				}).orElseThrow(() -> new ResourceNotFoundException("Article inconnu pour l'id " + articleId));
	}
	
	@DeleteMapping("/index/{articleId}")
	public ResponseEntity<?> deleteArticle(@PathVariable Long articleId) {
		return articleService.findById(articleId)
				.map(article -> {
					articleService.delete(article);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Article inconnu pour l'id " + articleId));
	}
}
