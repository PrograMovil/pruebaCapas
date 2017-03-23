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

public class InterfazConsola implements Runnable {
    String menuOption = "";
    String responseServer = "Conectando...";
    String ipServidor ="127.0.0.1";

    public void setResponseServer(String responseServer) {
        this.responseServer = responseServer;
    }
    
    
    public InterfazConsola() {
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
//                this.setResponseServer(dataRecibida);
                System.out.println("\n" + dataRecibida + "\n");
            }

        } catch (IOException ex) {
            System.err.println("Exception: "+ ex);
        }
    }
    
    public void menu() throws InterruptedException {
        Thread.sleep(300);
        Scanner menuEscaner = new Scanner(System.in);
//        System.out.println(this.responseServer);
        System.out.print("<---------- MENU ---------->"
                + "\n 1 - Regristrar Carrera."
                + "\n 2 - Eliminar Carrera."
                + "\n 3 - Actualizar Carrera."
                + "\n 4 - Buscar Carrera."
                + "\n 5 - Salir."
                + "\n\n Seleccione una opción:");
        this.menuOption = menuEscaner.nextLine(); 
    }
    public void routerMenu() throws InterruptedException{
        
//        this.menu();
        switch(this.menuOption){
            case "1":{
                System.out.println("< ---------- Registrar Carrera ---------->.");
                
                this.registrarCarrera();
                
                this.menu();
                this.routerMenu();
            }
            break;
            case "2":{
                System.out.println("Opcion 2.");
                this.menu();
                this.routerMenu();
            }
            break;
            case "3":{
                System.out.println("Opcion 3.");
                this.menu();
                this.routerMenu();
            }
            break;
            case "4":{
                System.out.println("Opcion 4.");
                this.menu();
                this.routerMenu();
            }
            break;
            case "5":{
                System.exit(0);
            }
            break;
            default: {
                System.out.println("Error, opcion invalida.");
                this.menu();
                this.routerMenu();
            }
            break;
        }
    }
    
    public void registrarCarrera(){
        try {
            Scanner entradaEscaner = new Scanner(System.in);
            Carrera carrera = new Carrera();
            
            Socket cliente = new Socket(this.ipServidor, 9999);
            
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
    public static void main(String[] args) throws Exception {
//        Sockets para la conexion con las interfaces.
//        ResponseListener resposes = new ResponseListener();
        
        
        InterfazConsola interfaz = new InterfazConsola();
        interfaz.menu();
        interfaz.routerMenu();
        
        
        
        
        
        
//        try {
//            Scanner entradaEscaner = new Scanner(System.in);
//            Carrera carrera = new Carrera();
//            
//            Socket cliente = new Socket(ipServidor, 9999);
//            
//            //Mandar una Carrera
//            System.out.println("Ingrese el Codigo de la carrera:");
//            carrera.setCodigo(entradaEscaner.nextLine());
//            System.out.println("Ingrese el nombre de la carrera:");
//            carrera.setNombre(entradaEscaner.nextLine());
//            System.out.println("Ingrese el titulo de la carrera:");
//            carrera.setTitulo(entradaEscaner.nextLine());
//            
//            ObjectOutputStream carreraDatos = new ObjectOutputStream(cliente.getOutputStream());
//            carreraDatos.writeObject(carrera);
//            carreraDatos.close();      
//            
//	} catch (UnknownHostException ex) {
//            System.err.println("Exception: " + ex );
//        } catch (Exception e) {
//            System.err.println("Exception: " + e );
//        }
      
    }

    
}
