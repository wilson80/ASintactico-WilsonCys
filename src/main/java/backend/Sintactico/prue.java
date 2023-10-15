
package backend.Sintactico;

/**
 *
 * @author Jonwil
 */
public class prue {

    static String uno="1,2,3,4,";
    
    
    public static void imprimir(){
        int limite = 0;
        boolean comer = true;
        int contador = 0;
        int nada = 0;

        while(comer){
            if(nada==5){
                comer=true;
            }
            System.out.println("uno");
            if(limite==10){
                break;
            }
            
            limite++;
        }
        
    }
            
            
    public static void main(String[] args) {
        imprimir();
    }
    
}
