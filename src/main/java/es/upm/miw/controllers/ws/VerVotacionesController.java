package es.upm.miw.controllers.ws;

import java.util.List;

import es.upm.miw.controllers.IVerVotacionesController;
import es.upm.miw.models.utils.TemaValoracionMedia;
import es.upm.miw.ws.VotacionesUris;
import es.upm.miw.ws.utils.VotacionesWrapper;

public class VerVotacionesController extends ControllerWs implements IVerVotacionesController {

    @Override
    public List<TemaValoracionMedia> obtenerValoracionesMediaPorTema() {
        WsManager wsManager = ControllerWs.buildWebServiceManager(VotacionesUris.PATH_VOTACIONES);
        if (wsManager.read()) {
            return wsManager.entity(VotacionesWrapper.class).getVotaciones();
        }
        return null;
    }

}
