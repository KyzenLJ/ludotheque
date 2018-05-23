package co.simplon.ludotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ludotheque.model.Jeu;

@Repository
public interface JeuRepository extends JpaRepository<Jeu, Long> {

}
