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
public class Gestor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodGestor;
    private String Usuario;
    private String Contrasenia;
    @OneToMany
    private List<Noticia> noticias;
    @OneToMany
    private List<Actividad> Actividades;

    public Gestor(Long codGestor,String Usuario,String pass){
        this.CodGestor=codGestor;
        this.Usuario=Usuario;
        this.Contrasenia=pass;
    }
    public Long getCodGestor() {
        return CodGestor;
    }

    public void setCodGestor(Long CodGestor) {
        this.CodGestor = CodGestor;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Actividad> getActividades() {
        return Actividades;
    }

    public void setActividades(List<Actividad> Actividades) {
        this.Actividades = Actividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CodGestor != null ? CodGestor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestor)) {
            return false;
        }
        Gestor other = (Gestor) object;
        if ((this.CodGestor == null && other.CodGestor != null) || (this.CodGestor != null && !this.CodGestor.equals(other.CodGestor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Gestor[ id=" + CodGestor + " ]";
    }
}
