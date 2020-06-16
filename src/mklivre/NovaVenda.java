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
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author willi
 */
public class NovaVenda extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form NovaVenda
     */
    DecimalFormat df =  new DecimalFormat("0.00");
    public NovaVenda() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/mklivre/icone/icone2.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
        conexao = ModuloConexao.conector();
        lucro.setEnabled(false);
        valorLiquidoML.setEnabled(false);
    }
    private void pegaData(){
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatar.format(data);
        dataVenda.setText(dataFormatada);
    }
    float valorVenda = 0,valorCusto=0;
    private void adicionar(){
        String sql = "insert into vendas_ml(CÓDIGO,DATA,QUANTIDADE_VENDIDA,NOME,PREÇO,PORCENTAGEM,TARIFA_ML,FRETE,VALOR_LÍQUIDO_DO_ML,CUSTO,LUCRO,CÓDIGO_DO_CLIENTE,OBSERVAÇÕES,DEVOLVIDO) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,codigoPeca.getText());
            pst.setString(2,dataVenda.getText());
            pst.setInt(3, Integer.parseInt(quantidadeVendida.getText().replace(",",".")));
            pst.setString(4, nomePeca.getText());
            pst.setString(5,precoVendido.getText().replace(",","."));
            pst.setString(6,porcentagemDoMercadoLivre.getText().replace(",","."));
            pst.setString(7,tarifaDoML.getText().replace(",","."));
            pst.setString(8, valorFrete.getText().replace(",","."));
            pst.setString(9, valorLiquidoML.getText().replace(",","."));
            pst.setString(10,custoNaMadri.getText().replace(",","."));
            pst.setString(11,lucro.getText().replace(",","."));
            pst.setString(12,codigoCliente.getText());
            pst.setString(13, cadastroObservacoes.getText());
            pst.setString(14, "NÃO");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"VENDA CADASTRADA COM SUCESSO");
            ItemVendido usuario = new ItemVendido();
            usuario.setVisible(true);
            usuario.acessoUser.setText(acessoUser.getText());
            usuario.cadastroObservacoes.setText(cadastroObservacoes.getText());
            usuario.codigoCliente.setText(codigoCliente.getText());
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void prencheCod(){
        String sqlnome = "select * from tb_pecas_ml2 where CÓDIGO=?";
        try {
            pst = conexao.prepareStatement(sqlnome);
            pst.setString(1,codigoPeca.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                nomePeca.setText(rs.getString("NOME"));
                precoVendido.setText(df.format(Float.parseFloat(rs.getString("PREÇO"))*Integer.parseInt(quantidadeVendida.getText())).replace(".",","));
                porcentagemDoMercadoLivre.setText(rs.getString("PORCENTAGEM").replace(".",","));
                valorVenda=Float.parseFloat(rs.getString("PREÇO"));
                valorCusto=Float.parseFloat(rs.getString("PREÇO_DE_CUSTO"));
                float a=(Float.parseFloat(precoVendido.getText().replace(",","."))*Float.parseFloat(porcentagemDoMercadoLivre.getText().replace(",",".")))/100;
                tarifaDoML.setText(df.format(a).replace(".",","));
                float liquido=Float.parseFloat(precoVendido.getText().replace(",","."))-Float.parseFloat(tarifaDoML.getText().replace(",","."))-Float.parseFloat(valorFrete.getText().replace(",","."));
                valorLiquidoML.setText(df.format(liquido).replace(".",","));
                custoNaMadri.setText(df.format(Float.parseFloat(rs.getString("PREÇO_DE_CUSTO"))*Integer.parseInt(quantidadeVendida.getText())).replace(".",","));
                lucro.setText(df.format(Float.parseFloat(valorLiquidoML.getText().replace(",","."))-Float.parseFloat(custoNaMadri.getText().replace(",","."))).replace(".",","));
            }
            else{
                int confirma = JOptionPane.showConfirmDialog(null, "CÓDIGO NÃO LOCALIZADO NO BANCO DE DADOS, GOSTARIA DE CADASTRAR COMO UM NOVO ITEM?","ATENÇÃO",JOptionPane.YES_NO_OPTION);
                if(confirma==JOptionPane.YES_OPTION){
                    CadastroNovoItem novo = new CadastroNovoItem();
                    novo.setVisible(true);
                    novo.cadastroCodigo.setText(codigoPeca.getText());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void valorQuantidade(){
        if(valorVenda==0){
            precoVendido.setText(df.format(Float.parseFloat(precoVendido.getText().replace(",","."))*Integer.parseInt(quantidadeVendida.getText())).replace(".",","));
        }
        else{
            precoVendido.setText(df.format(valorVenda*Integer.parseInt(quantidadeVendida.getText())).replace(".",","));
        }
        if(valorCusto==0){
            custoNaMadri.setText(df.format(Float.parseFloat(custoNaMadri.getText().replace(",","."))*Integer.parseInt(quantidadeVendida.getText())).replace(".",","));
        }
        else{
            custoNaMadri.setText(df.format(valorCusto*Integer.parseInt(quantidadeVendida.getText())).replace(".",","));
        }
        float a=(Float.parseFloat(precoVendido.getText().replace(",","."))*Float.parseFloat(porcentagemDoMercadoLivre.getText().replace(",",".")))/100;
        tarifaDoML.setText(df.format(a).replace(".",","));
        float liquido=Float.parseFloat(precoVendido.getText().replace(",","."))-Float.parseFloat(tarifaDoML.getText().replace(",","."))-Float.parseFloat(valorFrete.getText().replace(",","."));
        valorLiquidoML.setText(df.format(liquido).replace(".",","));
        lucro.setText(df.format(Float.parseFloat(valorLiquidoML.getText().replace(",","."))-Float.parseFloat(custoNaMadri.getText().replace(",","."))).replace(".",","));
    }
    private void valorVendido(){
        float a=(Float.parseFloat(precoVendido.getText().replace(",","."))*Float.parseFloat(porcentagemDoMercadoLivre.getText().replace(",",".")))/100;
        tarifaDoML.setText(df.format(a).replace(".",","));
        float liquido=Float.parseFloat(precoVendido.getText().replace(",","."))-Float.parseFloat(tarifaDoML.getText().replace(",","."))-Float.parseFloat(valorFrete.getText().replace(",","."));
        valorLiquidoML.setText(df.format(liquido).replace(".",","));
        lucro.setText(df.format(Float.parseFloat(valorLiquidoML.getText().replace(",","."))-Float.parseFloat(custoNaMadri.getText().replace(",","."))).replace(".",","));
    }
    private void tarifaML(){
        float liquido=Float.parseFloat(precoVendido.getText().replace(",","."))-Float.parseFloat(tarifaDoML.getText().replace(",","."))-Float.parseFloat(valorFrete.getText().replace(",","."));
        valorLiquidoML.setText(df.format(liquido).replace(".",","));
        porcentagemDoMercadoLivre.setText(df.format((Float.parseFloat(tarifaDoML.getText().replace(",","."))*100)/Float.parseFloat(precoVendido.getText().replace(",","."))).replace(".",","));
        lucro.setText(df.format(Float.parseFloat(valorLiquidoML.getText().replace(",","."))-Float.parseFloat(custoNaMadri.getText().replace(",","."))).replace(".",","));
    }
    private void custoMadri(){
        lucro.setText(df.format(Float.parseFloat(valorLiquidoML.getText().replace(",","."))-Float.parseFloat(custoNaMadri.getText().replace(",","."))).replace(".",","));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lucro = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        codigoCliente = new javax.swing.JTextField();
        custoNaMadri = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        valorLiquidoML = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataVenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        precoVendido = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        codigoPeca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cadastroObservacoes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tarifaDoML = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        porcentagemDoMercadoLivre = new javax.swing.JTextField();
        quantidadeVendida = new javax.swing.JTextField();
        botaoEntrarIniciall = new javax.swing.JButton();
        botaoEntrarIniciall1 = new javax.swing.JButton();
        nomePeca = new javax.swing.JTextField();
        valorFrete = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CADASTRO DE VENDA");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOVA VENDA");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("LUCRO");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(280, 350, 70, 17);

        lucro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lucro.setText("0,00");
        lucro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lucroFocusGained(evt);
            }
        });
        lucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lucroActionPerformed(evt);
            }
        });
        lucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lucroKeyPressed(evt);
            }
        });
        getContentPane().add(lucro);
        lucro.setBounds(280, 380, 140, 30);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("CÓDIGO DA VENDA");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(480, 350, 180, 17);

        codigoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoClienteActionPerformed(evt);
            }
        });
        codigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoClienteKeyPressed(evt);
            }
        });
        getContentPane().add(codigoCliente);
        codigoCliente.setBounds(480, 380, 140, 30);

        custoNaMadri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custoNaMadri.setText("0,00");
        custoNaMadri.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                custoNaMadriFocusGained(evt);
            }
        });
        custoNaMadri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoNaMadriActionPerformed(evt);
            }
        });
        custoNaMadri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                custoNaMadriKeyPressed(evt);
            }
        });
        getContentPane().add(custoNaMadri);
        custoNaMadri.setBounds(30, 380, 190, 30);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("PREÇO DE CUSTO NA MADRI");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(30, 350, 210, 17);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("NOVA VENDA");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(260, 10, 320, 60);

        valorLiquidoML.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valorLiquidoML.setText("0,00");
        valorLiquidoML.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorLiquidoMLFocusGained(evt);
            }
        });
        valorLiquidoML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorLiquidoMLActionPerformed(evt);
            }
        });
        valorLiquidoML.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorLiquidoMLKeyPressed(evt);
            }
        });
        getContentPane().add(valorLiquidoML);
        valorLiquidoML.setBounds(480, 300, 140, 30);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("VALOR LÍQUIDO DO MERCADO LIVRE");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(480, 270, 270, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PORCENTAGEM DO MERCADO LIVRE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(480, 190, 270, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 110, 100, 17);

        dataVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dataVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dataVendaFocusGained(evt);
            }
        });
        dataVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataVendaKeyPressed(evt);
            }
        });
        getContentPane().add(dataVenda);
        dataVenda.setBounds(280, 140, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("QUANTIDADE VENDIDA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 110, 190, 17);

        precoVendido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precoVendido.setText("0,00");
        precoVendido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                precoVendidoFocusGained(evt);
            }
        });
        precoVendido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precoVendidoKeyPressed(evt);
            }
        });
        getContentPane().add(precoVendido);
        precoVendido.setBounds(280, 220, 140, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("*");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(230, 330, 40, 60);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(330, 100, 30, 40);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("*");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(660, 110, 20, 22);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("*");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(90, 100, 30, 40);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CÓDIGO");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(30, 110, 70, 17);

        codigoPeca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codigoPeca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codigoPecaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoPecaFocusLost(evt);
            }
        });
        codigoPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoPecaKeyPressed(evt);
            }
        });
        getContentPane().add(codigoPeca);
        codigoPeca.setBounds(30, 140, 130, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MER-LIVRE.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(715, 5, 70, 75);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("OBSERVAÇÕES");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(30, 430, 200, 17);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("TARIFA DO MERCADO LIVRE");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(30, 270, 210, 17);

        cadastroObservacoes.setColumns(20);
        cadastroObservacoes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cadastroObservacoes.setRows(5);
        cadastroObservacoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cadastroObservacoesFocusGained(evt);
            }
        });
        cadastroObservacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cadastroObservacoesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(cadastroObservacoes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 460, 730, 140);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-4, 0, 150, 80);

        tarifaDoML.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tarifaDoML.setText("0,00");
        tarifaDoML.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tarifaDoMLFocusGained(evt);
            }
        });
        tarifaDoML.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tarifaDoMLKeyPressed(evt);
            }
        });
        getContentPane().add(tarifaDoML);
        tarifaDoML.setBounds(30, 300, 140, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("PREÇO DE VENDA");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(280, 190, 150, 17);

        porcentagemDoMercadoLivre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        porcentagemDoMercadoLivre.setText("11,00");
        porcentagemDoMercadoLivre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                porcentagemDoMercadoLivreFocusGained(evt);
            }
        });
        porcentagemDoMercadoLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porcentagemDoMercadoLivreActionPerformed(evt);
            }
        });
        porcentagemDoMercadoLivre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentagemDoMercadoLivreKeyPressed(evt);
            }
        });
        getContentPane().add(porcentagemDoMercadoLivre);
        porcentagemDoMercadoLivre.setBounds(480, 220, 140, 30);

        quantidadeVendida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantidadeVendida.setText("1");
        quantidadeVendida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantidadeVendidaFocusGained(evt);
            }
        });
        quantidadeVendida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantidadeVendidaKeyPressed(evt);
            }
        });
        getContentPane().add(quantidadeVendida);
        quantidadeVendida.setBounds(480, 140, 140, 30);

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
        botaoEntrarIniciall.setBounds(30, 640, 160, 40);

        botaoEntrarIniciall1.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall1.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall1.setText("PESQUISAR");
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
        botaoEntrarIniciall1.setBounds(290, 640, 160, 40);

        nomePeca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomePeca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomePecaFocusGained(evt);
            }
        });
        nomePeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomePecaKeyPressed(evt);
            }
        });
        getContentPane().add(nomePeca);
        nomePeca.setBounds(30, 220, 210, 30);

        valorFrete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valorFrete.setText("0,00");
        valorFrete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valorFreteFocusGained(evt);
            }
        });
        valorFrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorFreteActionPerformed(evt);
            }
        });
        valorFrete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorFreteKeyPressed(evt);
            }
        });
        getContentPane().add(valorFrete);
        valorFrete.setBounds(280, 300, 140, 30);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("VALOR DO FRETE");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(280, 270, 140, 17);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("NOME");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(30, 190, 150, 17);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("*");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(400, 170, 40, 60);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(750, 160, 30, 80);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel12.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel12.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-80, 4, 760, 77);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("*");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(630, 330, 30, 60);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("*");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(90, 170, 30, 60);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PROCURA HEHE.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(430, 610, 80, 70);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("*");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(230, 250, 40, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 4, 760, 77);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setText("*");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(420, 250, 30, 60);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO HEHE.png"))); // NOI18N
        getContentPane().add(jLabel26);
        jLabel26.setBounds(170, 610, 80, 70);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FUNDO AMARELO.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, -331, 810, 430);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RS.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 10, 610, 530);

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

        setBounds(427, 5, 790, 716);
    }// </editor-fold>//GEN-END:initComponents

    private void codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoClienteActionPerformed

    private void codigoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoClienteKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            cadastroObservacoes.requestFocus();
        }
    }//GEN-LAST:event_codigoClienteKeyPressed

    private void custoNaMadriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custoNaMadriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custoNaMadriActionPerformed

    private void custoNaMadriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custoNaMadriKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            codigoCliente.requestFocus();
            custoMadri();
        }
    }//GEN-LAST:event_custoNaMadriKeyPressed

    private void valorLiquidoMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorLiquidoMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorLiquidoMLActionPerformed

    private void valorLiquidoMLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorLiquidoMLKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            custoNaMadri.requestFocus();
        }
    }//GEN-LAST:event_valorLiquidoMLKeyPressed

    private void dataVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataVendaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            quantidadeVendida.requestFocus();
        }
    }//GEN-LAST:event_dataVendaKeyPressed

    private void precoVendidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precoVendidoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            porcentagemDoMercadoLivre.requestFocus();
            valorVendido();
        }
    }//GEN-LAST:event_precoVendidoKeyPressed

    private void codigoPecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoPecaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            dataVenda.requestFocus();
            prencheCod();
        }
    }//GEN-LAST:event_codigoPecaKeyPressed

    private void cadastroObservacoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastroObservacoesKeyPressed

    }//GEN-LAST:event_cadastroObservacoesKeyPressed

    private void tarifaDoMLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tarifaDoMLKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            valorFrete.requestFocus();
            tarifaML();
        }
    }//GEN-LAST:event_tarifaDoMLKeyPressed

    private void porcentagemDoMercadoLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcentagemDoMercadoLivreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porcentagemDoMercadoLivreActionPerformed

    private void porcentagemDoMercadoLivreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentagemDoMercadoLivreKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            tarifaDoML.requestFocus();
            valorVendido();
        }
    }//GEN-LAST:event_porcentagemDoMercadoLivreKeyPressed

    private void quantidadeVendidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeVendidaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            nomePeca.requestFocus();
            valorQuantidade();
        }
    }//GEN-LAST:event_quantidadeVendidaKeyPressed

    private void botaoEntrarIniciallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallActionPerformed
        if(codigoCliente.getText().equals("")||codigoPeca.getText().equals("")||dataVenda.getText().equals("")||quantidadeVendida.getText().equals("")||nomePeca.getText().equals("")||precoVendido.getText().equals("")||porcentagemDoMercadoLivre.getText().equals("")||tarifaDoML.getText().equals("")||valorFrete.getText().equals("")||custoNaMadri.getText().equals("")){
            JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS");
        }
        else{
            adicionar();
        }
    }//GEN-LAST:event_botaoEntrarIniciallActionPerformed

    private void botaoEntrarIniciallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(codigoCliente.getText().equals("")||codigoPeca.getText().equals("")||dataVenda.getText().equals("")||quantidadeVendida.getText().equals("")||nomePeca.getText().equals("")||precoVendido.getText().equals("")||porcentagemDoMercadoLivre.getText().equals("")||tarifaDoML.getText().equals("")||valorFrete.getText().equals("")||custoNaMadri.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA TODOS OS CAMPOS OBRIGATÓRIOS");
            }
            else{
                adicionar();
            }
        }
    }//GEN-LAST:event_botaoEntrarIniciallKeyPressed

    private void botaoEntrarIniciall1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall1ActionPerformed
        LocalizarVendas verifica = new LocalizarVendas();
        verifica.setVisible(true);
        verifica.mostrarNivel.setText(mostrarNivel.getText());
        verifica.acessoUser.setText(acessoUser.getText());
    }//GEN-LAST:event_botaoEntrarIniciall1ActionPerformed

    private void botaoEntrarIniciall1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciall1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            LocalizarVendas verifica = new LocalizarVendas();
            verifica.setVisible(true);
            verifica.mostrarNivel.setText(mostrarNivel.getText());
            verifica.acessoUser.setText(acessoUser.getText());
        }
    }//GEN-LAST:event_botaoEntrarIniciall1KeyPressed

    private void nomePecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePecaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            precoVendido.requestFocus();
        }
    }//GEN-LAST:event_nomePecaKeyPressed

    private void valorFreteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorFreteKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            custoNaMadri.requestFocus();
            valorVendido();
        }
    }//GEN-LAST:event_valorFreteKeyPressed

    private void valorFreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorFreteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorFreteActionPerformed

    private void codigoPecaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoPecaFocusLost
       
    }//GEN-LAST:event_codigoPecaFocusLost
    int x=0;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(x==0){
            x++;
            pegaData();
        }
    }//GEN-LAST:event_formWindowActivated

    private void lucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lucroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lucroActionPerformed

    private void lucroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lucroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lucroKeyPressed

    private void cadastroObservacoesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cadastroObservacoesFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroObservacoesFocusGained

    private void codigoPecaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoPecaFocusGained
        codigoPeca.selectAll();
    }//GEN-LAST:event_codigoPecaFocusGained

    private void dataVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataVendaFocusGained
        dataVenda.selectAll();
    }//GEN-LAST:event_dataVendaFocusGained

    private void quantidadeVendidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadeVendidaFocusGained
        quantidadeVendida.selectAll();
    }//GEN-LAST:event_quantidadeVendidaFocusGained

    private void nomePecaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomePecaFocusGained
        nomePeca.selectAll();
    }//GEN-LAST:event_nomePecaFocusGained

    private void precoVendidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precoVendidoFocusGained
        precoVendido.selectAll();
    }//GEN-LAST:event_precoVendidoFocusGained

    private void porcentagemDoMercadoLivreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_porcentagemDoMercadoLivreFocusGained
        porcentagemDoMercadoLivre.selectAll();
    }//GEN-LAST:event_porcentagemDoMercadoLivreFocusGained

    private void tarifaDoMLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarifaDoMLFocusGained
        tarifaDoML.selectAll();
    }//GEN-LAST:event_tarifaDoMLFocusGained

    private void valorFreteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorFreteFocusGained
        valorFrete.selectAll();
    }//GEN-LAST:event_valorFreteFocusGained

    private void valorLiquidoMLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorLiquidoMLFocusGained
        valorLiquidoML.selectAll();
    }//GEN-LAST:event_valorLiquidoMLFocusGained

    private void custoNaMadriFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custoNaMadriFocusGained
        custoNaMadri.selectAll();
    }//GEN-LAST:event_custoNaMadriFocusGained

    private void lucroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lucroFocusGained
        lucro.selectAll();
    }//GEN-LAST:event_lucroFocusGained
    
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
            java.util.logging.Logger.getLogger(NovaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JButton botaoEntrarIniciall;
    private javax.swing.JButton botaoEntrarIniciall1;
    private javax.swing.JTextArea cadastroObservacoes;
    public static javax.swing.JTextField codigoCliente;
    private javax.swing.JTextField codigoPeca;
    public static javax.swing.JTextField custoNaMadri;
    private javax.swing.JTextField dataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField lucro;
    public static javax.swing.JLabel mostrarNivel;
    private javax.swing.JTextField nomePeca;
    private javax.swing.JTextField porcentagemDoMercadoLivre;
    private javax.swing.JTextField precoVendido;
    private javax.swing.JTextField quantidadeVendida;
    private javax.swing.JTextField tarifaDoML;
    private javax.swing.JTextField valorFrete;
    private javax.swing.JTextField valorLiquidoML;
    // End of variables declaration//GEN-END:variables
}
