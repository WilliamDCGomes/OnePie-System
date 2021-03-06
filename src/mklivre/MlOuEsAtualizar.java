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
public class MlOuEsAtualizar extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form MlOuEsAtualizar
     */
    public MlOuEsAtualizar() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
    }
    int nivel;
    String acesso;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        varEs4 = new javax.swing.JLabel();
        varEs3 = new javax.swing.JLabel();
        varML4 = new javax.swing.JLabel();
        varML3 = new javax.swing.JLabel();
        varEs2 = new javax.swing.JLabel();
        varEs1 = new javax.swing.JLabel();
        varML1 = new javax.swing.JLabel();
        varML2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        escolhaEstoque = new javax.swing.JButton();
        escolhaMercado = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        nomePeca = new javax.swing.JTextField();
        custoCadastrado = new javax.swing.JTextField();
        localizacaoCadastrada = new javax.swing.JTextField();
        precoDeVenda = new javax.swing.JTextField();
        codigoCadastrado = new javax.swing.JTextField();
        marcaCadastrada = new javax.swing.JTextField();
        lucroCadastrado = new javax.swing.JTextField();
        caixaLocalizada = new javax.swing.JTextField();
        quantCadastrada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cadastroObservacoes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAMINHO DA ATUALIZAÇÃO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        varEs4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varEs4);
        varEs4.setBounds(140, 270, 120, 30);

        varEs3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varEs3);
        varEs3.setBounds(140, 270, 120, 30);

        varML4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varML4);
        varML4.setBounds(140, 170, 210, 40);

        varML3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varML3);
        varML3.setBounds(140, 170, 210, 40);

        varEs2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varEs2);
        varEs2.setBounds(30, 250, 60, 60);

        varEs1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varEs1);
        varEs1.setBounds(30, 250, 60, 60);

        varML1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varML1);
        varML1.setBounds(30, 160, 60, 60);

        varML2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varML2);
        varML2.setBounds(30, 160, 60, 60);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ESTOQUE");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14);
        jLabel14.setBounds(130, 240, 140, 80);

        escolhaEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ESTOQUE2.png"))); // NOI18N
        escolhaEstoque.setMaximumSize(new java.awt.Dimension(32, 32));
        escolhaEstoque.setMinimumSize(new java.awt.Dimension(32, 32));
        escolhaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolhaEstoqueActionPerformed(evt);
            }
        });
        escolhaEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                escolhaEstoqueKeyPressed(evt);
            }
        });
        getContentPane().add(escolhaEstoque);
        escolhaEstoque.setBounds(30, 250, 60, 58);

        escolhaMercado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MERCADO LIVEW.png"))); // NOI18N
        escolhaMercado.setMaximumSize(new java.awt.Dimension(32, 32));
        escolhaMercado.setMinimumSize(new java.awt.Dimension(32, 32));
        escolhaMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolhaMercadoActionPerformed(evt);
            }
        });
        escolhaMercado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                escolhaMercadoKeyPressed(evt);
            }
        });
        getContentPane().add(escolhaMercado);
        escolhaMercado.setBounds(30, 160, 60, 58);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("MERCADO LIVRE");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(120, 150, 250, 80);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("ESSA PEÇA ESTÁ LOCALIZADA NO:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 80, 400, 60);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ESCOLHA UMA OPÇÃO");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(160, 10, 260, 60);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 450, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 460, 430);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 50, 570, 530);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-30, 0, 390, 400);

        mostrarNivel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mostrarNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarNivel.setText("5");
        getContentPane().add(mostrarNivel);
        mostrarNivel.setBounds(290, 120, 50, 70);

        acessoUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        acessoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acessoUser.setText("ADMIN");
        getContentPane().add(acessoUser);
        acessoUser.setBounds(290, 210, 70, 60);

        nomePeca.setEditable(false);
        nomePeca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomePeca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(nomePeca);
        nomePeca.setBounds(10, 140, 190, 50);

        custoCadastrado.setEditable(false);
        custoCadastrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custoCadastrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(custoCadastrado);
        custoCadastrado.setBounds(10, 250, 190, 50);

        localizacaoCadastrada.setEditable(false);
        localizacaoCadastrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        localizacaoCadastrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(localizacaoCadastrada);
        localizacaoCadastrada.setBounds(10, 360, 190, 50);

        precoDeVenda.setEditable(false);
        precoDeVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precoDeVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(precoDeVenda);
        precoDeVenda.setBounds(240, 250, 140, 50);

        codigoCadastrado.setEditable(false);
        codigoCadastrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codigoCadastrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(codigoCadastrado);
        codigoCadastrado.setBounds(240, 140, 140, 50);

        marcaCadastrada.setEditable(false);
        marcaCadastrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marcaCadastrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(marcaCadastrada);
        marcaCadastrada.setBounds(410, 140, 150, 50);

        lucroCadastrado.setEditable(false);
        lucroCadastrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lucroCadastrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(lucroCadastrado);
        lucroCadastrado.setBounds(410, 250, 150, 50);

        caixaLocalizada.setEditable(false);
        caixaLocalizada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        caixaLocalizada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(caixaLocalizada);
        caixaLocalizada.setBounds(590, 250, 150, 50);

        quantCadastrada.setEditable(false);
        quantCadastrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantCadastrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(quantCadastrada);
        quantCadastrada.setBounds(590, 140, 150, 50);

        cadastroObservacoes.setColumns(20);
        cadastroObservacoes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cadastroObservacoes.setRows(5);
        cadastroObservacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastroObservacoesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(cadastroObservacoes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 350, 500, 230);

        setSize(new java.awt.Dimension(450, 372));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void consultarES(){
        String sqlnome = "select * from tb_pecas_es2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codigoCadastrado.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                EstoqueAtualizarItem usuario = new EstoqueAtualizarItem();
                usuario.setVisible(true);
                usuario.mostrarNivel.setText(mostrarNivel.getText());
                usuario.acessoUser.setText(acessoUser.getText());
                usuario.cadastroNome.setText(rs.getString(1));
                usuario.cadastroCodigo1.setText(rs.getString(2));
                usuario.editarCaixa.setText(rs.getString(3));
                usuario.varCusto.setText(rs.getString(7));
                usuario.varVenda.setText(rs.getString(8));
                usuario.cadastroMarca.setText(rs.getString(5));
                usuario.cadastroQuantidadeDisponivel.setText(rs.getString(6));
                usuario.editarLocalizacao.setText(rs.getString(4));
                usuario.cadastroObservacoes.setText(rs.getString(9));
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"PEÇA NÃO LOCALIZADA NO BANCO DE DADOS DO ESTOQUE!\nTalvez a peça esteja cadastrada no Mercado Livre, procure alguém desse setor para tentar editar o cadastro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void consultarML(){
        String sqlnome = "select * from tb_pecas_ml2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codigoCadastrado.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                AtualizarItemML usuario = new AtualizarItemML();
                usuario.setVisible(true);
                usuario.mostrarNivel.setText(mostrarNivel.getText());
                usuario.acessoUser.setText(acessoUser.getText());
                usuario.cadastroNome.setText(rs.getString(1));
                usuario.codItemML.setText(rs.getString(2));
                usuario.editarPrecoDeCusto.setText(rs.getString(3));
                usuario.editarPrecoDeVenda.setText(rs.getString(4));
                usuario.cadastroMarca.setText(rs.getString(5));
                usuario.quantDisponivel.setText(rs.getString(7));
                usuario.qntMinima.setText(rs.getString(8));
                usuario.qntRecomendada.setText(rs.getString(9));
                usuario.editarPorcentagemML.setText(rs.getString(6));
                usuario.cadastroObservacoes.setText(rs.getString(10));
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"PEÇA NÃO LOCALIZADA NO BANCO DE DADOS DO MERCADO LIVRE!\nTalvez a peça esteja cadastrada no Estoque, procure alguém desse setor para tentar editar o cadastro");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void escolhaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolhaEstoqueActionPerformed
        if(acesso.equals("ML")&&nivel!=5){
            JOptionPane.showMessageDialog(null,"VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
        }
        else{
            consultarES();
        }
    }//GEN-LAST:event_escolhaEstoqueActionPerformed

    private void escolhaMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolhaMercadoActionPerformed
        if(acesso.equals("ES")&&nivel!=5){
            JOptionPane.showMessageDialog(null,"VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
        }
        else{
            consultarML();
        }
    }//GEN-LAST:event_escolhaMercadoActionPerformed

    private void escolhaMercadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_escolhaMercadoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(acesso.equals("ES")&&nivel!=5){
                JOptionPane.showMessageDialog(null,"VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
            }
            else if(evt.getKeyCode() == evt.VK_ENTER){
                consultarML();
            }
        }
    }//GEN-LAST:event_escolhaMercadoKeyPressed

    private void escolhaEstoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_escolhaEstoqueKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(acesso.equals("ML")&&nivel!=5){
                JOptionPane.showMessageDialog(null,"VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
            }
            else{
                consultarES();
            }
        }
    }//GEN-LAST:event_escolhaEstoqueKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        varML1.setVisible(false);
        varML2.setVisible(false);
        varEs1.setVisible(false);
        varEs2.setVisible(false);
        varML3.setVisible(false);
        varML4.setVisible(false);
        varEs3.setVisible(false);
        varEs4.setVisible(false);
        nivel=Integer.parseInt(mostrarNivel.getText());
        acesso=acessoUser.getText();
        if(acesso.equals("ES")&&nivel!=5){
            varML1.setVisible(true);
            varML2.setVisible(true);
            varML3.setVisible(true);
            varML4.setVisible(true);
        }
        else if(acesso.equals("ML")&&nivel!=5){
            varEs1.setVisible(true);
            varEs2.setVisible(true);
            varEs3.setVisible(true);
            varEs4.setVisible(true);
        }
    }//GEN-LAST:event_formWindowActivated

    private void cadastroObservacoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastroObservacoesKeyPressed

    }//GEN-LAST:event_cadastroObservacoesKeyPressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        if(acesso.equals("ML")&&nivel!=5){
            JOptionPane.showMessageDialog(null,"VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
        }
        else{
            consultarES();
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        if(acesso.equals("ES")&&nivel!=5){
            JOptionPane.showMessageDialog(null,"VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
        }
        else{
            consultarML();
        }
    }//GEN-LAST:event_jLabel17MouseClicked

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
            java.util.logging.Logger.getLogger(MlOuEsAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MlOuEsAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MlOuEsAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MlOuEsAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MlOuEsAtualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    public static javax.swing.JTextArea cadastroObservacoes;
    public static javax.swing.JTextField caixaLocalizada;
    public static javax.swing.JTextField codigoCadastrado;
    public static javax.swing.JTextField custoCadastrado;
    private javax.swing.JButton escolhaEstoque;
    private javax.swing.JButton escolhaMercado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField localizacaoCadastrada;
    public static javax.swing.JTextField lucroCadastrado;
    public static javax.swing.JTextField marcaCadastrada;
    public static javax.swing.JLabel mostrarNivel;
    public static javax.swing.JTextField nomePeca;
    public static javax.swing.JTextField precoDeVenda;
    public static javax.swing.JTextField quantCadastrada;
    public javax.swing.JLabel varEs1;
    public javax.swing.JLabel varEs2;
    public javax.swing.JLabel varEs3;
    public javax.swing.JLabel varEs4;
    public javax.swing.JLabel varML1;
    public javax.swing.JLabel varML2;
    public javax.swing.JLabel varML3;
    public javax.swing.JLabel varML4;
    // End of variables declaration//GEN-END:variables
}
