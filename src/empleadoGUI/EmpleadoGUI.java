package empleadoGUI;

import static empleadoDAL.Conexion.getConectar;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.EmpleadoBL;

public class EmpleadoGUI extends javax.swing.JFrame {

    //Para trabajar con tablas se utiliza DefaultTableModel
    DefaultTableModel modeloTabla;

    PreparedStatement ps;
    ResultSet rs;

    public EmpleadoGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Empleado");
        encabezadoTabla();
        listarEmpleado();
        limpiarCajas();
    }
    public void encabezadoTabla() {
        String cabecera[] = {"ID", "Nombre", "Email"};
        modeloTabla = new DefaultTableModel(null, cabecera);
        tblEmpleado.setModel(modeloTabla);
    }

    //Select tabl empleado y mostrar en tabla
    public void listarEmpleado() {
        //limpiar tabla cada vez que eliminamos
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        Connection conexion = null;
        try {
            conexion = getConectar();
            ps = conexion.prepareStatement("SELECT * from empleado");
            //OJO: executeUpdate: cuando haces consultas a la BD
            //OJO: executeQuery: cuando traes datos de la BD, pintas en pantalla
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] oEmpleado = {rs.getString("id"), rs.getString("nombre"), rs.getString("correo")};
                //insertar en la tabla los datos
                modeloTabla.addRow(oEmpleado);
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Error al listar: " + e);
        }
    }
    
    //Asignar valores de los textField al modelo Empleado
    public EmpleadoBL capturarDatosGUI(){
        EmpleadoBL ob=new EmpleadoBL();
        int id=(txtId.getText().isEmpty())?0: Integer.parseInt(txtId.getText());
        ob.setId(id);
        ob.setNombre(txtNombre.getText());
        ob.setCorreo(txtCorreo.getText());
        return ob; 
    }
    
    public void limpiarCajas(){
        txtId.setText(null);
        txtNombre.setText(null);
        txtCorreo.setText(null);
        //activar y desactivar botones
        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleado);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("ID");

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cancelar.png"))); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/eliminar.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Correo");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtCorreo))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadoMouseClicked
        //Evento para seleccionar valores de fila clickeada
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            txtId.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtNombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtCorreo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
        }
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnBorrar.setEnabled(true);
    }//GEN-LAST:event_tblEmpleadoMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //DELETE FILA TABLA
        Connection conexion = null;
        try {
            conexion = getConectar();
            ps = conexion.prepareStatement("delete from empleado where id=?");
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            //ejecutar la consulta
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente!");
                listarEmpleado();
                limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro");
            }
            //cerramos la conexión
            conexion.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Connection conexion = null;
        EmpleadoBL ob=capturarDatosGUI();
        try {
            conexion = getConectar();
            ps = conexion.prepareStatement("insert into empleado(nombre,correo) values (?,?)");
            ps.setString(1, ob.getNombre());
            ps.setString(2, ob.getCorreo());
         
            //ejecutar la consulta
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro insertado correctamente!");
                listarEmpleado();
                limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar registro");
            }
            //cerramos la conexión
            conexion.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // EDITAR empleado
        Connection conexion = null;
        EmpleadoBL ob=capturarDatosGUI();
        try {
            conexion = getConectar();
            ps = conexion.prepareStatement("update empleado set nombre=?, correo=? where id=?");
            ps.setString(1, ob.getNombre());
            ps.setString(2, ob.getCorreo());
            ps.setString(3, String.valueOf(ob.getId()));
         
            //ejecutar la consulta
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente!");
                listarEmpleado();
                limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar registro");
            }
            //cerramos la conexión
            conexion.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadoGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleado;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
