/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SheshoVega
 */
public class Database {
    Connection cnx = null;
    
    
    public Database() {
        System.out.println("Hola desde Database");
        this.getConnection();
        if( this.cnx != null){
            System.out.println("Conexion a BD Exitosa");
        }else{
            System.out.println("Conexion a BD Cerrada!");
        }
        
    }
    
//    public Database(String servidorArg, String usuarioArg, String claveArg){
//        if (servidorArg!=null){
//            cnx=this.getConnection(servidorArg, usuarioArg, claveArg);
//        }
//        else{
//            cnx=this.getConnection(null, null, null);            
//        }
//    }
    
    public Connection getConnection(){
        try{
            
//            "jdbc:mysql://localhost:3306/pruebacapas";
            String servidor = PROTOCOLO+"//"+SERVIDOR+":"+PUERTO+"/"+BASEDATOS;
            System.out.println("El servidor es: "+servidor);
            String user = USUARIO;
            String pass = CLAVE;
            Class.forName(MANEJADOR_DB);
            this.cnx = DriverManager.getConnection(servidor, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Error en ClassNotFound");
            System.err.println(e.getMessage());
            this.cnx = null;
        }catch (SQLException e) {
            System.out.println("Error en SQL");
            System.err.println(e.getMessage());
            this.cnx = null;
        }catch(Exception e){
            System.err.println(e.getMessage());
            this.cnx = null;
        }finally {
//            System.out.println(this.cnx.toString());
            return this.cnx;
        }
//        try {
//            String servidor=(servidorArg==null?SERVIDOR:servidorArg);
//            String usuario=(usuarioArg==null?USUARIO:usuarioArg);
//            String clave=(claveArg==null?CLAVE:claveArg);
//            String URL_conexion=PROTOCOLO+"//"+ servidor+":"+PUERTO+"/"+BASEDATOS+"?user="+usuario+"&password="+clave;
//            Class.forName(MANEJADOR_DB).newInstance();
//            return DriverManager.getConnection(URL_conexion);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            System.exit(-1);
//        } 
//        return null;
    }
    
    public int executeUpdate(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public ResultSet executeUpdateWithKeys(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement,Statement.RETURN_GENERATED_KEYS);
            return stm.getGeneratedKeys();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet executeQuery(String statement){
        try {
            Statement stm = cnx.createStatement();
            return stm.executeQuery(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static final String MANEJADOR_DB = "com.mysql.jdbc.Driver";
    private static final String PROTOCOLO = "jdbc:mysql:";
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "3306";
    private static final String USUARIO = "root";
    private static final String CLAVE = "admin";
    private static final String BASEDATOS = "pruebaCapas";
}
