/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel
 */
public class Interfaz extends javax.swing.JFrame {

    Mensaje objMen = new Mensaje();
    
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
    }

     private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/apinodominguez/Descargas/SQLiteStudio/BasesDeDatos/Libreria.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("conn");
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    /**
     *
     */
    public void selectAll(){
        String sql = "SELECT isbn, titulo, nombre FROM libros INNER JOIN autor ON autor.id = libros.idautor";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                Object[] row = { rs.getInt("isbn"), rs.getString("titulo"), rs.getString("nombre")};
                 DefaultTableModel model = (DefaultTableModel) tablaLibros.getModel();

                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     */
    public void limpiarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) tablaLibros.getModel();
        dtm.setRowCount(0);
    } 
      
    /**
     *
     * @param id
     * @param sql
     */
    public void selectWhere(int id, String sql){
        
        System.out.println("id- "+ id);
        System.out.println("sql"+ sql);
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
             pstmt.setInt(1,id);
             
             ResultSet rs    = pstmt.executeQuery();
            System.out.println("1---");
            // loop through the result set
            while (rs.next()) {
                Object[] row = { rs.getInt("isbn"), rs.getString("titulo"), rs.getString("nombre")};
                 DefaultTableModel model = (DefaultTableModel) tablaLibros.getModel();

                model.addRow(row);
            }
       
    }   catch (SQLException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        etiquetaTitulo = new javax.swing.JLabel();
        botonAñadir = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonMostar = new javax.swing.JButton();
        etiquetaT = new javax.swing.JLabel();
        etiquetaA = new javax.swing.JLabel();
        textoT = new javax.swing.JTextField();
        textoA = new javax.swing.JTextField();
        etiquetaID = new javax.swing.JLabel();
        textoIsbn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "TITULO", "AUTOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaLibros);

        etiquetaTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etiquetaTitulo.setText("LIBROS DISPONIBLES");

        botonAñadir.setText("AÑADIR");
        botonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirActionPerformed(evt);
            }
        });

        botonBorrar.setText("BORRAR");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonActualizar.setText("ACTUALIZAR");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonBuscar.setText("BUSCAR");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonMostar.setText("MOSTAR");
        botonMostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostarActionPerformed(evt);
            }
        });

        etiquetaT.setText("TITULO:");

        etiquetaA.setText("AUTOR:");

        etiquetaID.setText("ISBN:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(etiquetaA)
                                        .addGap(18, 18, 18)
                                        .addComponent(textoA, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiquetaT)
                                            .addComponent(etiquetaID))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textoT)
                                            .addComponent(textoIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(etiquetaTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonMostar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(etiquetaTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaID)
                    .addComponent(textoIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaT)
                    .addComponent(textoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaA)
                    .addComponent(textoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAñadir)
                    .addComponent(botonBorrar)
                    .addComponent(botonActualizar)
                    .addComponent(botonBuscar)
                    .addComponent(botonMostar))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirActionPerformed
       Metodos objM = new Metodos();
       if(textoIsbn.getText().isEmpty()){
       if (!textoT.getText().isEmpty() && !textoA.getText().isEmpty()){
            objM.ConsultaSimple(textoA.getText(), "INSERT INTO autor(nombre) VALUES(?)");
            objM.ConsultaCompleja(textoT.getText(), objM.seleccionWhere(textoA.getText(),"SELECT ID FROM autor WHERE nombre = ?"), "INSERT INTO libros(titulo,idautor) VALUES (?,?)");
            textoT.setText("");
            textoA.setText("");
       }
       else{
           if(!textoT.getText().isEmpty()){
               objM.ConsultaSimple(textoT.getText(), "INSERT INTO libros(titulo) VALUES(?)");
               textoT.setText("");
           }
           else if(!textoA.getText().isEmpty()){
               objM.ConsultaSimple(textoA.getText(), "INSERT INTO autor(nombre) VALUES(?)");
               textoA.setText("");
           }
           else{
               objMen.setVisible(true);
               objMen.cambiarText("Introduce al menos un campo para continuar");
           }
       }
       }
       else{
          objMen.setVisible(true);
          objMen.cambiarText("Deja el campo ISBN vacio cuando quieras añadir");
       }
    }//GEN-LAST:event_botonAñadirActionPerformed

    private void botonMostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostarActionPerformed
        limpiarTabla();
        selectAll();
    }//GEN-LAST:event_botonMostarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
         Metodos objM = new Metodos();
         
         if (!textoT.getText().isEmpty() && !textoA.getText().isEmpty() && !textoIsbn.getText().isEmpty()){
             objMen.setVisible(true);
               objMen.cambiarText("No puedes eliminar los tres campos a la vez");
       }
         else if((!textoIsbn.getText().isEmpty() && !textoT.getText().isEmpty()) || (!textoIsbn.getText().isEmpty() && !textoA.getText().isEmpty()) || (!textoT.getText().isEmpty() && !textoA.getText().isEmpty()) ){
            objMen.setVisible(true);
            objMen.cambiarText("Solamente puedes elegir un campo");
         }
        else{
           if(!textoT.getText().isEmpty()){
               objM.cuenta(textoT.getText(), "Select count(titulo) from libros where titulo= (?)");
               objM.ConsultaSimple(textoT.getText(), "DELETE FROM libros WHERE titulo = (?)");
               textoT.setText("");
           }
           else if(!textoA.getText().isEmpty()){
               objM.cuenta(textoA.getText(), "Select count(nombre) from autor where nombre= (?)");
              objM.ConsultaSimple(textoA.getText(), "DELETE FROM autor WHERE nombre = (?)");
               textoA.setText("");
           }
           else if (!textoIsbn.getText().isEmpty()){
               objM.cuenta(Integer.parseInt(textoIsbn.getText()), "Select count(isbn) from libros where isbn= (?)");
               objM.ConsultaSimple(Integer.parseInt(textoIsbn.getText()), "DELETE FROM libros WHERE ISBN = (?)");
               textoIsbn.setText("");
           }
           else{
               objMen.setVisible(true);
               objMen.cambiarText("Introduce al menos un campo para continuar");
           }
       } 
         
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        Metodos objM = new Metodos();
        if (!textoT.getText().isEmpty() && !textoA.getText().isEmpty() && !textoIsbn.getText().isEmpty()){
            objMen.setVisible(true);
               objMen.cambiarText("No puedes modificar el ISBN");
       }
        else{
            if(!textoT.getText().isEmpty() && !textoIsbn.getText().isEmpty()){
                objM.cuenta(Integer.parseInt(textoIsbn.getText()), "Select count(libros) from libros where isbn= (?)"); 
              objM.ConsultaCompleja(textoT.getText(), Integer.parseInt(textoIsbn.getText()), "UPDATE libros SET titulo = (?) WHERE ISBN = (?)");  
            }
            else if(!textoA.getText().isEmpty() && !textoIsbn.getText().isEmpty()){
              objM.cuenta(Integer.parseInt(textoIsbn.getText()), "Select count(autores) from autor where id= (SELECT idautor FROM libros where isbn = (?))"); 
              objM.ConsultaCompleja(textoA.getText(), Integer.parseInt(textoIsbn.getText()), "UPDATE autor SET nombre = (?) WHERE ID = (SELECT idautor FROM libros where ISBN = (?))");  
            }
            else if (!textoA.getText().isEmpty() && !textoT.getText().isEmpty()){
              objM.cuenta(textoA.getText(), "Select count(autorid) from libros where titulo= (?)");  
              objM.ConsultaCompleja(textoA.getText(), textoT.getText(), "UPDATE autor SET nombre = (?) WHERE ID = (SELECT idautor FROM libros where titulo = (?))");  
            }
            else{
               objMen.setVisible(true);
               objMen.cambiarText("Selecciona los campos correctamente");
            }
        } 
    }//GEN-LAST:event_botonActualizarActionPerformed
//
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(!textoIsbn.getText().isEmpty()){
            selectWhere(Integer.parseInt(textoIsbn.getText()),"SELECT isbn, titulo, nombre FROM libros INNER JOIN autor ON autor.id = libros.idautor WHERE isbn = ( ? )");
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAñadir;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonMostar;
    private javax.swing.JLabel etiquetaA;
    private javax.swing.JLabel etiquetaID;
    private javax.swing.JLabel etiquetaT;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField textoA;
    private javax.swing.JTextField textoIsbn;
    private javax.swing.JTextField textoT;
    // End of variables declaration//GEN-END:variables
}
