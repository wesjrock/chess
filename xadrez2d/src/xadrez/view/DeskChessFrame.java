/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import xadrez.controller.SystemLog;
import xadrez.controller.Tabuleiro;
import xadrez2d.DeskChess;


public class DeskChessFrame extends javax.swing.JFrame  {

    /**
     * Creates new form DeskChessFrame
     */
    public static Board board;
    public static SystemLog systemlog; 
    
    public DeskChessFrame() throws Exception {
        systemlog = SystemLog.getInstance(); //SINGLETON
        
        setVisible(true);
        initComponents();
        atualizarLabelVezDoJogador();
        
        board = new Board();
        
        systemlog.escreveEmArquivo("Iniciando Frame...", "info");
        Dimension area = new Dimension(boardPanel.getWidth(), boardPanel.getHeight());
        board.setPreferredSize(area);//set dimensao do painel de desenho
        board.setBackground(Color.WHITE);//set cor de fundo        
        systemlog.escreveEmArquivo("Iniciando Listeners...", "info");
        board.addMouseListener((MouseListener) new Listener());//Adiciona evento de mouse ao Painel
        board.addMouseMotionListener((MouseMotionListener) new Listener());//Adiciona evento de mouse ao Painel
        systemlog.escreveEmArquivo("Iniciando Panels...", "info");
        this.boardPanel.setLayout(new GridLayout(1, 1));
        this.boardPanel.add(board);  
    }
    
    private void sair(){
        systemlog.escreveEmArquivo("Botão sair apertado. Criando janela de confirmação...", "info");
        Object[] options = {"Sim",
                    "Não"};
        int n = JOptionPane.showOptionDialog(this,
            "Você tem certeza que quer sair?",
            "Sair",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[1]); //default button title
        
        
        if(n == JOptionPane.YES_OPTION){
            systemlog.escreveEmArquivo("Saída confirmada  pelo usuário. Encerrando programa..", "info");
            System.out.println("Bye!!!");
            System.exit(0);
        }else{
            systemlog.escreveEmArquivo("Saída cancelada pelo usuário.", "info");
            System.out.println("Obrigado por ficar!!!");
    }
    
    }
    private void novo_jogo(){
        systemlog.escreveEmArquivo("Botão Novo Jogo apertado. Criando janela de confirmação...", "info");
        
        Object[] options = {"Sim",
                    "Não"};
        int n = JOptionPane.showOptionDialog(
                DeskChess.getFrame(),
            "Você tem certeza que quer SAIR DO JOGO ATUAL e INICIAR UM NOVO JOGO?",
            "Novo Jogo",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[1]); //default button title
        
        
        if(n == JOptionPane.YES_OPTION){
            systemlog.escreveEmArquivo("Confirmação recebida do usuário. Criando novo jogo...", "info");
            System.out.println("Novo Jogo!!!");
            DeskChess.getFrame().dispose();
            DeskChess.main(new String[0]);
        }else{
            systemlog.escreveEmArquivo("Criação de Novo Jogo não confirmada pelo usuário.", "info");
            System.out.println("Você que manda!!! =)");
        }
        
    }
    
    private void initComponents() {
        boardPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton("Deitar Rei");
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jtexarea_log = new javax.swing.JTextArea(5, 3);
        jscrollpane_log = new javax.swing.JScrollPane(jtexarea_log);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Meu Xadrez");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        boardPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout boardPanelLayout = new javax.swing.GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        boardPanelLayout.setVerticalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));;
        
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));;
        
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));;
        
        jButton2.addActionListener(new Listener());

        jLabel3.setText("Aluno: Wesley Tiozzo");
        
        jtexarea_log.setText("Log de movimentos:");
        jtexarea_log.setEditable(false);
        jtexarea_log.setLineWrap(true);
        jtexarea_log.setBorder(new BevelBorder(BevelBorder.LOWERED));

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        
        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Novo Jogo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        
        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Desfazer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        
        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Refazer");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        
        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Salvar Jogo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        
        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem6.setText("Salvar Jogo Como...");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);
        
        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Carregar Jogo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        
        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem8.setText("Carregar Jogo Como...");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);
