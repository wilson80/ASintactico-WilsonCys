
package com.controlVista;


/**
 *
 * @author Jonwil
 */


public class EjecutarCreacionImagenes {
//    private  String nombreArchivo ="dotLexemaPrueba";
    private  String nombreArchivo;
    private  String extension = ".dot";
    private  String extensionImagen = ".png";
    
    
    public EjecutarCreacionImagenes(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    
    public  void ejecutarComandos(){
        try {
      
            String DOTPATH = "c:\\Program Files\\Graphviz\\bin\\dot.exe";
            
//            String getRutaInput = getClass().getResource("/images/"+nombreArchivo+extension).toString();
//            String getRutaOutput = getClass().getResource("/images/"+nombreArchivo+extensionImagen).toString();
//            String getRutaInput = getClass().getResource("\\images\\"+nombreArchivo+extension).toString();
//            String getRutaOutput = getClass().getResource("\\images\\"+nombreArchivo+extensionImagen).toString();
      
//      C:\Users\Jonwil\Desktop
//      String fileInputPath = getRutaInput;
//      String fileOutputPath = getRutaOutput;


//            String fileInputPath = "c:\\Users\\Jonwil\\Desktop\\"+nombreArchivo +extension;
//            String fileOutputPath = "c:\\Users\\Jonwil\\Desktop\\dots\\"+nombreArchivo+extensionImagen;
            String fileInputPath = "C:\\Users\\Jonwil\\Documents\\NetBeansProjects\\AnalizadorL_Lenguajes\\Lenguajes_Formales_De_Programacion\\src\\main\\resources\\images\\"+nombreArchivo +extension;
            String fileOutputPath = "C:\\Users\\Jonwil\\Documents\\NetBeansProjects\\AnalizadorL_Lenguajes\\Lenguajes_Formales_De_Programacion\\src\\main\\resources\\images\\"+nombreArchivo+extensionImagen;
//            System.out.println("EJECUTANDO"); 
            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] ejecutar = new String[5];
            ejecutar[0] = DOTPATH;
            ejecutar[1] = tParam;
            ejecutar[2] = fileInputPath;
            ejecutar[3] = tOParam;
            ejecutar[4] = fileOutputPath;

            Runtime runtime = Runtime.getRuntime();
            runtime.exec( ejecutar );

          } catch (Exception ex) {
            ex.printStackTrace();
          } finally {
          }

          }
    

}