package es.upm.miw.ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.utils.TemaValoracionMedia;
import es.upm.miw.models.utils.ValoracionMedia;
import es.upm.miw.ws.VotacionesUris;
import es.upm.miw.ws.utils.VotacionesWrapper;

@Path(VotacionesUris.PATH_VOTACIONES)
public class VotacionesResource {
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response consultar() {
        IVotacionDao votacionDao = DaoFactory.getFactory().getVotacionDao();
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        List<Tema> listTemas = temaDao.findAll();
        List<TemaValoracionMedia> listTemaValoracionMedias = new ArrayList<TemaValoracionMedia>();
        for (Tema tmpTema : listTemas) {
            List<ValoracionMedia> valoracionMedia = votacionDao
                    .valoracionMediaByNivelEstudio(tmpTema);
            int numeroVotos = votacionDao.numeroVotos(tmpTema);
            TemaValoracionMedia tmp = new TemaValoracionMedia();
            tmp.setTema(tmpTema);
            tmp.setValoracionMedia(valoracionMedia);
            tmp.setNumeroVotos(numeroVotos);
            listTemaValoracionMedias.add(tmp);
        }
        VotacionesWrapper votaciones = new VotacionesWrapper();
        votaciones.setVotaciones(listTemaValoracionMedias);
        return Response.ok(votaciones).build();
    }

}
