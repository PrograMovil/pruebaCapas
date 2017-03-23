/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.Carreras;
import LogicaNegocio.Carrera;

import java.io.*;
import java.net.*;


class Server implements Runnable {

    public Server() {
        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    @Override
    public void run() {
//        Variables
        Carrera carreraRecibida;
        String ipClient ="127.0.0.1";
        Control ctrl = new Control();
        String responseMsg = "";
        
        System.out.println("Server Corriendo!");
        
        try {
//            Server socket para recibir las peticiones
            ServerSocket miServicio = new ServerSocket(9999);
            while(true){
//                Recibiendo la Carrera
                Socket socketConectado = miServicio.accept();
                ObjectInputStream carreraDatos = new ObjectInputStream(socketConectado.getInputStream());
                carreraRecibida = (Carrera) carreraDatos.readObject();
                System.out.println(carreraRecibida.toString());
                
//                Almacenando la carrera en la base de datos y comunicar registro al cliente
                Socket toCliente = new Socket(ipClient, 9090);
                DataOutputStream flujoToClient = new DataOutputStream(toCliente.getOutputStream());
                if(ctrl.addCarrera(carreraRecibida) == 1){
                    responseMsg = "Carrera agregada!";
                }else{
                    responseMsg = "ERROR: Carrera NO agregada!";
                }
                flujoToClient.writeUTF(responseMsg);
                
//                Cerrando socket para el cliente
                toCliente.close();
//                Cerrando socket del server
                socketConectado.close();
            } 

        } catch (IOException ex) {
            System.err.println("Exception: " + ex );
        } catch (ClassNotFoundException ex) {
            System.err.println("Exception: " + ex );
        }

    }

}

public class Main {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        
//        Sockets para la conexion con las interfaces.
//        Server servidor = new Server();
        

     

//                          PRUEBAS DE CRUD
//
//        Carrera car = new Carrera("001","Informatica","Ingenieria en Sistemas");
//        Control ctrl = new Control();
//
//
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

//        Carrera car2 = ctrl.getCarrera("100");
//        System.out.println(car2.toString());

    }
    
}
