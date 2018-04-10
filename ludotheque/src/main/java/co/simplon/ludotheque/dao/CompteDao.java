package co.simplon.ludotheque.dao;

import java.util.List;

import co.simplon.ludotheque.model.Compte;

public interface CompteDao {
	// methode à utiliser dans l'implementation de JDBCCompte
	public List<Compte> listComptes() throws Exception;
	
	public Compte getCompte(Long id_compte) throws Exception;
	
	public Compte addCompte(Compte compte) throws Exception;
	
	public Compte updateCompte(Compte compte) throws Exception;
	
	public void deleteCompte(Long id_compte) throws Exception;
}

