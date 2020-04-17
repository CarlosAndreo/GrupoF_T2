/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;


import grupof.Organizacion;
import grupof.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "controlAutorizacion")
@SessionScoped
public class controlAutorizacion implements Serializable {

    private Usuario usuario;
    
    private Organizacion org;
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Long getID(){
        return usuario.getUserID();
    }

    public Usuario getUsuario() {
        return usuario;
    }
   
    public Organizacion getOrg() {
        return org;
    }

    public void setOrg(Organizacion org) {
        this.org = org;
    }
    
  
    public String CRUDActividades(){
        return "CRUDActividades.xhtml";
    }
    
    public String ParticipacionActividad(){
        return "participacionActividad.xhtml";
    }
    
    public String Noticias(){
        return "noticias.xhtml";
    }
    
    public String ApS(){
        return "ApS.xhtml";
    }
    
    public String perfilUsuario(){
        return "miPerfilUsuario.xhtml";
    }
    
    public String EvaluarUser(){
        return "evaluaciones.xhtml";
    }
    
    public String porRealizar(){
        return "inicio.xhtml";
    }
    
    public String home() {
        // Devuelve la página Home dependiendo del rol del usuario
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().GESTOR)){
            return "inicio.xhtml";
        }
  
        if(getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)){
            return "inicio.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().PDI)){
            return "inicio.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().PAS)){
            return "inicio.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ORGANIZACION)){
            return "inicio.xhtml";
        }
        return null;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public controlAutorizacion() {
    }
}
