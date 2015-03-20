package es.upm.miw.ws.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import es.upm.miw.models.utils.TemaValoracionMedia;

@XmlRootElement
public class VotacionesWrapper {
    private List<TemaValoracionMedia> votaciones;

    public VotacionesWrapper() {

    }

    public List<TemaValoracionMedia> getVotaciones() {
        return votaciones;
    }

    public void setVotaciones(List<TemaValoracionMedia> votaciones) {
        this.votaciones = votaciones;
    }

}
