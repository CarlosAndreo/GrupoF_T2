/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupof;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


/**
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable {

    Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setUserId(Long UserID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public enum Rol{
        PDI,PAS,ALUMNO,GESTOR, ORGANIZACION
     
    };
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserID;
    private String Nombre;
    private String Apellidos;
    private String Password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNacimiento;
    @Column(name="DNI", unique = true)
    private String DNI;
    private String email;
    private String direccion;
    private String formacion;
    private String foto;
    private Integer telefono;
    private String idioma;
    private Rol Rol;
    @OneToMany
    private List<ParticipacionEnActividad> participantes;
    @OneToMany//Entidad debil
    private List<Matching> matching;
    @OneToMany
    private List<Mensaje> mensajes;
    @OneToMany
    private List<ValoracionPrivada> valoraciones;
    @OneToMany
    private List<ValoracionPublica> valoracionesPublicas;
    private Organizacion org;
    
    public Usuario(Long cod,String email,String pass,Rol rol){
        setUserID(cod);
        setEmail(email);
        setPassword(pass);
        setRol(rol);
    }
    
    public Usuario( String nombre, String apellidos){
     
        setNombre(nombre);
        setApellidos(apellidos);
    }
    public Usuario(String email,String pass,Rol tipo){
        setEmail(email);
        setPassword(pass);
        setRol(tipo);
    }

    public Usuario(Long UserID, String Nombre, String Apellidos, String Password, Date FechaNacimiento, String DNI, String email, String direccion, String formacion, Integer telefono, String idioma, Rol Rol) {       
        setUserID(UserID);
        setNombre(Nombre);
        setApellidos(Apellidos);
        setPassword(Password);
        setFechaNacimiento(FechaNacimiento);
        setDNI(DNI);
        setEmail(email);
        setDireccion(direccion);
        setFormacion(formacion);
        setTelefono(telefono);
        setIdioma(idioma);
        setRol(Rol);

    }
    

    public Usuario(String Nombre, String Apellidos, String DNI,String email) {       
        
        setNombre(Nombre);
        setApellidos(Apellidos);
        setDNI(DNI);
        setEmail(email);
     

    }
    
    public Usuario(String email, String password, Rol rol, Organizacion ong){
        setEmail(email);
        setPassword(password);
        setRol(rol);
        setOrg(ong);
    }

    public Organizacion getOrg() {
        return org;
    }

    public void setOrg(Organizacion org) {
        this.org = org;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    public List<ParticipacionEnActividad> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipacionEnActividad> participantes) {
        this.participantes = participantes;
    }

    public List<Matching> getMatching() {
        return matching;
    }

    public void setMatching(List<Matching> matching) {
        this.matching = matching;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public List<ValoracionPrivada> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<ValoracionPrivada> valoraciones) {
        this.valoraciones = valoraciones;
    }  

    public List<ValoracionPublica> getValoracionesPublicas() {
        return valoracionesPublicas;
    }

    public void setValoracionesPublicas(List<ValoracionPublica> valoracionesPublicas) {
        this.valoracionesPublicas = valoracionesPublicas;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (UserID != null ? UserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.UserID == null && other.UserID != null) || (this.UserID != null && !this.UserID.equals(other.UserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupof.Usuario[ id=" + UserID + " ]";
    }
    
}
