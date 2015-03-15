package es.upm.miw.views.beans.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IIncorporarTemaController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.utils.JSFUtils;

@ManagedBean
public class IncorporarTemaView extends ViewBean {

    private final static Class<IncorporarTemaView> clazz = IncorporarTemaView.class;

    private Tema tema;

    public IncorporarTemaView() {
        this.tema = new Tema();
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String incorporarTema() {
        IIncorporarTemaController incorporarTemaController = this.getControllerFactory()
                .getIncorporarTemaController();
        boolean isCreated = incorporarTemaController.incorporarTema(this.tema);
        String next = null;
        if (isCreated) {
            next = "home";
            JSFUtils.addMessage(FacesMessage.SEVERITY_INFO, "OK!",
                    this.getBundle().getString("incorporacion_ok"));            
        } else {
            JSFUtils.addMessage(FacesMessage.SEVERITY_ERROR, "Error!",
                    this.getBundle().getString("incorporacion_failure"));
        }

        LogManager.getLogger(clazz).debug(
                "Creación de tema " + tema + " resultado " + isCreated + " Proxima vista " + next);

        return next;
    }

}
