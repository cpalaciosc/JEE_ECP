package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao{

    public TemaDaoJpa() {
        super(Tema.class);
    }

}
