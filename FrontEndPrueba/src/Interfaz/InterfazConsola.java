/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import java.io.*;
import java.net.*;
import java.util.Scanner;


import LogicaNegocio.Carrera;

class ResponseListener implements Runnable{

    public ResponseListener() {
        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket responseListener = new ServerSocket(9090);

            while(true){
                Socket socketResponses = responseListener.accept();
                DataInputStream flujoEntrada = new DataInputStream(socketResponses.getInputStream());
                String dataRecibida = flujoEntrada.readUTF();
                System.out.println(dataRecibida);
            }

        } catch (IOException ex) {
            System.err.println("Exception: "+ ex);
        }
    }

}

public class InterfazConsola {
    
    public static void main(String[] args) throws Exception {
//        Sockets para la conexion con las interfaces.
        ResponseListener resposes = new ResponseListener();
        String ipServidor ="127.0.0.1";
        
        try {
            Scanner entradaEscaner = new Scanner(System.in);
            Carrera carrera = new Carrera();
            
            Socket cliente = new Socket(ipServidor, 9999);
            
            //Mandar una Carrera
            System.out.println("Ingrese el Codigo de la carrera:");
            carrera.setCodigo(entradaEscaner.nextLine());
            System.out.println("Ingrese el nombre de la carrera:");
            carrera.setNombre(entradaEscaner.nextLine());
            System.out.println("Ingrese el titulo de la carrera:");
            carrera.setTitulo(entradaEscaner.nextLine());
            
            ObjectOutputStream carreraDatos = new ObjectOutputStream(cliente.getOutputStream());
            carreraDatos.writeObject(carrera);
            carreraDatos.close();      
            
	} catch (UnknownHostException ex) {
            System.err.println("Exception: " + ex );
        } catch (Exception e) {
            System.err.println("Exception: " + e );
        }
      
    }

    
}
