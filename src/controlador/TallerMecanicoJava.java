/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.FRMacceso;
/**
 *
 * @author Alvaro
 */
public class TallerMecanicoJava {


public TallerMecanicoJava(){
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //arranque del sistema, se inicia con el login
      new FRMacceso().setVisible(true);

    }
    
}
