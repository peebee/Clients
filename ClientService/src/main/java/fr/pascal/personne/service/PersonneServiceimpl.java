package fr.pascal.personne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pascal.personne.dao.PersonneDao;
import fr.pascal.personne.entity.Personne;

/**
 * Implémentation du service Personne 
 * 
 * 
 * @author pascal.bousquet
 */
@Service("personneService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class PersonneServiceimpl implements PersonneService {

	@Autowired
	private PersonneDao personneDao; 
	
	@Override
	@Transactional(readOnly = false)
	public void ajouter(Personne personne) {
		personneDao.create(personne);
	}

}
