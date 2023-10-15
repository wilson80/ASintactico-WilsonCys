
package Vista;

import Tokens.Token;
import backend.Sintactico.Instrucciones;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Jonwil
 */
public class VentanaReportes extends javax.swing.JFrame {
    JTable tablaReportes;
    JTable tablaSimbolos;
    private List<Token> listTokens;
    private List<Instrucciones> listExpresiones;
    private List<Instrucciones> listFunciones;
    private List<String> listInstruccionesBloque;
    private int filas;
    private static final int columnas =6;
    private  JScrollPane scrollPane;
    
    Object [][] datosTable;
    Object [][] datosExpresiones;
    Object [][] datosInstrucciones;
   
    public VentanaReportes(List<Token> listTokens) {
        initComponents();
        scrollPane = new JScrollPane();
//        scrollPane2 = new JScrollPane();
        this.listTokens = listTokens;
        this.filas = listTokens.size();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        menuTokens = new javax.swing.JMenu();
        menuSimboloGlobal = new javax.swing.JMenu();
        menuSimboloBloque = new javax.swing.JMenu();
        menuInstrucciones = new javax.swing.JMenu();
        menuFun_Met = new javax.swing.JMenu();
        menuLLamadas = new javax.swing.JMenu();
        menuErrores = new javax.swing.JMenu();
        menuParametros = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPORTES");

        panelContenedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelContenedor.setLayout(new java.awt.GridLayout(1, 1));

        MenuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));

        menuTokens.setText("TOKENS");
        menuTokens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTokensMouseClicked(evt);
            }
        });
        MenuBar.add(menuTokens);

        menuSimboloGlobal.setText("SIMBOLOS(global)");
        menuSimboloGlobal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSimboloGlobalMouseClicked(evt);
            }
        });
        MenuBar.add(menuSimboloGlobal);

        menuSimboloBloque.setText("SIMBOLOS (bloque de codigo)");
        menuSimboloBloque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSimboloBloqueMouseClicked(evt);
            }
        });
        MenuBar.add(menuSimboloBloque);

        menuInstrucciones.setText("INSTRUCCIONES (por bloque)");
        menuInstrucciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuInstruccionesMouseClicked(evt);
            }
        });
        MenuBar.add(menuInstrucciones);

        menuFun_Met.setText("FUNCIONES/METODOS");
        MenuBar.add(menuFun_Met);

        menuLLamadas.setText("LLAMADAS ");
        MenuBar.add(menuLLamadas);

        menuErrores.setText("ERRORES");
        MenuBar.add(menuErrores);

        menuParametros.setText("PARAMETROS DE FUNCION");
        MenuBar.add(menuParametros);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSimboloGlobalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSimboloGlobalMouseClicked
        llenarTablaSimbolos();
        tablaSimbolosPrueba();
        
    }//GEN-LAST:event_menuSimboloGlobalMouseClicked

    private void menuTokensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTokensMouseClicked
        verReportes();
    }//GEN-LAST:event_menuTokensMouseClicked

    private void menuSimboloBloqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSimboloBloqueMouseClicked
//        mostrarMenu(new JTextArea("simbolos por bloque de CODIGO"));
    }//GEN-LAST:event_menuSimboloBloqueMouseClicked

    private void menuInstruccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInstruccionesMouseClicked
        
    }//GEN-LAST:event_menuInstruccionesMouseClicked
 

//    public void mostrarMenu(JTextArea jtextarea) {
//        panelContenedor.removeAll();;
//        panelContenedor.add(jtextarea);
//        panelContenedor.updateUI();
//    }
    
    public void verReportes(){
        datosTable = new Object[filas][columnas];
        llenarReportes();
        configurarTabla();
        panelContenedor.add(scrollPane);
    }
    
    public void llenarReportes() {
        for (int i = 0; i < listTokens.size(); i++) {
            for (int j = 0; j <columnas; j++) {
                switch (j) {
                    case 0:
                        datosTable [i][j] = i;
                        break;
                    case 1:
                        datosTable [i][j] = listTokens.get(i).getEnum();
                        break;
                    case 2:
                        if(listTokens.get(i).getPatron()!=null){
                            datosTable [i][j] = listTokens.get(i).getPatron();
                        }
                        break;
                    case 3:
                        datosTable [i][j] = listTokens.get(i).getLexema();
                        break;
                    case 4:
                        datosTable [i][j] = listTokens.get(i).getLinea();
                        break;
                    case 5:
                        datosTable [i][j] = listTokens.get(i).getColumna();
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
    }

    
    public void configurarTabla(){
        tablaReportes = new JTable();
        
        tablaReportes.setModel(new javax.swing.table.DefaultTableModel(
            datosTable ,
            new String [] {
                "#","Token", "Patron", "Lexema", "Linea", "columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class         
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tablaReportes);
    }
    
    
    
    public void llenarTablaSimbolos(){
        datosExpresiones = new Object[listExpresiones.size()][5];
        for (int i = 0; i < listExpresiones.size(); i++) {
            for (int j = 0; j < 5; j++) {
                switch (j) {
                    case 0:
                        datosExpresiones[i][j] = listExpresiones.get(i).getSimbolo();
                        break;
                    case 1:
                        datosExpresiones[i][j] = listExpresiones.get(i).getTipo();
                        break;
                    case 2:
                        datosExpresiones[i][j] = listExpresiones.get(i).getValor();
                        break;
                    case 3:
                        datosExpresiones[i][j] = listExpresiones.get(i).getLinea();
                        break;
                    case 4:
                        datosExpresiones[i][j] = listExpresiones.get(i).getColumna();
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
    }
    
    public void tablaSimbolosPrueba(){
        tablaSimbolos = new JTable();
        
        tablaSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            datosExpresiones ,
            new String [] {
                "SIMBOLO", "TIPO", "VALOR", "Linea", "columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tablaSimbolos);
    }

    public void setListExpresiones(List<Instrucciones> listExpresiones) {
        this.listExpresiones = listExpresiones;
    }

    public void setListFunciones(List<Instrucciones> listFunciones) {
        this.listFunciones = listFunciones;
    }

    public void setListInstruccionesBloque(List<String> listInstruccionesBloque) {
        this.listInstruccionesBloque = listInstruccionesBloque;
    }
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu menuErrores;
    private javax.swing.JMenu menuFun_Met;
    private javax.swing.JMenu menuInstrucciones;
    private javax.swing.JMenu menuLLamadas;
    private javax.swing.JMenu menuParametros;
    private javax.swing.JMenu menuSimboloBloque;
    private javax.swing.JMenu menuSimboloGlobal;
    private javax.swing.JMenu menuTokens;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
