package es.upm.miw.views.beans.jsf;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedProperty;

import es.upm.miw.controllers.ControllerFactory;

public class ViewBean {

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    @ManagedProperty(value = "#{msgs}")
    private ResourceBundle bundle;

    public ViewBean() {

    }

    public ViewBean(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

}
