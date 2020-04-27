/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.Noticia;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */

@Named(value ="ListaNoticias")
@SessionScoped
public class NoticiasController implements Serializable{
    private Noticia noticiaEJB;
    private ArrayList<Noticia> noticias;
    private Noticia noticia = new Noticia();
    
    public NoticiasController() throws ParseException{
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        noticias = new ArrayList<>();
        Noticia notice = new Noticia(new Long(1), "CORONAVIRUS", "Se empieza a levantar un poco el confinamiento", dateformat3.parse("02/07/2020"));
        Noticia notice2 = new Noticia(new Long(2), "MADRID NECESITA COMIDA", "Debido al coronavirus", dateformat3.parse("05/03/2020"));
        
        noticias.add(notice); 
        noticias.add(notice2);   
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    
    public String createNoticia(){
        return "crearNoticia.xhtml";
    }
    
    /*public String create(String Titulo, String Descripcion, Date fecha){
       SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
       noticia = new Noticia(new Long(noticias.size()+1), Titulo, Descripcion, fecha);
       noticias.add(noticia);
       return "noticias.xhtml";
    }*/
    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    public String verNoticia(){
        return "verNoticia.xhtml";
    }
    
    public String modificarNoticia(){
        return "modificarNoticia.xhtml";
    }
    
    public String borrarNoticia(int id){
         noticias.remove(id-1);
         return "noticias.xhtml";          
    }
    
    public Noticia getById(int id){
        return noticias.get(id);
    }
    
   /* public modificarNoticia(Long id, String Titulo, String Descripcion, Date fecha){
       
    }*/
    
    
}

