
package com.controlVista;

import Tokens.Token;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonwil
 */
public class CrearArchivoDot {
    private List<Token> listTokens;
    
    private String textoDot;
    private String nombreDot;
    
    private String color;
    private String conectorLetra = "";
    private String letraAceptacion ="";
    
//    private String path = "C:\\Users\\Jonwil\\Desktop\\";
    private String path = "src";
    private String extension = ".dot";
    private int iterador = 0;
    
//    String getRuta = getClass().getResource("src/nombrearchivo.png");     
//    String getRuta = getClass().getResource("/images/nombrearchivo.png");
            
    private FileWriter nuevoFile;

    public CrearArchivoDot(List<Token> listTokens) {
        this.listTokens = listTokens;
    } 
 
    public void crearDots() throws IOException {
        for (Token tokenActual : listTokens) {
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> " + tokenActual.getLexema());
//            if(!tokenActual.getToken().name().equals("CADENA_DE_CARACTERES") &&tokenActual.getToken().name().equals("") ){
//            }
            //set colores letra aceptacion
            nombreDot = tokenActual.getLexema();
            unirCaracterConector(tokenActual);
            establecerColores(tokenActual);
            correccionCadenasComentarios();
            
            textoDot = String.format(("digraph {   \n" +
                                        "    node [shape = doublecircle, color = %s] %s ;\n" +
                                        "    node [shape = circle];\n" +
                                        "    node [color= %s];\n" +
                                        "    %s	\n" +
                                        "}"),color , letraAceptacion, color, conectorLetra);
            compilarDot();
            
            textoDot = "";
            letraAceptacion = "";
            color = "";
            conectorLetra = "";
        }
        JOptionPane.showMessageDialog(null, "Se han graficado los lexemas.");
        
    }
    
    
    
    
    public void establecerColores(Token token){
        switch (token.getEnum().name()) {
            case "ID":
                color = "black";
                break;
            case "ARITMETICOS":
                color = "darkslategray3";
                break;

            case "COMPARACION":
                color = "darkslategray3";
                break;
            case "LOGICOS":
                color = "darkslategray3";
                break;
            case "ASIGNACION":
                color = "darkslategray3";
                break;
            case "RESERVADA":
                color = "darkviolet";
                break;
            case "CADENA_DE_CARACTERES":
                color = "firebrick1";
                break;
            case "CONSTANTES_NUMERICAS":
                color = "firebrick1";
                break;
            case "CONSTANTES_BOOLEANAS":
                color = "firebrick1";
                break;
            case "OTROS":
                color = "gray";
                break;
            case "COMENTARIO":
                color = "chartreuse";
                break;
            case "ERROR":
//                entra en el ciclo crea la imagen pero no la necesito
                break;
//            default:
//                throw new AssertionError();
        }
    }
    
    
    public void unirCaracterConector(Token token){
        String conector = " -> ";
        String lexema = token.getLexema();
        
        char [] caracter = lexema.toCharArray();
        
        
        try {
            
            for (int i = 0; i < caracter.length; i++) {
                if(i==caracter.length-1){
                    letraAceptacion += caracter[i];

                }
            }
            
            for (int i = 0; i < caracter.length; i++) {
                conectorLetra +=caracter[i];
                if(i==caracter.length-1){
                    conectorLetra += ";";
                }else{
                    conectorLetra += conector;
                }
            }
            
        } catch (Exception e) {
        }
    }
    
      public void compilarDot() throws IOException {
         
          try {
            iterador++;
//            System.out.println("Entrando a compilar Dot");
  //              String getRuta = getClass().getResource("/images/").toString();
              nuevoFile = new FileWriter("C:\\Users\\Jonwil\\Documents\\NetBeansProjects\\AnalizadorL_Lenguajes\\Lenguajes_Formales_De_Programacion\\src\\main\\resources\\images\\"+nombreDot+extension);
  //            nuevoFile = new FileWriter("/images/" +nombreDot+extension);

              nuevoFile.write(textoDot);
              nuevoFile.close();
              
          } catch (Exception e) {
          }
          
            
            
    }
      public void correccionCadenasComentarios(){
          char [] c = nombreDot.toCharArray();
          char i = c[0];
            if(i =='"' || i=='\'' || i == '#'){
                switch (i) {
                    case '"':
                        nombreDot = "cadena" + iterador;
                        break;
                    case '\'':
                        nombreDot = "cadena" + iterador;
                        break;
                    case '#':
                        nombreDot = "comentario" + iterador;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
      }

//         digraph {   
//        node [shape = doublecircle, color = firebrick1] " ;
//        node [shape = circle];
//        node [color= firebrick1];
//        " -> s -> d -> s -> d -> f -> g -> s -> f -> ";	
//}
    
    
    
}
