/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mklivre;

/**
 *
 * @author willi
 */
public class RendaMensal extends javax.swing.JFrame {

    /**
     * Creates new form RendaMensal
     */
    public RendaMensal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botNovo = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        apagarVenda = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        percaElucro = new javax.swing.JLabel();
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
        localicarPecas = new javax.swing.JButton();
        nomePeca = new javax.swing.JTextField();
        valorFrete = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mostrarNivel = new javax.swing.JLabel();
        acessoUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RENDA MENSAL");
        setResizable(false);
        getContentPane().setLayout(null);

        botNovo.setBackground(new java.awt.Color(0, 0, 0));
        botNovo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botNovo.setForeground(new java.awt.Color(255, 255, 255));
        botNovo.setText("NOVO");
        botNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNovoActionPerformed(evt);
            }
        });
        botNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botNovoKeyPressed(evt);
            }
        });
        getContentPane().add(botNovo);
        botNovo.setBounds(30, 640, 110, 40);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO HEHE.png"))); // NOI18N
        getContentPane().add(jLabel27);
        jLabel27.setBounds(120, 610, 80, 70);

        apagarVenda.setBackground(new java.awt.Color(0, 0, 0));
        apagarVenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        apagarVenda.setForeground(new java.awt.Color(255, 255, 255));
        apagarVenda.setText("APAGAR");
        apagarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarVendaActionPerformed(evt);
            }
        });
        apagarVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apagarVendaKeyPressed(evt);
            }
        });
        getContentPane().add(apagarVenda);
        apagarVenda.setBounds(370, 640, 110, 40);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/APAGAR.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(460, 610, 80, 70);

        percaElucro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        percaElucro.setForeground(new java.awt.Color(255, 255, 255));
        percaElucro.setText("LUCRO");
        getContentPane().add(percaElucro);
        percaElucro.setBounds(590, 340, 130, 17);

        lucro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lucro.setText("0,00");
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
        lucro.setBounds(590, 370, 140, 30);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("CÓDIGO DA VENDA");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(30, 100, 180, 17);

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
        codigoCliente.setBounds(30, 130, 140, 30);

        custoNaMadri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custoNaMadri.setText("0,00");
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
        custoNaMadri.setBounds(340, 370, 140, 30);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("PREÇO DE CUSTO");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(340, 340, 210, 17);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("RENDA MENSAL");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(230, 10, 320, 60);

        valorLiquidoML.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valorLiquidoML.setText("0,00");
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
        valorLiquidoML.setBounds(30, 370, 140, 30);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("VALOR LÍQUIDO DO MERCADO LIVRE");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(30, 340, 270, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PORCENTAGEM DO MERCADO LIVRE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 260, 270, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 180, 100, 17);

        dataVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dataVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dataVendaKeyPressed(evt);
            }
        });
        getContentPane().add(dataVenda);
        dataVenda.setBounds(30, 210, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("QUANTIDADE VENDIDA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(340, 180, 190, 17);

        precoVendido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precoVendido.setText("0,00");
        precoVendido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precoVendidoKeyPressed(evt);
            }
        });
        getContentPane().add(precoVendido);
        precoVendido.setBounds(590, 210, 140, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CÓDIGO");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(340, 100, 70, 17);

        codigoPeca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codigoPeca.addFocusListener(new java.awt.event.FocusAdapter() {
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
        codigoPeca.setBounds(340, 130, 130, 30);

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
        jLabel20.setBounds(340, 260, 210, 17);

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
        jScrollPane1.setBounds(30, 460, 730, 140);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sem título.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-4, 0, 150, 80);

        tarifaDoML.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tarifaDoML.setText("0,00");
        tarifaDoML.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tarifaDoMLKeyPressed(evt);
            }
        });
        getContentPane().add(tarifaDoML);
        tarifaDoML.setBounds(340, 290, 140, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("PREÇO DE VENDA");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(590, 180, 150, 17);

        porcentagemDoMercadoLivre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        porcentagemDoMercadoLivre.setText("11,00");
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
        porcentagemDoMercadoLivre.setBounds(30, 290, 140, 30);

        quantidadeVendida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantidadeVendida.setText("1");
        quantidadeVendida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantidadeVendidaKeyPressed(evt);
            }
        });
        getContentPane().add(quantidadeVendida);
        quantidadeVendida.setBounds(340, 210, 140, 30);

        botaoEntrarIniciall.setBackground(new java.awt.Color(0, 0, 0));
        botaoEntrarIniciall.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoEntrarIniciall.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrarIniciall.setText("EDITAR");
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
        botaoEntrarIniciall.setBounds(200, 640, 110, 40);

        localicarPecas.setBackground(new java.awt.Color(0, 0, 0));
        localicarPecas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        localicarPecas.setForeground(new java.awt.Color(255, 255, 255));
        localicarPecas.setText("PESQUISAR");
        localicarPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localicarPecasActionPerformed(evt);
            }
        });
        localicarPecas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                localicarPecasKeyPressed(evt);
            }
        });
        getContentPane().add(localicarPecas);
        localicarPecas.setBounds(550, 640, 160, 40);

        nomePeca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomePeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomePecaKeyPressed(evt);
            }
        });
        getContentPane().add(nomePeca);
        nomePeca.setBounds(590, 130, 130, 30);

        valorFrete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valorFrete.setText("0,00");
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
        valorFrete.setBounds(590, 290, 140, 30);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("VALOR DO FRETE");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(590, 260, 140, 17);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("NOME");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(590, 100, 150, 17);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel12.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel12.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-80, 4, 760, 77);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PROCURA HEHE.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(690, 610, 80, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo preto.png"))); // NOI18N
        jLabel1.setMinimumSize(new java.awt.Dimension(1057, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(1057, 350));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 4, 760, 77);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EDIT.png"))); // NOI18N
        getContentPane().add(jLabel26);
        jLabel26.setBounds(290, 610, 80, 70);

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

        setSize(new java.awt.Dimension(792, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botNovoActionPerformed
        NovaVenda tudo = new NovaVenda();
        tudo.setVisible(true);
        tudo.mostrarNivel.setText(mostrarNivel.getText());
        tudo.acessoUser.setText(acessoUser.getText());
        this.dispose();
    }//GEN-LAST:event_botNovoActionPerformed

    private void botNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botNovoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            NovaVenda tudo = new NovaVenda();
            tudo.setVisible(true);
            tudo.mostrarNivel.setText(mostrarNivel.getText());
            tudo.acessoUser.setText(acessoUser.getText());
            this.dispose();
        }
    }//GEN-LAST:event_botNovoKeyPressed

    private void apagarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarVendaActionPerformed
        
    }//GEN-LAST:event_apagarVendaActionPerformed

    private void apagarVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apagarVendaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            
        }
    }//GEN-LAST:event_apagarVendaKeyPressed

    private void lucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lucroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lucroActionPerformed

    private void lucroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lucroKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            cadastroObservacoes.requestFocus();
        }
    }//GEN-LAST:event_lucroKeyPressed

    private void codigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoClienteActionPerformed

    private void codigoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoClienteKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            codigoPeca.requestFocus();
        }
    }//GEN-LAST:event_codigoClienteKeyPressed

    private void custoNaMadriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custoNaMadriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custoNaMadriActionPerformed

    private void custoNaMadriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custoNaMadriKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            cadastroObservacoes.requestFocus();
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
        }
    }//GEN-LAST:event_precoVendidoKeyPressed

    private void codigoPecaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoPecaFocusLost

    }//GEN-LAST:event_codigoPecaFocusLost

    private void codigoPecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoPecaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            nomePeca.requestFocus();
        }
    }//GEN-LAST:event_codigoPecaKeyPressed

    private void cadastroObservacoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastroObservacoesKeyPressed

    }//GEN-LAST:event_cadastroObservacoesKeyPressed

    private void tarifaDoMLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tarifaDoMLKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            valorFrete.requestFocus();
        }
    }//GEN-LAST:event_tarifaDoMLKeyPressed

    private void porcentagemDoMercadoLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcentagemDoMercadoLivreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porcentagemDoMercadoLivreActionPerformed

    private void porcentagemDoMercadoLivreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentagemDoMercadoLivreKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            tarifaDoML.requestFocus();
        }
    }//GEN-LAST:event_porcentagemDoMercadoLivreKeyPressed

    private void quantidadeVendidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeVendidaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            precoVendido.requestFocus();
        }
    }//GEN-LAST:event_quantidadeVendidaKeyPressed

    private void botaoEntrarIniciallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallActionPerformed
        EditarVenda verifica = new EditarVenda();
        verifica.setVisible(true);
        verifica.mostrarNivel.setText(mostrarNivel.getText());
        verifica.acessoUser.setText(acessoUser.getText());
        verifica.codigoCliente.setText(codigoCliente.getText());
        this.dispose();
    }//GEN-LAST:event_botaoEntrarIniciallActionPerformed

    private void botaoEntrarIniciallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarIniciallKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            EditarVenda verifica = new EditarVenda();
            verifica.setVisible(true);
            verifica.mostrarNivel.setText(mostrarNivel.getText());
            verifica.acessoUser.setText(acessoUser.getText());
            verifica.codigoCliente.setText(codigoCliente.getText());
            this.dispose();
        }
    }//GEN-LAST:event_botaoEntrarIniciallKeyPressed

    private void localicarPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localicarPecasActionPerformed
        LocalizarVendas verifica = new LocalizarVendas();
        verifica.setVisible(true);
        verifica.mostrarNivel.setText(mostrarNivel.getText());
        verifica.acessoUser.setText(acessoUser.getText());
        this.dispose();
    }//GEN-LAST:event_localicarPecasActionPerformed

    private void localicarPecasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localicarPecasKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            LocalizarVendas verifica = new LocalizarVendas();
            verifica.setVisible(true);
            verifica.mostrarNivel.setText(mostrarNivel.getText());
            verifica.acessoUser.setText(acessoUser.getText());
            this.dispose();
        }
    }//GEN-LAST:event_localicarPecasKeyPressed

    private void nomePecaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePecaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            dataVenda.requestFocus();
        }
    }//GEN-LAST:event_nomePecaKeyPressed

    private void valorFreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorFreteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorFreteActionPerformed

    private void valorFreteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorFreteKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            custoNaMadri.requestFocus();
        }
    }//GEN-LAST:event_valorFreteKeyPressed

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
            java.util.logging.Logger.getLogger(RendaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RendaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RendaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RendaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RendaMensal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acessoUser;
    private javax.swing.JButton apagarVenda;
    private javax.swing.JButton botNovo;
    private javax.swing.JButton botaoEntrarIniciall;
    public static javax.swing.JTextArea cadastroObservacoes;
    public static javax.swing.JTextField codigoCliente;
    public static javax.swing.JTextField codigoPeca;
    public static javax.swing.JTextField custoNaMadri;
    public static javax.swing.JTextField dataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton localicarPecas;
    public static javax.swing.JTextField lucro;
    public static javax.swing.JLabel mostrarNivel;
    public static javax.swing.JTextField nomePeca;
    public static javax.swing.JLabel percaElucro;
    public static javax.swing.JTextField porcentagemDoMercadoLivre;
    public static javax.swing.JTextField precoVendido;
    public static javax.swing.JTextField quantidadeVendida;
    public static javax.swing.JTextField tarifaDoML;
    public static javax.swing.JTextField valorFrete;
    public static javax.swing.JTextField valorLiquidoML;
    // End of variables declaration//GEN-END:variables
}