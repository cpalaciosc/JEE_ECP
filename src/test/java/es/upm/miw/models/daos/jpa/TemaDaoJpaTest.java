package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

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

public class TemaDaoJpaTest {
    private IVotacionDao votacionDao;

    private ITemaDao temaDao;

    private Tema tema;

    final static Class<TemaDaoJpaTest> clazz = TemaDaoJpaTest.class;

    @BeforeClass
    public static void beforeClass() {
        LogManager.getLogger(clazz).debug("Inicializando los test");
        DaoFactory.setFactory(new DaoJpaFactory());
    }

    @Before
    public void before() {
        LogManager.getLogger(clazz).debug("Inicio de before()");
        temaDao = DaoFactory.getFactory().getTemaDao();
        votacionDao = DaoFactory.getFactory().getVotacionDao();
        cleanTables();
        initTemaDataSet();
        LogManager.getLogger(clazz).debug("Fin de before()");
    }

    @Test
    public void testRead() {
        LogManager.getLogger(clazz).debug("Inicio de testRead()");
        assertEquals(this.tema, temaDao.read(tema.getId()));
        LogManager.getLogger(clazz).debug("Fin de testRead()");
    }

    @Test
    public void testUpdate() {
        LogManager.getLogger(clazz).debug("Inicio de testUpdate()");
        this.tema.setPregunta("Pregunta1 Actualizada");
        temaDao.update(tema);
        assertEquals(tema.getPregunta(), temaDao.read(tema.getId()).getPregunta());
        LogManager.getLogger(clazz).debug("Fin de testUpdate()");
    }

    @Test
    public void testDeleteByID() {
        LogManager.getLogger(clazz).debug("Inicio de testDeleteByID()");
        initVotacionDataSet();
        temaDao.deleteById(tema.getId());
        assertEquals(0, votacionDao.findAllByTema(tema).size());
        assertNull(temaDao.read(tema.getId()));
        LogManager.getLogger(clazz).debug("Fin de testDeleteByID()");
    }

    @Test
    public void testFindAll() {
        LogManager.getLogger(clazz).debug("Inicio de testFindAll()");
        temaDao.create(new Tema("Tema2", "Pregunta2"));
        temaDao.create(new Tema("Tema3", "Pregunta3"));
        assertEquals(3, temaDao.findAll().size());
        LogManager.getLogger(clazz).debug("Fin de testFindAll()");
    }

    @After
    public void after() {
        LogManager.getLogger(clazz).debug("Limpiando tablas afectadas");
        cleanTables();
    }

    private void cleanTables() {
        votacionDao.deleteAll();
        temaDao.deleteAll();
    }

    private void initTemaDataSet() {
        tema = new Tema("Tema1", "Pregunta1");
        temaDao.create(tema);
    }

    private void initVotacionDataSet() {
        List<Votacion> votaciones = new ArrayList<Votacion>();
        votaciones.add(new Votacion("255.255.255.255", tema, 5, NivelEstudio.DOCTORADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 4, NivelEstudio.DOCTORADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 8, NivelEstudio.GRADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 3, NivelEstudio.GRADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 1, NivelEstudio.MASTER));
        votaciones.add(new Votacion("255.255.255.255", tema, 6, NivelEstudio.MASTER));

        for (Votacion tmp : votaciones) {
            votacionDao.create(tmp);
        }
    }
}
