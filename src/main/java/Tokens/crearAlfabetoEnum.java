
package Tokens;

import Tokens.TokenEnum;
import java.util.HashMap;
import java.util.Map;

/**
 *  
 * @author Jonwil
 */
public class crearAlfabetoEnum {
    private Map<String, TokenEnum> alfabeto;

    
    public crearAlfabetoEnum() {
        alfabeto = new HashMap();
        alfabeto.put(".", TokenEnum.OTROS);
        alfabeto.put(",", TokenEnum.OTROS);
        alfabeto.put(";", TokenEnum.OTROS);
        alfabeto.put(":", TokenEnum.OTROS);
        alfabeto.put("(", TokenEnum.OTROS);
        alfabeto.put(")", TokenEnum.OTROS);
        alfabeto.put("{", TokenEnum.OTROS);
        alfabeto.put("}", TokenEnum.OTROS);
        alfabeto.put("[", TokenEnum.OTROS);
        alfabeto.put("]", TokenEnum.OTROS);
        
        alfabeto.put("+", TokenEnum.ARITMETICOS);
        alfabeto.put("-", TokenEnum.ARITMETICOS);
        alfabeto.put("*", TokenEnum.ARITMETICOS);
        alfabeto.put("/", TokenEnum.ARITMETICOS);
        alfabeto.put("%", TokenEnum.ARITMETICOS);
        alfabeto.put("**", TokenEnum.ARITMETICOS);
        
        alfabeto.put("def", TokenEnum.RESERVADA);
        alfabeto.put("if", TokenEnum.RESERVADA);
        alfabeto.put("as", TokenEnum.RESERVADA);
        alfabeto.put("assert", TokenEnum.RESERVADA);
        alfabeto.put("break", TokenEnum.RESERVADA);
        alfabeto.put("class", TokenEnum.RESERVADA);
        alfabeto.put("continue", TokenEnum.RESERVADA);
        alfabeto.put("del", TokenEnum.RESERVADA);
        alfabeto.put("elif", TokenEnum.RESERVADA);
        alfabeto.put("else", TokenEnum.RESERVADA);
        alfabeto.put("except", TokenEnum.RESERVADA);
        alfabeto.put("finally", TokenEnum.RESERVADA);
        alfabeto.put("for", TokenEnum.RESERVADA);
        alfabeto.put("from", TokenEnum.RESERVADA);
        alfabeto.put("impor", TokenEnum.RESERVADA);
        alfabeto.put("for", TokenEnum.RESERVADA);
        alfabeto.put("in", TokenEnum.RESERVADA);
        alfabeto.put("is", TokenEnum.RESERVADA);
        alfabeto.put("print", TokenEnum.RESERVADA);
        alfabeto.put("lambda", TokenEnum.RESERVADA);
        alfabeto.put("None", TokenEnum.RESERVADA);
        alfabeto.put("nonlocal", TokenEnum.RESERVADA);
        alfabeto.put("pass", TokenEnum.RESERVADA);
        alfabeto.put("raise", TokenEnum.RESERVADA);
        alfabeto.put("return", TokenEnum.RESERVADA);
//        alfabeto.put("True", TokenEnum.RESERVADA);
        alfabeto.put("try", TokenEnum.RESERVADA);
        alfabeto.put("while", TokenEnum.RESERVADA);
        alfabeto.put("with", TokenEnum.RESERVADA);
        alfabeto.put("yield", TokenEnum.RESERVADA);
        
        alfabeto.put("is", TokenEnum.PERMANENCIA);
        alfabeto.put("is not", TokenEnum.PERMANENCIA);
        alfabeto.put("in", TokenEnum.PERMANENCIA);
        alfabeto.put("in not", TokenEnum.PERMANENCIA);
        
        
        alfabeto.put("and", TokenEnum.LOGICOS);
        alfabeto.put("or", TokenEnum.LOGICOS);
        alfabeto.put("not", TokenEnum.LOGICOS);
        
        alfabeto.put("=", TokenEnum.ASIGNACION);
        alfabeto.put("+=", TokenEnum.ASIGNACION);
        alfabeto.put("-=", TokenEnum.ASIGNACION);
        alfabeto.put("*=", TokenEnum.ASIGNACION);
        alfabeto.put("/=", TokenEnum.ASIGNACION);
        alfabeto.put("**=", TokenEnum.ASIGNACION);
        alfabeto.put("%=", TokenEnum.ASIGNACION);
        
        alfabeto.put("True", TokenEnum.CONSTANTES_BOOLEANAS);
        alfabeto.put("False", TokenEnum.CONSTANTES_BOOLEANAS);
        
        alfabeto.put("#", TokenEnum.COMENTARIO);
        
        alfabeto.put("==", TokenEnum.COMPARACION);
        alfabeto.put("!=", TokenEnum.COMPARACION);
        alfabeto.put(">", TokenEnum.COMPARACION);
        alfabeto.put("<", TokenEnum.COMPARACION);
        alfabeto.put(">=", TokenEnum.COMPARACION);
        alfabeto.put("<=", TokenEnum.COMPARACION);
    }

    public Map<String, TokenEnum> getAlfabeto() {
        return alfabeto;
    }

    
}
