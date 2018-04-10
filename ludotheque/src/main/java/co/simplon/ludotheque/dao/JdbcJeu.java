package co.simplon.ludotheque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import co.simplon.ludotheque.model.Jeu;

@Service
public class JdbcJeu implements JeuDao {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private DataSource datasource;
	/**
	 * Constructeur
	 * 
	 * @param jdbcTemplate : le jdbcTemplate est connecté à la base de données grâce à Spring
	 */
	@Autowired
	public JdbcJeu(JdbcTemplate jdbcTemplate) {
		this.datasource = jdbcTemplate.getDataSource();
	}
	
	// Méthode pour afficher tous les jeux
	public List<Jeu> listJeux() throws Exception {
		// voir si cette déclaration de Jeu pose problème
		Jeu jeu;
		String sql;
		ArrayList<Jeu> aLlistOfJeux = new ArrayList<>();
		
		// préparation de la requête SQL
		sql = "SELECT *\n" + "FROM jeu\n";
		
		try (Connection connection = this.datasource.getConnection()) {
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					//Log info
					logSQL(pstmt);
					//Parcourir les résultats de la requête
					while (rs.next()) {
						jeu = getJeuFromResultSet(rs);
						aLlistOfJeux.add(jeu);
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.error("SQL Error !:" + pstmt.toString(),e);
					throw e;
				}
			}
		}
		return aLlistOfJeux;
	}

	// Fabrication de l'objet avec toutes les infos
	private Jeu getJeuFromResultSet(ResultSet rs) throws SQLException {
		Jeu jeu = new Jeu();
		//On récupère les données par colonne
		jeu.setId_jeu(rs.getLong("id_jeu"));
		jeu.setTitre(rs.getString("titre"));
		jeu.setDescription(rs.getString("description"));
		jeu.setTheme(rs.getString("theme"));
		jeu.setGenre1(rs.getString("genre1"));
		jeu.setGenre2(rs.getString("genre2"));
		jeu.setGenre3(rs.getString("genre3"));
		jeu.setJoueur_min(rs.getInt("joueur_min"));
		jeu.setJoueur_max(rs.getInt("joueur_max"));
		jeu.setDisponible(rs.getBoolean("disponible"));
		jeu.setExemplaire_catalogue(rs.getInt("exemplaire_catalogue"));
		jeu.setExemplaire_dispo(rs.getInt("exemplaire_dispo"));
		
		return jeu;
	}
	
	//Méthode pour voir un jeu
	@Override
	public Jeu getJeu(Long id_jeu) throws Exception {
		Jeu jeu = null;
		String sql;
		
		//Préparation de la requête SQL
		sql = "SELECT *\n" +
				"FROM jeu\n" +
				"WHERE id_jeu = ?;";
		
		try (Connection connection = this.datasource.getConnection()) {
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				// injection du paramètre ci-dessous à la place du ? de la requête
				pstmt.setLong(1, id_jeu);
				
				try (ResultSet rs = pstmt.executeQuery()) {
					pstmt.setLong(1, id_jeu);
					// Log info
					logSQL(pstmt);
					// Prend en charge le résultat de la requête
					while (rs.next()) {
						jeu = getJeuFromResultSet(rs);
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.error("SQL Error !:" + pstmt.toString(), e);
					throw e;
				}
			}
		}
		return jeu;
	}
	
	//Pour ajouter un jeu
	@Override
	public Jeu addJeu(Jeu jeu) throws Exception {
		PreparedStatement pstmt = null;
		Jeu result = null;
		try {
			// Préparation de la requête SQL
			String sql = "INSERT INTO jeu (titre, description, theme, genre1, genre2, genre3, joueur_min, joueur_max, disponible, exemplaire_catalogue, exemplaire_disponible) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = datasource.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// injection des paramètres ci-dessous en remplacement des ? de la requête
			pstmt.setString(1, jeu.getTitre());
			pstmt.setString(2, jeu.getDescription());
			pstmt.setString(3, jeu.getTheme());
			pstmt.setString(4, jeu.getGenre1());
			pstmt.setString(5, jeu.getGenre2());
			pstmt.setString(6, jeu.getGenre3());
			pstmt.setInt(7, jeu.getJoueur_min());
			pstmt.setInt(8, jeu.getJoueur_max());
			pstmt.setBoolean(9, jeu.isDisponible());
			pstmt.setInt(10, jeu.getExemplaire_catalogue());
			pstmt.setInt(11, jeu.getExemplaire_dispo());
			
			//Log info
			logSQL(pstmt);
			
			// Lance la requête de mise à jour
			pstmt.executeUpdate();
			
			//Récupération de l'ID généré et màj de l'acteur et date de modif
			ResultSet rs = pstmt.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQL Error !:" + pstmt.toString(), e);
			throw e;
		} finally {
			pstmt.close();
		}
		return result;
	}

	@Override
	public Jeu updateJeu(Jeu jeu) throws Exception {
		
		return null;
	}

	// Méthode pour effacer un jeu
	@Override
	public void deleteJeu(Long id_jeu) throws Exception {
		String sql;
		sql = "DELETE FROM jeu WHERE id_jeu = ?";
		
		try (Connection connection = this.datasource.getConnection()) {
			
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setLong(1, id_jeu);
			
			try {
				int rs = pstmt.executeUpdate();
				pstmt.setLong(1, id_jeu);
				
				//Log info
				logSQL(pstmt);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.error("SQL Error !:" + pstmt.toString(), e);
				throw e;
			}
		}

	  }
	}
	
	//Méthode pour les logs
	private void logSQL (PreparedStatement pstmt) {
		String sql;
		
		if (pstmt == null)
			return;
		
		sql = pstmt.toString().substring(":".indexOf(pstmt.toString()) + 2);
		log.debug(sql);
	}

}
