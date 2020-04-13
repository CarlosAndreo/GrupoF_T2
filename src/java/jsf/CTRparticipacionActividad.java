/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.Actividad;
import grupof.Alumno;
import grupof.ParticipacionEnActividad;
import grupof.Usuario;
import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
/**
 *
 * @author Alex
 * Esta clase muestra las solicitudes de los alumnos, para formar parte de las 
 * actividades
 */
@Named(value ="ListaSolicitudes")   
@SessionScoped

public class CTRparticipacionActividad implements Serializable{
    
    private ArrayList<Actividad> actividades;
    private Actividad actividad; 
    private Usuario user;
    
    public CTRparticipacionActividad() throws ParseException{
        actividades = new ArrayList<>();
        user = new Usuario("Pepe", "Trol");
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        actividades.add(new Actividad(new Long(1), "Avanzadilla al tibet", dateformat3.parse("04/07/1998"), dateformat3.parse("04/07/2020"),user, "En curso"));
    }
    
    public String gestionar(){
        return "gestionarSolicitud.xhtml";
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }


}
