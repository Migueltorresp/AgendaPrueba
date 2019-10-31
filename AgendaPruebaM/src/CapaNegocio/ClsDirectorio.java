/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fundamentos DS
 */
public class ClsDirectorio {
    private int _clave;
    private String _nom;
    private String _apell;
    private int  _telf;
   
    
    public ClsDirectorio(){
     _clave=0;
     _nom=null;
     _apell=null;
     _telf=0;
       
    }
    public void leer(ResultSet dato) throws SQLException{
          _clave=dato.getInt("clave");
     _nom=dato.getString("nom");
     _apell=dato.getString("apell");
     _telf=dato.getInt("telf");
       
    }

    public int getClave() {
        return _clave;
    }

    public void setClave(int _claveProducto) {
        this._clave = _claveProducto;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nomProducto) {
        this._nom = _nomProducto;
    }

    public String getapell() {
        return _apell;
    }

    public void setapell(String _precioProducto) {
        this._apell = _precioProducto;
    }

    public int gettelf() {
        return _telf;
    }

    public void settelf(int _cantProducto) {
        this._telf = _cantProducto;
    }

   
}
