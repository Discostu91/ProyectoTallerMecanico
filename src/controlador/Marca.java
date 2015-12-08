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
                    "marca(descripcion) " +
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
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from marca where id_marca = ?");            
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
            "set descripcion = ? " +
            "where id_marca = ? ");
            pstm.setString(1, descripcion);                   
            pstm.setString(2, String.valueOf(id));
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
      
    Object[][] data = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "id_marca,"+
            " descripcion" +
            " FROM marca" +
            " ORDER BY id_marca ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estid = res.getString("id_marca");
            String estdescripcion = res.getString("descripcion");
            data[i][0] = estid;
            data[i][1] = estdescripcion;                           
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
