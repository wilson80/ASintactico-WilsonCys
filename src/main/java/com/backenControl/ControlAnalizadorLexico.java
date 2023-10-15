

package com.backenControl;

import Tokens.crearAlfabetoEnum;
import Tokens.TokenEnum;
import Tokens.Token;
import Vista.VistaGeneral;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jonwil
 */
public class ControlAnalizadorLexico {
    
    VistaGeneral vistaAnalizador;
    
    private int linea = 1;
    private int columna = 0;
    private int iterador = 0;
    private int cadenaAperturai = 0;
    private String buffer = "";
    private String textoIngresado; //Entrada
    private String identificador = "identificador";
    char [] caracteresIngresados;
    private boolean dentroDeComentario = false;
    private boolean dentroDeCadena = false;
    private boolean dentroDeEnteros = false;
    private boolean tokenNumericoAgregado = false;
    private boolean errorHallado = false;
    
    private boolean idReconocido = false;
    private List<Token> listTokens;
    private Map<String, TokenEnum> alfabeto;
    crearAlfabetoEnum alfabetoCreado;
            
    private String [] alfabetoIdSinNumero = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
                                                  "q","r","s","t","u","v","w","x","y","z", "_"}; 
    private String [] alfabetoIdSinNumeroMasyusculas = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
                                                    "N","O","P","Q","R","S","T","U","V","W","X","Y","Z", "_"}; 

    public ControlAnalizadorLexico(VistaGeneral vistaAnalizador) {
        this.vistaAnalizador = vistaAnalizador;
        listTokens = new ArrayList<>();
        alfabeto = new HashMap();
        alfabetoCreado = new crearAlfabetoEnum();
        alfabeto = alfabetoCreado.getAlfabeto();
    }

    
    public void analizar() {
        textoIngresado = vistaAnalizador.getCajonTexto().getText();             //extrayendo el texto del cajon de texto
            System.out.println("texto INGRESADO: " + textoIngresado );
        caracteresIngresados = textoIngresado.toCharArray();
        for (int i = 0; iterador < caracteresIngresados.length; iterador++) {
                    char valor = caracteresIngresados[iterador];
            
             if(tokenNumericoAgregado || errorHallado){
                 dentroDeEnteros = false;
                 tokenNumericoAgregado = false;
             }   
             
            if(!dentroDeCadena){
                verificarComentario(valor);
            }
            if(!dentroDeComentario){
                    buscarCadena(valor);
            }
            
            if(dentroDeComentario==false && dentroDeCadena==false){      //Si esta reconociendo un comentario no entra en el switch                
                switchGeneral(valor);                                    //dentro del switch reconoce palabras reservadas, signos de operacion y otros.           
            }
            
            if(!dentroDeCadena){
                reconocerComentario(valor);         //Clasifica los comentarios y hace false el atributo dentroDeComentario 
            }
            if(!dentroDeComentario){
                reconocerCadena(valor);             //identifica el cierre de la cadena de caracteres y agrega la cadena
            }
             
            if(iterador==(caracteresIngresados.length-1)) {        //Para reconocer el ultimo Token 
                        comparar(buffer, linea, columna);
                        buffer = "";
            }
//            System.out.println("Bufer: " +buffer);
        }
            System.out.println("Tokens Encontrados");
//            imprimirTokens();
            
        

    }

    
    public void reconocerEnteros(char valor) {
//             1 10 15   
        try {
            if(Character.isDigit(valor)) {
                    columna++;
                    dentroDeEnteros = true;
                    buffer += valor;
                    if(ultimoCaracter()) {
                        agregarTokenNumerico();
                    }
                    
                   if(!verificarSiguienteEntero()) { //si el siguiente caracter ya no es un entero
                       
                            if(Character.isLetter(caracteresIngresados[iterador+1])){
                                System.out.println("error detectado>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); 
                                errorHallado = true;
                                dentroDeEnteros = false;
                            }else{
                                agregarTokenNumerico();
                            }
                   }
            }
        } catch (Exception e) {
            
        }
    }
    
    public void agregarTokenNumerico(){
        char [] tamaño = buffer.toCharArray();      //pendiente
        int tamañoToken = tamaño.length-1;
        columna = columna-tamañoToken;
        Token token = new Token(buffer, TokenEnum.CONSTANTES_NUMERICAS, linea, columna);
                            listTokens.add(token);
                            columna +=tamañoToken;
//                            columna++;
                            buffer = "";
                            tokenNumericoAgregado = true;
        
    }
    
    public boolean ultimoCaracter(){
        if(iterador == (caracteresIngresados.length-1)){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean reconocerEspacioBlanco(){
        try {
            if(caracteresIngresados[iterador+1] ==' '){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
        }
        return false;
    }
    
    private boolean verificarSiguienteEntero(){
        try {
                if(Character.isDigit(caracteresIngresados[iterador+1])){
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e) {
            }
        return false;
        
    }
    
    
    
    public void buscarCadena(char valor){
        if(!dentroDeCadena){
                if(valor=='"'){
                    columna++;      //pendiente
                dentroDeCadena = true;
                cadenaAperturai=iterador;
                buffer+= "\"";
            }
        }
    }
    
    public void reconocerCadena(char valor){
        
        if(cadenaAperturai!=iterador){
            if(dentroDeCadena == true){ 
                buffer+=valor;
                columna++;  //pendiente
                if(valor=='"'  || iterador==caracteresIngresados.length-1){
                    if(valor == '"'){           // verificando las " comillas de cierre de la cadena
                        char [] tamañoT = buffer.toCharArray();
                        int tamañoToken = tamañoT.length-1;     //pendiente
                        columna = columna-tamañoToken;
                    Token token = new Token(buffer, TokenEnum.CADENA_DE_CARACTERES, linea, columna);
                    listTokens.add(token);
                    columna +=tamañoToken;      //pendiente
                    buffer="";
//                    columna++;
                    dentroDeCadena = false;
                    }else {
                        if(iterador==caracteresIngresados.length-1){ //si llega al ultimo caracter ingresado 
                                                                    //  y no recnonoce unas " comillas de cierre entonces califica como error
                            Token token = new Token(buffer, TokenEnum.ERROR, linea, columna);
                            listTokens.add(token);
                            System.out.println("Error de ciere de CADENA>>>>>>>");
                            dentroDeCadena = false;
                            columna++;
                            buffer="";
                        }
                    }
                }
            }
        }
    }
    
    
        private void switchGeneral(char valor) {
        switch (valor) {
                case ' ':
                    comparar(buffer, linea, columna);
                    columna++;
                    this.buffer = "";
                    break;
                case  '\n':
//nada
                    break;
                case  '\t':
                    comparar(buffer, linea, columna);
                    columna+=5;
                    this.buffer = "";
                    break;
                case  '\r':
//                    System.out.println("Salto de linea");
                    comparar(buffer, linea, columna);
                    linea++;
                    this.buffer = "";
                    columna = 0;
                    break;
                case  '+':
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] == '=' ){
                            columna+=2;
                            comparar("+=", linea, columna);
                            iterador++; 
                        }else{
                            columna++;
                            comparar("+", linea, columna);
                        }
                    } catch (Exception e) {
                        columna++;
                        comparar("+", linea, columna);
                        System.out.println("Fin de cadena de caracteres: no entra al if del try");
                    }
                      
                    break;
                case  '-':
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] == '=' ){
                            columna+=2;
                            comparar("-=", linea, columna);
                            iterador++; 
                        }else{
                            columna++;
                            comparar("-", linea, columna);
                        }
                    } catch (Exception e) {
                        columna++;
                        comparar("-", linea, columna);
                        System.out.println("Fin de cadena de caracteres");
                    }
                      
                    break;
                case '*':
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] == '*' ){
                            if(caracteresIngresados[iterador+2] == '=' ){
                                columna+=3;
                                comparar("**=", linea, columna);
                                iterador+=2;
                            }else{
                                columna+=2;
                                comparar("**", linea, columna);
                                iterador++;
                            }
                            
                        }else if(caracteresIngresados[iterador+1] == '=' ){
                            columna+=2;
                            comparar("*=", linea, columna);
                            iterador++;
                        }else{
                            columna++;
                            comparar("*", linea, columna);
                            
                        }
                    } catch (Exception e) {
                        columna++;
                        comparar("*", linea, columna);
                        System.out.println("Fin de cadena de caracteres");
                    }
                    
                    break;
                case '/':
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] == '=' ){
                            columna+=2;
                            comparar("/=", linea, columna);
                            iterador++; 
                        }else{
                            columna++;
                            comparar("/", linea, columna);
                        }
                    } catch (Exception e) {
                        columna++;
                        comparar("/", linea, columna);
                        System.out.println("Fin de cadena de caracteres");
                    }
                    
                    break;
                case '(':
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar("(", linea, columna);
                    this.buffer = "";
                    break;
                case ')':
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar(")", linea, columna);
                    this.buffer = "";
                    break;
                case '[':
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar("[", linea, columna);
                    this.buffer = "";
                    break;
                case ']':
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar("]", linea, columna);
                    this.buffer = "";
                    break;
                case '{':
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar("{", linea, columna);
                    this.buffer = "";
                    break;
                case '}':
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar("}", linea, columna);
                    this.buffer = "";
                    break;
                case '.' :
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar(".", linea, columna);
                    this.buffer = "";
                    break;
                case ',' :
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar(",", linea, columna);
                    this.buffer = "";
                    break;
                case ';' :
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar(";", linea, columna);
                    this.buffer = "";
                    break;
                case ':' :
                    comparar(buffer, linea, columna);
                    columna++;
                    comparar(":", linea, columna);
                    this.buffer = "";
                    break;
                case '%' :
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] == '=' ){
                            columna+=2;
                            comparar("%=", linea, columna);
                            iterador++; 
                        }else{
                            columna++;
                            comparar("%", linea, columna);
                        }
                    } catch (Exception e) {
                        columna++;
                        comparar("%", linea, columna);
                        System.out.println("Fin de cadena de caracteres");
                    }
                    
                    break;
                case '<' :
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] =='='){
                            columna+=2;
                            comparar("<=", linea, columna);
                            iterador++;
                        }else{
                            columna++;
                            comparar("<", linea, columna);
//                            this.buffer = "";
                            
                        }
                        
                    } catch (Exception e) {
                            columna++;
                            comparar("<", linea, columna);
//                            this.buffer = "";
                        System.out.println("Fin de cadena de CaracteresIngresados No hay Siguiente");
                    }
                    break;
                case '>' :
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] =='='){
                            columna+=2;
                            comparar(">=", linea, columna);
                            iterador++;
                        }else{
                            columna++;
                            comparar(">", linea, columna);
//                            this.buffer = "";
                            
                        }
                        
                    } catch (Exception e) {
                            columna++;
                            comparar(">", linea, columna);
//                            this.buffer = "";
                        System.out.println("Fin de cadena de CaracteresIngresados No hay Siguiente");
                    }
                    break;
                case '=' :
                    comparar(buffer, linea, columna);
                    this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] == '='){
                            columna+=2;
                            comparar("==", linea, columna);
                            iterador++;
                        }else{
                            columna++;
                            comparar("=", linea, columna);
//                            this.buffer = "";
                        }
                        
                    } catch (Exception e) {
                            columna++;
                            comparar("=", linea, columna);
//                            this.buffer = "";
                        System.out.println("Fin de cadena de Caracteres No hay Siguiente");
                    }
                    break;
                case '!' :
                    comparar(buffer, linea, columna);
                            this.buffer = "";
                    try {
                        if(caracteresIngresados[iterador+1] =='='){
                            columna+=2;
                            comparar("!=", linea, columna);
                            iterador++;
                        }else{
                            columna++;
                            comparar("!", linea, columna);
                            
                        }
                        
                    } catch (Exception e) {
                            columna++;
                        Token token = new Token("!", TokenEnum.ERROR, linea, columna);
                        listTokens.add(token);
                        System.out.println("Fin de cadena de Caracteres No hay Siguiente");
                    }
                    break;
                    

                default:    //default
                if(!errorHallado){  
                    try {
                        if(!Character.isLetter(caracteresIngresados[iterador-1])){
                            reconocerEnteros(valor);      //se realiza si no hay errores
                        }    
                        
                    } catch (Exception e) {
                    }
                        
                }
                    if(!dentroDeEnteros){
                      buffer +=valor;
                      columna++;
                    }
        }
    }
    
    public void reconocerIdentificador() {
        char [] caracteres = buffer.toCharArray();
        
        String primerCaracter = "";
        primerCaracter += caracteres[0];
        int tamanoID = caracteres.length-1;
        
        
        for (int i = 0; i < alfabetoIdSinNumero.length; i++) {      //comprobando que el primer caracter del buffer no sea un Numero o un signo no permitido para Id
            if(primerCaracter.equals(alfabetoIdSinNumero[i]) || primerCaracter.equals(alfabetoIdSinNumeroMasyusculas[i])){
                idReconocido = true;
            }                                           //Si no encaja en alguna categoria es un Error
        }
        
        if(idReconocido){                 //Creando un Nuevo Token ID
                columna = columna-tamanoID;
                Token token = new Token(buffer, TokenEnum.ID, linea, columna);
                listTokens.add(token);
                columna = columna+tamanoID;         //pendiente
//                System.out.println("IDENTIFICADOR CREADO");
                idReconocido=false;
        } else if(idReconocido==false){   //Al no reconocer un Id ni encajar en otra categoria Califica como error       
                Token token = new Token(buffer, TokenEnum.ERROR, linea, columna);
                listTokens.add(token);
                errorHallado = false;
        }
    }
    
    public void verificarComentario(char valor){    //Cuando encuentre el primer Caracter igual a # empieza a reconocer un comentario
            if(valor=='#'){            
//                System.out.println("INICIO COMENTARIO");
                dentroDeComentario = true;
            }
    }
    
    public void reconocerComentario(char valor){
            if(dentroDeComentario==true){
                if(valor!='\n' && valor!='\r'){
                    columna++;
                }
                
                buffer+=valor;
                if(valor=='\n' || iterador==caracteresIngresados.length-1){
                    System.out.println("iterador: " +iterador);
                    char[] tamañoT = buffer.toCharArray();
                    int tamañoToken =tamañoT.length-3; 
                    columna = columna-tamañoToken;      //pendiente
                    if(columna ==0){
                        columna=1;
                    }
                    Token token = new Token(buffer, TokenEnum.COMENTARIO, linea, columna);
                    listTokens.add(token);
                    columna = 0;
//                    crearNuevoToken("#", linea, columna);               //pendiente de crear aqui el token y tener la descrpcion del comentario
                    if(valor=='\n'){
                        linea++;
                    }
//                    System.out.println("CERRANDO COMENTARIO");
                    dentroDeComentario = false;
                    buffer="";
                }
            }
    }
    
    
    public void comparar(String buffer, int lineas, int columnas) {
        if(alfabeto.containsKey(buffer)) {
            crearNuevoToken(buffer, lineas, columnas);
            
        }else if(buffer!="" && dentroDeComentario==false){
            reconocerIdentificador();
        }
    }
    
    public void crearNuevoToken(String buffer, int lineas, int columnas){
        char [] tamaño = buffer.toCharArray();
        int tamañoToken = tamaño.length-1;  //pendiente
        columna = columna-tamañoToken;
        TokenEnum enumToken = alfabeto.get(buffer);
        Token tokenEncontrado = new Token(buffer, enumToken, linea, columna);
        listTokens.add(tokenEncontrado);    //Agregando el token a una lista 
        columna += tamañoToken;
    }
      
    private void imprimirTokens(){
        for (int i = 0; i < listTokens.size(); i++) {
            System.out.println("\t\t\t\t\t: " + i);
            System.out.println(listTokens.get(i).toString());
        }
    }

    public List<Token> getListTokens() {
        return listTokens;
//        listTokens.
    }
    
    
    
}
