package co.simplon.ludotheque.service;

import java.util.Set;

import co.simplon.ludotheque.model.Resa;

public interface ResaService {
	
	Set<Resa> findAll();
	Set<Resa> findLatest();
	Resa findById (Long id);
	void deleteById (Long id);
	
}
