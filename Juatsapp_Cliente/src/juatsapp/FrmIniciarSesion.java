/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juatsapp;

import entidades.Chat;
import implementaciones.UsuarioDAO;
import implementaciones.ConexionBD;
import interfaces.IUsuariosDAO;
import implementaciones.ChatDAO;
import entidades.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Luis Baez
 */
public class FrmIniciarSesion extends javax.swing.JFrame {

    ConexionBD conexion;
    ChatDAO cd = new ChatDAO();
    /**
     * Creates new form FrmIniciarSesion
     */
    public FrmIniciarSesion() {
        initComponents();
        centrarFrame();
    }
    
    public void centrarFrame(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bIniciarSesion = new javax.swing.JButton();
        bCrearCuenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        pfContra = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");

        bIniciarSesion.setText("Iniciar sesión");
        bIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarSesionActionPerformed(evt);
            }
        });

        bCrearCuenta.setText("Crear cuenta");
        bCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearCuentaActionPerformed(evt);
            }
        });

        jLabel1.setText("Correo electrónico");

        jLabel2.setText("Contraseña:");

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Juatsapp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(pfContra))
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(bIniciarSesion)
                        .addGap(75, 75, 75)
                        .addComponent(bCrearCuenta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel3)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCrearCuenta)
                    .addComponent(bIniciarSesion))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarSesionActionPerformed
        String contra = String.copyValueOf(pfContra.getPassword());
        String email = tfEmail.getText();
        if (!contra.isEmpty() && !tfEmail.getText().isEmpty()) {
            UsuarioDAO ud = new UsuarioDAO();
            Usuario usuario = ud.buscarPorEmailyContra(tfEmail.getText(), contra);
            //
            
            //    System.out.println(usuario.getContrasenia());
            if (usuario != null) {
            ChatDAO pd = new ChatDAO();
//            List<Chat> chats = pd.mostrarPorIntegrantes(email);
            pd.mostrarPorIntegrantes(email);
//                cd.mostrarPorIntegrantes(tfEmail.getText());
                FrmMuroChats frm = new FrmMuroChats(usuario);
                //
//            if (!chats.isEmpty()) {
//            Collections.reverse(chats);    
//            for (Chat chat : chats) {
//                frm.add(new PanelChat(usuario, chat, frm));
//            }
//            }          
            //
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
                this.dispose();
                
//                
//            frm.removeAll();
            
//            
            }else{
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrecto", "Error", ERROR_MESSAGE);
            }

        } else {
            System.out.println("sos");
        }
    }//GEN-LAST:event_bIniciarSesionActionPerformed

    private void bCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearCuentaActionPerformed
        FrmCrearCuenta frm = new FrmCrearCuenta();
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bCrearCuentaActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

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
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrearCuenta;
    private javax.swing.JButton bIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pfContra;
    private javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
}
