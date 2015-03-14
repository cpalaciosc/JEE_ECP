package es.upm.miw.models.utils;

public class ValoracionMedia {

    private NivelEstudio nivelEstudio;

    private double valor;

    public ValoracionMedia() {

    }

    public ValoracionMedia(double valoracionMedia, NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
        this.valor = valoracionMedia;
    }

    public NivelEstudio getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ValoracionMedia [nivelEstudio=" + nivelEstudio + ", valor="
                + valor + "]";
    }

}
