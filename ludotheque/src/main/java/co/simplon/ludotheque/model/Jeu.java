package co.simplon.ludotheque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="jeu")
public class Jeu extends AuditModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String titre;
	@Size(max=500)
	private String description;
	@Size(max=100)
	private String theme;
	private int joueur_min;
	private int joueur_max;
	private boolean disponible;
	@Column( nullable=false)
	private int exemplaire_catalogue;
	@Column( nullable=false)
	private int exemplaire_dispo;
	
//	@OneToMany(cascade = CascadeType.ALL,
//	       fetch = FetchType.LAZY,
//	       mappedBy = "jeu")
//	private Set<Mecanique> mecanique = new HashSet<>();

	public Jeu() {
		}
	
	public Jeu(Long id, String titre, String description, String theme, int joueur_min, int joueur_max,
			boolean disponible, int exemplaire_catalogue, int exemplaire_dispo, Set<Mecanique> mecanique) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.theme = theme;
		this.joueur_min = joueur_min;
		this.joueur_max = joueur_max;
		this.disponible = disponible;
		this.exemplaire_catalogue = exemplaire_catalogue;
		this.exemplaire_dispo = exemplaire_dispo;
		this.mecanique = mecanique;
	}
	
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "jeu_mecanique",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "mecanique_id")
        )
    private Set<Mecanique> mecanique = new HashSet<>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getJoueur_min() {
		return joueur_min;
	}

	public void setJoueur_min(int joueur_min) {
		this.joueur_min = joueur_min;
	}

	public int getJoueur_max() {
		return joueur_max;
	}

	public void setJoueur_max(int joueur_max) {
		this.joueur_max = joueur_max;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getExemplaire_catalogue() {
		return exemplaire_catalogue;
	}

	public void setExemplaire_catalogue(int exemplaire_catalogue) {
		this.exemplaire_catalogue = exemplaire_catalogue;
	}

	public int getExemplaire_dispo() {
		return exemplaire_dispo;
	}

	public void setExemplaire_dispo(int exemplaire_dispo) {
		this.exemplaire_dispo = exemplaire_dispo;
	}

	public Set<Mecanique> getMecanique() {
		return mecanique;
	}

	public void setMecanique(Set<Mecanique> mecanique) {
		this.mecanique = mecanique;
	}
	
    public void addMecanique(Mecanique mecanique) {
        ((Set<Mecanique>) mecanique).add(mecanique);
        mecanique.getJeu().add(this);
    }
 
    public void removeMecanique(Mecanique mecanique) {
        ((Set<Mecanique>) mecanique).remove(mecanique);
        mecanique.getJeu().remove(this);
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jeu)) return false;
        return id != null && id.equals(((Jeu) o).id);
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
	

}
