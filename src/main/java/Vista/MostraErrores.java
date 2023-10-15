
package Vista;

import Tokens.TokenEnum;
import Tokens.Token;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Jonwil
 */
public class MostraErrores {
    private List<Token> listTokens;
    private String errores = "";
    private VistaGeneral vistaGeneral;
    private JTextPane areaImpresion;

    public MostraErrores(List<Token> listTokens, VistaGeneral vista) {
        this.vistaGeneral = vista;
        this.listTokens = listTokens;
        this.areaImpresion = vista.getcajonMostrarErroers();
        
    }
    
    
    public void clasificarerrores(){
        for (Token listToken : listTokens) {
            if(listToken.getEnum()==TokenEnum.ERROR){
                errores += listToken.getLexema() + ",  ";
                errores += listToken.getEnum()+ ",  ";
                errores += listToken.getLinea()+ ",  ";
                errores += listToken.getColumna()+ ",  ";
                errores += "\n";
            }
        }
        vistaGeneral.setCajonMostrarErroes(errores);
    }

    
    public String getErrores() {
        return errores;
    }
    
    
}
