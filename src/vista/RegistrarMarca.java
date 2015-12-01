/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Marca;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author crist
 */
public class RegistrarMarca extends javax.swing.JInternalFrame {

    
    Object[][] dtPer;
    int fila = -1;
    Marca M=new Marca();

    /**
     * Creates new form RegistrarMarca
     */
    public RegistrarMarca() {
        initComponents();
    }
    
    private void updateTabla(){             
        String[] columNames = {"Id_Marca","Descripcion"};  
        // se utiliza la funcion
        dtPer = M.getDatos();
               
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtPer,columNames);                        
        Tabla.setModel(datos); 
        //ajustamos tamaño de la celda ID
        TableColumn columna = Tabla.getColumn("Id_Marca");        
        columna.setPreferredWidth(50);
        columna.setMinWidth(10);
        columna.setMaxWidth(30);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Agregar Marca Del Auto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Desripción Marca De Auto"));

        jLabel1.setText("Descripción");

        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnnuevo.setForeground(new java.awt.Color(204, 0, 0));
        btnnuevo.setText("Nuevo ");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setForeground(new java.awt.Color(204, 0, 0));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/16 (Save).jpg"))); // NOI18N
        btnguardar.setText("Guardar ");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneliminar.setForeground(new java.awt.Color(204, 0, 51));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/16 (Delete).jpg"))); // NOI18N
        btneliminar.setText("Eliminar ");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnactualizar.setForeground(new java.awt.Color(204, 0, 51));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/16 (User edit).jpg"))); // NOI18N
        btnactualizar.setText("Actualizar ");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/marca.png"))); // NOI18N

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {null, ""},
                {null, ""},
                {null, ""},
                {null, ""},
                {null, ""},
                {null, ""}
            },
            new String [] {
                "ID", "Descripcion"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel2)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        txtdescripcion.setText("");
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (fila > -1){
        String id = String.valueOf(Tabla.getValueAt(fila, 0));
        
        M.EliminarMarca(id);
        updateTabla();
        fila=-1;
        }
        
        
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        if (fila > -1){
        String id = String.valueOf(Tabla.getValueAt(fila, 0));
        String descripcion=txtdescripcion.getText();
        
        M.ActualizarMarca(id, descripcion);
            
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String descripcion=txtdescripcion.getText();
        
        M.GuardarMarca(descripcion);
        updateTabla();    
    }//GEN-LAST:event_btnguardarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.rowAtPoint(evt.getPoint());                 
         if (fila > -1){                          
             txtdescripcion.setText(String.valueOf(Tabla.getValueAt(fila, 1)));
         }
    }//GEN-LAST:event_TablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tabla;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
}
