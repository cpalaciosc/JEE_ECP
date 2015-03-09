package es.upm.miw.models.daos;

public abstract class DaoFactory {
    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) { 
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract ITemaDao getTemaDao();

    public abstract IVotacionDao getVotacionDao();

}
