
package backend.Sintactico;

import java.util.List;

/**
 *
 * @author Jonwil
 */
public class BloqueCodigo {
    String instruccionInicial;
    List<Instrucciones> instruccionesDentroBloque;     //print, if, else while, 

    
    public void agregarInstrucciones_a_Bloque(Instrucciones instruccion) {
        instruccionesDentroBloque.add(instruccion);
    }
    
    
    public List<Instrucciones> getInstruccionesDentroBloque() {
        return instruccionesDentroBloque;
    }
    
    
    
    
    
    
    
    
    
}
