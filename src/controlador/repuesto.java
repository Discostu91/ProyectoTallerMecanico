package controlador;
import java.sql.*;

/**

 */
public class repuesto {
  conectate con;
  
  public repuesto (){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/
   public void NuevaRepuesto(String descripcion){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement
                   ("insert into " + 
                    "repuesto(descripcion) " +
                    " values(?)");            
            pstm.setString(1, descripcion);
                                   
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }


   
   
   
     public void updateRepuesto(String id_repuesto, String descripcion){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement 
            ("update repuesto " +
            "set descripcion = ? " +                                        
            "where id_repuesto = ? ");            
            pstm.setString(1, descripcion);                   
            pstm.setString(2, String.valueOf(id_repuesto));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void deleteRepuesto(String cod){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from repuesto "
                        + "where id_repuesto = ?");            
                pstm.setString(1, cod);                   
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM repuesto ");
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
            " id_repuesto, descripcion " +
            " FROM repuesto" +
            " ORDER BY id_repuesto ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estCodigo = res.getString("id_repuesto");
            String estApp = res.getString("descripcion");
                      
            data[i][0] = estCodigo;            
            data[i][1] = estApp;            
                       
                       
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
