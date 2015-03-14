package es.upm.miw.views.beans;

import es.upm.miw.controllers.IVotarController;
import es.upm.miw.models.entities.Votacion;

public class VotarView extends TemasBean {

    private Votacion votacion;

    private int idTema;
    
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

    public void prepararVotacion() {
        IVotarController votarController = this.getControllerFactory().getVotarController();
        tema = votarController.consultarTema(idTema);
    }

}
