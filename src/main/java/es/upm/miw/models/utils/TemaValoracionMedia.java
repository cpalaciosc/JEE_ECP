package es.upm.miw.models.utils;

import java.util.List;

import es.upm.miw.models.entities.Tema;

public class TemaValoracionMedia {

    private Tema tema;

    private List<ValoracionMedia> valoracionMedia;

    public TemaValoracionMedia() {

    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<ValoracionMedia> getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(List<ValoracionMedia> valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

}
