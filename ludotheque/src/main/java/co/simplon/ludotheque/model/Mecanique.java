package co.simplon.ludotheque.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import co.simplon.ludotheque.Enum.MecaniqueEnum;

@Entity
@Table(name="mecanique")
public class Mecanique extends AuditModel {

	@Id
	@GeneratedValue
	private Long id;
	@NaturalId
	private MecaniqueEnum typeMecanique;
	
	@ManyToMany(mappedBy = "mecanique")
//	@OneToMany(cascade = CascadeType.ALL,
//	   fetch = FetchType.LAZY,
//	   mappedBy = "mecanique")
	private Set<Jeu> jeu = new HashSet<>();
	
	public Mecanique() {
	}

	public Mecanique(Long id, MecaniqueEnum typeMecanique, Set<Jeu> jeu) {
		super();
		this.id = id;
		this.typeMecanique = typeMecanique;
		this.jeu = jeu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MecaniqueEnum getTypeMecanique() {
		return typeMecanique;
	}

	public void setTypeMecanique(MecaniqueEnum typeMecanique) {
		this.typeMecanique = typeMecanique;
	}

	public Set<Jeu> getJeu() {
		return jeu;
	}

	public void setJeu(Set<Jeu> jeu) {
		this.jeu = jeu;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mecanique mecanique = (Mecanique) o;
        return Objects.equals(typeMecanique, mecanique.typeMecanique);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(typeMecanique);
    }
	
	
}
	
