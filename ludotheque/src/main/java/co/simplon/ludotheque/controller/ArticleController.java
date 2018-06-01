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
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ludotheque.exception.ResourceNotFoundException;
import co.simplon.ludotheque.model.Article;
import co.simplon.ludotheque.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/index")
	public String getArticlesPage (Model model) {
		model.addAttribute("articlesFirstPage", articleRepository.findAll(PageRequest.of(0, 10)));
		return "index";
	}
	
	@PostMapping("/index")
	public Article createArticle(@Valid @RequestBody Article article) {
		return articleRepository.save(article);
	}
	
	@PutMapping("/index/details/{articleId}")
	public Article updateArticle(@PathVariable Long articleId,
								@Valid @RequestBody Article articleRequest) {
		return articleRepository.findById(articleId)
				.map(article -> {
					article.setTitre(articleRequest.getTitre());
					article.setTexte(articleRequest.getTexte());
					article.setDate(articleRequest.getDate());
					return articleRepository.save(article);
				}).orElseThrow(() -> new ResourceNotFoundException("Article inconnu pour l'id " + articleId));
	}
	
	@DeleteMapping("/index/{articleId}")
	public ResponseEntity<?> deleteArticle(@PathVariable Long articleId) {
		return articleRepository.findById(articleId)
				.map(article -> {
					articleRepository.delete(article);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Article inconnu pour l'id " + articleId));
	}
}
