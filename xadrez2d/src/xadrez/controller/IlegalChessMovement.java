/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xadrez.controller;

import java.awt.Point;

/**
 *
 * @author Wesley
 */
public class IlegalChessMovement extends Exception{
    private Point origem, destino;
    
    public IlegalChessMovement() {
        this("Movimento Ilegal",null,null);
    }
    public IlegalChessMovement(String msg) {
        this(msg,null,null);
    }
    public IlegalChessMovement(Point origem, Point destino) {
        this("Movimento Ilegal",origem, destino);
    }
    public IlegalChessMovement(String msg, Point origem, Point destino) {
        super(msg);
        this.origem = origem;
        this.destino = destino;
    }

}
