package es.upm.miw.views.beans;

import es.upm.miw.controllers.ControllerFactory;

public class ViewBean {

    private ControllerFactory controllerFactory;

    private String errorMsg;

    private String successMsg;

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

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
