/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fundamentos DS
 */
public class ClsConexion {
    private Connection base;
    private Statement tabla;
    private ResultSet agenda;
    
    public ClsConexion(String dirbase) {
        try {
            base = DriverManager.getConnection("jdbc:ucanaccess://" + dirbase);
            System.out.println("***CONEXIÓN EXITOSA***");
            tabla = base.createStatement(ResultSet.FETCH_UNKNOWN, ResultSet.TYPE_SCROLL_SENSITIVE);

        } catch (Exception err) {
            System.out.println("***CONEXIÓN FALLIDA***" + err);
        }

    }
    
    public ResultSet _agenda() {
        return agenda;
    }
    
    public boolean consulta(String _tabla) throws SQLException {
        boolean comprobar = false;
        String comando = " SELECT * FROM " + _tabla;
        agenda = null;
        tabla.execute(comando);
        agenda = tabla.getResultSet();
        if (agenda != null) {
            comprobar = true;
        }
        return comprobar;
    }
    
    public boolean verAgenda(int clave) throws SQLException {
        agenda = null;
        boolean comprobar = false;
        String comando = "SELECT * Directorio WHERE IdDirectorio  = " + clave;
        tabla.execute(comando);
        agenda = tabla.getResultSet();
        if (agenda != null) {
            comprobar = true;
        }
        return comprobar;
    }
     
    public boolean nuevo (String n, String a, String t) throws SQLException {
        agenda = null;
        boolean registrar = false;
        try {
            String insertar = "INSERT INTO Directorio"
                    + "(Nombre,Apellido,Telefono)"
                    + "VALUES"
                    + "('" + n + "','" + a + "','" + t + "');";
            tabla = base.createStatement();
            tabla.execute(insertar);
            agenda = tabla.getResultSet();
            if (agenda != null) {
                registrar = true;
            }
        } catch (SQLException re) {
            System.out.println("No" + re);
        }
        return registrar;
    }
     
    
     
}
