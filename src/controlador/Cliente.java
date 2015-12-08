package controlador;
import java.sql.*;
/**

 */
public class Cliente {
  conectate con;
  
  public Cliente(){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/

     public void ActualizarCliente(String rut, String app, String nombre, String telefono){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update cliente " +
            "set app = ? ," +
            "nombre = ? ," +
            "telefono = ? " +
            "where rut = ? ");
            pstm.setString(1, app);
            pstm.setString(2, nombre);
            pstm.setString(3, telefono);
            pstm.setString(4, rut);
            pstm.execute();
            pstm.close();   
            }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void EliminarCliente(String rut){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from cliente where rut = ?");            
                pstm.setString(1, rut);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
   
   public void GuardarCliente(String rut, String app, String nombre, String telefono){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                    "cliente(rut, app, nombre, telefono) " +
                    " values(?,?,?,?)");            
            pstm.setString(1, rut);
            pstm.setString(2, app);
            pstm.setString(3, nombre);                        
            pstm.setString(4, telefono);
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM cliente ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][4];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " rut, app, nombre, telefono" +
            " FROM cliente" +
            " ORDER BY rut ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estrut = res.getString("rut");
            String estapp = res.getString("app");
            String estnombre = res.getString("nombre");
            String esttelefono = res.getString("telefono");
            data[i][0] = estrut;    
            data[i][1] = estapp; 
            data[i][2] = estnombre;            
            data[i][3] = esttelefono;                        
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }  
}

