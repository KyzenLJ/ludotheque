package co.simplon.ludotheque.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Resa extends AuditModel  {
	
	@Id
	@GeneratedValue
	private Long id;
	private boolean honore;
	private boolean rendu;
	private Date debutResa;
	private Date retourResaPrevu;

	public Resa() {
		}

	public Resa(Long id, boolean honore, boolean rendu, Date debutResa, Date retourResaPrevu) {
		super();
		this.id = id;
		this.honore = honore;
		this.rendu = rendu;
		this.debutResa = debutResa;
		this.retourResaPrevu = retourResaPrevu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isHonore() {
		return honore;
	}

	public void setHonore(boolean honore) {
		this.honore = honore;
	}

	public boolean isRendu() {
		return rendu;
	}

	public void setRendu(boolean rendu) {
		this.rendu = rendu;
	}
	
	public Date getDebutResa() {
		return debutResa;
	}
	
	public void setDebutResa(Date debutResa) {
		this.debutResa = debutResa;
	}
	
	public Date getRetourResaPrevu() {
		return retourResaPrevu;
	}
	
	public void setRetourResaPrevu(Date retourResaPrevu) {
		this.retourResaPrevu = retourResaPrevu;
	}
}
