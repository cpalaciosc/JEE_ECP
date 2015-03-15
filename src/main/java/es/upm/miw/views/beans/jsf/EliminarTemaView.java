package es.upm.miw.views.beans.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.utils.JSFUtils;

@ManagedBean
public class EliminarTemaView extends ViewBean {

    private final static Class<EliminarTemaView> clazz = EliminarTemaView.class;

    public boolean isDeleted = false;

    public EliminarTemaView() {
    }

    public String verificar() {
        String next = null;
        if (this.isDeleted) {
            next = "home";
        }
        LogManager.getLogger(clazz).debug(" Proxima vista " + next);
        return next;
    }

    public void eliminarTema() {
        IEliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        int idTema = Integer.parseInt(JSFUtils.getRequestParameter("idTema"));
        this.isDeleted = eliminarTemaController.eliminarTema(idTema);
        if (this.isDeleted) {
            JSFUtils.addMessage(FacesMessage.SEVERITY_INFO, "OK!",
                    this.getBundle().getString("eliminacion_ok"));
        } else {
            JSFUtils.addMessage(FacesMessage.SEVERITY_ERROR, "Error!",
                    this.getBundle().getString("eliminacion_failure"));
        }
        LogManager.getLogger(clazz).debug(
                "Eliminando tema con id " + idTema + " resultado " + isDeleted);
    }

}
