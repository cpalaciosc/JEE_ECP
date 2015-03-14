package es.upm.miw.views.beans;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IEliminarTemaController;

public class EliminarTemaView extends ViewBean {

    private final static Class<EliminarTemaView> clazz = EliminarTemaView.class;
    
    private static final String ELIMINACION_OK = "Se ha eliminado el tema satisfactoriamente.";

    private static final String ELIMINACION_FAIL = "No se ha podido eliminar el tema.";    

    private int idTema;

    public EliminarTemaView() {
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String eliminarTema() {
        IEliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        boolean isDeleted = eliminarTemaController.eliminarTema(idTema);
        String next = "home";
        if(isDeleted){
            this.setSuccessMsg(ELIMINACION_OK);
            
        }
        else{
            this.setErrorMsg(ELIMINACION_FAIL);
        }
        LogManager.getLogger(clazz).debug("Eliminando tema con id " + idTema + " resultado " + isDeleted + " Proxima vista "+next);
        return next;
    }

}
