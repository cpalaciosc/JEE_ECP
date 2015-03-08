package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.entities.Tema;

public class TemaDaoJpaTest {
    private TemaDao dao;

    private Tema tema;
    
    @BeforeClass
    public static void beforeClass() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug(
                "Vaciando la base de datos antes de empezar - drop and create tables");
        DaoFactory.setFactory(new DaoJpaFactory());
    }

    @Before
    public void before() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Inicio de before()");      
        this.tema = new Tema(1, "Tema1", "Pregunta1");
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Fin de before()");     
    }

    @Test
    public void testRead() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Inicio de testRead()");
        assertEquals(tema, dao.read(tema.getId()));
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Fin de testRead()");
    }

    @Test
    public void testUpdate() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Inicio de testUpdate()");
        this.tema.setPregunta("Pregunta2");
        dao.update(this.tema);
        assertEquals(tema.getPregunta(), dao.read(tema.getId()).getPregunta());
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Fin de testUpdate()");
    }

    @Test
    public void testDeleteByID() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Inicio de testDeleteByID()");
        dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Fin de testDeleteByID()");
    }

    @Test
    public void testFindAll() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Inicio de testFindAll()");
        dao.create(new Tema(2, "Tema2", "Pregunta2"));
        dao.create(new Tema(3, "Tema3", "Pregunta3"));
        assertEquals(3, dao.findAll().size());
        LogManager.getLogger(TemaDaoJpaTest.class).debug("Fin de testFindAll()");
    }

    
    @After
    public void after() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug(
                "Limpiando tablas afectadas");
        dao.deleteAll();
    }
    
}
