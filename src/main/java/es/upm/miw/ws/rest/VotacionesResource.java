package es.upm.miw.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.miw.ws.VotacionesUris;

@Path(VotacionesUris.PATH_VOTACIONES)
public class VotacionesResource {
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response consultar() {
        return null;
    }

}
