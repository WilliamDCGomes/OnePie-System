/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mklivre;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import java.sql.*;
import controle.ModuloConexao;
/**
 *
 * @author willi
 */
public class CancelarVenda extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form CancelarVenda
     */
    public CancelarVenda() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
    }
    private void remover(){
        int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA CANCELAR ESTA VENDA?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION){
            String sql = "update vendas_ml set cancela=?,motivo_cancela=? where CÓDIGO_DO_CLIENTE=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1,"SIM");
                pst.setString(2,motivoCancelamento.getText());
                pst.setString(3,codPeca.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"VENDA CANCELADA COM SUCESSO!");
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codPeca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        motivoCancelamento = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        botApagarItem = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CANCELAR VENDA");
        setResizable(false);
        getContentPane().setLayout(null);

        codPeca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codPecaKeyPressed(evt);
            }
        });
        getContentPane().add(codPeca);
        codPeca.setBounds(20, 130, 230, 30);

        motivoCancelamento.setColumns(20);
        motivoCancelamento.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        motivoCancelamento.setRows(5);
        motivoCancelamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                motivoCancelamentoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(motivoCancelamento);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 210, 400, 190);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("MOTIVO DO CANCELAMENTO");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(20, 180, 240, 17);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CÓDIGO DA VENDA");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(20, 100, 240, 17);

        botApagarItem.setBackground(new java.awt.Color(0, 0, 0));
        botApagarItem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botApagarItem.setForeground(new java.awt.Color(255, 255, 255));
        botApagarItem.setText("CANCELAR");
        botApagarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botApagarItemActionPerformed(evt);
            }
        });
        botApagarItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botApagarItemKeyPressed(evt);
            }
        });
        getContentPane().add(botApagarItem);
        botApagarItem.setBounds(20, 410, 140, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PREENCHA OS CAMPOS");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(30, 10, 520, 60);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 770, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 900, 430);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 50, 570, 530);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-10, 0, 390, 680);

        mostrarNivel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mostrarNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarNivel.setText("5");
        getContentPane().add(mostrarNivel);
        mostrarNivel.setBounds(520, 130, 50, 70);

        acessoUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        acessoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acessoUser.setText("ADMIN");
        getContentPane().add(acessoUser);
        acessoUser.setBounds(520, 220, 70, 60);

        setSize(new java.awt.Dimension(452, 487));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codPecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codPecaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            motivoCancelamento.requestFocus();
        }
    }//GEN-LAST:event_codPecaKeyPressed

    private void botApagarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botApagarItemActionPerformed
        if(codPeca.getText().equals("")||motivoCancelamento.getText().equals("")){
            JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS!");
        }
        else{
            remover();
        }
    }//GEN-LAST:event_botApagarItemActionPerformed

    private void botApagarItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botApagarItemKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(codPeca.getText().equals("")||motivoCancelamento.getText().equals("")){
                JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS!");
            }
            else{
                remover();
            }
        }
    }//GEN-LAST:event_botApagarItemKeyPressed

    private void motivoCancelamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motivoCancelamentoKeyPressed

    }//GEN-LAST:event_motivoCancelamentoKeyPressed

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
            java.util.logging.Logger.getLogger(CancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CancelarVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JButton botApagarItem;
    private javax.swing.JTextField codPeca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel mostrarNivel;
    private javax.swing.JTextArea motivoCancelamento;
    // End of variables declaration//GEN-END:variables
}