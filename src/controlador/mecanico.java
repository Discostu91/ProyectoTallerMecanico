package controlador;
import java.sql.*;

/**

 */
public class mecanico {
  conectate con;
  
  public mecanico (){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/
   public void NuevaMecanico(String app, String nombre){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                    "mecanico(app, nombre) " +
                    " values(?,?)");            
            pstm.setString(1, app);
            pstm.setString(2, nombre);                        
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }


   
   
   
     public void updateMecanico(String id_mecanico, String app, String nombre){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update mecanico " +
            "set app = ? ," +
            "nombre = ? ," +                               
            "where id_mecanico = ? ");            
            pstm.setString(1, app);                   
            pstm.setString(2, nombre);           
            pstm.setString(3, String.valueOf(id_mecanico));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void deleteMecanico(String cod){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from mecanico "
                        + "where id_mecanico = ?");            
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM mecanico ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][3];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " id_mecanico, app, nombre " +
            " FROM mecanico" +
            " ORDER BY id_mecanico ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estCodigo = res.getString("id_mecanico");
            String estApp = res.getString("app");
            String estNombre = res.getString("nombre");           
            data[i][0] = estCodigo;            
            data[i][1] = estApp;            
            data[i][2] = estNombre;            
                       
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
