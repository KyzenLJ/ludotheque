package co.simplon.ludotheque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import co.simplon.ludotheque.model.Jeu;
import co.simplon.ludotheque.repository.JeuRepository;
import exception.ResourceNotFoundException;

@RestController
public class JeuController {
	
	@Autowired
	private JeuRepository jeuRepository;
	
	@GetMapping("/catalogue")
	public Page<Jeu> getJeux (Pageable pageable) {
		return jeuRepository.findAll(pageable);
	}
	
	@PostMapping("/gestionCatalogue")
	public Jeu createJeu(@Valid @RequestBody Jeu jeu) {
		return jeuRepository.save(jeu);
	}
	
	@PutMapping("/gestionCatalogue/{jeuId}")
	public Jeu updateJeu(@PathVariable Long jeuId,
						@Valid @RequestBody Jeu jeuRequest) {
		return jeuRepository.findById(jeuId)
				.map(jeu -> {
					jeu.setTitre(jeuRequest.getTitre());
					jeu.setDescription(jeuRequest.getDescription());
					jeu.setTheme(jeuRequest.getTheme());
					jeu.setJoueur_min(jeuRequest.getJoueur_min());
					jeu.setJoueur_max(jeuRequest.getJoueur_max());
					jeu.setDisponible(jeuRequest.isDisponible());
					jeu.setExemplaire_catalogue(jeuRequest.getExemplaire_catalogue());
					jeu.setExemplaire_dispo(jeuRequest.getExemplaire_dispo());
					jeu.setMecanique(jeuRequest.getMecanique());
					return jeuRepository.save(jeu);
				}).orElseThrow(() -> new ResourceNotFoundException("Jeu inconnu avec l'id " + jeuId));
	}
	
	@DeleteMapping("/gestionCatalogue/{jeuId}")
	public ResponseEntity<?> deleteJeu(@PathVariable Long jeuId) {
		return jeuRepository.findById(jeuId)
				.map(jeu -> {
					jeuRepository.delete(jeu);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Jeu inconnu avec l'id " + jeuId));
	}

}
