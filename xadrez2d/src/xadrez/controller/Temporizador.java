/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xadrez.controller;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JPanel;

//a classe Temporizador controla as operações agendadas: autosave, relogio principal
//a classe Temporizador controla as operações não agendadas: tempo de jogada do jogador atual
// - atualizacao do painel de jogo
// -outros
public class Temporizador{
    //private MP3Player mp3pl = new MP3Player();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
    
    private final Runnable timerAutosave;
    private final Runnable timerUmSegundo;
    
    private final ScheduledFuture<?> AutoSaveHandle;
    private final ScheduledFuture<?> RelogioPrincipalHandle;
            
    /**
     *
     */
    public Temporizador(){
        //DEFINE TAREFA DE AUTOSAVE
        this.timerAutosave = new Runnable() {
                @Override
                public void run() { 
                    Tabuleiro.autosave(); 
                }
            };
        //DEFINE FREQUENCIA DA EXECUCAO DA TAREFA ACIMA E A LIGA COM O SCHEDULER
        this.AutoSaveHandle = scheduler.scheduleAtFixedRate(timerAutosave, 5, 10, TimeUnit.SECONDS);    
        
        
        //DEFINE TAREFA DE incrementar o relogio principal
        this.timerUmSegundo = new Runnable() {
                @Override
                public void run() { 
                    Tabuleiro.incrementaRelogioPrincipal(); 
                    Tabuleiro.incrementaRelogioJogador(); 
                }
            };
        //DEFINE FREQUENCIA DA EXECUCAO DA TAREFA ACIMA E A LIGA COM O SCHEDULER
        this.RelogioPrincipalHandle = scheduler.scheduleAtFixedRate(timerUmSegundo, 1000, 1, TimeUnit.MILLISECONDS); 
//        this.RelogioPrincipalHandle = scheduler.scheduleAtFixedRate(timerUmSegundo, 1, 1, TimeUnit.SECONDS); 
        
    }
    
	 
}
 
