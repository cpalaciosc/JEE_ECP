package es.upm.miw.controllers.ws;

import es.upm.miw.controllers.ControllerFactory;
import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.controllers.IIncorporarTemaController;
import es.upm.miw.controllers.IVerVotacionesController;
import es.upm.miw.controllers.IVotarController;

public class ControllerWsFactory extends ControllerFactory {

    private IEliminarTemaController eliminarTemaController;

    private IIncorporarTemaController incorporarTemaController;

    private IVerVotacionesController verVotacionesController;

    private IVotarController votarController;

    public ControllerWsFactory() {
    }

    @Override
    public IEliminarTemaController getEliminarTemaController() {
        if (eliminarTemaController == null) {
            eliminarTemaController = new EliminarTemaController();
        }
        return eliminarTemaController;
    }

    @Override
    public IIncorporarTemaController getIncorporarTemaController() {
        if (incorporarTemaController == null) {
            incorporarTemaController = new IncorporarTemaController();
        }
        return incorporarTemaController;
    }

    @Override
    public IVerVotacionesController getVerVotacionesController() {
        if (verVotacionesController == null) {
            verVotacionesController = new VerVotacionesController();
        }
        return verVotacionesController;
    }

    @Override
    public IVotarController getVotarController() {
        if (votarController == null) {
            votarController = new VotarController();
        }
        return votarController;
    }

}
