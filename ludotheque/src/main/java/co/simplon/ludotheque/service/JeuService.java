package co.simplon.ludotheque.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.simplon.ludotheque.model.Jeu;

public interface JeuService {

	List<Jeu> findAll();
	Jeu findById (Long id);
	Jeu edit (Jeu jeu);
	void deleteById (Long id);
	Jeu create(Jeu jeu);
	Page<Jeu> jeuList(Pageable pageable);
}
