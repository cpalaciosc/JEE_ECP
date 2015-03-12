package es.upm.miw.views.beans;

import es.upm.miw.models.entities.Tema;

public class TemasBean extends ViewBean {
    
    protected Tema tema;
    
    public TemasBean(){
        this.tema = new Tema();
    }
    
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }


}
