package fr.pascal.personne.service;

import fr.pascal.personne.entity.Personne;
/**
 * Service Métier gérant la personne
 * 
 * 
 * @author pascal.bousquet
 */
public interface PersonneService {
	/**
	 *  Ajoute une personne
	 *  
	 *  @param personne
	 */
	public void ajouter(Personne personne);

}
