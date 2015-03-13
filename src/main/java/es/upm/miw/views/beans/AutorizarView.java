package es.upm.miw.views.beans;

import es.upm.miw.controllers.IEliminarTemaController;

public class AutorizarView extends ViewBean {

    private static final String AUTORIZACION_OK = "Se ha registrado el tema satisfactoriamente.";

    private static final String AUTORIZACION_FAIL = "Ingrese un codigo de seguridad valido.";

    private String codigoSeguridad;

    public AutorizarView() {

    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String autorizar() {
        IEliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();

        String next = null;
        if (eliminarTemaController.autorizar(this.codigoSeguridad)) {
            this.setSuccessMsg(AUTORIZACION_OK);
            next = "tema/consultar";
        } else {
            this.setErrorMsg(AUTORIZACION_FAIL);
            next = "tema/autorizar";
        }
        return next;
    }

}
