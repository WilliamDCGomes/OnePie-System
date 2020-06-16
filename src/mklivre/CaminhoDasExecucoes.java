/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mklivre;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.*;
import controle.ModuloConexao;
import javax.swing.JOptionPane;
/**
 *
 * @author willi
 */
public class CaminhoDasExecucoes extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form CaminhoDasExecucoes
     */
    public CaminhoDasExecucoes() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
    }
    private void consultar(){
        String sqlnome = "select * from exec_of2 where os_aux=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codPeca.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                ExecucoesDosMecanicos usuario = new ExecucoesDosMecanicos();
                usuario.setVisible(true);
                usuario.mostrarNivel.setText(mostrarNivel.getText());
                usuario.acessoUser.setText(acessoUser.getText());
                usuario.campoOS.setText(codPeca.getText());
                usuario.campoServico.setText(rs.getString(2));
                usuario.campoHoraInicial.setText(rs.getString(3));
                usuario.campoHoraFinal.setText(rs.getString(4));
                usuario.campoDuracao.setText(rs.getString(5));
                usuario.campoObs.setText(rs.getString(6));
                usuario.campoTipoDaOs.setText(rs.getString(7));
                usuario.campoMecanico.setText(rs.getString(8));
                usuario.campoData.setText(rs.getString(9));
                usuario.historico.setText(rs.getString(17));
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"EXECUÇÃO NÃO LOCALIZADA NO BANCO DE DADOS!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
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
        jLabel20 = new javax.swing.JLabel();
        botaoEntrarIniciall3 = new javax.swing.JButton();
        botaoEntrarIniciall4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        campoOS = new javax.swing.JTextField();
        campoServico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObs = new javax.swing.JTextArea();
        campoHoraInicial = new javax.swing.JTextField();
        campoHoraFinal = new javax.swing.JTextField();
        campoDuracao = new javax.swing.JTextField();
        campoData = new javax.swing.JTextField();
        campoTipoDaOs = new javax.swing.JTextField();
        campoMecanico = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        historico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOCALIZAR EXECUÇÃO");
        setResizable(false);
        getContentPane().setLayout(null);

        codPeca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codPecaKeyPressed(evt);
            }
        });
        getContentPane().add(codPeca);
        codPeca.setBounds(10, 130, 190, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ORDEM DE SERVIÇO");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(10, 100, 160, 17);

        botaoEntrarIniciall3.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall3.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall3.setText("LOCALIZAR");
        botaoEntrarIniciall3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarIniciall3ActionPerformed(evt);
            }
        });
        botaoEntrarIniciall3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarIniciall3KeyPressed(evt);
            }
        });
        getContentPane().add(botaoEntrarIniciall3);
        botaoEntrarIniciall3.setBounds(10, 190, 190, 40);

        botaoEntrarIniciall4.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall4.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall4.setText("TODAS AS EXECUÇÕES");
        botaoEntrarIniciall4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarIniciall4ActionPerformed(evt);
            }
        });
        botaoEntrarIniciall4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarIniciall4KeyPressed(evt);
            }
        });
        getContentPane().add(botaoEntrarIniciall4);
        botaoEntrarIniciall4.setBounds(210, 190, 240, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("LOCALIZAR EXECUÇOES");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(180, 10, 260, 60);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 550, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 570, 430);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 50, 570, 530);

        acessoUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        acessoUser.setForeground(new java.awt.Color(255, 255, 255));
        acessoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acessoUser.setText("ADMIN");
        getContentPane().add(acessoUser);
        acessoUser.setBounds(290, 190, 70, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-10, 0, 390, 400);

        mostrarNivel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mostrarNivel.setForeground(new java.awt.Color(255, 255, 255));
        mostrarNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarNivel.setText("5");
        getContentPane().add(mostrarNivel);
        mostrarNivel.setBounds(240, 180, 50, 70);

        campoOS.setEditable(false);
        campoOS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoOSKeyPressed(evt);
            }
        });
        getContentPane().add(campoOS);
        campoOS.setBounds(20, 140, 140, 30);

        campoServico.setEditable(false);
        campoServico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoServico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoServicoKeyPressed(evt);
            }
        });
        getContentPane().add(campoServico);
        campoServico.setBounds(250, 140, 150, 30);

        campoObs.setEditable(false);
        campoObs.setColumns(20);
        campoObs.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        campoObs.setRows(5);
        campoObs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoObsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(campoObs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(440, 140, 300, 350);

        campoHoraInicial.setEditable(false);
        campoHoraInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoHoraInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoHoraInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoHoraInicialKeyPressed(evt);
            }
        });
        getContentPane().add(campoHoraInicial);
        campoHoraInicial.setBounds(20, 230, 140, 30);

        campoHoraFinal.setEditable(false);
        campoHoraFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoHoraFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoHoraFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoHoraFinalKeyPressed(evt);
            }
        });
        getContentPane().add(campoHoraFinal);
        campoHoraFinal.setBounds(250, 230, 150, 30);

        campoDuracao.setEditable(false);
        campoDuracao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoDuracao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoDuracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDuracaoKeyPressed(evt);
            }
        });
        getContentPane().add(campoDuracao);
        campoDuracao.setBounds(20, 310, 140, 30);

        campoData.setEditable(false);
        campoData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDataKeyPressed(evt);
            }
        });
        getContentPane().add(campoData);
        campoData.setBounds(250, 310, 150, 30);

        campoTipoDaOs.setEditable(false);
        campoTipoDaOs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoTipoDaOs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTipoDaOs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTipoDaOsKeyPressed(evt);
            }
        });
        getContentPane().add(campoTipoDaOs);
        campoTipoDaOs.setBounds(20, 390, 140, 30);

        campoMecanico.setEditable(false);
        campoMecanico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoMecanico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoMecanico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoMecanicoKeyPressed(evt);
            }
        });
        getContentPane().add(campoMecanico);
        campoMecanico.setBounds(250, 390, 150, 30);

        historico.setEditable(false);
        historico.setColumns(20);
        historico.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        historico.setRows(5);
        historico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                historicoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(historico);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(440, 140, 300, 120);

        setSize(new java.awt.Dimension(472, 283));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codPecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codPecaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(codPeca.getText().equals("")){
                JOptionPane.showMessageDialog(null,"DIGITE UMA ORDEM DE SERVIÇO");
            }
            else{
                consultar();
            } 
        }
    }//GEN-LAST:event_codPecaKeyPressed

    private void botaoEntrarIniciall3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall3ActionPerformed
        if(codPeca.getText().equals("")){
            JOptionPane.showMessageDialog(null,"DIGITE UMA ORDEM DE SERVIÇO");
        }
        else{
            consultar();
        } 
    }//GEN-LAST:event_botaoEntrarIniciall3ActionPerformed

    private void botaoEntrarIniciall3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall3KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(codPeca.getText().equals("")){
                JOptionPane.showMessageDialog(null,"DIGITE UMA ORDEM DE SERVIÇO");
            }
            else{
                consultar();
            } 
        }
    }//GEN-LAST:event_botaoEntrarIniciall3KeyPressed

    private void botaoEntrarIniciall4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall4ActionPerformed
        TodasAsExecucoes tudo = new TodasAsExecucoes();
        tudo.setVisible(true);
        tudo.mostrarNivel.setText(mostrarNivel.getText());
        tudo.acessoUser.setText(acessoUser.getText());
        this.dispose();
    }//GEN-LAST:event_botaoEntrarIniciall4ActionPerformed

    private void botaoEntrarIniciall4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall4KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            TodasAsExecucoes tudo = new TodasAsExecucoes();
            tudo.setVisible(true);
            tudo.mostrarNivel.setText(mostrarNivel.getText());
            tudo.acessoUser.setText(acessoUser.getText());
            this.dispose();
        }
    }//GEN-LAST:event_botaoEntrarIniciall4KeyPressed

    private void campoOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoOSKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoOSKeyPressed

    private void campoServicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoServicoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoServicoKeyPressed

    private void campoObsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoObsKeyPressed

    }//GEN-LAST:event_campoObsKeyPressed

    private void campoHoraInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoHoraInicialKeyPressed

    }//GEN-LAST:event_campoHoraInicialKeyPressed

    private void campoHoraFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoHoraFinalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoHoraFinalKeyPressed

    private void campoDuracaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDuracaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDuracaoKeyPressed

    private void campoDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDataKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataKeyPressed

    private void campoTipoDaOsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTipoDaOsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTipoDaOsKeyPressed

    private void campoMecanicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMecanicoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMecanicoKeyPressed

    private void historicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_historicoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_historicoKeyPressed

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
            java.util.logging.Logger.getLogger(CaminhoDasExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaminhoDasExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaminhoDasExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaminhoDasExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaminhoDasExecucoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JButton botaoEntrarIniciall3;
    private javax.swing.JButton botaoEntrarIniciall4;
    public static javax.swing.JTextField campoData;
    public static javax.swing.JTextField campoDuracao;
    public static javax.swing.JTextField campoHoraFinal;
    public static javax.swing.JTextField campoHoraInicial;
    public static javax.swing.JTextField campoMecanico;
    public static javax.swing.JTextField campoOS;
    public static javax.swing.JTextArea campoObs;
    public static javax.swing.JTextField campoServico;
    public static javax.swing.JTextField campoTipoDaOs;
    private javax.swing.JTextField codPeca;
    public static javax.swing.JTextArea historico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel mostrarNivel;
    // End of variables declaration//GEN-END:variables
}