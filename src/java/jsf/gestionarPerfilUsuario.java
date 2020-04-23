/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.Usuario;
import grupof.Usuario.Rol;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author GrupoF
 */
@Named(value ="PerfilUsuario")
@SessionScoped
public class gestionarPerfilUsuario implements Serializable{
    private ArrayList<Usuario> usuarios;
    private Usuario usuario;
    //Constructor
    /*
    public gestionarPerfilUsuario() {
    }*/
    
    
    public gestionarPerfilUsuario() throws ParseException {
        usuarios = new ArrayList<>();
        
        //Usuario u1 = new Usuario(new Long(1), "Alberto", "Aguilera", "alberto", dateformat3.parse("01/01/111"), "12456478W", "alberto@uma.es", "Avenida wela", "Es un pipas", "Foto", 12345679, "Espaniol", Rol.ALUMNO);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public Usuario getBy(int id){
        return usuarios.get(id);
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Long getId() {
        return usuario.getUserID();
    }

    public String getNombre() {
        return this.usuario.getNombre();
    }
    
    public String getApellidos() {
        return this.usuario.getApellidos();
    }
    
    public String getPassword(){
        return this.usuario.getPassword();
    }
    
    public Date getFechaNacimiento(){
        return this.usuario.getFechaNacimiento();
    }
    
    public String getDni(){
        return this.usuario.getDNI();
    }
    
    public String getEmail(){
        return this.usuario.getEmail();
    }
    
    public String getDireccion(){
        return this.usuario.getDireccion();
    }
    
    public String getFoto(){
        return this.usuario.getFoto();
    }
    
    public String getFormacion(){
        return this.usuario.getEmail();
    }
    
    public Integer getTelefono(){
        return this.usuario.getTelefono();
    }
    
    public String getIdioma(){
        return this.usuario.getIdioma();
    }
    
    public Rol getRol(){
        return this.usuario.getRol();
    }
    /*
    public Usuario verPerfil(Long id)throws ParseException{
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        return this.usuario = new Usuario(new Long(1), "Alberto", "Aguilera", "alberto", dateformat3.parse("01/01/111"), "12456478W", "alberto@uma.es", "Avenida wela", "Es un pipas", "Foto", 12345679, "Espaniol", Rol.ALUMNO);
    }
    */
    public String home(){
        //No inicia sesion
        if(getUsuario()==null){
            return "login.xhtml";
        }
        //Usuario ALUMNO
        if(getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)){
            return "miPerfilUsuario.xhtml";
        }
        return null;
    }
    public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
}