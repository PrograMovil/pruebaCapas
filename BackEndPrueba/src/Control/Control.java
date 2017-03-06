/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.Carreras;
import LogicaNegocio.Carrera;

/**
 *
 * @author SheshoVega
 */
public class Control {
    Carreras carreras;

    public Control() {
        this.carreras = new Carreras();
    }
    
    public int addCarrera(Carrera ca){
        return this.carreras.addCarrera(ca);
    }
    
    public int deleteCarrera(Carrera ca){
        return this.carreras.deleteCarrera(ca);
    }
    
    public int updateCarrera(Carrera ca){
        return this.carreras.updateCarrera(ca);
    }
    
    public Carrera getCarrera(String id) throws Exception{
        return this.carreras.getCarrera(id);
    }
}