//        
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
//        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jscrollpane_log, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                )
                        .addGap(0, 10, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(jscrollpane_log)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(boardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        atualizaRelogioPrincipal();
        atualizaRelogioJogador();
        
        pack();
        pack();
    }// </editor-fold>                        

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.sair();             
    } 
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.novo_jogo();
    }                                  
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {   
        systemlog.escreveEmArquivo("Desfazendo jogada...", "info");
        Tabuleiro.undo();
        this.boardPanel.repaint();
        this.atualizar();
    }                                  
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {      
        systemlog.escreveEmArquivo("Refazendo Jogada...", "info");
        Tabuleiro.redo();
        this.boardPanel.repaint();
        this.atualizar();
    }                                  
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //salvar jogo
        systemlog.escreveEmArquivo("Salvando jogo em \"./salvar.txt\"", "info");
        System.out.println("salvando...");
        Tabuleiro.salvar("./salvar.txt");
    }                                  
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //salvar jogo como...
        System.out.println("salvar como...");
        systemlog.escreveEmArquivo("Abrindo janela de escolha de local para salvar o jogo...", "info");
        
        JFileChooser saveFile = new JFileChooser();
        int returnVal = saveFile.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            systemlog.escreveEmArquivo("Salvando jogo em "+saveFile.getSelectedFile().getAbsolutePath(), "info");
            Tabuleiro.salvar(saveFile.getSelectedFile().getAbsolutePath());
            boardPanel.repaint();
        }
        
    }                                  
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {  
        //carregar jogo
        systemlog.escreveEmArquivo("Carregando jogo de \"./salvar.txt\"", "info");
        System.out.println("carregando...");
        Tabuleiro.carregar("./salvar.txt");
        boardPanel.repaint();
    }                                  
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {  
        //carregar jogo
        systemlog.escreveEmArquivo("Carregando jogo como... (Abrindo caixa para escolha do local do arquivo)", "info");
//        System.out.println("carregando como...");
        JFileChooser loadFile = new JFileChooser();
        int returnVal = loadFile.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            systemlog.escreveEmArquivo("Carregando jogo de "+loadFile.getSelectedFile().getAbsolutePath(), "info");
            Tabuleiro.carregar(loadFile.getSelectedFile().getAbsolutePath());
            boardPanel.repaint();
        }
    }                                  

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        this.sair();
    }   
    
    public void atualizarLabelVezDoJogador(){
        systemlog.escreveEmArquivo("Atualizando painel do jogo para indicar o jogador da vez...", "info");
        if(Tabuleiro.isRodadaJogadorBranco()){
            jLabel1.setText("BRANCO");
            jLabel1.setBackground(Color.white);
            jLabel1.setForeground(Color.black);
        }else{
            jLabel1.setText("PRETO");
            jLabel1.setBackground(Color.black);
            jLabel1.setForeground(Color.white);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel boardPanel;
    private javax.swing.JLabel jLabel1;//label branco/preto
    private javax.swing.JLabel jLabel2;//relogio principal
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;//relogio jogador
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JTextArea jtexarea_log;
    private javax.swing.JScrollPane  jscrollpane_log;
    // End of variables declaration                   

    public void atualizar() {
        this.atualizarLabelVezDoJogador();
    }
    public void adicionarAoLog(String msg){
        this.jtexarea_log.setText(this.jtexarea_log.getText()+"\n\n"+msg);
    }

    public void atualizaRelogioPrincipal() {
        String tempo = Tabuleiro.getTempoJogo();
        jLabel2.setText("Tempo Jogo: "+tempo);
//        System.out.println("tempo jogo: "+tempo);
    }

    public void atualizaRelogioJogador() {
        String tempo = Tabuleiro.getTempoJogador();
        jLabel4.setText("Tempo Jogador: "+tempo);
//        System.out.println("tempo jogador: "+tempo);
    }
    
    public static SystemLog getSystemLog(){
        return systemlog;
    }

}
