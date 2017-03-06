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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Carrera car = new Carrera("001","Informatica","Ingenieria en Sistemas");
        Control ctrl = new Control();
        
//        add
//        if(ctrl.addCarrera(car) == 1){
//            System.out.println("Carrera agregada!");
//        }else{
//            System.out.println("ERROR: Carrera NO agregada!");
//        }

//        update
//        car.setNombre("Ingenieria en Informatica");
//        if(ctrl.updateCarrera(car) == 1){
//            System.out.println("Carrera actualizada!");
//        }else{
//            System.out.println("ERROR: Carrera NO actualizada!");
//        }

//        delete
//        if(ctrl.deleteCarrera(car) == 1){
//            System.out.println("Carrera eliminada!");
//        }else{
//            System.out.println("ERROR: Carrera NO eliminada!");
//        }

        Carrera car2 = ctrl.getCarrera("100");
        System.out.println(car2.toString());
    }
    
}
