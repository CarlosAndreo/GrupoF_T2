/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.Noticia;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author aleex
 */

@Named(value ="ListaNoticias")
@SessionScoped
public class NoticiasController implements Serializable{
    
    private ArrayList<Noticia> noticias;
    
}
