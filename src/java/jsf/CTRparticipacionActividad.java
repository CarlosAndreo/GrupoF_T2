/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.Actividad;
import grupof.Alumno;
import grupof.Organizacion;
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
    private ArrayList<Actividad> actRechazadas;
    private Actividad actividad; 
    
    
    public CTRparticipacionActividad() throws ParseException{
        actividades = new ArrayList<>();
        actRechazadas = new ArrayList<>();
        
        Organizacion ong = new Organizacion("Caritas");
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        actividades.add(new Actividad(new Long(1), "Avanzadilla al tibet", dateformat3.parse("04/07/1998"), dateformat3.parse("04/07/2020"),ong, "Sin comenzar","tibet","Es una actividad que pretende realizar una caminita hacia al tibet","Tener minimo dos piernas","Voluntariado","Pendiente"));
        actRechazadas.add(new Actividad(new Long(2), "Day Zero", dateformat3.parse("04/07/1999"), dateformat3.parse("04/07/2020"), "Sin comenzar","japón","Es una actividad que pretende inculcar valores","Tener  nivel de inglés","Voluntariado","Rechazada","sin posibilidad de poder hacerlo en japón, preferiblemente cambiar destino"));
        actRechazadas.add(new Actividad(new Long(3), "Encuentro con niños", dateformat3.parse("04/07/2000"), dateformat3.parse("04/08/2021"), "Sin comenzar","la palmilla","Es una actividad que pretende lograr que los niños se sientan bien","Saber de educación","Voluntariado","Rechazada" ,"barrio muy conflictivo, mejor cambiar de localización"));
        
    }

    public ArrayList<Actividad> getActRechazadas() {
        return actRechazadas;
    }

    public void setActRechazadas(ArrayList<Actividad> actRechazadas) {
        this.actRechazadas = actRechazadas;
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

    public String modificarSolicitud(){
        return "modificarSolicitud.xhtml";
    }
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }


}
