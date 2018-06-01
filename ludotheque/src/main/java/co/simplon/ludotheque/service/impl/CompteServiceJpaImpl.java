package co.simplon.ludotheque.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import co.simplon.ludotheque.model.Compte;
import co.simplon.ludotheque.repository.CompteRepository;
import co.simplon.ludotheque.service.CompteService;

public class CompteServiceJpaImpl implements CompteService{
	
	@Autowired
	private CompteRepository compteRepo;

	@Override
	public List<Compte> findAll() {
		return this.compteRepo.findAll();
	}

	@Override
	public Compte findById(Long id) {
		return null;
	}

	@Override
	public Compte create(Compte compte) {
		return this.compteRepo.save(compte);
	}

	@Override
	public Compte edit(Compte compte) {
		return this.compteRepo.save(compte);
	}

	@Override
	public void deleteById(Long id) {
		this.compteRepo.deleteById(id);
		
	}

}
