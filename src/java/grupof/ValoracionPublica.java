/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupof;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class ValoracionPublica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDValoracion;
    private Integer Calificacion;
    private String ComentariosUsuario;
    @ManyToOne
    private Usuario creador;
    
    @ManyToOne
    private Actividad act;
    private Long ID = new Long(1);
    
    public ValoracionPublica() {
        
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Actividad getAct() {
        return act;
    }

    public void setAct(Actividad act) {
        this.act = act;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    public ValoracionPublica(Long id){
        this.IDValoracion = id;
    }
    
    public ValoracionPublica(Long IDValoracion, Integer Calificacion, String ComentariosUsuario) {
        this.IDValoracion = IDValoracion;
        this.Calificacion = Calificacion;
        this.ComentariosUsuario = ComentariosUsuario;
    }
    
  

    public Long getIDValoracion() {
        return IDValoracion;
    }

    public void setIDValoracion(Long IDValoracion) {
        this.IDValoracion = IDValoracion;
    }

    public Integer getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(Integer Calificacion) {
        this.Calificacion = Calificacion;
    }

    public String getComentariosUsuario() {
        return ComentariosUsuario;
    }

    public void setComentariosUsuario(String ComentariosUsuario) {
        this.ComentariosUsuario = ComentariosUsuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDValoracion != null ? IDValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionPublica)) {
            return false;
        }
        ValoracionPublica other = (ValoracionPublica) object;
        if ((this.IDValoracion == null && other.IDValoracion != null) || (this.IDValoracion != null && !this.IDValoracion.equals(other.IDValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Valoracion[ id=" + IDValoracion + " ]";
    }
    
}
