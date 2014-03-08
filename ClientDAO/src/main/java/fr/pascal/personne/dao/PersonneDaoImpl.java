package fr.pascal.personne.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.pascal.personne.entity.Personne;

/**
 * Implémentation du DAO Pour la classe des personnes .
 * 
 * 
 * @author pascal.bousquet
 */
@Repository
public class PersonneDaoImpl implements PersonneDao {

	final Logger logger = LoggerFactory.getLogger(PersonneDao.class);

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em = null;

	/**
	 * {@inheritDoc}
	 */
	public void create(Personne personne) {
		try {
			em.persist(personne);
		} catch (Exception e) {
			logger.error("l'enregistrement a échoué", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Personne findbyId(Long id) {
		try {
			Personne personne = em.find(Personne.class, id);
			return personne;
		} catch (Exception e) {
			logger.error("Personne non trouvé", e);
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(Personne personne) {
		em.remove(personne);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Personne> readbyNom(String nomUsage) {
		try {
			List<Personne> personnes = em
					.createQuery(
							"SELECT c FROM personne c WHERE c.nom_usage LIKE :nomUsage",
							Personne.class).setParameter("nomUsage", nomUsage)
					.setMaxResults(10).getResultList();
			return personnes;
		} catch (Exception e) {
			logger.error("Personne non trouvé", e);
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deletebyId(Long id) {
		em.remove(this.findbyId(id));
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(Personne personne) {
		
		try {
			em.merge(personne);
		} catch (Exception e) {
			logger.error("personne non trouvé", e);
		}
		
	}

}
