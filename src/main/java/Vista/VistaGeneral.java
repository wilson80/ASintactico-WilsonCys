
package Vista;

import com.controlVista.EjecutarCreacionImagenes;
import com.controlVista.CrearArchivoDot;
import Tokens.Token;
import backend.Sintactico.Analizador_Sintactico;
import com.backenControl.ControlAnalizadorLexico;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jonwil
 */
public class VistaGeneral extends javax.swing.JFrame {
    
    ControlAnalizadorLexico controlAnalizador;
    panelGraficos panelGraficos; 
    private int contador = 0;
    private boolean  analisisRealizado = false;
    private List<Token> listTokens;
    private EjecutarCreacionImagenes ejecutarCreacionImagenes;
    private VentanaReportes ventanaReportes;
    
    /**
     * Creates new form VistaGeneral
     */
    public VistaGeneral() {
        initComponents();
        setSize(894, 662);
        establecerConfiguracionBotones();
    }
       
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        panelContenedorGraficos_Editor = new javax.swing.JPanel();
        panelContenedorEditor = new javax.swing.JPanel();
        panelTexto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajonEditorTexto = new javax.swing.JTextPane();
        panelError = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cajonMostrarErroers = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        botonAnalizar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonReportes = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        barraColumnas = new javax.swing.JTextArea();
        panelContenedorGraficos = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        archivo = new javax.swing.JButton();
        editorTexto = new javax.swing.JButton();
        generarGraficos = new javax.swing.JButton();
        botonAcercaDe = new javax.swing.JButton();
        botonAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parse-Py");
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        panelGeneral.setBackground(new java.awt.Color(0, 51, 102));
        panelGeneral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 2, true));
        panelGeneral.setLayout(null);

        panelContenedorGraficos_Editor.setLayout(null);

        panelContenedorEditor.setBackground(new java.awt.Color(51, 51, 51));
        panelContenedorEditor.setLayout(null);

        cajonEditorTexto.setBackground(new java.awt.Color(153, 153, 153));
        cajonEditorTexto.setBorder(null);
        cajonEditorTexto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(cajonEditorTexto);

        javax.swing.GroupLayout panelTextoLayout = new javax.swing.GroupLayout(panelTexto);
        panelTexto.setLayout(panelTextoLayout);
        panelTextoLayout.setHorizontalGroup(
            panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        panelTextoLayout.setVerticalGroup(
            panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        panelContenedorEditor.add(panelTexto);
        panelTexto.setBounds(40, 0, 850, 300);

        cajonMostrarErroers.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setViewportView(cajonMostrarErroers);

        javax.swing.GroupLayout panelErrorLayout = new javax.swing.GroupLayout(panelError);
        panelError.setLayout(panelErrorLayout);
        panelErrorLayout.setHorizontalGroup(
            panelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        panelErrorLayout.setVerticalGroup(
            panelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        panelContenedorEditor.add(panelError);
        panelError.setBounds(10, 350, 880, 170);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" ERRORES");
        panelContenedorEditor.add(jLabel1);
        jLabel1.setBounds(20, 320, 66, 24);

        botonAnalizar.setText("Analizar");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });
        panelContenedorEditor.add(botonAnalizar);
        botonAnalizar.setBounds(270, 540, 100, 30);

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        panelContenedorEditor.add(botonLimpiar);
        botonLimpiar.setBounds(160, 540, 110, 30);

        botonReportes.setText("Reportes");
        botonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReportesActionPerformed(evt);
            }
        });
        panelContenedorEditor.add(botonReportes);
        botonReportes.setBounds(370, 540, 110, 30);

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        barraColumnas.setEditable(false);
        barraColumnas.setBackground(new java.awt.Color(51, 51, 51));
        barraColumnas.setColumns(20);
        barraColumnas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        barraColumnas.setForeground(new java.awt.Color(153, 153, 153));
        barraColumnas.setRows(9);
        barraColumnas.setTabSize(4);
        barraColumnas.setText("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12");
        jScrollPane2.setViewportView(barraColumnas);

        panelContenedorEditor.add(jScrollPane2);
        jScrollPane2.setBounds(10, 0, 30, 300);

        panelContenedorGraficos_Editor.add(panelContenedorEditor);
        panelContenedorEditor.setBounds(-10, 0, 890, 610);

        panelContenedorGraficos.setBackground(new java.awt.Color(153, 153, 153));
        panelContenedorGraficos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 51), 3, true));
        panelContenedorGraficos.setLayout(new java.awt.GridLayout(1, 1));
        panelContenedorGraficos_Editor.add(panelContenedorGraficos);
        panelContenedorGraficos.setBounds(0, 0, 880, 610);

        panelGeneral.add(panelContenedorGraficos_Editor);
        panelContenedorGraficos_Editor.setBounds(0, 50, 880, 610);

        panelOpciones.setLayout(new java.awt.GridBagLayout());

        archivo.setText("Archivo");
        archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoActionPerformed(evt);
            }
        });
        panelOpciones.add(archivo, new java.awt.GridBagConstraints());

        editorTexto.setText("Editor de texto");
        editorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorTextoActionPerformed(evt);
            }
        });
        panelOpciones.add(editorTexto, new java.awt.GridBagConstraints());

        generarGraficos.setText("Generar Graficos");
        generarGraficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarGraficosActionPerformed(evt);
            }
        });
        panelOpciones.add(generarGraficos, new java.awt.GridBagConstraints());

        botonAcercaDe.setText("Acerca de");
        panelOpciones.add(botonAcercaDe, new java.awt.GridBagConstraints());

        botonAyuda.setText("Ayuda");
        panelOpciones.add(botonAyuda, new java.awt.GridBagConstraints());

        panelGeneral.add(panelOpciones);
        panelOpciones.setBounds(40, 10, 560, 30);

        getContentPane().add(panelGeneral);
        panelGeneral.setBounds(0, 0, 880, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoActionPerformed
        contador++;
        
        JFileChooser jFileChooser = new JFileChooser();                 //Recibir Archivo de entrada por medio de FileChoser
        
        int selecccion = jFileChooser.showOpenDialog(this);
        
        if(selecccion==JFileChooser.APPROVE_OPTION){
            
            File fichero = jFileChooser.getSelectedFile();
            this.archivo.setText("Archivo");
            
            try (FileReader fr = new FileReader(fichero)){
                String cadena = "";
                int valor = fr.read();  
                while(valor != -1){
                    cadena = cadena + (char) valor;
                    valor=fr.read();
                    
                }
                this.cajonEditorTexto.setText(cadena);                    //colocar el texto del Archivo.txt en el editor de texto
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_archivoActionPerformed
  
    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed
            if(!cajonEditorTexto.getText().isBlank()) {
                analisisRealizado = true;
                controlAnalizador = new ControlAnalizadorLexico(this);
                controlAnalizador.analizar();
                this.listTokens = controlAnalizador.getListTokens();            //Obtener la lista de Tokens
                    ventanaReportes = new VentanaReportes(listTokens);  //Pasando la informacion a la clase que creara los reportes
                    Analizador_Sintactico aSintactico = new Analizador_Sintactico();
                    aSintactico.setListTokens(listTokens);
//                    aSintactico.identificarExpresion();
                    aSintactico.identificarInstruccion();
//                    aSintactico.identificar_Operadores_Entrada_salida();
                    ventanaReportes.setListExpresiones(aSintactico.getListSimbolos());
                    ventanaReportes.verReportes();
                    

                    
                    
                    
              CrearArchivoDot crearArchivoDot = new CrearArchivoDot(listTokens);  //Mandando la lista de tokens para crear los Archivos Dot
                try {
                crearArchivoDot.crearDots();
                    for (Token lT : listTokens) {
                        ejecutarCreacionImagenes = new EjecutarCreacionImagenes(lT.getLexema());
                        ejecutarCreacionImagenes.ejecutarComandos();
                    }
                } catch (Exception e) {
                }
                MostraErrores mostrarErr;                                               //Mostrar errores en el Cajon de errores        
                mostrarErr = new MostraErrores(controlAnalizador.getListTokens(), this);
                mostrarErr.clasificarerrores();
            }else{
                JOptionPane.showMessageDialog(panelGeneral, "Editor Vacio, no puede Analizar");
            }
    }//GEN-LAST:event_botonAnalizarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        cajonEditorTexto.setText("");                                       //Limpiar el cajon de texto
        cajonMostrarErroers.setText("");
        panelContenedorGraficos.setVisible(false);
        panelContenedorEditor.setVisible(true);
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void generarGraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarGraficosActionPerformed
        if(!cajonEditorTexto.getText().isBlank() && analisisRealizado) {                
//            panelContenedorGraficos_Editor.remove(panelContenedorEditor);
            this.getContentPane().repaint();
            
            panelGraficos = new panelGraficos(listTokens);
            panelGraficos.getContenedorDeContenedorTokens().setVisible(false);
            panelGraficos.setVisible(true);
            panelContenedorEditor.setVisible(false);                        //Ocultar panel editor de texto
            
            panelContenedorGraficos.add(panelGraficos);
            panelContenedorGraficos.setVisible(true);

            panelGraficos.updateUI();                                       //Actualizar la interfaz grafica
//            panelGraficos.repaint();
            
        }else{
            JOptionPane.showMessageDialog(panelGeneral, "Debe realizar un analisis primero para Generar los Graficos");
        }
    }//GEN-LAST:event_generarGraficosActionPerformed

    public void establecerConfiguracionBotones(){
        configurBoton(archivo);
        configurBoton(editorTexto);
        configurBoton(generarGraficos);
        configurBoton(botonAcercaDe);
        configurBoton(botonAyuda);
        configurBoton(botonAnalizar);
        configurBoton(botonLimpiar);
        configurBoton(botonReportes);
  
    }
    public void configurBoton(JButton boton){
        boton.setBackground(new java.awt.Color(0, 0, 102));
        boton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton.setForeground(Color.white);
    }
    
    private void editorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorTextoActionPerformed
        try {
            panelGraficos.repaint();                                        //
            panelContenedorEditor.setVisible(true);
            panelContenedorGraficos.setVisible(false);                      //ocultar el paner de la clasificacion de los graficos
            panelContenedorGraficos.removeAll();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_editorTextoActionPerformed

    private void botonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReportesActionPerformed
        if(analisisRealizado){
            ventanaReportes.setVisible(true);                                           //boton para hacer visible los reportes
        }else{
            JOptionPane.showMessageDialog(panelGeneral, "Debe realizar un analisis primero para poder visualizar los reportes");
        }
    }//GEN-LAST:event_botonReportesActionPerformed

    public JTextPane getcajonMostrarErroers() {
        return cajonMostrarErroers;
    }

    public void setCajonMostrarErroes(String areaErrores) {
        this.cajonMostrarErroers.setText(areaErrores);
    }
      public JTextPane getCajonTexto() {
        return cajonEditorTexto;
    }
    

    public void setCajonTexto(String cajonTexto) {
        this.cajonEditorTexto.setText(cajonTexto);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton archivo;
    private javax.swing.JTextArea barraColumnas;
    private javax.swing.JButton botonAcercaDe;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JButton botonAyuda;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonReportes;
    private javax.swing.JTextPane cajonEditorTexto;
    private javax.swing.JTextPane cajonMostrarErroers;
    private javax.swing.JButton editorTexto;
    private javax.swing.JButton generarGraficos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelContenedorEditor;
    private javax.swing.JPanel panelContenedorGraficos;
    private javax.swing.JPanel panelContenedorGraficos_Editor;
    private javax.swing.JPanel panelError;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelTexto;
    // End of variables declaration//GEN-END:variables
}
