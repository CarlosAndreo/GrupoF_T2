/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.Mensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */
@Named(value="ListaMensajes")
@SessionScoped
public class CRMensajesController implements Serializable{
    
    private Mensaje m1;
    private List<Mensaje> mensajes;
    
    public CRMensajesController(){
        mensajes = new ArrayList<Mensaje>();
        m1 = new Mensaje();
        
       
        mensajes.add( new Mensaje(new Long(1),"pepe@mail.com","bd@uma.es","error inscripcion actividad","he tendio un error y necesito que me ayuden"));
        mensajes.add(new Mensaje(new Long(2),"ong@mail.com","zz@uma.es","problema","he tendio un problema "));
        
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    
    public String verMensaje(){
       return "verMensaje.xhtml";
     }
    
    public String borrarMensaje(int id){
        mensajes.remove(id-1);
        return "mensajesRecibidos.xhtml";
    }
    

    public Mensaje getM1() {
        return m1;
    }

    public void setM1(Mensaje m1) {
        this.m1 = m1;
    }
    
    
}
