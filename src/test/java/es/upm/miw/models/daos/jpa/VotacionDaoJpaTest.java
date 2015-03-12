package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
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
import es.upm.miw.models.utils.ValoracionMedia;

public class VotacionDaoJpaTest {
    private IVotacionDao votacionDao;

    private ITemaDao temaDao;

    private Votacion votacion;

    private Tema tema;

    List<Votacion> votaciones;

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
        votacionDao = DaoFactory.getFactory().getVotacionDao();
        temaDao.deleteAll();
        cleanTables();
        initTema();
        initVotacion();
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
        initVotacionListDataSet();
        assertEquals(this.votaciones.size(), votacionDao.findAll().size());
        LogManager.getLogger(clazz).debug("Fin de testFindAll()");
    }

    @Test
    public void testPromedioByEstudio() {
        LogManager.getLogger(clazz).debug("Inicio de testPromedioByEstudio()");
        initVotacionListDataSet();
        List<NivelEstudio> nivelEstudioList = Arrays.asList(NivelEstudio.values());
        List<ValoracionMedia> listValoracionMedia = votacionDao.valoracionMediaByNivelEstudio(tema);
        assertEquals(nivelEstudioList.size(), listValoracionMedia.size());
        LogManager.getLogger(clazz).debug("Fin de testPromedioByEstudio()");
    }

    @Test
    public void testNumeroVotosByTema() {
        LogManager.getLogger(clazz).debug("Inicio de testNumeroVotosByTema()");
        initVotacionListDataSet();

        assertEquals(votacionDao.findAllByTema(tema).size(), votacionDao.numeroVotos(tema));
        LogManager.getLogger(clazz).debug("Fin de testNumeroVotosByTema()");
    }

    @After
    public void after() {
        LogManager.getLogger(clazz).debug("Limpiando tablas afectadas");
        votacionDao.deleteAll();
        temaDao.deleteAll();
    }

    private void cleanTables() {
        votacionDao.deleteAll();
        temaDao.deleteAll();
    }

    private void initTema() {
        tema = new Tema("Tema1", "Pregunta1");
        temaDao.create(tema);

    }

    private void initVotacion() {
        votacion = new Votacion("255.255.255.255", tema, 1, NivelEstudio.DOCTORADO);
        votacionDao.create(votacion);
    }

    private void initVotacionListDataSet() {
        votaciones = new ArrayList<Votacion>();
        votaciones.add(new Votacion("255.255.255.255", tema, 5, NivelEstudio.DOCTORADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 4, NivelEstudio.DOCTORADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 8, NivelEstudio.GRADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 3, NivelEstudio.GRADO));
        votaciones.add(new Votacion("255.255.255.255", tema, 1, NivelEstudio.MASTER));
        votaciones.add(new Votacion("255.255.255.255", tema, 6, NivelEstudio.MASTER));

        for (Votacion tmp : votaciones) {
            votacionDao.create(tmp);
        }

        votaciones.add(votacion);
    }

}
