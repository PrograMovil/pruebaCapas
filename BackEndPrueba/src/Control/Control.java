/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.Carreras;
import AccesoDatos.Usuarios;
import LogicaNegocio.Carrera;

/**
 *
 * @author SheshoVega
 */
public class Control {
    Carreras carreras;
    Usuarios usuarios;

    public Control() {
        System.out.println("Creando Control Back");
        this.carreras = new Carreras();
        this.usuarios = new Usuarios();
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
    
    public int addCarreraServlet(String codigo, String nombre, String titulo){
        Carrera c = new Carrera(codigo,nombre,titulo);
        if(this.addCarrera(c) == 1){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int getUsuario(String id) throws Exception{
        if(this.usuarios.getUsuario(id) != null){
            return 1;
        }else{
            return 0;
        }
    }
    
    
}
