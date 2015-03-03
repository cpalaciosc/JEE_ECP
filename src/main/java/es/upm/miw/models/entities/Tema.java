package es.upm.miw.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {
    
    public static final String TABLE = "tema";

    public static final String ID = "ID";    

    public static final String TEMA = "TEMA";

    public static final String PREGUNTA = "PREGUNTA";
    
    @Id
    @GeneratedValue
    private Integer id;

    private String tema;

    private String pregunta;

    public Tema() {

    }

    public Tema(Integer id, String tema, String pregunta) {
        super();
        this.id = id;
        this.tema = tema;
        this.pregunta = pregunta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        Tema other = (Tema) obj;
        return id.equals(other.id) && tema.equals(other.tema)
                && pregunta.equals(other.pregunta);
    }

    @Override
    public String toString() {
        return "Tema [id=" + id + ", tema=" + tema + ", pregunta=" + pregunta + "]";
    }
    
    
    
    
    
    

}
