package es.upm.miw.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.upm.miw.models.utils.NivelEstudio;

@Entity
public class Votacion {
    public static final String TABLE = "votacion";

    public static final String ID = "id";

    public static final String IP = "ip";

    public static final String NIVEL_ESTUDIO = "nivel_estudio";

    public static final String TEMA = "id_tema";

    public static final String VALORACION = "valoracion";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Integer id;

    @Column(name = IP, nullable = false)
    private String ip;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = TEMA, nullable = false)
    private Tema tema;

    @Column(name = VALORACION, nullable = false)
    private Integer valoracion;

    @Enumerated(EnumType.STRING)
    @Column(name = NIVEL_ESTUDIO, length=1, nullable=false)
    private NivelEstudio nivelEstudio;

    public Votacion() {

    }

    public Integer getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public NivelEstudio getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        Votacion other = (Votacion) obj;
        return id.equals(other.id) && tema.equals(other.tema) && ip.equals(other.ip)
                && valoracion == other.valoracion
                && nivelEstudio == other.nivelEstudio;
    }

    @Override
    public String toString() {
        return "Votacion [id=" + id + ", tema=" + tema.toString() + ", valoracion=" + valoracion
                + ", ip=" + ip + "nivel de estudio="+nivelEstudio+"]";
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        final int prime = 31;
        hash = hash * prime + (this.valoracion == null ? 0 : this.valoracion.hashCode());
        hash = hash * prime + (this.ip == null ? 0 : this.ip.hashCode());
        hash = hash * prime + this.id;
        hash = hash * prime + (this.nivelEstudio.valor == null ? 0 : this.nivelEstudio.valor.hashCode());
        return hash;
        
    }    

}
