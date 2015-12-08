/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.*;
/**
 *
 * @author Alvaro
 */
public class AdminUsuario {
    conectate con;
  
  public AdminUsuario (){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/
   public void NuevoUsuario(String rut, String nombre, String apellido, String estado_usuario, String nivel_acceso, String clave){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                   "usuario(rut, nombre, apellido, estado_usuario, nivel_acceso, clave) " +
                   " values(?,?,?,?,?,?)")) {
               pstm.setString(1, rut);
               pstm.setString(2, nombre);
               pstm.setString(3, apellido);
               pstm.setString(4, estado_usuario);
               pstm.setString(5, nivel_acceso);
               pstm.setString(6, clave);
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
   }

     public void updateUsuario(String rut, String nombre, String apellido, String estado_usuario, String nivel_acceso, String clave){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update usuario "+
            "set nombre = ? ," +
            "apellido = ? ," +
            "estado_usuario = ? ," +                    
            "nivel_acceso = ? ," +        
            "clave = ? " +         
            "where rut = ? ");
            pstm.setString(1, nombre);                   
            pstm.setString(2, apellido);
            pstm.setString(3, estado_usuario);
            pstm.setString(4, nivel_acceso);
            pstm.setString(5, clave);
            pstm.setString(6, String.valueOf(rut));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
           
      }
   }
   
   public void deleteUsuario(String rut){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from usuario where rut = ?");            
                pstm.setString(1, rut);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }


    
 /*obtenemos todos los datos de la tabla*/
 public Object [][] getDatos(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM usuario ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][6];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " rut, nombre, apellido, estado_usuario, nivel_acceso, clave " +
            " FROM usuario" +
            " ORDER BY rut ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estRut = res.getString("rut");
            String estNombre = res.getString("nombre");
            String estApellido = res.getString("apellido");
            String estEstado_usuario = res.getString("estado_usuario");
            String estNivel_acceso = res.getString("nivel_acceso");
            String estClave = res.getString("clave");
            data[i][0] = estRut;            
            data[i][1] = estNombre;            
            data[i][2] = estApellido;            
            data[i][3] = estEstado_usuario;            
            data[i][4] = estNivel_acceso;
            data[i][5] = estClave;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
  
}
