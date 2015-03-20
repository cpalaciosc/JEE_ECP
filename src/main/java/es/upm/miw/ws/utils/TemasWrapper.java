package es.upm.miw.ws.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import es.upm.miw.models.entities.Tema;

@XmlRootElement
public class TemasWrapper {

    private List<Tema> listTemas;

    public TemasWrapper() {

    }

    public List<Tema> getListTemas() {
        return listTemas;
    }

    public void setListTemas(List<Tema> listTemas) {
        this.listTemas = listTemas;
    }

}
