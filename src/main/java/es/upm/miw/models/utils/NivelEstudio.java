package es.upm.miw.models.utils;

public enum NivelEstudio {
    PRIMARIA("P"), SECUNDARIA("S"), GRADO("G"), MASTER("M"), DOCTORADO("D");
    
    public String valor;
    
    private NivelEstudio(String valor){
        this.valor = valor;
    }

}
