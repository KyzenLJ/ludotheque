package co.simplon.ludotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ludotheque.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
