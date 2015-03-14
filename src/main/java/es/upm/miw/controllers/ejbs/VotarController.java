package es.upm.miw.controllers.ejbs;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IVotarController;
import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;

public class VotarController extends ControllerEjb implements IVotarController {
    private final static Class<VotarController> clazz = VotarController.class;

    @Override
    public List<Tema> consultarTemas() {
        return super.consultarTemas();
    }

    @Override
    public Tema consultarTema(int idTema) {
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        LogManager.getLogger(clazz).debug("Obteniendo info de tema con id " + idTema);
        return temaDao.read(idTema);
    }

    @Override
    public boolean votar(Votacion votacion) {
        IVotacionDao votacionDao = DaoFactory.getFactory().getVotacionDao();
        votacionDao.create(votacion);
        LogManager.getLogger(clazz).debug("Votacion creado con id "+votacion.getId());
        return votacion.getId()!=null ? true : false;        
    }

}
