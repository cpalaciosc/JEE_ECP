package es.upm.miw.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.daos.IVotacionDao;

public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "JEE_ECP";

    private static EntityManagerFactory entityManagerFactory;

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static void dropAndCreateTables() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PersistenceUnitProperties.DDL_GENERATION,
                PersistenceUnitProperties.DROP_AND_CREATE);
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
        LogManager.getLogger(DaoJpaFactory.class).debug("drop and create tables");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return entityManagerFactory;
    }

    @Override
    public ITemaDao getTemaDao() {
        return new TemaDaoJpa();
    }

    @Override
    public IVotacionDao getVotacionDao() {
        return new VotacionDaoJpa();
    }

}
