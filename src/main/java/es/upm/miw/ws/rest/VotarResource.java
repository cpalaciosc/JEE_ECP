package es.upm.miw.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.IVotacionDao;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.ws.VotarUris;

@Path(VotarUris.PATH_VOTACION)
public class VotarResource {

    private final static Class<VotarResource> clazz = VotarResource.class;

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response votar(Votacion votacion) {
        LogManager.getLogger(clazz).debug("Llamada al metodo votar " + votacion);
        IVotacionDao votacionDao = DaoFactory.getFactory().getVotacionDao();
        votacionDao.create(votacion);
        LogManager.getLogger(clazz).debug("Tema creado con id " + votacion.getId());
        return Response.ok(votacion).build();
    }

}
