/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juatsapp;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Chat;
import implementaciones.UsuarioDAO;
import implementaciones.ConexionBD;
import entidades.Usuario;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Luis Baez
 */
public class FrmEditarUsuario extends javax.swing.JFrame {

    ConexionBD conexion;
    Usuario usuario;
    ArrayList<Usuario> usuarios;
    private IConexionBD iconexion;
    private MongoDatabase bd;    
    UsuarioDAO ud = new UsuarioDAO();
    /**
     * Creates new form FrmEditarUsuario
     */
    Usuario usuarioConectado;
    DefaultListModel<String> modeloM, modeloP;

    public FrmEditarUsuario(Usuario usuarioConectado) {
        initComponents();
        this.usuarioConectado = usuarioConectado;
        modeloM = new DefaultListModel<>();
        modeloP = new DefaultListModel<>();
        cargarDatos();
    }

    private FrmEditarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//       public MongoCollection<Usuario> getColeccion() {
////        return this.bd.getCollection("usuarios", Usuario.class);
//       MongoDatabase bd = this.crearConexion();
//       MongoCollection<Usuario> coleccion = bd.getCollection("usuarios", Usuario.class);
//       return coleccion;
//    }        
//        public List<Usuario> mostrarUsuarios() {
//        MongoCollection<Usuario> coleccion = this.getColeccion();
//        FindIterable<Usuario> usuarios = coleccion.find();
//        
//        ArrayList<Usuario> listaUsuarios = new ArrayList();
//        return usuarios.into(listaUsuarios);
//    }
    public void cargarDatos() {
        modeloM.removeAllElements();
        modeloP.removeAllElements();
        tfEmail.setText(usuarioConectado.getEmailUsuario());
        tfEdad.setText(usuarioConectado.getEdad());

//        Period edad = Period.between(usuarioConectado.getFechaNac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
//        tfEdad.setText("" + edad.getYears());
        if (usuarioConectado.getSexo() == 'H' ) {
            cbSexo.setSelectedIndex(0);
        } else if(usuarioConectado.getSexo() == 'M') {
            cbSexo.setSelectedIndex(1);
        } else if(usuarioConectado.getSexo() == 'R') {
            cbSexo.setSelectedIndex(2);
        }

    }

    
//    private static final String HOST = "localhost";
//    private static final int PUERTO = 27017;
//    private static final String BASE_DATOS = "juatsapp";
//    
//    public MongoDatabase crearConexion() {
//        try{
//            //CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
//            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
//            
//            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
//            
//            ConnectionString cadenaConexion = new ConnectionString("mongodb://"+HOST+"/"+PUERTO);
//            
//            MongoClientSettings clientsSettings = MongoClientSettings.builder()
//                .applyConnectionString(cadenaConexion)
//                .codecRegistry(codecRegistry)
//                .build();
//            
//            MongoClient clienteMongo = MongoClients.create(clientsSettings);
//            
//            MongoDatabase baseDatos = clienteMongo.getDatabase(BASE_DATOS);
//            
//            return baseDatos;           
//        }catch(Exception ex){
//            System.err.println(ex.getMessage());
//            return null;
//        }
//    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        tfEdad = new javax.swing.JTextField();
        bGuardar = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pfContraNueva = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        pfContra = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Usuario");

        jLabel1.setText("Correo electrónico:");

        jLabel4.setText("Sexo:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Robot" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Juatsapp");

        lblEdad.setText("Edad:");

        bGuardar.setText("Guardar Cambios");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bVolver.setText("Volver");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        jLabel2.setText("Contraseña:");

        jLabel3.setText("Contraseña actual para confirmar los cambios:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("?");
        jLabel12.setToolTipText("Campos vacíos no hacen cambios");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(pfContra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bGuardar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(lblEdad)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbSexo, 0, 130, Short.MAX_VALUE)
                                .addComponent(tfEmail))
                            .addComponent(pfContraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bVolver)
                                .addGap(264, 264, 264))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel8)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(tfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfContraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar)
                    .addComponent(bVolver))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        String contra = String.copyValueOf(pfContra.getPassword());

        
        if(ud.buscarPorEmail(tfEmail.getText()) == null){
                    if (contra.equals(usuarioConectado.getContrasenia())) {

            int respuesta=JOptionPane.showConfirmDialog(this, "¿Estás segur@ que quieres hacer esta acción?", "Atención", YES_NO_OPTION);
            if (respuesta==0) {
                if (!tfEmail.getText().isEmpty()){
                    usuarioConectado.setEmailUsuario(tfEmail.getText());
                }
//                if(tfEmail.getText().equals(ud.buscarPorEmail(usuarioConectado.getEmailUsuario()))){
//                    JOptionPane.showMessageDialog(this, "Usuario ya existe", "Acción", INFORMATION_MESSAGE);
//                }
                if (tfEdad.getText() != null) {
                    usuarioConectado.setEdad(tfEdad.getText());
                }

                String contraNueva = String.copyValueOf(pfContraNueva.getPassword());
                if (!contraNueva.isEmpty()) {
                    usuarioConectado.setContrasenia(contraNueva);
                }

                if (cbSexo.getSelectedItem().toString().equalsIgnoreCase("Hombre")) {
                    usuarioConectado.setSexo('H');
                } else if (cbSexo.getSelectedItem().toString().equalsIgnoreCase("Mujer")){
                    usuarioConectado.setSexo('M');
                } else {
                    usuarioConectado.setSexo('R');
                }

                ud.actualizar(usuarioConectado);
                JOptionPane.showMessageDialog(this, "Se han guardado los cambios", "Acción", INFORMATION_MESSAGE);
                cargarDatos();
            }
//            else if(tfEmail.getText().equals(ud.buscarPorEmail(usuarioConectado.getEmailUsuario()))){
//                    JOptionPane.showMessageDialog(this, "Usuario ya existe", "Acción", INFORMATION_MESSAGE);
//                }

        }   else {
            JOptionPane.showMessageDialog(this, "Ingrese la contraseña actual para guardar cambios", "Aviso", WARNING_MESSAGE);
        }
        } else{
            JOptionPane.showMessageDialog(this, "Usuario ya existe", "Acción", INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_bGuardarActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        FrmMuroChats frm = new FrmMuroChats(usuarioConectado);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bVolver;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JPasswordField pfContra;
    private javax.swing.JPasswordField pfContraNueva;
    private javax.swing.JTextField tfEdad;
    private javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
}
