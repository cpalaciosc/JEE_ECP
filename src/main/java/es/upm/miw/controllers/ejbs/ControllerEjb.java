package es.upm.miw.controllers.ejbs;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.entities.Tema;

public abstract class ControllerEjb {

    private final static Class<ControllerEjb> clazz = ControllerEjb.class;

    protected List<Tema> consultarTemas() {
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        List<Tema> result = temaDao.findAll();
        LogManager.getLogger(clazz).debug("Se han encontrado " + result.size()+ " temas");
        return result;
    }

}
