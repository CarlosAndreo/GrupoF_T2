/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import grupof.ValoracionPublica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fabri
 */
@Named ( value = "ValoracionesPublicas")
@SessionScoped
public class valoracionController implements Serializable {
    
    private List<ValoracionPublica> valoraciones ;
    private ValoracionPublica v = new ValoracionPublica();
    private Long ID = new Long(1);
    
    public valoracionController() {
        valoraciones = new ArrayList<>();
        valoraciones.add(new ValoracionPublica(new Long (1), 7, "Buena actividad"));
    }

    public String crear(){
        v = new ValoracionPublica(this.ID);
        ID++;
        valoraciones.add(v);
        return "CRUDActividades.xhtml";
    }
    
    public ValoracionPublica getV() {
        return v;
    }

    public void setV(ValoracionPublica v) {
        this.v = v;
    }

    public void setValoraciones(List<ValoracionPublica> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public List<ValoracionPublica> getValoraciones() {
        return valoraciones;
    }
}
