package es.upm.miw.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.ejbs.ControllerEjbFactory;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/pages/jsp/";

    private final static Class<Dispatcher> clazz = Dispatcher.class;

    private ControllerEjbFactory controllerFactory;

    @Override
    public void init() throws ServletException {
        controllerFactory = new ControllerEjbFactory();
        // getServletContext().setAttribute("controllerFactory",
        // controllerFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LogManager.getLogger(clazz).debug("PathInfo " + request.getPathInfo());
        String view = "home";
        if (request.getPathInfo() != null) {
            String action = request.getPathInfo().substring(1);
            switch (action) {
            case "tema/nuevo":
                view = "tema/incorporar";
                IncorporarTemaView incorporarTemaView = new IncorporarTemaView();
                request.setAttribute("incorporarTemaView", incorporarTemaView);
                break;
            case "tema/autorizar":
                view = "tema/autorizar";
                AutorizarView autorizarView = new AutorizarView();
                request.setAttribute("autorizarView", autorizarView);
                break;

            }
        }
        LogManager.getLogger(clazz).debug("Redirigiendo a vista " + view + ".jsp");
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LogManager.getLogger(clazz).debug("PathInfo " + request.getPathInfo());
        String view = "home";
        if (request.getPathInfo() != null) {
            String action = request.getPathInfo().substring(1);
            switch (action) {
            case "tema/crear":
                IncorporarTemaView incorporarTemaView = new IncorporarTemaView();
                incorporarTemaView.getTema().setPregunta(request.getParameter("pregunta"));
                incorporarTemaView.getTema().setCategoria(request.getParameter("categoria"));
                incorporarTemaView.setControllerFactory(controllerFactory);
                LogManager.getLogger(clazz).debug("Tema a guardar " + incorporarTemaView.getTema());
                view = incorporarTemaView.incorporarTema();
                request.setAttribute("incorporarTemaView", incorporarTemaView);
                request.setAttribute("errorMsg", incorporarTemaView.getErrorMsg());
                request.setAttribute("successMsg", incorporarTemaView.getSuccessMsg());
                break;
            case "tema/verificar_codigo_seguridad":
                AutorizarView autorizarView = new AutorizarView();
                autorizarView.setControllerFactory(controllerFactory);
                autorizarView.setCodigoSeguridad(request.getParameter("codigo"));
                view = autorizarView.autorizar();
                if(autorizarView.isAutorizado()){
                    ListadoTemasView listadoTemasView = new ListadoTemasView();
                    listadoTemasView.listarTemas();
                    request.setAttribute("listadoTemasView", listadoTemasView);
                }
                request.setAttribute("errorMsg", autorizarView.getErrorMsg());
                request.setAttribute("successMsg", autorizarView.getSuccessMsg());
                break;

            }
        }
        LogManager.getLogger(clazz).debug("Redirigiendo a vista " + view + ".jsp");
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
