/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez.controller;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.*;
import xadrez.model.Peca;
import xadrez.model.PecaJSON;
import xadrez.view.DeskChessFrame;

public class Arquivo {

    public static boolean escreveEmArquivo(String conteudo, String file_loc) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file_loc));
            writer.write(conteudo);

        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    public static String leDeArquivo(String file_loc) throws IOException {
        InputStream inputstream;
        try {
            inputstream = new FileInputStream(file_loc);
        } catch (FileNotFoundException ex) {
             DeskChessFrame.getSystemLog().escreveEmArquivo("Arquivo não encontrado em "+file_loc, "error");
            System.out.println("FILE NOT FOUND IN " + file_loc);
            return null;
        }
        StringBuilder sb = new StringBuilder(Math.max(16, inputstream.available()));
        char[] tmp = new char[8000];

        try {
            InputStreamReader reader = new InputStreamReader(inputstream, "UTF-8");
            for (int cnt; (cnt = reader.read(tmp)) > 0;) {
                sb.append(tmp, 0, cnt);
            }
        } finally {
            inputstream.close();
        }
        return sb.toString();
    }

//    public static ArrayList<ArrayList> jsonDecodeJogo(String json_str) {
    public static ArrayList<Peca> jsonDecodeJogo(String json_str) {
        ArrayList<PecaJSON> jogo_salvo = new ArrayList<PecaJSON>();
        ArrayList<LinkedTreeMap> temp_json;
        ArrayList<Peca> jogo_salvo_return = new ArrayList<Peca>();
        
        Gson gson = new Gson();
        
        //transforma string em arraylist de LinkedTreeMap
        temp_json = gson.fromJson(json_str, ArrayList.class);
        
        //CONVERTE os LinkedTreeMap's para PecaJSON (Peca nao eh usada pq eh uma classe abstrata e nao pode ser instanciada
//        for(int i=0; i<temp_json.size(); i++){
        for(LinkedTreeMap peca: temp_json){
            jogo_salvo.add(gson.fromJson(peca.toString(), PecaJSON.class));
//            jogo_salvo.add(gson.fromJson(temp_json.get(i).toString(), PecaJSON.class));
        }
        
        //converte os objetos do tipo PecaJSON para serem do tipo Peca
        for(PecaJSON peca :jogo_salvo){
            jogo_salvo_return.add(Peca.pecaFactory(peca));
        }
        
        return jogo_salvo_return;
    }

    public static String jsonEncodeJogo() {
        System.out.println("JSON encoding...");
        Gson gson = new Gson();
        String json = gson.toJson(preparaTabuleiroParaJSONenconde());

        return json;
    }
    public static ArrayList<PecaJSON> preparaTabuleiroParaJSONenconde(){
        ArrayList<PecaJSON> pecas = new ArrayList<PecaJSON>();
        for(int i=1; i<=8; i++){
            for(int j=1; j<=8; j++){
                Peca temp = Tabuleiro.getPeca(i, j);
                if(temp != null){
                    pecas.add(new PecaJSON().importaPeca(temp));
                }
            }
        }
        return pecas;
    }
}
