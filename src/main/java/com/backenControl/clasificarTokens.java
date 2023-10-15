
package com.backenControl;

import Tokens.Token;
import com.controlVista.EjecutarCreacionImagenes;
import Vista.panelGraficos;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jonwil
 */

public class clasificarTokens implements ActionListener{
    
    private List<Token> listTokens;

    private panelGraficos panelGraficos;
    private JPanel panelContenedor;
    private String tokenEnum;
    private JPanel panelContenedorLexema;
    private JButton insertarImagen;
    private ImageIcon imagenLexema;
    private static final String IMAGES_ROOT_PATH = "/images/";
//    private static final String IMAGES_ROOT_PATH = "C:\\Users\\Jonwil\\Documents\\NetBeansProjects\\AnalizadorL_Lenguajes\\Lenguajes_Formales_De_Programacion\\src\\main\\resources\\images\\";
    private String nombreToken = "";
    private String extension = ".png";
    private EjecutarCreacionImagenes ejecutarCreacionImagenes;
    
    

    public clasificarTokens(panelGraficos panelGraficos, List<Token> listTokens, String tokenEnum) {
        this.listTokens = listTokens;
        this.panelGraficos = panelGraficos;
        this.panelContenedor = panelGraficos.getContenedorDeContenedorTokens();
        panelContenedorLexema = new JPanel();
        this.tokenEnum = tokenEnum; 
        this.insertarImagen = panelGraficos.getColocarImagen();
        
    }
    
    public void configuracionPanelContenedorLexema(){
        panelContenedorLexema.setLayout(new java.awt.GridLayout(10, 1));
        panelContenedorLexema.setSize(300, 500);
        
        panelContenedor.add(panelContenedorLexema);
        panelContenedorLexema.setVisible(true);
        panelContenedor.repaint();
    }
    
    public void crearCategoriaLexema(){
        configuracionPanelContenedorLexema();
        
        for (Token lT : listTokens) {
            if(lT.getEnum().name().equals(tokenEnum)){
                JButton  botonLexema = new JButton(lT.getLexema());  //crea el Boton con el texto lexema 
                botonLexema.setBackground(new java.awt.Color(0, 0, 102));
        botonLexema.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonLexema.setForeground(Color.white);
                accionCrearImagen(botonLexema, lT);//agrega las acciones al boton
                panelContenedorLexema.add(botonLexema);
                
                
            }            
            
        }
    }
        
    public void accionCrearImagen(JButton boton, Token token){
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                establecerImagenLineaColumna(boton, token);
                
            }
        });
    }
    
    
//        private static final String IMAGES_ROOT_PATH = "/imagenes/tiposPlanetas/";
    
    
    
    public void establecerImagenLineaColumna(JButton boton, Token token){
           nombreToken = token.getLexema();
       
          panelGraficos.setLabelLinea("Linea : " + token.getLinea());
          panelGraficos.setLabelColumna("Columna : " + token.getColumna());
          
          try {
            ImageIcon imagen = new ImageIcon(getClass().getResource(IMAGES_ROOT_PATH + nombreToken + extension));
            imagenLexema = new ImageIcon(imagen.getImage().getScaledInstance(200, 480, Image.SCALE_DEFAULT));
            insertarImagen.setIcon(imagenLexema);
            insertarImagen.setVisible(true);
            
        } catch (Exception e) {
            
        }

        

//        panelContenedorImagen.add(new JLabel(lexema));
        panelGraficos.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
//    public void concatenar(String Lexema){
//        char [] caracteres = Lexema.toCharArray();
//        
//        
//        
//        
//    }
        
        
    
}
