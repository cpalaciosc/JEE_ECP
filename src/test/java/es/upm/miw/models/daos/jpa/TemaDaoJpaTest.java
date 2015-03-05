package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.AfterClass;
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
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.tema = new Tema(1, "Tema1", "Pregunta1");
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
    }

    @Test
    public void testRead() {
        assertEquals(tema, dao.read(tema.getId()));
    }

    @Test
    public void testUpdate() {
        this.tema.setPregunta("Pregunta2");
        dao.update(this.tema);
        assertEquals(tema.getPregunta(), dao.read(tema.getId()).getPregunta());
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
    }

    @Test
    public void testFindAll() {
        dao.create(new Tema(2, "Tema2", "Pregunta2"));
        dao.create(new Tema(3, "Tema3", "Pregunta3"));
        assertEquals(3, dao.findAll().size());
    }

    @After
    public void after() {
        LogManager.getLogger(TemaDaoJpaTest.class).debug(
                "Vaciando la base de datos antes de salir - drop and create tables");
        DaoJpaFactory.dropAndCreateTables();
    }

}
