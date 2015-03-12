package es.upm.miw.models.utils;

public class ValoracionMedia {

    private NivelEstudio nivelEstudio;

    private double valoracionMedia;

    public ValoracionMedia() {

    }

    public ValoracionMedia(double valoracionMedia, NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
        this.valoracionMedia = valoracionMedia;
    }

    public NivelEstudio getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    @Override
    public String toString() {
        return "ValoracionMedia [nivelEstudio=" + nivelEstudio + ", valoracionMedia="
                + valoracionMedia + "]";
    }

}
