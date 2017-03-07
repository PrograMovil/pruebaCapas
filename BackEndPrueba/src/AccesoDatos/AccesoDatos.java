/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;

/**
 *
 * @author juandediosmurillomorera
 */
public class AccesoDatos {
    static Database db;
    
//    static initializer block
//    ejecuta la inicializacion de la base cuando se cargue la clase
    static {
        initdb();
    }
        
    private static void initdb() {
        db = new Database(null, null, null);
    }
    
//    public AccesoDatos(){}
    
    public int addData(String tableAndParams,String values){
        String sql = "insert into "+ tableAndParams + "values(" + values + ")";
        int count = db.executeUpdate(sql);
        return count; //0 = fallo o registro repetido, 1 = exitoso
    }
    
    public int deleteData(String tableName, String query){
        String sql = "delete from " + tableName + " where " + query;
        int count = db.executeUpdate(sql);
        return count;
    }
    
    public int updateData(String tableName, String tableParams){
        String sql = "update " + tableName + " set " + tableParams;
        int count = db.executeUpdate(sql);
        return count;
    }
    
    public ResultSet getData(String tableName, String param){
        String sql = "select * from " + tableName + " o where o." + param;
        ResultSet rs = db.executeQuery(sql);
        return rs;        
    }
}
