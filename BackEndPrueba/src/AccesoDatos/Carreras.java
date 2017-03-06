/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaNegocio.Carrera;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SheshoVega
 */
public class Carreras extends AccesoDatos {
    
    public int addCarrera(Carrera c){
        String tableAndParams = "Carreras(codigo,nombre,titulo)";
        String values = "'%s','%s','%s'";
        values = String.format(values,c.getCodigo(),c.getNombre(),c.getTitulo());
        return super.addData(tableAndParams, values);
    }
    
    public int deleteCarrera(Carrera c){
        String tableName = "Carreras";
        String query = "codigo='%s'";
        query = String.format(query, c.getCodigo());
        return super.deleteData(tableName, query);
    }
    
    public int updateCarrera(Carrera c){
        String tableName = "Carreras";
        String tableParams = "nombre='%s', titulo='%s' where codigo='%s'";
        tableParams = String.format(tableParams, c.getNombre(), c.getTitulo(), c.getCodigo());
        return super.updateData(tableName, tableParams);
    }
    
    private Carrera toCarrera(ResultSet rs) throws Exception {
        Carrera obj = new Carrera();
        obj.setCodigo(rs.getString("codigo"));
        obj.setNombre(rs.getString("nombre"));
        obj.setTitulo(rs.getString("titulo"));
        return obj;
    }
    
    public Carrera getCarrera(String codigo) throws SQLException, Exception{
        String tableName = "Carreras";
        String param = "codigo = '%s'";
        param = String.format(param, codigo);
        ResultSet rs = super.getData(tableName, param);
        if (rs.next()) {
            return toCarrera(rs);
        } else {
            return null;
        }
    }
    
}
