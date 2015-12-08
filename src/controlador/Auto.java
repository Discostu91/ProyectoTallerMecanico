package controlador;
import java.sql.*;

/**

 */
public class Auto {
  conectate con;
  
  public Auto (){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/
   public void NuevoAuto(String patente,String rut, String id_modelo  ){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement
                    ("insert into " + 
                    "auto(patente,rut,id_modelo) " +
                    " values(?,?,?)");            
            pstm.setString(1, patente);
            pstm.setString(2, rut); 
             pstm.setString(3, id_modelo);
            
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }


   
   
   
     public void updateAuto(String patente, String rut, String id_modelo){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement
            ("update auto " +
            "set rut = ? ," +
            "id_modelo = ? " +                               
            "where patente = ? ");            
            pstm.setString(1, rut);                   
            pstm.setString(2, id_modelo);           
            pstm.setString(3, String.valueOf(patente));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void deleteAuto(String patente){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement
                        ("delete from auto "
                        + "where patente = ?");            
                pstm.setString(1, patente);                   
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM auto ");
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
            " patente, rut, id_modelo " +
            " FROM auto" +
            " ORDER BY patente ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estpatente = res.getString("patente");
            String estrut = res.getString("rut");
            String estidmodelo = res.getString("id_modelo");           
            data[i][0] = estpatente;            
            data[i][1] = estrut;            
            data[i][2] = estidmodelo;            
                       
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
