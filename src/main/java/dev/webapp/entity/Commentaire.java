package dev.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Collegue collegue;
	private String comment;
	
	/**
	 * 
	 */
	public Commentaire() {
		super();
	}

	/**
	 * @param collegue
	 * @param commentaire
	 */
	public Commentaire(Collegue collegue, String commentaire) {
		super();
		this.collegue = collegue;
		this.comment = commentaire;
	}

	/**
	 * Getter for the id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter for the id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter for the collegue
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * Setter for the collegue
	 * @param collegue the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	/**
	 * Getter for the commentaire
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return comment;
	}

	/**
	 * Setter for the commentaire
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.comment = commentaire;
	}

}
