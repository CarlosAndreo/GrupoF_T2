/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import grupof.Actividad;
import grupof.ParticipacionEnActividad;
import grupof.Usuario;
import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author juanky
 */

@Named(value ="Evaluaciones")
@SessionScoped
public class EvaluacionesController implements Serializable {
    private ArrayList<ParticipacionEnActividad> participaciones;
    private Usuario usuario;
    private Actividad actividad;

    private ParticipacionEnActividad p;

    public ArrayList<ParticipacionEnActividad> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(ArrayList<ParticipacionEnActividad> participaciones) {
        this.participaciones = participaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    public EvaluacionesController() throws ParseException {
        participaciones = new ArrayList<>();
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        
        participaciones.add(new ParticipacionEnActividad(new Long(1),dateformat3.parse("21/11/2020"), 8 , "Perfe", 16, "Todo perfe","Evaluado"));
        participaciones.add(new ParticipacionEnActividad(new Long(2),dateformat3.parse("22/11/2020"), 7 , "Correcto", 15, "Todo bien","Evaluado"));
        participaciones.add(new ParticipacionEnActividad(new Long(3),dateformat3.parse("23/11/2020"), 6 , "Bien", 13, "Todo perfe","Evaluado"));
        participaciones.add(new ParticipacionEnActividad(new Long(4),dateformat3.parse("24/11/2020"), 9 , "Excelente", 18, "Todo perfe","Evaluado"));
        participaciones.add(new ParticipacionEnActividad(new Long(5),dateformat3.parse("25/11/2020"), 0 , " ", 0, "","No evaluado"));
        p = new ParticipacionEnActividad(new Long(5),dateformat3.parse("25/11/2020"), 0 , " ", 0, "","No evaluado");
    }
    
    public String home(){
        //No inicia sesion
        if(getUsuario()==null){
            return "login.xhtml";
        }
        //Usuario GESTOR
        if(getUsuario().getRol().equals(getUsuario().getRol().GESTOR)){
            return "CRUDActividadesController.xhtml";
        }
        return null;
    }
    
     public String logout(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    public ParticipacionEnActividad getP() {
        return p;
    }

    public void setP(ParticipacionEnActividad p) {
        this.p = p;
    }
     
     
}