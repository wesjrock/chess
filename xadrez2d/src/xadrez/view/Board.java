/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez.view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import xadrez.controller.Tabuleiro;
import xadrez.model.Peca;

/**
 *
 * @author felipelageduarte
 */
public class Board extends JPanel
{
    private static int squareSize;
    private String path = "src/xadrez/images/";
    
    public Board() throws Exception
    {
        super();
        Tabuleiro.inicializaTabuleiro();
    }

    @Override //sobrescrita do metodo paintComponent da classe JPanel
    protected void paintComponent(Graphics g)
    {
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.WHITE);
        g2.setColor(Color.LIGHT_GRAY);

        float maxWidth = this.getWidth();
        float maxHeight = this.getHeight();
        float boardSize = (maxWidth < maxHeight) ? maxWidth : maxHeight;
        squareSize = Math.round(boardSize/8.0f);
                
        //preenche tabuleiro com casas pretas e brancas
        for(int i = 0; i<8; ++i){
            for(int j = 0; j<8; ++j){
                //varia a cor do quadrante
                if (g2.getColor() == Color.WHITE)
                {
                    g2.setColor(Color.LIGHT_GRAY);
                } else
                {
                    g2.setColor(Color.WHITE);
                }

                //Desenha um quadrado do tabuleiro
                g2.fillRect(i*squareSize,j*squareSize,(i*squareSize)+squareSize, (j*squareSize)+squareSize);
            }

            if (g2.getColor() == Color.WHITE)
            {
                g2.setColor(Color.LIGHT_GRAY);
            } else
            {
                g2.setColor(Color.WHITE);
            }
        }
        
        
        //desenha peca (ou não)
        for(int i = 0; i<8; ++i){
            for(int j = 0; j<8; ++j){
                Peca peca_temp = Tabuleiro.getPeca(i+1, j+1);
                if(peca_temp != null){
                    //testa se é a peca selecionada no momento
                    if(Tabuleiro.getPosicaoOrigem() != null 
                            && peca_temp.getPosition().getX() == Tabuleiro.getPosicaoOrigem().getX()
                            && peca_temp.getPosition().getY() == Tabuleiro.getPosicaoOrigem().getY()
                            ){
                        //colore o fundo da peca selecionada no momento
                        g2.setColor(Color.GREEN);
                        g2.fillRect(i*squareSize,j*squareSize,squareSize, squareSize);
                        
                        //colore os movimentos possiveis desta peca
                        peca_temp.calculaMovimentosPossiveis();
                        for(int k = 0; k < peca_temp.getMovimentosPossiveis().size(); k++){
                            Point movimento_possivel = peca_temp.getMovimentosPossiveis().get(k);
                            g2.setColor(Color.YELLOW);
                            g2.fillRect(
                                    (int) (movimento_possivel.getX()-1)*squareSize,
                                    (int) (movimento_possivel.getY()-1)*squareSize,
                                    (int) squareSize,
                                    (int) squareSize);
                        }
                    }
                    
                    try{
                        this.desenhaImage(g, this.path+peca_temp.getNomeArquivo(), i, j);
                    }catch(IOException ex){
                        System.out.printf("IO Exception"+ex.getMessage());
                        
                        //desenha imagem alternativa
                        
                        //DESENHA FUNDO (CIRCULO)
                        if(peca_temp.isBranco()){
                            g2.setColor(Color.ORANGE);
                        }else{
                            g2.setColor(Color.BLACK);
                        }
                        g2.fillOval(i*squareSize+8,j*squareSize+8,squareSize-16, squareSize-16);
                        
                        //desenha texto
                        int text_x_offset = squareSize/2 -12;
                        int text_y_offset = squareSize/2 +4;
                        if(peca_temp.isBranco()){
                            g2.setColor(Color.BLACK);
                        }else{
                            g2.setColor(Color.WHITE);
                        }
                        FontMetrics fm = g.getFontMetrics(g.getFont());
                        g2.drawString(peca_temp.getMyTag(), i*squareSize + text_x_offset, (j*squareSize)+text_y_offset);
                        
                    }
                    
                    
                }
            }
        }
        
        
    }
    
    public static int getSquareSize(){
        return squareSize;
    }

    private void desenhaImage(Graphics g, String image_location, int i, int j) throws IOException {
//        Image image_temp = new ImageIcon(image_location).getImage();
        ImageIcon image_temp = new ImageIcon(image_location);
        switch(image_temp.getImageLoadStatus()){
            case MediaTracker.COMPLETE:
                System.out.println("Image Loaded OK");
                Image image = image_temp.getImage();
                g.drawImage(image, i*squareSize, j*squareSize, 80, 80, null);
                break;
            default:
                System.out.println("Image DID NOT Loaded OK");
                throw new IOException("Imagem não encontrada em " + image_location);
//                break;
        }
//        if(image_temp != null){
//        }else{
//            throw new IOException("Imagem não encontrada em " + image_location);
//        }
    }

}
