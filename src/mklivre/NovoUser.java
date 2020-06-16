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
public class NovoUser extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form NovoUser
     */
    public NovoUser() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
        
    }
    
    
    private void adicionar(){
        String sql = "insert into tbusuarios2(NOME,SENHA,NIVEL,ACESSO_PERMITIDO,SEXO) values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,cadastroNome.getText());
            pst.setString(2,senhaDoUser.getText());
            if(escolhaSexo1.isSelected()){
                pst.setString(5,"MASCULINO");
            }
            else if(escolhaSexo2.isSelected()){
                pst.setString(5,"FEMININO");
            }
            if(localAtendimento.isSelected()&&localML.isSelected()&&localEs.isSelected()&&localOficina.isSelected()){
                pst.setString(4,"AT E ML E ES E OF");
            }
            else if(localAtendimento.isSelected()&&localML.isSelected()&&localEs.isSelected()){
                pst.setString(4,"AT E ML E ES");
            }
            else if(localAtendimento.isSelected()&&localML.isSelected()&&localOficina.isSelected()){
                pst.setString(4,"AT E ML E OF");
            }
            else if(localAtendimento.isSelected()&&localEs.isSelected()&&localOficina.isSelected()){
                pst.setString(4,"AT E ES E OF");
            }
            else if(localML.isSelected()&&localEs.isSelected()&&localOficina.isSelected()){
                pst.setString(4,"ML E ES E OF");
            }
            else if(localAtendimento.isSelected()&&localOficina.isSelected()){
                pst.setString(4,"AT E OF");
            }
            else if(localAtendimento.isSelected()&&localEs.isSelected()){
                pst.setString(4, "AT E ES");
            }
            else if(localAtendimento.isSelected()&&localML.isSelected()){
                pst.setString(4,"AT E ML");
            }
            else if(localML.isSelected()&&localOficina.isSelected()){
                pst.setString(4,"ML E OF");
            }
            else if(localML.isSelected()&&localEs.isSelected()){
                pst.setString(4,"ML E ES");
            }
            else if(localEs.isSelected()&&localOficina.isSelected()){
                pst.setString(4,"ES E OF");
            }
            else if(localAtendimento.isSelected()){
                pst.setString(4,"AT");
            }
            else if(localML.isSelected()){
                pst.setString(4,"ML");
            }
            else if(localEs.isSelected()){
                pst.setString(4,"ES");
            }
            else if(localOficina.isSelected()){
                pst.setString(4,"OF");
            }
            if(nivelUm.isSelected()){
                pst.setInt(3,1);
            }
            else if(nivelDois.isSelected()){
                pst.setInt(3,2);
            }
            else if(nivelTres.isSelected()){
                pst.setInt(3,3);
            }
            else if(nivelQuatro.isSelected()){
                pst.setInt(3,4);
            }
            else if(nivelCinco.isSelected()){
                pst.setInt(3,5);
            }
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"USUÁRIO CADASTRADO COM SUCESSO");
            UserCadastrado usuario = new UserCadastrado();
            usuario.setVisible(true);
            usuario.cadastroNome.setText(cadastroNome.getText());
            if(escolhaSexo1.isSelected()){
                usuario.sexoMascu.setSelected(true);
            }
            else if(escolhaSexo2.isSelected()){
                usuario.sexoFemi.setSelected(true);
            }
            if(localAtendimento.isSelected()){
                usuario.localAtendimento.setSelected(true);
            }
            if(localML.isSelected()){
                usuario.localML.setSelected(true);
            }
            if(localEs.isSelected()){
                usuario.localEs.setSelected(true);
            }
            if(localOficina.isSelected()){
                usuario.localOficina.setSelected(true);
            }
            if(nivelUm.isSelected()){
                usuario.nivelUm.setSelected(true);
            }
            else if(nivelDois.isSelected()){
                usuario.nivelDois.setSelected(true);
            }
            else if(nivelTres.isSelected()){
                usuario.nivelTres.setSelected(true);
            }
            else if(nivelQuatro.isSelected()){
                usuario.nivelQuatro.setSelected(true);
            }
            else if(nivelCinco.isSelected()){
                usuario.nivelCinco.setSelected(true);
            }
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        grupoNivel = new javax.swing.ButtonGroup();
        grupoGenero = new javax.swing.ButtonGroup();
        acesso = new javax.swing.ButtonGroup();
        senhaDoUserConfirm = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cadastroNome = new javax.swing.JTextField();
        senhaDoUser = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        botaoEntrarIniciall1 = new javax.swing.JButton();
        botaoEntrarIniciall = new javax.swing.JButton();
        localOficina = new javax.swing.JRadioButton();
        escolhaSexo2 = new javax.swing.JRadioButton();
        localAtendimento = new javax.swing.JRadioButton();
        nivelCinco = new javax.swing.JRadioButton();
        localML = new javax.swing.JRadioButton();
        nivelUm = new javax.swing.JRadioButton();
        nivelDois = new javax.swing.JRadioButton();
        localEs = new javax.swing.JRadioButton();
        nivelTres = new javax.swing.JRadioButton();
        nivelQuatro = new javax.swing.JRadioButton();
        escolhaSexo1 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        valida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOVO USUÁRIO");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        senhaDoUserConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        senhaDoUserConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaDoUserConfirmKeyPressed(evt);
            }
        });
        getContentPane().add(senhaDoUserConfirm);
        senhaDoUserConfirm.setBounds(300, 220, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONFIRMAR SENHA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(300, 190, 190, 21);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("SEXO");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(30, 200, 70, 21);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ACESSO PERMITIDO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 320, 180, 21);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SENHA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 110, 130, 21);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("NOME");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(30, 110, 100, 21);

        cadastroNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cadastroNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastroNomeKeyPressed(evt);
            }
        });
        getContentPane().add(cadastroNome);
        cadastroNome.setBounds(30, 140, 200, 30);

        senhaDoUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        senhaDoUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaDoUserKeyPressed(evt);
            }
        });
        getContentPane().add(senhaDoUser);
        senhaDoUser.setBounds(300, 140, 130, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-4, 0, 150, 80);

        botaoEntrarIniciall1.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall1.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall1.setText("NÍVEIS");
        botaoEntrarIniciall1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarIniciall1ActionPerformed(evt);
            }
        });
        botaoEntrarIniciall1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarIniciall1KeyPressed(evt);
            }
        });
        getContentPane().add(botaoEntrarIniciall1);
        botaoEntrarIniciall1.setBounds(300, 510, 160, 40);

        botaoEntrarIniciall.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall.setText("CADASTRAR");
        botaoEntrarIniciall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarIniciallActionPerformed(evt);
            }
        });
        botaoEntrarIniciall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarIniciallKeyPressed(evt);
            }
        });
        getContentPane().add(botaoEntrarIniciall);
        botaoEntrarIniciall.setBounds(30, 510, 160, 40);

        acesso.add(localOficina);
        localOficina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        localOficina.setForeground(new java.awt.Color(255, 255, 255));
        localOficina.setText("OFICINA");
        localOficina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                localOficinaKeyPressed(evt);
            }
        });
        getContentPane().add(localOficina);
        localOficina.setBounds(30, 470, 240, 25);

        grupoGenero.add(escolhaSexo2);
        escolhaSexo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        escolhaSexo2.setForeground(new java.awt.Color(255, 255, 255));
        escolhaSexo2.setText("FEMININO");
        escolhaSexo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                escolhaSexo2KeyPressed(evt);
            }
        });
        getContentPane().add(escolhaSexo2);
        escolhaSexo2.setBounds(30, 270, 130, 25);

        acesso.add(localAtendimento);
        localAtendimento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        localAtendimento.setForeground(new java.awt.Color(255, 255, 255));
        localAtendimento.setText("ATENDIMENTO");
        localAtendimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                localAtendimentoKeyPressed(evt);
            }
        });
        getContentPane().add(localAtendimento);
        localAtendimento.setBounds(30, 350, 240, 25);

        grupoNivel.add(nivelCinco);
        nivelCinco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nivelCinco.setForeground(new java.awt.Color(255, 255, 255));
        nivelCinco.setText("NÍVEL 5");
        nivelCinco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nivelCincoKeyPressed(evt);
            }
        });
        getContentPane().add(nivelCinco);
        nivelCinco.setBounds(300, 470, 180, 25);

        acesso.add(localML);
        localML.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        localML.setForeground(new java.awt.Color(255, 255, 255));
        localML.setText("MERCADO LIVRE");
        localML.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                localMLKeyPressed(evt);
            }
        });
        getContentPane().add(localML);
        localML.setBounds(30, 430, 240, 25);

        grupoNivel.add(nivelUm);
        nivelUm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nivelUm.setForeground(new java.awt.Color(255, 255, 255));
        nivelUm.setText("NÍVEL 1");
        nivelUm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nivelUmKeyPressed(evt);
            }
        });
        getContentPane().add(nivelUm);
        nivelUm.setBounds(300, 310, 180, 25);

        grupoNivel.add(nivelDois);
        nivelDois.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nivelDois.setForeground(new java.awt.Color(255, 255, 255));
        nivelDois.setText("NÍVEL 2");
        nivelDois.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nivelDoisKeyPressed(evt);
            }
        });
        getContentPane().add(nivelDois);
        nivelDois.setBounds(300, 350, 180, 25);

        acesso.add(localEs);
        localEs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        localEs.setForeground(new java.awt.Color(255, 255, 255));
        localEs.setText("ESTOQUE");
        localEs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                localEsKeyPressed(evt);
            }
        });
        getContentPane().add(localEs);
        localEs.setBounds(30, 390, 240, 25);

        grupoNivel.add(nivelTres);
        nivelTres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nivelTres.setForeground(new java.awt.Color(255, 255, 255));
        nivelTres.setText("NÍVEL 3");
        nivelTres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nivelTresKeyPressed(evt);
            }
        });
        getContentPane().add(nivelTres);
        nivelTres.setBounds(300, 390, 180, 25);

        grupoNivel.add(nivelQuatro);
        nivelQuatro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nivelQuatro.setForeground(new java.awt.Color(255, 255, 255));
        nivelQuatro.setText("NÍVEL 4");
        nivelQuatro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nivelQuatroKeyPressed(evt);
            }
        });
        getContentPane().add(nivelQuatro);
        nivelQuatro.setBounds(300, 430, 180, 25);

        grupoGenero.add(escolhaSexo1);
        escolhaSexo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        escolhaSexo1.setForeground(new java.awt.Color(255, 255, 255));
        escolhaSexo1.setText("MASCULINO");
        escolhaSexo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                escolhaSexo1KeyPressed(evt);
            }
        });
        getContentPane().add(escolhaSexo1);
        escolhaSexo1.setBounds(30, 230, 130, 25);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("NÍVEL DE ACESSO");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(300, 280, 180, 21);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("*");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(90, 98, 20, 50);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("*");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(80, 163, 20, 100);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("*");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(210, 308, 20, 50);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("*");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(453, 248, 30, 90);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("*");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(477, 174, 20, 60);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("*");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(360, 78, 30, 90);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/faixa-cinza-5.png"))); // NOI18N
        getContentPane().add(jLabel28);
        jLabel28.setBounds(210, 570, 50, 120);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CADASTRO DE USUÁRIO");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(160, 10, 320, 60);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel12.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel12.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-80, 4, 760, 77);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 4, 760, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 760, 430);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(320, 340, 570, 530);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-20, 450, 570, 530);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 570, 530);

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
        getContentPane().add(valida);
        valida.setBounds(230, 200, 0, 0);

        setSize(new java.awt.Dimension(532, 590));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarIniciallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallActionPerformed
        String a=senhaDoUser.getText(),b=senhaDoUserConfirm.getText();
        if(cadastroNome.getText().equals("")){
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
        }
        else if(senhaDoUser.getText().equals("")){
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
        }
        else if((localAtendimento.isSelected()||localEs.isSelected()||localML.isSelected()||localOficina.isSelected())&&(nivelUm.isSelected()||nivelDois.isSelected()||nivelTres.isSelected()||nivelQuatro.isSelected()||nivelCinco.isSelected())&&(escolhaSexo1.isSelected()||escolhaSexo2.isSelected())){
            if((localAtendimento.isSelected()&&nivelDois.isSelected())||(localAtendimento.isSelected()&&nivelTres.isSelected())||(localAtendimento.isSelected()&&nivelQuatro.isSelected())||(localAtendimento.isSelected()&&nivelCinco.isSelected())){
                JOptionPane.showMessageDialog(null, "É OBRIGATÓRIO QUE UM USUÁRIO DO ATENDIMENTO POSSUA O NÍVEL 1!");
            }
            else if(senhaDoUser.getText().equals(b)&&senhaDoUserConfirm.getText().equals(a)){
                adicionar();
            }
            else{
                JOptionPane.showMessageDialog(null, "AS SENHAS ESTÃO DIFERENTES, PREENCHA OS CAMPOS NOVAMENTE!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
        }
    }//GEN-LAST:event_botaoEntrarIniciallActionPerformed

    private void botaoEntrarIniciall1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall1ActionPerformed
        Niveis nivel = new Niveis();
        nivel.setVisible(true);
    }//GEN-LAST:event_botaoEntrarIniciall1ActionPerformed

    private void cadastroNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastroNomeKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            senhaDoUser.requestFocus();
        }
    }//GEN-LAST:event_cadastroNomeKeyPressed

    private void escolhaSexo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_escolhaSexo1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            escolhaSexo2.requestFocus();
        }
    }//GEN-LAST:event_escolhaSexo1KeyPressed

    private void escolhaSexo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_escolhaSexo2KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            localAtendimento.requestFocus();
        }
    }//GEN-LAST:event_escolhaSexo2KeyPressed

    private void localMLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localMLKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            localOficina.requestFocus();
        }
    }//GEN-LAST:event_localMLKeyPressed

    private void localEsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localEsKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            localML.requestFocus();
        }
    }//GEN-LAST:event_localEsKeyPressed

    private void localAtendimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localAtendimentoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            localEs.requestFocus();
        }
    }//GEN-LAST:event_localAtendimentoKeyPressed

    private void nivelUmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nivelUmKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            nivelDois.requestFocus();
        }
    }//GEN-LAST:event_nivelUmKeyPressed

    private void nivelDoisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nivelDoisKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            nivelTres.requestFocus();
        }
    }//GEN-LAST:event_nivelDoisKeyPressed

    private void nivelTresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nivelTresKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            nivelQuatro.requestFocus();
        }
    }//GEN-LAST:event_nivelTresKeyPressed

    private void nivelQuatroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nivelQuatroKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            nivelCinco.requestFocus();
        }
    }//GEN-LAST:event_nivelQuatroKeyPressed

    private void nivelCincoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nivelCincoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            String a=senhaDoUser.getText(),b=senhaDoUserConfirm.getText();
            if(cadastroNome.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            }
            else if(senhaDoUser.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            }
            else if((localAtendimento.isSelected()||localEs.isSelected()||localML.isSelected()||localOficina.isSelected())&&(nivelUm.isSelected()||nivelDois.isSelected()||nivelTres.isSelected()||nivelQuatro.isSelected()||nivelCinco.isSelected())&&(escolhaSexo1.isSelected()||escolhaSexo2.isSelected())){
                if((localAtendimento.isSelected()&&nivelDois.isSelected())||(localAtendimento.isSelected()&&nivelTres.isSelected())||(localAtendimento.isSelected()&&nivelQuatro.isSelected())||(localAtendimento.isSelected()&&nivelCinco.isSelected())){
                    JOptionPane.showMessageDialog(null, "É OBRIGATÓRIO QUE UM USUÁRIO DO ATENDIMENTO POSSUA O NÍVEL 1!");
                }
                else if(senhaDoUser.getText().equals(b)&&senhaDoUserConfirm.getText().equals(a)){
                    adicionar();
                }
                else{
                    JOptionPane.showMessageDialog(null, "AS SENHAS ESTÃO DIFERENTES, PREENCHA OS CAMPOS NOVAMENTE!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            }
        }
    }//GEN-LAST:event_nivelCincoKeyPressed

    private void botaoEntrarIniciallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            String a=senhaDoUser.getText(),b=senhaDoUserConfirm.getText();
            if(cadastroNome.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            }
            else if(senhaDoUser.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            }
            else if((localAtendimento.isSelected()||localEs.isSelected()||localML.isSelected()||localOficina.isSelected())&&(nivelUm.isSelected()||nivelDois.isSelected()||nivelTres.isSelected()||nivelQuatro.isSelected()||nivelCinco.isSelected())&&(escolhaSexo1.isSelected()||escolhaSexo2.isSelected())){
                if((localAtendimento.isSelected()&&nivelDois.isSelected())||(localAtendimento.isSelected()&&nivelTres.isSelected())||(localAtendimento.isSelected()&&nivelQuatro.isSelected())||(localAtendimento.isSelected()&&nivelCinco.isSelected())){
                    JOptionPane.showMessageDialog(null, "É OBRIGATÓRIO QUE UM USUÁRIO DO ATENDIMENTO POSSUA O NÍVEL 1!");
                }
                else if(senhaDoUser.getText().equals(b)&&senhaDoUserConfirm.getText().equals(a)){
                    adicionar();
                }
                else{
                    JOptionPane.showMessageDialog(null, "AS SENHAS ESTÃO DIFERENTES, PREENCHA OS CAMPOS NOVAMENTE!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS");
            }
        }
    }//GEN-LAST:event_botaoEntrarIniciallKeyPressed

    private void botaoEntrarIniciall1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            Niveis nivel = new Niveis();
            nivel.setVisible(true);
        }
    }//GEN-LAST:event_botaoEntrarIniciall1KeyPressed

    private void senhaDoUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaDoUserKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            senhaDoUserConfirm.requestFocus();
        }   
    }//GEN-LAST:event_senhaDoUserKeyPressed

    private void localOficinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localOficinaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            nivelUm.requestFocus();
        }  
    }//GEN-LAST:event_localOficinaKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    private void senhaDoUserConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaDoUserConfirmKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            escolhaSexo1.requestFocus();
        }
    }//GEN-LAST:event_senhaDoUserConfirmKeyPressed

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
            java.util.logging.Logger.getLogger(NovoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup acesso;
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JButton botaoEntrarIniciall;
    private javax.swing.JButton botaoEntrarIniciall1;
    private javax.swing.JTextField cadastroNome;
    private javax.swing.JRadioButton escolhaSexo1;
    private javax.swing.JRadioButton escolhaSexo2;
    private javax.swing.ButtonGroup grupoGenero;
    private javax.swing.ButtonGroup grupoNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton localAtendimento;
    private javax.swing.JRadioButton localEs;
    private javax.swing.JRadioButton localML;
    private javax.swing.JRadioButton localOficina;
    public static javax.swing.JLabel mostrarNivel;
    private javax.swing.JRadioButton nivelCinco;
    private javax.swing.JRadioButton nivelDois;
    private javax.swing.JRadioButton nivelQuatro;
    private javax.swing.JRadioButton nivelTres;
    private javax.swing.JRadioButton nivelUm;
    private javax.swing.JPasswordField senhaDoUser;
    private javax.swing.JPasswordField senhaDoUserConfirm;
    private javax.swing.JLabel valida;
    // End of variables declaration//GEN-END:variables
}
