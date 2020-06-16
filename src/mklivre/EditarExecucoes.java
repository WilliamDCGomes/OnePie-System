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
public class EditarExecucoes extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /** Creates new form EditarExecucoes */
    public EditarExecucoes() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
        cadastroObservacoes.setWrapStyleWord(true);
    }
    String compara;
    int x=0;
    public void pupolaJComboBox(){
        String sql ="select * from mecanicos where situacao=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,"ATIVO");
            rs=pst.executeQuery();
            while(rs.next()){
                campoMecanicos.addItem(rs.getString("nome_mecanico"));
            }
            campoMecanicos.setSelectedItem(mec.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void alterar(){
        String sql = "update exec_of2 set SERVIÇO=?,HORA_INICIAL=?,HORA_FINAL=?,DURAÇÃO=?,OBSERVAÇÕES=?,TIPO_DE_ORDEM=?,MECÂNICO=?,DIA=?,HINICIAL=?,MINICIAL=?,HORAFINAL=?,MINIFINAL=?,DIAS=?,MÊS=?,ANO=?,HISTÓRICO=?,COMP=?,APARELHO=? where os_aux=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,servicoDaOs.getSelectedItem().toString());
            int horainicial=Integer.parseInt(horaInicial.getValue().toString()),minutoinicial=Integer.parseInt(minutoInicial.getValue().toString()),horafinal=Integer.parseInt(horaFinal.getValue().toString()),minutofinal=Integer.parseInt(minutoFinal.getValue().toString());
            int duracaoh=(horafinal-horainicial)*60;
            int duracaom=minutofinal-minutoinicial;
            int duracao = duracaoh+duracaom;
            if(duracao<0){
		duracao+=1440;
            }
            duracaoh=0;
            duracaom=0;
            if(duracao==0){
		duracaoh=24;
            }
            while(duracao>=60){
		duracaoh+=1;
		duracao-=60;
            }
            String tempo = Integer.toString(duracaoh)+":"+Integer.toString(duracao);
            if(duracaoh<10&&duracao<10){
                tempo="0"+Integer.toString(duracaoh)+":"+"0"+Integer.toString(duracao);
            }
            else if(duracaoh<10){
                tempo="0"+Integer.toString(duracaoh)+":"+Integer.toString(duracao);
            }
            else if(duracao<10){
                tempo=Integer.toString(duracaoh)+":"+"0"+Integer.toString(duracao);
            }
            String data = dataDia.getValue().toString()+"/"+dataMes.getValue().toString()+"/"+dataAno.getValue().toString();
            if(Integer.parseInt(dataDia.getValue().toString())<10&&Integer.parseInt(dataMes.getValue().toString())<10&&Integer.parseInt(dataAno.getValue().toString())<10){
                data = "0"+dataDia.getValue().toString()+"/"+"0"+dataMes.getValue().toString()+"/"+"0"+dataAno.getValue().toString();
            }
            else if(Integer.parseInt(dataMes.getValue().toString())<10&&Integer.parseInt(dataAno.getValue().toString())<10){
                data = dataDia.getValue().toString()+"/"+"0"+dataMes.getValue().toString()+"/"+"0"+dataAno.getValue().toString();
            }
            else if(Integer.parseInt(dataDia.getValue().toString())<10&&Integer.parseInt(dataAno.getValue().toString())<10){
                data = "0"+dataDia.getValue().toString()+"/"+dataMes.getValue().toString()+"/"+"0"+dataAno.getValue().toString();
            }
            else if(Integer.parseInt(dataDia.getValue().toString())<10&&Integer.parseInt(dataMes.getValue().toString())<10){
                data = "0"+dataDia.getValue().toString()+"/"+"0"+dataMes.getValue().toString()+"/"+dataAno.getValue().toString();
            }
            else if(Integer.parseInt(dataAno.getValue().toString())<10){
                data = dataDia.getValue().toString()+"/"+dataMes.getValue().toString()+"/"+"0"+dataAno.getValue().toString();
            }
            else if(Integer.parseInt(dataMes.getValue().toString())<10){
                data = dataDia.getValue().toString()+"/"+"0"+dataMes.getValue().toString()+"/"+dataAno.getValue().toString();
            }
            else if(Integer.parseInt(dataDia.getValue().toString())<10){
                data = "0"+dataDia.getValue().toString()+"/"+dataMes.getValue().toString()+"/"+dataAno.getValue().toString();
            }
            String passahoraI=horaInicial.getValue().toString()+":"+minutoInicial.getValue().toString();
            if(Integer.parseInt(minutoInicial.getValue().toString())<10&&Integer.parseInt(horaInicial.getValue().toString())<10){
                passahoraI="0"+horaInicial.getValue().toString()+":"+"0"+minutoInicial.getValue().toString();
            }
            else if(Integer.parseInt(minutoInicial.getValue().toString())<10){
                passahoraI=horaInicial.getValue().toString()+":"+"0"+minutoInicial.getValue().toString();
            }
            else if(Integer.parseInt(horaInicial.getValue().toString())<10){
                passahoraI="0"+horaInicial.getValue().toString()+":"+minutoInicial.getValue().toString();
            }
            String passahoraF = horaFinal.getValue().toString()+":"+minutoFinal.getValue().toString();
            if(Integer.parseInt(minutoFinal.getValue().toString())<10&&Integer.parseInt(horaFinal.getValue().toString())<10){
                passahoraF="0"+horaFinal.getValue().toString()+":"+"0"+minutoFinal.getValue().toString();
            }
            else if(Integer.parseInt(minutoFinal.getValue().toString())<10){
                passahoraF=horaFinal.getValue().toString()+":"+"0"+minutoFinal.getValue().toString();
            }
            else if(Integer.parseInt(horaFinal.getValue().toString())<10){
                passahoraF="0"+horaFinal.getValue().toString()+":"+minutoFinal.getValue().toString();
            }
            int pass=Integer.parseInt(dataMes.getValue().toString()),comp=1;
            if(pass==1){
                comp=Integer.parseInt(dataDia.getValue().toString());
            }
            else if(pass==2){
                comp=Integer.parseInt(dataDia.getValue().toString())+31;
            }
            else if(pass==3){
                comp=Integer.parseInt(dataDia.getValue().toString())+59;
            }
            else if(pass==4){
                comp=Integer.parseInt(dataDia.getValue().toString())+90;
            }
            else if(pass==5){
                comp=Integer.parseInt(dataDia.getValue().toString())+120;
            }
            else if(pass==6){
                comp=Integer.parseInt(dataDia.getValue().toString())+151;
            }
            else if(pass==7){
                comp=Integer.parseInt(dataDia.getValue().toString())+181;
            }
            else if(pass==8){
                comp=Integer.parseInt(dataDia.getValue().toString())+212;
            }
            else if(pass==9){
                comp=Integer.parseInt(dataDia.getValue().toString())+243;
            }
            else if(pass==10){
                comp=Integer.parseInt(dataDia.getValue().toString())+273;
            }
            else if(pass==11){
                comp=Integer.parseInt(dataDia.getValue().toString())+304;
            }
            else if(pass==12){
                comp=Integer.parseInt(dataDia.getValue().toString())+334;
            }
            pst.setString(2,passahoraI);
            pst.setString(3,passahoraF);
            pst.setString(4,tempo);
            pst.setString(5,cadastroObservacoes.getText());
            pst.setString(6,tipoDaOS.getSelectedItem().toString());
            pst.setString(7,campoMecanicos.getSelectedItem().toString());
            pst.setString(8,data);
            pst.setString(9,horaInicial.getValue().toString());
            pst.setString(10,minutoInicial.getValue().toString());
            pst.setString(11,horaFinal.getValue().toString());
            pst.setString(12,minutoFinal.getValue().toString());
            pst.setInt(13,Integer.parseInt(dataDia.getValue().toString()));
            pst.setInt(14,Integer.parseInt(dataMes.getValue().toString()));
            pst.setInt(15,Integer.parseInt(dataAno.getValue().toString()));
            pst.setInt(17,comp);
            pst.setString(18,aparelho.getText());
            pst.setString(19,cadastroOS.getText());
            String compara2=servicoDaOs.getSelectedItem().toString()+" "+data;
            if(servicoDaOs.getSelectedItem().toString().equals(compara)){
               pst.setString(16,historico.getText());
            }
            else{
                pst.setString(16,historico.getText()+"\n"+compara2);
            }
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"EXECUÇÃO ATUALIZADA COM SUCESSO");
            ExecucoesDosMecanicos execucoes = new ExecucoesDosMecanicos();
            execucoes.setVisible(true);
            execucoes.campoOS.setText(cadastroOS.getText());
            execucoes.campoServico.setText(servicoDaOs.getSelectedItem().toString());
            execucoes.campoHoraInicial.setText(passahoraI);
            execucoes.campoHoraFinal.setText(passahoraF);
            execucoes.campoDuracao.setText(tempo);
            execucoes.campoData.setText(data);
            execucoes.campoTipoDaOs.setText(tipoDaOS.getSelectedItem().toString());
            execucoes.campoMecanico.setText(campoMecanicos.getSelectedItem().toString());
            execucoes.campoObs.setText(cadastroObservacoes.getText());
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void pegar(){
        String sqlnome = "select * from exec_of2 where os_aux=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,cadastroOS.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                compara=rs.getString(2);
                mec.setText(rs.getString(8));
                aparelho.setText(rs.getString("APARELHO"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        aparelho = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cadastroObservacoes = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cadastroOS = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        dataDia = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        dataAno = new javax.swing.JSpinner();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        botaoEntrarIniciall = new javax.swing.JButton();
        dataMes = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        tipoDaOS = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        servicoDaOs = new javax.swing.JComboBox<>();
        campoMecanicos = new javax.swing.JComboBox<>();
        minutoInicial = new javax.swing.JSpinner();
        horaInicial = new javax.swing.JSpinner();
        horaFinal = new javax.swing.JSpinner();
        minutoFinal = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historico = new javax.swing.JTextArea();
        mec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR EXECUÇÕES");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("APARELHO");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(250, 360, 100, 17);

        aparelho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aparelho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aparelhoKeyPressed(evt);
            }
        });
        getContentPane().add(aparelho);
        aparelho.setBounds(250, 390, 170, 30);

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
        jScrollPane1.setBounds(440, 140, 300, 280);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("*");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(320, 100, 30, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(180, 100, 20, 40);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ORDEM DE SERVIÇO");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 110, 160, 17);

        cadastroOS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cadastroOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastroOSKeyPressed(evt);
            }
        });
        getContentPane().add(cadastroOS);
        cadastroOS.setBounds(20, 140, 100, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("OBSERVAÇÕES");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(440, 90, 120, 50);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-4, 0, 150, 80);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("HORA FINAL");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(250, 200, 90, 17);

        dataDia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataDia.setModel(new javax.swing.SpinnerNumberModel(0, 0, 31, 1));
        dataDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataDiaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dataDiaKeyTyped(evt);
            }
        });
        getContentPane().add(dataDia);
        dataDia.setBounds(20, 310, 60, 30);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("DATA (**/**/**)");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(20, 280, 130, 17);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("/");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(70, 310, 30, 30);

        dataAno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataAno.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        dataAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataAnoKeyPressed(evt);
            }
        });
        getContentPane().add(dataAno);
        dataAno.setBounds(160, 310, 60, 30);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("/");
        getContentPane().add(jLabel38);
        jLabel38.setBounds(140, 310, 30, 30);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("*");
        getContentPane().add(jLabel39);
        jLabel39.setBounds(100, 340, 50, 60);

        botaoEntrarIniciall.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall.setText("GRAVAR");
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
        botaoEntrarIniciall.setBounds(20, 430, 110, 40);

        dataMes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataMes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 1));
        dataMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataMesKeyPressed(evt);
            }
        });
        getContentPane().add(dataMes);
        dataMes.setBounds(90, 310, 60, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("M");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(170, 230, 30, 30);

        tipoDaOS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR", "NORMAL", "GARANTIA", "GARANTIA INTERNA" }));
        tipoDaOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tipoDaOSKeyPressed(evt);
            }
        });
        getContentPane().add(tipoDaOS);
        tipoDaOS.setBounds(20, 390, 160, 30);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("TIPO DA OS");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(20, 360, 150, 17);

        servicoDaOs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR", "ORÇAMENTO", "EXECUTADO", "SEM CONSERTO" }));
        servicoDaOs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                servicoDaOsKeyPressed(evt);
            }
        });
        getContentPane().add(servicoDaOs);
        servicoDaOs.setBounds(250, 140, 160, 30);

        campoMecanicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONAR" }));
        campoMecanicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoMecanicosKeyPressed(evt);
            }
        });
        getContentPane().add(campoMecanicos);
        campoMecanicos.setBounds(250, 310, 160, 30);

        minutoInicial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        minutoInicial.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        minutoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                minutoInicialKeyPressed(evt);
            }
        });
        getContentPane().add(minutoInicial);
        minutoInicial.setBounds(110, 230, 60, 30);

        horaInicial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        horaInicial.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        horaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                horaInicialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horaInicialKeyTyped(evt);
            }
        });
        getContentPane().add(horaInicial);
        horaInicial.setBounds(20, 230, 60, 30);

        horaFinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        horaFinal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        horaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                horaFinalKeyPressed(evt);
            }
        });
        getContentPane().add(horaFinal);
        horaFinal.setBounds(250, 230, 60, 30);

        minutoFinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        minutoFinal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        minutoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                minutoFinalKeyPressed(evt);
            }
        });
        getContentPane().add(minutoFinal);
        minutoFinal.setBounds(340, 230, 60, 30);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("H");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(310, 230, 30, 30);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("*");
        getContentPane().add(jLabel40);
        jLabel40.setBounds(140, 260, 40, 60);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("M");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(400, 230, 30, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("EDITAR EXECUÇÕES");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(280, 10, 320, 60);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("H");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(80, 230, 30, 30);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("*");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(340, 180, 30, 60);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 0, 0));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("*");
        getContentPane().add(jLabel41);
        jLabel41.setBounds(330, 260, 40, 60);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("SERVIÇO");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(250, 110, 150, 17);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("MECÂNICO");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(250, 280, 150, 17);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel12.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel12.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-80, 4, 760, 77);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("HORA INICIAL");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(20, 200, 150, 17);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("*");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(130, 180, 30, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 4, 760, 77);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 820, 430);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(250, 10, 640, 530);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(320, 340, 570, 530);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-20, 450, 570, 530);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 570, 530);

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

        mec.setText("jLabel2");
        getContentPane().add(mec);
        mec.setBounds(620, 80, 34, 15);

        setSize(new java.awt.Dimension(764, 517));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        cadastroObservacoes.setWrapStyleWord(true);
        if(x==0){
            x++;
            pegar();
            pupolaJComboBox();
        }
    }//GEN-LAST:event_formWindowActivated

    private void cadastroOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastroOSKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            servicoDaOs.requestFocus();
        }
    }//GEN-LAST:event_cadastroOSKeyPressed

    private void cadastroObservacoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastroObservacoesKeyPressed
        
    }//GEN-LAST:event_cadastroObservacoesKeyPressed

    private void dataDiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataDiaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            dataMes.requestFocus();
        }
    }//GEN-LAST:event_dataDiaKeyPressed

    private void dataDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataDiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dataDiaKeyTyped

    private void dataAnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataAnoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            campoMecanicos.requestFocus();
        }
    }//GEN-LAST:event_dataAnoKeyPressed

    private void botaoEntrarIniciallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallActionPerformed
        if(dataDia.getValue().toString().equals("0")||dataMes.getValue().toString().equals("0")||dataAno.getValue().toString().equals("0")||cadastroOS.getText().equals("")||(horaInicial.getValue().toString().equals("0")&&minutoInicial.getValue().toString().equals("0")&&horaFinal.getValue().toString().equals("0")&&minutoFinal.getValue().toString().equals("0"))||campoMecanicos.getSelectedItem().toString().equals("SELECIONAR")||servicoDaOs.getSelectedItem().toString().equals("SELECIONAR")||tipoDaOS.getSelectedItem().toString().equals("SELECIONAR")){
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS");
        }
        else{
            alterar();
        }
    }//GEN-LAST:event_botaoEntrarIniciallActionPerformed

    private void botaoEntrarIniciallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(dataDia.getValue().toString().equals("0")||dataMes.getValue().toString().equals("0")||dataAno.getValue().toString().equals("0")||cadastroOS.getText().equals("")||(horaInicial.getValue().toString().equals("0")&&minutoInicial.getValue().toString().equals("0")&&horaFinal.getValue().toString().equals("0")&&minutoFinal.getValue().toString().equals("0"))||campoMecanicos.getSelectedItem().toString().equals("SELECIONAR")||servicoDaOs.getSelectedItem().toString().equals("SELECIONAR")||tipoDaOS.getSelectedItem().toString().equals("SELECIONAR")){
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS");
            }
            else{
                alterar();
            }
        }
    }//GEN-LAST:event_botaoEntrarIniciallKeyPressed

    private void dataMesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataMesKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            dataAno.requestFocus();
        }
    }//GEN-LAST:event_dataMesKeyPressed

    private void tipoDaOSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoDaOSKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            aparelho.requestFocus();
        }
    }//GEN-LAST:event_tipoDaOSKeyPressed

    private void servicoDaOsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_servicoDaOsKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            horaInicial.requestFocus();
        }
    }//GEN-LAST:event_servicoDaOsKeyPressed

    private void campoMecanicosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMecanicosKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            tipoDaOS.requestFocus();
        }
    }//GEN-LAST:event_campoMecanicosKeyPressed

    private void minutoInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_minutoInicialKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            horaFinal.requestFocus();
        }
    }//GEN-LAST:event_minutoInicialKeyPressed

    private void horaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaInicialKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            minutoInicial.requestFocus();
        }
    }//GEN-LAST:event_horaInicialKeyPressed

    private void horaInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaInicialKeyTyped

    }//GEN-LAST:event_horaInicialKeyTyped

    private void horaFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaFinalKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            minutoFinal.requestFocus();
        }
    }//GEN-LAST:event_horaFinalKeyPressed

    private void minutoFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_minutoFinalKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            dataDia.requestFocus();
        }
    }//GEN-LAST:event_minutoFinalKeyPressed

    private void historicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_historicoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_historicoKeyPressed

    private void aparelhoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aparelhoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            cadastroObservacoes.requestFocus();
        }
    }//GEN-LAST:event_aparelhoKeyPressed

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
            java.util.logging.Logger.getLogger(EditarExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarExecucoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarExecucoes().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JTextField aparelho;
    private javax.swing.JButton botaoEntrarIniciall;
    public static javax.swing.JTextField cadastroOS;
    public static javax.swing.JTextArea cadastroObservacoes;
    public static javax.swing.JComboBox<String> campoMecanicos;
    public static javax.swing.JSpinner dataAno;
    public static javax.swing.JSpinner dataDia;
    public static javax.swing.JSpinner dataMes;
    public static javax.swing.JTextArea historico;
    public static javax.swing.JSpinner horaFinal;
    public static javax.swing.JSpinner horaInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mec;
    public static javax.swing.JSpinner minutoFinal;
    public static javax.swing.JSpinner minutoInicial;
    public static javax.swing.JLabel mostrarNivel;
    public static javax.swing.JComboBox<String> servicoDaOs;
    public static javax.swing.JComboBox<String> tipoDaOS;
    // End of variables declaration//GEN-END:variables

}
