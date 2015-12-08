/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Alvaro
 */
public class controlAcceso {
    private String rut;
    private String nombre;
    private String apellido;
    private String estado_usuario;
    private String nivel_acceso;
    private String clave;
    conectate con=new conectate();
            
    
    public controlAcceso(){
        
    }
    public controlAcceso checkUser(String user, String pass){
        
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * " +
            " FROM usuario where rut=? and clave=?");
         pstm.setString(1, user);                   
         pstm.setString(2, pass);
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){
            rut = res.getString("rut");
            nombre = res.getString("nombre");
            apellido = res.getString("apellido");
            estado_usuario = res.getString("estado_usuario");
            nivel_acceso = res.getString("nivel_acceso");
            clave = res.getString("clave");
            
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return null;
    }


        //metodos get
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public String getNivel_acceso() {
        return nivel_acceso;
    }

    

    public String getClave() {
        return clave;
    }

        //metodos set
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public void setNivel_acceso(String nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }

    

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    
}
