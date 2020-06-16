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
public class MaisVendidos extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form MaisVendidos
     */
    public MaisVendidos() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
        varUm1.setVisible(false);
        varUm2.setVisible(false);
        varUm3.setVisible(false);
        varUm4.setVisible(false);
        varApagar1.setVisible(false);
        varApagar2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        varApagar1 = new javax.swing.JLabel();
        varApagar2 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        campoMecanicos = new javax.swing.JComboBox<>();
        varUm3 = new javax.swing.JLabel();
        varUm4 = new javax.swing.JLabel();
        varUm1 = new javax.swing.JLabel();
        varUm2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        baixar = new javax.swing.JButton();
        mostrar = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDePecas = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        codigoCadastrado = new javax.swing.JLabel();
        quantCadastrada = new javax.swing.JLabel();
        quantMinimo = new javax.swing.JLabel();
        requisicaoAutomatica = new javax.swing.JLabel();
        quantRecomendada = new javax.swing.JLabel();
        aguardando = new javax.swing.JLabel();
        chegar = new javax.swing.JLabel();
        automatico = new javax.swing.JLabel();
        osPega = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        auto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ITENS AGUARDANDO CHEGADA");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        varApagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varApagar1);
        varApagar1.setBounds(475, 490, 180, 40);

        varApagar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varApagar2);
        varApagar2.setBounds(475, 490, 180, 40);

        cancelar.setBackground(new java.awt.Color(0, 0, 0));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("DESCONTINUAR");
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
        cancelar.setBounds(475, 490, 180, 40);

        campoMecanicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODAS" }));
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
        campoMecanicos.setBounds(15, 490, 160, 40);

        varUm3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varUm3);
        varUm3.setBounds(310, 490, 150, 40);

        varUm4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varUm4);
        varUm4.setBounds(310, 490, 150, 40);

        varUm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varUm1);
        varUm1.setBounds(200, 490, 90, 40);

        varUm2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(varUm2);
        varUm2.setBounds(200, 490, 90, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 80);

        baixar.setBackground(new java.awt.Color(0, 0, 0));
        baixar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        baixar.setForeground(new java.awt.Color(255, 255, 255));
        baixar.setText("ADICIONAR");
        baixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baixarActionPerformed(evt);
            }
        });
        baixar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                baixarKeyPressed(evt);
            }
        });
        getContentPane().add(baixar);
        baixar.setBounds(310, 490, 150, 40);

        mostrar.setBackground(new java.awt.Color(0, 0, 0));
        mostrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mostrar.setForeground(new java.awt.Color(255, 255, 255));
        mostrar.setText("MOSTRAR");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });
        mostrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mostrarKeyPressed(evt);
            }
        });
        getContentPane().add(mostrar);
        mostrar.setBounds(670, 490, 130, 40);

        jSpinner1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinner1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jSpinner1CaretPositionChanged(evt);
            }
        });
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinner1KeyPressed(evt);
            }
        });
        getContentPane().add(jSpinner1);
        jSpinner1.setBounds(200, 496, 90, 30);

        tabelaDePecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CÓDIGO", "CAIXA", "LOCALIZAÇÃO", "MARCA", "QUANTIDADE"
            }
        ));
        jScrollPane2.setViewportView(tabelaDePecas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(-5, 85, 820, 395);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ITENS AGUARDANDO CHEGADA");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(310, 10, 340, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 820, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 820, 430);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(310, 20, 570, 550);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-10, 40, 570, 530);

        acessoUser.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        acessoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acessoUser.setText("ADMIN");
        getContentPane().add(acessoUser);
        acessoUser.setBounds(520, 220, 70, 60);

        mostrarNivel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mostrarNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarNivel.setText("5");
        getContentPane().add(mostrarNivel);
        mostrarNivel.setBounds(520, 130, 50, 70);

        codigoCadastrado.setText("jLabel2");
        getContentPane().add(codigoCadastrado);
        codigoCadastrado.setBounds(500, 230, 34, 14);

        quantCadastrada.setText("jLabel2");
        getContentPane().add(quantCadastrada);
        quantCadastrada.setBounds(580, 230, 34, 14);

        quantMinimo.setText("jLabel3");
        getContentPane().add(quantMinimo);
        quantMinimo.setBounds(670, 230, 34, 14);

        requisicaoAutomatica.setText("jLabel4");
        getContentPane().add(requisicaoAutomatica);
        requisicaoAutomatica.setBounds(620, 170, 34, 14);

        quantRecomendada.setText("jLabel5");
        getContentPane().add(quantRecomendada);
        quantRecomendada.setBounds(670, 310, 34, 14);

        aguardando.setText("jLabel7");
        getContentPane().add(aguardando);
        aguardando.setBounds(540, 310, 34, 14);

        chegar.setText("jLabel8");
        getContentPane().add(chegar);
        chegar.setBounds(460, 170, 34, 14);

        automatico.setText("jLabel2");
        getContentPane().add(automatico);
        automatico.setBounds(650, 140, 34, 14);

        osPega.setText("jLabel2");
        getContentPane().add(osPega);
        osPega.setBounds(490, 180, 34, 14);

        codigo.setText("jLabel2");
        getContentPane().add(codigo);
        codigo.setBounds(420, 170, 34, 14);

        auto.setText("jLabel2");
        getContentPane().add(auto);
        auto.setBounds(530, 190, 34, 14);

        setSize(new java.awt.Dimension(817, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int a,mudar=0,nivel;
    String acesso;
    public void setar(){
        int setar=tabelaDePecas.getSelectedRow();
        TodosOsItensCadastrados todos = new TodosOsItensCadastrados();
        todos.setVisible(true);
        todos.codigoCadastrado.setText(tabelaDePecas.getModel().getValueAt(setar,0).toString());
        todos.nomePeca.setText(tabelaDePecas.getModel().getValueAt(setar,1).toString());
        todos.marcaCadastrada.setText(tabelaDePecas.getModel().getValueAt(setar,2).toString());
        todos.quantCadastrada.setText(tabelaDePecas.getModel().getValueAt(setar,3).toString());
        todos.vindoDoEspera.setText("1");
        todos.mostrarNivel.setText(mostrarNivel.getText());
        todos.acessoUser.setText(acessoUser.getText());
    }
    public void pupolaJComboBox(){
        String sql ="select * from tb_pecas_ml2 where AGUARDANDO_PEÇAS=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "SIM");
            rs=pst.executeQuery();
            while(rs.next()){
                campoMecanicos.addItem(rs.getString("MARCA"));
            }
            comboboxML();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void comboboxML(){
        int quant=campoMecanicos.getItemCount();
        int valida=0;//1=NÃO E 2=SIM    
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
    private void pesquisarOS(){
        String sql = "select CÓDIGO,NOME,MARCA,QUANTIDADE,QUANTIDADE_PENDENTE from tb_pecas_ml2 where MARCA =? and AGUARDANDO_PEÇAS=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,campoMecanicos.getSelectedItem().toString());
            pst.setString(2, "SIM");
            rs=pst.executeQuery();
            tabelaDePecas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void pesquisar(){
        String sql = "select CÓDIGO,NOME,MARCA,QUANTIDADE,QUANTIDADE_PENDENTE from tb_pecas_ml2 where AGUARDANDO_PEÇAS=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "SIM");
            rs=pst.executeQuery();
            tabelaDePecas.setModel(DbUtils.resultSetToTableModel(rs));
            mudar=1;
            campoMecanicos.removeAllItems();
            campoMecanicos.addItem("TODAS");
            pupolaJComboBox();
            mudar=0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void setarES(){
        int setar=tabelaDePecas.getSelectedRow();
        codigoCadastrado.setText(tabelaDePecas.getModel().getValueAt(setar,0).toString());
    }
    private void pegar(){
        String sqlnome = "select * from tb_pecas_ml2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codigoCadastrado.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                quantCadastrada.setText(rs.getString(7));
                quantMinimo.setText(rs.getString(8));
                quantRecomendada.setText(rs.getString(9));
                requisicaoAutomatica.setText(rs.getString(17));
                aguardando.setText(rs.getString(19));
                chegar.setText(rs.getString(20));
                a=Integer.parseInt(quantCadastrada.getText())+Integer.parseInt(jSpinner1.getValue().toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"");
        }
    }
    public void descontinuar1(){
        int setar=tabelaDePecas.getSelectedRow();
        codigo.setText(tabelaDePecas.getModel().getValueAt(setar,0).toString());
        descontinuar2();
    }
    public void descontinuar2(){
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
        int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA DESCONTINUAR ESSE PEDIDO?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION){
            String sql = "update tb_pecas_ml2 set AGUARDANDO_PEÇAS=?, QUANTIDADE_PENDENTE=?,OS=? where CÓDIGO=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1,"NÃO");
                pst.setInt(2,0);
                pst.setString(3,null);
                pst.setString(4,codigo.getText());
                pst.executeUpdate();
                if(auto.getText().equals("NÃO")){
                    cancelar2();
                }
                else{
                    JOptionPane.showMessageDialog(null,"PEDIDO DO ITEM DESCONTINUADO COM SUCESSO");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
    private void cancelar2(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE_DE_REQUISIÇÃO=?,REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1,0);
            pst.setString(2,"NÃO");
            pst.setString(3,codigo.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"PEDIDO DO ITEM DESCONTINUADO COM SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void chegou(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE=?,AGUARDANDO_PEÇAS=?,QUANTIDADE_PENDENTE=?,REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1,a);
            if(Integer.parseInt(jSpinner1.getValue().toString())>=Integer.parseInt(chegar.getText())){
                pst.setString(2,"NÃO");
                pst.setString(4,"NÃO");
                pst.setInt(3,0);
            }
            else{
                pst.setString(2,"SIM");
                pst.setString(4,"SIM");
                pst.setInt(3,Integer.parseInt(chegar.getText())-Integer.parseInt(jSpinner1.getValue().toString()));
            }
            pst.setString(5,codigoCadastrado.getText());
            pst.executeUpdate();
            pegar2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void pegar2(){
        String sqlnome = "select * from tb_pecas_ml2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codigoCadastrado.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                automatico.setText(rs.getString(17));
                if(automatico.getText().equals("NÃO")){
                    upD();
                }
                else{
                    JOptionPane.showMessageDialog(null,"O ITEM FOI MARCADO COMO RECEBIDO NO ESTOQUE COM SUCESSO");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void upD(){
        String sql = "update tb_pecas_ml2 set QUANTIDADE_DE_REQUISIÇÃO=? where CÓDIGO=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1,0);
            pst.setString(2,codigoCadastrado.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"O ITEM FOI MARCADO COMO RECEBIDO NO ESTOQUE COM SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        nivel = Integer.parseInt(mostrarNivel.getText());
        acesso = acessoUser.getText();
        pesquisar();
        if(acessoUser.getText().equals("ML")&&Integer.parseInt(mostrarNivel.getText())<5){
            varUm1.setVisible(true);
            varUm2.setVisible(true);
            varUm3.setVisible(true);
            varUm4.setVisible(true);
            varApagar1.setVisible(true);
            varApagar2.setVisible(true);
        }
        if(nivel<4){
            varApagar1.setVisible(true);
            varApagar2.setVisible(true);
        }
    }//GEN-LAST:event_formWindowActivated

    private void baixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baixarActionPerformed
        if(acessoUser.getText().equals("ML")&&Integer.parseInt(mostrarNivel.getText())<5){
            JOptionPane.showMessageDialog(null,"APENAS O ESTOQUE OU ALGUÉM COM NÍVEL DE ACESSO 5 PODE MARCAR O ITEM COMO RECEBIDO NA MADRI");
        }
        else{
            int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA ADICIONAR ESSA QUANTIDADE COMO ENTREGUE NA MADRI?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
            if(confirma==JOptionPane.YES_OPTION){
                setarES();
                pegar();
                chegou();
            }
        }
    }//GEN-LAST:event_baixarActionPerformed

    private void baixarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_baixarKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(acessoUser.getText().equals("ML")&&Integer.parseInt(mostrarNivel.getText())<5){
                JOptionPane.showMessageDialog(null,"APENAS O ESTOQUE OU ALGUÉM COM NÍVEL DE ACESSO 5 PODE MARCAR O ITEM COMO RECEBIDO NA MADRI");
            }
            else{
                int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA ADICIONAR ESSA QUANTIDADE COMO ENTREGUE NA MADRI?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                if(confirma==JOptionPane.YES_OPTION){
                    setarES();
                    pegar();
                    chegou();
                }
            }
        }
    }//GEN-LAST:event_baixarKeyPressed

    private void jSpinner1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSpinner1CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1CaretPositionChanged

    private void jSpinner1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(acessoUser.getText().equals("ML")&&Integer.parseInt(mostrarNivel.getText())<5){
                JOptionPane.showMessageDialog(null,"APENAS O ESTOQUE PODE MARCAR O ITEM COMO RECEBIDO NA MADRI");
            }
            else{
                setarES();
                pegar();
                chegou();
            }
        }
    }//GEN-LAST:event_jSpinner1KeyPressed

    private void campoMecanicosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoMecanicosItemStateChanged
        if(mudar==0){
            if(campoMecanicos.getSelectedItem().toString().equals("TODOS")){
                pesquisar();
            }
            else{
                pesquisarOS();
            }
        }
    }//GEN-LAST:event_campoMecanicosItemStateChanged

    private void campoMecanicosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMecanicosKeyPressed
        if(mudar==0){
            if(campoMecanicos.getSelectedItem().toString().equals("TODOS")){
                pesquisar();
            }
            else{
                pesquisarOS();
            }
        }
    }//GEN-LAST:event_campoMecanicosKeyPressed

    private void mostrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mostrarKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            setar();
        }
    }//GEN-LAST:event_mostrarKeyPressed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        setar();
    }//GEN-LAST:event_mostrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        if(acessoUser.getText().equals("ML")&&Integer.parseInt(mostrarNivel.getText())<5){
            JOptionPane.showMessageDialog(null,"APENAS O ESTOQUE OU ALGUÉM COM NÍVEL DE ACESSO 5 PODE DESCONTINUAR O PEDIDO");
        }
        else if(nivel<4){
            JOptionPane.showMessageDialog(null,"APENAS USUÁRIOS COM NÍVEL 4 OU 5 PODEM DESCONTINUAR UM PEDIDO");
        }
        else{
            descontinuar1();
            cancelar();
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelarKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(acessoUser.getText().equals("ML")&&Integer.parseInt(mostrarNivel.getText())<5){
                JOptionPane.showMessageDialog(null,"APENAS O ESTOQUE OU ALGUÉM COM NÍVEL DE ACESSO 5 PODE DESCONTINUAR O PEDIDO");
            }
            else if(nivel<4){
                JOptionPane.showMessageDialog(null,"APENAS USUÁRIOS COM NÍVEL 4 OU 5 PODEM DESCONTINUAR UM PEDIDO");
            }
            else{
                descontinuar1();
                cancelar();
            }
        }
    }//GEN-LAST:event_cancelarKeyPressed

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
            java.util.logging.Logger.getLogger(MaisVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaisVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaisVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaisVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaisVendidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JLabel aguardando;
    private javax.swing.JLabel auto;
    private javax.swing.JLabel automatico;
    private javax.swing.JButton baixar;
    private javax.swing.JComboBox<String> campoMecanicos;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel chegar;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel codigoCadastrado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton mostrar;
    public static javax.swing.JLabel mostrarNivel;
    private javax.swing.JLabel osPega;
    private javax.swing.JLabel quantCadastrada;
    private javax.swing.JLabel quantMinimo;
    private javax.swing.JLabel quantRecomendada;
    private javax.swing.JLabel requisicaoAutomatica;
    private javax.swing.JTable tabelaDePecas;
    public javax.swing.JLabel varApagar1;
    public javax.swing.JLabel varApagar2;
    public javax.swing.JLabel varUm1;
    public javax.swing.JLabel varUm2;
    public javax.swing.JLabel varUm3;
    public javax.swing.JLabel varUm4;
    // End of variables declaration//GEN-END:variables
}