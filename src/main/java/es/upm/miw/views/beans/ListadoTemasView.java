package es.upm.miw.views.beans;

import java.util.List;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.entities.Tema;

public class ListadoTemasView extends ViewBean {
    
    List<Tema> temasList;
    
    public ListadoTemasView(){
    }
    
    public String listarTemas(){
        IEliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        this.temasList = eliminarTemaController.consultarTemas();
        return null;
    }

}
