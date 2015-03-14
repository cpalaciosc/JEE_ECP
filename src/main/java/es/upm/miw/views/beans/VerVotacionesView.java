package es.upm.miw.views.beans;

import java.util.List;

import es.upm.miw.controllers.IVerVotacionesController;
import es.upm.miw.models.utils.TemaValoracionMedia;

public class VerVotacionesView extends ViewBean {

    private List<TemaValoracionMedia> temaValoracionMediaList;

    public VerVotacionesView() {

    }

    public List<TemaValoracionMedia> getTemaValoracionMediaList() {
        return temaValoracionMediaList;
    }

    public void setTemaValoracionMediaList(List<TemaValoracionMedia> temaValoracionMediaList) {
        this.temaValoracionMediaList = temaValoracionMediaList;
    }

    public String generarReporte() {
        IVerVotacionesController verVotacionesController = this.getControllerFactory()
                .getVerVotacionesController();
        temaValoracionMediaList = verVotacionesController.obtenerValoracionesMediaPorTema();
        return "votacion/ver";

    }

}
