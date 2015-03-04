package es.upm.miw.models.utils;

public enum NivelEstudio {
    PRIMARIA(1), SECUNDARIA(2), GRADO(3), MASTER(4), DOCTORADO(5);
    
    public int valor;
    
    private NivelEstudio(int valor){
        this.valor = valor;
    }

}
