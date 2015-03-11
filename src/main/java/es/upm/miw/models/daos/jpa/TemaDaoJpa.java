package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements ITemaDao {

    public TemaDaoJpa() {
        super(Tema.class);
    }

    @Override
    public void deleteById(Integer id) {
        Tema tema = this.read(id);
        if (tema != null) {
            this.deleteRelatedVotaciones(tema);
            super.deleteById(id);
        }
    }

    private void deleteRelatedVotaciones(Tema tema) {
        DaoFactory.setFactory(new DaoJpaFactory());
        IVotacionDao votacionDao = DaoFactory.getFactory().getVotacionDao();
        votacionDao.deleteAllByTema(tema);
    }

    @Override
    protected String getNativeTableName() {
        return Tema.TABLE;
    }

}
