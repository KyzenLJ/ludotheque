package co.simplon.ludotheque.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.ludotheque.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	@Query("SELECT a FROM Article a ORDER BY a.date DESC")
	Page<Article> findAll(Pageable pageable);
}
