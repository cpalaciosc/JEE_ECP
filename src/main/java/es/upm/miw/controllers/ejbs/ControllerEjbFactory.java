package es.upm.miw.controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.upm.miw.controllers.ControllerFactory;
import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.controllers.IIncorporarTemaController;
import es.upm.miw.controllers.IVerVotacionesController;
import es.upm.miw.controllers.IVotarController;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {

    private IEliminarTemaController eliminarTemaController;

    private IIncorporarTemaController incorporarTemaController;

    private IVerVotacionesController verVotacionesController;

    private IVotarController votarController;

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
