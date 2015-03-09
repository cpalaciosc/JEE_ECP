package es.upm.miw.controllers;

public abstract class ControllerFactory {
    
    public abstract IEliminarTemaController getEliminarTemaController();
    public abstract IIncorporarTemaController getIncorporarTemaController();
    public abstract IVerVotacionesController getVerVotacionesController();
    public abstract IVotarController getVotarController();

}
