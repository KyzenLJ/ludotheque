package co.simplon.ludotheque.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.simplon.ludotheque.model.Jeu;
import co.simplon.ludotheque.repository.JeuRepository;
import co.simplon.ludotheque.service.JeuService;

@Service
@Primary
public class JeuServiceJpaImpl implements JeuService {

	@Autowired
	private JeuRepository jeuRepo;
	
	@Override
	public List<Jeu> findAll() {
		return this.jeuRepo.findAll();
	}

//	@Override
//	public Jeu findById(Long id) {
//		return this.jeuRepo.findById(id);
//	}
	@Override
	public Jeu findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Jeu create(Jeu jeu) {
		return this.jeuRepo.save(jeu);
	}

	@Override
	public Jeu edit(Jeu jeu) {
		return this.jeuRepo.save(jeu);
	}

	@Override
	public void deleteById(Long id) {
		this.jeuRepo.deleteById(id);
		
	}


}
