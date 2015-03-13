package es.upm.miw.controllers.ejbs;

import java.util.List;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.entities.Tema;

public class EliminarTemaController extends ControllerEjb implements IEliminarTemaController {

    @Override
    public List<Tema> consultarTemas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean eliminarTema() {
        // TODO Auto-generated method stub
        return false;
    }
    
    public static final String CODIGO_SEGURIDAD = "666";

    @Override
    public boolean autorizar(String codigoSeguridad) {
        return codigoSeguridad.equals(CODIGO_SEGURIDAD);
    }

}
