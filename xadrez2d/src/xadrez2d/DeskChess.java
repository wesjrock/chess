//Nome: WESLEY TIOZZO
//NUMERO USP: 8077925
//PROFESSOR: JOAO BATISTA
//DISCIPLINA DE PROGRAMACAO ORIENTADA A OBJETOS
//USP - ICMC SAO CARLOS


package xadrez2d;

import java.util.logging.Level;
import java.util.logging.Logger;
import xadrez.view.DeskChessFrame;

public class DeskChess
{
    private static DeskChessFrame frame;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    frame = new DeskChessFrame();
                }catch(Exception ex){
                    System.out.println("erro na inicialização!");
                }
                    frame.setVisible(true);
                    frame.atualizar();
            }
        });
    }
    
    public static DeskChessFrame getFrame(){
        return frame;
    }

}
