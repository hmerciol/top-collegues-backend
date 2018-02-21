package dev.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Collegue collegue;
	private String avis;
	private int score;
	
	/**
	 * 
	 */
	public Vote() {
		super();
	}

	/**
	 * @param collegue
	 * @param avis
	 */
	public Vote(Collegue collegue, String avis, int score) {
		super();
		this.collegue = collegue;
		this.avis = avis;
		this.score = score;
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
	 * Getter for the avis
	 * @return the avis
	 */
	public String getAvis() {
		return avis;
	}

	/**
	 * Setter for the avis
	 * @param avis the avis to set
	 */
	public void setAvis(String avis) {
		this.avis = avis;
	}

	/**
	 * Getter for the score
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter for the score
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
