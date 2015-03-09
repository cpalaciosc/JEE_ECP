package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements ITemaDao{
    
    public TemaDaoJpa() {
        super(Tema.class);
    }

    @Override
    protected String getNativeTableName() {
        return Tema.TABLE;
    }

}
