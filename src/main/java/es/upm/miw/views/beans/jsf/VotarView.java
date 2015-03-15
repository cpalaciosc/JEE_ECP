package es.upm.miw.views.beans.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.IVotarController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.JSFUtils;
import es.upm.miw.models.utils.NivelEstudio;
import es.upm.miw.models.utils.Utils;

@ManagedBean
@ViewScoped
public class VotarView extends ViewBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final static Class<VotarView> clazz = VotarView.class;

    private Votacion votacion;

    private List<Tema> listTemas;

    private Tema tema;

    private Integer selectedIdTema;

    private String selectedNivelEstudio;

    private boolean showFields = false;

    public VotarView() {
        this.votacion = new Votacion();
    }

    @PostConstruct
    public void init() {
        IVotarController votarController = this.getControllerFactory().getVotarController();
        this.listTemas = votarController.consultarTemas();
        this.selectedIdTema = -1;
    }

    public Votacion getVotacion() {
        return votacion;
    }

    public void setVotacion(Votacion votacion) {
        this.votacion = votacion;
    }

    public List<Tema> getListTemas() {
        return listTemas;
    }

    public void setListTemas(List<Tema> listTemas) {
        this.listTemas = listTemas;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public int getSelectedIdTema() {
        return selectedIdTema;
    }

    public void setSelectedIdTema(int selectedIdTema) {
        this.selectedIdTema = selectedIdTema;
    }

    public boolean isShowFields() {
        return showFields;
    }

    public void setShowFields(boolean showFields) {
        this.showFields = showFields;
    }

    public String getSelectedNivelEstudio() {
        return selectedNivelEstudio;
    }

    public void setSelectedNivelEstudio(String selectedNivelEstudio) {
        this.selectedNivelEstudio = selectedNivelEstudio;
    }

    public void onCategoriaChange() {
        if (selectedIdTema != null && selectedIdTema != -1) {
            IVotarController votarController = this.getControllerFactory().getVotarController();
            this.tema = votarController.consultarTema(selectedIdTema);
            this.showFields = true;
            LogManager.getLogger(clazz).debug("Tema seleccionado " + this.tema);
        } else {
            this.showFields = false;
            LogManager.getLogger(clazz).debug("No se selecciono el tema");
        }

    }

    public String procesar() {
        IVotarController votarController = this.getControllerFactory().getVotarController();
        tema = votarController.consultarTema(selectedIdTema);
        this.votacion.setTema(tema);
        this.votacion.setIp(JSFUtils.getClientIpAddr());
        this.votacion.setNivelEstudio(NivelEstudio.valueOf(selectedNivelEstudio));
        boolean isCreated = votarController.votar(votacion);
        String next = null;
        if (isCreated) {
            JSFUtils.addMessage(FacesMessage.SEVERITY_INFO, "OK!",
                    this.getBundle().getString("votacion_ok"));
            next = "home";
        } else {
            JSFUtils.addMessage(FacesMessage.SEVERITY_ERROR, "Error!",
                    this.getBundle().getString("votacion_failure"));
        }
        LogManager.getLogger(clazz).debug(
                "Creación de votacion " + votacion + " resultado " + isCreated + " Proxima vista "
                        + next);

        return next;
    }

    public List<NivelEstudio> getNivelEstudioList() {
        return Utils.getNivelEstudioList();
    }

}
