package es.upm.miw.controllers.ws;

import java.util.List;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.ws.TemaUris;

public class EliminarTemaController extends ControllerWs implements IEliminarTemaController {

    @Override
    public boolean autorizar(String codigoSeguridad) {
        throw new UnsupportedOperationException("Operacion permitida via EJB");
    }

    @Override
    public List<Tema> consultarTemas() {
        return super.consultarTemas();
    }

    @Override
    public boolean eliminarTema(int idTema) {
        throw new UnsupportedOperationException("Operacion permitida via EJB");
    }

    @Override
    public boolean eliminarTema(int idTema, String codigoSeguridad) {
        WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS);
        wsManager.addPath(TemaUris.PATH_ID_PARAM);
        wsManager.addParams("code", codigoSeguridad);
        wsManager.addPathParam("id", new Integer(idTema));
        return wsManager.delete();
    }

}
