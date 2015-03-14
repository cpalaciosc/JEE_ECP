package es.upm.miw.views.beans;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IIncorporarTemaController;

public class IncorporarTemaView extends TemasBean {

    private final static Class<IncorporarTemaView> clazz = IncorporarTemaView.class;

    public IncorporarTemaView() {
        super();
    }

    private static final String INCORPORACION_OK = "Se ha registrado el tema satisfactoriamente.";

    private static final String INCORPORACION_FAIL = "No se ha podido registrar el tema.";

    private boolean isCreated = false;

    public String incorporarTema() {
        IIncorporarTemaController incorporarTemaController = this.getControllerFactory()
                .getIncorporarTemaController();
        isCreated = incorporarTemaController.incorporarTema(this.tema);
        String next = null;
        if (isCreated) {
            this.setSuccessMsg(INCORPORACION_OK);
            next = "home";
        } else {
            this.setErrorMsg(INCORPORACION_FAIL);
            next = "tema/incorporar";
        }

        LogManager.getLogger(clazz).debug(
                "Creación de tema " + tema + " resultado " + isCreated + " Proxima vista " + next);

        return next;

    }

    public boolean isCreated() {
        return isCreated;
    }

}
