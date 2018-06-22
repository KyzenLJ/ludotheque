package co.simplon.ludotheque.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.ludotheque.model.Jeu;

@Repository
public interface JeuRepository extends JpaRepository<Jeu, Long> {
	@Query("SELECT j FROM Jeu j ORDER BY j.titre ASC")
	Page<Jeu> findAll(Pageable pageable);
}

