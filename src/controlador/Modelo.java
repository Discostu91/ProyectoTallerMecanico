package controlador;
import java.sql.*;
/**

 */
public class Modelo {
  conectate con;
  
  public Modelo(){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/

     public void ActualizarModelo(String id, String descripcion, String cilindrada, String color, String marca){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update modelo " +
            "set descripcion = ? ," +
            "cilindrada = ? ," +
            "color = ? ," +
            "marca = ? " +        
            "where id_modelo = ? ");
            pstm.setString(1, descripcion);
            pstm.setString(2, cilindrada);
            pstm.setString(3, color);
            pstm.setString(4, marca);
            pstm.setString(5, String.valueOf(id));
            pstm.execute();
            pstm.close();   
            }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void EliminarModelo(String id){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from modelo where id_modelo = ?");            
                pstm.setString(1, id);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
   
   public void GuardarModelo(String descripcion, String cilindrada, String color, String marca){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                    "modelo(descripcion, cilindrada, color, marca) " +
                    " values(?,?,?,?)");            
            pstm.setString(1, descripcion);
            pstm.setString(2, cilindrada);
            pstm.setString(3, color);                        
            pstm.setString(4, marca);
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM modelo ");
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
            " descripcion, cilindrada, color, marca" +
            " FROM moldeo" +
            " ORDER BY id_modelo ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estid = res.getString("id_modelo");
            String estdescripcion = res.getString("descripcion");
            String estcilindrada = res.getString("cilindra");
            String estcolor = res.getString("color");
            String estmarca = res.getString("marca");
            data[i][0] = estid;
            data[i][1] = estdescripcion;    
            data[i][2] = estcilindrada; 
            data[i][3] = estcolor;            
            data[i][4] = estmarca;                        
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  
}

