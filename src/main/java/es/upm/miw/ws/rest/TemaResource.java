package es.upm.miw.ws.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IEliminarTemaController;
import es.upm.miw.controllers.IIncorporarTemaController;
import es.upm.miw.controllers.ejbs.ControllerEjbFactory;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.ws.TemaUris;

@Stateless
@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

    private final static Class<TemaResource> clazz = TemaResource.class;

    private ControllerEjbFactory controllerFactory = new ControllerEjbFactory();

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response create(Tema tema) {
        LogManager.getLogger(clazz).debug("Llamada al metodo create " + tema);
        IIncorporarTemaController incorporarTemaController = controllerFactory
                .getIncorporarTemaController();
        incorporarTemaController.incorporarTema(tema);
        return Response.ok(tema).build();
    }

    @DELETE
    @Path(TemaUris.PATH_ID_PARAM)
    public Response delete(@PathParam("id") Integer id) {
        IEliminarTemaController eliminarTemaController = controllerFactory
                .getEliminarTemaController();

        eliminarTemaController.eliminarTema(id);

        return Response.ok().build();
    }

}
