/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;



import grupof.Usuario;
import grupof.Usuario.Rol;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import grupof.Gestor;
import grupof.Organizacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *  SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 * usuario Gestor credenciales:
 * email: bd@mail.com
 * pass:bd
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String email;
    private String contrasenia;
    private List<Usuario> usuarios;
    private Organizacion org;
    
   @Inject
    private controlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() throws ParseException {
       usuarios = new ArrayList<Usuario>();
      
       SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");  
       usuarios.add(new Usuario(new Long(1), "ALUMNO", "MARTINEZ", "alumno", dateformat3.parse("05/03/2020"), "12456478W", "alumno@uma.es", "Avenida Casa Lorin", "Ingeniero Informatico", 12345679, "Espaniol", Rol.ALUMNO)); 
       usuarios.add(new Usuario(new Long(2), "PDI", "", "pdi", dateformat3.parse("05/03/2020"), "12456478W", "pdi@uma.es", "paseo de los moros", "si", 12345679, "Espaniol", Rol.PDI)); 
       usuarios.add(new Usuario(new Long(3), "PAS", "", "pas", dateformat3.parse("05/03/2020"), "12456478W", "pas@uma.es", "jefaso avenido", "si", 12345679, "Espaniol", Rol.PAS));
       usuarios.add(new Usuario(new Long(4),"admin@uma.es","admin",Rol.GESTOR));
       org =  new Organizacion(new Long(6), "Unicef", "Madrid", "Salvar vidas de las personas en malas condiciones");
       usuarios.add(new Usuario("org@uma.es", "org", Rol.ORGANIZACION, org));
    }
    
    public String borrarPerfil(int id){  
        usuarios.remove(id-1);
        return "logout.xhtml";
    }
         
    public List<Usuario> getUsuarios(){       
        return this.usuarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Organizacion getOrg() {
        return org;
    }

    public void setOrg(Organizacion org) {
        this.org = org;
    }
    
    public String autenticar() {
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        Iterator<Usuario> iter = usuarios.iterator();
        boolean pass = false;
        boolean user = false;
      
        Usuario usuario = null;
         
        while(iter.hasNext() && !user){
            usuario = iter.next();
            
            if(usuario.getEmail().equals(getEmail())){
                user = true;
                
                if(usuario.getPassword().equals(getContrasenia())){
                    pass = true;
                    ctrl.setUsuario(usuario);
                    ctrl.setOrg(org);
                  
                    return ctrl.home();
                }
            }
        }
        
        if(!user){
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"El usuario introducido no existe", "El usuario introducido no existe"));
            return null;
        }
        
        if(!pass){
            ctx.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"La contraseña introducida es incorrecta", "La contraseña introducida es incorrecta"));
            return null;
        }
        
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El método autenticar() no está implementado", "El método autenticar() no está implementado"));
        return null;
    }
}
