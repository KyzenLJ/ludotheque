package co.simplon.ludotheque.dao;

import java.util.List;

import co.simplon.ludotheque.model.Resa;

public interface ResaDao {

	// methode à utiliser dans l'implementation de JDBCResa
	public List<Resa> listResas() throws Exception;
	
	public Resa get(Long id_resa) throws Exception;
	
	public Resa add(Resa resa) throws Exception;
	
	public Resa update(Resa resa) throws Exception;
	
	public void delete(Long id_resa) throws Exception;
}
