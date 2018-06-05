package co.simplon.ludotheque.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String titre;
	@NotBlank
	@Column(length=10000)
	private String texte;
	private Date date = new Date();
	
	public Article() {
		
	}
	
	public Article(Long id, @NotBlank String titre, @NotBlank @Size(max = 2000) String texte, Date date) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.date = date;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", texte=" + texte + ", date=" + date + "]";
	}
	
}
