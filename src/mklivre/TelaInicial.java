package mklivre;


import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import java.sql.*;
import controle.ModuloConexao;
import java.applet.Applet;
import java.applet.AudioClip;
/**
 *
 * @author willi
 */
public class TelaInicial extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int x=0;
    public void pupolaJComboBox(){
        String sql ="select * from tbusuarios2";
        try {
            pst = conexao.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                loginUsuario.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void logar(){
        String sql ="select * from tbusuarios2 where NOME =? and SENHA =?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, loginUsuario.getSelectedItem().toString());
            pst.setString(2, senhaUsuario.getText());
            rs= pst.executeQuery();
            if((loginUsuario.getSelectedItem().toString().equals(""))&&(senhaUsuario.getText().equals(""))){
                JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE LOGIN E DE SENHA!");
            }
            else if(loginUsuario.getSelectedItem().toString().equals("")){
                JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE LOGIN!");
            }
            else if(senhaUsuario.getText().equals("")){
                JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE SENHA!");
            }
            else if(rs.next()){
                int nivel = Integer.parseInt(rs.getString(3));
                String nomeusuario =rs.getString(1);
                this.dispose();
                SegundaTela menu= new SegundaTela();
                menu.setVisible(true);
                menu.acessoUser.setText(rs.getString(4));
                menu.nomeUser.setText(rs.getString(1));
                menu.mostrarNivel.setText(rs.getString(3));
                if(rs.getString(1).equals("WILLIAM")){
                    
                }
                else if(rs.getString(5).equals("FEMININO")){
                    menu.userProgramador.setVisible(false);
                    menu.userMulher.setVisible(true);
                }
                else if(rs.getString(5).equals("MASCULINO")){
                    menu.userProgramador.setVisible(false);
                    menu.userHomem.setVisible(true);
                }
                conexao.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "LOGIN OU SENHA INCORRETOS, REVISE OS CAMPOS DIGITADOS!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public TelaInicial() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botLogar = new javax.swing.JButton();
        senhaUsuario = new javax.swing.JPasswordField();
        loginUsuario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        abertura = new javax.swing.JLabel();
        op = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" LOGIN");
        setMinimumSize(new java.awt.Dimension(546, 435));
        setResizable(false);
        setSize(new java.awt.Dimension(546, 407));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FAÇA O LOGIN");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(170, 50, 210, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(160, 40, 230, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 40, 230, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 40, 230, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("LOGIN");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(110, 175, 90, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SENHA");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(110, 225, 90, 40);

        botLogar.setBackground(new java.awt.Color(0, 0, 0));
        botLogar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botLogar.setForeground(new java.awt.Color(255, 255, 255));
        botLogar.setText("LOGAR");
        botLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLogarActionPerformed(evt);
            }
        });
        botLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botLogarKeyPressed(evt);
            }
        });
        getContentPane().add(botLogar);
        botLogar.setBounds(320, 280, 110, 40);

        senhaUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        senhaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaUsuarioActionPerformed(evt);
            }
        });
        senhaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(senhaUsuario);
        senhaUsuario.setBounds(260, 220, 170, 40);

        loginUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        loginUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(loginUsuario);
        loginUsuario.setBounds(260, 170, 170, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 120, 480, 180);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 120, 480, 180);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 120, 480, 180);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/motor-dcd700-dewalt-12v-c-pinho-p-parafusadeira-dcd710-D_NQ_NP_928389-MLB29392416132_022019-F.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 546, 407);

        abertura.setText("0");
        getContentPane().add(abertura);
        abertura.setBounds(250, 70, 7, 16);

        op.setText("0");
        getContentPane().add(op);
        op.setBounds(440, 50, 7, 16);

        setSize(new java.awt.Dimension(550, 431));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLogarActionPerformed
        if(loginUsuario.getSelectedItem().toString().equals(" ")&&senhaUsuario.getText().equals("906030103")){
            SegundaTela menu= new SegundaTela();
            menu.setVisible(true);
            this.dispose();
        }
        else{
            logar();
        }
    }//GEN-LAST:event_botLogarActionPerformed

    private void senhaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaUsuarioKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(loginUsuario.getSelectedItem().toString().equals(" ")&&senhaUsuario.getText().equals("906030103")){
                SegundaTela menu= new SegundaTela();
                menu.setVisible(true);
                this.dispose();
            }
            else{
                logar();
            }
        }
    }//GEN-LAST:event_senhaUsuarioKeyPressed

    private void botLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botLogarKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(loginUsuario.getSelectedItem().toString().equals(" ")&&senhaUsuario.getText().equals("906030103")){
                SegundaTela menu= new SegundaTela();
                menu.setVisible(true);
                this.dispose();
            }
            else{
                logar();
            }
        }
    }//GEN-LAST:event_botLogarKeyPressed

    private void senhaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaUsuarioActionPerformed
    private void playmusic(){
       
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(x==0){
            x++;
            pupolaJComboBox();
        }
        if(op.getText().equals("0")){
            URL url = getClass().getResource("som.wav");
            AudioClip audio=Applet.newAudioClip(url);
            audio.play();
            op.setText("1");
        }
    }//GEN-LAST:event_formWindowActivated

    private void loginUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginUsuarioKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            senhaUsuario.requestFocus();
        }
    }//GEN-LAST:event_loginUsuarioKeyPressed
    
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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel abertura;
    private javax.swing.JButton botLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> loginUsuario;
    public static javax.swing.JLabel op;
    private javax.swing.JPasswordField senhaUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the nivelpassa
     */
    

    
}
