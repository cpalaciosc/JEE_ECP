package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudio;

public class VotacionDaoJpaTest {
    private VotacionDao dao;

    private Votacion votacion;

    final static Class<VotacionDaoJpaTest> clazz = VotacionDaoJpaTest.class;

    @BeforeClass
    public static void beforeClass() {
        LogManager.getLogger(clazz).debug(
                "Vaciando la base de datos antes de empezar - drop and create tables");
        DaoFactory.setFactory(new DaoJpaFactory());
    }

    @Before
    public void before() {
        LogManager.getLogger(clazz).debug("Inicio de before()");
        DaoFactory.getFactory().getTemaDao().deleteAll();  
        this.votacion = new Votacion(1, "255.255.255.255", new Tema(1, "Tema1", "Pregunta1"), 1,
                NivelEstudio.DOCTORADO);
        dao = DaoFactory.getFactory().getVotacionDao();
        dao.create(votacion);
        LogManager.getLogger(clazz).debug("Fin de before()");
    }

    @Test
    public void testRead() {
        LogManager.getLogger(clazz).debug("Inicio de testRead()");
        assertEquals(votacion, dao.read(votacion.getId()));
        LogManager.getLogger(clazz).debug("Fin de testRead()");
    }

    @Test
    public void testUpdate() {
        LogManager.getLogger(clazz).debug("Inicio de testUpdate()");
        this.votacion.setNivelEstudio(NivelEstudio.GRADO);
        dao.update(this.votacion);
        assertEquals(votacion.getNivelEstudio(), dao.read(votacion.getId()).getNivelEstudio());
        LogManager.getLogger(clazz).debug("Fin de testUpdate()");
    }

    @Test
    public void testDeleteByID() {
        LogManager.getLogger(clazz).debug("Inicio de testDeleteByID()");
        dao.deleteById(votacion.getId());
        assertNull(dao.read(votacion.getId()));
        LogManager.getLogger(clazz).debug("Fin de testDeleteByID()");
    }

    @Test
    public void testFindAll() {
        LogManager.getLogger(clazz).debug("Inicio de testFindAll()");
        Tema tema = new Tema(1, "Tema1", "Pregunta1");
        dao.create(new Votacion(2, "255.255.255.255", tema, 2, NivelEstudio.GRADO));
        dao.create(new Votacion(3, "255.255.255.255", tema, 3, NivelEstudio.PRIMARIA));
        assertEquals(3, dao.findAll().size());
        LogManager.getLogger(clazz).debug("Fin de testFindAll()");
    }

    @After
    public void after() {
        LogManager.getLogger(clazz).debug("Limpiando tablas afectadas");
        dao.deleteAll();
    }

}
