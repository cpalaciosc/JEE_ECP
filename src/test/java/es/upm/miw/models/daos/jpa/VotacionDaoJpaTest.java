package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudio;

public class VotacionDaoJpaTest {
    private IVotacionDao votacionDao;

    private ITemaDao temaDao;

    private Votacion votacion;

    private Tema tema;

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
        temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.deleteAll();
        tema = new Tema("Tema1", "Pregunta1");
        temaDao.create(tema);
        votacion = new Votacion(1, "255.255.255.255", tema, 1, NivelEstudio.DOCTORADO);
        votacionDao = DaoFactory.getFactory().getVotacionDao();
        votacionDao.create(votacion);
        LogManager.getLogger(clazz).debug("Fin de before()");
    }

    @Test
    public void testRead() {
        LogManager.getLogger(clazz).debug("Inicio de testRead()");
        assertEquals(votacion, votacionDao.read(votacion.getId()));
        LogManager.getLogger(clazz).debug("Fin de testRead()");
    }

    @Test
    public void testUpdate() {
        LogManager.getLogger(clazz).debug("Inicio de testUpdate()");
        this.votacion.setNivelEstudio(NivelEstudio.GRADO);
        votacionDao.update(this.votacion);
        assertEquals(votacion.getNivelEstudio(), votacionDao.read(votacion.getId())
                .getNivelEstudio());
        LogManager.getLogger(clazz).debug("Fin de testUpdate()");
    }

    @Test
    public void testDeleteByID() {
        LogManager.getLogger(clazz).debug("Inicio de testDeleteByID()");
        votacionDao.deleteById(votacion.getId());
        assertNull(votacionDao.read(votacion.getId()));
        LogManager.getLogger(clazz).debug("Fin de testDeleteByID()");
    }

    @Test
    public void testFindAll() {
        LogManager.getLogger(clazz).debug("Inicio de testFindAll()");
        votacionDao.create(new Votacion(2, "255.255.255.255", tema, 2, NivelEstudio.GRADO));
        votacionDao.create(new Votacion(3, "255.255.255.255", tema, 3, NivelEstudio.PRIMARIA));
        assertEquals(3, votacionDao.findAll().size());
        LogManager.getLogger(clazz).debug("Fin de testFindAll()");
    }

    @After
    public void after() {
        LogManager.getLogger(clazz).debug("Limpiando tablas afectadas");
        votacionDao.deleteAll();
        temaDao.deleteAll();
    }

}
