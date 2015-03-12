package es.upm.miw.models.daos;

import java.util.List;

import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.ValoracionMedia;

public interface IVotacionDao extends IGenericDao<Votacion, Integer> {
    
    public List<Votacion> findAllByTema(Tema tema);
    
    public int deleteAllByTema(Tema tema);
    
    public List<ValoracionMedia> valoracionMediaByNivelEstudio(Tema tema);

}
