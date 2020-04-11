/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.Actividad;
import grupof.Usuario;
import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author aleex
 */
@Named(value ="ListaActividades")
@SessionScoped

public class CRUDActividadesController implements Serializable{
    

private ArrayList<Actividad> actividades;
private Usuario usuario;
private Actividad actividad;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
public CRUDActividadesController() throws ParseException{
    actividades = new ArrayList<>();
    SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
    
    actividades.add(new Actividad(new Long(1),"Hands on Kuala Lumpur",dateformat3.parse("21/11/2020"),dateformat3.parse("25/11/2020"),"Kuala Lumpur","Actividad correspondiente al lavado de manos","Conocimientos previos del lavado de mano (Curso Lavado de manos de la Complutense)","Voluntariado","Abierta"));
     actividades.add(new Actividad(new Long(2),"AfricaWorld",dateformat3.parse("23/02/2020"),dateformat3.parse("25/03/2020"),"Tanzania","Actividad correspondiente al lavado de manos","Conocimientos previos del lavado de mano (Curso Lavado de manos de la Complutense)","Voluntariado","Abierta"));
    
}

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
    
 public String borrarActividad(int id){
     actividades.remove(id-1);
     
     return "CRUDActividades.xhtml";
 }
    
 public String modificarActividad(){
     
     return "modificarActividad.xhtml";
 }
 
 public Actividad getById(int id){
 return actividades.get(id);
 }
 
 public String modificarVariables(int id,String nombre,Date fechaInicio,Date FechaFin,String local,String desc,String capNec,String tipo,String estado){
     
     getById(id).SetVariables("pp", getById(id).getFechaInicio(), FechaFin, local, desc, desc, tipo, "abierta");
     
     return "CRUDActividades.xhtml";
     
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
}
