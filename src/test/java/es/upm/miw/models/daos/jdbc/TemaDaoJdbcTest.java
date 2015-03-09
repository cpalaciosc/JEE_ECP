package es.upm.miw.models.daos.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.entities.Tema;

public class TemaDaoJdbcTest {

    private ITemaDao dao;

    private Tema tema;

    final static Class<TemaDaoJdbcTest> clazz = TemaDaoJdbcTest.class;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJdbcFactory());
        DaoJdbcFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        LogManager.getLogger(clazz).debug("Inicio de before()");
        this.tema = new Tema("Tema1", "Pregunta1");
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
        LogManager.getLogger(clazz).debug("Fin de before()");
    }

    @Test
    public void testRead() {
        LogManager.getLogger(clazz).debug("Inicio de testRead()");
        assertEquals(tema, dao.read(tema.getId()));
        LogManager.getLogger(clazz).debug("Fin de testRead()");
    }

    @Test
    public void testUpdate() {
        LogManager.getLogger(clazz).debug("Inicio de testUpdate()");
        this.tema.setPregunta("Pregunta2");
        dao.update(this.tema);
        assertEquals(tema.getPregunta(), dao.read(tema.getId()).getPregunta());
        LogManager.getLogger(clazz).debug("Fin de testUpdate()");
    }

    @Test
    public void testDeleteByID() {
        LogManager.getLogger(clazz).debug("Inicio de testDeleteByID()");
        dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
        LogManager.getLogger(clazz).debug("Fin de testDeleteByID()");
    }

    @Test
    public void testFindAll() {
        LogManager.getLogger(clazz).debug("Inicio de testFindAll()");
        dao.create(new Tema("Tema2", "Pregunta2"));
        dao.create(new Tema("Tema3", "Pregunta3"));
        assertEquals(3, dao.findAll().size());
        LogManager.getLogger(clazz).debug("Fin de testFindAll()");
    }

    @After
    public void after() {
        LogManager.getLogger(clazz).debug("Limpiando tablas afectadas");
        dao.deleteAll();
    }
    
}
