package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Votacion;

public class VotacionDaoJpa extends GenericDaoJpa<Votacion, Integer> implements IVotacionDao {

    public VotacionDaoJpa() {
        super(Votacion.class);
    }

    @Override
    protected String getNativeTableName() {
        return Votacion.TABLE;
    }

}
