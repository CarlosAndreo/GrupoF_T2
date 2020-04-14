/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;



import grupof.Usuario;
import grupof.Usuario.Rol;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 * usuario Gestor credenciales:
 *  email: bd@mail.com
 * pass:bd
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String email;
    private String contrasenia;
    private List<Usuario> usuarios;
    
    @Inject
    private controlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<Usuario>();
      
       
       usuarios.add(new Usuario("paco@mail.com","pass",Rol.ALUMNO));
       usuarios.add(new Usuario("roberto@uma.es","bd",Rol.ALUMNO));
       usuarios.add(new Usuario("ad@hotmail.es","ad",Rol.PDI));
       usuarios.add(new Usuario("bd@mail.com","bd",Rol.GESTOR));
       usuarios.add(new Usuario("pas@mail.com","pas",Rol.PAS));
       usuarios.add(new Usuario("ong@correo.com","ong",Rol.ORGANIZACION));
        
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
