package fr.pascal.personne.dao;

import java.util.List;

import fr.pascal.personne.entity.Personne;
/**
 * DAO Pour la classe des personnes .
 * 
 * 
 * @author pascal.bousquet
 */
public interface PersonneDao {
	
	/**
	 * Persist Le personne dans la base
	 * 
	 * @param personne
	 */
	public void create (Personne personne);
	
	/**
	 * Modifie Le personne dans la base
	 * 
	 * @param personne
	 */
	public void update (Personne personne);
	
	/**
	 * Recherche dans la base le personne ayant cet identifiant
	 * 
	 * @param id
	 * @return le personne trouvé ou Null
	 */
	public Personne findbyId(Long id);
	
	/**
	 * Recherche dans la base, les personnes ayant ce nom
	 * 
	 * @param nomUsage
	 */
	public List<Personne> readbyNom(String nomUsage);
	
	/**
	 * Détruit l'enregistrement suivant
	 * 
	 * @param personne
	 */
	public void delete(Personne personne);
	
	/**
	 * Détruit l'enregistrement dont l'identifiant est le suisvant
	 * 
	 * @param id
	 */
	public void deletebyId(Long id);

}
