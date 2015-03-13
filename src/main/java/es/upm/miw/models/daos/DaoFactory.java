package es.upm.miw.models.daos;

import es.upm.miw.models.daos.jpa.DaoJpaFactory;

public abstract class DaoFactory {
    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        if (factory == null) {
            factory = new DaoJpaFactory();
        }
        return factory;
    }

    public abstract ITemaDao getTemaDao();

    public abstract IVotacionDao getVotacionDao();

}
