/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.IngresarMantencion;
import java.sql.*;
/**
 *
 * @author Alvaro
 */
public class mantencion {
    conectate con;
    
public mantencion (){
    
    con = new conectate();
    
  } 
  
  /*Añade un nuevo registro*/
   public void NuevaMantencion(String descripcion, String fecha_recepcion, String fecha_entrega, String folio){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                    "mantencion(descripcion, fecha_recepcion, fecha_entrega, folio) " +
                    " values(?,?,?,?)");            
            pstm.setString(1, descripcion);
            pstm.setString(2, fecha_recepcion);
            pstm.setString(3, fecha_entrega); 
            pstm.setString(4, folio); 
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }


   
   
   
     public void updateMantencion(String secuencia, String descripcion, String fecha_recepcion, String fecha_entrega, String folio){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update mantencion " +
            "set descripcion = ? ," +
            "fecha_recepcion = ? ," +
            "fecha_entrega = ? ," +  
            "folio = ? " +  
            "where secuencia = ? ");            
            pstm.setString(1, descripcion);                   
            pstm.setString(2, fecha_recepcion); 
            pstm.setString(3, fecha_entrega);
            pstm.setString(4, folio);
            pstm.setString(5, String.valueOf(secuencia));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void deleteMantencion(String secuencia){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from mantencion "
                        + "where secuencia = ?");            
                pstm.setString(1, secuencia);                   
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM mantencion ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][5];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " secuencia, descripcion, fecha_recepcion, fecha_entrega, folio" +
            " FROM mantencion");
         
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String secuencia = res.getString("secuencia");
            String descripcion = res.getString("descripcion");
            String fecha_recepcion = res.getString("fecha_recepcion");
            String fecha_entrega = res.getString("fecha_entrega");  
            String folio = res.getString("folio");  
            data[i][0] = secuencia;            
            data[i][1] = descripcion;            
            data[i][2] = fecha_recepcion; 
            data[i][3] = fecha_entrega;
            data[i][4] = folio;
                       
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
           //MECANICO
 public Object [][] getDatosMecanicos(String secuencia){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM mecanico_mantencion");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT" +
            " nombre, app" +
            " FROM mecanico m, mecanico_mantencion mm"+
            " where secuencia = ? and m.id_mecanico=mm.id_mecanico"     );
         pstm.setString(1, secuencia); 
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String nombre = res.getString("nombre");
            String app = res.getString("app");
            data[i][0] = nombre;            
            data[i][1] = app;            
                              
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
             //REPUESTOS
 public Object [][] getDatosRepuestos(String secuencia){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM repuesto ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][1];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " descripcion" +
            " FROM repuesto r, mantencion_repuesto mr"+
            " where r.id_repuesto=mr.id_repuesto and mr.secuencia = ?"     );
         pstm.setString(1, secuencia); 
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String descripcion = res.getString("descripcion");
            data[i][0] = descripcion;            
                              
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
