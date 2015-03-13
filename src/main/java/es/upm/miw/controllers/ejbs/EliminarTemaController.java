package es.upm.miw.controllers.ejbs;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.entities.Tema;

public class EliminarTemaController extends ControllerEjb implements IEliminarTemaController {

    private final static Class<EliminarTemaController> clazz = EliminarTemaController.class;

    @Override
    public List<Tema> consultarTemas() {
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        List<Tema> result = temaDao.findAll();
        LogManager.getLogger(clazz).debug("Consultando los temas " + result.size());
        return result;
    }

    @Override
    public boolean eliminarTema() {

        return false;
    }

    public static final String CODIGO_SEGURIDAD = "666";

    @Override
    public boolean autorizar(String codigoSeguridad) {
        return codigoSeguridad.equals(CODIGO_SEGURIDAD);
    }

}
