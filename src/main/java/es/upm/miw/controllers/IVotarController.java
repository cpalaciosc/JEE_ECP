package es.upm.miw.controllers;

import java.util.List;

import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;

public interface IVotarController {
    
    public List<Tema> consultarTemas();
    
    public Tema consultarTema(int idTema);
    
    public boolean votar(Votacion votacion);

}
