package es.upm.miw.views.beans;

import java.util.List;

import es.upm.miw.controllers.IVotarController;
import es.upm.miw.models.entities.Tema;

public class SeleccionarTemaView extends ViewBean {

    private List<Tema> listTemas;

    public SeleccionarTemaView() {
    }

    public List<Tema> getListTemas() {
        return listTemas;
    }

    public String listarTemas() {
        IVotarController votarController = this.getControllerFactory().getVotarController();
        listTemas = votarController.consultarTemas();
        return null;
    }

}
