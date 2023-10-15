
package com.backenControl;

import Vista.VistaGeneral;

/**
 *
 * @author Jonwil
 */
public class Main {
    public static void main(String[] args) {
        Vista.VistaGeneral vistaGeneral = new VistaGeneral();
        vistaGeneral.setVisible(true);
        ControlAnalizadorLexico controlAnalizadorLexico = new ControlAnalizadorLexico(vistaGeneral);
        
        
        
        
        
//        ControlAnalizadorLexico primeraPrueba = new ControlAnalizadorLexico();
//        primeraPrueba.analizador();
        
        
    }
   
}
