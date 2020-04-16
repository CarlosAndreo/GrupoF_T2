/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupof;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IDMensaje;
    private String Texto;
    private String Asunto;
    
    
    @OneToMany
    private List<Usuario> Usuarios;

    public Long getIDMensaje() {
        return IDMensaje;
    }

    public void setIDMensaje(Long IDMensaje) {
        this.IDMensaje = IDMensaje;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDMensaje != null ? IDMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.IDMensaje == null && other.IDMensaje != null) || (this.IDMensaje != null && !this.IDMensaje.equals(other.IDMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Mensaje[ id=" + IDMensaje + " ]";
    }
    
}
