package es.upm.miw.controllers.ws;

import java.util.List;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.entities.Tema;

public class EliminarTemaController extends ControllerWs implements IEliminarTemaController {

    @Override
    public boolean autorizar(String codigoSeguridad) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Tema> consultarTemas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean eliminarTema(int idTema) {
        // TODO Auto-generated method stub
        return false;
    }

}
