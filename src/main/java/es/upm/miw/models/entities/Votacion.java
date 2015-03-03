package es.upm.miw.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Votacion { 
    public static final String TABLE = "votacion";

    public static final String ID = "id";
    
    public static final String IP = "ip";
    
    public static final String NIVEL_ESTUDIO = "nivel_estudio";

    public static final String TEMA = "tema";

    @Id
    @GeneratedValue
    @Column(name=ID)
    private Integer id;
    
    @Column(name=IP)
    private String ip;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_tema")
    private Tema tema;
    
    
    
    

}
