package es.upm.miw.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema {
    
    public static final String TABLE = "tema";

    public static final String ID = "id";    

    public static final String TEMA = "tema";

    public static final String PREGUNTA = "pregunta";
    
    public static final String VOTACION = "votacion";
    
    @Id
    @GeneratedValue
    @Column(name=ID)
    private Integer id;

    @Column(name=TEMA, nullable=false)
    private String tema;

    @Column(name=PREGUNTA, nullable=false)
    private String pregunta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = TEMA)
    private List<Votacion> votaciones;

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
