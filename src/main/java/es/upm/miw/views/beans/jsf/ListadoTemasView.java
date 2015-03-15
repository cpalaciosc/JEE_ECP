package es.upm.miw.views.beans.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.models.entities.Tema;

@ManagedBean
public class ListadoTemasView extends ViewBean {

    private List<Tema> temasList;

    public ListadoTemasView() {
    }

    public List<Tema> getTemasList() {
        return temasList;
    }
    
    @PostConstruct
    public void init(){
        this.listarTemas();
    }

    public void listarTemas() {
        IEliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        this.temasList = eliminarTemaController.consultarTemas();
    }

}
