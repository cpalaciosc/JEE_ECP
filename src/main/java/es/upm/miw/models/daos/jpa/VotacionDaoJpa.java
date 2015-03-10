package es.upm.miw.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudio;

public class VotacionDaoJpa extends GenericDaoJpa<Votacion, Integer> implements IVotacionDao {

    public VotacionDaoJpa() {
        super(Votacion.class);
    }

    @Override
    protected String getNativeTableName() {
        return Votacion.TABLE;
    }

    private static final String FIND_VOTACION_BY_TEMA = "SELECT v FROM Votacion v WHERE v.tema = :tema ";

    @SuppressWarnings("unchecked")
    @Override
    public List<Votacion> findAllByTema(Tema tema) {
        Query query = DaoJpaFactory.getEntityManagerFactory().createEntityManager()
                .createQuery(FIND_VOTACION_BY_TEMA);
        query.setParameter("tema", tema);
        return (List<Votacion>) query.getResultList();
    }

    private static final String DELETE_VOTACION_BY_TEMA = "DELETE FROM Votacion v WHERE v.tema = :tema ";

    @Override
    public int deleteAllByTema(Tema tema) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        int deletedCount = -1;
        try {
            entityManager.getTransaction().begin();
            deletedCount = entityManager.createQuery(DELETE_VOTACION_BY_TEMA).setParameter("tema", tema).executeUpdate();
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDaoJpa.class).debug(" rows deleteByTema: " + deletedCount);
        } catch (Exception e) {
            LogManager.getLogger(GenericDaoJpa.class).error("delete: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return deletedCount;

    }

    @Override
    public double valoracionMediaByNivelEstudio(NivelEstudio nivelEstudio) {
        // TODO Auto-generated method stub
        return 0;
    }
}
