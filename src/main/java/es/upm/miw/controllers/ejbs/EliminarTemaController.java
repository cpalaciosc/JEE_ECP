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
        return super.consultarTemas();
    }

    @Override
    public boolean eliminarTema(int idTema) {
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        LogManager.getLogger(clazz).debug("Eliminando tema con id " + idTema);
        temaDao.deleteById(idTema);
        return temaDao.read(idTema)==null? true: false;
    }

    private static final String CODIGO_SEGURIDAD = "666";

    @Override
    public boolean autorizar(String codigoSeguridad) {
        return codigoSeguridad.equals(CODIGO_SEGURIDAD);
    }

    @Override
    public void eliminarTema(int idTema, String codigoSeguridad) {
        throw new UnsupportedOperationException("Operacion permitida via REST");
        
    }

}
