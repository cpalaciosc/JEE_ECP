package es.upm.miw.controllers.ws;

import java.util.List;

import es.upm.miw.models.entities.Tema;
import es.upm.miw.ws.TemaUris;
import es.upm.miw.ws.utils.TemasWrapper;


abstract class ControllerWs {

    private static final String PROTOCOL = "http";

    private static final String HOST = "localhost";

    private static final int PORT = 8080;

    private static final String WEB = "/Web/rest";

    private static final String URI = PROTOCOL + "://" + HOST + ":" + PORT + WEB;

    protected ControllerWs() {
    }

  
    protected static WsManager buildWebServiceManager(String... paths){
        return new WsManager(URI, paths);
    }
    
    public List<Tema> consultarTemas() {
        WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS);
        if (wsManager.read()) {
            return wsManager.entity(TemasWrapper.class).getListTemas();
        }
        return null;
    }    

}
