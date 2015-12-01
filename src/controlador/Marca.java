package controlador;
import java.sql.*;
/**

 */
public class Marca {
  conectate con;
  
  public Marca(){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/

   
   public void GuardarMarca(String descripcion){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                    "marca(Descripcion) " +
                    " values(?)");            
            pstm.setString(1, descripcion);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void EliminarMarca(String id){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from cliente where Id = ?");            
                pstm.setString(1, id);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
   
public void ActualizarMarca(String id, String descripcion){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update marca " +
            "set Descripcion = ? " +
            "where Id = ? ");
            pstm.setString(1, id);                   
            pstm.setString(2, descripcion);
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM marca ");
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
            " Descripcion" +
            " FROM marca" +
            " ORDER BY Descripcion ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estdescripcion = res.getString("Descripcion");
            data[i][0] = estdescripcion;                           
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
