
package Tokens;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonwil
 */

public class Token {
    
    private int linea;
    private int columna;
    private String lexema;
    private String patron;
    private TokenEnum token;
    private Map<TokenEnum, String> alfabetoPatron = new HashMap<>(); ; 
//    this.alfabetoPatron = new HashMap<>(); 
//     public Token() {
//     }

    
    public Token(String lexema, TokenEnum token, int linea, int columna){
        
        alfabetoPatron.put(TokenEnum.OTROS, ",");
        alfabetoPatron.put(TokenEnum.OTROS, ".");
        alfabetoPatron.put(TokenEnum.OTROS, ";");
        alfabetoPatron.put(TokenEnum.OTROS, ":");
        alfabetoPatron.put(TokenEnum.OTROS, "[");
        alfabetoPatron.put(TokenEnum.OTROS, "]");
        alfabetoPatron.put(TokenEnum.OTROS, "{");
        alfabetoPatron.put(TokenEnum.OTROS, "}");
        alfabetoPatron.put(TokenEnum.ARITMETICOS, "+");
        alfabetoPatron.put(TokenEnum.ARITMETICOS, "-");
        alfabetoPatron.put(TokenEnum.ARITMETICOS, "*");
        alfabetoPatron.put(TokenEnum.ARITMETICOS, "/");
        
        
//      this.patron = this.alfabetoPatron.get(token);
        this.lexema=lexema;
        this.token = token;
        this.linea = linea;  
        this.columna = columna;
//        System.out.println("lexema>>>>>>>>>>>>>>>>>" + this.lexema);
                
        if(token!= TokenEnum.ID){
            this.patron = lexema;
        }else if(token== TokenEnum.ID){
            this.patron = "([\\w]|_)+(\\w|\\d)*";
        }
        
            
    }
    
    
    @Override
    public String toString() {
        
        return "TOKEN<"+lexema+ ", "
                       +token + ","
                       +" Patron: " + patron + "," 
                       + " linea: "+linea + ","
                       + " columna: "+columna+">";
    }    

    public String getLexema() {
        return lexema;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public TokenEnum getEnum() {
        return token;
    }

    public String getPatron() {
        return patron;
    }
    
    
}
