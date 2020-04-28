/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupof;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class ParticipacionEnActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Fecha", unique = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Fecha;
    private Long IDParticipacion;
    private Integer Nota;
    private String ComentariosNota;
    private Integer HorasDedicadas;
    private String Observaciones;
    private String Estado;
   
    @ManyToOne
    private Actividad participantes;
    @ManyToOne
    private Usuario participaciones;
   
  
    


    public ParticipacionEnActividad(Long IDParticipacion, Date Fecha, Integer Nota, String ComentariosNota, Integer HorasDedicadas, String Observaciones, String Estado) {
        this.IDParticipacion = IDParticipacion;
        this.Fecha = Fecha;
        this.Nota = Nota;
        this.ComentariosNota = ComentariosNota;
        this.HorasDedicadas = HorasDedicadas;
        this.Observaciones = Observaciones;
        this.Estado = Estado;
    }

    public Actividad getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Actividad participantes) {
        this.participantes = participantes;
    }

    public Usuario getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(Usuario participaciones) {
        this.participaciones = participaciones;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    public Long getIDParticipacion() {
        return IDParticipacion;
    }

    public void setIDParticipacion(Long IDParticipacion) {
        this.IDParticipacion = IDParticipacion;
    }

    public Integer getNota() {
        return Nota;
    }


    public void setNota(Integer Nota) {
        this.Nota = Nota;
    }

    public String getComentariosNota() {
        return ComentariosNota;
    }

    public void setComentariosNota(String ComentariosNota) {
        this.ComentariosNota = ComentariosNota;
    }

    public Integer getHorasDedicadas() {
        return HorasDedicadas;
    }

    public void setHorasDedicadas(Integer HorasDedicadas) {
        this.HorasDedicadas = HorasDedicadas;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDParticipacion != null ? IDParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipacionEnActividad)) {
            return false;
        }
        ParticipacionEnActividad other = (ParticipacionEnActividad) object;
        if ((this.IDParticipacion == null && other.IDParticipacion != null) || (this.IDParticipacion != null && !this.IDParticipacion.equals(other.IDParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.ParticipacionEnActividad[ id=" + IDParticipacion + " ]";
    }
    
}
