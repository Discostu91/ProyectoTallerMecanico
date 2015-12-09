package controlador;
import java.sql.*;

/**

 */
public class FAuto {
  conectate con;
  
  public FAuto (){
    con = new conectate();
  } 
  
  /*Añade un nuevo registro*/
   public void NuevaFichaAuto(String patente){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement
                   ("insert into " + 
                    "ficha_auto(patente) " +
                    " values(?)");            
            pstm.setString(1, patente);
                                   
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }


   
   
   
     public void updateFichaAuto(String folio, String patente){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement 
            ("update ficha_auto " +
            "set patente = ? " +                                        
            "where folio = ? ");            
            pstm.setString(1, patente);                   
            pstm.setString(2, String.valueOf(folio));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void deleteFichaAuto(String folio){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from Ficha_auto "
                        + "where folio = ?");            
                pstm.setString(1, folio);                   
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM ficha_auto ");
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
            " folio, patente " +
            " FROM ficha_auto" +
            " ORDER BY folio ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estfolio = res.getString("folio");
            String estpatente = res.getString("patente");
                      
            data[i][0] = estfolio;            
            data[i][1] = estpatente;            
                       
                       
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
