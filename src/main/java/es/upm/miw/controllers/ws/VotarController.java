package es.upm.miw.controllers.ws;

import java.util.List;

import es.upm.miw.controllers.IVotarController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.ws.TemaUris;
import es.upm.miw.ws.VotarUris;

public class VotarController extends ControllerWs implements IVotarController {

    @Override
    public List<Tema> consultarTemas() {
        return super.consultarTemas();
    }

    @Override
    public Tema consultarTema(int idTema) {
        WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS);
        wsManager.addPath(TemaUris.PATH_ID_PARAM);
        wsManager.addPathParam("id", new Integer(idTema));
        if (wsManager.read()) {
            return wsManager.entity(Tema.class);
        }
        return null;
    }

    @Override
    public boolean votar(Votacion votacion) {
        return ControllerWs.buildWebServiceManager(VotarUris.PATH_VOTACION).create(votacion);
    }

}
