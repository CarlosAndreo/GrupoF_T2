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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
public CRUDActividadesController(){
    actividades = new ArrayList<>();
    actividades.add(new Actividad(new Long(1),"Hands on Kuala Lumpur",new Date(21/11/2020),new Date(25/11/2020),"Kuala Lumpur","Actividad correspondiente al lavado de manos","Conocimientos previos del lavado de mano (Curso Lavado de manos de la Complutense)","Voluntariado","Abierta"));
    
}

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
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
