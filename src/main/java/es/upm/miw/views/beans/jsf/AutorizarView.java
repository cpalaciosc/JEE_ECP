package es.upm.miw.views.beans.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.utils.JSFUtils;

@ManagedBean
public class AutorizarView extends ViewBean {

    private String codigoSeguridad;
    
    private boolean autorizado;

    public AutorizarView() {

    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    
    public String autorizar(){
        String next = null;
        if(this.autorizado){
            next = "tema/consultar";
        }
        return next;
    }

    public void verificar() {
        IEliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();

        this.autorizado = eliminarTemaController.autorizar(this.codigoSeguridad);
        if (!this.autorizado) {
            JSFUtils.addMessage(FacesMessage.SEVERITY_ERROR, "Error!",
                    this.getBundle().getString("autorizacion_failure"));
        }

    }

}
