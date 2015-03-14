package es.upm.miw.views.beans;

import java.util.List;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.entities.Tema;

public class ListadoTemasView extends ViewBean {

    private List<Tema> temasList;

    public ListadoTemasView() {
    }

    public List<Tema> getTemasList() {
        return temasList;
    }

    public void listarTemas() {
        IEliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        this.temasList = eliminarTemaController.consultarTemas();
    }

}
