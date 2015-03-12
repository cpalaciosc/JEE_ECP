package es.upm.miw.controllers.ejbs;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IIncorporarTemaController;
import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.entities.Tema;

public class IncorporarTemaController extends ControllerEjb implements IIncorporarTemaController {
    
    private final static Class<IncorporarTemaController> clazz = IncorporarTemaController.class;

    @Override
    public boolean incorporarTema(Tema tema) {
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);
        LogManager.getLogger(clazz).debug("Tema creado con id "+tema.getId());
        return tema.getId()!=null ? true : false;
    }

}
