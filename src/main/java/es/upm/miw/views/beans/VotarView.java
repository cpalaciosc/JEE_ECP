package es.upm.miw.views.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IVotarController;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudio;
import es.upm.miw.models.utils.Utils;

public class VotarView extends TemasBean {

    private final static Class<VotarView> clazz = VotarView.class;

    private Votacion votacion;

    private int idTema;

    private boolean isCreated = false;

    private static final String VOTACION_OK = "Se ha registrado el voto satisfactoriamente.";

    private static final String VOTACION_FAIL = "No se ha podido registrar el voto.";

    public VotarView() {
        this.votacion = new Votacion();
    }

    public Votacion getVotacion() {
        return votacion;
    }

    public void setVotacion(Votacion votacion) {
        this.votacion = votacion;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String prepararVotacion() {
        IVotarController votarController = this.getControllerFactory().getVotarController();
        tema = votarController.consultarTema(idTema);
        return "votacion/votar";
    }

    public boolean isCreated() {
        return isCreated;
    }

    public String procesar() {
        IVotarController votarController = this.getControllerFactory().getVotarController();
        tema = votarController.consultarTema(idTema);
        this.votacion.setTema(tema);
        isCreated = votarController.votar(votacion);
        String next = null;
        if (isCreated) {
            this.setSuccessMsg(VOTACION_OK);
            next = "votacion/seleccionTema";
        } else {
            this.setErrorMsg(VOTACION_FAIL);
            next = "votacion/votar";
        }
        LogManager.getLogger(clazz).debug(
                "Creación de votacion " + votacion + " resultado " + isCreated + " Proxima vista "
                        + next);

        return next;
    }

    public List<NivelEstudio> getNivelEstudioList() {
        return Utils.getNivelEstudioList();
    }

    public List<Integer> getValoracionesList() {
        return Utils.getValoracionesList();
    }

}
