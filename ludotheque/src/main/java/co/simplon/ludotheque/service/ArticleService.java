package co.simplon.ludotheque.service;

import java.util.List;
import co.simplon.ludotheque.model.Article;

public interface ArticleService {

	List<Article> findAll();
	Article findById(Long id);
	Article create(Article article);
	Article edit(Article article);
	void deleteById(Long id);
}
