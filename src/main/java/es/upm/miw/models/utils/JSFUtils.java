package es.upm.miw.models.utils;

import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class JSFUtils {

    public static void addMessage(Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severity, summary, detail));

    }

    public static String getResourceBundleString(String resourceBundleName, String resourceBundleKey)
            throws MissingResourceException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext,
                resourceBundleName);
        return bundle.getString(resourceBundleKey);
    }

    public static String getRequestParameter(String parameterName) {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap();
        return params.get(parameterName);
    }

    public static String getClientIpAddr() {
        return Utils.getClientIpAddr((HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest());

    }

}
