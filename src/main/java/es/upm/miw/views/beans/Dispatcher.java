package es.upm.miw.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.ejbs.ControllerEjbFactory;
import es.upm.miw.models.utils.NivelEstudio;
import es.upm.miw.models.utils.Utils;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/pages/jsp/";

    private final static Class<Dispatcher> clazz = Dispatcher.class;

    private ControllerEjbFactory controllerFactory;

    @Override
    public void init() throws ServletException {
        controllerFactory = new ControllerEjbFactory();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LogManager.getLogger(clazz).debug("PathInfo " + request.getPathInfo());
        String view = "home";
        request.setCharacterEncoding("UTF-8");
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
            case "tema/eliminar":
                EliminarTemaView eliminarTemaView = new EliminarTemaView();
                eliminarTemaView.setControllerFactory(controllerFactory);
                eliminarTemaView.setIdTema(Integer.parseInt(request.getParameter("idTema")));
                view = eliminarTemaView.eliminarTema();
                request.setAttribute("errorMsg", eliminarTemaView.getErrorMsg());
                request.setAttribute("successMsg", eliminarTemaView.getSuccessMsg());
                break;
            case "votacion/seleccionTema":
                SeleccionarTemaView seleccionarTemaView = new SeleccionarTemaView();
                seleccionarTemaView.setControllerFactory(controllerFactory);
                view = seleccionarTemaView.listarTemas();
                request.setAttribute("seleccionarTemaView", seleccionarTemaView);
                break;
            case "votacion/ver":
                VerVotacionesView verVotacionesView = new VerVotacionesView();
                verVotacionesView.setControllerFactory(controllerFactory);
                view = verVotacionesView.generarReporte();
                request.setAttribute("verVotacionesView", verVotacionesView);
                break;
            default:
                LogManager.getLogger(clazz).debug(
                        "Vista solicitada no reconocida, se redirigirá al home " + view);
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
        request.setCharacterEncoding("UTF-8");
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
                if (!incorporarTemaView.isCreated()) {
                    request.setAttribute("incorporarTemaView", incorporarTemaView);
                }
                request.setAttribute("errorMsg", incorporarTemaView.getErrorMsg());
                request.setAttribute("successMsg", incorporarTemaView.getSuccessMsg());
                break;
            case "tema/listar":
                AutorizarView autorizarView = new AutorizarView();
                autorizarView.setControllerFactory(controllerFactory);
                autorizarView.setCodigoSeguridad(request.getParameter("codigo"));
                view = autorizarView.autorizar();
                if (autorizarView.isAutorizado()) {
                    ListadoTemasView listadoTemasView = new ListadoTemasView();
                    listadoTemasView.setControllerFactory(controllerFactory);
                    listadoTemasView.listarTemas();
                    request.setAttribute("listadoTemasView", listadoTemasView);
                }
                request.setAttribute("errorMsg", autorizarView.getErrorMsg());
                request.setAttribute("successMsg", autorizarView.getSuccessMsg());
                break;
            case "votacion/votar":
                VotarView votarView = new VotarView();
                votarView.setIdTema(Integer.parseInt(request.getParameter("temas")));
                votarView.setControllerFactory(controllerFactory);
                view = votarView.prepararVotacion();
                request.setAttribute("votarView", votarView);
                break;
            case "votacion/procesar":
                VotarView votarViewProcesar = new VotarView();
                votarViewProcesar.setIdTema(Integer.parseInt(request.getParameter("idTema")));
                votarViewProcesar.setControllerFactory(controllerFactory);
                votarViewProcesar.getVotacion().setIp(Utils.getClientIpAddr(request));
                votarViewProcesar.getVotacion().setNivelEstudio(
                        NivelEstudio.valueOf(request.getParameter("nivelEstudio")));
                votarViewProcesar.getVotacion().setValoracion(
                        Integer.parseInt(request.getParameter("valoracion")));
                view = votarViewProcesar.procesar();
                if (!votarViewProcesar.isCreated()) {
                    request.setAttribute("votarView", votarViewProcesar);
                } else {
                    SeleccionarTemaView seleccionarTemaView = new SeleccionarTemaView();
                    seleccionarTemaView.setControllerFactory(controllerFactory);
                    view = seleccionarTemaView.listarTemas();
                    request.setAttribute("seleccionarTemaView", seleccionarTemaView);
                }
                request.setAttribute("errorMsg", votarViewProcesar.getErrorMsg());
                request.setAttribute("successMsg", votarViewProcesar.getSuccessMsg());

                break;

            }
        }
        LogManager.getLogger(clazz).debug("Redirigiendo a vista " + view + ".jsp");
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
