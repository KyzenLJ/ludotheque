package co.simplon.ludotheque.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.ludotheque.model.Article;
import co.simplon.ludotheque.repository.ArticleRepository;
import co.simplon.ludotheque.service.ArticleService;

@Service
public class ArticleServiceJpaImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepo;

	@Override
	public List<Article> findAll() {
		return this.articleRepo.findAll();
	}

	@Override
	public Article findById(Long id) {
		return null;
	}

	@Override
	public Article create(Article article) {
		return this.articleRepo.save(article);
	}

	@Override
	public Article edit(Article article) {
		return this.articleRepo.save(article);
	}

	@Override
	public void deleteById(Long id) {
		this.articleRepo.deleteById(id);
		
	}
	
	

}
