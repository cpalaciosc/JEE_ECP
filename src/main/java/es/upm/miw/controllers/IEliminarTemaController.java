package es.upm.miw.controllers;

import java.util.List;

import es.upm.miw.models.entities.Tema;

public interface IEliminarTemaController {
    
    public boolean autorizar(String codigoSeguridad);

    public List<Tema> consultarTemas();

    public boolean eliminarTema();

}
