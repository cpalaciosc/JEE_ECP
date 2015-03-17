package es.upm.miw.views.beans.jsf;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.models.utils.JSFUtils;

@ManagedBean
@SessionScoped
public class CambiarIdiomaView {

    private final static Class<CambiarIdiomaView> clazz = CambiarIdiomaView.class;

    public CambiarIdiomaView() {

    }

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void cambiar() {
        LogManager.getLogger(clazz).debug(
                "Cambiando a locale " + JSFUtils.getRequestParameter("locale"));
        this.locale = new Locale(JSFUtils.getRequestParameter("locale"));
        FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
    }

}
