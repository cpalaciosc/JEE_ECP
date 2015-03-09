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

    @Override
    public IEliminarTemaController getEliminarTemaController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IIncorporarTemaController getIncorporarTemaController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IVerVotacionesController getVerVotacionesController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IVotarController getVotarController() {
        // TODO Auto-generated method stub
        return null;
    }

}
