package dev.webapp.entity;

public class Vote {
	
	private static int compteur = 0;
	
	private Integer id;
	private Collegue collegue;
	private String avis;
	
	/**
	 * @param collegue
	 * @param avis
	 */
	public Vote(Collegue collegue, String avis) {
		super();
		this.id = ++compteur;
		this.collegue = collegue;
		this.avis = avis;
	}

	/**
	 * Getter for the collegue
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * Getter for the avis
	 * @return the avis
	 */
	public String getAvis() {
		return avis;
	}

	/**
	 * Getter for the id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
