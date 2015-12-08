package controlador;

import java.sql.*;
/**
 
 */
public class conectate {
   static String bd = "tallermecanico";//nombre de la base de datos que esta en mysql
   static String login = "root";// usuario
   static String password = "roottaller";// contraseña
   static String url = "jdbc:derby://localhost:1527/"+bd;
   private Statement conSql = null;
   private ResultSet resultado = null;

   Connection conn = null;

   /** Constructor de DbConnection */
   public  void conectate() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+". listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public boolean ejecutarSql(String sql) {
        try {
            conSql.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en la consulta SQL: " +ex.getMessage());
            return false;
        }
    }
   
   public ResultSet getSql(String Sql) {
        try {
            resultado = conSql.executeQuery(Sql);
        } catch (SQLException ex) {
            System.out.println("Error en la consulta SQL: " +ex.getMessage());
        }
        return resultado;
    }
   
   public void desconectar(){
      conn = null;
      System.out.println("La conexion a la  base de datos "+bd+" a terminado");
   }
}
