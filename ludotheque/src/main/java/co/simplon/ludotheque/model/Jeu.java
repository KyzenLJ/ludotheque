package co.simplon.ludotheque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@Column(name="joueur_min")
	private int joueurMin;
	@Column(name="joueur_max")
	private int joueurMax;
	@Column( name="exemplaire_catalogue", nullable=false)
	private int exemplaireCatalogue;
	@Column( name="exemplaire_dispo", nullable=false)
	private int exemplaireDispo;
	
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "jeu_mecanique",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "mecanique_id")
        )
    private Set<Mecanique> mecanique = new HashSet<>();
    
    
	public Jeu() {
		}
	
	public Jeu(Long id, String titre, String description, String theme, int joueurMin, int joueurMax,
			 int exemplaireCatalogue, int exemplaireDispo, Set<Mecanique> mecanique) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.theme = theme;
		this.joueurMin = joueurMin;
		this.joueurMax = joueurMax;
		this.exemplaireCatalogue = exemplaireCatalogue;
		this.exemplaireDispo = exemplaireDispo;
		this.mecanique = mecanique;
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

	public int getJoueurMin() {
		return joueurMin;
	}

	public void setJoueurMin(int joueurMin) {
		this.joueurMin = joueurMin;
	}

	public int getJoueurMax() {
		return joueurMax;
	}

	public void setJoueurMax(int joueurMax) {
		this.joueurMax = joueurMax;
	}

	public int getExemplaireCatalogue() {
		return exemplaireCatalogue;
	}

	public void setExemplaireCatalogue(int exemplaireCatalogue) {
		this.exemplaireCatalogue = exemplaireCatalogue;
	}

	public int getExemplaireDispo() {
		return exemplaireDispo;
	}

	public void setExemplaireDispo(int exemplaireDispo) {
		this.exemplaireDispo = exemplaireDispo;
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
