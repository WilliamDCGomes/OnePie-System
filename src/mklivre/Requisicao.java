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
import net.proteanit.sql.DbUtils;
/**
 *
 * @author willi
 */
public class Requisicao extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conexao2 = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
    /**
     * Creates new form Requisicao
     */
    public Requisicao() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        varRequisitar1.setVisible(false);
        varRequisitar2.setVisible(false);
        varApagar1.setVisible(false);
        varApagar2.setVisible(false);
        conexao = ModuloConexao.conector();
    }
    int nivel;
    String acesso;
    public void setar(){
        int setar=tabelaRequisicao.getSelectedRow();
        codigo.setText(tabelaRequisicao.getModel().getValueAt(setar,0).toString());
        aguardando();
    }
    public void pegar(){
        int setar=tabelaRequisicao.getSelectedRow();
        codigo.setText(tabelaRequisicao.getModel().getValueAt(setar,0).toString());
        pegar2();
    }
    public void pegar2(){
        String sqlnome = "select * from tb_pecas_ml2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codigo.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                auto.setText(rs.getString("REQUISIÇÃO_AUTOMATICA"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void cancelar(){
        int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA APAGAR ESSA REQUISIÇÃO?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION){
            String sql = "update tb_pecas_ml2 set REQUISIÇÃO=?, STATUS_DA_REQUISIÇÃO=? where CÓDIGO=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1,"NÃO");
                pst.setString(2,"NÃO");
                pst.setString(3,codigo.getText());
                pst.executeUpdate();
                if(auto.getText().equals("NÃO")){
                    cancelar2();
                }
                else{
                    JOptionPane.showMessageDialog(null,"CANCELADO A REQUISIÇÃO DO ITEM COM SUCESSO");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
    private void cancelar2(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE_DE_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1,0);
            pst.setString(2,codigo.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"CANCELADO A REQUISIÇÃO DO ITEM COM SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void aguardando(){
        String sql = "update tb_pecas_ml2 set AGUARDANDO_PEÇAS=?,STATUS_DA_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, "SIM");
            pst.setString(2, "NÃO");
            pst.setString(3, codigo.getText());
            pst.executeUpdate();
            p2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    int mudar=0;
    private void pesquisarMarca(){
        String sql = "select CÓDIGO,NOME,MARCA,QUANTIDADE_DE_REQUISIÇÃO,REQUISIÇÃO_AUTOMATICA from tb_pecas_ml2 where (STATUS_DA_REQUISIÇÃO =? and ((REQUISIÇÃO_AUTOMATICA = ? and AGUARDANDO_PEÇAS = ?)or REQUISIÇÃO=?))and MARCA=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "SIM");
            pst.setString(2, "SIM");
            pst.setString(3, "NÃO");
            pst.setString(4, "SIM");
            pst.setString(5, campoMecanicos.getSelectedItem().toString());
            rs=pst.executeQuery();
            tabelaRequisicao.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void pesquisar(){
        String sql = "select CÓDIGO,NOME,MARCA,QUANTIDADE_DE_REQUISIÇÃO,REQUISIÇÃO_AUTOMATICA from tb_pecas_ml2 where STATUS_DA_REQUISIÇÃO =? and ((REQUISIÇÃO_AUTOMATICA = ? and AGUARDANDO_PEÇAS = ?)or REQUISIÇÃO=?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "SIM");
            pst.setString(2, "SIM");
            pst.setString(3, "NÃO");
            pst.setString(4, "SIM");
            rs=pst.executeQuery();
            tabelaRequisicao.setModel(DbUtils.resultSetToTableModel(rs));
            mudar=1;
            campoMecanicos.removeAllItems();
            campoMecanicos.addItem("TODOS");
            pupolaJComboBox();
            mudar=0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void pupolaJComboBox(){
        String sql ="select * from tb_pecas_ml2 where STATUS_DA_REQUISIÇÃO =? and ((REQUISIÇÃO_AUTOMATICA = ? and AGUARDANDO_PEÇAS = ?)or REQUISIÇÃO=?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "SIM");
            pst.setString(2, "SIM");
            pst.setString(3, "NÃO");
            pst.setString(4, "SIM");
            rs=pst.executeQuery();
            while(rs.next()){
                campoMecanicos.addItem(rs.getString("MARCA"));
            }
            combobox();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void combobox(){
        int quant=campoMecanicos.getItemCount();
        int valida=0;  
        String aux[]=new String[quant];
        for(int x=0;x<quant;x++){
            aux[x]=null;
        }
        int comp=1;
        while(quant>comp){
            for(int x=0;x<quant;x++){
                if(campoMecanicos.getItemAt(comp).equals(aux[x])){
                    valida=1;
                    break;
                }
            }
            if(valida==0){
                for(int x=0;x<quant;x++){
                    if(aux[x]==null){
                       aux[x]=campoMecanicos.getItemAt(comp);
                        break;
                    }
                }
            }
            valida=0;
            comp++;
        }
        mudar=1;
        campoMecanicos.removeAllItems();
        campoMecanicos.addItem("TODOS");
        for (int x=0;x<quant;x++){
            if(aux[x]!=null){
                campoMecanicos.addItem(aux[x]);
            }
        }
        mudar=0;
    }
    private void p2(){
        String sql = "select * from tb_pecas_ml2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, codigo.getText());
            rs=pst.executeQuery();
            if (rs.next()) {
                qnt_chegou.setText(rs.getString(14));
                aguardando2();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void aguardando2(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE_PENDENTE=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(qnt_chegou.getText()));
            pst.setString(2, codigo.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"PEÇA MARCADA COMO REQUISATA COM SUCESSO");
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

        varApagar2 = new javax.swing.JLabel();
        varApagar1 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        varRequisitar2 = new javax.swing.JLabel();
        varRequisitar1 = new javax.swing.JLabel();
        campoMecanicos = new javax.swing.JComboBox<>();
        botaoEntrarIniciall4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaRequisicao = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        qnt_chegou = new javax.swing.JLabel();
        auto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ITENS EM FALTA");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        varApagar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varApagar2);
        varApagar2.setBounds(210, 500, 170, 40);

        varApagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varApagar1);
        varApagar1.setBounds(210, 500, 170, 40);

        cancelar.setBackground(new java.awt.Color(0, 0, 0));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelarKeyPressed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(210, 500, 170, 40);

        varRequisitar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varRequisitar2);
        varRequisitar2.setBounds(10, 500, 170, 40);

        varRequisitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varRequisitar1);
        varRequisitar1.setBounds(10, 500, 170, 40);

        campoMecanicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));
        campoMecanicos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoMecanicosItemStateChanged(evt);
            }
        });
        campoMecanicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoMecanicosKeyPressed(evt);
            }
        });
        getContentPane().add(campoMecanicos);
        campoMecanicos.setBounds(530, 500, 160, 40);

        botaoEntrarIniciall4.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall4.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall4.setText("REQUISITADA");
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
        botaoEntrarIniciall4.setBounds(10, 500, 170, 40);

        tabelaRequisicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "MARCA", "QUANTIDADE"
            }
        ));
        jScrollPane2.setViewportView(tabelaRequisicao);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(-5, 85, 720, 402);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PEÇAS EM FALTA");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(310, 10, 210, 60);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 720, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 760, 430);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 50, 570, 530);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-30, 0, 410, 570);

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

        codigo.setText("jLabel2");
        getContentPane().add(codigo);
        codigo.setBounds(230, 270, 34, 15);

        qnt_chegou.setText("jLabel2");
        getContentPane().add(qnt_chegou);
        qnt_chegou.setBounds(320, 200, 34, 15);

        auto.setText("jLabel2");
        getContentPane().add(auto);
        auto.setBounds(320, 270, 34, 15);

        setSize(new java.awt.Dimension(715, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarIniciall4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall4ActionPerformed
        if(nivel<4||(nivel!=5&&acesso.equals("ML"))){
            JOptionPane.showMessageDialog(null, "VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
        }
        else{
            int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA MARCAR ESSAS PEÇAS COMO PEDIDAS?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
            if(confirma==JOptionPane.YES_OPTION){
                setar();
            }
        }
    }//GEN-LAST:event_botaoEntrarIniciall4ActionPerformed

    private void botaoEntrarIniciall4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall4KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(nivel<4||(nivel!=5&&acesso.equals("ML"))){
                JOptionPane.showMessageDialog(null, "VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
            }
            else{
                int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA MARCAR ESSAS PEÇAS COMO PEDIDAS?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                if(confirma==JOptionPane.YES_OPTION){
                    setar();
                }
            }
        }
    }//GEN-LAST:event_botaoEntrarIniciall4KeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        nivel = Integer.parseInt(mostrarNivel.getText());
        acesso = acessoUser.getText();
        if(nivel<4||(nivel!=5&&acesso.equals("ML"))){
            varRequisitar1.setVisible(true);
            varRequisitar2.setVisible(true);
            varApagar1.setVisible(true);
            varApagar2.setVisible(true);
        }
        if(mudar==0){
            if(campoMecanicos.getSelectedItem().toString().equals("TODOS")){
                pesquisar();
            }
            else{
                pesquisarMarca();
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        if(nivel<4||(nivel!=5&&acesso.equals("ML"))){
            JOptionPane.showMessageDialog(null, "VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
        }
        else{
            pegar();
            cancelar();
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelarKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(nivel<4||(nivel!=5&&acesso.equals("ML"))){
                JOptionPane.showMessageDialog(null, "VOCÊ NÃO TEM ACESSO A ESSE MÓDULO!");
            }
            else{
                pegar();
                cancelar();
            }
        }
    }//GEN-LAST:event_cancelarKeyPressed

    private void campoMecanicosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoMecanicosItemStateChanged
        if(mudar==0){
            if(campoMecanicos.getSelectedItem().toString().equals("TODOS")){
                pesquisar();
            }
            else{
                pesquisarMarca();
            }
        }
    }//GEN-LAST:event_campoMecanicosItemStateChanged

    private void campoMecanicosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMecanicosKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(mudar==0){
                if(campoMecanicos.getSelectedItem().toString().equals("TODOS")){
                    pesquisar();
                }
                else{
                    pesquisarMarca();
                }
            }
        }
    }//GEN-LAST:event_campoMecanicosKeyPressed

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
            java.util.logging.Logger.getLogger(Requisicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Requisicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Requisicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Requisicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requisicao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JLabel auto;
    private javax.swing.JButton botaoEntrarIniciall4;
    private javax.swing.JComboBox<String> campoMecanicos;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel mostrarNivel;
    private javax.swing.JLabel qnt_chegou;
    private javax.swing.JTable tabelaRequisicao;
    public javax.swing.JLabel varApagar1;
    public javax.swing.JLabel varApagar2;
    public javax.swing.JLabel varRequisitar1;
    public javax.swing.JLabel varRequisitar2;
    // End of variables declaration//GEN-END:variables
}
