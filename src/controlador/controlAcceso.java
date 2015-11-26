/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import controlador.conectate;
/**
 *
 * @author Alvaro
 */
public class controlAcceso {
    //datos
    private String rut;
    private String nombre;
    private String apellido;
    private boolean estado_usuario;
    private int nivel_acceso;
    private String clave;
            
    
    public controlAcceso(){
        
    }
    public controlAcceso checkUser(String user,String pass){
        boolean acc=false;
        cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
       
            conectate c=new conectate();
            cn=c.getConnection();
            String sql="SELECT * FROM usuario WHERE rut=? AND clave=?";
            pr=cn.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            rs=pr.executeQuery();
                while(rs.next()){
                    
                    setRut(rs.getString("rut"));
                    setNombre(rs.getString("nombre"));
                    setApellido(rs.getString("apellido"));
                    setEstado_usuario(rs.getString("estado_usuario"));
                    setNivel_acceso(rs.getString("nivel_acceso"));
                    setClave(rs.getString("clave"));
                    
                    rs.close();
                    pr.close();
                    rs.close();
    
    
                    break;
            }
                
                return null;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean isEstado_usuario() {
        return estado_usuario;
    }

    public int getNivel_acceso() {
        return nivel_acceso;
    }

    public String getClave() {
        return clave;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEstado_usuario(boolean estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public void setNivel_acceso(int nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    
}
