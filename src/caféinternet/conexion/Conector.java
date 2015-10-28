/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caféinternet.conexion;
import java.sql.*;

/**
 *
 * @author David
 */
public class Conector {

private Connection con;
private String usuario;
private String server;
private String password;
private String puerto;
private String baseDatos;

    public Conector() {
        usuario = "root";
        password ="root";
        server = "127.0.0.1";
        puerto = "3306";
        baseDatos= "caféinternet";    
    }

    public Conector(String usuario, String server, String password, String puerto, String baseDatos) {
        this.usuario = usuario;
        this.server = server;
        this.password = password;
        this.puerto = puerto;
        this.baseDatos = baseDatos;
    }
    
    public Connection getCon()
    {
        try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            String stringConexion = "jdbc:mysql://"+server+":"+puerto+"/"+baseDatos;
            con = DriverManager.getConnection(stringConexion, usuario, password);
            return con;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
            return null;
        }   
    }
    
    public void cerrarConexion() throws SQLException
    {
        con.close();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }
    
    
}
