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
    private Organizacion ONG;
    //private Socios[] socios;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Long getID(){
        return usuario.getUserID();
    }

    public Usuario getUsuario() {
        return usuario;
    }

   /* public Organizacion getONG() {
        return ONG;
    }

    public void setONG(Organizacion ONG) {
        this.ONG = ONG;
    }
    */
   /* public Socios[] getSocios() {
        return socios;
    }
    */
    public String CRUDActividades(){
        return "CRUDActividades.xhtml";
    }
    public String ListaSocios(){
        return "listasocios.xhtml";
    }
    
    public String ListaNinos(){
        return "listaninos.xhtml";
    }
    
    public String NinosApadrinados(){
        return "listaninosapadrinados.xhtml";
    }
    
    public String Cuotas(){
        return "listacuotas.xhtml";
    }
    
    public String MisDatos(){
        return "socio.xhtml";
    }
    
    public String ListaEnvios(){
        return "envio.xhtml";
    }
    
public String ApS(){
    return "ApS.xhtml";
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
