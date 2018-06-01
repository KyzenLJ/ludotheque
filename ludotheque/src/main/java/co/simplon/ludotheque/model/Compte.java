package co.simplon.ludotheque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="compte")
public class Compte extends AuditModel {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	@Size(max=50)
	private String nom;
	@Column(nullable = false)	
	@Size(max=50)
	private String prenom;
	@Column(unique = true, nullable = false)
	@Size(max=100)
	private String email;
	@Column(nullable = false)
	@Size(max=20)
	private String mdp;
	@Column(unique = true, nullable = false)
	@Size(max=20)
	private String pseudo;

	public Compte() {
		}

	public Compte(Long id_compte, String nom, String prenom, String email, String mdp, String pseudo) {
		super();
		this.id = id_compte;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.pseudo = pseudo;
	}

	public Long getId_compte() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp
				+ ", pseudo=" + pseudo + "]";
	}

}
