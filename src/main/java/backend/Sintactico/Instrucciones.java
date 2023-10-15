
package backend.Sintactico;

import Tokens.Token;

/**
 *
 * @author Jonwil
 */
public class Instrucciones {
    
    
    
    private String id;              //contiene la instruccion
    private Token token;
    private boolean constanteNumerica;
    private boolean constanteCaracteres;
    
    private String tipoInstruccion;
    
    private String simbolo;
    private String tipo;
    private String valor;
    private int linea;
    private int columna;
    

    public Instrucciones(Token token, String id, boolean numerica, boolean cadenaCaracteres) {
        this.token = token;
        this.id = id;
        this.constanteNumerica = numerica;
        this.constanteCaracteres = cadenaCaracteres;
            setExpresion();
    }
    
    public void setExpresion(){
        simbolo = id;
        
        if(constanteNumerica){
            tipo = "Entero"; 
            valor = token.getLexema();
        }
        
        if(constanteCaracteres){
            tipo = "cadena";
            valor = token.getLexema();
        }
        if(!constanteNumerica && !constanteCaracteres){
            tipo ="Boolean";
            valor = token.getLexema();
        }
        
        linea = token.getLinea();
        columna = token.getColumna();
        
        if(token.getLexema().equals("def")){
            if(constanteNumerica){
                valor = "Entero"; 
                tipo = "funct";
            }

            if(constanteCaracteres){
                valor = "cadena";
                tipo = "funct";
            }
            if(!constanteNumerica && !constanteCaracteres){
                valor ="Boolean";
                tipo = "funct";
            }

            linea = token.getLinea();
            columna = token.getColumna();

            
        }
        
    }
    
    
//        se necesita la linea inicial del Token
    public void calcularLinea(){}

    public void setToken(Token token) {
        this.token = token;
    }
     
    public String getSimbolo() {
        return simbolo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }
    
    
}
