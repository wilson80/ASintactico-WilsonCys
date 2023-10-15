
package Vista;

import com.backenControl.clasificarTokens;
import Tokens.Token;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jonwil
 */
public class panelGraficos extends javax.swing.JPanel {
    private List<Token> listTokens;
    private List<panelGraficos> paneles;
    private clasificarTokens clasificarTokens;
    

    
    public panelGraficos(List<Token> listTokens) {
        
        this.listTokens = listTokens;
        initComponents();
        colocarImagen.setVisible(false);
        
        contenedorDeContenedorTokens.setVisible(false);
//        setBounds(0, 0, 750, 610);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorDeContenedorTokens = new javax.swing.JPanel();
        seleccionClasificacion = new javax.swing.JComboBox<>();
        botonClasificar = new javax.swing.JButton();
        panelContenedorImagen = new javax.swing.JPanel();
        colocarImagen = new javax.swing.JButton();
        labelLinea = new javax.swing.JLabel();
        labelColumna = new javax.swing.JLabel();

        contenedorDeContenedorTokens.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 3, true));
        contenedorDeContenedorTokens.setLayout(new java.awt.GridLayout(1, 1));

        seleccionClasificacion.setBackground(new java.awt.Color(0, 51, 102));
        seleccionClasificacion.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        seleccionClasificacion.setForeground(new java.awt.Color(255, 255, 255));
        seleccionClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Identificador", "Aritmeticos", "Comparacion", "Logicos", "Asignacion", "Palabras Claves", "Constantes (Cadenas)", "Constantes (Numericas)", "Constantes (Booleanas)", "Otros", "Comentario" }));
        seleccionClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionClasificacionActionPerformed(evt);
            }
        });

        botonClasificar.setBackground(new java.awt.Color(0, 51, 102));
        botonClasificar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        botonClasificar.setForeground(new java.awt.Color(255, 255, 255));
        botonClasificar.setText("Ver");
        botonClasificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClasificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorImagenLayout = new javax.swing.GroupLayout(panelContenedorImagen);
        panelContenedorImagen.setLayout(panelContenedorImagenLayout);
        panelContenedorImagenLayout.setHorizontalGroup(
            panelContenedorImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorImagenLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelContenedorImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colocarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelContenedorImagenLayout.setVerticalGroup(
            panelContenedorImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorImagenLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(labelLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(labelColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
            .addComponent(colocarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seleccionClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonClasificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contenedorDeContenedorTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(panelContenedorImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonClasificar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelContenedorImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenedorDeContenedorTokens, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionClasificacionActionPerformed

    private void botonClasificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClasificarActionPerformed
        contenedorDeContenedorTokens.removeAll();
        contenedorDeContenedorTokens.setVisible(true);
        
        int clasificacionSeleccionada = seleccionClasificacion.getSelectedIndex();
        switch (clasificacionSeleccionada) {
            case 0:
                clasificarTokens = new clasificarTokens(this, listTokens, "ID");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 1:
                clasificarTokens = new clasificarTokens(this, listTokens, "ARITMETICOS");
                clasificarTokens.crearCategoriaLexema();
                break;

            case 2:
                clasificarTokens = new clasificarTokens(this, listTokens, "COMPARACION");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 3:
                clasificarTokens = new clasificarTokens(this, listTokens, "LOGICOS");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 4:
                clasificarTokens = new clasificarTokens(this, listTokens, "ASIGNACION");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 5:
                clasificarTokens = new clasificarTokens(this, listTokens, "RESERVADA");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 6:
                clasificarTokens = new clasificarTokens(this, listTokens, "CADENA_DE_CARACTERES");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 7:
                clasificarTokens = new clasificarTokens(this, listTokens, "CONSTANTES_NUMERICAS");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 8:
                clasificarTokens = new clasificarTokens(this, listTokens, "CONSTANTES_BOOLEANAS");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 9:
                clasificarTokens = new clasificarTokens(this, listTokens, "OTROS");
                clasificarTokens.crearCategoriaLexema();
                break;
            case 10:
                clasificarTokens = new clasificarTokens(this, listTokens, "COMENTARIO");
                clasificarTokens.crearCategoriaLexema();
                break;
//            default:
//                throw new AssertionError();
        }
        
        
        contenedorDeContenedorTokens.updateUI();
//        this.repaint();
        
    }//GEN-LAST:event_botonClasificarActionPerformed

    public JPanel getContenedorDeContenedorTokens() {
        return contenedorDeContenedorTokens;
    }

    public JPanel getPanelContenedorImagen() {
        return panelContenedorImagen;
    }

    public JButton getColocarImagen() {
        return colocarImagen;
    }


    public void setLabelLinea(String labelLinea) {
        this.labelLinea.setText(labelLinea);
    }

    public void setLabelColumna(String labelColumna) {
        this.labelColumna.setText(labelColumna);
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonClasificar;
    private javax.swing.JButton colocarImagen;
    private javax.swing.JPanel contenedorDeContenedorTokens;
    private javax.swing.JLabel labelColumna;
    private javax.swing.JLabel labelLinea;
    private javax.swing.JPanel panelContenedorImagen;
    private javax.swing.JComboBox<String> seleccionClasificacion;
    // End of variables declaration//GEN-END:variables
}
