package controlador;
import java.sql.*;
import javax.swing.JOptionPane;

public class IngresarMecanico {
  conectate con;
  CallableStatement st;
  
  public IngresarMecanico(){
    con = new conectate();
  } 
  
   public void Nuevocliente(String rut, String nombre, String direccion, String comuna, String tipificacion,  String lactual, String lanterior){
                           
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                    "cliente(Rut, Nombre, Direccion, Comuna, Tipificacion, lactual, lanterior) " +
                    " values(?,?,?,?,?,?,?)");            
            pstm.setString(1, rut);
            pstm.setString(2, nombre);
            pstm.setString(3, direccion);                        
            pstm.setString(4, comuna);
            pstm.setString(5, tipificacion);
            pstm.setString(6, lactual);
            pstm.setString(7, lanterior);
            pstm.execute();
            pstm.close();  
           int rta=st.executeUpdate();
        if(rta==1)
        {
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
        } 
         }catch(SQLException e){
         System.out.println(e);
      }
   }

     public void updatecliente(String id, String rut, String nombre, String direccion, String comuna, String tipificacion, String lactual, String lanterior){
                          
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update cliente " +
            "set Rut = ? ," +
            "Nombre = ? ," +
            "Direccion = ? ," +
            "Comuna = ? ," +                    
            "Tipificacion = ? ," +                    
            "lactual = ? ,"+
            "lanterior = ? "+
            "where id = ? ");
            pstm.setString(1, rut);                   
            pstm.setString(2, nombre);
            pstm.setString(3, direccion);
            pstm.setString(4, comuna);
            pstm.setString(5, tipificacion);
            pstm.setString(6, lactual);
            pstm.setString(7, lanterior);
            pstm.setString(8, String.valueOf(id));
            pstm.execute();
            pstm.close();   
            }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   public void deletecliente(String id){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from cliente where id = ?");            
                pstm.setString(1, id);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

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
      
    Object[][] data = new String[registros][8];  
   
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " id, Rut, Nombre, Direccion, Comuna, Tipificacion, lactual, lanterior " +
            " FROM cliente" +
            " ORDER BY id ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estid = res.getString("id");
            String estRut = res.getString("Rut");
            String estNombre = res.getString("Nombre");
            String estDireccion = res.getString("Direccion");
            String estComuna = res.getString("Comuna");
            String estTipificacion = res.getString("Tipificacion");
            String estlactual = res.getString("lactual");
            String estlanterior = res.getString("lanterior");
            data[i][0] = estid;    
            data[i][1] = estRut; 
            data[i][2] = estNombre;            
            data[i][3] = estDireccion;            
            data[i][4] = estComuna;            
            data[i][5] = estTipificacion;   
            data[i][6] = estlactual; 
            data[i][7] = estlanterior; 
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
