package co.simplon.ludotheque.service;

import java.util.List;
import java.util.Set;

import co.simplon.ludotheque.model.Compte;

public interface CompteService {
	
	List<Compte> findAll();
	Compte findById(Long id);
	Compte create(Compte compte);
	Compte edit(Compte compte);
	void deleteById(Long id);

}
