package es.upm.miw.ws.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.ITemaDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.ws.TemaUris;
import es.upm.miw.ws.utils.TemasWrapper;

@Stateless
@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

    private final static Class<TemaResource> clazz = TemaResource.class;

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response incorporar(Tema tema) {
        LogManager.getLogger(clazz).debug("Llamada al metodo create " + tema);
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);
        LogManager.getLogger(clazz).debug("Tema creado con id "+tema.getId());
        return Response.ok(tema).build();
    }
    
    
    @GET
    @Path(TemaUris.PATH_ID_PARAM)
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response consultar(@PathParam("id") Integer id) {
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        Tema tema = temaDao.read(id);
        LogManager.getLogger(clazz).debug("Buscar tema con id "+tema.getId());
        return Response.ok(tema).build();
    }
    
    @GET
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response consultar() {
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        List<Tema> listTemas = temaDao.findAll();
        TemasWrapper temasWrapper = new TemasWrapper();
        temasWrapper.setListTemas(listTemas);
        LogManager.getLogger(clazz).debug("Temas encontrados "+listTemas.size());
        return Response.ok(temasWrapper).build();
    }
    
    
    private static final String CODIGO_SEGURIDAD = "666";

    @DELETE
    @Path(TemaUris.PATH_ID_PARAM)
    public Response eliminar(@PathParam("id") Integer id, @QueryParam("code") String code) {
        if(code==null){
            code = "";
        }
        if(!code.equals(CODIGO_SEGURIDAD)){
            throw new NotAuthorizedException("No tiene permiso para eliminar un tema");
        }
        
        ITemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        LogManager.getLogger(clazz).debug("Eliminando tema con id " + id);
        temaDao.deleteById(id);

        return Response.ok().build();
    }

}
