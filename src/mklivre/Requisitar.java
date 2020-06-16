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
public class Requisitar extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form Requisitar
     */
    public Requisitar() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
        txtAUTO.setVisible(false);
    }
    
    private void pegar(){
        String sqlnome = "select * from tb_pecas_ml2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codigoCadastrado.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                requisicao.setText(rs.getString(13));
                quantRequisicao.setText(rs.getString(14));
                txtAuto.setText(rs.getString(17));
                quantRecomendada.setText(rs.getString(9));
                quantAtual.setText(rs.getString(7));
                if(requisicao.getText().equals("NÃO")){
                    msgText.setVisible(false);
                }
                else if(requisicao.getText().equals("SIM")){
                    msgText.setVisible(true);
                }
                if(txtAuto.getText().equals("SIM")){
                    txtAUTO.setVisible(true);
                }
                else if(txtAuto.getText().equals("NÃO")){
                    txtAUTO.setVisible(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void requisitar(){
        String sql = "update tb_pecas_ml2 set REQUISIÇÃO=?, STATUS_DA_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            msgText.setVisible(false);
            pst=conexao.prepareStatement(sql);
            pst.setString(1,"SIM");
            pst.setString(2,"SIM");
            pst.setString(3,codigoCadastrado.getText());
            pst.executeUpdate();
            requisitar2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void requisitar2(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE_DE_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(quantRequisicao.getText())+Integer.parseInt(jSpinner1.getValue().toString()));
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"ITEM REQUISITADO COM SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void auto(){
        String sql = "update tb_pecas_ml2 set REQUISIÇÃO_AUTOMATICA=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,"SIM");
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
            msgText.setVisible(false);
            auto2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void auto2(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE_DE_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(quantRequisicao.getText())+Integer.parseInt(jSpinner1.getValue().toString()));
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
            if(txtAuto.getText().equals("SIM")){
                txtAUTO.setVisible(true);
            }
            else if(txtAuto.getText().equals("NÃO")){
                txtAUTO.setVisible(false);
            }
            JOptionPane.showMessageDialog(null,"REQUISIÇÃO AUTOMATICA LIGADA!");
            if(Integer.parseInt(quantAtual.getText())<Integer.parseInt(quantRecomendada.getText())){
                ativo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void ativo(){
        String sql = "update tb_pecas_ml2 set STATUS_DA_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,"SIM");
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void Dauto(){
        String sql = "update tb_pecas_ml2 set REQUISIÇÃO_AUTOMATICA=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,"NÃO");
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
            msgText.setVisible(false);
            Dauto2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void Dauto2(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE_DE_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1,0);
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
            if(txtAuto.getText().equals("SIM")){
                txtAUTO.setVisible(true);
            }
            else if(txtAuto.getText().equals("NÃO")){
                txtAUTO.setVisible(false);
            }
            JOptionPane.showMessageDialog(null,"REQUISIÇÃO AUTOMATICA DESLIGADA!");
            if(Integer.parseInt(quantAtual.getText())<Integer.parseInt(quantRecomendada.getText())){
                Dativo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void Dativo(){
        String sql = "update tb_pecas_ml2 set STATUS_DA_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,"NÃO");
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    /**}
     * }
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOpc = new javax.swing.ButtonGroup();
        varUm1 = new javax.swing.JLabel();
        varUm2 = new javax.swing.JLabel();
        txtAUTO = new javax.swing.JLabel();
        botSalva = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        botaoEntrarIniciall2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        opcNao = new javax.swing.JRadioButton();
        opcSim = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        msgText = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        codigoCadastrado = new javax.swing.JTextField();
        requisicao = new javax.swing.JLabel();
        quantRequisicao = new javax.swing.JLabel();
        txtAuto = new javax.swing.JLabel();
        quantRecomendada = new javax.swing.JLabel();
        quantAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REQUISIÇÃO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        varUm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varUm1);
        varUm1.setBounds(40, 220, 160, 40);

        varUm2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varUm2);
        varUm2.setBounds(40, 220, 160, 40);

        txtAUTO.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        txtAUTO.setForeground(new java.awt.Color(0, 153, 0));
        txtAUTO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAUTO.setText("(AUTO)");
        getContentPane().add(txtAUTO);
        txtAUTO.setBounds(390, 10, 260, 60);

        botSalva.setBackground(new java.awt.Color(0, 0, 0));
        botSalva.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botSalva.setForeground(new java.awt.Color(255, 255, 255));
        botSalva.setText("SALVAR");
        botSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSalvaActionPerformed(evt);
            }
        });
        botSalva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botSalvaKeyPressed(evt);
            }
        });
        getContentPane().add(botSalva);
        botSalva.setBounds(380, 220, 110, 40);

        jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinner1KeyPressed(evt);
            }
        });
        getContentPane().add(jSpinner1);
        jSpinner1.setBounds(40, 140, 90, 30);

        botaoEntrarIniciall2.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall2.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall2.setText("REQUISITAR");
        botaoEntrarIniciall2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarIniciall2ActionPerformed(evt);
            }
        });
        botaoEntrarIniciall2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarIniciall2KeyPressed(evt);
            }
        });
        getContentPane().add(botaoEntrarIniciall2);
        botaoEntrarIniciall2.setBounds(40, 220, 160, 40);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("REQUISIÇÃO AUTOMATICA");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(380, 110, 400, 20);

        grupoOpc.add(opcNao);
        opcNao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        opcNao.setForeground(new java.awt.Color(255, 255, 255));
        opcNao.setText("NÃO");
        opcNao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                opcNaoKeyPressed(evt);
            }
        });
        getContentPane().add(opcNao);
        opcNao.setBounds(380, 180, 60, 23);

        grupoOpc.add(opcSim);
        opcSim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        opcSim.setForeground(new java.awt.Color(255, 255, 255));
        opcSim.setText("SIM");
        opcSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcSimActionPerformed(evt);
            }
        });
        opcSim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                opcSimKeyPressed(evt);
            }
        });
        getContentPane().add(opcSim);
        opcSim.setBounds(380, 140, 60, 23);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("REQUISIÇÃO DE ITENS");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(220, 10, 260, 60);

        msgText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        msgText.setForeground(new java.awt.Color(255, 0, 0));
        msgText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgText.setText("O ITEM JÁ POSSUI UMA REQUISIÇÃO PENDENTE");
        getContentPane().add(msgText);
        msgText.setBounds(40, 280, 510, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 80);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("QUANTIDADE QUE DESEJA REQUISITAR");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(40, 110, 400, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 680, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 650, 430);

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
        mostrarNivel.setBounds(520, 130, 50, 70);

        acessoUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        acessoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acessoUser.setText("ADMIN");
        getContentPane().add(acessoUser);
        acessoUser.setBounds(520, 220, 70, 60);

        codigoCadastrado.setEditable(false);
        codigoCadastrado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codigoCadastrado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(codigoCadastrado);
        codigoCadastrado.setBounds(240, 140, 140, 50);

        requisicao.setText("resicao");
        getContentPane().add(requisicao);
        requisicao.setBounds(470, 180, 34, 14);

        quantRequisicao.setText("jLabel2");
        getContentPane().add(quantRequisicao);
        quantRequisicao.setBounds(500, 210, 34, 14);

        txtAuto.setText("jLabel2");
        getContentPane().add(txtAuto);
        txtAuto.setBounds(290, 170, 34, 14);

        quantRecomendada.setText("jLabel2");
        getContentPane().add(quantRecomendada);
        quantRecomendada.setBounds(270, 160, 34, 14);

        quantAtual.setText("jLabel2");
        getContentPane().add(quantAtual);
        quantAtual.setBounds(320, 160, 34, 14);

        setSize(new java.awt.Dimension(614, 352));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(txtAuto.getText().equals("SIM")){
                JOptionPane.showMessageDialog(null,"VOCÊ NÃO PODE FAZER UMA REQUISIÇÃO MANUAL ENQUANTO A REQUISIÇÃO AUTOMATICA ESTÁ ATIVA!");
            }  
            else if(txtAuto.getText().equals("NÃO")){
                pegar();
                if(requisicao.getText().equals("SIM")){
                    int confirma = JOptionPane.showConfirmDialog(null, "JÁ EXISTE UMA RESIÇÃO PENDENTE, TEM CERTEZA QUE DESEJA FAZER UMA NOVA?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                    if(confirma==JOptionPane.YES_OPTION){
                        requisitar();
                    }
                }
                else{
                    requisitar();
                } 
            } 
        }
    }//GEN-LAST:event_jSpinner1KeyPressed

    private void botaoEntrarIniciall2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall2ActionPerformed
        if(txtAuto.getText().equals("SIM")){
            JOptionPane.showMessageDialog(null,"VOCÊ NÃO PODE FAZER UMA REQUISIÇÃO MANUAL ENQUANTO A REQUISIÇÃO AUTOMATICA ESTÁ ATIVA!");
        }  
        else if(txtAuto.getText().equals("NÃO")){
            pegar();
            if(requisicao.getText().equals("SIM")){
                int confirma = JOptionPane.showConfirmDialog(null, "JÁ EXISTE UMA RESIÇÃO PENDENTE, TEM CERTEZA QUE DESEJA FAZER UMA NOVA?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                if(confirma==JOptionPane.YES_OPTION){
                    requisitar();
                }
            }
            else{
                requisitar();
            } 
        } 
    }//GEN-LAST:event_botaoEntrarIniciall2ActionPerformed

    private void botaoEntrarIniciall2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall2KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(txtAuto.getText().equals("SIM")){
                JOptionPane.showMessageDialog(null,"VOCÊ NÃO PODE FAZER UMA REQUISIÇÃO MANUAL ENQUANTO A REQUISIÇÃO AUTOMATICA ESTÁ ATIVA!");
            }  
            else if(txtAuto.getText().equals("NÃO")){
                pegar();
                if(requisicao.getText().equals("SIM")){
                    int confirma = JOptionPane.showConfirmDialog(null, "JÁ EXISTE UMA RESIÇÃO PENDENTE, TEM CERTEZA QUE DESEJA FAZER UMA NOVA?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                    if(confirma==JOptionPane.YES_OPTION){
                        requisitar();
                    }
                }
                else{
                    requisitar();
                } 
            } 
        }
    }//GEN-LAST:event_botaoEntrarIniciall2KeyPressed

    private void opcSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcSimActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        pegar();
        if(txtAuto.getText().equals("SIM")){
            varUm1.setVisible(true);
            varUm2.setVisible(true);
        }  
        else if(txtAuto.getText().equals("NÃO")){
            varUm1.setVisible(false);
            varUm2.setVisible(false);
        } 
    }//GEN-LAST:event_formWindowActivated

    private void botSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalvaActionPerformed
        if(opcSim.isSelected()&&requisicao.getText().equals("NÃO")&&txtAuto.getText().equals("NÃO")){
            auto();
        }
        else if(opcNao.isSelected()&&txtAuto.getText().equals("SIM")){
            int confirma = JOptionPane.showConfirmDialog(null, "ATENÇÃO: VOCÊ ESTÁ DESATIVANDO A REQUISIÇÃO AUTOMATICA, CASO TENHA UMA REQUISIÇÃO QUE NÃO FOI ATENDIDA \nELA SERÁ EXCLUIDA, TEM CERTEZA QUE DESEJA CONTINUAR?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
            if(confirma==JOptionPane.YES_OPTION){
                Dauto();
            }
        }
        else if(opcSim.isSelected()&&txtAuto.getText().equals("SIM")){
            JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ ATIVA!");
        }
        else if(opcNao.isSelected()&&txtAuto.getText().equals("NÃO")){
            JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ DESATIVA!");
        }
        else{
             JOptionPane.showMessageDialog(null,"EXISTE UMA REQUISIÇÃO EM ABERTO, SOLICITE AO ENCARREGADO DO ESTOQUE A EXCLUSÃO DA REQUISIÇÃO\nOU AGUARDE ELA SER ATENDIDA PARA ATIVAR A REQUISIÇÃO AUTOMATICA");
             msgText.setVisible(true);
        }
    }//GEN-LAST:event_botSalvaActionPerformed

    private void botSalvaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botSalvaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(opcSim.isSelected()&&requisicao.getText().equals("NÃO")&&txtAuto.getText().equals("NÃO")){
                auto();
            }
            else if(opcNao.isSelected()&&txtAuto.getText().equals("SIM")){
                int confirma = JOptionPane.showConfirmDialog(null, "ATENÇÃO: VOCÊ ESTÁ DESATIVANDO A REQUISIÇÃO AUTOMATICA, CASO TENHA UMA REQUISIÇÃO QUE NÃO FOI ATENDIDA \nELA SERÁ EXCLUIDA, TEM CERTEZA QUE DESEJA CONTINUAR?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                if(confirma==JOptionPane.YES_OPTION){
                    Dauto();
                }
            }
            else if(opcSim.isSelected()&&txtAuto.getText().equals("SIM")){
                JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ ATIVA!");
            }
            else if(opcNao.isSelected()&&txtAuto.getText().equals("NÃO")){
                JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ DESATIVA!");
            }
            else{
                JOptionPane.showMessageDialog(null,"EXISTE UMA REQUISIÇÃO EM ABERTO, SOLICITE AO ENCARREGADO DO ESTOQUE A EXCLUSÃO DA REQUISIÇÃO\nOU AGUARDE ELA SER ATENDIDA PARA ATIVAR A REQUISIÇÃO AUTOMATICA");
                msgText.setVisible(true);
            }
        }
    }//GEN-LAST:event_botSalvaKeyPressed

    private void opcSimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_opcSimKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(opcSim.isSelected()&&requisicao.getText().equals("NÃO")&&txtAuto.getText().equals("NÃO")){
                auto();
            }
            else if(opcNao.isSelected()&&txtAuto.getText().equals("SIM")){
                int confirma = JOptionPane.showConfirmDialog(null, "ATENÇÃO: VOCÊ ESTÁ DESATIVANDO A REQUISIÇÃO AUTOMATICA, CASO TENHA UMA REQUISIÇÃO QUE NÃO FOI ATENDIDA \nELA SERÁ EXCLUIDA, TEM CERTEZA QUE DESEJA CONTINUAR?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                if(confirma==JOptionPane.YES_OPTION){
                    Dauto();
                }
            }
            else if(opcSim.isSelected()&&txtAuto.getText().equals("SIM")){
                JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ ATIVA!");
            }
            else if(opcNao.isSelected()&&txtAuto.getText().equals("NÃO")){
                JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ DESATIVA!");
            }
            else{
                JOptionPane.showMessageDialog(null,"EXISTE UMA REQUISIÇÃO EM ABERTO, SOLICITE AO ENCARREGADO DO ESTOQUE A EXCLUSÃO DA REQUISIÇÃO\nOU AGUARDE ELA SER ATENDIDA PARA ATIVAR A REQUISIÇÃO AUTOMATICA");
                msgText.setVisible(true);
            }
        }
    }//GEN-LAST:event_opcSimKeyPressed

    private void opcNaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_opcNaoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(opcSim.isSelected()&&requisicao.getText().equals("NÃO")&&txtAuto.getText().equals("NÃO")){
                auto();
            }
            else if(opcNao.isSelected()&&txtAuto.getText().equals("SIM")){
                int confirma = JOptionPane.showConfirmDialog(null, "ATENÇÃO: VOCÊ ESTÁ DESATIVANDO A REQUISIÇÃO AUTOMATICA, CASO TENHA UMA REQUISIÇÃO QUE NÃO FOI ATENDIDA \nELA SERÁ EXCLUIDA, TEM CERTEZA QUE DESEJA CONTINUAR?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                if(confirma==JOptionPane.YES_OPTION){
                    Dauto();
                }
            }
            else if(opcSim.isSelected()&&txtAuto.getText().equals("SIM")){
                JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ ATIVA!");
            }
            else if(opcNao.isSelected()&&txtAuto.getText().equals("NÃO")){
                JOptionPane.showMessageDialog(null,"A REQUISIÇÃO AUTOMATICA JÁ ESTÁ DESATIVA!");
            }
            else{
                JOptionPane.showMessageDialog(null,"EXISTE UMA REQUISIÇÃO EM ABERTO, SOLICITE AO ENCARREGADO DO ESTOQUE A EXCLUSÃO DA REQUISIÇÃO\nOU AGUARDE ELA SER ATENDIDA PARA ATIVAR A REQUISIÇÃO AUTOMATICA");
                msgText.setVisible(true);
            }
        }
    }//GEN-LAST:event_opcNaoKeyPressed

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
            java.util.logging.Logger.getLogger(Requisitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Requisitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Requisitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Requisitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requisitar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JButton botSalva;
    private javax.swing.JButton botaoEntrarIniciall2;
    public static javax.swing.JTextField codigoCadastrado;
    private javax.swing.ButtonGroup grupoOpc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner jSpinner1;
    public static javax.swing.JLabel mostrarNivel;
    private javax.swing.JLabel msgText;
    public static javax.swing.JRadioButton opcNao;
    public static javax.swing.JRadioButton opcSim;
    private javax.swing.JLabel quantAtual;
    private javax.swing.JLabel quantRecomendada;
    private javax.swing.JLabel quantRequisicao;
    private javax.swing.JLabel requisicao;
    private javax.swing.JLabel txtAUTO;
    private javax.swing.JLabel txtAuto;
    public javax.swing.JLabel varUm1;
    public javax.swing.JLabel varUm2;
    // End of variables declaration//GEN-END:variables
}
