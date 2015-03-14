package es.upm.miw.controllers.ejbs;

import java.util.List;

import es.upm.miw.controllers.IVotarController;
import es.upm.miw.models.entities.Tema;

public class VotarController extends ControllerEjb implements IVotarController {

    @Override
    public List<Tema> consultarTemas() {
        return super.consultarTemas();
    }

}
