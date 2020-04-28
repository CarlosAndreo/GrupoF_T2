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
public class Organizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodProyecto;
    private String Nombre;
    private String Sede;
    private String proposito;
    @OneToMany(mappedBy="creadorONG")
    private List<Actividad> Actividades;
    @OneToMany(mappedBy="valoracionONG")
    private List<ValoracionPrivada> valoraciones;
    @OneToMany
    private List<Noticia> noticias;

     @OneToMany(mappedBy="creadorNoticia")
    private List<Noticia> noticiasCreadas;
     
    public List<Noticia> getNoticias() {
        return noticias;
    }

    public List<Noticia> getNoticiasCreadas() {
        return noticiasCreadas;
    }

    public void setNoticiasCreadas(List<Noticia> noticiasCreadas) {
        this.noticiasCreadas = noticiasCreadas;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
    
    public Organizacion(String nombre){
        this.Nombre = nombre;
    }
    
    public Organizacion(Long CodProyecto, String nombre, String sede, String proposito){
        setCodProyecto(CodProyecto);
        setNombre(nombre);
        setSede(sede);
        setProposito(proposito);
    }
    public Long getCodProyecto() {
        return CodProyecto;
    }

    public void setCodProyecto(Long CodProyecto) {
        this.CodProyecto = CodProyecto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public List<Actividad> getActividades() {
        return Actividades;
    }

    public void setActividades(List<Actividad> Actividades) {
        this.Actividades = Actividades;
    }

    public List<ValoracionPrivada> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<ValoracionPrivada> valoraciones) {
        this.valoraciones = valoraciones;
    }
    
    public Organizacion(){
        
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CodProyecto != null ? CodProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizacion)) {
            return false;
        }
        Organizacion other = (Organizacion) object;
        if ((this.CodProyecto == null && other.CodProyecto != null) || (this.CodProyecto != null && !this.CodProyecto.equals(other.CodProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Organizacion[ id=" + CodProyecto + " ]";
    }
    
}
