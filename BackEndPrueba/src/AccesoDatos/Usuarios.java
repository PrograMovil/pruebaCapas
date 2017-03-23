/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaNegocio.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SheshoVega
 */
public class Usuarios extends AccesoDatos {

    public Usuarios() {
    }
       
    private Usuario toUsuario(ResultSet rs) throws Exception {
        Usuario obj = new Usuario();
        obj.setId(rs.getString("id"));
        obj.setPass(rs.getString("pass"));
        return obj;
    }
    public Usuario getUsuario(String id) throws SQLException, Exception{
        String tableName = "Usuarios";
        String param = "id = '%s'";
        param = String.format(param, id);
        ResultSet rs = super.getData(tableName, param);
        if (rs.next()) {
            return toUsuario(rs);
        } else {
            return null;
        }
    }
}
