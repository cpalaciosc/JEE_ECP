package es.upm.miw.controllers.ws;

import es.upm.miw.controllers.IIncorporarTemaController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.ws.TemaUris;

public class IncorporarTemaController extends ControllerWs implements IIncorporarTemaController {

    @Override
    public boolean incorporarTema(Tema tema) {
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(tema);
    }

}
