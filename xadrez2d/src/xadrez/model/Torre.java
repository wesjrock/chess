package xadrez.model;

import java.awt.Point;
import java.util.ArrayList;
import xadrez.controller.IlegalChessMovement;
import xadrez.controller.Tabuleiro;

public class Torre extends Peca {
    
    
    public Torre(){
        super();
    }
    public Torre(Peca peca){
        super(peca);
    }
    public Torre(Point posicao, boolean eh_branco) throws IlegalChessMovement {
        super(posicao, eh_branco);
        this.setNomeArquivo("torre_" + (eh_branco ? "branco" : "preto") + ".png");
        setTipo_peca("torre");
    }
    public Torre(PecaJSON peca_json) {
        super(peca_json);
    }

    

    @Override
    public void calculaMovimentosPossiveis() {
        this.movimentos_possiveis = new ArrayList<Point>();
        Point p_temp;

        //movimento da torre para a direita
        p_temp = new Point((int) this.getPosition().getX() + 1, (int) this.getPosition().getY());
        if (Peca.estaDentroDoTabuleiro(p_temp)) {
            while (Tabuleiro.getPeca(p_temp) == null && Peca.estaDentroDoTabuleiro(p_temp)) {
                this.movimentos_possiveis.add(new Point(p_temp));
                p_temp.setLocation(p_temp.getX() + 1, p_temp.getY());
            }
            if (Peca.estaDentroDoTabuleiro(p_temp)
                    && Tabuleiro.getPeca(p_temp) != null
//                    && Tabuleiro.getPeca(p_temp).isBranco() != Tabuleiro.isRodadaJogadorBranco()) { //teste para saber se a peca eh amiga ou inimiga
                    && Tabuleiro.getPeca(p_temp).isBranco() != this.isBranco()) { //teste para saber se a peca eh amiga ou inimiga
                movimentos_possiveis.add(new Point(p_temp));
            }
        }
        
        //movimento da torre para a esquerda
        p_temp = new Point((int) this.getPosition().getX() - 1, (int) this.getPosition().getY());
        if (Peca.estaDentroDoTabuleiro(p_temp)) {
            while (Tabuleiro.getPeca(p_temp) == null && Peca.estaDentroDoTabuleiro(p_temp)) {
                this.movimentos_possiveis.add(new Point(p_temp));
                p_temp.setLocation(p_temp.getX() - 1, p_temp.getY());
            }
            if (Peca.estaDentroDoTabuleiro(p_temp)
                    && Tabuleiro.getPeca(p_temp) != null
                    && Tabuleiro.getPeca(p_temp).isBranco() != this.isBranco()) { //teste para saber se a peca eh amiga ou inimiga
                movimentos_possiveis.add(new Point(p_temp));
            }
        }
        
        //movimento da torre para a cima
        p_temp = new Point((int) this.getPosition().getX() , (int) this.getPosition().getY() - 1);
        if (Peca.estaDentroDoTabuleiro(p_temp)) {
            while (Tabuleiro.getPeca(p_temp) == null && Peca.estaDentroDoTabuleiro(p_temp)) {
                this.movimentos_possiveis.add(new Point(p_temp));
                p_temp.setLocation(p_temp.getX() , p_temp.getY() -1);
            }
            if (Peca.estaDentroDoTabuleiro(p_temp)
                    && Tabuleiro.getPeca(p_temp) != null
                    && Tabuleiro.getPeca(p_temp).isBranco() != this.isBranco()) { //teste para saber se a peca eh amiga ou inimiga
                 movimentos_possiveis.add(new Point(p_temp));
            }
        }
        //movimento da torre para a baixo
        p_temp = new Point((int) this.getPosition().getX() , (int) this.getPosition().getY() +1);
        if (Peca.estaDentroDoTabuleiro(p_temp)) {
            while (Tabuleiro.getPeca(p_temp) == null && Peca.estaDentroDoTabuleiro(p_temp)) {
                this.movimentos_possiveis.add(new Point(p_temp));
                p_temp.setLocation(p_temp.getX() , p_temp.getY()+1);
            }
            if (Peca.estaDentroDoTabuleiro(p_temp)
                    && Tabuleiro.getPeca(p_temp) != null
                    && Tabuleiro.getPeca(p_temp).isBranco() != this.isBranco()) { //teste para saber se a peca eh amiga ou inimiga
                movimentos_possiveis.add(new Point(p_temp));
            }
        }
    }
}
