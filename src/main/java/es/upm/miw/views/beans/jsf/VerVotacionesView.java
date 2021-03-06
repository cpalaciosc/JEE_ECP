package es.upm.miw.views.beans.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import es.upm.miw.controllers.IVerVotacionesController;
import es.upm.miw.models.utils.TemaValoracionMedia;

@ManagedBean
public class VerVotacionesView extends ViewBean {

    private List<TemaValoracionMedia> temaValoracionMediaList;

    public VerVotacionesView() {

    }

    @PostConstruct
    public void init() {
        IVerVotacionesController verVotacionesController = this.getControllerFactory()
                .getVerVotacionesController();
        temaValoracionMediaList = verVotacionesController.obtenerValoracionesMediaPorTema();
    }

    public List<TemaValoracionMedia> getTemaValoracionMediaList() {
        return temaValoracionMediaList;
    }

    public void setTemaValoracionMediaList(List<TemaValoracionMedia> temaValoracionMediaList) {
        this.temaValoracionMediaList = temaValoracionMediaList;
    }

}
