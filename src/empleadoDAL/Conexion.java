
package empleadoDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Conexion {
     //3 parametros
    public static final String URL="jdbc:mysql://localhost:3306/bd_crud_java?useSSL=false&serverTimezone=UTC";
    public static final String USER="root";
    public static final String PASS="";
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    
    public static Connection getConectar(){
        Connection conexion=null;
        try {
            //conexion en 2 lineas
            Class.forName(DRIVER);
            conexion=DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Conexion exitosa");
            
        } catch (Exception e) {
            System.out.println("Error al conectar: "+e);
        }
        return conexion;
    }
    public static void main(String[] args) {
        Conexion.getConectar();
    }
    
}
