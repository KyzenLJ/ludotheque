package co.simplon.ludotheque.dao;

import java.util.List;

import co.simplon.ludotheque.model.Resa;

public interface ResaDao {

	// methode à utiliser dans l'implementation de JDBCResa
	public List<Resa> listResas() throws Exception;
	
	public Resa getResa(Long id_resa) throws Exception;
	
	public Resa addResa(Resa resa) throws Exception;
	
	public Resa updateResa(Resa resa) throws Exception;
	
	public void deleteResa(Long id_resa) throws Exception;
}
