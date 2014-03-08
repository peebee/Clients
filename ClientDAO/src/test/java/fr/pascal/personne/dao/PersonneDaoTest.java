package fr.pascal.personne.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.pascal.personne.entity.Personne;
import fr.pascal.personne.entity.Genre;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"context.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
public class PersonneDaoTest extends
        AbstractTransactionalJUnit4SpringContextTests {

    final Logger logger = LoggerFactory.getLogger(PersonneDao.class);

    @Autowired
    protected PersonneDao personneDao;

    @BeforeClass
    public static void setUppersass() throws Exception {
    }

    @AfterClass
    public static void tearDownpersass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testFindById() {
        Personne pers1, pers2;
		/*
		 * Element existant
		 */
        pers1 = personneDao.findbyId(0L);
        assertNotNull(pers1);
		/*
		 * Element inexistant
		 */
        pers2 = personneDao.findbyId(2L);
        assertNull(pers2);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCreate() {
        Personne pers,pers1;
        pers = new Personne();
        pers.setGenre(Genre.Femme);
        pers.setNom_naissance("Martin");
        pers.setNom_usage("Dupond");
        pers.setPrenom("Anne");
        GregorianCalendar gc = new GregorianCalendar(1920, 12, 30);
        pers.setDt_naissance(gc.getTime());
        personneDao.create(pers);
        logger.info(pers.toString());
		/*
		 * Si la personne est dans la base elle à un ID
		 */
        assertNotNull(pers.getId());

    }
}
