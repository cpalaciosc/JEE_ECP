package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.entities.Votacion;

public class VotacionDaoJpa extends GenericDaoJpa<Votacion, Integer> implements VotacionDao {

    public VotacionDaoJpa() {
        super(Votacion.class);
    }

    @Override
    protected String getNativeTableName() {
        return Votacion.TABLE;
    }

}
