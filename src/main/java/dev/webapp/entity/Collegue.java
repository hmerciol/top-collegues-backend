package dev.webapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collegue {

	@Id
	private String pseudo;
	private int score;
	private String imageUrl;

	/**
	 * Getter for the score
	 * 
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter for the score
	 * 
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Getter for the pseudo
	 * 
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Setter for the pseudo
	 * 
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Getter for the imageUrl
	 * 
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Setter for the imageUrl
	 * 
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
