package es.upm.miw.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tema implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String TABLE = "tema";

    public static final String ID = "id";

    public static final String CATEGORIA = "categoria";

    public static final String PREGUNTA = "pregunta";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = ID)
    private Integer id;

    @Column(name = CATEGORIA, nullable = false)
    private String categoria;

    @Column(name = PREGUNTA, nullable = false)
    private String pregunta;

    public Tema() {

    }

    public Tema(String tema, String pregunta) {
        this.categoria = tema;
        this.pregunta = pregunta;
    }

    public Tema(Integer id, String tema, String pregunta) {
        this(tema, pregunta);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        return id.equals(other.id) && categoria.equals(other.categoria)
                && pregunta.equals(other.pregunta);
    }

    @Override
    public String toString() {
        return "Tema [id=" + id + ", tema=" + categoria + ", pregunta=" + pregunta + "]";
    }

    @Override
    public int hashCode() {
        int hash = 1;
        final int prime = 31;
        hash = hash * prime + this.id;
        hash = hash * prime + (this.categoria == null ? 0 : this.categoria.hashCode());
        hash = hash * prime + (this.pregunta == null ? 0 : this.pregunta.hashCode());
        return hash;

    }

}
