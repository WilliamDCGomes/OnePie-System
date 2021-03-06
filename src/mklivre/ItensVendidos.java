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
import java.text.DecimalFormat;
import net.proteanit.sql.DbUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author willi
 */
public class ItensVendidos extends javax.swing.JFrame {

    int mudar = 0;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form ItensVendidos
     */
    public ItensVendidos() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
    }

    private void filtrar() {
        char[] dataI = new char[10];
        String ano = "";
        for (int y = 0; y < 10; y++) {
            dataI[y] = dataInicial.getText().charAt(y);
            if (y > 5) {
                ano += dataI[y];
            }
        }
        String dataInicial = ano + "/" + dataI[3] + dataI[4] + "/" + dataI[0] + dataI[1];
        char[] dataF = new char[10];
        String ano1 = "";
        for (int y = 0; y < 10; y++) {
            dataF[y] = dataFinal.getText().charAt(y);
            if (y > 5) {
                ano1 += dataF[y];
            }
        }
        String dataFinal = ano1 + "/" + dataF[3] + dataF[4] + "/" + dataF[0] + dataF[1];
        ini.setText(dataInicial);
        fini.setText(dataFinal);
        String sql = "select CÓDIGO_DO_CLIENTE as CÓDIGO_DA_VENDA,DATA,QUANTIDADE_VENDIDA as QUANTIDADE,CÓDIGO,NOME,PREÇO as VALOR_DE_VENDA,PORCENTAGEM,TARIFA_ML,FRETE,VALOR_LÍQUIDO_DO_ML,CUSTO,LUCRO from vendas_ml where (str_to_date(DATA, '%d/%m/%Y') between ? and ?) and cancela= ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ini.getText());
            pst.setString(2, fini.getText());
            pst.setString(3, "NÃO");
            rs = pst.executeQuery();
            tabelaDePecas.setModel(DbUtils.resultSetToTableModel(rs));
            faturamentoTotal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    DecimalFormat df = new DecimalFormat("0.00");

    private void faturamentoTotal() {
        String sql = "select * from vendas_ml where (str_to_date(DATA, '%d/%m/%Y') between ? and ?) and cancela=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ini.getText());
            pst.setString(2, fini.getText());
            pst.setString(3, "NÃO");
            rs = pst.executeQuery();
            float fat = 0;
            while (rs.next()) {
                fat += Float.parseFloat(rs.getString("LUCRO"));
            }
            faturamento.setText(df.format(fat).replace(".", ","));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pegaData() {
        Date data = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        dataFinal.setText(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
        c.set(Calendar.DAY_OF_MONTH, 1);
        dataInicial.setText(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
    }

    private void setar() {
        int setar = tabelaDePecas.getSelectedRow();
        ItemVendido execu = new ItemVendido();
        execu.setVisible(true);
        execu.codigoCliente.setText(tabelaDePecas.getModel().getValueAt(setar, 0).toString());
        execu.mostrarNivel.setText(mostrarNivel.getText());
        execu.acessoUser.setText(acessoUser.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoEditar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        botaoEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDePecas = new javax.swing.JTable();
        dataFinal = new javax.swing.JFormattedTextField();
        dataInicial = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        faturamento = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        filtro = new javax.swing.JLabel();
        ini = new javax.swing.JLabel();
        fini = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ITENS VENDIDOS");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        botaoEditar1.setBackground(new java.awt.Color(0, 0, 0));
        botaoEditar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEditar1.setForeground(new java.awt.Color(255, 255, 255));
        botaoEditar1.setText("FILTRAR");
        botaoEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditar1ActionPerformed(evt);
            }
        });
        botaoEditar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEditar1KeyPressed(evt);
            }
        });
        getContentPane().add(botaoEditar1);
        botaoEditar1.setBounds(390, 500, 160, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 150, 80);

        botaoEditar.setBackground(new java.awt.Color(0, 0, 0));
        botaoEditar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEditar.setForeground(new java.awt.Color(255, 255, 255));
        botaoEditar.setText("MOSTRAR");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });
        botaoEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEditarKeyPressed(evt);
            }
        });
        getContentPane().add(botaoEditar);
        botaoEditar.setBounds(570, 500, 160, 40);

        tabelaDePecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CÓDIGO", "CAIXA", "LOCALIZAÇÃO", "MARCA", "QUANTIDADE"
            }
        ));
        jScrollPane2.setViewportView(tabelaDePecas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(-5, 85, 920, 395);

        try {
            dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dataFinal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataFinalActionPerformed(evt);
            }
        });
        dataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataFinalKeyPressed(evt);
            }
        });
        getContentPane().add(dataFinal);
        dataFinal.setBounds(220, 500, 150, 40);

        try {
            dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dataInicial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataInicialKeyPressed(evt);
            }
        });
        getContentPane().add(dataInicial);
        dataInicial.setBounds(30, 500, 150, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ITENS VENDIDOS");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(320, 10, 340, 60);

        faturamento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        faturamento.setForeground(new java.awt.Color(0, 204, 0));
        faturamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faturamento.setText("0");
        getContentPane().add(faturamento);
        faturamento.setBounds(740, 510, 170, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LUCRO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(780, 480, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 4, 930, 77);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("À");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 500, 40, 40);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 920, 430);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(480, 10, 910, 550);

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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 60, 570, 530);

        filtro.setText("0");
        getContentPane().add(filtro);
        filtro.setBounds(540, 240, 6, 15);

        ini.setText("jLabel3");
        getContentPane().add(ini);
        ini.setBounds(610, 230, 34, 15);

        fini.setText("jLabel3");
        getContentPane().add(fini);
        fini.setBounds(680, 270, 34, 15);

        setSize(new java.awt.Dimension(918, 578));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        setar();
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEditarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            setar();
        }
    }//GEN-LAST:event_botaoEditarKeyPressed
    int x = 0;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (x == 0) {
            x++;
            pegaData();
        }
        filtrar();
    }//GEN-LAST:event_formWindowActivated

    private void dataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataFinalActionPerformed

    private void botaoEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditar1ActionPerformed
        filtrar();
    }//GEN-LAST:event_botaoEditar1ActionPerformed

    private void botaoEditar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEditar1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            filtrar();
        }
    }//GEN-LAST:event_botaoEditar1KeyPressed

    private void dataInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataInicialKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            dataFinal.requestFocus();
        }
    }//GEN-LAST:event_dataInicialKeyPressed

    private void dataFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataFinalKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            filtrar();
            tabelaDePecas.requestFocus();
        }
    }//GEN-LAST:event_dataFinalKeyPressed

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
            java.util.logging.Logger.getLogger(ItensVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItensVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItensVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItensVendidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItensVendidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoEditar1;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel faturamento;
    public static javax.swing.JLabel filtro;
    private javax.swing.JLabel fini;
    private javax.swing.JLabel ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel mostrarNivel;
    public static javax.swing.JTable tabelaDePecas;
    // End of variables declaration//GEN-END:variables
}
