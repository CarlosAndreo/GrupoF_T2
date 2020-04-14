/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupof;

import java.io.*;
import java.util.*;
import javax.persistence.*;
/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Entity
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CodActividad;
    private Integer Puntuacion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaFin;
    private String Localizacion;
    private String Descripcion;
    private String CapacidadesNecesarias;
    private String EstadoActividad;
    private String TipoActividad;
    private String NombreActividad;
    private String EstadoSolicitud;
    private Organizacion ong;
    @OneToMany
    private List<ParticipacionEnActividad> participantes;
    @OneToMany
    private List<ValoracionPublica> Valoracion;
    @ManyToMany
    @JoinTable(name="jnd_matc_act",joinColumns=@JoinColumn(name="actividad_fk"),inverseJoinColumns=@JoinColumn(name="matching_fk"))
    private List<Matching> matching;
    @OneToMany
    private List<Asignatura> Asignaturas;
    
    public Actividad(){
        
    }

    public Actividad(Long CodActividad, Integer Puntuacion, Date FechaInicio, Date FechaFin, String Localizacion, String Descripcion, String CapacidadesNecesarias, String EstadoActividad, String TipoActividad, String NombreActividad, String EstadoSolicitud, List<ParticipacionEnActividad> participantes, List<ValoracionPublica> Valoracion, List<Matching> matching, List<Asignatura> Asignaturas) {
        this.CodActividad = CodActividad;
        this.Puntuacion = Puntuacion;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Localizacion = Localizacion;
        this.Descripcion = Descripcion;
        this.CapacidadesNecesarias = CapacidadesNecesarias;
        this.EstadoActividad = EstadoActividad;
        this.TipoActividad = TipoActividad;
        this.NombreActividad = NombreActividad;
        this.EstadoSolicitud = EstadoSolicitud;
        this.participantes = participantes;
        this.Valoracion = Valoracion;
        this.matching = matching;
        this.Asignaturas = Asignaturas;
    }

   

    public Actividad(Long CodActividad, String NombreActividad, Date FechaInicio, Date FechaFin, String Localizacion, String Descripcion, String CapacidadesNecesarias, String TipoActividad, String EstadoActividad) {
        this.CodActividad = CodActividad;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Localizacion = Localizacion;
        this.Descripcion = Descripcion;
        this.CapacidadesNecesarias = CapacidadesNecesarias;
        this.EstadoActividad = EstadoActividad;
        this.TipoActividad = TipoActividad;
        this.NombreActividad = NombreActividad;
        
        
    }
    
    
    public Actividad(Long CodActividad, String NombreActividad, Date FechaInicio, Date FechaFin, Organizacion ong, String EstadoActividad,String Localizacion,String descripcion,String cap,String tipo, String estadoSol){
        this.CodActividad = CodActividad;
        this.NombreActividad = NombreActividad;
        this.FechaFin = FechaFin;
        this.FechaInicio = FechaInicio;
        this.ong=ong;
        this.EstadoActividad = EstadoActividad;
        this.EstadoSolicitud=estadoSol;
        this.Localizacion=Localizacion;
        this.Descripcion=descripcion;
        this.CapacidadesNecesarias=cap;
        this.TipoActividad=tipo;
    }

  
    public void SetVariables(String NombreActividad, Date FechaInicio, Date FechaFin, String Localizacion, String Descripcion, String CapacidadesNecesarias, String TipoActividad, String EstadoActividad){
         this.NombreActividad = NombreActividad;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Localizacion = Localizacion;
        this.Descripcion = Descripcion;
        this.CapacidadesNecesarias = CapacidadesNecesarias;
        this.TipoActividad = TipoActividad;
        this.EstadoActividad = EstadoActividad;
        
          
    }
    
    public Long getCodActividad() {
        return CodActividad;
    }

    public void setCodActividad(Long CodActividad) {
        this.CodActividad = CodActividad;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    public String getLocalizacion() {
        return Localizacion;
    }

    public void setLocalizacion(String Localizacion) {
        this.Localizacion = Localizacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCapacidadesNecesarias() {
        return CapacidadesNecesarias;
    }

    public void setCapacidadesNecesarias(String CapacidadesNecesarias) {
        this.CapacidadesNecesarias = CapacidadesNecesarias;
    }

    public String getEstadoActividad() {
        return EstadoActividad;
    }

    public void setEstadoActividad(String EstadoActividad) {
        this.EstadoActividad = EstadoActividad;
    }

    public String getTipoActividad() {
        return TipoActividad;
    }

    public void setTipoActividad(String TipoActividad) {
        this.TipoActividad = TipoActividad;
    }

    public String getNombreActividad() {
        return NombreActividad;
    }

    public void setNombreActividad(String NombreActividad) {
        this.NombreActividad = NombreActividad;
    }

    public String getEstadoSolicitud() {
        return EstadoSolicitud;
    }

    public void setEstadoSolicitud(String EstadoSolicitud) {
        this.EstadoSolicitud = EstadoSolicitud;
    }

    public List<ParticipacionEnActividad> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipacionEnActividad> participantes) {
        this.participantes = participantes;
    }

    public List<ValoracionPublica> getValoracion() {
        return Valoracion;
    }

    public void setValoracion(List<ValoracionPublica> Valoracion) {
        this.Valoracion = Valoracion;
    }

    public Integer getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(Integer Puntuacion) {
        this.Puntuacion = Puntuacion;
    }

    public List<Matching> getMatching() {
        return matching;
    }

    public void setMatching(List<Matching> matching) {
        this.matching = matching;
    }

    public List<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(List<Asignatura> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }

    public Organizacion getOng() {
        return ong;
    }

    public void setOng(Organizacion ong) {
        this.ong = ong;
    }
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CodActividad != null ? CodActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.CodActividad == null && other.CodActividad != null) || (this.CodActividad != null && !this.CodActividad.equals(other.CodActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Actividad[ id=" +  CodActividad + " ]";
    }
    
}
